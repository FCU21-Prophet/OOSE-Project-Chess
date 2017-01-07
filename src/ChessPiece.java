import java.util.ArrayList;

public abstract class ChessPiece extends Piece {
	private String chessType;
	private boolean isMoved = false; //�Ѥl�O�_�w�g���ʹL�A�w�]��false�A�٨S���ʹL
	public boolean targetable = false; //�аO�ӺX�l�O�_���i���ʤ��ؼ�
	
	//�Ω��ˬdchessType�����A�d�߮ɡA�ϥ�ChessPiece.�Ѥl���O
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
			ChessPiece chessTemp = boardTemp[x][y]; //�Ȧs�n���ʪ��Ѥl������
			
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
	
	public abstract ArrayList<int[]> getMoveAble(); //�o�X�ӴѤl�i������l (��v�ѩζH�ѵ��~�����ʪ�����)
}
