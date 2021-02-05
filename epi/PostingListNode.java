
package epi;

import java.util.Deque;
import java.util.LinkedList;

public class PostingListNode {
  public int order;
  public PostingListNode next, jump;

  public PostingListNode(int order, PostingListNode next,
                         PostingListNode jump) {
    this.order = order;
    this.next = next;
    this.jump = jump;
  }

  public PostingListNode() {
    this.order = -1;
  }

  @Override
  public String toString() {
    return String.format("(%d)%s%s", order, next != null ? "->" : "",
                         next != null ? next.toString() : "");
  }

  public static void iterativeAssignJumpFirstOrder(PostingListNode postingListNode) {
    int order = 0;
    Deque<PostingListNode> stack = new LinkedList<>();
    stack.push(postingListNode);
    while(!stack.isEmpty()) {
      PostingListNode cur = stack.pop();
      if(cur != null && cur.order == -1) {
        cur.order = order++;
        stack.push(cur.next);
        stack.push(cur.jump);
      }
    }
  }

  public static int recursiveAssignJumpFirstOrder(PostingListNode postingListNode, int order) {
    if(postingListNode != null && postingListNode.order == -1) {
      postingListNode.order = order++;
      order = recursiveAssignJumpFirstOrder(postingListNode.jump, order);
      order = recursiveAssignJumpFirstOrder(postingListNode.next, order);
    }
    return order;
  }

  public static void main(String... args) {
    PostingListNode a = new PostingListNode(), b = new PostingListNode()
            , c= new PostingListNode(), d = new PostingListNode();

    a.jump = c;
    a.next = b;
    b.jump = d;
    b.next = c;
    c.jump = b;
    c.next = d;
    d.jump = d;

//    recursiveAssignJumpFirstOrder(a, 0);
    iterativeAssignJumpFirstOrder(a);
    assert a.order == 0;
    assert b.order == 2;
    assert c.order == 1;
    assert d.order == 3;
  }
}
