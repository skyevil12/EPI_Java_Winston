package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class SpreadsheetEncoding {
  @EpiTest(testDataFile = "spreadsheet_encoding.tsv")

  public static int ssDecodeColID(final String col) {
    int rt = 0;

    //T O(N) S O(1)
    for(char ch : col.toCharArray()) {
      rt *= 26;
      rt += (ch - 'A' + 1);
    }

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
