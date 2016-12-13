import java.util.ArrayList;

public class KnightChessPiece extends ChessPiece
{
	public KnightChessPiece(int x , int y , int chessTeam , BoardGame boardGame)
	{
		// TODO �����n�]�w�L���Ѥl���O
		// TODO �����a�J�y��
		// TODO �]�w�L���Ѥl����
		// TODO �N�ѽL�C���]�i�h 
		this.setChessType(ChessPiece.KNIGHT);
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
		
		if(originX-1 >= 0 && originY-2 >= 0)
		{
			//�u�n���O�ۤv�誺�Ѥl�N�i�H��
			if(this.getBoardGame().getBoard()[originX-1][originY-2].chessTeam != this.chessTeam)
			{
				moveAble[0] = originX-1;
				moveAble[1] = originY-2;
				output.add(moveAble.clone() );
			}
		}
		
		if(originX-2 >= 0 && originY-1 >= 0)
		{
			//�u�n���O�ۤv�誺�Ѥl�N�i�H��
			if(this.getBoardGame().getBoard()[originX-2][originY-1].chessTeam != this.chessTeam)
			{
				moveAble[0] = originX-2;
				moveAble[1] = originY-1;
				output.add(moveAble.clone() );
			}
		}
		
		if(originX-2 >= 0 && originY+1 < this.getBoardGame().getBoard().length)
		{
			//�u�n���O�ۤv�誺�Ѥl�N�i�H��
			if(this.getBoardGame().getBoard()[originX-2][originY+1].chessTeam != this.chessTeam)
			{
				moveAble[0] = originX-2;
				moveAble[1] = originY+1;
				output.add(moveAble.clone() );
			}
		}
		
		if(originX-1 >= 0 && originY+2 < this.getBoardGame().getBoard().length)
		{
			//�u�n���O�ۤv�誺�Ѥl�N�i�H��
			if(this.getBoardGame().getBoard()[originX-1][originY+2].chessTeam != this.chessTeam)
			{
				moveAble[0] = originX-1;
				moveAble[1] = originY+2;
				output.add(moveAble.clone() );
			}
		}
		
		if(originX+1 < this.getBoardGame().getBoard().length && originY+2 < this.getBoardGame().getBoard().length)
		{
			//�u�n���O�ۤv�誺�Ѥl�N�i�H��
			if(this.getBoardGame().getBoard()[originX+1][originY+2].chessTeam != this.chessTeam)
			{
				moveAble[0] = originX+1;
				moveAble[1] = originY+2;
				output.add(moveAble.clone() );
			}
		}
		
		if(originX+2 < this.getBoardGame().getBoard().length && originY+1 < this.getBoardGame().getBoard().length)
		{
			//�u�n���O�ۤv�誺�Ѥl�N�i�H��
			if(this.getBoardGame().getBoard()[originX+2][originY+1].chessTeam != this.chessTeam)
			{
				moveAble[0] = originX+2;
				moveAble[1] = originY+1;
				output.add(moveAble.clone() );
			}
		}
		
		if(originX+2 < this.getBoardGame().getBoard().length && originY-1 >= 0)
		{
			//�u�n���O�ۤv�誺�Ѥl�N�i�H��
			if(this.getBoardGame().getBoard()[originX+2][originY-1].chessTeam != this.chessTeam)
			{
				moveAble[0] = originX+2;
				moveAble[1] = originY-1;
				output.add(moveAble.clone() );
			}
		}
		
		if(originX+1 < this.getBoardGame().getBoard().length && originY-2 >= 0)
		{
			//�u�n���O�ۤv�誺�Ѥl�N�i�H��
			if(this.getBoardGame().getBoard()[originX+1][originY-2].chessTeam != this.chessTeam)
			{
				moveAble[0] = originX+1;
				moveAble[1] = originY-2;
				output.add(moveAble.clone() );
			}
		}
		return output;
	}
}
