import java.util.ArrayList;

public class NoneChessPiece extends ChessPiece
{
	public NoneChessPiece(int x , int y , int chessTeam , BoardGame boardGame)
	{
		this.setChessType(ChessPiece.NONE);
		this.setPosition(x, y);
		this.setChessTeam(chessTeam);
		this.setBoardGame(boardGame);
	}
	
	@Override
	public ArrayList<int[]> getMoveAble() {
		// TODO Auto-generated method stub
		ArrayList<int[]> output = new ArrayList<int[]>();
		return output;
	}

}
