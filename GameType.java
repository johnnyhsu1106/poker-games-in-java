public abstract class GameType{
  
    double ante;//Double variable to capture the current table ante.

    // String type;//String variable to capture the current game type.

    public abstract void setAnte(double ante);
    //Abstract setter to set a table ante.

    public double getAnte(){
        return this.ante;
    }

    public abstract String toString();
    //Abstract AF implementation.

    public abstract boolean repOK();
    //Abstract RI implementation.
}