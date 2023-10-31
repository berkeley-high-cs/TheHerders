/*
 * A number is prime if it is not divisible by any number other than 1 and
 * itself. 1 is not prime. Thus you can test whether a number greater than 1 is
 * prime by checking whether it is divisible by any smaller number greater than
 * one.
 */

public class Primes {
  public boolean isPrime(int num){
    for (int i = 1; i < num; i++){
      if (num % i == 0){
        return false;
      } 
      if (i == num){
        return true;
      }
    }
    System.out.println("something wrong");
    return false;
  }


}
