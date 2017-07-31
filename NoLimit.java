public class NoLimit extends BettingStructure{

    public NoLimit(){
        //Default constructor for "NoLimit" type objects.
    }

    public NoLimit(double smallBlind, double bigBlind){
        //Constructor for "Limit" type objects that sets the big and small blinds.
        this.smallBlind = smallBlind;
        this.bigBlind = bigBlind;
    }

    public String toString(){
        //AF implementation for the "Limit" class.
        return ("\"No-Limit\" Table with Big Blind: " + this.bigBlind + " - Small Blind: " + this.smallBlind + "\n");
    }

    public boolean repOK(){
        //RI implementation for the "Limit" class.
        return this.bigBlind >=0 && this.smallBlind >= 0;
    }

}