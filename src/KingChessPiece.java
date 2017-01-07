import java.util.ArrayList;

public class KingChessPiece extends ChessPiece
{
	public KingChessPiece(int x , int y , int chessTeam , BoardGame boardGame)
	{
		this.setChessType(ChessPiece.KING);
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
		
		//(-1,-1)
		if(originX-1 >= 0 && originY-1 >= 0)
		{
			//只要不是自己方的棋子就可以走
			if(this.getBoardGame().getBoard()[originX-1][originY-1].chessTeam != this.chessTeam)
			{
				moveAble[0] = originX-1;
				moveAble[1] = originY-1;
				output.add(moveAble.clone() );
			}
		}
		//(-1,0)
		if(originX-1 >= 0)
		{
			if(this.getBoardGame().getBoard()[originX-1][originY].chessTeam != this.chessTeam)
			{
				moveAble[0] = originX-1;
				moveAble[1] = originY;
				output.add(moveAble.clone() );
			}
		}
		//(-1,1)
		if(originX-1 >= 0 && originY+1 < this.getBoardGame().getBoard().length)
		{
			if(this.getBoardGame().getBoard()[originX-1][originY+1].chessTeam != this.chessTeam)
			{
				moveAble[0] = originX-1;
				moveAble[1] = originY+1;
				output.add(moveAble.clone() );
			}
		}
		//(0,-1)
		if(originY-1 >= 0)
		{
			if(this.getBoardGame().getBoard()[originX][originY-1].chessTeam != this.chessTeam)
			{
				moveAble[0] = originX;
				moveAble[1] = originY-1;
				output.add(moveAble.clone() );
			}
		}
		//(0,1)
		if(originY-1 < this.getBoardGame().getBoard().length)
		{
			if(this.getBoardGame().getBoard()[originX][originY+1].chessTeam != this.chessTeam)
			{
				moveAble[0] = originX;
				moveAble[1] = originY+1;
				output.add(moveAble.clone() );
			}
		}
		//(1,-1)
		if(originX+1 < this.getBoardGame().getBoard().length && originY-1 >= 0)
		{
			if(this.getBoardGame().getBoard()[originX+1][originY-1].chessTeam != this.chessTeam)
			{
				moveAble[0] = originX+1;
				moveAble[1] = originY-1;
				output.add(moveAble.clone() );
			}
		}
		//(1,0)
		if(originX+1 < this.getBoardGame().getBoard().length)
		{
			if(this.getBoardGame().getBoard()[originX+1][originY].chessTeam != this.chessTeam)
			{
				moveAble[0] = originX+1;
				moveAble[1] = originY;
				output.add(moveAble.clone() );
			}
		}
		//(1,1)
		if(originX+1 < this.getBoardGame().getBoard().length && originY+1 < this.getBoardGame().getBoard().length)
		{
			if(this.getBoardGame().getBoard()[originX+1][originY+1].chessTeam != this.chessTeam)
			{
				moveAble[0] = originX+1;
				moveAble[1] = originY+1;
				output.add(moveAble.clone() );
			}
		}
		
		return output;
	}

}
