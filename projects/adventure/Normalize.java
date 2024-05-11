public class Normalize {
    public String normalizeInput(String input){ 
        //should take player input, seperate it into words, check if there are synonyms, then return the synonyms and words in a way code understands
        
        String tempInput = input;
        String firstWord = "";
        String secondWord = "";
        firstWord = tempInput.substring(getFirstLetterIndex(tempInput), findNextEndOfWord(tempInput));
        String helperString = tempInput.substring(Math.min(tempInput.length(), firstWord.length() + 1)); //cuts first word from tempInput, unless there is no more than one word
        secondWord = helperString.substring(getFirstLetterIndex(helperString), findNextEndOfWord(helperString));
        firstWord = getSynonym(firstWord);
        secondWord = getSynonym(secondWord);
        System.out.println("firstWord is: |" + firstWord + "|");
        System.out.println("secondWord is: |" + secondWord + "|");
        return firstWord + " " + secondWord;
     
    }
    public boolean isLetter(String inputLetter){
        return "abcdefghijklmnopqrstuvwxyz".indexOf(inputLetter) >= 0;
    }
    public int getFirstLetterIndex(String input){
        for (int i = 0; i < input.length(); i++){
            if(isLetter(input.substring(i, i + 1))){
                return i;
            }
        }
        return 0;
    }
    public String getSynonym(String input){ //find all recognized words, then find a bunch of synonyms for them
        String[] moveSynonyms = {"go", "leave", "run", "shimmy"};
        String[] lookSynonyms = {"see", "view", "gaze", "survey"};
        for (int i = 0; i < moveSynonyms.length; i++){
            if (moveSynonyms[i].equals(input)){
                return "move";
            }
            if (lookSynonyms[i].equals(input)){
                return input;
            }
        }
        if (input.equals("up")){
            return "north";
        }
        if (input.equals("right")){
            return "east";
        }
        if (input.equals("down")){
            return "south";
        }
        if (input.equals("left")){
            return "west";
        }
        return input;

    }
    public boolean checkForMoreSpace(String input){
        return input.substring(input.indexOf(" ") + 1).indexOf(" ") != -1;
    }
    public int findNextEndOfWord(String input){
        if (input.equals("") || input == null){
            System.out.println("WEE WOO WEE WOO, find end of next word input got shittaroonied on");
            return -1;
        }
        if (input.indexOf(" ") == -1){
            return input.length();
        } else {
            return input.indexOf(" ");
        }
    }

}
