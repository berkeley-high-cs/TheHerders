/*
 * A number is prime if it is not divisible by any number other than 1 and
 * itself. 1 is not prime. Thus you can test whether a number greater than 1 is
 * prime by checking whether it is divisible by any smaller number greater than
 * one.
 */

public class Primes {
  public static boolean isPrime(int num){
    for (int i = 2; i < num; i++){
      if (num % i == 0){
        System.out.println("something false");
        return false;
      } 
      if (i == num){
        return true;
      }
    }
    System.out.println("something wrong");
    return false;
  }
  public boolean numberOfPrimesBelow (int num){
    p
  }


}
