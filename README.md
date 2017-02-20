# poker-in-Java
<h1>design poker game based on design pattern in Java </h1>


<p>
This zip file contains 80 Java files including .java file and .class files. Each .java file corresponds to one .class file. Each.java or .class  file represents a Java class. Before you run it, you can use command prompt or Java IDE to run this code. Execute the file: PokerGameDemo.class on the command prompt by typing the following command.
For example, in Windows
> java PokerGameDemo
</p>

<h3>This project is finished collaboratively by four people. (listed alphabetically) </h3>
<ul>
<li>Johnny Hsu	johnnyhsu1106@email.arizona.edu (myself)</li>
<li>Justin LeBreck	jlebreck@email.arizona.edu</li>
<li>Joshua Ziegler	joshuaz@email.arizona.edu</li>
<li>Michelle Ziegler	mvziegler22@email.arizona.edu</li>
</ul>

<h2>Project Summary:</h2>
<p>
We have designed a poker game.  We developed a program to compute the relative strength of poker hands based on a set number of players and following the rules of various poker game variations.  This program will generate a complete deck of cards by suit and face-value as well as track the hands of each “player” in the game.   We wanted to ensure this program is extensible so that additional game variations can be added and scalable by allowing more players to be added to the game.  We also wanted to make sure that betting and AI players could eventually be programmed into the program.
</p>

<ul>

<h2>File Description</h2>
PokerProject.mp4 - a video demos how it works in terminal
Final Report.docx - describe how

<h2>Design Patterns: </h2>
<ol>
<li>Bridge (2):  We used the bridge pattern when to structure poker tables as either tournament or cash tables and to structure the betting pattern for each table as either no limit or limit poker.  We also used a bridge to ensure that AI players can be set up with betting tolerance of loose or tight and with a style of aggressive, neutral, or passive.</li>

<li>Strategy (several):  We use multiple strategies throughout the design. We have a poker game strategy that chooses between Texas Hold ‘Em, 7 Card Stud, 5 Card Draw, and Omaha. We employ strategy to create players as either Human or AI. We use strategy for a list of dealers that corresponds to the list of poker games.</li>

<li>Observer (1):  The implementation of an observer pattern will notify the Player class, after they join a Table, that the Dealer has dealt a card to either the player’s hand or the community hand.  The Player class’ notify method will call PokerHand’s updateBestHand() method to create the player’s best hand based on their hand and the community’s hand.</li>

<li>Abstract Factory (1):  The abstract factory will bundle Table, Dealer, Player, BettingStructure, and GameType objects when a poker game instance is created.</li>
</ol>


<h2>Key Features:</h2>
<p>
The program will deal out cards, compare player hands, and designate a winner for a selected poker game variation.  We have set up some basic rules relating to the number of cards given to and shared by players for a select variety of poker games variations.  This can be extended to include other game types.
</p>
<p>
Currently, betting and AI players are not programmed into the code, but we have the structure to ensured that there is space for the required algorithms to be easily inserted.
</p>


<h3>All .java and .class files are listed below. </h3>
AggroStyle.java <br>
AIPlayer.java<br>
BettingStructure.java <br>
BettingStructure Factory.java <br>
Card.java<br>
CashGame.java<br>
CommunityCard.java<br>
Dealer.java<br>
DealerFactory.java<br>
Deck.java<br>
DrawDealer.java<br>
FiveCardDraw.java<br>
GameType.java<br>
GameTypeFactory.java<br>
HandStrengthAnalyzer.java<br>
HoldemDealer.java<br>
HumanPlayer.java<br>
Limit.java<br>
LoosePlayer.java<br>
NeutralStyle.java<br>
NoLimit.java<br>
Omaha.java<br>
OmahaDealer.java<br>
PassiveStyle.java<br>
Player.java<br>
PlayerFactory.java<br>
PlayerHand.java<br>
PlayerStyle.java<br>
PokerFactory.java<br>
PokerGame.java<br>
PokerDemo.java<br>
PokerGameFactory.java<br>
PokerHand.java<br>
SevenCardStud.java<br>
StudDealer.java<br>
Table.java<br>
TableFactory.java<br>
TexasHoldEm.java<br>
TightPlayer.java<br>
TournamentGame.java<br>


