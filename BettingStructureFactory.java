public class BettingStructureFactory extends PokerFactory{
	// Return Limit Object or NoLimt Object based on argument
	public static BettingStructure createBettingStructure(String structure){
		if (structure.equalsIgnoreCase("Limit")){
			return new Limit();
		}
		else if (structure.equalsIgnoreCase("NoLimit")) {
			return new NoLimit();
		}
		else{
			return null;
		}
	}

	public static BettingStructure createBettingStructure(String structure, double smallBlind, double bigBlind){
		if (structure.equalsIgnoreCase("Limit")){
			return new Limit(smallBlind, bigBlind);
		}
		else if (structure.equalsIgnoreCase("NoLimit")) {
			return new NoLimit(smallBlind, bigBlind);
		}
		else{
			return null;
		}
	}
}