public class Choice {
    private String choiceName;

    public Choice(String choiceName) {
        this.choiceName = choiceName;
    }

    public String getName() {
        return choiceName;
    }

    public void callConsequence(Player player) {
        System.out.println("you arent really supposed to call me, callConsequence");
        return; // just for other methods to change
    }

    public static class Look extends Choice {
        public Look() {
            super("look");
        }

        public void callConsequence(Player player) {
            System.out.println(""); // for formatting
            player.getLocation().look();
            System.out.println(""); // for formatting
        }
    }

    public static class Inspect extends Choice {
        private String textName;
        private String text;

        public Inspect(String textName, String text) {
            super("inspect " + textName);
            this.textName = textName;
            this.text = text;
        }

        public void callConsequence(Player player) {
            System.out.println(""); // for formatting
            System.out.println(text);
            System.out.println(""); // for formatting
        }
    }

    public static class Move extends Choice {
        private String direction; // all lowercase, north south east west

        public Move(String direction) {
            super("move " + direction);
            this.direction = direction;
        }

        public void callConsequence(Player player) {
            switch (direction) {

                case "north":
                    player.changeLocation(
                            Game.getMap()[player.getLocation().getMapRow() - 1][player.getLocation().getMapCol()]);// move
                                                                                                                   // player
                                                                                                                   // north
                    showPlayerLocation(player);
                    break;

                case "east":
                    player.changeLocation(
                            Game.getMap()[player.getLocation().getMapRow()][player.getLocation().getMapCol() + 1]);
                    showPlayerLocation(player);
                    break;

                case "south":
                    player.changeLocation(
                            Game.getMap()[player.getLocation().getMapRow() + 1][player.getLocation().getMapCol()]);
                    showPlayerLocation(player);
                    break;

                case "west":
                    player.changeLocation(
                            Game.getMap()[player.getLocation().getMapRow()][player.getLocation().getMapCol() - 1]);
                    showPlayerLocation(player);
                    break;

                default:
                    System.out.println("Error, direction not understood");
            }
        }

        public void showPlayerLocation(Player player) { // change for gui
            player.getLocation().callChoiceConsequence("look", player); // print out what the room they are in looks
                                                                        // like
        }
    }

    public static class Take extends Choice {
        private Item item;

        public Take(Item item) {
            super("take " + item.getItemName());
            this.item = item;
        }

        public void callConsequence(Player player) {
            if (player.getLocation().hasItem(item)) {
                if (item.isType("immovable")) {
                    System.out.println(""); // formatting
                    System.out.println("You can't take the " + item.getItemName() + ", it's immovable");
                    System.out.println(""); // formatting
                    // maybe add something to say you cant take that later
                } else {
                    player.addToInventory(item);
                    player.getLocation().removeItem(item);
                    System.out.println(""); // formatting
                    System.out.println("You take the " + item.getItemName());
                    System.out.println(""); // formatting
                    if (item.isType("meatKey")) {
                        if (item.findItemRefrenced("meat") == null){ //having meat on table or not changes description
                            changeRefrencedItemDescription(item, "MeatTable", "key", "you find more meat. ");
                        } else {
                            changeRefrencedItemDescription(item, "MeatTable", "key", "you find a blood stained marble slab. ");
                        }
                        
                        changeRefrencedItemDescription(item, "foodMeat", "key", "");
                        item.removeItemRefrenced("MeatTable");
                        item.removeItemRefrenced("Meat");
                    } 
                    if (item.isType("sword")){
                        player.getLocation().changeDescription("You see an open chest. ", player.getLocation().findKeyWordInRoom("chest"));
                        changeRefrencedItemDescription(item, "MeatChest", "sword", "");
                    }
                    if (item.isType("Meat") && !item.isType("key")){
                        if (item.findItemRefrenced("meatKey") != null){ //if the key is there difference
                            System.out.println("Under the meat, you see a key.");
                            System.out.println("");//formatting
                            player.getLocation().changeDescription("You see a butchers table. On the bloody marble slab you see a key. ", player.getLocation().findKeyWordInRoom("meat"));
                        } else {
                            player.getLocation().changeDescription("You see a butchers table. ", Math.max(0, player.getLocation().findKeyWordInRoom("meat")));
                        }
                       
                        changeRefrencedItemDescription(item, "MeatTable", "meat", "On the bloody table ");
                        item.removeItemRefrenced("MeatTable");
                        item.removeItemRefrenced("meatKey");
                    }
                    if (item.isType("giantKey")){
                        item.findItemRefrenced("dustyChest").changeDescription(item.findItemRefrenced("dustyChest").findKeyWordInDescription("ages"), "The chest is very dusty, with cobwebs everywhere you didnt clean them off. You see your fingerprints on the top. ");
                        item.findItemRefrenced("dustyChest").changeDescription(item.findItemRefrenced("dustyChest").findKeyWordInDescription("key"), "");
                    }
                }
            } else

            {
                System.out.println(""); // formatting
                System.out.println("There is no " + item);
                System.out.println(""); // formatting
            }

        }

        public void changeRefrencedItemDescription(Item item, String wantedItemType, String keyword,
                String newDescription) {
                    Item itemRefrenced = item.findItemRefrenced(wantedItemType);
            if (itemRefrenced != null) {
                if (itemRefrenced.findKeyWordInDescription(keyword) != -1) {
                    if (Game.debug){
                        System.out.println("Find item refrenced worked");
                    }
                    
                    itemRefrenced.changeDescription(itemRefrenced.findKeyWordInDescription(keyword), newDescription);

                }
            }
        }
    }

    public static class Use extends Choice {

        private Item itemUsed;

        public Use(Item itemUsed){
            super("use " + itemUsed.getItemName());
            this.itemUsed = itemUsed;
     }
     public void callConsequence(Player player){ //only key into chest for now
        if (player.getInventory().contains(itemUsed)){
            if (itemUsed.isType("key")){
                if (itemUsed.isType("meat")){
                    if (player.getLocation().isAt(0, 1)){
                        System.out.println(""); //for formatting
                        System.out.println("You insert the key with meat on it into the hole. It's a perfect fit. As it opens you see the faint glow of a great blade. "); 
                        System.out.println(""); //for formatting
                        Item sword = new Item("sword", "sword", "It glows faintly blue. It looks sharp");
                        sword.addItemRefrenced(itemUsed.findItemRefrenced("MeatChest"));
                        player.getLocation().addItem(sword);
                        changeRefrencedItemDescription(itemUsed, "MeatChest", "shut", "The chest is open. ");
                        itemUsed.findItemRefrenced("MeatChest").addDescription("There is a sword inside. It glows faintly. ");
                        player.getInventory().remove(itemUsed);
                        player.getLocation().changeDescription("You see an open chest with a sword inside. ", player.getLocation().findKeyWordInRoom("chest"));
                        
                    }
                }
                if (itemUsed.isType("dusty")){
                    if (player.getLocation().isAt(1,2)){
                        System.out.println(""); //for formatting
                        System.out.println("You insert the dusty key into the chest behind the throne. It's a perfect fit. As it opens you see a massive key. "); 
                        System.out.println(""); //for formatting
                        Item tempGiantKey = itemUsed.findItemRefrenced("dustyChest").findItemRefrenced("giantKey");
                        tempGiantKey.addItemRefrenced(itemUsed.findItemRefrenced("dustyChest"));
                        player.getLocation().addItem(tempGiantKey);
                        changeRefrencedItemDescription(itemUsed, "dustyChest", "shut", "The chest is open. ");
                        itemUsed.findItemRefrenced("dustyChest").addDescription("There is a massive key inside. ");
                        player.getInventory().remove(itemUsed);
                    }
                }
                if (itemUsed.isType("giant")){
                    if(player.getLocation().isAt(1, 2)){
                        System.out.println(""); //for formatting
                        System.out.println("You heave the giant key into the giant keyhole. You push it and get it to turn. The doors slightly open as you see daylight for the first time in years. You win."); 
                        System.out.println(""); //for formatting
                        System.out.println("You got the normal ending.");
                        Game.end();
                    }
                }
            }
        } else {
            System.out.println(""); //for formatting
            System.out.println("You dont have that. "); 
            System.out.println(""); //for formatting
        }
      
     }
     public void changeRefrencedItemDescription(Item item, String wantedItemType, String keyword,
                String newDescription) {
            if (item.findItemRefrenced(wantedItemType) != null) {
                if (item.findItemRefrenced(wantedItemType).findKeyWordInDescription(keyword) != -1) {
                    // System.out.println("we found it");
                    item.findItemRefrenced(wantedItemType).changeDescription(
                            item.findItemRefrenced(wantedItemType).findKeyWordInDescription(keyword), newDescription);

                }
            }
        }
    }
    public static class Attack extends Choice {
        private Item monster;
        public Attack(Item monster){
            super("attack " + monster.getItemName());
            this.monster = monster;
        }
        public void callConsequence(Player player){
            System.out.println(""); //for formatting
            if (monster.isType("monster")){
                if (monster.isType("goblin")){
                    if(player.hasItem("sword")){
                        System.out.println("You attack the " + monster.getItemName() + ". It tries to dodge but it's barely within your reach. You lop off its head and it falls to the floor. Thud. Blood splatters all over your shirt. ");
                        player.getLocation().removeItem(monster);
                        Item deadGoblin = new Item("goblin", "foodGoblin", "Its a dead goblin. He's wearing a now bloody loincloth. Inside of the loincloths pockets, you find a key.");
                        player.getLocation().addItem(deadGoblin);
                        
                        monster.findItemRefrenced("dustyChest").addItemRefrenced(monster.findItemRefrenced("dustyKey"));
                        player.getLocation().addItem(monster.findItemRefrenced("dustyKey"));
                        player.getLocation().changeDescription("There is a dead goblin on the floor. His head is about two feet from his body. ", player.getLocation().findKeyWordInRoom("goblin"));
                    } else {
                        System.out.println("You swing at the " + monster.getItemName() +  ", it dodges just barely out of the way. It's angry now. It comes and shanks you 5 times. You go down biting and scratching. You die.");
                        System.out.println(""); //formating
                        System.out.println("You got the bad ending.");
                        Game.end();
                    }
                    
                }
            } else {
                
                if (player.hasItem("sword")){
                    System.out.println("Okay? You slice and scratch the " + monster.getItemName() + ". It gets pretty scratched up and so does your sword. ");
                } else {
                    System.out.println("Okay? You bite and punch and scratch the " + monster.getItemName() + ". It gets pretty scratched up and so do your teeth. Ouch. ");
                }
                
            }
            System.out.println(""); //for formatting
        }

    }
  
}




//possible debug class choice
  // public static class Hack extends Choice {
    //     private Item itemHacked;
    //     public Hack(Item itemHacked){
    //         super("hack " + itemHacked.getItemName());
    //         this.itemHacked = itemHacked;
    //     }
    //     public void callConsequence(Player player){
    //         if (Game.debug){
    //             player.addToInventory(itemHacked);
    //             System.out.println(""); //formatiing
    //             System.out.println(itemHacked + " hacked, be careful");
    //             System.out.println(""); //formatiing
    //         } else {
    //             System.out.println(""); //formatiing
    //             System.out.println("Your not in debug mode!");
    //             System.out.println(""); //formatiing
    //         }
    //     }
    // }