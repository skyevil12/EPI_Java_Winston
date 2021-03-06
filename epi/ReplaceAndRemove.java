package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;

import java.util.ArrayList;
import java.util.List;
public class ReplaceAndRemove {

  public static int replaceAndRemove(int size, char[] s) {
    /*List<Character> list = new ArrayList<>();

    for(int i = 0; i < size; i++) {
      char cur = s[i];
      if(cur == 'a') {
        list.add('d');
        list.add('d');
      } else if(cur == 'b' || cur == 0) {
        continue;
      } else {
        list.add(cur);
      }
    }

    for(int i = 0; i < list.size(); i++) {
      s[i] = list.get(i);
    }

    return list.size();*/
    //T O(N) S O(1)
    //Two pointer to remove 'b' and count rt size
    /*int wIdx = 0, rt = size;
    for(int i = 0; i < size; i++) {
      char ch = s[i];
      if(ch != 'b') {
        if(ch == 'a') {
          rt++;
        }
        s[wIdx++] = ch;
      } else {
        rt--;
      }
    }

    int j = rt - 1;
    //Set replacement of 'a' from backward
    for(int i = wIdx - 1; i >= 0; i--) {
      char ch = s[i];
      if(ch == 'a') {
        s[j--] = 'd';
        s[j--] = 'd';
      } else {
        s[j--] = ch;
      }
    }

    return rt;*/
    return epi.kt.ReplaceAndRemove.INSTANCE.replaceAndRemove(size, s);
  }
  @EpiTest(testDataFile = "replace_and_remove.tsv")
  public static List<String>
  replaceAndRemoveWrapper(TimedExecutor executor, Integer size, List<String> s)
      throws Exception {
    char[] sCopy = new char[s.size()];
    for (int i = 0; i < size; ++i) {
      if (!s.get(i).isEmpty()) {
        sCopy[i] = s.get(i).charAt(0);
      }
    }

    Integer resSize = executor.run(() -> replaceAndRemove(size, sCopy));

    List<String> result = new ArrayList<>();
    for (int i = 0; i < resSize; ++i) {
      result.add(Character.toString(sCopy[i]));
    }
    return result;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "ReplaceAndRemove.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
