
public abstract class BoardGame {
	public Player playerA , playerB;
	public Player nowPlayer;
	private Piece[][] board;
	public boolean isGaming = true;
	protected static BoardGame uniqueInstance = null;
	
	public static BoardGame getInstance()
	{
		return uniqueInstance;
	}
	
	public void setPlayer(String playerNameA , String playerNameB)
	{
		this.playerA = new Player(playerNameA , Player.FIRST);
		this.playerB = new Player(playerNameB , Player.SECOND);
		this.nowPlayer = this.playerA;
	}
	public Piece[][] getBoard()
	{
		return this.board;
	}
	protected void setBoard(int x , int y)
	{
		if(this.board == null)
		{
			this.board = makeBoard(x ,  y);
		}
	}
	
	public void setPiece(int x , int y , Piece piece)
	{
		this.board[x][y] = piece;
	}
	
	public void eatCommand(int x , int y)
	{
		if(this.isGaming)
		{
			commandHandle(x, y);
		}		
		if(this.hasWinner())
		{
			this.isGaming = false;
			printWinner();
		}
	}
	
	public void restart()
	{
		this.arrangeBoard();
		this.setPlayer(this.playerA.playerName , this.playerB.playerName);
		this.isGaming = true;
	}
	
	protected abstract Piece[][] makeBoard(int x , int y); 
	protected abstract void arrangeBoard(); //擺放棋子
	public abstract void showBoard(); //印出棋盤內容狀況，測試用
	public abstract void commandHandle(int x, int y);
	public abstract boolean hasWinner();
	public abstract String printWinner();
}