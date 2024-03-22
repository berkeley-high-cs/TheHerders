public class RomanNumerals {

  private static final int[] ROMAN_VALUES = { 1, 5, 10, 50, 100, 500, 1000 };
  private static final String ROMAN_DIGITS = "IVXLCDM";

  /*
   * Translate a single roman numeral digit into its int value.
   */
  private int fromRomanDigit(String s) {
    return ROMAN_VALUES[ROMAN_DIGITS.indexOf(s)];
  }
  public int decode(String num){
    String lessNum = num.substring(1);
    if (num.isEmpty()){
      return 0;
    } else {
      return fromRomanDigit(lessNum) + decode(lessNum);
    }
  }

}
