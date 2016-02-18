
//name : Jongyeon Kim
//GTID : jkim989

public class HuffmanTree implements Comparable<HuffmanTree> {

	// Fill this class out with whatever you need to represent a huffman tree
	public final HuffmanTree L;
	public final HuffmanTree R;
	
	public final int time;
	public final int Freq;
	public final char Ch;
	private static int timer = 0;

	@Override
	public int hashCode() {
		return time;
	}
	
	public HuffmanTree(char Ch, int Freq) {
		this.L = null;
		this.R = null;
		this.time = timer++;
		this.Ch = Ch;
		this.Freq = Freq;

	}

	public HuffmanTree(HuffmanTree smaller, HuffmanTree bigger) {
		this.L = smaller;
		this.R = bigger;
		this.time = timer++;
		this.Ch = 0;
		this.Freq = smaller.Freq + bigger.Freq;

	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof HuffmanTree) {
			return ((HuffmanTree) object).time == time;
		}
		return false;
	}
	
	@Override
	public int compareTo(HuffmanTree e) {
		if (this.Freq == e.Freq) {
			if (this.Ch == e.Ch) {
				return this.time - e.time;
			} else {
				return this.Ch - e.Ch;
			}
		} else {
			return this.Freq - e.Freq;
		}
	}

}
