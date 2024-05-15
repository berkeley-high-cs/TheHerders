import java.util.HashMap;

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
            System.out.println("tempInput is: " + tempInput);
            System.out.println("first word is: |" + firstWord + "|");
            secondWord = tempInput.substring(getFirstLetterIndex(tempInput), findNextEndOfWord(tempInput));
            System.out.println("second word is: |" + secondWord + "|");
            firstWord = getSynonym(firstWord);
            secondWord = getSynonym(secondWord);

            if (secondWord.equals("") || !checkForLetters(secondWord)){
                
                return firstWord;
            } else {

                return firstWord + " " + secondWord;
            }
           

        } else {
            firstWord = getSynonym(firstWord);
            System.out.println("tempInput is: " + tempInput);
            System.out.println("first word is: |" + firstWord + "|");
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

        return 0;
    }

    public String getSynonym(String input) { // find all recognized words, then find a bunch of synonyms for them
       HashMap<String, String> synonyms = new HashMap<String, String>();
       synonyms.put("go","move");
       synonyms.put("leave","move");
       synonyms.put("run","move");
       synonyms.put("shimmy","move");
       synonyms.put("see","look");
       synonyms.put("view","look");
       synonyms.put("gaze","look");
       synonyms.put("ponder","look");
       synonyms.put("l","look");
       synonyms.put("check","inspect");
       synonyms.put("examine","inspect");
       synonyms.put("read","inspect");
       synonyms.put("study","inspect");
       synonyms.put("butchers","table");
       synonyms.put("butchering","table");
       synonyms.put("butcher","table");
       synonyms.put("desk","table");
       synonyms.put("up","north");
       synonyms.put("left","east");
       synonyms.put("right","west");
       synonyms.put("down","south");
       if(synonyms.get(input) == null){
        return input;
       } else {
        return synonyms.get(input);
       }

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


// String[] moveSynonyms = { "go", "leave", "run", "shimmy" };
// String[] lookSynonyms = { "see", "view", "gaze", "survey" };
// String[] inspectSynonyms = {"check", "examine", "read", "study"};
// String[] inscriptionSynonyms = {"inscription", "text", "words", "poem"};
// String[] tableSynonyms = {"butchering", "butchers", "desk", "butcher"}; //because they might say butchers table, and second word would then be butchers
// for (int i = 0; i < moveSynonyms.length; i++) {
//     if (moveSynonyms[i].equals(input)) {
//         return "move";
//     }
//     if (lookSynonyms[i].equals(input)) {
//         return "look";
//     }
//     if (inspectSynonyms[i].equals(input)) {
//         return "inspect";
//     }
//     if (inscriptionSynonyms[i].equals(input)) {
//         return "inscription";
//     }
//     if (tableSynonyms[i].equals(input)) {
//         return "table";
//     }
// }
// if (input.equals("up")) {
//     return "north";
// }
// if (input.equals("right")) {
//     return "east";
// }
// if (input.equals("down")) {
//     return "south";
// }
// if (input.equals("left")) {
//     return "west";
// }
// return input;