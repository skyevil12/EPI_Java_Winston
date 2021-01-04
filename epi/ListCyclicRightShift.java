package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class ListCyclicRightShift {
  @EpiTest(testDataFile = "list_cyclic_right_shift.tsv")

  public static ListNode<Integer> cyclicallyRightShiftList(ListNode<Integer> L,
                                                         int k) {
    /*
      1 -> 2 -> 3
      cur 1 2 3
      len   1 2
     */
    /*
    if(L == null) {
      return null;
    }

    ListNode<Integer> dummy = new ListNode(-1, L), cur = L;
    int len = 1;
    while(cur.next != null) {
      cur = cur.next;
      len++;
    }
    k %= len;
    if(k == 0) {
      return L;
    }
    //Make circle
    cur.next = L;

    int nTailCnt = len - k;
    //Start from ori tail and seek len - k nodes to get new tail node
    while(nTailCnt > 0) {
      cur = cur.next;
      nTailCnt--;
    }
    //New Head
    dummy.next = cur.next;
    //Set tail next is null
    cur.next = null;

    return dummy.next;
     */
    /*
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
     */
    /*
      1 -> 2 -> 3
      k 1
      3 -> 1 -> 2
      0. Save head
      1. Get len
      2. k %= len
      3. shift len - k - 1
      4. cut next node to null and set new head
      5. Traverse the new head to tail and link old head
      6. return new head

      T O(N) S O(1)
     */
    /*
    if(L == null) {
      return null;
    }
    ListNode<Integer> dummy = new ListNode(-1, L), oH = L, cur = L;
    int len = 0;
    while(cur != null) {
      cur = cur.next;
      len++;
    }

    k %= len;
    if(k == 0) {
      return L;
    }
//    System.out.println("Len is " + len);
    int shift = len - k - 1;
    cur = L;
    while(shift > 0) {
      cur = cur.next;
      shift--;
    }

    dummy.next = cur.next;
    cur.next = null;
    cur = dummy.next;
    while(cur.next != null) {
      cur = cur.next;
    }
    cur.next = oH;

    return dummy.next;
     */
    return epi.kt.ListCyclicRightShift.INSTANCE.cyclicallyRightShiftList(L, k);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ListCyclicRightShift.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
