public class Player {
	public String playerName;
	public int chessTeam;
	
	public Player(String playerName , int chessTeam)
	{
		this.playerName = playerName;
		this.chessTeam = chessTeam;
	}
	
	public static final int NONE = 0;
	public static final int FIRST = 1;
	public static final int SECOND = 2;
}
