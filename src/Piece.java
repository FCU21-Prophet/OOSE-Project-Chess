public abstract class Piece {
	private int[] position = new int[2];
	public BoardGame boardGame;
	public int chessTeam; //棋子所屬陣營，1為先手，2為後手，0為沒有

	public void setPosition(int x , int y)
	{
		this.position[0] = x;
		this.position[1] = y;
	}
	public int[] getPosition()
	{
		return this.position.clone(); //這裡只扔clone是因為不想讓人家用get動到你的位子
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
