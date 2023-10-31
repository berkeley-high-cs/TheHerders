/*
 * A number is prime if it is not divisible by any number other than 1 and
 * itself. 1 is not prime. Thus you can test whether a number greater than 1 is
 * prime by checking whether it is divisible by any smaller number greater than
 * one.
 */

public class Primes {
  public static boolean isPrime(int num){
    for (int i = 1; i < num; i++){
      if (i == num - 1){
        return true;
      }
      if (num % i == 0){
        
        return false;
      } 
      
    }
    
    return true;
  }
  public int numberOfPrimesBelow (int num){
    for (int i = 0; i <= num; i++){
      return 0;
    }
    return 0;
  }


}
