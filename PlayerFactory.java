public class PlayerFactory extends PokerFactory{
	public static Player createPlayer(String playerType){

		if (playerType.equalsIgnoreCase("Human")){
			return new HumanPlayer();
		}
		else if (playerType.equalsIgnoreCase("AI")){
			return new AIPlayer();
		}
		else{
			return null;
		}

	}

	public static Player createPlayer(String playerType, String name, double chip){

		if (playerType.equalsIgnoreCase("Human")){
			return new HumanPlayer(name, chip);
		}
		else if (playerType.equalsIgnoreCase("AI")){
			return new AIPlayer(name, chip);
		}
		else{
			return null;
		}
	}
}