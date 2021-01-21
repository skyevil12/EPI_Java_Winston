package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class PivotList {

  public static ListNode<Integer> listPivoting(ListNode<Integer> l, int x) {
//    ListNode<Integer> smallerHead = new ListNode(-1, null), smallerIter = smallerHead;
//    ListNode<Integer> equalHead = new ListNode(-1, null), equalIter = equalHead;
//    ListNode<Integer> largeHead = new ListNode(-1, null), largeIter = largeHead;
//    ListNode<Integer> iter = l;
//
//    while(iter != null) {
//      if(iter.data < x) {
//        smallerIter.next = iter;
//        smallerIter = iter;
//      } else if(iter.data == x) {
//        equalIter.next = iter;
//        equalIter = iter;
//      } else if(iter.data > x) {
//        largeIter.next = iter;
//        largeIter = iter;
//      }
//      iter = iter.next;
//    }
//
//    largeIter.next = null;
//    equalIter.next = largeHead.next;
//    smallerIter.next = equalHead.next;
//
//    return smallerHead.next;
    //T O(N) S O(1)
//    ListNode<Integer> sL = new ListNode<>(0, null), eL = new ListNode<>(0, null), lL = new ListNode<>(0, null), cur = l;
//    ListNode<Integer> dS = sL, dE = eL, dL = lL;
//
//    while(cur != null) {
//      if(cur.data < x) {
//        sL.next = cur;
//        sL = sL.next;
//      } else if(cur.data == x) {
//        eL.next = cur;
//        eL = eL.next;
//      } else if(cur.data > x) {
//        lL.next = cur;
//        lL = lL.next;
//      }
//      cur = cur.next;
//    }
//
//    lL.next = null;
//    eL.next = dL.next;
//    sL.next = dE.next;
//    return dS.next;
    return epi.kt.PivotList.INSTANCE.listPivoting(l, x);
  }
  public static List<Integer> linkedToList(ListNode<Integer> l) {
    List<Integer> v = new ArrayList<>();
    while (l != null) {
      v.add(l.data);
      l = l.next;
    }
    return v;
  }

  @EpiTest(testDataFile = "pivot_list.tsv")
  public static void listPivotingWrapper(TimedExecutor executor,
                                         ListNode<Integer> l, int x)
      throws Exception {
    List<Integer> original = linkedToList(l);

    final ListNode<Integer> finalL = l;
    l = executor.run(() -> listPivoting(finalL, x));

    List<Integer> pivoted = linkedToList(l);

    int mode = -1;
    for (Integer i : pivoted) {
      switch (mode) {
      case -1:
        if (i == x) {
          mode = 0;
        } else if (i > x) {
          mode = 1;
        }
        break;
      case 0:
        if (i < x) {
          throw new TestFailure("List is not pivoted");
        } else if (i > x) {
          mode = 1;
        }
        break;
      case 1:
        if (i <= x) {
          throw new TestFailure("List is not pivoted");
        }
      }
    }

    Collections.sort(original);
    Collections.sort(pivoted);
    if (!original.equals(pivoted))
      throw new TestFailure("Result list contains different values");
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PivotList.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
