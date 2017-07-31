import java.util.*;

public class Table
{
	private int tableNum;
	private int maxNumPlayer; // a capacity of a table, maxNumPlayer >= players.size()
	private ArrayList<Player> players; // [player1, player2, player 3, player 4]
	private Dealer dealer;
	private double pot;
	private int buttonPosition;
	private CommunityCard communityCards;


	public Table(){
		this.tableNum = 0;
		this.maxNumPlayer = 0 ;
		this.players = new ArrayList<>(); 
		this.dealer = null;
		this.pot = 0.0;
		this.buttonPosition = 0;
		this.communityCards = new CommunityCard();
	}

	public Table(int tableNum, int maxNumPlayer){
		this.tableNum = tableNum;
		this.maxNumPlayer = maxNumPlayer;
		this.players = new ArrayList<Player>();
		this.dealer = null;
		this.pot = 0.0;
		this.buttonPosition = 0;
		this.communityCards = new CommunityCard();

	}

	public int getTableNum(){
		return this.tableNum;
	}

	public Player getPlayer(int position){
		return (Player)this.players.get(position);
	}

	public ArrayList<Player> getPlayers(){
		return this.players;
	}


	public void setMaxNumPlayer(int maxNumPlayer){
		this.maxNumPlayer = maxNumPlayer;
	}

	public int getMaxNumPlayer(){
		return this.maxNumPlayer;
	}



	public ArrayList<Player> getCurrentPlayers(){
		return this.players;
	}

	public int getCurrentNumPlayer(){
		return this.players.size();
	}

	public boolean requestJoin(Player in){
		if( this.maxNumPlayer > this.players.size() )
		{
			this.players.add(in);
			return true;
		}
		else
			return false;
	}

	public boolean requestLeave(Player out){
		return this.players.remove(out);
	}

	public Dealer getDealer(){
		return this.dealer;
	}

	public void setDealer(Dealer dealer){
		this.dealer = dealer;
	}

	public boolean isTableFull(){
		return this.maxNumPlayer == this.players.size();
	}

	public int getButtonPosition(){
		return this.buttonPosition;
	}

	public void setButtonPosition(int buttonPosition){
		this.buttonPosition = buttonPosition;
	}

	public void moveButton(){
		if (this.buttonPosition + 1 == this.players.size()){
			this.buttonPosition = 0;
		}
		else{
			this.buttonPosition += 1;
		}
		clearPot();
	}

	public double getPot(){
		return this.pot;
	}

	public void addPot(double amount){
		this.pot += amount;
	}

	public void clearPot(){
		this.pot = 0.0;
	}

	public double getHighestBet()
	{
		double highestAmnt = 0;

		Iterator<Player> playerList = this.players.iterator();
		while (playerList.hasNext())
		{
			Player temp = playerList.next();

			if( temp.getBet() > highestAmnt )
				highestAmnt = temp.getBet();
		}

		return highestAmnt;
	}

	public void getCurrentBets()
	{
		Iterator<Player> playerList = this.players.iterator();
		while (playerList.hasNext())
		{
			Player temp = playerList.next();
			System.out.println( temp.getName() + ": Bet - $" + temp.getBet() );
		}
	}

	public void setCommunictyCard(Card communityCard){
		this.communityCards.setCard(communityCard);
	}

	public CommunityCard getCommunityCards(){
		return this.communityCards;
	}

	public void clearCommunityHand(){
		this.communityCards.clearHand();
	}

	public String toString(){
		String out = "Table: " + this.tableNum;
		if( this.dealer != null )
			out += "\nDealer: " + this.dealer.getName();
		else
			out += "\nDealer: No Dealer";
		out += "\nNum of Players: " + this.players.size() + "/" + this.maxNumPlayer;
		out += "\nPot Size: " + this.pot;
		out += "\nButton Pos: " + this.buttonPosition;

		if( this.players.size() > 0 ){
			out += "\nPlayers: ";

			Iterator<Player> playerList = this.players.iterator();
			while (playerList.hasNext()){
			  out += (playerList.next()).getName();

			  if( playerList.hasNext() )
			  	out += ", ";
			}
		}
		else
			out += "\nPlayers: No Players";
		return out;
	}
}