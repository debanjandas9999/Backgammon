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

	public String getCommand(Plays possiblePlays) {
		int d0;
		int d1;
		int flag = 0;
		String from, to;
		String st = "";
		to = " ";
		from = "";
		double max[][] = new double[1000][1000];
		double maximum = max[0][0];
		if (isFirstMove()) {
			System.out.println("true");
			Dice di = me.getDuplicateDice();
			Dice di2 = opponent.getDuplicateDice();

			child2 = board.get();
			child3 = board.get();
			int Reset[] = { 0, 0, 0, 0, 0, 0, 5, 0, 3, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0 };
			for (int i = 0; i < 26; i++) {
				if (child2[opponent.getId()][i] != Reset[i])
					flag = 1;
			}

			if (flag == 1) {
				d0 = di.getDie(0);
				d1 = di.getDie(1);
			} else {
				d0 = di.getDie(0);
				d1 = di2.getDie(0);
			}

			System.out.println("d0 = " + d0);
			System.out.println("d1 = " + d1);

			if (d0 - d1 == 5 || d1 - d0 == 5) {
				System.out.println("inside 5 ");
				for (int i = 0; i < possiblePlays.number(); i++) {
					String play = possiblePlays.get(i).toString();
					System.out.println(play);
					x = play.split("\\s+");
					if ((x[0].substring(x[0].indexOf('-') + 1)).equals((x[1].substring(x[1].indexOf('-') + 1))))
						return Integer.toString(i + 1);
				}
			}

			if (d0 - d1 == 2 || d1 - d0 == 2) {
				System.out.println("inside 2 ");
				for (int i = 0; i < possiblePlays.number(); i++) {
					String play = possiblePlays.get(i).toString();
					System.out.println(play);
					x = play.split("\\s+");
					if ((x[0].substring(x[0].indexOf('-') + 1)).equals((x[1].substring(x[1].indexOf('-') + 1))))
						return Integer.toString(i + 1);

				}
			}
		}

		for (int i = 0; i < possiblePlays.number(); i++) {
			System.out.println("LENGTH =" + possiblePlays.number());
			child2 = board.get();
			// System.out.println(child2);
			String play = possiblePlays.get(i).toString();
			x = play.split("\\s+");

			int updarr[][] = board.get();
			for (int j = 0; j < x.length; j++) {
				System.out.println(x[j]);
				x[j] = x[j].replace('-', '@');
				x[j] = x[j].replace('*', '@');
				// System.out.println(x[j]);

				if (x[j].substring(0, 3).equalsIgnoreCase("Bar")) {
					x[j] = "25".concat(x[j].substring(3));
					// System.out.println(x[j]);
				}

				if (x[j].substring(x[j].indexOf('@') + 1).equalsIgnoreCase("Off")) {
					x[j] = (x[j].substring(0, x[j].indexOf('@') + 1)).concat("0");
					// System.out.println(x[j]);
				}

//		    if (x[j].length() >= 4) 
//		    {
//			     if (x[j].substring(x[j].length() - 3).equalsIgnoreCase("Off"))
//			     {
//			    	 x[j] = (x[j].substring(0, x[j].length() - 3)).concat("0");
//			    	//  System.out.println(x[j]);
//			     }
//		    }
				// x[j] = x[j].replace('Bar', '0');
				// x[j] = x[j].replace('Bar', '0');
				for (int p = 0; p < x[j].length(); p++) {
					if (x[j].charAt(x[j].length() - 1) == '@') {
						x[j] = x[j].substring(0, x[j].length() - 1);
						from = x[j].substring(0, x[j].indexOf('@'));
						to = x[j].substring(x[j].indexOf('@') + 1);

						int t = Integer.parseInt(to);
						// System.out.println(x[j]);
						int hit_score = hit();
						if (t > 18)
							max[i][j] += hit_score + 8;
						else if (t > 12)
							max[i][j] += hit_score + 6;
						else if (t > 6)
							max[i][j] += hit_score + 4;
						else if (t > 0)
							max[i][j] += hit_score;

//				      System.out.println("from "+ from);
//				      System.out.println("to " + to);
						updarr = hitmove(me, from, to, child3);
					}
					if (x[j].charAt(p) == '@') {
						from = x[j].substring(0, p);
						to = x[j].substring(p + 1, x[j].length());

						int t = Integer.parseInt(to);

						if (to.equals("0"))
							max[i][j] += 2;
						else {
							if (numloneRanger(updarr) == false) {
								int d = loneRanger(from, to, updarr);
								if (d == 1)
									max[i][j] += 3;
							}
						}

						if (max[i][j] > 0)
							max[i][j] += 1;
						else
							max[i][j] = 1;

						// max[i][j] = my_pipcount(child3);
						int off_score = off(to);

						if (off_score == 10)
							max[i][j] += 10;

						int bar_score = bar(from);

						if (bar_score == 3)
							max[i][j] += 3;

						max[i][j] += primeBoardScore(me, updarr);

						int de = futureMove(from, to, updarr);
						if (de == 1)
							max[i][j] += 2;

						if (updarr[me.getId()][t] > 5)
							max[i][j] = 1;

						updarr = move(me, from, to, child2);

					}
				}
				System.out.print(i);
				System.out.println(": " + max[i][j]);
			}
		}

		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				max[i][0] = max[i][0] + max[i][j];
			}
		}

		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				if (max[i][j] > maximum)
					maximum = max[i][j];
			}
		}

		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 1000; j++) {
				if (maximum == max[i][j])
					st = Integer.toString(i + 1);
//      System.out.println(st);
			}
		}
		return st;
	}

	public int[][] move(PlayerAPI player, String from, String to, int b[][]) {
		int fr = Integer.parseInt(from);
		int t = Integer.parseInt(to);
		b[player.getId()][fr]--;
		b[player.getId()][t]++;

		if (t < Board.BAR && t > Board.BEAR_OFF && b[opponent.getId()][calculateOpposingPip(t)] == 1) {
			b[opponent.getId()][calculateOpposingPip(t)]--;
			b[opponent.getId()][Board.BAR]++;
		}
		return b;
	}

	private int calculateOpposingPip(int pip) {
		return Board.NUM_PIPS - pip + 1;
	}

	public int[][] hitmove(PlayerAPI player, String from, String to, int b[][]) {
		int fr = Integer.parseInt(from);
		int t = Integer.parseInt(to);
		b[player.getId()][fr]--;
		b[player.getId()][t]++;
		b[opponent.getId()][25 - t]--;
		b[opponent.getId()][25]++;
		return b;
	}

	public void winPercent() {

		int duplicate[][] = board.get();
		int mycount = 0;
		int oppocount = 0;

		for (int i = 1; i < 25; i++) {
			if (duplicate[me.getId()][i] == 1)
				mycount++;
		}

		for (int i = 1; i < 25; i++) {
			if (duplicate[opponent.getId()][i] == 1)
				oppocount++;
		}

		double mypipcount = my_pipcount();
		double opppipcount = opp_pipcount();

		if (mypipcount < opppipcount) {
			if (opppipcount - mypipcount >= 45)
				win = 4;
			else if (opppipcount - mypipcount >= 20 && opppipcount - mypipcount <= 45) {
				if (oppocount - mycount >= 3)
					win = 4;
				else
					win = 3;
			} else if (opppipcount - mypipcount >= 0 && opppipcount - mypipcount <= 20)
				win = 3;

		} else if (mypipcount > opppipcount) {
			if (mypipcount - opppipcount >= 45)
				win = 1;
			else if (mypipcount - opppipcount >= 20 && mypipcount - opppipcount <= 45) {
				if (mycount - oppocount >= 3)
					win = 1;
				else
					win = 2;
			}

			else if (mypipcount - opppipcount >= 0 && mypipcount - opppipcount <= 20)
				win = 2;
		}

		else
			win = 2;
	}

	private int primeBoardScore(PlayerAPI player, int[][] boardCopy) {
		int counter = 0;
		for (int i = 1; i <= 24; i++) {
			int primeLength = 0;
			int j = i;
			while (boardCopy[player.getId()][j] >= 2) {
				primeLength++;
				j++;
			}
			counter += Math.pow(2, primeLength);
		}
		return counter;
	}

	public String getDoubleDecision() {
		winPercent();

		if (win >= 2)
			return "y";
		else
			return "n";
	}
}
