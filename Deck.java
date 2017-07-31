import java.util.ArrayList;

public class Deck{
    private static Card[] newDeck = new Card[52];//Array of Card objects that
                                                //holds the Deck of Cards.

    private final int DECK_SIZE = 52; //Final int variable to capture how many
                                     //indices a Deck array should have.
    private       int topCard = 52;   //Integer variabe to track the top card
                                     //in a Deck Card array as cards are taken
                                     //from the deck;
                  
    public static  String[] suitName = {"Spades", "Hearts", "Diamonds", 
                                      "Clubs"};//Default Deck Suits. Public
                                               //so that it can be overwritten.

    public static  String[] rankName = {"A", "2", "3", "4", "5",
                                       "6", "7", "8", "9",
                                       "10", "J", "Q", "K"};
                                      //Default Deck Ranks. Public so that it
                                      //can be overwritten.

                                   /*{"A", "Two", "Three", "Four", "Five",
                                       "Six", "Seven", "Eight", "Nine",
                                       "Ten", "Jack", "Queen", "King"};*/
                                    //Array to store actual card names

    //AF: "DECK_SIZE" is a final integer to store the number of cards in a deck object.
    //"newDeck" is a Card array to store the the cards as they are created in a Deck object.
    //"topCard" is a integer that tracks the current top card in the deck array.
    //"suitName" is a String Array that stores the name of the suits in a deck.
    //"rankName" is a String Array that stores the name of the ranks in a deck.
    //RI: Every index position in newDeck should not be nill.


  
    
        

    public Deck(){
        //Deck class default, and only, constructor. Loops through 2 Arrays. One is 
        //an array of suit names Spades, Hearts etc. The other is an array of face
        //values, Ace, Two etc. Uses the Array indices for each array to set 
        //the suitNumber and rankNumber.
    
        for(int s = 0; s < suitName.length; s++){

            for(int r = 0; r < rankName.length; r++){

                int rVal = 0,
                sVal = 4 - s;
        
                if(r == 0){
                    rVal = 14;
                }
                else{
                    rVal = r + 1;
                }
                this.newDeck[((rankName.length * s) + r)] = new Card(suitName[s], rankName[r], sVal , rVal);
            
            }
    
        }
    }

 
    public Card getCard(){
        //Pulls the top card from the deck. Uses the private int topCard to keep track
        //of which card in the array is the top card. Returns the card at the array
        //index taht matches the topCard value and decrements topCard.
     
        this.topCard = this.topCard - 1;
        if(this.topCard < 0){
            System.out.println("Out of cards, shuffling the deck.");
            this.topCard = 51;
            shuffleDeck();
            return this.newDeck[this.topCard];
        }
        else{
            return this.newDeck[this.topCard];
        }
    }
    
 
    public void shuffleDeck(){
        //Uses the Fisher-Yates shuffle method to randomly shuffle the deck. 
        //Exact method used can be found here:
        //reference: https://www.dotnetperls.com/fisher-yates-shuffle
        //This is a somewhat straightforward and simple shuffle method so it 
        //does not stray far from the outline given by the source material.

       for(int i = 0; i < this.newDeck.length; i++){
         int shuf = i + (int)(Math.random() * (DECK_SIZE - i));
         
         Card shuffleCard = this.newDeck[shuf];
         this.newDeck[shuf] = this.newDeck[i];
         this.newDeck[i] = shuffleCard;     
       }
    }
  
    public int getNumCardsInDeck(){
        //Getter to return the number of cards left in the deck.
        return this.topCard + 1;
    }

    public Card[] getDeck(){
       //Getter to return the Card[] a Deck type object holds.
       return this.newDeck;
    }


    
    public String toString(){
        //AF implementation for the Deck Class. 
        String returnString = "";
        for(int i = 0; i < this.newDeck.length; i++){
          
        returnString += (newDeck[i].getSuit() + " " + 
                         newDeck[i].getRank() + " " + 
                         newDeck[i].getSuitNumber() + " " + 
                         newDeck[i].getRankNumber() + "\n");
         }
        return returnString;
    }

    public boolean repOK(){
        boolean testRepOk = true;
        for(int i = 0; i < newDeck.length; i++){
            if(testRepOk = true){
               testRepOk = !(newDeck[i] == null);
            }
        }
        return testRepOk;
    }   

}