import java.util.Scanner;

public class ClientTest {
	public static void main(String args[] )
	{
		BoardGame BG = ChessBoardGame.getInstance();
		BG.setPlayer("Alice", "Bob");
		
		ChessGUI testGUI = new ChessGUI();
		 
	}
	
}
