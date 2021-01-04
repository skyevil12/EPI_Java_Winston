package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class DeleteKthLastFromList {
  @EpiTest(testDataFile = "delete_kth_last_from_list.tsv")

  // Assumes L has at least k nodes, deletes the k-th last node in L.
  public static ListNode<Integer> removeKthLast(ListNode<Integer> L, int k) {
    /*
      Edge:
      k should not be <=0 > or larger than L len
      k is 1
      L is null
      only one node L

      T O(N) S O(1)
     */
    /*
      [2, 1], 2
      slow  -1
      fast  null
      k     0
     */
    /*
    //Slow is the k + 1 node, fast is the tail node
    ListNode dummy = new ListNode(-1, L), prev = dummy, tailNext = dummy.next;
    //Suppose L is kth node, so update tailNext here
    while(k > 0) {
      tailNext = tailNext.next;
      k--;
    }

    while(tailNext != null) {
      prev = prev.next;
      tailNext = tailNext.next;
    }

    prev.next = prev.next.next;
    return dummy.next;
     */

    /*
    //Sentinel node
    ListNode dummy = new ListNode(-1, L), kPrev = dummy, tail = dummy;

    while(k > 0) {
      tail = tail.next;
      k--;
    }

    //Traverse to put tail
    while(tail != null && tail.next != null) {
      tail = tail.next;
      kPrev = kPrev.next;
    }

    //Remove node
    kPrev.next = kPrev.next.next;

    return dummy.next;
     */

    return epi.kt.DeleteKthLastFromList.INSTANCE.removeKthLast(L, k);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "DeleteKthLastFromList.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
