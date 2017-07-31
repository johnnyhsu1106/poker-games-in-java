public class LoosePlayer extends AIPlayer
{
	private double betStrategy;

	public LoosePlayer()
	{
		super();
		this.betStrategy = 0;
	}

	public void setBetStrategy(double strategy)
	{
		this.betStrategy = strategy;
	}

	public double getBetStrategy()
	{
		return this.betStrategy;
	}

	public String toString()
	{
		return "Bet Strategy: " + this.betStrategy;
	}

	public boolean repOK()
	{
		if( this.betStrategy < 0 )
			return false;
		else
			return true;
	}
}