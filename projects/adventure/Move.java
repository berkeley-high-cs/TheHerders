public class Move extends Choice {
    private int direction; //0 north, 1 east, 2 south, 3 west
    public Move(int direction){
        super("move");
        this.direction = direction;
    }
    public void callConsequence(Player player){
        switch(direction){
            case 0: player.changeLocation(); //to work on
        }
    }
}
