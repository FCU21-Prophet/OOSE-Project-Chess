import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessGUI extends JFrame implements ActionListener
{
	JPanel statusPanel;
	JPanel chessPanel;
	private JButton[][] board;
	private BoardGame boardGame;
	private JLabel status;
	public static ImageIcon WHITE_PAWN_IMAGE = new ImageIcon("img/chess_piece_white_pawn_T.png");
	public static ImageIcon WHITE_KING_IMAGE = new ImageIcon("img/chess_piece_white_king_T.png");
	public static ImageIcon WHITE_QUEEN_IMAGE = new ImageIcon("img/chess_piece_white_queen_T.png");
	public static ImageIcon WHITE_KNIGHT_IMAGE = new ImageIcon("img/chess_piece_white_knight_T.png");
	public static ImageIcon WHITE_BISHOP_IMAGE = new ImageIcon("img/chess_piece_white_bishop_T.png");
	public static ImageIcon WHITE_CASTLE_IMAGE = new ImageIcon("img/chess_piece_white_rook_T.png");
	
	public static ImageIcon BLACK_PAWN_IMAGE = new ImageIcon("img/chess_piece_black_pawn_T.png");
	public static ImageIcon BLACK_KING_IMAGE = new ImageIcon("img/chess_piece_black_king_T.png");
	public static ImageIcon BLACK_QUEEN_IMAGE = new ImageIcon("img/chess_piece_black_queen_T.png");
	public static ImageIcon BLACK_KNIGHT_IMAGE = new ImageIcon("img/chess_piece_black_knight_T.png");
	public static ImageIcon BLACK_BISHOP_IMAGE = new ImageIcon("img/chess_piece_black_bishop_T.png");
	public static ImageIcon BLACK_CASTLE_IMAGE = new ImageIcon("img/chess_piece_black_rook_T.png");

	public ChessGUI()
	{
		statusPanel = new JPanel();
		status = new JLabel();
		statusPanel.add(status);
		chessPanel = new JPanel();
		this.boardGame = ChessBoardGame.getInstance();
		this.board = new JButton[boardGame.getBoard().length][];
		this.setLayout(new BorderLayout() );
		this.setSize(720 , 740);
		chessPanel.setLayout(new GridLayout(8 , 8) );
		
		for(int i = 0 ; i < boardGame.getBoard().length ; i++)
		{
			this.board[i] = new JButton[boardGame.getBoard()[i].length];
			
			for(int j = 0 ; j < boardGame.getBoard()[i].length ; j++)
			{
				ChessPiece CPTemp = (ChessPiece)boardGame.getBoard()[i][j];
				
				this.board[i][j] = new JButton();
				this.board[i][j].setSize(90 , 90);
				this.board[i][j].addActionListener(this);
				if((i + j)%2 == 0)
				{
					this.board[i][j].setBackground(Color.DARK_GRAY);
				}
				else
				{
					this.board[i][j].setBackground(Color.GRAY);
				}
				
				chessPanel.add(this.board[i][j]);
			}
		}
		this.add(statusPanel , BorderLayout.NORTH);
		this.add(chessPanel , BorderLayout.CENTER);
		this.update();
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		boolean flag = true;
		for(int i = 0 ; i < this.board.length && flag ; i++)
		{
			for(int j = 0 ; j < this.board[i].length && flag ; j++)
			{
				if(this.board[i][j] == e.getSource() )
				{
					System.out.println("come in!");
					flag = false;
					this.boardGame.eatCommand(i, j);
					this.update();
				}
			}
		}		
	}
	
	private void update()
	{
		status.setText(boardGame.nowPlayer.playerName);
		if(boardGame.hasWinner())
			status.setText(boardGame.printWinner());
		for(int i = 0 ; i < boardGame.getBoard().length ; i++)
		{			
			for(int j = 0 ; j < boardGame.getBoard()[i].length ; j++)
			{
				ChessPiece CPTemp = (ChessPiece)boardGame.getBoard()[i][j];
				this.board[i][j].setIcon(null);
				this.board[i][j].setBorder(null);
				
				if(CPTemp instanceof PawnChessPiece && CPTemp.chessTeam == Player.FIRST)
				{
					this.board[i][j].setIcon(this.WHITE_PAWN_IMAGE);
				}
				else if(CPTemp instanceof KingChessPiece && CPTemp.chessTeam == Player.FIRST)
				{
					this.board[i][j].setIcon(this.WHITE_KING_IMAGE);
				}
				else if(CPTemp instanceof QueenChessPiece && CPTemp.chessTeam == Player.FIRST)
				{
					this.board[i][j].setIcon(this.WHITE_QUEEN_IMAGE);
				}
				else if(CPTemp instanceof KnightChessPiece && CPTemp.chessTeam == Player.FIRST)
				{
					this.board[i][j].setIcon(this.WHITE_KNIGHT_IMAGE);
				}
				else if(CPTemp instanceof BishopChessPiece && CPTemp.chessTeam == Player.FIRST)
				{
					this.board[i][j].setIcon(this.WHITE_BISHOP_IMAGE);
				}
				else if(CPTemp instanceof CastleChessPiece && CPTemp.chessTeam == Player.FIRST)
				{
					this.board[i][j].setIcon(this.WHITE_CASTLE_IMAGE);
				}
				
				else if(CPTemp instanceof PawnChessPiece && CPTemp.chessTeam == Player.SECOND)
				{
					this.board[i][j].setIcon(this.BLACK_PAWN_IMAGE);
				}
				else if(CPTemp instanceof KingChessPiece && CPTemp.chessTeam == Player.SECOND)
				{
					this.board[i][j].setIcon(this.BLACK_KING_IMAGE);
				}
				else if(CPTemp instanceof QueenChessPiece && CPTemp.chessTeam == Player.SECOND)
				{
					this.board[i][j].setIcon(this.BLACK_QUEEN_IMAGE);
				}
				else if(CPTemp instanceof KnightChessPiece && CPTemp.chessTeam == Player.SECOND)
				{
					this.board[i][j].setIcon(this.BLACK_KNIGHT_IMAGE);
				}
				else if(CPTemp instanceof BishopChessPiece && CPTemp.chessTeam == Player.SECOND)
				{
					this.board[i][j].setIcon(this.BLACK_BISHOP_IMAGE);
				}
				else if(CPTemp instanceof CastleChessPiece && CPTemp.chessTeam == Player.SECOND)
				{
					this.board[i][j].setIcon(this.BLACK_CASTLE_IMAGE);
				}
//				else if(CPTemp instanceof NoneChessPiece)
//				{
//					this.board[i][j]();
//				}
				
				if(CPTemp.targetable)
				{
					this.board[i][j].setBorder(BorderFactory.createMatteBorder(
						    5,5,5,5,Color.yellow) );
				}
			}
		}
	}
	
}
