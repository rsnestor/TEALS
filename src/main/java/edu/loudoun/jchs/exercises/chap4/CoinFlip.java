package edu.loudoun.jchs.exercises.chap4;

import edu.loudoun.jchs.CommandLineRunner;

/**
 * Flip a coin 10 times
 * @author scottnestor - TEALS, 2015
 *
 */
public class CoinFlip extends CommandLineRunner {
	

	public static void main(String[] args) {
		
		CoinFlip flipper = new CoinFlip();
		//10 tails
		flipper.flipOccurances(Side.TAILS, 10);
		//10 in a row 
		flipper.flipContigOccurances(10);
		
	}
	
	public void flipOccurances(Side s,int limit){
		flipOccurances(s,limit,false);
	}
	
	public void flipOccurances(Side s,int limit,boolean contiguous) {
		Coin coin = new Coin();
		int flips = 0;
		int match = 0;
		while (match < limit) {
			coin.flip();
			if (s==Side.HEADS){
				if (coin.isHeads()) {
					match++;
				} else if (contiguous) {
					match=0;
				}
			} else {
				if (!coin.isHeads()) {
					match++;
				} else if (contiguous) {
					match=0;
				}
			}
			flips++;
		}
		printf("Flips to get %d %s = %d\n",limit,((s==Side.HEADS)?"heads":"tails"),flips);
	}
	
	public void flipContigOccurances(int limit) {
		Coin coin = new Coin();
		int flips = 1;
		int match = 1;
		//primer
		coin.flip();
		Side s = (coin.isHeads()?Side.HEADS:Side.TAILS);
		while (match < limit) {
			coin.flip();
			if ((s==Side.HEADS && coin.isHeads())||s==Side.TAILS && !coin.isHeads()) {
					match++;
			} else {
				match=0;
				s=(coin.isHeads()?Side.HEADS:Side.TAILS);
			}
			flips++;
		}
		printf("It took %d flips to get %d %s in a row!\n",flips,limit,((s==Side.HEADS)?"heads":"tails"));
	}
	
	public static enum Side {
		HEADS,
		TAILS
	}

}
