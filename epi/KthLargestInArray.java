package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class KthLargestInArray {
  // The numbering starts from one, i.e., if A = [3,1,-1,2] then
  // findKthLargest(1, A) returns 3, findKthLargest(2, A) returns 2,
  // findKthLargest(3, A) returns 1, and findKthLargest(4, A) returns -1.
  @EpiTest(testDataFile = "kth_largest_in_array.tsv")
  public static int findKthLargest(int k, List<Integer> A) {
//    Collections.sort(A, Collections.reverseOrder());
//    return A.get(k - 1);
    //Quick Select
    /*
      (3, 2,1,5,4)
      k 1
     */
    Integer[] nums = new Integer[A.size()];
    for(int i = 0; i < nums.length; i++) {
      nums[i] = A.get(i);
    }
    int l = 0, r = nums.length - 1, m = 0;
    k--;
    k = nums.length - 1 - k;
    while(l <= r) {
      m = new Random().nextInt(r - l + 1) + l;
      swap(nums, m, r);
      int pivot = pagination(nums, l, r);
      if(k == pivot) {
        return nums[pivot].intValue();
      } else if(k < pivot) {
        r = pivot - 1;
      } else{
        l = pivot + 1;
      }
    }
    return -1;
  }

  private static int pagination(Integer[] nums, int l, int r) {
    int idx = l - 1;
    int target = nums[r];

    for(int i = l; i < r; i++) {
      if(nums[i] < target) {
        idx++;
        swap(nums, i, idx);
      }
    }

    swap(nums, r, idx + 1);
    return idx + 1;
  }

  private static void swap(Integer[] nums, int i, int j) {
    Integer tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "KthLargestInArray.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
