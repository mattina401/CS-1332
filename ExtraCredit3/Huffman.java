import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//name : Jongyeon Kim
//GTID : jkim989

/**
 * Huffman Encoding.
 */
public class Huffman {
	
	/**
	 * Builds the frequency table for each charactr in the given string. 
	 * Map<Character, Integer> should be a mapping of characters to their
	 * respective frequencies.
	 *
	 * @param str The String to be encoded.
	 */
	public static Map<Character, Integer> buildFrequencyTable(String str) {
		// TODO: Auto-generated method stub
		
		HashMap<Character, Integer> frequencyTable = new HashMap<>();
		for (char K : str.toCharArray()) {
			Integer Pre = frequencyTable.remove(K);
			Integer Aft;
			
			if (Pre != null) {
				Aft = Pre + 1;
			} else {
				Aft = 1;
			}
			frequencyTable.put(K, Aft);
		}
		return frequencyTable;
	}

	/**
	 * Builds the encoder map that pairs a Character with it's corresponding 
	 * Huffman encoding. Map<Character, String> should be a map of characters
	 * to their Huffman encoding.
	 *
	 * @param frequencyTable The frequency table of characters
	 */
	public static Map<Character, String> buildEncoder(Map<Character, Integer> frequencyTable) {
		// TODO: Auto-generated method stub
		
		HashMap<Character, String> encoder = new HashMap<>();
		HuffmanTree T = Huffman.buildHuffmanTree(frequencyTable);

		if(frequencyTable.size() == 0) {
			return new HashMap<>();
		}
		if ((T.R == null) && (T.L == null)) {
			return null;
		}
			
		recursion(encoder, T, new String());

		return encoder;
	}

	private static void recursion(HashMap<Character, String> M, HuffmanTree T, String L) {
			// TODO Auto-generated method stub
		
		if ((T.R == null) && (T.L == null)) {
			M.put(T.Ch, L);
		}
		if (T.R != null) {
			String N = new String();
			recursion(M, T.R, N.concat(L + "1"));
		}
		if (T.L != null) {
			String N = new String();
			recursion(M, T.L, N.concat(L + "0"));
		}
	}

	/**
	 * Builds a huffman tree that can be used for decoding from the frequency table
	 * 
	 * @param frequencyTable The frequency table of characters
	 */
	public static HuffmanTree buildHuffmanTree(Map<Character, Integer> frequencyTable) {
		// TODO: Auto-generated method stub
		
		PriorityQueue<HuffmanTree> Q = new PriorityQueue<HuffmanTree>();
		for (Map.Entry<Character, Integer> P : frequencyTable.entrySet()) {
			if(frequencyTable.size() == 1) {
				
				int i = 0;
				while (i < P.getValue()) {
					Q.add(new HuffmanTree(P.getKey(), P.getValue()));
					i++;
				}
			}
			Q.add(new HuffmanTree(P.getKey(), P.getValue()));
		}
		while (Q.size() > 1) {
			HuffmanTree T1 = Q.poll();
			HuffmanTree T2 = Q.poll();
			Q.offer(new HuffmanTree(T1, T2));
		}
		return Q.poll();
	}
	
	/**
	 * Encodes a String
	 *
	 * @param String input The String to be encoded.
	 * @param Map encoder an encoder that can be used to encode the input
	 * @return String The resulting encoded String.
	 */
	public static String encodeString(String input, Map<Character, String> encoder) {
		// TODO: Auto-generated method stub
		
		String Encode = new String();
		
		if(encoder == null) {
			return input;
		}

		for (char K : input.toCharArray()) {
			String H = encoder.get(K);
			if (H != null) {
				Encode = Encode + H;
			}
		}
		return Encode;
	}
		
	/**
	 * Decodes a String
	 *
	 * @param String input The String to be decoded.
	 * @param HuffmanTree tree A huffman tree generated from the input
	 * @return String The decoded String.
	 */
	public static String decodeString(String input, HuffmanTree tree) {
		// TODO: Auto-generated method stub
		
		String Encode = new String();
		HuffmanTree Now = tree;
		if(Now == null) {
			return Encode;
		}
		
		if((Now.R == null) && (Now.L == null)) {
			return Encode + Now.Ch;
		}

		char[] H = input.toCharArray();
		int i = 0;
		while (i < H.length) {
			char code = H[i];
			if (code == '1') {
				Now = Now.R;
			} 
			else if (code == '0'){
				Now = Now.L;
			}
			if ((Now.R == null) && (Now.L == null)) {
				Encode = Encode + Now.Ch;
				Now = tree;
			}
			i++;
		}
		return Encode;
	}

}