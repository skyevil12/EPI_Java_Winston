package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class ListCyclicRightShift {
  @EpiTest(testDataFile = "list_cyclic_right_shift.tsv")

  public static ListNode<Integer> cyclicallyRightShiftList(ListNode<Integer> L,
                                                           int k) {
    //T O(N) S O(1)
    if(L == null) {
      return null;
    }

    int len = 0;
    ListNode cur = L;
    //Find length, T O(N)
    while(cur != null) {
      len++;
      cur = cur.next;
    }

    k %= len;
    if(k == 0) {
      return L;
    }

    //Transfer from right shift to counter clock shift
    k = len - k;
    int cnt = 1;
    ListNode<Integer> dummy = new ListNode(-1, L), nEd = null, ed = null;
    cur = dummy.next;
    //T O(N)
    while(cur != null) {
      if(cnt == k) {
        nEd = cur;
      }
      ed = cur;
      cur = cur.next;
      cnt++;
    }

    dummy.next = nEd.next;
    nEd.next = null;
    ed.next = L;

    return dummy.next;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ListCyclicRightShift.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
