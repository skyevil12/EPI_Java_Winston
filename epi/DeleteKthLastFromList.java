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
    //Slow is the k + 1 node, fast is the tail node
    ListNode dummy = new ListNode(-1, L), slow = dummy, fast = dummy.next;
    /*
      [2, 1], 2
      slow  -1
      fast  null
      k     0
     */
    while(k > 0) {
      fast = fast.next;
      k--;
    }

    while(fast != null) {
      slow = slow.next;
      fast = fast.next;
    }

    slow.next = slow.next.next;
    return dummy.next;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "DeleteKthLastFromList.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
