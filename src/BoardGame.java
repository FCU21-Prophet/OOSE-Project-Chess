
public abstract class BoardGame {
	public Player playerA , playerB;
	public Player nowPlayer;
	private Piece[][] board;
	public boolean isGaming = true;
	
	public Piece[][] getBoard()
	{
		return this.board;
	}
	public void setBoard(int x , int y)
	{
		if(this.board == null)
		{
			this.board = makeBoard(x ,  y);
//			this.board = new Piece[x][y];
		}
	}
	
	public void setPiece(int x , int y , Piece piece)
	{
		this.board[x][y] = piece;
	}
	public abstract Piece[][] makeBoard(int x , int y); 
	public abstract void arrangeBoard(String playerNameA , String playerNameB); //擺放棋子
	public abstract void showBoard(); //印出棋盤內容狀況，測試用
	public abstract void eatCommand(int x , int y);
}