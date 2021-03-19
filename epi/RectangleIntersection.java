package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;
public class RectangleIntersection {
  @EpiUserType(ctorParams = {int.class, int.class, int.class, int.class})
  public static class Rect {
    int x, y, width, height;

    public Rect(int x, int y, int width, int height) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Rect rectangle = (Rect)o;

      if (x != rectangle.x) {
        return false;
      }
      if (y != rectangle.y) {
        return false;
      }
      if (width != rectangle.width) {
        return false;
      }
      return height == rectangle.height;
    }

    @Override
    public int hashCode() {
      int result = x;
      result = 31 * result + y;
      result = 31 * result + width;
      result = 31 * result + height;
      return result;
    }

    @Override
    public String toString() {
      return "[" + x + ", " + y + ", " + width + ", " + height + "]";
    }
  }
  @EpiTest(testDataFile = "rectangle_intersection.tsv")
  public static Rect intersectRectangle(Rect r1, Rect r2) {
    //T O(1) S O(1)
    int[] h1 = {r1.x, r1.x + r1.width}, h2 = {r2.x, r2.x + r2.width};
    int[] v1 = {r1.y, r1.y + r1.height}, v2 = {r2.y, r2.y + r2.height};
    int isX = Math.max(h1[0], h2[0]), isY = Math.max(v1[0], v2[0]);
    int iW = Math.min(h1[1], h2[1]) - isX, iH = Math.min(v1[1], v2[1]) - isY;
    if(iW < 0 || iH < 0) {
      return new Rect(0, 0, -1, -1);
    }
    return new Rect(isX, isY, iW, iH);
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "RectangleIntersection.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
