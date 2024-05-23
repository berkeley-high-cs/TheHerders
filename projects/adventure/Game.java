import java.util.Scanner;

public class Game {

    public final static boolean debug = true;

    private static boolean end = false;
    public static Room[][] map = new Room[3][3];
    public Game(){
       map[0][0] = new Room ("You see a butchers table, with assorted rotting meat on top. It doesnt look like any meat you recognize. You see a hallway to the east. ", 0, 0); //choices take meat, then add description where key is below meat. move east
       map[0][1] = new Room ("You see a locked chest in the middle of the room. ", 0, 1);
       map[0][2] = new Room("", 0, 2); //no room
       map[1][0] = new Room("", 1, 0);  //no room
       map[1][1] = new Room("You are in a grand hallway, with large arched door to the north, east, and south. There is an inscription on one of the doorways. ", 1, 1); //just move and read
       map[1][2] = new Room("You are in a throne room, long forgotten. The ground is dusty, and the throne has cobwebs on it. Not cozy. The only doorway is the one you came from. ", 1, 2); //look throne will find the chest behind, or look behind
       map[2][0] = new Room("You encounter a goblin! He hasn't noticed you yet because he is eating some miscellaneous meat. ", 2, 0);
       map[2][1] = new Room("You see a huge oaken door, with a large keyhole in the middle. It seems the only way to get out. There is a dank smell coming from the west door. The only other door is the one to the grand hall. ", 2, 1);
       map[2][2] = new Room("", 2, 2); //no room
       map[0][0].addChoice(new Choice.Move("east"));
       map[0][1].addChoice(new Choice.Move("west"));
       map[0][1].addChoice(new Choice.Move("south"));
       map[1][1].addChoice(new Choice.Move("north"));
       map[1][1].addChoice(new Choice.Move("east"));
       map[1][1].addChoice(new Choice.Move("south"));
       map[1][2].addChoice(new Choice.Move("west"));
       map[2][0].addChoice(new Choice.Move("east"));
       map[2][1].addChoice(new Choice.Move("north"));
       map[2][1].addChoice(new Choice.Move("west"));


       Item meatTable = new Item("table", "immovableMeatTable", "You disgustingly look under the rotten weird meat. Under the piles of meat, blood, and stench, ");
       meatTable.addDescription("you find a key. ");
       
       map[0][0].addItem(meatTable);
       Item meat = new Item("meat", "foodMeat", "The meat looks gross and disgusting. Nobody should ever eat it. ");
       meat.addDescription("Under the meat, you find a key. ");
       map[0][0].addItem(meat);
       Item meatKey = new Item("key", "meatKey", "The key is covered in rotting meat. Gross. ");
       map[0][0].addItem(meatKey);
       meatTable.addItemRefrenced(meatKey); //two way street
       meat.addItemRefrenced(meatKey); //two way street
       meatTable.addItemRefrenced(meat);
        
       map[0][1].addDescription("You see a hallway to the west, with a foul smell coming from inside. You see a hallway south. "); 
       Item meatChest = new Item("chest", "immovableMeatChest", "The chest looks relatively normal, albeit gross. The keyhole has bits of rotting meat in it. Gross. ");
       meatChest.addDescription("The chest is securely shut.");
       meatChest.addItemRefrenced(meatKey);
       map[0][1].addItem(meatChest); //add sword once meat key is used on meat chest
       map[0][1].addChoice(new Choice.Use(meatKey));

       map[1][1].addItem(new Item("inscription", "immovableInsciption",  "The text reads: " + "\n" +
                                                                                            "The keys three you will need " + "\n" +
                                                                                            "from butchers table cleaned to chest " + "\n" +
                                                                                            "the one that bleeds has another " + "\n" +
                                                                                            "and behind the throne secrets smothered "));

       Item throne = new Item("throne", "immovableThrone", "The dusty throne has something large behind it. As you get close, it looks to be a large chest, that is also quite dusty. ");
       Item dustyChest = new Item("chest", "immovableDustyChest", "The chest is very dusty, with cobwebs all around it. It looks like it hasnt been touched in ages. ");
       dustyChest.addDescription("The chest is securely shut. ");
       map[1][2].addItem(throne);
       map[1][2].addItem(dustyChest);
        //TODO: add combat, then once they inspect alive goblin just say you cant, hes agressive. 
        //once they attack with sword, have goblin just die? but if the attack without then you die and restart
        //add attack? or say use sword
        //is goblin item or new class
       //this one is differet, deal with later
       map[2][0].addDescription("It smells dank in here. The only doorway is the one you came from. ");
       Item goblin = new Item("goblin", "immovableMonsterGoblin", "He smells dank. His loincloth has pockets in it. Fancy");
       map[2][0].addItem(goblin);

       Item grandDoor = new Item("door", "immovableDoor", "The keyhole is huge and dusty, and the door seems unbreakable. ");
       grandDoor.addDescription("The door is securely shut. ");
       map[2][1].addItem(grandDoor);
       
       
    }
    public static void main(String[] args){
        Game game = new Game();
        Player player = new Player(map[1][1]);
        game.startShow();
        game.gameLoop(player);
    }
    public void gameLoop(Player player){
        player.getLocation().look();
    
        while (!end){
            player.getLocation().callChoiceConsequence(getPlayerChoiceName(player), player);
        }
        
        
    }
    public String getPlayerChoiceName(Player player){ // change for gui
        Normalize normalize = new Normalize();
        System.out.println("What do you want to do?");
        System.out.println(" "); // for formatting
        Scanner scanner = new Scanner(System.in);
        String choiceName = scanner.nextLine().toLowerCase();
        choiceName = normalize.normalizeInput(choiceName);
        //special case that need player info
        if (choiceName.equals("inspect") && player.getLocation().isAt(1,1)){
            choiceName += " inscription";
        }
        //end of special case
        if (isUnderstood(choiceName, player.getLocation())){
           return choiceName;
        } else {
            System.out.println(" "); // for formatting
            System.out.println("Sorry, I didnt understand that, please try again");
            System.out.println(" "); // for formatting
            return getPlayerChoiceName(player);
        }
    }
    public boolean isUnderstood(String choiceName, Room location){
        return location.hasChoice(choiceName);
    }
    public void startShow(){ //change for gui
        System.out.print("\033[2J\033[1;1H");
        System.out.println("submit choice as always being of the form VERB NOUN like, “inspect insription”, “move west”, etc.");
        System.out.println(" "); // for formatting
    }
    public static Room[][] getMap(){
        return map;
    }
    public static void end(){
        end = true;
    }
    

}