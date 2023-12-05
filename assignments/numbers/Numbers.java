public class Numbers {

  private int[] numbers;
  private int size;

  public Numbers(int arraySize) {
    this.numbers = new int[arraySize];
    this.size = size;
  }

  public static void main(String[] args) {}

  public int size() {
    return size;
  }

  public void add(int num) {
    if (numbers.length <= size) {
      int[] newArray = new int[numbers.length * 2];
      for (int i = 0; i < numbers.length; i++) {
        newArray[i] = numbers[i];
      }
      numbers = newArray;
    }
    numbers[size] = num;
    size++;
  }
  public int get(int index){
    if (index < 0 || index >= size){
      throw new IndexOutOfBoundsException(index);
    } else {
      return numbers[index];
    }

  }
  public int removeLast(){
    if (size == 0){
      throw new IndexOutOfBoundsException();
    } else {
      int[] newArray = new int [numbers.length - 1];
      numbers = newArray;
    }
  }
}
