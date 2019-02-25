package debback2;

public class Game {

	int PLAYERS = 2;
	int PIP = 26;
	private int START;
	private int END;
	static Board board = new Board();

	private static int ARR[][] = board.getArray();
	static private int arr[][];

	public Game() {
		arr = new int[PLAYERS][PIP];

		arr = ARR;

	}

	public Game(int start, int end) {
		START = start;
		END = end;
		arr = new int[PLAYERS][PIP];

		arr = ARR;

	}

	public boolean isValid(int in) {
		if (arr[in][START] == 0 || START > 24 || END > 24 || START < 0 || END < 0)
			return false;

		return true;
	}

	public int[][] getARR() {
		return arr;
	}

	public void updateArray(int in, int prev_pip, int next_pip) {
		arr[in][prev_pip]--;
		arr[in][next_pip]++;
	}
}
