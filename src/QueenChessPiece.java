import java.util.ArrayList;

public class QueenChessPiece extends ChessPiece
{
	
	public QueenChessPiece(int x , int y , int chessTeam , BoardGame boardGame)
	{
		this.setChessType(ChessPiece.QUEEN);
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
		int count = 1;
		
		//(-1,-1)
		//只要遇到牆或是自己的棋子就停
		while((originX-count >= 0 && originY-count >= 0) && this.getBoardGame().getBoard()[originX-count][originY-count].chessTeam != this.chessTeam)
		{
			moveAble[0] = originX-count;
			moveAble[1] = originY-count;
			output.add(moveAble.clone() );
			
			//在外面已經確定棋子不會碰到牆或自己的小兵，而這裡判斷是否為敵方小兵
			if(this.getBoardGame().getBoard()[originX-count][originY-count].chessTeam != 0) //不等於0也就是敵方棋子而不是空格
			{
				break;
			}
			count++;
		}
		count = 1;
		
		//(-1,0)
		while(originX-count >= 0 && this.getBoardGame().getBoard()[originX-count][originY].chessTeam != this.chessTeam)
		{
			moveAble[0] = originX-count;
			moveAble[1] = originY;
			output.add(moveAble.clone() );
			
			if(this.getBoardGame().getBoard()[originX-count][originY].chessTeam != 0)
			{
				break;
			}
			count++;
		}
		count = 1;
		
		//(-1,1)
		while((originX-count >= 0 && originY+count < this.getBoardGame().getBoard().length) && this.getBoardGame().getBoard()[originX-count][originY+count].chessTeam != this.chessTeam)
		{
			moveAble[0] = originX-count;
			moveAble[1] = originY+count;
			output.add(moveAble.clone() );
			
			if(this.getBoardGame().getBoard()[originX-count][originY+count].chessTeam != 0)
			{
				break;
			}
			count++;
		}
		count = 1;
		
		//(0,-1)
		while(originY-count >= 0 && this.getBoardGame().getBoard()[originX][originY-count].chessTeam != this.chessTeam)
		{
			moveAble[0] = originX;
			moveAble[1] = originY-count;
			output.add(moveAble.clone() );
			
			if(this.getBoardGame().getBoard()[originX][originY-count].chessTeam != 0)
			{
				break;
			}
			count++;
		}
        count = 1;
        
		//(0,1)
        while(originY+count < this.getBoardGame().getBoard().length && this.getBoardGame().getBoard()[originX][originY+count].chessTeam != this.chessTeam)
        {
        	moveAble[0] = originX;
			moveAble[1] = originY+count;
			output.add(moveAble.clone() );
			
			if(this.getBoardGame().getBoard()[originX][originY+count].chessTeam != 0)
			{
				break;
			}
			count++;
        }
        count = 1;

		//(1,-1)
        while((originX+count < this.getBoardGame().getBoard().length && originY-count >= 0) && this.getBoardGame().getBoard()[originX+count][originY-count].chessTeam != this.chessTeam)
        {
        	moveAble[0] = originX+count;
			moveAble[1] = originY-count;
			output.add(moveAble.clone() );
			
			if(this.getBoardGame().getBoard()[originX+count][originY-count].chessTeam != 0)
			{
				break;
			}
			count++;
        }
		count = 1;
		
		//(1,0)
		while(originX+count < this.getBoardGame().getBoard().length && this.getBoardGame().getBoard()[originX+count][originY].chessTeam != this.chessTeam)
		{
			moveAble[0] = originX+count;
			moveAble[1] = originY;
			output.add(moveAble.clone() );
			
			if(this.getBoardGame().getBoard()[originX+count][originY].chessTeam != 0)
			{
				break;
			}
			count++;
		}
		count = 1;
		
		//(1,1)
		while((originX+count < this.getBoardGame().getBoard().length && originY+count < this.getBoardGame().getBoard().length) && this.getBoardGame().getBoard()[originX+count][originY+count].chessTeam != this.chessTeam)
		{
			moveAble[0] = originX+count;
			moveAble[1] = originY+count;
			output.add(moveAble.clone() );
			
			if(this.getBoardGame().getBoard()[originX+count][originY+count].chessTeam != 0)
			{
				break;
			}
			count++;
		}
		count = 1;
				
		return output;
	}

}
