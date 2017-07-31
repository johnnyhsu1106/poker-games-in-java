public class Card {
    
    private String rank, //String variable to capture the face vallue
                         //of any card
                   suit; //String variable to capture the suit value 
                         //of any card
  
    private int rankNumber, //Int variable to capture the integer face value
                         //of any card
             suitNumber; //Int variable to capture the suit value of any
                         //card

    //AF: "rank" refers to the displayed string face value of a card.
    //"suit refers to the displayed string value of a card.
    //"rankNumber" refers to the integer face value of a card used for hand
    // strength comparisons.
    //"suitNumber" refers to the integer suit value, used to find out if a 
    //hand is a flush.
    //RI: rank and suit should not be nil. rankNumber should be between 2 and 
    //14. suitNumber should be between 1 and 4.

    //AF implementation, allows a user to print the contents of a Card object.

    public Card(){
        //Default construtor. Creates an empty null card.
    } 
     

    public Card(String suit, String rank, int suitNumber, int rankNumber){
        //Constructor used by the deck object to instantiate new cards. Sets the
        //rank string value, suit string value, rankNumber integer value,
        //and suitNumber integer value for each card.
        this.suit = suit;
        this.rank = rank;
        this.suitNumber = suitNumber;
        this.rankNumber = rankNumber;        
    } 

    public String getRank(){
        //Getter to return a Card object's rank String.
        return this.rank;
    }

    public String getSuit(){
        //Getter to return a Card object's suit String.
        return this.suit;
    }

    public int getRankNumber(){
        //Getter to return a Card object's integer rankNumber.
        return this.rankNumber;
    }

    public int getSuitNumber(){
        //Getter to return a Card object's integer suitNumber.
        return this.suitNumber;
    }
    
    public void setRankNumber(int rankNum){
        //Setter to set a Card obects's rankNumber.
        this.rankNumber = rankNumber;
    }

    public String toString(){
    return(this.rank + String.valueOf(this.suit.charAt(0)));
    /*toString implementation used for fine testing of cards
    return (rank + " of " + suit + ". Has a integer rank value of " + rankNumber + 
                       " and a integer suit value of " + suitNumber + ".");
                       */
    }     
     
    //RI implementation of a Card object to validate that the contents of 
    //a card object are logically correct.      
    public boolean repOK(){
        //RI implementation of a Card object to validate that the contents of 
        //a card object are logically correct.  
        return ((this.rankNumber >= 2 && this.rankNumber <= 14) &&
              (this.suitNumber >= 1 && this.suitNumber <= 4) &&
              (this.suit != null && this.rank != null));
    }  
     
}