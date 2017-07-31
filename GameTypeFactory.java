public class GameTypeFactory extends PokerFactory{

	public static GameType createGameType(String gameType){
		if (gameType.equalsIgnoreCase("Cash")){
			return new CashGame();
		}
		else if (gameType.equalsIgnoreCase("Tournament")){
			return new TournamentGame();
		}
		else{
			return null;
		}
	}

	public static GameType createGameType(String gameType, double ante){
		if (gameType.equalsIgnoreCase("Cash")){
			return new CashGame(ante);
		}
		else if (gameType.equalsIgnoreCase("Tournament")){
			return new TournamentGame(ante);
		}
		else{
			return null;
		}
	}
}