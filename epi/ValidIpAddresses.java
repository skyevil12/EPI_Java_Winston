package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
public class ValidIpAddresses {
  private static final Character TOKEN = '.';
  @EpiTest(testDataFile = "valid_ip_addresses.tsv")

  /*
    19216811, IPV4
    //T O(1) 2^32 at most, S O(1) 2^32 at most
   */
  public static List<String> getValidIpAddress(String s) {
    List<String> rtList = new ArrayList<>();

    for(int i = 1; i < 4 && i < s.length(); i++) {
      String first = s.substring(0, i);
      if(!isValid(first)) {
        continue;
      }
      for(int j = 1; j < 4 && i + j < s.length(); j++) {
        String second = s.substring(i, i + j);
        if(!isValid(second)) {
          continue;
        }

        for(int k = 1; k < 4 && i + j + k < s.length(); k++) {
          String third = s.substring(i + j, i + j + k), fourth = s.substring(i + j + k);
          if(isValid(third) && isValid(fourth)) {
            StringBuilder rtSb = new StringBuilder();
            rtSb.append(first);
            rtSb.append(TOKEN);
            rtSb.append(second);
            rtSb.append(TOKEN);
            rtSb.append(third);
            rtSb.append(TOKEN);
            rtSb.append(fourth);
            rtList.add(rtSb.toString());
          }
        }
      }
    }

    return rtList;
  }

  private static boolean isValid(String str) {
    if(str.length() > 3) {
      return false;
    }

    if(str.charAt(0) == '0' && str.length() > 1) {
      return false;
    }

    int ip = Integer.valueOf(str);
    return ip >= 0 && ip <= 255;
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
            .runFromAnnotations(args, "ValidIpAddresses.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
