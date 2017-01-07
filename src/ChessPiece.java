import java.util.ArrayList;

public abstract class ChessPiece extends Piece {
	private String chessType;
	private boolean isMoved = false; //棋子是否已經移動過，預設為false，還沒移動過
	public boolean targetable = false; //標記該旗子是否為可移動之目標
	
	//用於檢查chessType的表格，查詢時，使用ChessPiece.棋子類別
	public static final String PAWN = "PAWN";
	public static final String KING = "KING";
	public static final String QUEEN = "QUEEN";
	public static final String KNIGHT = "KNIGHT";
	public static final String BISHOP = "BISHOP";
	public static final String CASTLE = "CASTLE";
	public static final String NONE = "NONE";
	
	public void setChessType(String chessType)
	{
		this.chessType = chessType;
	}
	public String getChessType()
	{
		return this.chessType;
	}
	
	public boolean getIsMoved()
	{
		return this.isMoved;
	}
	
	public void moveTo(int x , int y)
	{
		ChessPiece[][] boardTemp = (ChessPiece[][]) this.boardGame.getBoard();
		
		if(boardTemp[x][y] instanceof ChessPiece)
		{
			ChessPiece chessTemp = boardTemp[x][y]; //暫存要移動的棋子之指標
			
			if(chessTemp.getChessTeam() != this.getChessTeam() )
			{
				boardTemp[x][y] = new NoneChessPiece(x , y , Player.NONE , this.boardGame);
				chessTemp = boardTemp[x][y];
				
				int originX = this.getPosition()[0];
				int originY = this.getPosition()[1];
				boardTemp[x][y] = boardTemp[originX][originY];
				boardTemp[originX][originY] = chessTemp;
				
				this.setPosition(x, y);
				this.isMoved = true;
			}			
		}		
	}
	
	public abstract ArrayList<int[]> getMoveAble(); //得出該棋子可走的位子 (西洋棋或象棋等才有移動的概念)
}
