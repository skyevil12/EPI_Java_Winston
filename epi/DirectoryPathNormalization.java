package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.*;

public class DirectoryPathNormalization {
  private static final String DOC_SEPARATOR = "/";
  private static final String DOC_PARENT = "..";
  private static final String DOC_CUR = ".";
  @EpiTest(testDataFile = "directory_path_normalization.tsv")

  public static String shortestEquivalentPath(String path) {
    StringBuilder rtSb = new StringBuilder();
    if(path.startsWith(DOC_SEPARATOR)) {
      rtSb.append(DOC_SEPARATOR);
    }

    Deque<String> dq = new ArrayDeque<>();
    String[] dirs = path.split(DOC_SEPARATOR);
    for(String dir : dirs) {
      if(dir.isEmpty() || dir.equals(DOC_CUR)) {
        continue;
      }

      if(dir.equals(DOC_PARENT)) {
        if(dq.isEmpty() || dq.peekFirst().equals(DOC_PARENT)) {
          dq.offerFirst(dir);
        } else {
          dq.pollFirst();
        }
      } else {
        dq.offerFirst(dir);
      }
    }

    while(!dq.isEmpty()) {
      rtSb.append(dq.pollLast());
      if(!dq.isEmpty()) {
        rtSb.append(DOC_SEPARATOR);
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
