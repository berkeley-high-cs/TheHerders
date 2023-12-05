public class Numbers {
  private int[] numbers;
  private int size;
  public Numbers(int arraySize){
    this.numbers = new int [arraySize];
    this.size = size;
  }
  public static void main(String[] args){

  }
  public int size(){
    return size;
  }
  public void add(int num){
    if (numbers.length = size){
      int[] newArray = new int[numbers.length * 2];
      for (int i = 0; i <= numbers.length; i++){
        newArray[i] = numbers[i];
      }
      newArray[size] = num;

    } else {
    numbers[size] = num;
    size++;
    }
  }
}