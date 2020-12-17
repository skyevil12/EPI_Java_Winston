package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    private static Map<Character, Integer> map = new HashMap<>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    @EpiTest(testDataFile = "roman_to_integer.tsv")
//T O(N) S O(1)
    public static int romanToInteger(String s) {
//    assert(isValid(s));
//    int rt = 0, prev = Integer.MAX_VALUE;
//
//    for(char ch : s.toCharArray()) {
//      int val = map.get(ch);
//      if(val > prev) {
//        rt -= prev;
//        rt += (val - prev);
//      } else {
//        rt += val;
//      }
//      prev = val;
//    }
//
//    return rt;
        return epi.kt.RomanToInteger.INSTANCE.romanToInteger(s);
    }

    private static boolean isValid(String s) {
    /*
      0. Check if there contains any illegal char
      1. Check if correct preceding char
      2. Check if back to back exception exist
     */
        boolean hasPre = false;
        int prev = Integer.MAX_VALUE;
        int cnt = 1;
        for (char ch : s.toCharArray()) {
            Integer val = map.get(ch);
            //Check if there contains any illegal char
            if (val == null) {
                return false;
            }

            if (val > prev) {
                if (hasPre || cnt > 1) {
                    //Back to back
                    return false;
                }
                //Check if correct preceding char
                if (((ch == 'V' || ch == 'X') && prev != 1)
                        || ((ch == 'L' || ch == 'C') && prev != 10)
                        || ((ch == 'D' || ch == 'M') && prev != 100)) {
                    return false;
                }

                hasPre = true;
            } else {
                hasPre = false;
            }
            if (prev == val) {
                cnt++;
            } else {
                prev = val;
                cnt = 1;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        //Back to back
        assert (!isValid("IXC"));
        assert (!isValid("CDM"));
        //Illegal char
        assert (!isValid("ACD"));
        //Wrong preceding char
        assert (!isValid("IDM"));
        assert (!isValid("IIX"));
        assert (isValid("I"));
        assert (isValid("V"));
        assert (isValid("X"));
        assert (isValid("L"));
        assert (isValid("C"));
        assert (isValid("D"));
        assert (isValid("M"));
        assert (isValid("II"));
        assert (isValid("VII"));
        assert (isValid("XVII"));
        assert (isValid("LXVII"));
        assert (isValid("CLXVII"));
        assert (isValid("DCLXVII"));
        assert (isValid("MDCLXVII"));
        assert (isValid("VVII"));
        assert (isValid("VVVII"));
        assert (isValid("XXVVVII"));
        assert (isValid("CCCXXVVVII"));
        assert (isValid("DDCCCXXVVVII"));
        assert (isValid("MMMDDCCCXXVVVII"));
        assert (isValid("IV"));
        assert (isValid("IX"));
        assert (isValid("IVV"));
        assert (isValid("IXX"));
        assert (isValid("XL"));
        assert (isValid("XLL"));
        assert (isValid("XCC"));
        assert (isValid("CD"));
        assert (isValid("CM"));
        assert (isValid("CDD"));
        assert (isValid("CMM"));
        assert (isValid("XXXXXIIIIIIIII"));
        assert (isValid("LVIIII"));
        assert (isValid("LIX"));
        assert (isValid("CMMXCCIXX"));
        assert (!isValid("IIL"));
        assert (!isValid("IIC"));
        assert (!isValid("IID"));
        assert (!isValid("IIM"));
        assert (!isValid("XXD"));
        assert (!isValid("XXM"));
        assert (!isValid("IC"));
        //https://leetcode.com/discuss/interview-question/746954/amazon-virtual-onsite-roman-number-validation
        /*
        1. To find the value of a set of roman numerals you add up the value of the characters.
        2. A power of ten can only be repeated three times i.e., XXX = 30, XXXX is not valid.
        3. Those that are not powers of ten can only appear once, i.e. VV is not valid.
        4. The numbers must read highest-lowest from the left to the right. (with one exception, see the next rule)
        5. If a letter of a smaller value appears before a number of a higher value, then the smaller number is to be subtracted from the higher value. ex: IX = 9.
        6. You can subtract only powers of ten i.e., I, X, C
        7. Only one character can be used to subtract from a larger character. eg IIX = 8 is not allowed.
        8. You can't subtract a number from one that is more than 10 times greater. That is, you can only subtract I from V or X, X from L or C, etc. For e.g., IC can not be used for 99. It must be XCIX.
         */
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "RomanToInteger.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
