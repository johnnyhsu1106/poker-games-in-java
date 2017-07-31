public class PokerGameFactory extends PokerFactory{

	public static PokerGame createPokerGame(String pokerType){

		if (pokerType.equalsIgnoreCase("Draw")){
			return new FiveCardDraw();
		}
		else if (pokerType.equalsIgnoreCase("Holdem")){
			return new TexasHoldEm();
		}
		else if (pokerType.equalsIgnoreCase("Stud")){

			return new SevenCardStud();
		}
		else if (pokerType.equalsIgnoreCase("Omaha")){
			return new Omaha();
		}
		else{
			return null;
		}
	}

	public static PokerGame createPokerGame(String pokerType, BettingStructure bettingStructure, GameType gameType){

		if (pokerType.equalsIgnoreCase("Draw")){
			return new FiveCardDraw(bettingStructure, gameType);
		}
		else if (pokerType.equalsIgnoreCase("Holdem")){
			return new TexasHoldEm(bettingStructure, gameType);
		}
		else if (pokerType.equalsIgnoreCase("Stud")){

			return new SevenCardStud(bettingStructure, gameType);
		}
		else if (pokerType.equalsIgnoreCase("Omaha")){
			return new Omaha(bettingStructure, gameType);
		}
		else{
			return null;
		}
	}


}
