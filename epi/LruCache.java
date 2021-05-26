package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;

import java.util.*;

public class LruCache {
  class Node {
    Node next, prev;
    int key, value;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }

    Node() {

    }
  }

  Node head, tail;
  int size;
  Map<Integer, Node> map;

  private void remove(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private void offerLast(Node node) {
    Node oLast = tail.prev;
    tail.prev = node;
    node.next = tail;
    oLast.next = node;
    node.prev = oLast;
  }

  private void pollFirst() {
    Node oFirst = head.next;
    head.next = oFirst.next;
    oFirst.next.prev = head;
    oFirst.prev = null;
    oFirst.next = null;
    map.remove(oFirst.key);
  }

  LruCache(final int capacity) {
    map = new HashMap<>();
    head = new Node();
    tail = new Node();
    head.next = tail;
    tail.prev = head;
    size = capacity;
  }

  public Integer lookup(Integer key) {
    if(!map.containsKey(key)) {
      return -1;
    }

    Node node = map.get(key);
    remove(node);
    offerLast(node);
    return node.value;
  }

  public void insert(Integer key, Integer value) {
    if(lookup(key) != -1) {
      return;
    }

    Node nNode = new Node(key, value);
    offerLast(nNode);
    map.put(key, nNode);
    if(map.size() > size) {
      pollFirst();
    }
    return;
  }
  public Boolean erase(Object key) {
    if(!map.containsKey(key)) {
      return false;
    }

    Node rmNode = map.get(key);
    remove(rmNode);
    map.remove(key);
    return true;
  }
  @EpiUserType(ctorParams = {String.class, int.class, int.class})
  public static class Op {
    String code;
    int arg1;
    int arg2;

    public Op(String code, int arg1, int arg2) {
      this.code = code;
      this.arg1 = arg1;
      this.arg2 = arg2;
    }
  }

  @EpiTest(testDataFile = "lru_cache.tsv")
  public static void lruCacheTester(List<Op> commands) throws TestFailure {
    if (commands.isEmpty() || !commands.get(0).code.equals("LruCache")) {
      throw new RuntimeException("Expected LruCache as first command");
    }
    LruCache cache = new LruCache(commands.get(0).arg1);
    for (Op op : commands.subList(1, commands.size())) {
      int result;
      switch (op.code) {
      case "lookup":
        result = cache.lookup(op.arg1);
        if (result != op.arg2) {
          throw new TestFailure("Lookup: expected " + String.valueOf(op.arg2) +
                                ", got " + String.valueOf(result));
        }
        break;
      case "insert":
        cache.insert(op.arg1, op.arg2);
        break;
      case "erase":
        result = cache.erase(op.arg1) ? 1 : 0;
        if (result != op.arg2) {
          throw new TestFailure("Erase: expected " + String.valueOf(op.arg2) +
                                ", got " + String.valueOf(result));
        }
        break;
      default:
        throw new RuntimeException("Unexpected command " + op.code);
      }
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LruCache.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
