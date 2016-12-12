
public class ClientTest {
	public static void main(String args[] )
	{
		BoardGame BG = new ChessBoardGame();
		BG.arrangeBoard("Alice" , "Bob");
		
		BG.showBoard();
		BG.eatCommand(6, 1);
		System.out.println();
		System.out.println("6,1");
		BG.showBoard();
		BG.eatCommand(6 , 4);
		System.out.println();
		System.out.println("6,4");
		BG.showBoard();
		BG.eatCommand(1, 3);
		System.out.println();
		System.out.println("1,3");
		BG.showBoard();
		BG.eatCommand(4 , 4);
		System.out.println();
		System.out.println("4,4");
		BG.showBoard();
		BG.eatCommand(1, 3);
		System.out.println();
		System.out.println("1,3");
		BG.showBoard();
		BG.eatCommand(3, 3);
		System.out.println();
		System.out.println("3,3");
		BG.showBoard();
		BG.eatCommand(4, 4);
		System.out.println();
		System.out.println("4,4");
		BG.showBoard();
		BG.eatCommand(3, 3);
		System.out.println();
		System.out.println("3,3");
		BG.showBoard();
	}
	
}
