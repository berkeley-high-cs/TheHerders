public class BinarySearch {

  public int search(int[] nums, int target) {
    int low = 0;
    int high = nums.length;
    int mid = 0;
    
    while(low < high){
      mid = (high + low) / 2;
      if (nums[mid] < target){
        low = mid;
       // printArray(nums);
       // System.err.println(low);
      } else if (nums[mid] > target){
        high = mid;
       // printArray(nums);
       // System.err.println(high);
      } else {
        return mid;
      }
    }
    return -1;

  }
  public void printArray(int[] array){
    for (int i = 0; i < array.length; i++){
      System.err.print(array[i] + " ");
    }
    System.err.println("");
  }
}
