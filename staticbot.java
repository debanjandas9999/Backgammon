public class staticbot implements BotAPI {
	// The public API of Bot must not change
	// This is ONLY class that you can edit in the program
	// Rename Bot to the name of your team. Use camel case.
	// Bot may not alter the state of the game objects
	// It may only inspect the state of the board and the player objects

	private int win;
	private PlayerAPI me, opponent;
	private BoardAPI board;
	private CubeAPI cube;
	private MatchAPI match;
	private InfoPanelAPI info;
	private int[][] child2;
	private int[][] child3;
	private int[][] duplicate_board;
	private String[] x = new String[8];

	staticbot(PlayerAPI me, PlayerAPI opponent, BoardAPI board, CubeAPI cube, MatchAPI match, InfoPanelAPI info) {
		this.me = me;
		this.opponent = opponent;
		this.board = board;
		this.cube = cube;
		this.match = match;
		this.info = info;
	}

	public double my_pipcount() {

		int dupboard[][] = board.get();
		double myCount = 0;
		double numofcheckers = 0;
		for (int i = 25; i > 0; i--) {
			myCount = myCount + (i * dupboard[me.getId()][i]);
		}
		return myCount;
	}

	public double opp_pipcount() {

		int dupboard[][] = board.get();
		double myCount = 0;
		double numofcheckers = 0;
		for (int i = 25; i > 0; i--) {
			myCount = myCount + (i * dupboard[opponent.getId()][i]);
		}
		return myCount;
	}

	public String getName() {
		return "staticbot"; // must match the class name
	}

	public boolean isFirstMove() {
		int flag = 0;
		child2 = board.get();
		int Reset[] = { 0, 0, 0, 0, 0, 0, 5, 0, 3, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0 };
		for (int i = 0; i < 26; i++) {
			if (child2[me.getId()][i] != Reset[i])
				return false;
		}
		return true;
	}

	public int off(String to) {
		int a = 0;
		if (to.equals("off")) {
			a = 10;
		}
		return a;
	}

	public int bar(String from) {
		int a = 0;
		if (from.equals("from")) {
			a = 3;
		}
		return a;
	}

	public int hit() {
		int a = 4;
		return a;
	}

	public boolean numloneRanger(int ar[][]) {
		// child2 = board.get();
		for (int i = 1; i < 26; i++) {
			if (ar[me.getId()][i] == 1)
				return false;
		}
		return true;
	}

	public boolean prime(int newar[][], int prear[][]) {
		int newcount = 0;
		int count = 0;
//  child2 = board.get();

		for (int i = 1; i < 26; i++) {
			if (newar[me.getId()][i] == 1)
				newcount++;
		}

		for (int i = 1; i < 26; i++) {
			if (prear[me.getId()][i] == 1)
				count++;
		}

		if (newcount < count)
			return true;
		else
			return false;
	}

	public boolean futurePrime(int newarr[][], int prearr[][]) {
		int newcount = 0;
		int count = 0;

		for (int i = 1; i < 26; i++) {
			if (newarr[me.getId()][i] == 1)
				newcount++;
		}
//  System.out.println("newcount "+ newcount);
//  for(int g=1;g<26;g++)
//  {
//	  System.out.print(newarr[me.getId()][g]+" ");
//  }
//  

		for (int i = 1; i < 26; i++) {
			if (prearr[me.getId()][i] == 1)
				count++;
		}

//  System.out.println("count "+ count);
//  for(int g=1;g<26;g++)
//  {
//	  System.out.print(prearr[me.getId()][g]+" ");
//  }

		if (newcount == count)
			return true;
		else
			return false;
	}

	public int loneRanger(String fro, String to, int aa[][]) {

		int naa[][] = new int[2][26];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 26; j++) {
				naa[i][j] = aa[i][j];
			}
		}
		int arr[][] = move(me, fro, to, naa);
		if (prime(arr, aa) == true)
			return 1;
		else
			return 0;
	}

	public int futureMove(String fro, String to, int ar[][]) {

		int nar[][] = new int[2][26];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 26; j++) {
				nar[i][j] = ar[i][j];
			}
		}

		int arr[][] = move(me, fro, to, nar);
//  System.out.println("in fumo");
//  for(int g=1;g<26;g++)
//  {
//	  System.out.print(arr[me.getId()][g]+" ");
//  }
		if (futurePrime(arr, ar) == true)
			return 1;
		else
			return 0;
	}

	public void hit(Plays possiblePlays) {
		for (int i = 0; i < possiblePlays.number(); i++) {
			String play = possiblePlays.get(i).toString();
			x = play.split("\\s+");
			if (x[0].charAt(x[0].length() - 1) == '*' || x[1].charAt(x[1].length() - 1) == '*') {
			}
		}
	}

	public String formingPrimes(Plays possiblePlays) {
		for (int i = 0; i < possiblePlays.number(); i++) {
			// child2 = board.get();
			// System.out.println(child2);
			String play = possiblePlays.get(i).toString();
			System.out.println(play);
			x = play.split("\\s+");
			if ((x[0].substring(x[0].indexOf('-') + 1)).equals((x[1].substring(x[1].indexOf('-') + 1))))
				return Integer.toString(i + 1);
		}
		return "false";
	}

