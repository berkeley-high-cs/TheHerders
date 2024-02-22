public class BinarySearch {

  public int search(int[] nums, int target) {
    int low = nums[0];
    int high = nums[nums.length - 1];
    int mid = 0;
    
    while(low < high){
      mid = (low + high) / 2;
      if (mid > target){
        low = mid;
      } else if (mid < target){
        high = mid;
      } else {
        return mid;
      }
    }
    return -1;

  }

}
