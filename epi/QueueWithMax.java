package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;

import java.util.*;

public class QueueWithMax {
    /*
    T O(N) S O(N)
    Remove dummy front element that is smaller than cur
    54321
     */
//    Deque<Integer> maxQ = new ArrayDeque<>();
//    Queue<Integer> q = new ArrayDeque<>();
//
//    public void enqueue(Integer x) {
//      q.offer(x);
//      T O(N)
//      while(!maxQ.isEmpty() && maxQ.peekLast() < x) {
//        maxQ.pollLast();
//      }
//      maxQ.offerLast(x);
//    }
//
//    public Integer dequeue() {
//      int rt = q.poll();
//      if(rt == maxQ.peekFirst()) {
//        maxQ.pollFirst();
//      }
//      return rt;
//    }
//
//    public Integer max() {
//      return maxQ.peekFirst();
//    }

    /*Two maxStack solution make queue solution
        T O(1), amortize in dequeue S O(1)
     */
    StackWithMax.Stack enStack = new StackWithMax.Stack();
    StackWithMax.Stack dqStack = new StackWithMax.Stack();
    public void enqueue(Integer x) {
      //enqueue stack work normally
      enStack.push(x);
    }

    public Integer dequeue() {
      //only fill dq stack when it is empty
      if(dqStack.empty()) {
        while(!enStack.empty()) {
          dqStack.push(enStack.pop());
        }
      }
      return dqStack.pop();
    }

    public Integer max() {
        if(!enStack.empty()) {
            return dqStack.empty() ? enStack.max() : Math.max(enStack.max(), dqStack.max());
        } else if(!dqStack.empty()){
            return dqStack.max();
        }

        throw new RuntimeException("empty!!");
    }

    @EpiUserType(ctorParams = {String.class, int.class})
    public static class QueueOp {
        public String op;
        public int arg;

        public QueueOp(String op, int arg) {
            this.op = op;
            this.arg = arg;
        }
    }

    @EpiTest(testDataFile = "queue_with_max.tsv")
    public static void queueTester(List<QueueOp> ops) throws TestFailure {
        try {
            QueueWithMax q = new QueueWithMax();

            for (QueueOp op : ops) {
                switch (op.op) {
                    case "QueueWithMax":
                        q = new QueueWithMax();
                        break;
                    case "enqueue":
                        q.enqueue(op.arg);
                        break;
                    case "dequeue":
                        int result = q.dequeue();
                        if (result != op.arg) {
                            throw new TestFailure("Dequeue: expected " +
                                    String.valueOf(op.arg) + ", got " +
                                    String.valueOf(result));
                        }
                        break;
                    case "max":
                        int s = q.max();
                        if (s != op.arg) {
                            throw new TestFailure("Max: expected " + String.valueOf(op.arg) +
                                    ", got " + String.valueOf(s));
                        }
                        break;
                }
            }
        } catch (NoSuchElementException e) {
            throw new TestFailure("Unexpected NoSuchElement exception");
        }
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "QueueWithMax.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
