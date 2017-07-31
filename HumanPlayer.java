import java.util.*;
// Class made by Johnny
public class HumanPlayer extends Player{

	public HumanPlayer(){
		this.name = "";
		this.chip = 0;
		this.bet = 0;
		this.playerHand = new PlayerHand();
		this.table = null;
	}

	
	public HumanPlayer(String name, double chip){
		this.name = name;
		this.chip = chip; 
		this.bet = 0;
		this.playerHand = new PlayerHand();
		this.table = null;
	}	

}