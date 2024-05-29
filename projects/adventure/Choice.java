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
                        if (Game.debug){
                            System.out.println("MEATT DEBUGGING x x xx x xx xxx. xx. xx. xx x. x x x ");
                            System.out.println("item.findItemRefrenced(meat): " + item.findSpecificItemRefrenced("foodMeat"));
                            System.out.println("MEATT DEBUGGINGx. xx x x x.  xx. xx. xx. xx. x x xx ");
                        }
                        if (item.findSpecificItemRefrenced("foodMeat") != null){ //having meat on table or not changes description
                            changeRefrencedItemDescription(item, "MeatTable", "key", "you find more meat. ");
                        } else {
                            changeRefrencedItemDescription(item, "MeatTable", "key", "you find a blood stained marble slab. ");
                            player.getLocation().changeDescription("You see a butchers table. There is nothing on its bloody marble slab. ", player.getLocation().findKeyWordInRoom("key"));
                        }
                        
                        changeRefrencedItemDescription(item, "foodMeat", "key", "");
                        item.removeItemRefrenced("MeatTable");
                        item.removeSpecificItemRefrenced("foodMeat");
                    } 

                    if (item.isType("sword")){
                        player.getLocation().changeDescription("You see an open chest. ", player.getLocation().findKeyWordInRoom("chest"));
                        changeRefrencedItemDescription(item, "MeatChest", "sword", "");
                        item.removeItemRefrenced("MeatChest");
                    }

                    if (item.isType("Meat") && !item.isType("key")){ 

                        changeRefrencedItemDescription(item, "MeatTable", "meat", "On the bloody table ");
                        
                        if (item.findSpecificItemRefrenced("meatKey") != null){ //if the key is there difference
                            System.out.println("Under the meat, you see a key.");
                            System.out.println("");//formatting
                            player.getLocation().changeDescription("You see a butchers table. On the bloody marble slab you see a key. ", player.getLocation().findKeyWordInRoom("meat"));
                        } else {
                            player.getLocation().changeDescription("You see a butchers table. Its top is a bloody marble slab. ", Math.max(0, player.getLocation().findKeyWordInRoom("key")));
                        }
                        if (item.findSpecificItemRefrenced("meatKey") != null){ //having key on table or not changes description
                            changeRefrencedItemDescription(item, "MeatTable", "on", "On the bloody marble slab ");
                        } else {
                           changeRefrencedItemDescription(item, "MeatTable", "meat", "you find a blood stained marble slab. ");
                        }
                       
                        item.removeItemRefrenced("MeatTable");
                        item.removeItemRefrenced("meatKey");
                    }

                    if (item.isType("giantKey")){
                        item.findItemRefrenced("dustyChest").changeDescription(item.findItemRefrenced("dustyChest").findKeyWordInDescription("ages"), "The chest is very dusty, with cobwebs everywhere you didnt clean them off. You see your fingerprints on the top. ");
                        item.findItemRefrenced("dustyChest").changeDescription(item.findItemRefrenced("dustyChest").findKeyWordInDescription("key"), "");
                    }

                    if(item.isType("goblin")){
                        player.getLocation().changeDescription("", player.getLocation().findKeyWordInRoom("goblin"));
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
                        
                    } else if (Game.debug){
                        System.out.println("wrong key used prolly");
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
                    if(player.getLocation().isAt(2, 1)){
                        if (Game.goodEnding){
                            System.out.println(""); //for formatting
                            System.out.println("You heave the giant key into the giant keyhole. You push it and get it to turn. The doors slightly open as you see daylight for the first time in years. You leave with the good thoughts of the goblin in your head. You win. "); 
                            System.out.println(""); //for formatting
                            System.out.println("You got the good ending.");
                            Game.end();
                        } else {
                        System.out.println(""); //for formatting
                        System.out.println("You heave the giant key into the giant keyhole. You push it and get it to turn. The doors slightly open as you see daylight for the first time in years. You leave with blood on your hands, a bloody sword, and a bloody conscience. Have you really won?"); 
                        System.out.println(""); //for formatting
                        System.out.println("You got the normal ending.");
                        Game.end();
                        }
                        
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
                        System.out.println("You attack the " + monster.getItemName() + ". It tries to wake up to dodge but it's barely too late. You lop off its head and it falls to the floor. Thud. Blood splatters all over your shirt. ");
                        player.getLocation().removeItem(monster);
                        Item deadGoblin = new Item("goblin", "foodGoblin", "Its a dead goblin. He's wearing a now bloody loincloth. Inside of the loincloths pockets, you find a key.");
                        player.getLocation().addItem(deadGoblin);
                        deadGoblin.addItemRefrenced(monster.findItemRefrenced("dustyKey"));
                        
                        monster.findItemRefrenced("dustyChest").addItemRefrenced(monster.findItemRefrenced("dustyKey"));
                        player.getLocation().addItem(monster.findItemRefrenced("dustyKey"));
                        player.getLocation().changeDescription("There is a dead goblin on the floor. His head is about two feet from his body. ", player.getLocation().findKeyWordInRoom("goblin"));
                        player.getLocation().addChoice(new Choice.Eat(deadGoblin));
                    } else {
                        System.out.println("You swing at the " + monster.getItemName() +  ", it wakes up and dodges just barely out of the way. It's angry now. It comes and shanks you 5 times. You go down biting and scratching. You die.");
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
    public static class Eat extends Choice {
        private Item itemAte;
        public Eat(Item itemAte){
            super("eat " + itemAte.getItemName());
            this.itemAte = itemAte;
        }
        public void callConsequence(Player player){
            System.out.println(""); //formatting
            if (itemAte.isType("food")){
                
                    if (itemAte.isType("goblin")){
                        if (player.hasItem(itemAte.getItemType())){
                            if (itemAte.findItemRefrenced("dustyKey") != null){
                            System.out.println("You eat the dead goblin. ewww. As you bite down on its leg you find something hard. Its a key.");
                            if (player.getLocation().isAt(2,0)){
                                player.getLocation().changeDescription("The only thing left of the goblin is his tunic and his key. You have devoured him. ", player.getLocation().findKeyWordInRoom("goblin"));
                            }
                            } else {
                            System.out.println("You eat the dead goblin. ewww. Theres is blood and guts all over your tunic. ");
                            if (player.getLocation().isAt(2,0) ){
                                player.getLocation().changeDescription("The only thing left of the goblin is his tunic and his blood. You have devoured him. ", player.getLocation().findKeyWordInRoom("goblin"));
                            }
                            }
                            
                           
                            player.removeFromInventory(itemAte.getItemType());
                        }  else if (player.getLocation().isAt(2, 0) && player.getLocation().hasItem(itemAte)){ //for goblin on floor
                            if (itemAte.findItemRefrenced("dustyKey") != null){
                                System.out.println("You eat the dead goblin. ewww. As you bite down on its leg you find something hard. Its a key.");
                                player.getLocation().changeDescription("The only thing left of the goblin is his tunic and his key. You have devoured him. ", player.getLocation().findKeyWordInRoom("goblin"));
                                } else {
                                System.out.println("You eat the dead goblin. ewww. Theres is blood and guts all over your tunic. ");
                               
                                player.getLocation().changeDescription("The only thing left of the goblin is his tunic and his blood. You have devoured him. ", player.getLocation().findKeyWordInRoom("goblin"));
                                }
                                
                                player.getLocation().removeItem(itemAte);
                        }
                
                }
                if (itemAte.isType("meat")){
                    if (player.hasItem(itemAte.getItemType())){
                        System.out.println("You eat the rotting meat. ewww. As you bite down on the gushy meat, you almost vomit. ");
                        player.removeFromInventory(itemAte.getItemType());

                    }  else if (player.getLocation().isAt(0, 0) && player.getLocation().hasItem(itemAte)){ //for meat on table
                        if (itemAte.findItemRefrenced("meatKey") != null){
                            System.out.println("You eat the rotting meat. ewww. As you bite down on the gushy meat, you bite something hard. Its a key.");
                            player.getLocation().changeDescription("You see a butchers table. On the bloody marble slab you see a key. ", player.getLocation().findKeyWordInRoom("meat"));
                            itemAte.removeItemRefrenced("meatKey");
                            } else {
                            System.out.println("You eat the rotting meat. ewww. As you bite down on the gushy meat, you almost vomit. ");
                            player.getLocation().changeDescription("You see a butchers table. Its top is a bloody marble slab. ", Math.max(0, player.getLocation().findKeyWordInRoom("key")));
                            
                            }
                            if (itemAte.findSpecificItemRefrenced("meatKey") != null){ //having key on table or not changes description
                                changeRefrencedItemDescription(itemAte, "MeatTable", "on", "On the bloody marble slab ");
                            } else {
                               changeRefrencedItemDescription(itemAte, "MeatTable", "meat", "you find a blood stained marble slab. ");
                            }
                            itemAte.removeItemRefrenced("MeatTable");
                            player.getLocation().removeItem(itemAte);
                    }

                    
                    
                }
               
            } else {

            }
            System.out.println(""); //formatting
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
    public static class Give extends Choice {
        private Item itemGiven;

        public Give(Item itemGiven){
            super("give " + itemGiven.getItemName());
                this.itemGiven = itemGiven;
            
        }
        public void callConsequence(Player player){
            if (itemGiven.isType("meat") && !itemGiven.isType("key")){
                if (player.getLocation().isAt(2, 0) && player.getLocation().hasItem(itemGiven.findItemRefrenced("goblin")) && player.hasItem(itemGiven.getItemType())){
                    System.out.println("");//formatting
                    System.out.println("You gently wake up the goblin, and with the smell of the meat he so loves, it brings tears to his eyes. He gives you his key, takes the meat, and promptly vanishes because i dont want to code more. ");
                   
                   
                    System.out.println("");//formatting
                    player.addToInventory(itemGiven.findItemRefrenced("goblin").findItemRefrenced("dustyKey"));
                    player.removeFromInventory("meat");
                    player.getLocation().changeDescription("You realize the only trace left of the goblin in the room is his tears, from your good deed. ", player.getLocation().findKeyWordInRoom("goblin"));
                    Game.goodEnding();
                }
            }
            
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