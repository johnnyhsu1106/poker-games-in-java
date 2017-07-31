import java.util.ArrayList;

class CommunityCard{

    private ArrayList<Card> hand;

    CommunityCard(){
        this.hand = new ArrayList<Card>();
    }

    public void setCard(Card card){
        this.hand.add(card);
    }

    public ArrayList<Card> getCards(){
        return this.hand;
    }

	public void clearHand(){
		this.hand = new ArrayList<Card>();
	}

    public String toString(){
        String result = "";
        for(int i=0; i < this.hand.size(); i++){
            result += this.hand.get(i) + "\t";
        }
        return result;
    }

}