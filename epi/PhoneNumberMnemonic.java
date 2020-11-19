package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;

import java.util.*;
import java.util.function.BiPredicate;
public class PhoneNumberMnemonic {
  @EpiTest(testDataFile = "phone_number_mnemonic.tsv")

  //T O(4^N * N), suppose the input only contains numerical digit
  public static List<String> phoneMnemonic(String phoneNumber) {
    List<String> rtList = new ArrayList<>();
    char[][] mapping = {{'0'}, {'1'}, {'A', 'B', 'C'},
                        {'D', 'E', 'F'}, {'G', 'H', 'I'},
                        {'J', 'K', 'L'}, {'M', 'N', 'O'},
                        {'P', 'Q', 'R', 'S'}, {'T', 'U', 'V'},
                        {'W', 'X', 'Y', 'Z'}};

    core(phoneNumber, 0, new char[phoneNumber.length()], rtList, mapping);

    return rtList;
  }

  private static void core(String phoneNumber, int idx, char[] cur, List<String> rtList, char[][] mapping) {
    if(idx == phoneNumber.length()) {
      rtList.add(new String(cur));
      return;
    }

    char ch = phoneNumber.charAt(idx);
    for(char mCh : mapping[ch - '0']) {
      cur[idx] = mCh;
      core(phoneNumber, idx + 1, cur, rtList, mapping);
    }
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
