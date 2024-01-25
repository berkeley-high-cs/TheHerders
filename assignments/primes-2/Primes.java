/*
 * Recall tha a number is prime if it is not divisible by any number other than
 * 1 and itself. 1 is not prime. Thus you can test whether a number greater than
 * 1 is prime by checking whether it is divisible by any smaller number greater
 * than one.
 *
 * Remember that you only need to check possible factors up to (but including)
 * the square root of the number since any factor larger than the square root
 * would have to be multiplied by some factor smaller than the square root to
 * get the number.
 *
 * Also note that you only really need to check whether the number is divisible
 * by the prime numbers less than or equal to the square root because if a
 * number is divisible by a composite number it is divisible by all of that
 * composite number's prime factors.
 */
import java.util.ArrayList;

public class Primes {
  public ArrayList<Integer> primes(int n){
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++){
      if (i.isPrime()){
        
      }
    }
    return list;
  }
  public boolean isPrime(int n){
    for (int i = 2; i < Math.sqrt(n); i++){
      if (n % i == 0){
        return false;
      }
    }
    return true;
  }
}
