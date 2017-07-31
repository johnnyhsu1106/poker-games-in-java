import java.util.*;

public abstract class Dealer extends Observable{

    protected Deck deck;
    protected Table table;
    protected String name;
    protected PokerGame pokerGame;
    protected ArrayList<Player> activePlayers;

    // In Dealer Class, activePlayers is a list of players for this round of game.
    // for each stage (preflop, flop, turn, river, the activePlayers means those player with player hand, which means unfold their hand)
    // In each stage, the number of activePlayer may change because some player may fold their hands.
    // In Table Class, the currentPlayers means those player who's in the game in the begining of this round(preflop)
    // In Table Class, the players are those player who put chips on table, but not in the game for this round. (not exit the table)

    public Dealer(){
        this.name = null;
        this.deck = null;
        this.table = null;
        this.pokerGame = null;
    }

    public Dealer(String name){
        this.name = name;
        this.deck = null;
        this.table = null;
        this.pokerGame = null;
    }

    public void setPokerGame(PokerGame pokerGame){
        this.pokerGame = pokerGame;
    }

    public PokerGame getPokerGame(){
        return this.pokerGame;
    }

    public abstract void startHands();
        // Each different type of Dealer has his/her own way to start hands based on the game type

    public void burnCard(){
        // Burn Card
        getCard();
    }

    public void dealCommunityCard(){
    // This is for Texas Hold'em and Omaha. For Poker Game are 7 Card Stud or 5 Card Draw. it won't be executed.
        if(this.pokerGame.getNumCommunityCards() > 0){
        // Get a card from deck
        Card communityCard = getCard();
        // Add this card to community card
        this.table.getCommunityCards().setCard(communityCard);

        setChanged();
        notifyObservers();
        }
    }

    private void moveButton(){
        this.table.moveButton();
    }

    public ArrayList<Player> getWinners(){
        // Return an ArrayList containing the game's winner(s).
        ArrayList<Player> winners = new ArrayList<Player>(this.activePlayers);
        for(int i = 0; i < winners.size(); i++ ){
        	if( (i+1) < winners.size() )
        		for(int j = i+1; j < winners.size(); j++ ){
        			if( (winners.get(i).getPokerHand()).compareTo(winners.get(j).getPokerHand()) > 0 ){
        				winners.remove(j);
        				j--;
        			}
        			else if( (winners.get(i).getPokerHand()).compareTo(winners.get(j).getPokerHand()) < 0 ){
        				winners.remove(i);
        				i--;
        				break;
        			}
        		}
        }

        //Divide the pot equally to all winners.
        double currentNumWinner = winners.size();
        
        for (int i = 0; i < currentNumWinner; i++){
            double amount = this.table.getPot()/currentNumWinner;
            winners.get(i).winPot(amount);
        }

        //Clear the table pot and all player bets.  Game has completed.
        this.table.clearPot();
        this.table.clearCommunityHand();
        clearBets();

        return winners;
    }

    public void clearBets(){
        for (int i = 0; i < activePlayers.size(); i++){
        	this.activePlayers.get(i).setBet(0.0);
        	this.activePlayers.get(i).clearPlayerHand();
        }
    }

    public Card getCard(){
        return this.deck.getCard();
    }

    public void shuffleDeck(){
        this.deck.shuffleDeck();
    }

    public Deck getDeck(){
        return this.deck;
    }

    // set a new Deck
    public void setDeck(){
        this.deck = new Deck();
    }

    public Table getTable(){
        return this.table;
    }

    public void setTable(Table table){
        this.table = table;
        setActivePlayers();
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getAnte(){
        return this.pokerGame.getGameType().getAnte();
    }

    public double getSmallBlind(){
        return this.pokerGame.getBettingStructure().getSmallBlind();
    }

    public double getBigBlind(){
        return this.pokerGame.getBettingStructure().getBigBlind();
    }

    public void getAnteFromPlayer(){
        // Get the ante from each player and add thess ante into pot.
        double totalAnte = 0;
        for(int i = 0; i < this.table.getCurrentPlayers().size(); i++ ){
            totalAnte += this.table.getCurrentPlayers().get(i).bet(getAnte());
        }
        this.table.addPot(totalAnte);
    }

    public void getBlindsFromPlayer(){
        // In the begining of each round, dealer will get the small blind and big blind from two players at SB position and BB position.
        // Players is a array list = [player1, player2, ......, player 9], assume max number player is 9.
        // Get small blind(SB) from one player at small blind postion: index of SB player shoulde be buttonPosition + 1
        // Get big blind(BB) from one player at big blind position: index of BB player should be buttonPosition + 2

        // Get number of active players.
        int currentNumPlayer = this.table.getCurrentNumPlayer(); // <Option1>

        // button positon should be the index of array list of players, ArrayList<Player>
        int buttonPosition = this.table.getButtonPosition();

        // Get button position, small blind position, and big blind position
        int smallBlindPostion = (buttonPosition + 1) % currentNumPlayer ;
        int bigBlindPosition = (buttonPosition + 2) % currentNumPlayer;

        // Find the player at small blind position and player will bet amount equal to small blind
        Player smallBlindPlayer = this.table.getCurrentPlayers().get(smallBlindPostion);
        double smallBlind = smallBlindPlayer.bet(getSmallBlind());

        // Find the player at big blind position and player will bet amount equal to Big blind
        Player bigBlindPlayer = this.table.getCurrentPlayers().get(bigBlindPosition);
        double bigBlind = bigBlindPlayer.bet(getBigBlind());
    }

    public ArrayList<Player> getActivePlayers(){
        return activePlayers;
    }

    public void setActivePlayers(){
        this.activePlayers = new ArrayList<Player>(table.getPlayers());
    }

    public String toString(){
        String result = "";
        result += "Dealer info: " + this.name + "\n";
        result += "Poker Game info: " + this.pokerGame + "\n";
        result += "Table info: " + this.table + "\n";
        return result;
    }

}
