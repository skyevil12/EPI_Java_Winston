package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class SubstringMatch {
  @EpiTest(testDataFile = "substring_match.tsv")

  // Returns the index of the first character of the substring if found, -1
  // otherwise.
  public static int rabinKarp(String t, String s) {
    //return t.indexOf(s);
    //Rolling hash, T O(S + T) S O(1)
    long hash = 0, tmpHash = 0;
    int base = 26, sLen = s.length(), tLen = t.length();
    //Consider the tLen < sLen
    if(tLen < sLen) {
      return -1;
    }

    for (int i = 0; i < sLen; i++) {
      hash *= base;
      hash += (s.charAt(i) - 'A');
      tmpHash *= base;
      tmpHash += (t.charAt(i) - 'A');
    }

    double upMost = Math.pow(base, sLen - 1);
    for(int i = 0; i + sLen <= tLen; i++) {
      //Consider the case that sLen == tLen
      String substring = t.substring(i, i + sLen);
      if(i == 0) {
        if(tmpHash == hash) {
          //Secure hash error won't bother
          if(substring.equals(s)) {
            return i;
          }
        }
        continue;
      }

      tmpHash -= (t.charAt(i - 1) - 'A') * upMost;
      tmpHash *= base;
      tmpHash += (t.charAt(i + sLen - 1) - 'A');
      if(tmpHash == hash) {
        //Secure hash error won't bother
        if (substring.equals(s)) {
          return i;
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SubstringMatch.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
