import java.util.ArrayList;

public class CastleChessPiece extends ChessPiece
{
	public CastleChessPiece(int x , int y , int chessTeam , BoardGame boardGame)
	{
		// TODO �����n�]�w�L���Ѥl���O
		// TODO �����a�J�y��
		// TODO �]�w�L���Ѥl����
		// TODO �N�ѽL�C���]�i�h 
		this.setChessType(ChessPiece.CASTLE);
		this.setPosition(x, y);
		this.setChessTeam(chessTeam);
		this.setBoardGame(boardGame);
	}
	
	@Override
	public ArrayList<int[]> getMoveAble() 
	{
		ArrayList<int[]> output = new ArrayList<int[]>();
		int originX = this.getPosition()[0];
		int originY = this.getPosition()[1];
		int[] moveAble = new int[2];
		
		for(int x = originX - 1; x >= 0; x--)
		{
			if(this.getBoardGame().getBoard()[x][originY] instanceof NoneChessPiece)
			{
				moveAble[0] = x;
				moveAble[1] = originY;
				output.add(moveAble.clone() );
			}
			else
			{
				if(this.getBoardGame().getBoard()[x][originY].chessTeam != this.chessTeam)
				{
					moveAble[0] = x;
					moveAble[1] = originY;
					output.add(moveAble.clone() );
				}
				break;
			}
		}
		
		for(int x = originX + 1; x < this.getBoardGame().getBoard().length; x++)
		{
			if(this.getBoardGame().getBoard()[x][originY] instanceof NoneChessPiece)
			{
				moveAble[0] = x;
				moveAble[1] = originY;
				output.add(moveAble.clone() );
			}
			else
			{
				if(this.getBoardGame().getBoard()[x][originY].chessTeam != this.chessTeam)
				{
					moveAble[0] = x;
					moveAble[1] = originY;
					output.add(moveAble.clone() );
				}
				break;
			}
		}
		
		for(int y = originY - 1; y >= 0; y--)
		{
			if(this.getBoardGame().getBoard()[originX][y] instanceof NoneChessPiece)
			{
				moveAble[0] = originX;
				moveAble[1] = y;
				output.add(moveAble.clone() );
			}
			else
			{
				if(this.getBoardGame().getBoard()[originX][y].chessTeam != this.chessTeam)
				{
					moveAble[0] = originX;
					moveAble[1] = y;
					output.add(moveAble.clone() );
				}
				break;
			}
		}
		
		for(int y = originY + 1; y < this.getBoardGame().getBoard().length; y++)
		{
			if(this.getBoardGame().getBoard()[originX][y] instanceof NoneChessPiece)
			{
				moveAble[0] = originX;
				moveAble[1] = y;
				output.add(moveAble.clone() );
			}
			else
			{
				if(this.getBoardGame().getBoard()[originX][y].chessTeam != this.chessTeam)
				{
					moveAble[0] = originX;
					moveAble[1] = y;
					output.add(moveAble.clone() );
				}
				break;
			}
		}
		
		return output;
	}
}
