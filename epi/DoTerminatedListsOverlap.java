package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;
public class DoTerminatedListsOverlap {
  /*
    Edge case: null return null, len 1, cycle(but input has no circle in this case)
   */
  public static ListNode<Integer>
  overlappingNoCycleLists(ListNode<Integer> l0, ListNode<Integer> l1) {
    if(l0 == null || l1 == null) {
      return null;
    }

    int len0 = 0, len1= 0;

    ListNode<Integer> tL0 = l0, tL1 = l1;

    while(tL0 != null) {
      len0++;
      tL0 = tL0.next;
    }

    while(tL1 != null) {
      len1++;
      tL1 = tL1.next;
    }

    tL0 = l0;
    while(len0 - len1 > 0) {
      len0--;
      tL0 = tL0.next;
    }

    tL1 = l1;
    while(len1 - len0 > 0) {
      len1--;
      tL1 = tL1.next;
    }

    while(tL0 != null) {
      if(tL0 == tL1) {
        return tL0;
      }

      tL0 = tL0.next;
      tL1 = tL1.next;
    }

    return null;
  }
  @EpiTest(testDataFile = "do_terminated_lists_overlap.tsv")
  public static void
  overlappingNoCycleListsWrapper(TimedExecutor executor, ListNode<Integer> l0,
                                 ListNode<Integer> l1, ListNode<Integer> common)
      throws Exception {
    if (common != null) {
      if (l0 != null) {
        ListNode<Integer> i = l0;
        while (i.next != null) {
          i = i.next;
        }
        i.next = common;
      } else {
        l0 = common;
      }

      if (l1 != null) {
        ListNode<Integer> i = l1;
        while (i.next != null) {
          i = i.next;
        }
        i.next = common;
      } else {
        l1 = common;
      }
    }

    final ListNode<Integer> finalL0 = l0;
    final ListNode<Integer> finalL1 = l1;
    ListNode<Integer> result =
        executor.run(() -> overlappingNoCycleLists(finalL0, finalL1));

    if (result != common) {
      throw new TestFailure("Invalid result");
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "DoTerminatedListsOverlap.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
