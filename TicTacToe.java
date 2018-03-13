public class TicTacToe {
	

	//**Test run simple game
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();

		game.putMark(1,1);			game.putMark(0,2);
		game.putMark(2,2);			game.putMark(0,0);
		game.putMark(0,1);			game.putMark(2,1);
		game.putMark(1,2);			game.putMark(1,0);
		game.putMark(2,0);

		System.out.println(game);
		int winningPlayer = game.winner();
		String[] outcome = {"O Wins!", "Tie", "X Wins!"};
		System.out.println(outcome[1 + winningPlayer]);
	}



	public static final int X = 1, O = -1;		//Players
	public static final int EMPTY = 0;			//Empty Cell
	private int board[][] = new int[3][3];		//Game Board
	private int player;							//Current Player

	//**Constructor**
	public TicTacToe() {
		clearBoard();
	}

	//**Clearing board
	public void clearBoard() {
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				board[i][j] = EMPTY;		//Ensure every cell is empty to begin with
		player = X;
	}

	//**Puts an X or an O at position i.j
	public void putMark(int i, int j) throws IllegalStateException {
		if((i < 0) || (i > 2) || (j < 0) || (j > 2))
			throw new IllegalArgumentException("Invalid Board Position!");
		if(board[i][j] != EMPTY)
			throw new IllegalArgumentException("Board Position Occupied!");
		if(isWin(x || o))
			throw new IllegalArgumentException("Game Already Won!")
		board[i][j] = player;
		player = -player;
	}

	public boolean isWin(int mark) {
		return ((board[0][0] + board[0][1] + board[0][2] == mark*3)
			|| (board[1][0] + board[1][1] + board[1][2] == mark *3)
			|| (board[2][0] + board[2][1] + board[2][2] == mark *3)
			|| (board[0][0] + board[1][0] + board[2][0] == mark *3)
			|| (board[0][1] + board[1][1] + board[2][1] == mark *3)
			|| (board[0][2] + board[1][2] + board[2][2] == mark *3)
			|| (board[0][0] + board[1][1] + board[2][2] == mark *3)
			|| (board[2][0] + board[1][1] + board[0][2] == mark *3));
	}

	public int winner() {
		if(isWin(X))
			return(X);
		else if(isWin(O))
			return(O);
		else
			return(0);
	}

	//**Returns character string to show board
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j<3; j++) {
				switch (board[i][j]) {
					case X: sb.append("X"); break;
					case O: sb.append("O"); break;
					case EMPTY: sb.append(" "); break;
				}
				if (j < 2) sb.append("|");
			}
			if (i < 2) sb.append("\n-----\n");
		}
		return sb.toString();
	}
}