package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class RemoveDuplicatesFromSortedList {
  @EpiTest(testDataFile = "remove_duplicates_from_sorted_list.tsv")

  public static ListNode<Integer> removeDuplicates(ListNode<Integer> L) {
    /*
      Edge cases null input
      Len 1 input
      Len 2 input(Same data)

      Suppose L is len N then T O(N) S O(1)
     */
    /*ListNode cur = L;

    while(cur != null) {
      ListNode next = cur.next;
      while(next != null && next.data == cur.data) {
        next = next.next;
      }
      cur.next = next;
      cur = cur.next;
    }
    return L;*/
    /*
      2 -> 2 -> 2 -> 2
      T O(N) S O(1)
     */
    /*
    ListNode<Integer> cur = L;
    while(cur != null) {
      ListNode<Integer> next = cur.next;
      while (next != null && cur.data == next.data) {
        next = next.next;
      }
      cur.next = next;
      cur = cur.next;
    }
    return L;
     */
    return epi.kt.RemoveDuplicatesFromSortedList.INSTANCE.removeDuplicates(L);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "RemoveDuplicatesFromSortedList.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
