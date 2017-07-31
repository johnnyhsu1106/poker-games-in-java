import java.util.*;

public class HandStrengthAnalyzer{

    private ArrayList<Card> kicker;
    private ArrayList<Card> flushList;
    private int[] setStrengthArray;
    private int   handStrengthVal,
                  highSet,
                  lowSet,
                  highSetIdx,
                  lowSetIdx,
                  flushSuit,
                  straightIdx,
                  straightInc,
                  lowStraightInd,
                  handSetter,
                  kickerLimit;

    private Card[] bestHand = new Card[5];
  
    public HandStrengthAnalyzer(){
        this.kicker = new ArrayList<>();
        this.flushList = new ArrayList<>();
        this.handStrengthVal = 0;
        this.highSet = 0;
        this.lowSet = 0;
        this.highSetIdx = 0;
        this.lowSetIdx = 0;
        this.flushSuit = 0;
        this.straightIdx = 0;
        this.straightInc = 0;
        this.lowStraightInd = 0;
        this.handSetter = 0;
        this.kickerLimit = 0;    
    }
  
  

    public Card[] getBestHand(ArrayList<Card> hand){
    
        if(bestHand[1] !=null){
            this.kicker = new ArrayList<>();
            this.flushList = new ArrayList<>();
            this.handStrengthVal = 0;
            this.highSet = 0;
            this.lowSet = 0;
            this.highSetIdx = 0;
            this.lowSetIdx = 0;
            this.flushSuit = 0;
            this.straightIdx = 0;
            this.straightInc = 0;
            this.lowStraightInd = 0;
            this.handSetter = 0;
            this.kickerLimit = 0;} 


            sortArrayListRank(hand);
            setHandStregnthVal(hand);

        if(this.handStrengthVal == 8){
            setStraight(hand);
        }
        else if(this.handStrengthVal >= 6 || this.handStrengthVal <= 3){
            setSets(hand);
        }
        else if(this.handStrengthVal == 5){
            setFlush(hand);
        }
        else if(this.handStrengthVal == 4){
            setStraight(hand);
        }

        return bestHand;

    }

    private int[] getsetStrengthArray(){
        //Returns the setStrength array itself.
        return this.setStrengthArray;
    }
    public int getHigSetVal(){
        //Returns the value of the high pair or 3 of a kind in a hand.
        return this.highSet;
    }
    public int getLowSetVal(){
        //Returns the value of the pair in a hand.
        return this.lowSet;
    } 
    public int getHandStrengthVal(){    
        //Returns the hand strength of a hand as an integer in a predetermined range.
        return this.handStrengthVal;
    }
    private ArrayList<Card> sortArrayListRank(ArrayList<Card> hand){
            //Sorts ArrayLists by the rankNumber of a Card object.
        Collections.sort(hand, new Comparator<Card>(){
            @Override
            public int compare(Card card1, Card card2){ 
                return card1.getRankNumber() - card2.getRankNumber();
            }
        }); //Sort ArryList in ascending order.

        return hand;
    }

    private ArrayList<Card> sortArrayListSuit(ArrayList<Card> hand){
        Collections.sort(hand, new Comparator<Card>(){
            @Override
            public int compare(Card card1, Card card2){ 
                return card1.getSuitNumber() - card2.getSuitNumber();
            }
        }); //Sort ArryList in ascending order.

        return hand;
    }//Sorts ArrayLists by the rankNumber of a Card object.

    private int checkStraightFlush(ArrayList<Card> hand){
        int c1 = 1;
        int sf = 0;


        if(checkFlush(hand) == 5){
            setFlush(hand);
        }

        for(int i = 0; i < hand.size()-1; i++){
            if(hand.get(i).getRankNumber() == (hand.get(i+1).getRankNumber()-1)){
                c1 = c1 + 1;
            } 
            else if(hand.get(i).getRankNumber() == (hand.get(i+1).getRankNumber())){
                c1 = c1;
            } 
            else {
                c1 = 1;
            }
            if(c1==5){
                straightIdx = i + 1;
            }
            if(c1 == 5){
                sf = 1;
            }
        }
        if(sf == 1){
            return 8;
        } 
        else if (hand.get(hand.size() - 1).getRankNumber() == 14){
            c1 = 1;
            sf = 0;
            hand.get(hand.size() - 1).setRankNumber(1);
            sortArrayListRank(hand);
            for(int i = 0; i < hand.size()-1; i++){
                if(hand.get(i).getRankNumber() == (hand.get(i+1).getRankNumber()-1)){
                    c1 = c1 + 1;
                } 
                else if(hand.get(i).getRankNumber() == (hand.get(i+1).getRankNumber())){
                    c1 = c1;
                } 
                else {
                    c1 = 1;
                }
                if(c1==5){
                    straightIdx = i + 1;
                    lowStraightInd = 1;
                }
                if(c1 == 5){
                  sf = 1;
                }
            } 
            
            for(int i = 0; i < hand.size(); i++){
                if(hand.get(i).getRankNumber() == 1){
                    hand.get(i).setRankNumber(14);}}  
            }   
            if(sf == 1){
              return 8;      
            } 
            else {
              return 0;
            }
      
        }

    private int checkFlush(ArrayList<Card> hand){
        sortArrayListSuit(hand);

        int c1 = 1;
        int fl = 0;

        for(int i = 0; i < hand.size()-1; i++){
            if(hand.get(i).getSuitNumber() == hand.get(i+1).getSuitNumber()){
                c1 = c1 + 1;
            } 
            else {
                c1 = 1;
            }
            if(c1==5){
                flushSuit = hand.get(i).getSuitNumber();
            }
            if(c1 == 5){
                fl = 1;
            }
        }
        if(fl == 1){
            return 5;
        } 
        else return 0;
    }

    private void setFlush(ArrayList<Card> hand){
        int flushListDec = 0;

        sortArrayListRank(hand);

        if(flushList.size() == 0){
            for(int i = 0; i < hand.size(); i++){
                if(hand.get(i).getSuitNumber() == flushSuit){
                    this.flushList.add(hand.get(i));
                }
            }
        }
            
        flushListDec = flushList.size() - 1;
        sortArrayListRank(flushList);

        for(int i = 0; i < bestHand.length; i++){
            bestHand[i] = flushList.get(flushListDec);
            flushListDec--;
        }

    }

    private int checkStraight(ArrayList<Card> hand){
        sortArrayListRank(hand);
        int c1 = 1;
        int st = 0;

        for(int i = hand.size()-1; i > 0; i--){   
            if(hand.get(i).getRankNumber() == (hand.get(i-1).getRankNumber()+1)){
                c1 = c1 + 1;
              } 
            else if(hand.get(i).getRankNumber() == (hand.get(i-1).getRankNumber())){
                c1 = c1;
            } 
            else {
                c1 = 1;
            }

            if(c1==5){
                straightIdx = i - 1 ;
            }
            if(c1 == 5){
              st = 1;
            }  
        }
        
        if(st == 1){      
            return 4;
        }
        else if(hand.get(hand.size() - 1).getRankNumber() == 14){
            c1 = 1;
            st = 0;
            hand.get(hand.size() - 1).setRankNumber(1);
            sortArrayListRank(hand);
            for(int i = hand.size()-1; i > 0; i--){   
                if(hand.get(i).getRankNumber() == (hand.get(i-1).getRankNumber()+1)){
                    c1 = c1 + 1;
                } 
                else if(hand.get(i).getRankNumber() == (hand.get(i-1).getRankNumber())){
                    c1 = c1;
                } 
                else {
                    c1 = 1;
                }

                if(c1==5){
                    straightIdx = i - 1 ;
                    lowStraightInd = 1;
                }
                if(c1 == 5){
                  st = 1;
                }
          
            }     
        
            for(int i = 0; i < hand.size(); i++){
                if(hand.get(i).getRankNumber() == 1){
                    hand.get(i).setRankNumber(14);
                }
            }    
        }

        if(st == 1){      
            return 4;
        } 
        else return 0;
    }

    private void setStraight(ArrayList<Card> hand){
        sortArrayListRank(hand);
        checkSets(hand);
        setHighSet(hand);
        setLowSet(hand);

        if(lowStraightInd == 0){
            for(int i = 0; i < hand.size(); i++){
                if(straightInc < 5){
                    bestHand[straightInc] = hand.get(straightIdx);
                }
                if(setStrengthArray[i] != 0){
                    straightIdx = straightIdx + setStrengthArray[i];
                    straightInc++;
                    i = i + setStrengthArray[i] - 1;
                } 
                else {
                    straightIdx++;
                    straightInc++;
                }
            }
        } 
        else {
            hand.get(hand.size() - 1).setRankNumber(1);
            sortArrayListRank(hand);
            for(int i = 0; i < hand.size(); i++){
                if(straightInc < 5){
                bestHand[straightInc] = hand.get(straightIdx);
                }
            
                if(setStrengthArray[i] != 0){
                    straightIdx = straightIdx + setStrengthArray[i];
                    straightInc++;
                    i = i + setStrengthArray[i] - 1;
                } 
                else {
                    straightIdx++;
                    straightInc++;
                }
            }
          
        }

    }

    private void fillsetStrengthArray(ArrayList<Card> hand){
        int currCardInt;
        this.setStrengthArray = new int[hand.size()];
        sortArrayListRank(hand);


        for(int hs = this.setStrengthArray.length - 1; hs >= 0; hs--){        
            int setStrengthSum = 0;
            currCardInt = hand.get(hs).getRankNumber();
            for(int tl = 0; tl < hand.size(); tl++){
                if((hand.get(tl).getRankNumber() == currCardInt && 
                    hs == (this.setStrengthArray.length - 1)) ||
                   (hand.get(tl).getRankNumber() == currCardInt &&
                    currCardInt != hand.get(hs + 1).getRankNumber())){
                    setStrengthSum++;
                }//Find and label indices of pairs and 3 of a kind.

            }//Inner for loop that iterates through the ArrayList that is being tested

            if(setStrengthSum == 1){
                setStrengthSum = 0;
            }

            this.setStrengthArray[hs] = setStrengthSum;
        }//Outer for loop that iterates through the setStrengthArray.

    }//Fills the setStrengthArray with a count of each card where 2 or more of
    //that card exist. Useful because the index of the count corresponds to the index
    //of the start of duplicate cards in a sorted array list.


    private int checkSets(ArrayList<Card> hand){
        int setStrengthVal = 0; //ensure that setStrengthVal is 0 at the start of
                             //this process
        fillsetStrengthArray(hand);//Fill the setStrengthArray.

        for(int i = 0; i < this.setStrengthArray.length; i++){
            int incrementVal = 0;

            if(setStrengthArray[i] == 4){
                incrementVal = 9999;
            } 
            else {
                incrementVal = setStrengthArray[i];
            }
            setStrengthVal += incrementVal;
        }//Set four of a kind to a distinct value so that it is not confused with two pair.

        if(setStrengthVal == 2){
            setStrengthVal = 1;
        } 
        else if(setStrengthVal >=4 && setStrengthVal % 2 == 0){
            setStrengthVal = 2;
        } 
        else if(setStrengthVal >= 5 && setStrengthVal % 2 == 1){
            setStrengthVal = 6;
        } 
        else if(setStrengthVal >=9999){
            setStrengthVal = 7;
        }

        //Parse the different summed values from the handStregnthArray into the
        //the specific output values.


        return setStrengthVal;

    }//Returns the set strength as an integer value. high card 0,
    //pair = 1, 2 pair = 2, three of a kind = 3, fullhouse = 6,
    //four of a kind = 8.

    private void setHandStregnthVal(ArrayList<Card> hand){

        int[] handStrengthIntArray = new int[4];

        handStrengthIntArray[0] = checkStraightFlush(hand);
        handStrengthIntArray[2] = checkFlush(hand);
        handStrengthIntArray[3] = checkStraight(hand);
        handStrengthIntArray[1] = checkSets(hand);

        Arrays.sort(handStrengthIntArray);

        for(int i = 0; i < handStrengthIntArray.length; i++){
            if(handStrengthIntArray[i] > handStrengthVal){
                handStrengthVal = handStrengthIntArray[i];
            }
        }
    }

    private void setHighSet(ArrayList<Card> hand){
        int biggestSet = 0;
        sortArrayListRank(hand);      

        for(int i = this.setStrengthArray.length - 1; i > 0; i--){
            if(this.setStrengthArray[i] > biggestSet){
                highSet = 0;
            }
            if(this.setStrengthArray[i] != 0 && 
                this.setStrengthArray[i] >= biggestSet &&
                hand.get(i).getRankNumber() > this.highSet){
                biggestSet = this.setStrengthArray[i];
                this.highSet = hand.get(i).getRankNumber();
                this.highSetIdx = i;
            }
        }//Find the highSet value and the array index of the first highSet card.
    }//Setter to set the highSet int value.

    
    private void setLowSet(ArrayList<Card> hand){
        for(int i = this.setStrengthArray.length - 1; i > 0; i--){
            if(this.setStrengthArray[i] != 0 && 
                hand.get(i).getRankNumber() > lowSet &&
                hand.get(i).getRankNumber() != this.highSet){

                this.lowSet = hand.get(i).getRankNumber();
                this.lowSetIdx = i;
            }//Ensure that the low set does not equal the high set.
        }//Find the highest set that is lower than the high set.
    }//Setter to set the lowSet int value.

    private void setKicker(ArrayList<Card> hand){
        int kickerInc = 5 - handSetter;
        //Set the kicker = to the handsetter value so that we know how many kicker
        //cards to take.
        sortArrayListRank(hand);
        for(int i = (this.setStrengthArray.length - 1); i >= 0;  i--){   

            if(this.setStrengthArray[i] == 0 &&
             hand.get(i).getRankNumber() != this.highSet &&
             hand.get(i).getRankNumber() != this.lowSet &&
              kickerInc != 0){
             this.kicker.add(hand.get(i));
             kickerInc--;
            } 
        }//Fill kicker cards with the best cards that are not already part of the
         //hand. Kicker will be used to evaluate high card hands, one pair, 2 pair,
         //three of a kind, and four of a kind.
    }//Fill the kicker ArrayList.

    private void setSets(ArrayList<Card> hand){
        int highSetLoop,
            lowSetLoop;
        sortArrayListRank(hand);

        setHighSet(hand);//Find the highSet value and the array index of the first highSet card.

        setLowSet(hand);//Find the highest set that is lower than the high set.
        highSetLoop = highSetIdx;
        lowSetLoop = lowSetIdx;

        for(int i = setStrengthArray[highSetIdx]; i > 0; i--){
            this.bestHand[handSetter] = hand.get(highSetLoop);
            this.handSetter++;
            highSetLoop--;
          }//Fill high set. This means it will choose the High Pair or the only 3 of
           //a kind if there is one.

        if(setStrengthArray[highSetIdx] != 4){
            for(int i = setStrengthArray[lowSetIdx]; i > 0; i--){
                this.bestHand[handSetter] = hand.get(lowSetLoop);
                this.handSetter++;
                lowSetLoop--;
            }//Fill low set if there is one and you do not have a 4 of a kind.
        }//Ensure that you do not try to fill low set on 4 of a kind.

        setKicker(hand);//Fill the kicker ArrayList.

        kickerLimit = handSetter;
         
         for(int i = 0; i < kicker.size(); i++){
            bestHand[kickerLimit] = kicker.get(i);
            kickerLimit++;
          }//Fill the best hand with the kicker cards.
    }//Fills the best hand with High Card, Pair, 2 Pair, 3 of a Kind, Full House, and
    //Four of a Kind hands.

}