import java.util.*;

public class PokerGameDemo{

    public static void main(String [ ] args){

        // ====================================== Initailize the Game ======================================
        // =================================================================================================

        //  =================================== Create the all objects ===================================

        // Parameters for Texas Holdem, cash Game(no ante), No Limit
        String pokerType = "Holdem";
        String gameType = "Cash";
        String structure = "NoLimit";
        double ante = 0; // cash game has no ante.
        double smallBlind = 1;
        double bigBlind = 2;
        double chip = 200;

        // Parameters for table
        int tableNum = 1;
        int maxNumPlayer = 9;
        double amount = 0;

        // Parameters for dealer
        String dealerName = "Daniel";

        // Parameters for players
        String playerType = "Human";
        String playerName1 = "Johnny";
        String playerName2 = "Josh";
        String playerName3 = "Justin";
        String playerName4 = "Michelle";

        // Create a Texas Hold'em type and betting structure for the poker game.
        GameType cashGame = GameTypeFactory.createGameType(gameType, ante);
        BettingStructure noLimit = BettingStructureFactory.createBettingStructure(structure, smallBlind, bigBlind);
        PokerGame texasHoldem = PokerGameFactory.createPokerGame(pokerType, noLimit, cashGame);

        // Create a dealer and a table for the poker game.
        Dealer dealer= DealerFactory.createDealer(pokerType, dealerName);
        Table table = TableFactory.createTable(tableNum, maxNumPlayer);

        // Set the dealer's poker game type and add them to the table.
        dealer.setPokerGame(texasHoldem);
        dealer.setTable(table);
        table.setDealer(dealer);
        dealer.setDeck();

        // Create 4 players for the poker game.
        Player humanPlayer1 = PlayerFactory.createPlayer(playerType, playerName1, chip);
        Player humanPlayer2 = PlayerFactory.createPlayer(playerType, playerName2, chip);
        Player humanPlayer3 = PlayerFactory.createPlayer(playerType, playerName3, chip);
        Player humanPlayer4 = PlayerFactory.createPlayer(playerType, playerName4, chip);

        //Add all of the players to the same table.
        humanPlayer1.joinTable(table);
        humanPlayer2.joinTable(table);
        humanPlayer3.joinTable(table);
        humanPlayer4.joinTable(table);

        //Add every player to the Dealer's observer list.
        dealer.addObserver(humanPlayer1);
        dealer.addObserver(humanPlayer2);
        dealer.addObserver(humanPlayer3);
        dealer.addObserver(humanPlayer4);

        // =================================== Print out all information ===================================

        // Print the Game Type Info
        System.out.println(texasHoldem);

        // Print the Table Info:
        System.out.println(table);


        // ======================================== Start this Round ======================================
        // ================================================================================================

        //  =================================== Dealer starts the hand =================================
        System.out.println("\nStart Round 1!\n");

        System.out.println("Betting small and big blinds:");
        dealer.startHands();

        // Print Player Info and each player's position: button, small blind, big blind
        System.out.println("\nInitial Player Standings:");
        System.out.println( humanPlayer1 + "\n"); //+ " at button positon of this table.");
        System.out.println( humanPlayer2 + "\n"); //+ " at small blind position of this table.");
        System.out.println( humanPlayer3 + "\n"); //+ " at big blind position of this table.");
        System.out.println( humanPlayer4 + "\n");

        //  =================================== At Pre-Flop Stage ===================================

        System.out.println("=========== At Pre-Flop Stage ===========");
        double totalBettingAmount = 0.0;

        System.out.println("\nCurrent Bets_____________________________");
        table.getCurrentBets();
        System.out.println();

        // Each player's action
        System.out.println("Player 3's action: call");

        totalBettingAmount += humanPlayer3.call();

        System.out.println("Player 4's action: call");
        totalBettingAmount += humanPlayer4.call();

        System.out.println("Player 1's action: call");

        totalBettingAmount += humanPlayer1.call();

        System.out.println("Player 2's action: check");
        totalBettingAmount += humanPlayer2.check();

        System.out.println("\nCurrent Bets_____________________________");
        table.getCurrentBets();
        System.out.println();

        // Show the pot size
        System.out.println("The pot size is: $" + table.getPot());


        //  =================================== At Flop Stage ===================================
        System.out.println("\n============= At Flop Stage =============");
        totalBettingAmount = 0.0;

        // dealer burn card
        dealer.burnCard();

        // dealer deal community cards (3 cards)
        dealer.dealCommunityCard();
        dealer.dealCommunityCard();
        dealer.dealCommunityCard();

        // Print out the community cards on the table
        System.out.println("The first 3 cards on table are:");
        System.out.println(table.getCommunityCards());

        // Each player's action
        System.out.println();
        System.out.println("player 2's action: bet");
        amount = 10;
        totalBettingAmount += humanPlayer2.bet(amount);

        System.out.println("player 3's action: call");
        totalBettingAmount += humanPlayer3.call();

        System.out.println("player 4's action: call");
        totalBettingAmount += humanPlayer4.call();

        System.out.println("player 1's action: fold");
        totalBettingAmount += humanPlayer1.fold();

        System.out.println("\nCurrent Bets_____________________________");
        table.getCurrentBets();
        System.out.println();

        // Show the pot size
        System.out.println("The pot size is: $" + table.getPot());


        //  =================================== At Turn Stage ===================================
        System.out.println("\n============= At Turn Stage =============");
        totalBettingAmount = 0.0;

        // dealer burn card
        dealer.burnCard();

        // dealer deal community cards (1 cards)
        dealer.dealCommunityCard();
        // Print out the community cards on the table
        System.out.println("The first 4 cards on table are:");
        System.out.println(table.getCommunityCards());

        // Each player's action
        System.out.println();
        System.out.println("player 2's action: check");

        totalBettingAmount += humanPlayer2.check();

        System.out.println("player 3's action: bet");
        amount = 30;
        totalBettingAmount += humanPlayer3.bet(amount);

        System.out.println("player 4's action: call");
        totalBettingAmount += humanPlayer4.call();

        System.out.println("player 2's action: fold");
        totalBettingAmount += humanPlayer2.fold();

        System.out.println("\nCurrent Bets_____________________________");
        table.getCurrentBets();
        System.out.println();

        // Show the pot size
        System.out.println("The pot size is: $" + table.getPot());


        // =================================== At River Stage ===================================
        System.out.println("\n============= At River Stage =============");
        totalBettingAmount = 0.0;

        // dealer burn card
        dealer.burnCard();

        // dealer deal community cards (1 cards)
        dealer.dealCommunityCard();

        // Print out the community cards on the table
        System.out.println("The total 5 cards on table are:");
        System.out.println(table.getCommunityCards());

        // Each player's action
        System.out.println();
        System.out.println("player 3's action: bet");
        amount = 60;
        totalBettingAmount += humanPlayer3.bet(amount);

        System.out.println("player 4's action: call");
        totalBettingAmount += humanPlayer4.call();

        System.out.println("\nCurrent Bets_____________________________");
        table.getCurrentBets();
        System.out.println();

        // Show the pot size
        System.out.println("The pot size is: $" + table.getPot());

        // ======================================== End this Round ======================================
        // ===============================================================================================

        System.out.println();
        System.out.println(humanPlayer3.getName() + "'s" + humanPlayer3.getPokerHand());
        System.out.println(humanPlayer4.getName() + "'s" + humanPlayer4.getPokerHand());
        System.out.println();

        //Game has ended.  Get winners array and print them to the screen.
        ArrayList<Player> winners = dealer.getWinners();

        if( winners.size() > 1 ){
        	System.out.print("Our winners are: ");
            for(int i = 0; i < winners.size(); i++){
                if( i+1 >= winners.size() )
                    System.out.println(winners.get(i).getName() + "!");
                else
          	         System.out.print(winners.get(i).getName() + " and ");
            }
        }
        else
        	System.out.println("Our winner is: " + winners.get(0).getName() + "!");

        System.out.println("\nFinal Player Standings:");
        System.out.println();
        System.out.println( humanPlayer1 + "\n");
        System.out.println( humanPlayer2 + "\n");
        System.out.println( humanPlayer3 + "\n");
        System.out.println( humanPlayer4 + "\n");
    }

}