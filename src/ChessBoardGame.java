import java.util.ArrayList;
import java.util.Random;

public class ChessBoardGame extends BoardGame{

	public boolean playerChosing = true;
	public ChessPiece chessPicking; //目前被選上的棋子，等待著被移動，或著改去選其他棋子
	
	private ChessBoardGame()
	{		
	}
	
	protected Piece[][] makeBoard(int x , int y)
	{
		return new ChessPiece[x][y];
	}
	
	@Override
	protected void arrangeBoard()
	{
		// TODO Auto-generated method stub		
		this.setBoard(8 , 8);
		
		for(int i = 0 ; i < this.getBoard().length ; i++)
		{
			for(int j = 0 ; j < this.getBoard().length ; j++)
			{
				if(i == 1)
				{
					//這一排都是後手的小兵
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
					//這一排都是先手的小兵
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
	
	public static BoardGame getInstance()
	{
		if(BoardGame.uniqueInstance == null)
		{
			BoardGame.uniqueInstance = new ChessBoardGame();
			BoardGame.uniqueInstance.arrangeBoard();			
		}
		return BoardGame.uniqueInstance;
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
	private void setTargetable(ArrayList<int[]> input) //依照目前所選到的棋子，設定哪些棋格是可移動的
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
	
	public void commandHandle(int x , int y)
	{
		ChessPiece CPTemp = (ChessPiece)this.getBoard()[x][y];
		if(CPTemp.chessTeam == this.nowPlayer.chessTeam && CPTemp != this.chessPicking)
		{
			//選棋階段，看哪些格子可動
			this.chessPicking = CPTemp;
			this.refreshTargetable();
			this.setTargetable(this.chessPicking.getMoveAble() );
		}
		else if(CPTemp.targetable)
		{
			//確定成功，可移動
			this.chessPicking.moveTo(x, y);
			this.refreshTargetable();
			if(!hasWinner())
			{
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
	}

	@Override
	public void showBoard() 
	{
		// TODO Auto-generated method stub
		for(int i = 0 ; i < this.getBoard().length ; i++)
		{
			for(int j = 0 ; j < this.getBoard()[i].length ; j++)
			{
				ChessPiece CPTemp = (ChessPiece)this.getBoard()[i][j];
				System.out.print(CPTemp.getChessType() + "/" + CPTemp.targetable + "\t");
			}
			System.out.println();
		}
	}

	@Override
	public boolean hasWinner() {
		// TODO Auto-generated method stub
		int count = 0;
		ChessPiece[][] CPTemp = (ChessPiece[][])this.getBoard();
		for(int i = 0 ; i < this.getBoard().length ; i++)
		{
			for(int j = 0 ; j < this.getBoard()[i].length ; j++)
			{
				if(CPTemp[i][j] instanceof KingChessPiece)
					count = count + 1;
			}
		}
		if(count == 2)
			return false;
		else
			return true;

	}

	@Override
	public String printWinner() {
		// TODO Auto-generated method stub
		String[] randomLyrics = {"他強任他強，清風拂山崗；他橫任他橫，明月照大江。" , "他自狠來他自惡，我自一口真氣足。"};
		Random random = new Random();
		return randomLyrics[random.nextInt(randomLyrics.length)] + "   恭喜" + this.nowPlayer.playerName + "獲勝!";
	}

	
}
