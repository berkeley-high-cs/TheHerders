public class Crossword {
         public boolean fits(String guess, String word){
          
            if (guess.length != word.length()){
              return false;
            }
            for (int i = 0; i < word.length(); i++){
              if (guess.substring(Math.Min(i - 1, 0), i).equals(word.substring(Math.Min(i - 1, 0), i)) || guess.substring(Math.Min(i - 1, 0), i).equals("-")){
                  
              } else {
                return false;
              }
            }
            return true;
            
         }
}
