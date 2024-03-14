public class BinarySearch {

  public int search(int[] nums, int target) {

    int low = 0;
    int high = nums.length;

    while (low < high) {
      int mid = low + (high - low) / 2;
      int midVal = nums[mid];

      if (target < midVal) {
        // Target is below mid so in interval [low, mid)
        high = mid;
      } else if (target > midVal) {
        // Target is above mid so in interval [mid+1, high)
        low = mid + 1;
      } else {
        // Target is at mid, i.e. in interval [mid, mid + 1)
        return mid;
      }
    }

    //return -(low + 1);
    return -1;
  }

}
