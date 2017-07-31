import java.util.*;
// Add abstract before class: no constructor is needed (no-instantiate)
public abstract class Player implements Observer{

	// Change all visiblity of instance variable:  private to protected
	protected String name;
	protected double chip;
	protected double bet; //for each stage, the bet should be reset to 0.
	protected PlayerHand playerHand;
	protected Table table; // Change currTable to Table, made by Johnny
	protected PokerHand pokerHand;

	// No constructor is needed (no-instantiate) : made by Johnny
	public Player(){
		this.name = "";
		this.chip = 0;
		this.bet = 0;
		this.playerHand = new PlayerHand();
		this.table = null;
	}

	// Add constructor with parameters
	public Player(String name, double chip){
		this.name = name;
		this.chip = chip;
		this.bet = 0;
		this.playerHand = new PlayerHand();
		this.table = null;
	}

	public void update(Observable obs, Object obj)
	{
		this.pokerHand.updateBestHand();
	}

	// In order to verify clearly, all instance variable should add this. in the front of intance varaible name
	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public double getChip(){
		return this.chip;
	}

	public void setChip(double chip){
		this.chip = chip;
	}

	public double getBet(){
		return this.bet;
	}

	public void setBet(double amount){
		this.bet = amount;
	}

	// Change all return type: bet, check, call, raise, allin from void to double
	public double bet(double amount)
	{
		// amount should be less than chip, amount <= this.chip
		//this.bet = 0;
		this.chip -= amount;
		this.bet += amount;
		table.addPot(amount);
		System.out.println(name + ": Betting - $" + amount);

		return amount;
	}

	public double check()
	{
		// no betting action
		return 0.0;
	}

	public double call()
	{
		//Determine minimum amount to bet to meet current highest bet.
		double amount = table.getHighestBet() - this.bet;
		this.chip -= amount;
		this.bet += amount;
		table.addPot(amount);

		return amount;
	}

	public double fold(){
		// remove the this Player from active player list
		getTable().getDealer().getActivePlayers().remove(this);
		this.bet = 0.0;
		clearPlayerHand();

		return 0.0;
	}

	public boolean raise(double amount){
		// raising amount should be greater than the amount the previous player bets.
		if( (amount + this.bet) > table.getHighestBet() )
		{
			System.out.println(name + ": Raising - $" + amount);
			bet(amount);
			return true;
		}
		else
			return false;
	}

	public void allin(){
		bet(this.chip);
	}

	public void winPot(double amount){
		this.chip += amount;
	}

	public PlayerHand getPlayerHand(){
		return this.playerHand;
	}

	public void clearPlayerHand(){
		this.playerHand.clearHand();
	}

	public PokerHand getPokerHand(){
		return this.pokerHand;
	}
	public Table getTable(){
		return this.table;
	}

	public boolean joinTable(Table reqTable){
		if (reqTable.requestJoin(this)){
			table = reqTable;
			this.pokerHand = new PokerHand( getPlayerHand(), this.table.getCommunityCards());
			return true;
		}
		else
			return false;
	}

	public boolean leaveTable(){
		if (table.requestLeave(this)){
			table = null;
			return true;
		}
		else
			return false;
	}
	public boolean quit(){
		if (table == null){
			return false;
		}
		else{
			return table.requestLeave(this);
		}
	}

	public String toString(){
		String out = "Player: " + getName();
		out += "\nChip Amount: " + getChip();
/*		if( table != null )
			out += "\nTable: " + table.getTableNum();
		else
			out += "\nTable: No Table";
*/
		ArrayList<Card> cards = playerHand.getCards();

		if( cards.size() > 0 ){
			out += "\nCards: ";

			Iterator<Card> cardList = cards.iterator();
			while (cardList.hasNext()){
			  Card next = cardList.next();
			  out += next;

			  if (cardList.hasNext())
			  	out += ", ";
			}
		}
		else
			out += "\nCards: No Cards";

		return out;
	}
}
