public class SevenCardStud extends PokerGame{
    
    public SevenCardStud(){
        super();
    }
    public SevenCardStud(BettingStructure bettingStructure, GameType gameType){
        super(bettingStructure, gameType);
        this.numPlayerCards = 7;
        this.numCommunityCards = 0;
    
    }

    public String toString(){
        String result = "";
        result = "This is a Seven Card Stud game.";
        result += "Each player gets " + this.numPlayerCards + " cards"; 
        result += "and there are " + this.numCommunityCards + " community cards.\n";
        result +=  this.gameType + " " + this.bettingStructure;
        return result;
    }
}