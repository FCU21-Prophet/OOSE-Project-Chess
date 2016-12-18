public class ClientTest {
	public static void main(String args[] )
	{
		BoardGame BG = ChessBoardGame.getInstance();
		BG.setPlayer("WHITE", "BLACK");
		
		ChessGUI testGUI = new ChessGUI();
		 
	}
	
}
