package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class SortedListsMerge {
  @EpiTest(testDataFile = "sorted_lists_merge.tsv")
  //@include
  public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> L1,
                                                      ListNode<Integer> L2) {
    ListNode<Integer> dummy = new ListNode<>(-1, null), cur = dummy;
    //T O(L1 + L2) S O(1)
    while(L1 != null && L2 != null) {
      if(L1.data < L2.data) {
        cur.next = L1;
        L1 = L1.next;
      } else {
        cur.next = L2;
        L2 = L2.next;
      }
      cur = cur.next;
    }

    if(L1 != null) {
      cur.next = L1;
    }

    if(L2 != null) {
      cur.next = L2;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SortedListsMerge.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
