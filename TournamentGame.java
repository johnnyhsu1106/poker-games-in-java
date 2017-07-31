public class TournamentGame extends GameType{

    public TournamentGame(){
        //Default constructor for TournamentGame objects.
        this.ante = 1;
    }
   
    public TournamentGame(double ante){
        //TournamentGame constructor that sets the ante and type variables.
        this.ante = ante;
    }

    public void setAnte(double ante){
        //Setter for TournamentGame objects that sets the ante variable.
        this.ante = ante;}

    public String toString(){
        //AF implementation of a tournament game object.
        return ("The current game type is tournament game and the ante is $" + this.ante + ".");
    }

    public boolean repOK(){
        //RI implementation of a TournamentGame object. Ante should be greater than 0.
        return this.ante > 0;
    }
    

}