import java.util.Scanner;
//not finished, no longer being worked on
public class Guns {
  private String gunName;
  private int gunAttacks;
  private int gunBs;
  private int gunStrength;
  private int gunAp;
  private int gunDamage;

  public Guns(String name, int attacks, int bs, int strength, int ap, int damage) {
    gunName = name;
    gunAttacks = attacks;
    gunBs = bs;
    gunStrength = strength;
    gunAp = ap;
    gunDamage = damage;
  }

  public static void guns(String[] args) {

  }

  public static String chatName() {
    System.out.println("What is your guns name?");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();

  }

  public static int chatNum(int place) {
    String[] keyword = { "range", "attack", "balistics skill", "strength", "armour piercing", "damage" };
    System.out.println("What is your guns " + keyword[place] + " value?");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();

  }

  public static int chatAmountGuns() {
    System.out.println("How many guns do you want to compare?");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();

  }

  public static int chatUnitSave() {
    System.out.println("What is the amour save of the unit you are shooting at?");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();

  }

  public static int chatUnitToughness() {
    System.out.println("What toughness does the unit you are shooting at have?");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();

  }

  // calculation is wrong, unitsave + ap is not correct, and dividing everything
  // else by it might not be either
  public int calculate() {
    int saveChance = unitSave + ap;
    Math.max(0, saveChance);
    if (strength > unitToughness && strength < 2 * unitToughness) {
      System.out.println((attacks * (7 - bs) / 6.0) * 4.0 / 6 * damage * (saveChance / 6.0));
    }
    if (strength < unitToughness && 2 * strength > unitToughness) {
      System.out.println((attacks * (7 - bs) / 6.0) * 2.0 / 6 * damage * (saveChance / 6.0));
    }
    if (strength == unitToughness) {
      System.out.println((attacks * (7 - bs) / 6.0) * 3.0 / 6 * damage * (saveChance / 6.0));
    }
    if (2 * strength < unitToughness) {
      System.out.println((attacks * (7 - bs) / 6.0) * 1.0 / 6 * damage * (saveChance / 6.0));
    }
    if (strength > 2 * unitToughness) {
      System.out.println((attacks * (7 - bs) / 6.0) * 5.0 / 6 * damage * (saveChance / 6.0));
    }
    return 0;
  }

}