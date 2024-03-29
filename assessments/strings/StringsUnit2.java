public class StringsUnit2 {

  // Write methods here. They should be public but not static.
  public String firstCharacter(String s) {
    return s.substring(0, 1);
  }

  public String lastCharacter(String s) {
    int last = (s.length()) - 1;
    return s.substring(last);
  }

  public String pair(String s, String a) {
    return (s + " and " + a);
  }

  public boolean longerThan(String s, String a) {
    int firstStringLength = s.length();
    int secondStringLength = a.length();
    if (firstStringLength > secondStringLength == true) {
      return true;
    } else {
      return false;
    }
  }

  public String upDown(String s) {
    return (s.toUpperCase() + s.toLowerCase());
  }

  public boolean contains(String s, String a) {
    if (s.contains(a) == true) {
      return true;
    } else {
      return false;
    }
  }

  public String slug(String s, String a, String b) {
    String x = s.toLowerCase();
    String y = a.toLowerCase();
    String z = b.toLowerCase();
    return (x + "-" + y + "-" + z);
  }

  public String simplePigLatin(String s, int i) {
    String newWord = (s.substring(i, s.length()) + s.substring(0, i) + "ay");
    return (newWord);
  }

  public String capitalize(String s) {
    String newWord =
      (
        (s.substring(0, 1)).toUpperCase() +
        s.substring(1, s.length()).toLowerCase()
      );
    return (newWord);
  }

  public String oneCharacter(String s, int i) {
    String newWord = (s.substring(i, i + 1));
    return (newWord);
  }

  public String firstHalf(String s) {
    String newWord = (s.substring(0, s.length() / 2));
    return (newWord);
  }

  public String lastHalf(String s) {
    String newWord = (s.substring(s.length() / 2, s.length()));
    return (newWord);
  }

  public String upTo(String s, String a) {
    String newWord = (s.substring(0, s.indexOf(a)));
    return (newWord);
  }

  public String firstName(String s) {
    String newWord = (s.substring(0, s.indexOf(" ")));
    return (newWord);
  }

  public String lastName(String s) {
    String newWord = (s.substring(s.indexOf(" ") + 1, s.length()));
    return (newWord);
  }

  public boolean startsWith(String s, String a) {
    int place = (a.length());
    if (place > s.length()) {
      return false;
    }
    String newWord = (s.substring(0, place));
    if (a.equals(newWord)) {
      return true;
    } else {
      return false;
    }
  }

  public boolean endsWith(String s, String a) {
    int place = (a.length());
    int sLength = (s.length());
    String newWord = (s.substring(sLength - place, sLength));
    if (a.equals(newWord)) {
      return true;
    } else {
      return false;
    }
  }

  public String middle(String s) {
    //String middle =
     // (s.substring(s.length() / 4, s.length() - (s.length() / 4)));

    String middle = s.substring(s.length() / 4, 3 * s.length() / 4);

    return middle;
  }

  public String upDownLastCharacter(String s) {
    String lastChar = (s.substring(s.length() - 1, s.length()));

    return (lastChar.toUpperCase() + lastChar.toLowerCase());
  }

  public String oneCharacterUpDown(String s, int i) {
    String letter = (s.substring(i, i + 1));

    return (upDownLastCharacter(letter));
  }

  public String firstAndLast(String s) {
    String first = (s.substring(0, 1));
    String last = (s.substring(s.length() - 1, s.length()));

    return (first + last);
  }

  public String swapFrontAndBack(String s) {
    String firstHalf = firstHalf(s);
    String lastHalf = lastHalf(s);

    return (lastHalf + firstHalf);
  }

  public String capitalizeName(String s) {
    String firstName = firstName(s);
    String lastName = lastName(s);

    return (capitalize(firstName) + " " + capitalize(lastName));
  }

  public String initials(String s) {
    String firstName = firstName(s);
    String lastName = lastName(s);

    return (firstName.substring(0, 1) + lastName.substring(0, 1));
  }
}
