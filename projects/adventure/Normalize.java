public class Normalize {
    public String normalizeInput(String input){ 
        //should take player input, seperate it into words, check if there are synonyms, then return the synonyms and words in a way code understands
        String tempInput = input;
        String firstWord = "";
        String secondWord = "";
        if (isLetter(tempInput.substring(0, 1))){ // if the first char is a letter
            firstWord = tempInput.substring(0, Math.min(tempInput.indexOf(" "), tempInput.length())); //first word is all letters up until first space
            if (tempInput.substring(tempInput.indexOf(" " + 1)).indexOf(" ") == -1){ //if there isnt more than one space
                secondWord = tempInput.substring(tempInput.indexOf(" "));//second word equals the rest of the command

            } else {
                secondWord = tempInput.substring(tempInput.indexOf(" "), tempInput.substring(tempInput.indexOf(" " + 1)).indexOf(" ")); //second word equals up to the next space

            }
            
        } else {
            tempInput = tempInput.substring(getFirstLetterIndex(tempInput));
            
        }
        System.out.println("normalize input is not finished");
        return "";
     
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


    }
}
