package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;

import java.util.*;
import java.util.function.BiPredicate;
public class PhoneNumberMnemonic {
  private static char[][] map = {{'0'}, {'1'}
          , {'A', 'B', 'C'}, {'D', 'E', 'F'}
          , {'G', 'H', 'I'}, {'J', 'K', 'L'}
          , {'M', 'N', 'O'}, {'P', 'Q', 'R', 'S'}
          , {'T', 'U', 'V'}, {'W', 'X', 'Y', 'Z'}};
  @EpiTest(testDataFile = "phone_number_mnemonic.tsv")

  public static List<String> phoneMnemonic(String phoneNumber) {
    /*List<String> rtList = new ArrayList<>();
    char[] pNumArray = phoneNumber.toCharArray();

    core(pNumArray, 0, rtList);

    return rtList;*/

//    //Iterative
//    List<String> rtList = new ArrayList<>();
//    rtList.add("");
//
//    StringBuilder tmpSb = new StringBuilder();
//    //T O(4^N * N) S O(4^N)
//    for(char nCh : phoneNumber.toCharArray()) {
//      int n = nCh - '0';
//      List<String> tmp = new ArrayList<>();
//      for(char ch : map[n]) {
//        for(String str : rtList) {
//          tmpSb.append(str).append(ch);
//          tmp.add(tmpSb.toString());
//          tmpSb.setLength(0);
//        }
//      }
//      rtList = new ArrayList<>(tmp);
//    }
//
//    return rtList;

    return epi.kt.PhoneNumberMnemonic.INSTANCE.phoneMnemonic(phoneNumber);
  }

  /*
    "2276696"
    c         0
    rtList

    T O(4^N * N) S O(4^N + N)
 */
  private static void core(char[] rts, int c, List<String> rtList) {
    if(c == rts.length) {
      rtList.add(new String(rts));
      return;
    }

    char ori = rts[c];
    int key = (ori - '0');
    for(char val : map[key]) {
      rts[c] = val;
      core(rts, c + 1, rtList);
    }
    rts[c] = ori;
  }

  @EpiTestComparator
  public static boolean comp(List<String> expected, List<String> result) {
    if (result == null) {
      return false;
    }
    Collections.sort(expected);
    Collections.sort(result);
    return expected.equals(result);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "PhoneNumberMnemonic.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
