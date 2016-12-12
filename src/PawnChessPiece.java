import java.util.ArrayList;

public class PawnChessPiece extends ChessPiece
{
	public PawnChessPiece(int x , int y , int chessTeam , BoardGame boardGame)
	{
		// TODO �����n�]�w�L���Ѥl���O
		// TODO �����a�J�y��
		// TODO �]�w�L���Ѥl����
		// TODO �N�ѽL�C���]�i�h 
		this.setChessType(ChessPiece.PAWN);
		this.setPosition(x, y);
		this.setChessTeam(chessTeam);
		this.setBoardGame(boardGame);
	}
	
	@Override
	public ArrayList<int[]> getMoveAble() //��o�@��int�}�C��ArrayList�A�o�ǳ��O�L�i�H�����y��
	{
		// TODO Auto-generated method stub
		ArrayList<int[]> output = new ArrayList<int[]>();
		int originX = this.getPosition()[0]; //�����OPiece���s��position�A�䥻�謰int[2]�A�䤤0��x�A1��y
		int originY = this.getPosition()[1];
		int[] moveAble = new int[2];
		
		if(this.getChessTeam() == Player.FIRST && originX-1 >= 0)
		{
			//�p�G�O����A�åB�L���e�@�椣�|�W�X�ѽL(x == 0)
			
			if(this.getBoardGame().getBoard()[originX-1][originY] instanceof NoneChessPiece)
			{
				//�Y�p�L���e��S���Ѥl
				
				moveAble[0] = originX-1;
				moveAble[1] = originY;
				output.add(moveAble.clone() );
				
				if(this.getIsMoved() == false && this.getBoardGame().getBoard()[originX-2][originY] instanceof NoneChessPiece)
				{
					//�Y�e��L�ѡA�Ӥp�L�S�S�ʹL�A�h�i�ʨ�B
					moveAble[0] = originX-2;
					moveAble[1] = originY;
					output.add(moveAble.clone() );
				}
			}
			if(originY-1 >= 0)
			{
				//�i�_�����e�Y�l�A���ݥ��e���S���W�X�ѽL
				
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
				//�Y�p�L���e��S���Ѥl
				moveAble[0] = originX+1;
				moveAble[1] = originY;
				output.add(moveAble.clone() );
				
				if(this.getIsMoved() == false && this.getBoardGame().getBoard()[originX+2][originY] instanceof NoneChessPiece)
				{
					//�Y�e��L�ѡA�Ӥp�L�S�S�ʹL�A�h�i�ʨ�B
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
