package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LruCache {
  /*
  private Queue<Integer> queue = new ArrayDeque<>();
  private Map<Integer, Integer> map = new HashMap<>();
  private int size;

  LruCache(final int capacity) {
    size = capacity;
  }
  //Return -1 when not found
  public Integer lookup(Integer key) {
    if(!map.containsKey(key)) {
      return -1;
    }

    Queue<Integer> nQ = new ArrayDeque<>();
    while(!queue.isEmpty()) {
      int cur = queue.poll();
      if(cur != key) {
        nQ.offer(cur);
      }
    }
    nQ.offer(key);
    queue = nQ;
    return map.get(key);
  }
  //Do not do anything if key exists
  public void insert(Integer key, Integer value) {
    if(lookup(key) != -1) {
      return;
    }
    queue.offer(key);
    map.put(key, value);
    if(queue.size() > size) {
      erase(queue.poll());
    }
  }
  public Boolean erase(Object key) {
    if(!(key instanceof Integer)) {
      return false;
    }

    if(map.containsKey(key)) {
      Queue<Integer> nQ = new ArrayDeque<>();
      while(!queue.isEmpty()) {
        int cur = queue.poll();
        if(cur != (Integer)key) {
          nQ.offer(cur);
        }
      }

      queue = nQ;
      map.remove(key);
      return true;
    }
    return false;
  }
   */
  private Map<Integer, Integer> map;
  LruCache(final int capacity) {
    map = new LinkedHashMap(capacity, 1.0f, true) {
      @Override
      protected boolean removeEldestEntry(Map.Entry eldest) {
        return this.size() > capacity;
      }
    };
  }
  //Must return -1 if not exist
  public Integer lookup(Integer key) {
    if(!map.containsKey(key)) {
      return -1;
    }
    return map.get(key);
  }
  //Must remove over capacity unit
  public void insert(Integer key, Integer value) {
    if(lookup(key) != -1) {
      return;
    }
    map.put(key, value);
  }
  public Boolean erase(Object key) {
    if(map.containsKey(key)) {
      map.remove(key);
      return true;
    }
    return false;
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
