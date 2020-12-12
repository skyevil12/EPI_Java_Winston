
package epi;

import java.util.List;

public class PostingListNode {
  public int order;
  public PostingListNode next, jump;

  public PostingListNode(int order, PostingListNode next,
                         PostingListNode jump) {
    this.order = order;
    this.next = next;
    this.jump = jump;
  }

  @Override
  public String toString() {
    return String.format("(%d)%s%s", order, next != null ? "->" : "",
                         next != null ? next.toString() : "");
  }

//  public static List<Integer> iterativeAssignJumpFirstOrder(PostingListNode postingListNode) {
//
//  }
//
//  public static List<Integer> recursiveAssignJumpFirstOrder(PostingListNode postingListNode) {
//
//  }

  public static void main(String... args) {

  }
}
