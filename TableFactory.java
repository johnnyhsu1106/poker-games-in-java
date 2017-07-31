public class TableFactory extends PokerFactory{
	public static Table createTable(){
		return new Table();
	}
	public static Table createTable(int tableNum, int maxNumPlayer){
		return new Table(tableNum, maxNumPlayer);
	}
}