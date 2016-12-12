import java.util.ArrayList;

public abstract class Piece {
	private int[] position = new int[2];
	public BoardGame boardGame;
	public int chessTeam; //�Ѥl���ݰ}��A1������A2�����A0���S��
	
	public void setPosition(int x , int y)
	{
		this.position[0] = x;
		this.position[1] = y;
	}
	public int[] getPosition()
	{
		return this.position.clone(); //�o�̥u��clone�O�]�����Q���H�a��get�ʨ�A����l
	}
	
	public void setBoardGame(BoardGame input)
	{
		this.boardGame = input;
	}
	public BoardGame getBoardGame()
	{
		return this.boardGame;
	}
	
	public void setChessTeam(int chessTeam)
	{
		this.chessTeam = chessTeam;
	}
	public int getChessTeam()
	{
		return this.chessTeam;
	}
}
