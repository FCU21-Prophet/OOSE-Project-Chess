
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
	
	protected abstract Piece[][] makeBoard(int x , int y); 
	protected abstract void arrangeBoard(); //�\��Ѥl
	public abstract void showBoard(); //�L�X�ѽL���e���p�A���ե�
	public abstract void commandHandle(int x, int y);
	public abstract boolean hasWinner();
	public abstract String printWinner();
}