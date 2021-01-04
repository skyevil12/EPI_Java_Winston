package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;
public class DoTerminatedListsOverlap {
  /*
    Edge case: null return null, len 1, cycle(but input has no circle in this case)
    T O(L0 + L1 + min(L0, L1)) S O(1)
   */
  public static ListNode<Integer>
  overlappingNoCycleLists(ListNode<Integer> l0, ListNode<Integer> l1) {
    if(l0 == null || l1 == null) {
      return null;
    }

    int len0 = 1, len1 = 1;
    ListNode<Integer> c0 = l0, c1 = l1;
    while(c0 != null) {
      c0 = c0.next;
      len0++;
    }

    while(c1 != null) {
      c1 = c1.next;
      len1++;
    }

    while(len0 > len1) {
      l0 = l0.next;
      len0--;
    }

    while(len0 < len1) {
      l1 = l1.next;
      len1--;
    }

    while(l0 != null) {
      if(l0 == l1) {
        return l0;
      }
      l0 = l0.next;
      l1 = l1.next;
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
