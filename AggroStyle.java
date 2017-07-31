public class AggroStyle extends PlayerStyle{
	int betDegree;
	int handDegree;
	int callDegree;

	//Creates an aggressive style for AI player.
	public AggroStyle(){
		betDegree = 0;
		handDegree = 0;
		callDegree = 0;
	}

	public void setBettingDegree(int degree){
	}

	public void setHandDegree(int degree){
	}

	public void setCallDegree(int degree){
	}

	public int getBettingDegree(){
		return betDegree;
	}

	public int getHandDegree(){
		return handDegree;
	}

	public int getCallDegree(){
		return callDegree;
	}

	public String toString(){
		return "Bet: " + betDegree + "\nHand: " + handDegree + "\nCall: " + callDegree;
	}

	public boolean repOK(){
		if( betDegree < 0 || handDegree < 0 || callDegree < 0 )
			return false;
		else
			return true;
	}
}
