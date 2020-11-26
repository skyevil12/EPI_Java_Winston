package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class SpreadsheetEncoding {
  @EpiTest(testDataFile = "spreadsheet_encoding.tsv")

  public static int ssDecodeColID(final String col) {
    //T O(N) S O(1)
    /*int rt = 0;
    if(col.isEmpty()) {
      return rt;
    }

    for(char ch : col.toCharArray()) {
      rt = rt * 26 + (ch - 'A') + 1;
    }

    return rt;*/
    int rt = epi.kt.SpreadsheetEncoding.INSTANCE.ssDecodeColID(col);
//    System.out.println(col + " " + rt + " " + epi.kt.SpreadsheetEncoding.INSTANCE.ssEncodeColID(rt));
    assert  (col.equals(epi.kt.SpreadsheetEncoding.INSTANCE.ssEncodeColID(rt)));
    return rt;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "SpreadsheetEncoding.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
