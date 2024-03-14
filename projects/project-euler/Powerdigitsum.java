//finds digits added together of very big numbers

import java.math.BigInteger;

public class Powerdigitsum {
    public static void main(String[] args) {
        BigInteger num = new BigInteger("2").pow(1000);
        BigInteger ten = new BigInteger("10");
        BigInteger digitSum = new BigInteger("0");
        while (num.signum() == 1) {
            digitSum = digitSum.add(num.mod(ten));
            num = num.divide(ten);
        }
        System.out.println(digitSum);
    }
}
