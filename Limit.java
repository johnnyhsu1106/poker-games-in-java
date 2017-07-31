public class Limit extends BettingStructure{

    public Limit(){
        //Default constructor for "Limit" type objects.
    }

    public Limit(double smallBlind, double bigBlind){
        //Constructor for "Limit" type objects that sets the big and small blinds.
        this.smallBlind = smallBlind;
        this.bigBlind = bigBlind;
    }

    public String toString(){
        //AF implementation for the "Limit" class.
        return ("\"Limit\" Table with Big Blind: " + bigBlind + " - Small Blind: " + smallBlind + "\n");
    }

    public boolean repOK(){
        //RI implementation for the "Limit" class.
        return bigBlind >=0 && smallBlind >= 0;
    }

}