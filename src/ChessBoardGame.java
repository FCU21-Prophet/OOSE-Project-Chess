import java.util.ArrayList;

public class ChessBoardGame extends BoardGame{

	public boolean playerChosing = true;
	public ChessPiece chessPicking; //�ثe�Q��W���Ѥl�A���ݵ۳Q���ʡA�εۧ�h���L�Ѥl
	
	public Piece[][] makeBoard(int x , int y)
	{
		return new ChessPiece[x][y];
	}
	
	@Override
	public void arrangeBoard(String playerNameA , String playerNameB)
	{
		// TODO Auto-generated method stub
		this.playerA = new Player(playerNameA , Player.FIRST);
		this.playerB = new Player(playerNameB , Player.SECOND);
		this.nowPlayer = this.playerA;
		
		this.setBoard(8 , 8);
		
		for(int i = 0 ; i < this.getBoard().length ; i++)
		{
			for(int j = 0 ; j < this.getBoard().length ; j++)
			{
				if(i == 1)
				{
					//�o�@�Ƴ��O��⪺�p�L
					this.setPiece(i , j , new PawnChessPiece(i , j , Player.SECOND , this) );
				}
				else if(i == 0 && j == 0)
				{
					this.setPiece(i, j, new CastleChessPiece(i , j , Player.SECOND , this) );
				}
				else if(i == 0 && j == 1)
				{
					this.setPiece(i, j, new KnightChessPiece(i , j , Player.SECOND , this) );
				}
				else if(i == 0 && j == 2)
				{
					this.setPiece(i, j, new BishopChessPiece(i , j , Player.SECOND , this) );
				}
				else if(i == 0 && j == 3)
				{
					this.setPiece(i, j, new QueenChessPiece(i , j , Player.SECOND , this) );
				}
				else if(i == 0 && j == 4)
				{
					this.setPiece(i, j, new KingChessPiece(i , j , Player.SECOND , this) );
				}
				else if(i == 0 && j == 5)
				{
					this.setPiece(i, j, new BishopChessPiece(i , j , Player.SECOND , this) );
				}
				else if(i == 0 && j == 6)
				{
					this.setPiece(i, j, new KnightChessPiece(i , j , Player.SECOND , this) );
				}
				else if(i == 0 && j == 7)
				{
					this.setPiece(i, j, new CastleChessPiece(i , j , Player.SECOND , this) );
				}
				else if(i == 6)
				{
					//�o�@�Ƴ��O���⪺�p�L
					this.setPiece(i , j , new PawnChessPiece(i , j , Player.FIRST , this) );
				}
				else if(i == 7 && j == 0)
				{
					this.setPiece(i, j, new CastleChessPiece(i , j , Player.FIRST , this) );
				}
				else if(i == 7 && j == 1)
				{
					this.setPiece(i, j, new KnightChessPiece(i , j , Player.FIRST , this) );
				}
				else if(i == 7 && j == 2)
				{
					this.setPiece(i, j, new BishopChessPiece(i , j , Player.FIRST , this) );
				}
				else if(i == 7 && j == 3)
				{
					this.setPiece(i, j, new QueenChessPiece(i , j , Player.FIRST , this) );
				}
				else if(i == 7 && j == 4)
				{
					this.setPiece(i, j, new KingChessPiece(i , j , Player.FIRST , this) );
				}
				else if(i == 7 && j == 5)
				{
					this.setPiece(i, j, new BishopChessPiece(i , j , Player.FIRST , this) );
				}
				else if(i == 7 && j == 6)
				{
					this.setPiece(i, j, new KnightChessPiece(i , j , Player.FIRST , this) );
				}
				else if(i == 7 && j == 7)
				{
					this.setPiece(i, j, new CastleChessPiece(i , j , Player.FIRST , this) );
				}
				else
				{
					this.setPiece(i , j , new NoneChessPiece(i , j , Player.NONE , this) );
				}
			}
		}
	}
	
	private void refreshTargetable()
	{
		for(int i = 0 ; i < this.getBoard().length ; i++)
		{
			for(int j = 0 ; j < this.getBoard()[i].length ; j++)
			{
				ChessPiece CPTemp = (ChessPiece)this.getBoard()[i][j];
				CPTemp.targetable = false;
			}
		}
	}
	private void setTargetable(ArrayList<int[]> input) //�̷ӥثe�ҿ�쪺�Ѥl�A�]�w���ǴѮ�O�i���ʪ�
	{
		int xTemp;
		int yTemp;
		for(int i = 0 ; i < input.size() ; i++)
		{
			xTemp = input.get(i)[0];
			yTemp = input.get(i)[1];
			ChessPiece CPTemp = (ChessPiece)this.getBoard()[xTemp][yTemp];
			CPTemp.targetable = true;
		}
	}
	
	public void eatCommand(int x , int y)
	{
		ChessPiece CPTemp = (ChessPiece)this.getBoard()[x][y];
		if(CPTemp.chessTeam == this.nowPlayer.chessTeam && CPTemp != this.chessPicking)
		{
			this.chessPicking = CPTemp;
			this.refreshTargetable();
			this.setTargetable(this.chessPicking.getMoveAble() );
		}
		else if(CPTemp.targetable)
		{
			this.chessPicking.moveTo(x, y);
			this.refreshTargetable();
			if(this.nowPlayer == this.playerA)
			{
				this.nowPlayer = this.playerB;
			}
			else
			{
				this.nowPlayer = this.playerA;
			}			
		}
	}

	@Override
	public void showBoard() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < this.getBoard().length ; i++)
		{
			for(int j = 0 ; j < this.getBoard()[i].length ; j++)
			{
				ChessPiece CPTemp = (ChessPiece)this.getBoard()[i][j];
				System.out.print(CPTemp.getChessType() + "/" + CPTemp.targetable + " ");
			}
			System.out.println();
		}
	}
}
