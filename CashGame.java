public class CashGame extends GameType{


	public CashGame(){
		//Default constructor for CashGane objects.
		this.ante = 0;
	}
	public CashGame(double ante){
		this.ante = ante;
	}

	public void setAnte(double ante){
		//Setter for CashGame objects that sets the ante variable.
		// do nothing because it is cash game
	}

	public String toString(){
		//AF implementation for CashGame objects.
		return ("Cash Game with $" +  this.ante + " ante.");
	}

	public boolean repOK(){
		//RI implementation of a CashGame object. Ante should be equal to 0.
		return this.ante == 0 ;
	}
}