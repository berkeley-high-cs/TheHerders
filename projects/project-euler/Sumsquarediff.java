

public class Sumsquarediff {  
    public static void main(String[] args) {
        int sumOfTheSquares = sumOfTheSquares(100);
        int squareOfTheSums = squareOfTheSums(100);
        System.out.println(sumOfTheSquares - squareOfTheSums);
      }
      public static int sumOfTheSquares(int loop){
        int total = 0;
        for (int i = 0; i <= loop; i++){
            total += i * i;
        }
        return total;
      }
      public static int squareOfTheSums(int loop){
        int total = 0;
        for (int i = 0; i <= loop; i++){
            total += i;
        }
        return total * total;
      }
 }
    
