public class Omaha extends PokerGame{
    
    public Omaha(){
        super();

    }

    public Omaha(BettingStructure bettingStructure, GameType gameType){
        super(bettingStructure, gameType);
        this.numPlayerCards = 4;
        this.numCommunityCards = 5;
   
    }

    public String toString(){
        String result = "";
        result = "This is a Omaha game.";
        result += "Each player gets " + this.numPlayerCards + " cards"; 
        result += "and there are " + this.numCommunityCards + " community cards.\n";
        result +=  this.gameType + " " + this.bettingStructure;
        return result;
    }
}
