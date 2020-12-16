package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class CircularQueue {

  public static class Queue {
    private static int SCALE_FACTOR = 2;
    int[] nums;
    int head, tail, cnt;

    public Queue(int capacity) {
      nums = new int[capacity];
    }

    private void rotate(int[] rt, int dis) {
      if(dis == 0) {
        return;
      }
      int len = rt.length;
      dis += len;
      dis %= len;

      //dis here is the dis that cnt of tail elements
      reverse(rt, 0, len - dis - 1);
      reverse(rt, len - 1 - dis + 1, len - 1);
      reverse(rt, 0, len - 1);
    }

    private void reverse(int[] rt, int st, int ed) {
      while(st < ed) {
        int tmp = rt[st];
        rt[st] = rt[ed];
        rt[ed] = tmp;
        st++;
        ed--;
      }
    }

    //Amortized T O(1)
    public void enqueue(Integer x) {
      if(cnt == nums.length) {
        rotate(nums, -head);
        //Note that we must use Integer obj when using Arrays.asList
//        Collections.rotate(Arrays.asList(nums), -head);
        head = 0;
        tail = cnt;
//        int[] tmp = new int[cnt * SCALE_FACTOR];
//        for(int i = 0; i < nums.length; i++) {
//          tmp[i] = nums[i];
//        }
        nums = Arrays.copyOf(nums, cnt * SCALE_FACTOR);//tmp;//
      }

      nums[tail++] = x;
      tail %= nums.length;
      cnt++;
      return;
    }
    //T O(1)
    public Integer dequeue() {
      if(cnt == 0) {
        throw new RuntimeException("Empty queue!!");
      }

      int rt = nums[head++];
      head %= nums.length;
      cnt--;
      return rt;
    }
    public int size() {
      return cnt;
    }
    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < nums.length; i++) {
        sb.append(nums[i]);
        if(i != nums.length - 1) {
          sb.append(',');
        }
      }
      return sb.toString();
    }
  }
  @EpiUserType(ctorParams = {String.class, int.class})
  public static class QueueOp {
    public String op;
    public int arg;

    public QueueOp(String op, int arg) {
      this.op = op;
      this.arg = arg;
    }

    @Override
    public String toString() {
      return op;
    }
  }

  @EpiTest(testDataFile = "circular_queue.tsv")
  public static void queueTester(List<QueueOp> ops) throws TestFailure {
    Queue q = new Queue(1);
    int opIdx = 0;
    for (QueueOp op : ops) {
      switch (op.op) {
      case "Queue":
        q = new Queue(op.arg);
        break;
      case "enqueue":
        q.enqueue(op.arg);
        break;
      case "dequeue":
        int result = q.dequeue();
        if (result != op.arg) {
          throw new TestFailure()
              .withProperty(TestFailure.PropertyName.STATE, q)
              .withProperty(TestFailure.PropertyName.COMMAND, op)
              .withMismatchInfo(opIdx, op.arg, result);
        }
        break;
      case "size":
        int s = q.size();
        if (s != op.arg) {
          throw new TestFailure()
              .withProperty(TestFailure.PropertyName.STATE, q)
              .withProperty(TestFailure.PropertyName.COMMAND, op)
              .withMismatchInfo(opIdx, op.arg, s);
        }
        break;
      }
      opIdx++;
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "CircularQueue.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
