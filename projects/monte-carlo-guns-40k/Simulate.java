import java.util.Scanner;

class Simulate {
  static String diceAmount = "";
  static boolean gunDamageDice = false;
  static int total = 0;
  class Guns {
  
   int gunAttacks;
   int gunBs;
   int gunStrength;
   int gunAp;
   int gunDamage;

    public Guns(int attacks, int bs, int strength, int ap, int damage) {
      
      gunAttacks = attacks;
      gunBs = bs;
      gunStrength = strength;
      gunAp = ap;
      gunDamage = damage;
     }
  }
  class Unit {
    int unitToughness;
    int unitSave;
    //int unitModelCount;

     public Unit(int toughness, int save){
       unitToughness = toughness;
       unitSave = save;
       //unitModelCount = modelCount;
     }
  }
  
  public static int chatNum(int place){
     String[] keyword = {"attack", "balistics skill", "strength", "armour piercing", "damage","devastating wounds (amount in order to acheive devastating wounds)"};
    System.out.println("What is your guns " + keyword[place] + " value?");
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    scanner.close();
     return num;
    
  }
  public static String chatDiceAmount(){
   
    System.out.println("Input dice type and amount like so: 1D6");
    Scanner scanner = new Scanner(System.in);
    diceAmount = scanner.nextLine();
    diceAmount = (diceAmount.toUpperCase());
    scanner.close();
    return diceAmount;
  }
  public static int diceAmountRoll(String diceAmount){
    switch (diceAmount) {
       case "1D6":
          return roll();
         
         case "2D6":
          return (roll() + roll());
         
         case "3D6":
          return (roll() + roll() + roll());
         
         case "1D3":
          return ((int)(Math.ceil(roll()/2.0)));

         case "2D3":
          return ((int)(Math.ceil(roll()/2.0) + Math.ceil(roll()/2.0)));

         case "3D3":
          return ((int)(Math.ceil(roll()/2.0) + Math.ceil(roll()/2.0) + Math.ceil(roll()/2.0)));

         case "1D6 + 1":
          return (roll() + 1);

         case "2D6 + 1":
          return (roll() + roll() + 1);

         case "3D6 + 1":
          return (roll() + roll() + roll() + 1);

         case "1D3 + 1":
          return ((int)(Math.ceil(roll()/2.0) + 1));

         case "2D3 + 1":
          return ((int)(Math.ceil(roll()/2.0) + Math.ceil(roll()/2.0) + 1));

         case "3D3 + 1":
          return ((int)(Math.ceil(roll()/2.0) + Math.ceil(roll()/2.0) + Math.ceil(roll()/2.0) + 1));
        
         
     }
    System.out.println("something went wrong");
    return 0;
    
  }
  public static boolean chatGunIfDice(int place){
    String[] keyword = {"attacks", "damage"};
    System.out.println("Is your gun's " + keyword[place] + " value represented by a dice roll? yes or no");
    Scanner scanner = new Scanner(System.in);
    String yesOrNo = scanner.nextLine();
    scanner.close();
     if (yesOrNo.equals("yes")){
       gunDamageDice = true;
       return true;
     } else if (yesOrNo.equals("no")){
       return false;
     } else{
       System.out.println("Please try again later.");
     }
    return false;
  }
  public static int chatUnitSave(){
    System.out.println("What is the amour save of the unit you are shooting at?");
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    scanner.close();
     return  num;
  }
  public static int chatToughness(){
    System.out.println("What toughness does the unit you are shooting at have?");
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
     scanner.close();
     return num;  
  } 
  public static int chatAmountRuns(){
    System.out.println("How many times do you want to run?");
    Scanner scanner = new Scanner(System.in);
    int num =  scanner.nextInt();
     scanner.close();
     return num;
  }
  public static boolean chatDevastatingWounds(){
    System.out.println("Does your gun have devastating wounds?");
    Scanner scanner = new Scanner(System.in);
     String yesOrNo = scanner.nextLine();
     scanner.close();
     if (yesOrNo.equals("yes")){
       return true;
     } else if (yesOrNo.equals("no")){
       return false;
     } else{
       System.out.println("Please try again later.");
     }
    return false;
  }
    
  
  public static void simulate(int attacks, int bs, int strength, int toughness, int ap, int damage, int unitSave, boolean devastatingWounds, int dWRollAmount) {
    int place = 0;
    for (int i = 0; i < attacks; i++){
      
      if (roll() >= bs){
        if (devastatingWounds){
            if (roll() >= dWRollAmount){
              place = damage(damage, gunDamageDice);
              total += place;
              System.out.println("you did " + place + " damage");
              
            } 
        }
        if (rollToWound(strength, toughness)){
          if (rollToSave(ap, unitSave) != true){
            place = damage(damage, gunDamageDice);
              total += place;
              System.out.println("you did " + place + " damage");
          }else {
        System.out.println("They saved");
      }
        }else {
        System.out.println("You didn't wound");
      }
      } else {
        System.out.println("You missed");
      }
    }
  }
  public static int roll (){
    return (int)(Math.random() * 6 + 1);
  }
  public static boolean rollToWound (int strength, int toughness){
    if (strength >= 2 * toughness){
      if (roll() >= 2){
        return true;
      } else {
        return false;
      }
   }
  else if (strength > toughness){
    if (roll() >= 3){
        return true;
      } else {
        return false;
      }
   }
   else if (strength == toughness){
      if (roll() >= 4){
        return true;
      } else {
        return false;
      }
   }
    else if (strength < toughness){
    if (roll() >= 5){
        return true;
      } else {
        return false;
      }
   }
    else if (strength * 2 <= toughness){
      if (roll() >= 6){
        return true;
      } else {
        return false;
      }
   } else {
    return false;
    }
    
  }
   public static boolean rollToSave(int ap, int unitSave){
     if ((roll() - ap) >= unitSave){
       return true;
     } else {
       return false;
     }
   }
  public static int damage(int damage, boolean gunDamageDice){
     if (gunDamageDice){
       return diceAmountRoll(diceAmount);
     } else {
       return damage;
     }
   }
  public static void printAverage(int amountRuns){
    System.out.println((double)total / amountRuns);
  }
}






