package edu.loudoun.jchs.exercises.chap2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import edu.loudoun.jchs.CommandLineRunner;

/**
 * Game simulator (man vs. machine) - Rock, Paper, Scissors
 * New Concepts:
 * 1) two dimensional array 
 * 
 * Rules of the game:  Spock smashes scissors and vaporizes rock; 
 * he is poisoned by lizard and disproven by paper. Lizard poisons Spock and eats paper; 
 * it is crushed by rock and decapitated by scissors
 * 
 * @author scottnestor - TEALS, 2015
 *
 */
public class RockPaperScissorsLizardSpock extends CommandLineRunner {
	
	public static final int ROCK = 0;
	public static final int PAPER = 1;
	public static final int SCISSORS = 2;
	public static final int LIZARD = 3;
	public static final int SPOCK = 4;
	
	//Two dimensional array to define the combinations.  Indexes represent the choices,
	//and the values represent the winner.
	protected static int rules [][] = {
			{-1,1,0,0,4}, //rock
			{1,-1,2,3,1}, //paper
			{0,2,-1,2,4}, //scissors
			{0,3,2,-1,3}, //lizard
			{4,1,4,3,-1}  //spock
	};
	
	//Two dimensional "mirror" array containing the rule verbs
	protected static final String [][] ruleDesc = {
			{"equals","covered by","smashes","crushes","vaporized by"},
			{"covers","equals","cut by","eaten by","disproves"},
			{"smashed by","cuts","equals","decapitates","smashed by"},
			{"crushed by","eats","decapitated by","equals","poisons"},
			{"vaporizes","disproven by","smashes","poisoned by","equals"}
	};

	public static final int H_WIN = 1;
	public static final int C_WIN = -1;

	protected Random machineMove = new Random();
	protected boolean activeRound = false;

	private static final String _prompt = "Pick your weapon:\n\t1) Rock\n\t2) Paper\n\t3) Scissors\n\t4) Lizard\n\t5) Spock\n";

	private int humanRoundWins = 0;
	private int computerRoundWins = 0;
	private int humanGameWins = 0;
	private int computerGameWins = 0;
	private int roundsPerGame = 1;

	public static void main(String[] args) {
		println("Welcome to Rock, Paper, Scissors, Lizard, Spock.");
		Scanner stdin = new Scanner(System.in);
		boolean playOn = true;
		try {

			//create new game, allowing "rounds per game" to be passed as an argument
			RockPaperScissorsLizardSpock game = new RockPaperScissorsLizardSpock((args.length>0)?Integer.parseInt(args[0]):2);
			while (playOn) {
				do {
					print(_prompt);
					game.move(stdin.nextInt()-1);
				} while (game.activeRound());
				printf("Win Totals => Human: %d\tMachine: %d\n", game.getHumanGameWins(), game.getComputerGameWins());
				print("\nAnother round [y/n]? > ");
				playOn = stdin.next("[YyNn]").matches("[Yy]");
			}
			if (game.getComputerGameWins()!=game.getHumanGameWins()){
				printf("%s prevails!!!\n",(game.getComputerGameWins()<game.getHumanGameWins()?"Biology":"AI"));
			} else {
				println("Stalemate.");
			}
		} catch (InputMismatchException ime) {
			// swallow input mis-matches
		} catch (Exception e) {
			println(e.getMessage());
		} finally {
			stdin.close();
		}

	}

	public RockPaperScissorsLizardSpock(int gameRounds) {
		this.roundsPerGame = gameRounds;
	}

	/**
	 * Computer move is generated randomly and compared with human move.  Internal
	 * counters are adjusted for every invocation, unless a "tie" occurs
	 * 
	 * @param hmove - human move
	 * @return move result (0 tie, 1 human win, -1 machine win) 
	 */
	public int move(int hmove) {
		activeRound = true;
		if (hmove<ROCK || hmove>SPOCK){
			printf("Invalid move: %d\n",hmove);
			return 0;
		}
		// Random int between 0 and 4, inclusive
		int cmove = machineMove.nextInt(5);
		printf("%s %s %s", fmt(hmove), ruleDesc[hmove][cmove], fmt(cmove));

		int result = 0; //default to tie
		if (rules[hmove][cmove]!=-1) {
			result = (rules[hmove][cmove]==hmove?H_WIN:C_WIN); //rules array
			adjustCounters(result);
		} else {
			print(" => Tie ...\n");
		}
		return result;
	}

	//increment internal counters
	protected void adjustCounters(int result) {
		switch (result) {
		case (H_WIN):
			print(" => Human wins round ...\n");
			this.humanRoundWins++;
			if (humanRoundWins >= this.roundsPerGame) {
				this.humanGameWins++;
				resetRounds();
				println("Human wins the game!");
			}
			break;
		case (C_WIN):
			print(" => Computer wins round ...\n");
			this.computerRoundWins++;
			if (computerRoundWins >= this.roundsPerGame) {
				this.computerGameWins++;
				resetRounds();
				println("Computer wins the game!");
			}
			break;
		}
	}

	protected void resetRounds() {
		this.humanRoundWins = 0;
		this.computerRoundWins = 0;
		this.activeRound = false;
	}

	public boolean activeRound() {
		return this.activeRound;
	}

	public String fmt(int move) {
		String desc = "";
		switch (move) {
		case (PAPER):
			desc = "PAPER";
			break;
		case (SCISSORS):
			desc = "SCISSORS";
			break;
		case (ROCK):
			desc = "ROCK";
			break;
		case (LIZARD):
			desc = "LIZARD";
			break;
		case (SPOCK):
			desc = "SPOCK";
			break;
		}
		return desc;
	}

	public int getHumanRoundWins() {
		return humanRoundWins;
	}

	public void setHumanRoundWins(int humanRoundWins) {
		this.humanRoundWins = humanRoundWins;
	}

	public int getComputerRoundWins() {
		return computerRoundWins;
	}

	public void setComputerRoundWins(int computerRoundWins) {
		this.computerRoundWins = computerRoundWins;
	}

	public int getHumanGameWins() {
		return humanGameWins;
	}

	public void setHumanGameWins(int humanGameWins) {
		this.humanGameWins = humanGameWins;
	}

	public int getComputerGameWins() {
		return computerGameWins;
	}

	public void setComputerGameWins(int computerGameWins) {
		this.computerGameWins = computerGameWins;
	}

	public int getRoundsPerGame() {
		return roundsPerGame;
	}

	public void setRoundsPerGame(int gameRounds) {
		this.roundsPerGame = gameRounds;
	}

}

