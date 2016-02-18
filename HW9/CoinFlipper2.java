import java.util.Random;


public class CoinFlipper2 extends CoinFlipper {
	public int numFlips = 0;
	protected Random gen;
	
	public CoinFlipper2(){
		this(new Random());
	}
	
	/**
	 * 
	 * constructor with a given source of randomness
	 * @param gen source of randomness
	 */
	public CoinFlipper2(Random gen){
		this.gen = gen;
	}
	
	/**
	 * simulates a random coin flip
	 * @return a random heads or tails enum
	 */
	public Coin flipCoin(){
		numFlips++;
		if(gen.nextBoolean()){
			return Coin.HEADS;
		} else {
			return Coin.TAILS;
		}
	}

}
