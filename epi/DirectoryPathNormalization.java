package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

public class DirectoryPathNormalization {
  private static String forward_slash_str = "/";
  private static String cur_dir_str = ".";
  private static String parent_dir_str = "..";
  @EpiTest(testDataFile = "directory_path_normalization.tsv")

  public static String shortestEquivalentPath(String path) {
    /*
      Edge
      Start from FW slash
      ".." before ".."
      Empty before ".."

      T O(N) S O(N)
     */
    if(path == null || path.isEmpty()) {
      return path;
    }

    Deque<String> deque = new ArrayDeque<>();
    if(path.charAt(0) == forward_slash_str.charAt(0)) {
      deque.offer(forward_slash_str);
    }

    String[] dirs = path.split(forward_slash_str);
    for(String dir : dirs) {
      if(dir.isEmpty() || dir.equals(cur_dir_str)) {
        continue;
      }

      if(dir.equals(parent_dir_str)) {
        if(!deque.isEmpty() && deque.peekLast().equals(forward_slash_str)) {
          throw new RuntimeException("Cannot go upper!");
        }

        if(deque.isEmpty() || (!deque.isEmpty() && deque.peekLast().equals(parent_dir_str))) {
          deque.offer(dir);
        } else {
          deque.pollLast();
        }
      } else {
        deque.offer(dir);
      }
    }

    StringBuilder rtSb = new StringBuilder();
    if(!deque.isEmpty() && deque.peek().equals(forward_slash_str)) {
      rtSb.append(deque.poll());
    }

    while(!deque.isEmpty()) {
      rtSb.append(deque.poll());
      if(!deque.isEmpty()) {
        rtSb.append(forward_slash_str);
      }
    }

    return rtSb.toString();
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "DirectoryPathNormalization.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
