package edu.loudoun.jchs.exercises.chap2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import edu.loudoun.jchs.CommandLineRunner;

/**
 * Game simulator (man vs. machine) - Rock, Paper, Scissors
 * New Concepts:
 * 1) do/while loop 
 * 2) try/catch/finally - Exception handling
 * 3) switch statement
 * 4) ternary operator
 * 
 * @author scottnestor - TEALS, 2015
 *
 */
public class RockPaperScissors extends CommandLineRunner {

	public static final int ROCK = 1;
	public static final int PAPER = 2;
	public static final int SCISSORS = 3;

	public static final int H_WIN = 1;
	public static final int C_WIN = -1;

	protected Random machineMove = new Random();
	protected boolean activeRound = false;

	private static final String _prompt = "Pick your weapon:\n\t1) Rock\n\t2) Paper\n\t3) Scissors\n";

	private int humanRoundWins = 0;
	private int computerRoundWins = 0;
	private int humanGameWins = 0;
	private int computerGameWins = 0;
	private int roundsPerGame = 1;

	/**
	 * Main method controls user interaction for game play (Scanner)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		println("Welcome to Rock, Paper, Scisssors.");
		Scanner stdin = new Scanner(System.in);
		boolean playOn = true;
		try {

			//create new game, allowing "rounds per game" to be passed as an argument
			RockPaperScissors game = new RockPaperScissors((args.length>0)?Integer.parseInt(args[0]):2);
			while (playOn) {
				do {
					print(_prompt);
					game.move(stdin.nextInt());
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
			println("Invalid input ... abort.");
		} catch (Exception e) {
			println(e.getMessage());
		} finally {
			stdin.close();
		}

	}

	public RockPaperScissors(int gameRounds) {
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
		/*
		if (hmove<ROCK || hmove>SCISSORS){
			printf("Invalid move: %d\n",hmove);
			return 0;
		}
		*/
		// Random.nextInt(max-min)+min
		int compMove = machineMove.nextInt(3) + 1;
		printf("Human - %s : Computer - %s", fmt(hmove), fmt(compMove));
		int result = 0;
		switch (compMove) {
		case (PAPER):
			result = (hmove == PAPER) ? 0 : ((hmove == ROCK) ? C_WIN : H_WIN);
			break;
		case (SCISSORS):
			result = (hmove == SCISSORS) ? 0 : ((hmove == ROCK) ? H_WIN : C_WIN);
			break;
		case (ROCK):
			result = (hmove == ROCK) ? 0 : ((hmove == PAPER) ? H_WIN : C_WIN);
			break;
		default:
			printf("Invalid move: %d\n",hmove);
			result = H_WIN;
		}
		if (result != 0) {
			adjustCounters(result);
		} else {
			print(" => Tie ...\n");
		}
		return result;
	}

	/**
	 * increment internal counters based on the round result
	 * 
	 * @param result
	 */
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

	/**
	 * Reset internal counters between rounds
	 */
	protected void resetRounds() {
		this.humanRoundWins = 0;
		this.computerRoundWins = 0;
		this.activeRound = false;
	}

	/**
	 * Determine if a game is actively in progress
	 *
	 * @return
	 */
	public boolean activeRound() {
		return this.activeRound;
	}

	/**
	 * Translate the integer representation of a move to it's
	 * String equivalent
	 * 
	 * @param move
	 * @return
	 */
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
