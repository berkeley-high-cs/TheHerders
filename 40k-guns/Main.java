import java.util.Scanner;

public class Main {
 
  public static void main(String[] args){
    String name;
    int range = 0;
    int attacks;
    int bs = 0;
    int strength = 0;
    int ap = 0;
    int damage = 0;
    int unitToughness = 0;
    int unitSave = 0;
    int amountGuns = Guns.chatAmountGuns();
    
    Guns[] gunnies = new Guns[amountGuns];
   for (int i = 0; i <= amountGuns; i++){
     
     name = Guns.chatName();
     range = Guns.chatNum(0);
     attacks = Guns.chatNum(1);
     bs = Guns.chatNum(2);
     strength = Guns.chatNum(3);
     ap = Guns.chatNum(4);
     damage = Guns.chatNum(5);
     unitToughness = Guns.chatUnitToughness();
     unitSave = Guns.chatUnitSave();
     System.out.print("The gun " + name + "'s average damage per shooting round is ");
     Guns.calculate(attacks, bs, strength, ap, damage, unitToughness, unitSave);
    gunnies[i] = new Guns(name, attacks,1,1,1,1);
    
   }
  }
 
  
}