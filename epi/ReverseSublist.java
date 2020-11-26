package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class ReverseSublist {
  @EpiTest(testDataFile = "reverse_sublist.tsv")

  public static ListNode<Integer> reverseSublist(ListNode<Integer> L, int start,
                                                 int finish) {
    //Edge case if L is null or start, finish not in range 1..len(L) - 1
    //T O(N) S O(1)
    if(L == null || start >= finish || start <= 0 || finish <= 0) {
      return L;
    }

    ListNode<Integer> dummy = new ListNode<>(-1, L), cur = dummy, prevHead = null, tail = null;
    int cnt = 0;

    while(cur != null) {
      if(cnt == start - 1) {
        prevHead = cur;
      } else if(cnt == finish) {
        tail = cur;
        break;
      }

      cnt++;
      cur = cur.next;
    }

    ListNode<Integer> head = prevHead.next, tailNext = tail.next;
    tail.next = null;
    //Connect new reversedHead
    prevHead.next = reverse(head);
    //Connect new reversed Tail next to original successor
    head.next = tailNext;

    return dummy.next;
  }

  private static ListNode<Integer> reverse(ListNode<Integer> head) {
    ListNode<Integer> prev = null, cur = head, next = null;

    while(cur != null) {
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
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
