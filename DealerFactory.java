public class DealerFactory extends PokerFactory{
	public static Dealer createDealer(String pokerType){
		if (pokerType.equalsIgnoreCase("Draw")){
			return new DrawDealer();
		}
		else if (pokerType.equalsIgnoreCase("Stud")){
			return new StudDealer();
		}
		else if (pokerType.equalsIgnoreCase("Holdem")){
			return new HoldemDealer();
		}
		else if (pokerType.equalsIgnoreCase("Omaha")){
			return new OmahaDealer();
		}
		else{
			return null;
		}
		
	}
	public static Dealer createDealer(String pokerType, String name){
		if (pokerType.equalsIgnoreCase("Draw")){
			return new DrawDealer(name);
		}
		else if (pokerType.equalsIgnoreCase("Stud")){
			return new StudDealer(name);
		}
		else if (pokerType.equalsIgnoreCase("Holdem")){
			return new HoldemDealer(name);
		}
		else if (pokerType.equalsIgnoreCase("Omaha")){
			return new OmahaDealer(name);
		}
		else{
			return null;
		}
		
	}
}