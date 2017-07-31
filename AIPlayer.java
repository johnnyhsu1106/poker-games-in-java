public class AIPlayer extends Player{
	
	protected PlayerStyle playerStyle;

	public AIPlayer(){
		super();
		this.playerStyle = null;
	}

	
	public AIPlayer(String name, double chip){
		super(name, chip);
	}

	public void selectPlayerStyle(String style){
		if(style.equalsIgnoreCase("aggro")  ){
			this.playerStyle = new AggroStyle();
		}
		else if(style.equalsIgnoreCase("neutral")  ){
			this.playerStyle = new NeutralStyle();
		}
		else if(style.equalsIgnoreCase("passive")) {
			this.playerStyle = new PassiveStyle();
		}
		else {
			this.playerStyle = null;
		}
		
	}




}