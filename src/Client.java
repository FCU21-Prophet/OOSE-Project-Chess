public class Client {
	public static void main(String args[] )
	{
		BoardGame BG = ChessBoardGame.getInstance();
		BG.setPlayer("WHITE", "BLACK");
		
		ChessGUI testGUI = new ChessGUI();
		 
	}
	
}
