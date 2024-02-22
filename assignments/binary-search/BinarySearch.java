public class BinarySearch {

  public int search(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    int mid = 0;
    
    while(low <high){
      mid = low + (high - low) / 2;
      if (mid > target){
        low = mid;
        printArray(nums);
        System.err.println(low);
      } else if (mid < target){
        high = mid;
        printArray(nums);
        System.err.println(high);
      } else {
        return mid;
      }
    }
    return -1;

  }
  public void printArray(int[] array){
    for (int i = 0; i < array.length; i++){
      System.err.println(array[i]);
    }
  }

}
