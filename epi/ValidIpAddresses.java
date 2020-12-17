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
//    int len = s.length();
//    List<String> rtList = new ArrayList<>();

//    for(int i = 1; i < 4 && i < len; i++) {
//      String iStr = s.substring(0, i);
//      if(!isValid(iStr)){
//        continue;
//      }
//      for(int j = i + 1; j < i + 4 && j < len; j++) {
//        String jStr = s.substring(i, j);
//        if(!isValid(jStr)) {
//          continue;
//        }
//        for(int k = j + 1; k < j + 4 && k < len; k++) {
//          String kStr = s.substring(j, k);
//          if(!isValid(kStr)) {
//            continue;
//          }
//
//          String remain = s.substring(k);
//          if(!isValid(remain)) {
//            continue;
//          }
//
//          StringBuilder rtSb = new StringBuilder();
//          rtSb.append(iStr)
//                  .append(TOKEN)
//                  .append(jStr)
//                  .append(TOKEN)
//                  .append(kStr)
//                  .append(TOKEN)
//                  .append(remain);
//          rtList.add(rtSb.toString());
//        }
//      }
//    }
//    int k = 3, maxLen = 3;
//    if(s.length() > maxLen * (k + 1)) {
//      //Illegal input
//      return rtList;
//    }
//    core(s, 0, k, new StringBuilder(), rtList);
    return epi.kt.ValidIpAddresses.INSTANCE.getValidIpAddress(s);
  }

  private static void core(String s, int st, int k, StringBuilder sb, List<String> rtList){
    if(k == 0) {
      String str = s.substring(st);
      if(isValid(str)) {
        int oriLen = sb.length();
        if(!sb.isEmpty()) {
          sb.append(TOKEN);
        }
        sb.append(str);
        rtList.add(sb.toString());
        sb.setLength(oriLen);
      }
      return;
    }

    for(int i = st + 1; i < st + 4 && i < s.length(); i++) {
      String str = s.substring(st, i);
      if(isValid(str)) {
        int oriLen = sb.length();
        if(!sb.isEmpty()) {
          sb.append(TOKEN);
        }
        sb.append(str);
        core(s, i, k - 1, sb, rtList);
        sb.setLength(oriLen);
      }
    }
  }

  private static boolean isValid(String str) {
    if(str.length() > 3 || (str.charAt(0) == '0' && str.length() > 1)) {
      return false;
    }

    int val = Integer.parseInt(str);
    return val >= 0 && val <= 255;
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
