package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;
public class EvenOddListMerge {
  @EpiTest(testDataFile = "even_odd_list_merge.tsv")

  public static ListNode<Integer> evenOddMerge(ListNode<Integer> L) {
    /*
      Edge case: null return null
      Even first then odd
      //T O(N) S O(1)
     */
    if(L == null) {
      return null;
    }
    /*
            0, 1, 2, 3, 4
      even  0->2->4
      odd   1->3->null
     */
    ListNode even = L, odd = L.next, oriOdd = odd;

    while(true) {
      if(odd == null || odd.next == null) {
        even.next = oriOdd;
        break;
      }
      even.next = odd.next;
      even = even.next;
      odd.next = even.next;
      odd = odd.next;
    }

    return L;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "EvenOddListMerge.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
