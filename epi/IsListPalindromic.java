package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IsListPalindromic {
  @EpiTest(testDataFile = "is_list_palindromic.tsv")

  public static boolean isLinkedListAPalindrome(ListNode<Integer> L) {
    /*
      Edge case would be null or odd or even len

      Use two pointer to find center point, then reverse the first part

      Compare the reversed first part with the following one, return true if no val difference

      T O(N) S O(1)
     */
    if(L == null) {
      return true;
    }

    ListNode slow = L, fast = L;
    /*
     1, 2, 3
     1, 2, 3, 4
     1, 2, 3, 4, 5
     */
    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode<Integer> first = L, second = reverse(slow);
    while(first != null && second != null) {
      if(first.data.intValue() != second.data.intValue()) {
        return false;
      }

      first = first.next;
      second = second.next;
    }

    return true;
  }

  private static ListNode reverse(ListNode node) {
    ListNode cur = node, prev = null;

    while(cur != null) {
      ListNode tmp = cur.next;
      cur.next = prev;
      prev = cur;
      cur = tmp;
    }

    return prev;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsListPalindromic.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
