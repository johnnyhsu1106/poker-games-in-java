public class TexasHoldEm extends PokerGame{
    public TexasHoldEm(){
        super();
    }
    public TexasHoldEm(BettingStructure bettingStructure, GameType gameType){
        super(bettingStructure, gameType);
        this.numPlayerCards = 2;
        this.numCommunityCards = 5;
    }

    public String toString(){
        String result = "";
        result = "This is a Texas Hold 'Em game.\n";
        result += "Each player gets " + this.numPlayerCards + " card(s) ";
        result += "and there are " + this.numCommunityCards + " community card(s).\n";
        result +=  "Game Type: " + this.gameType + "\nBetting Structure: " + this.bettingStructure + "\n";
        return result;
    }
}