package epi;
import epi.kt.ReverseSublistV1;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class ReverseSublist {
  @EpiTest(testDataFile = "reverse_sublist.tsv")

  public static ListNode<Integer> reverseSublist(ListNode<Integer> L, int start,
                                                 int finish) {
//    if(start == finish) {
//      return L;
//    }
//
//    ListNode<Integer> dummy = new ListNode<>(-1, L), pre = dummy;
//    int i = 1;
//    while(i++ < start) {
//      pre = pre.next;
//    }
//
//    ListNode<Integer> iter = pre.next;
//    while(start++ < finish) {
//      ListNode<Integer> tmp = iter.next;
//      iter.next = tmp.next;
//      tmp.next = pre.next;
//      pre.next = tmp;
//    }
//
//    return dummy.next;
    return ReverseSublistV1.INSTANCE.reverseSublist(L, start, finish);
  }

  //Recursive reverse function?
  /*
    1 -> 2
   */
  private static ListNode<Integer> reverse(ListNode<Integer> head) {
    ListNode<Integer> prev = null, cur = head;
    while(cur != null) {
      ListNode<Integer> tmp = cur.next;
      cur.next = prev;
      prev = cur;
      cur = tmp;
    }

    return prev;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReverseSublist.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
