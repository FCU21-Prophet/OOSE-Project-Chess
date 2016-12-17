import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChessGUI extends JFrame implements ActionListener
{
	JPanel statusPanel;
	JPanel chessPanel;
	private JButton[][] board;
	private BoardGame boardGame;
	private JLabel status;
	public static final ImageIcon WHITE_PAWN_IMAGE = new ImageIcon("white_pawn.png");
	public static final ImageIcon WHITE_KING_IMAGE = new ImageIcon("white_king.png");
	public static final ImageIcon WHITE_QUEEN_IMAGE = new ImageIcon("white_queen.png");
	public static final ImageIcon WHITE_KNIGHT_IMAGE = new ImageIcon("white_knight.png");
	public static final ImageIcon WHITE_BISHOP_IMAGE = new ImageIcon("white_bishop.png");
	public static final ImageIcon WHITE_CASTLE_IMAGE = new ImageIcon("white_castle.png");
	
	public static final ImageIcon BLACK_PAWN_IMAGE = new ImageIcon("black_pawn.png");
	public static final ImageIcon BLACK_KING_IMAGE = new ImageIcon("black_king.png");
	public static final ImageIcon BLACK_QUEEN_IMAGE = new ImageIcon("black_queen.png");
	public static final ImageIcon BLACK_KNIGHT_IMAGE = new ImageIcon("black_knight.png");
	public static final ImageIcon BLACK_BISHOP_IMAGE = new ImageIcon("black_bishop.png");
	public static final ImageIcon BLACK_CASTLE_IMAGE = new ImageIcon("black_castle.png");
	
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
