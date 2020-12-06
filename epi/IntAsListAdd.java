package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IntAsListAdd {
  @EpiTest(testDataFile = "int_as_list_add.tsv")

  public static ListNode<Integer> addTwoNumbers(ListNode<Integer> L1,
                                                ListNode<Integer> L2) {
    /*
      3, 1, 4
      7, 0, 9

      0, 2, 3, 1

      T O(L1 + L2) S O(Max(L1, L2))
     */
    ListNode<Integer> dummy = new ListNode<>(-1, null), cur = dummy, c1 = L1, c2 = L2;
    int sum = 0;
    boolean isAdd = false;

    while(c1 != null || c2 != null) {
      if(c1 != null) {
        sum += c1.data;
        c1 = c1.next;
      }

      if(c2 != null) {
        sum += c2.data;
        c2 = c2.next;
      }

      if(isAdd) {
        sum++;
      }

      isAdd = sum > 9;
      cur.next = new ListNode<>(sum % 10, null);
      cur = cur.next;
      sum = 0;
    }

    if(isAdd) {
      cur.next = new ListNode<>(1, null);
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IntAsListAdd.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
