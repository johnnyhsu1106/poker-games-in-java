import java.util.*;

class PokerHand implements Comparable<PokerHand>{
    private PlayerHand playerHand;
    private CommunityCard communityCard;
    private HandStrengthAnalyzer hsa;
    private Card[] hand;
    private static  ArrayList<Card> temp;
    private int handStrength;

    public PokerHand(PlayerHand playerHand, CommunityCard communityCard){
        this.playerHand = playerHand;
        this.communityCard = communityCard;
        this.hsa = new HandStrengthAnalyzer();
        this.hand = new Card[5];
        this.temp = new ArrayList<>();
    }
  
    @Override public int compareTo(PokerHand pokerHand){
        int equalStrength = 0;

        final int LESS_THAN = -1;
        final int EQUAL =0;
        final int GREATER_THAN = 1;

        if(this.handStrength < pokerHand.getHandStrength()){      
            return LESS_THAN;
        }
        else if(this.handStrength > pokerHand.getHandStrength()){
            return GREATER_THAN;
        }
        else if(this.handStrength == pokerHand.getHandStrength()){
            for(int i = 0; i < this.hand.length; i++){
                if(equalStrength == 0){
                    equalStrength = this.hand[i].getRankNumber() - pokerHand.getHand()[i].getRankNumber();
                }
            }
        }
            
        if(equalStrength < 0){
            return LESS_THAN;
        }
        else if(equalStrength > 0){
            return GREATER_THAN;
        }
        else return EQUAL;      
    }
  

    private int getHandStrength(){
        return handStrength;
    }
  
    private Card[] getHand(){
        return hand;
    }
    
    public void updateBestHand(){
        for(int i = 0; i < playerHand.getCards().size(); i++){
            this.temp.add(playerHand.getCards().get(i));
        }
        for(int i = 0; i < communityCard.getCards().size(); i++){
            this.temp.add(communityCard.getCards().get(i));
        }

        hand =  hsa.getBestHand(temp);
        handStrength = this.hsa.getHandStrengthVal();;
        temp.clear();    
    }
  
    public String toString(){
        String output = "";
        output += " best hand is ";
        for(int i = 0; i < hand.length; i++){
            if(i != hand.length - 1){
                output += (hand[i] + ", ");
            }
            else{
                output += hand[i] + ".";
            }
        }
        return output;
    }

    // //Unecessary Code
    // private static ArrayList<Card> getTemp(){
    // return temp;
    // }
      
}