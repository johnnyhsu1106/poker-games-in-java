public abstract class BettingStructure{
	double bigBlind ;//Variable to capture the current big blind.
	double smallBlind;//Variable to capture the current small blind.

	public void setSmallBlind(Double smallBlind){
		// Setter for smallBlinds.
		 this.smallBlind = smallBlind;
	}

	public double getSmallBlind(){
    	return this.smallBlind;
	}

	public void setBigBlind(Double bigBlind){
		//Setter for a "Limit" object's bigBlind variable.
		this.bigBlind = bigBlind; 
	}

	public double getBigBlind(){
		// Getter for bigBlinds.
	    return this.bigBlind;
	}
	

	public abstract String toString();
	//AF implementation for the  Betting Structure class.

	public  abstract boolean repOK();
	//RI implementation for the  Betting Structure class.

   
}