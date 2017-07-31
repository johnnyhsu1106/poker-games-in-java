public abstract class PokerGame{
	int numPlayerCards;
	int numCommunityCards;
	BettingStructure bettingStructure;
	GameType gameType;

	public PokerGame(){

	}

  	public PokerGame(BettingStructure bettingStructure, GameType gameType){
	    this.gameType = gameType;
	    this.bettingStructure = bettingStructure;
  	}

	public int getNumPlayerCards(){
		return this.numPlayerCards;
	}

	public int getNumCommunityCards(){
		return this.numCommunityCards;
	}

	public GameType getGameType(){
		return this.gameType;
	}
	public void setGameType(GameType gameType){
		this.gameType = gameType;
	}

	public BettingStructure getBettingStructure(){
		return this.bettingStructure;
	}

	public void setBettingStructure(BettingStructure bettingStructure){
		this.bettingStructure = bettingStructure;
	}

	public abstract String toString();

	public boolean repOK(){
		return (numPlayerCards > 0 && numCommunityCards >= 0 && bettingStructure != null && gameType != null);
	}

}