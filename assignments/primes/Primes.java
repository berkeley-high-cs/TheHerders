/*
 * A number is prime if it is not divisible by any number other than 1 and
 * itself. 1 is not prime. Thus you can test whether a number greater than 1 is
 * prime by checking whether it is divisible by any smaller number greater than
 * one.
 */

public class Primes {
  public static boolean isPrime(int num){
    if (num <= 1){
        return false;
      }
    for (int i = 2; i < num / 2.0; i++){
      if (num % i == 0){
        return false;
      } 
    }
    
    return true;
  }
  public int numberOfPrimesBelow (int num){
    int totalNumberOfPrimesBelow = 0;
    for (int i = 0; i <= num; i++){
      if (isPrime(i)){
        totalNumberOfPrimesBelow++;
      }
    }
    return totalNumberOfPrimesBelow;
  }


}
