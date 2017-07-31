public class FiveCardDraw extends PokerGame{
    public FiveCardDraw(){
        super();
    }
    public FiveCardDraw(BettingStructure bettingStructure, GameType gameType){
        super(bettingStructure, gameType);
        this.numPlayerCards = 5;
        this.numCommunityCards = 0;
    }

    public String toString(){
        String result = "";
        result = "This is a Five Card Draw game.";
        result += "Each player gets " + this.numPlayerCards + " cards"; 
        result += "and there are " + this.numCommunityCards + " community cards.\n";
        result +=  this.gameType + " " + this.bettingStructure;
        return result;
    }
}