import java.util.ArrayList;

public class PawnChessPiece extends ChessPiece
{
	public PawnChessPiece(int x , int y , int chessTeam , BoardGame boardGame)
	{
		// TODO 必須要設定他的棋子類別
		// TODO 必須帶入座標
		// TODO 設定他的棋子隊伍
		// TODO 將棋盤遊戲設進去 
		this.setChessType(ChessPiece.PAWN);
		this.setPosition(x, y);
		this.setChessTeam(chessTeam);
		this.setBoardGame(boardGame);
	}
	
	@Override
	public ArrayList<int[]> getMoveAble() //獲得一個int陣列之ArrayList，這些都是他可以走的座標
	{
		// TODO Auto-generated method stub
		ArrayList<int[]> output = new ArrayList<int[]>();
		int originX = this.getPosition()[0]; //父類別Piece中存著position，其本質為int[2]，其中0為x，1為y
		int originY = this.getPosition()[1];
		int[] moveAble = new int[2];
		
		if(this.getChessTeam() == Player.FIRST && originX-1 >= 0)
		{
			//如果是先手，並且他往前一格不會超出棋盤(x == 0)
			
			if(this.getBoardGame().getBoard()[originX-1][originY] instanceof NoneChessPiece)
			{
				//若小兵正前方沒有棋子
				
				moveAble[0] = originX-1;
				moveAble[1] = originY;
				output.add(moveAble.clone() );
				
				if(this.getIsMoved() == false && this.getBoardGame().getBoard()[originX-2][originY] instanceof NoneChessPiece)
				{
					//若前方無棋，而小兵又沒動過，則可動兩步
					moveAble[0] = originX-2;
					moveAble[1] = originY;
					output.add(moveAble.clone() );
				}
			}
			if(originY-1 >= 0)
			{
				//可否往左前吃子，先看左前有沒有超出棋盤
				
				if( !(this.getBoardGame().getBoard()[originX-1][originY-1] instanceof NoneChessPiece) )
				{
					if(this.getBoardGame().getBoard()[originX-1][originY-1].chessTeam != this.chessTeam)
					{
						moveAble[0] = originX-1;
						moveAble[1] = originY-1;
						output.add(moveAble.clone() );
					}
				}
			}
			if(originY+1 < this.getBoardGame().getBoard().length)
			{
				if( !(this.getBoardGame().getBoard()[originX-1][originY+1] instanceof NoneChessPiece) )
				{
					if(this.getBoardGame().getBoard()[originX-1][originY+1].chessTeam != this.chessTeam)
					{
						moveAble[0] = originX-1;
						moveAble[1] = originY+1;
						output.add(moveAble.clone() );
					}
				}
			}
		}
		
		else if(this.getChessTeam() == Player.SECOND && originX+1 < this.getBoardGame().getBoard().length)
		{
			if(this.getBoardGame().getBoard()[originX+1][originY] instanceof NoneChessPiece)
			{
				//若小兵正前方沒有棋子
				moveAble[0] = originX+1;
				moveAble[1] = originY;
				output.add(moveAble.clone() );
				
				if(this.getIsMoved() == false && this.getBoardGame().getBoard()[originX+2][originY] instanceof NoneChessPiece)
				{
					//若前方無棋，而小兵又沒動過，則可動兩步
					moveAble[0] = originX+2;
					moveAble[1] = originY;
					output.add(moveAble.clone() );
				}
			}
			if(originY-1 >= 0)
			{
				if( !(this.getBoardGame().getBoard()[originX+1][originY-1] instanceof NoneChessPiece) )
				{
					if(this.getBoardGame().getBoard()[originX+1][originY-1].chessTeam != this.chessTeam)
					{
						moveAble[0] = originX+1;
						moveAble[1] = originY-1;
						output.add(moveAble.clone() );
					}
				}
			}
			if(originY+1 < this.getBoardGame().getBoard().length)
			{
				if( !(this.getBoardGame().getBoard()[originX+1][originY+1] instanceof NoneChessPiece) )
				{
					if(this.getBoardGame().getBoard()[originX+1][originY+1].chessTeam != this.chessTeam)
					{
						moveAble[0] = originX+1;
						moveAble[1] = originY+1;
						output.add(moveAble.clone() );
					}
				}
			}
		}
		
		return output;
	}
	
}
