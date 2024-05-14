public class Normalize {
    public String normalizeInput(String input) {
        // should take player input, seperate it into words, check if there are
        // synonyms, then return the synonyms and words in a way code understands

        String tempInput = input;
        String firstWord = "";
        String secondWord = "";
        firstWord = tempInput.substring(getFirstLetterIndex(tempInput), findNextEndOfWord(tempInput));
        if (firstWord.length() < tempInput.length()) {
            tempInput = tempInput.substring(findNextEndOfWord(tempInput));
            System.out.println("temp input is: " + tempInput);
            secondWord = tempInput.substring(getFirstLetterIndex(tempInput), findNextEndOfWord(tempInput));
            firstWord = getSynonym(firstWord);
            secondWord = getSynonym(secondWord);
            System.out.println("firstWord is: |" + firstWord + "|");
            System.out.println("secondWord is: |" + secondWord + "|");
            if (secondWord.equals("") || secondWord.equals(" ")){
                return firstWord;
            }
            return firstWord + " " + secondWord;

        } else {
            firstWord = getSynonym(firstWord);
            System.out.println("firstWord is: |" + firstWord + "|");
            return firstWord;
        }

    }

    public boolean isLetter(String inputLetter) {
        return "abcdefghijklmnopqrstuvwxyz".indexOf(inputLetter) >= 0;
    }

    public int getFirstLetterIndex(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (isLetter(input.substring(i, i + 1))) {
                return i;
            }
        }
        //System.out.println("get First letter index all spaces");
        return 0;
    }

    public String getSynonym(String input) { // find all recognized words, then find a bunch of synonyms for them
        String[] moveSynonyms = { "go", "leave", "run", "shimmy" };
        String[] lookSynonyms = { "see", "view", "gaze", "survey" };
        for (int i = 0; i < moveSynonyms.length; i++) {
            if (moveSynonyms[i].equals(input)) {
                return "move";
            }
            if (lookSynonyms[i].equals(input)) {
                return input;
            }
        }
        if (input.equals("up")) {
            return "north";
        }
        if (input.equals("right")) {
            return "east";
        }
        if (input.equals("down")) {
            return "south";
        }
        if (input.equals("left")) {
            return "west";
        }
        return input;

    }

    public boolean checkForMoreSpace(String input) {
        return input.substring(input.indexOf(" ") + 1).indexOf(" ") != -1;
    }
    public boolean checkForLetters(String input){ //returns true if there is one letter
        for (int i = 0; i < input.length(); i++){
            if (isLetter(input.substring(i, i + 1))){
                return true;
            }
        }
        return false;
    }

    public int findNextEndOfWord(String input) {
        if (input.equals("") || input == null) {
            //System.out.println("WEE WOO WEE WOO, find end of next word input got shittaroonied on");
            return 0;
        }
        if (input.substring(getFirstLetterIndex(input)).indexOf(" ") == -1) { //at least one space after a word
            return input.length();
        } else if (checkForLetters(input)){ 
            return input.substring(getFirstLetterIndex(input)).indexOf(" ") + getFirstLetterIndex(input);
        } else {
            return input.length();
        }
    }

}
