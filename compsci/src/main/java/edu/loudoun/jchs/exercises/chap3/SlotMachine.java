/**
 * 
 */
package edu.loudoun.jchs.exercises.chap3;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

import edu.loudoun.jchs.CommandLineScanner;

/**
 * Simulate a slot machine.
 * 
 * Key concepts: Random class, NumberFormat class
 * 
 * @author scottnestor - TEALS, 2015
 *
 */
public class SlotMachine extends CommandLineScanner {

	public static double PURSE = 20.0;
	double runPurse = PURSE;
	double origPurse = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String play = "y";
		//allow purse to be set via command line parameter (optional)
		SlotMachine slot = new SlotMachine((args.length > 0) ? Integer.parseInt(args[0]) : SlotMachine.PURSE);
		NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);
		printf("AI slot machine. Beginning purse = %s\n", fmt.format(slot.getRunningPurse()));
		while (!play.equals("q")) {
			print("Pull (p), Quit (q) ");
			play = stdin.next().toLowerCase();
			if (play.equals("p")) {
				print(slot.pull());
				printf(" => %s\n", fmt.format(slot.getRunningPurse()));
				if (slot.busted())
					play = "q";
			}
		}
		printf("Final gambling proceeds = %s", fmt.format(slot.getRunningPurse()));
		String salutation = "";
		if(slot.busted()) {salutation = " - BUSTED!"; }
		else if(slot.getRunningPurse() < slot.getOrigPurse()) { salutation = " - In the HOLE!";}
		else if(slot.getRunningPurse() > slot.getOrigPurse()) { salutation = " - Winner!";}
		print(salutation+"\n");
	}

	public void addMoney(double money) {
		if (money > 0){
			runPurse += money;
			origPurse += money; //Keep track of total gambled
		}
	}

	public SlotMachine(double startingPurse) {
		runPurse = startingPurse;
		origPurse = startingPurse;
	}

	/**
	 * Default constructor
	 */
	public SlotMachine() {
		this(PURSE);
	}

	/**
	 * Generate 3 random numbers and update the running "purse".
	 * If 2 numbers match (winner) +$2 
	 * If 3 match (jackpot) +$5
	 * The play fee of $0.50 is always deducted.
	 * 
	 * @return
	 */
	public String pull() {
		Random num = new Random(); // 0-9
		int first = num.nextInt(10);
		int sec = num.nextInt(10);
		int third = num.nextInt(10);
		if (first == sec && sec == third) {
			runPurse += 5.0;
		} else if (first == sec || first == third || sec == third) {
			runPurse += 2.0;
		}
		runPurse += -.5; // always deduct $0.50 per play
		return "" + first + "|" + sec + "|" + third;
	}

	public double getRunningPurse() {
		return (runPurse < 0) ? 0.0 : runPurse;
	}

	public boolean busted() {
		return runPurse <= 0.0;
	}

	public double getOrigPurse() {
		return origPurse;
	}
}
