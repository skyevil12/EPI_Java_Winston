package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;

import java.util.HashSet;
import java.util.Set;
public class DoListsOverlap {

  public static ListNode<Integer> overlappingLists(ListNode<Integer> l0,
                                                   ListNode<Integer> l1) {
    /*
      l0 and l1 both have cycle
        intersection
          before cycle
          in cycle
        not intersection

      only l0 or l1 has cycle
        not intersection

      Neither have cycle - use previous solution
     */
    //circle start of l0 and l1
    ListNode c0 = IsListCyclic.hasCycle(l0), c1 = IsListCyclic.hasCycle(l1);
    if(c0 == null && c1 == null) {
      return DoTerminatedListsOverlap.overlappingNoCycleLists(l0, l1);
    } else if(c0 == null || c1 == null) {
      return null;
    }

    ListNode tmp = c1;
    do {
      tmp = tmp.next;
    } while(tmp != c0 && tmp != c1);

    if(tmp != c0) {
      return null;
    }

    int d0 = getDisBeforeNode(l0, c0), d1 = getDisBeforeNode(l1, c1);
    int diff = d0 - d1;
    if(d0 > d1) {
      while(diff-- > 0) {
        l0 = l0.next;
      }
    } else if(d1 > d0){
      diff *= -1;
      while(diff-- > 0) {
        l1 = l1.next;
      }
    }

    while(l0 != l1 && l0 != c0 && l1 != c1) {
      l0 = l0.next;
      l1 = l1.next;
    }

    return l0 == l1 ? l1 : c0;
  }

//  public static ListNode<Integer> overlappingLists(ListNode<Integer> l0,
//                                                   ListNode<Integer> l1) {
//    /*
//      0. No circle -> pass to previous solution
//      1. Only one has circle(l0 or l1), return null
//      2. Both has circle
//         Circle overlapped,
//         find each circle meet pt and check if one in another
//         Then check if meet before circle start
//         Then Circle not overlap if no result
//      Suppose l0 len M l1 len N
//      T O(M + N) S O(1)
//     */
//    ListNode c0 = null, c1 = null;
//
//    ListNode slow = l0, fast = l0;
//
//    while(fast != null && fast.next != null) {
//      slow = slow.next;
//      fast = fast.next.next;
//      if(slow == fast) {
//        c0 = slow;
//        break;
//      }
//    }
//
//    slow = l1;
//    fast = l1;
//    while(fast != null && fast.next != null) {
//      slow = slow.next;
//      fast = fast.next.next;
//      if(slow == fast) {
//        c1 = slow;
//        break;
//      }
//    }
//
//    if(c0 != null && c1 != null) {
//      ListNode tmpCur = l0;
//      while(tmpCur != c0) {
//        tmpCur = tmpCur.next;
//        c0 = c0.next;
//      }
//
//      tmpCur = l1;
//      while(tmpCur != c1) {
//        tmpCur = tmpCur.next;
//        c1 = c1.next;
//      }
//
//      slow = c1;
//      fast = c1;
//      while(true) {
//        if(slow == c0) {
//          return c0;
//        }
//
//        slow = slow.next;
//        fast = fast.next.next;
//        if(slow == fast) {
//          break;
//        }
//      }
//
//      c0.next = null;
//      c1.next = null;
//    } else if(c0 != null || c1 != null) {
//      return null;
//    }
//
//    return DoTerminatedListsOverlap.overlappingNoCycleLists(l0, l1);
//  }

  private static int getDisBeforeNode(ListNode<Integer> st, ListNode<Integer> exNode) {
    ListNode<Integer> tmp = st;
    int dis = 0;
    while(tmp != exNode) {
      dis++;
      tmp = tmp.next;
    }
    return dis;
  }
  @EpiTest(testDataFile = "do_lists_overlap.tsv")
  public static void
  overlappingListsWrapper(TimedExecutor executor, ListNode<Integer> l0,
                          ListNode<Integer> l1, ListNode<Integer> common,
                          int cycle0, int cycle1) throws Exception {
    if (common != null) {
      if (l0 == null) {
        l0 = common;
      } else {
        ListNode<Integer> it = l0;
        while (it.next != null) {
          it = it.next;
        }
        it.next = common;
      }

      if (l1 == null) {
        l1 = common;
      } else {
        ListNode<Integer> it = l1;
        while (it.next != null) {
          it = it.next;
        }
        it.next = common;
      }
    }

    if (cycle0 != -1 && l0 != null) {
      ListNode<Integer> last = l0;
      while (last.next != null) {
        last = last.next;
      }
      ListNode<Integer> it = l0;
      while (cycle0-- > 0) {
        if (it == null) {
          throw new RuntimeException("Invalid input data");
        }
        it = it.next;
      }
      last.next = it;
    }

    if (cycle1 != -1 && l1 != null) {
      ListNode<Integer> last = l1;
      while (last.next != null) {
        last = last.next;
      }
      ListNode<Integer> it = l1;
      while (cycle1-- > 0) {
        if (it == null) {
          throw new RuntimeException("Invalid input data");
        }
        it = it.next;
      }
      last.next = it;
    }

    Set<Integer> commonNodes = new HashSet<>();
    ListNode<Integer> it = common;
    while (it != null && !commonNodes.contains(it.data)) {
      commonNodes.add(it.data);
      it = it.next;
    }

    final ListNode<Integer> finalL0 = l0;
    final ListNode<Integer> finalL1 = l1;
    ListNode<Integer> result =
        executor.run(() -> overlappingLists(finalL0, finalL1));

    if (!((commonNodes.isEmpty() && result == null) ||
          (result != null && commonNodes.contains(result.data)))) {
      throw new TestFailure("Invalid result");
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "DoListsOverlap.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
