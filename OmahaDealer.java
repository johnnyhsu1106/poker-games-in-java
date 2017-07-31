import java.util.*;

public class OmahaDealer extends Dealer{

	public OmahaDealer(){
		super();
	}

	public OmahaDealer(String name){
		super(name);

	}

    public void startHands(){

		setChanged();
   		notifyObservers();
    }
}
