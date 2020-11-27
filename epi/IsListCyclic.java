package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;
public class IsListCyclic {
  /*
    Edge case is null or single point
    T O(N) s O(1)
   */
  public static ListNode<Integer> hasCycle(ListNode<Integer> head) {
    if(head == null) {
      return null;
    }

    //No cycle return null, or return the start of the cycle
    ListNode<Integer> slow = head, fast = head, conflict = null;
    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast) {
        conflict = slow;
        break;
      }
    }

    if(conflict == null) {
      return null;
    }

    while(true) {
      if(head == conflict) {
        return head;
      }

      head = head.next;
      conflict = conflict.next;
    }
  }
  @EpiTest(testDataFile = "is_list_cyclic.tsv")
  public static void HasCycleWrapper(TimedExecutor executor,
                                     ListNode<Integer> head, int cycleIdx)
      throws Exception {
    int cycleLength = 0;
    if (cycleIdx != -1) {
      if (head == null) {
        throw new RuntimeException("Can't cycle empty list");
      }
      ListNode<Integer> cycleStart = null, cursor = head;
      while (cursor.next != null) {
        if (cursor.data == cycleIdx) {
          cycleStart = cursor;
        }
        cursor = cursor.next;
        if (cycleStart != null) {
          cycleLength++;
        }
      }
      if (cursor.data == cycleIdx) {
        cycleStart = cursor;
      }
      if (cycleStart == null) {
        throw new RuntimeException("Can't find a cycle start");
      }
      cursor.next = cycleStart;
      cycleLength++;
    }

    ListNode<Integer> result = executor.run(() -> hasCycle(head));

    if (cycleIdx == -1) {
      if (result != null) {
        throw new TestFailure("Found a non-existing cycle");
      }
    } else {
      if (result == null) {
        throw new TestFailure("Existing cycle was not found");
      }

      ListNode<Integer> cursor = result;
      do {
        cursor = cursor.next;
        cycleLength--;
        if (cursor == null || cycleLength < 0) {
          throw new TestFailure(
              "Returned node does not belong to the cycle or is not the closest node to the head");
        }
      } while (cursor != result);

      if (cycleLength != 0) {
        throw new TestFailure(
            "Returned node does not belong to the cycle or is not the closest node to the head");
      }
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsListCyclic.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
