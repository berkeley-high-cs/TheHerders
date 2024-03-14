//import java.util.Scanner;

public class Guns40k {
 
  public static void main(String[] args){
    int attacks = 0;
    int damage = 0;
    String diceAmount = "";
    if (Simulate.chatGunIfDice(0)){
      diceAmount = Simulate.chatDiceAmount();
      attacks = Simulate.diceAmountRoll(diceAmount);
    } else {
     attacks = Simulate.chatNum(0);
    }
    if (Simulate.chatGunIfDice(1)){
      diceAmount = Simulate.chatDiceAmount();
      damage = Simulate.diceAmountRoll(diceAmount);
    } else {
      damage = Simulate.chatNum(4);
    }
    
    boolean devastatingWounds = Simulate.chatDevastatingWounds();
    int bs = Simulate.chatNum(1);
    int strength = Simulate.chatNum(2);
    int ap = Simulate.chatNum(3);
    int dWRollAmount = Simulate.chatNum(5);
    int toughness = Simulate.chatToughness();
    int unitSave = Simulate.chatUnitSave();
    int amountRuns = Simulate.chatAmountRuns();
    
    
   
   for (int i = 0; i <= amountRuns; i++){
     Simulate.simulate(attacks, bs, strength, toughness, ap, damage, unitSave, devastatingWounds, dWRollAmount);
    
    
   }
    Simulate.printAverage(amountRuns);
  }
 
  
}