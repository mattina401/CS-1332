import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

//import struct.Worth;

public class HuffmanTest {
	String str;
	HuffmanTree huffmanTree;
	String encoded;
	Map<Character, Integer> frequencyTable;
	Map<Character, String> encoder;
	Map<String, Character> decoder;
	boolean result;
	static final int TIMEOUT = 150;
	static final int LONGTIMEOUT = 750;

	@Test(timeout = TIMEOUT)
	//@Worth(points = 20)
	public void basicEncodeDecode(){
		str = "Hello World!";
		setup(str);
		assertEquals(str, Huffman.decodeString(Huffman.encodeString(str, encoder), huffmanTree));	
	}

	@Test(timeout = TIMEOUT)
	//@Worth(points = 20)
	public void correctLength(){
		str = "Hello World!";
		setup(str);
		encoded = Huffman.encodeString(str, encoder);
		assertEquals(encoded.length(), 37);
	}

	@Test(timeout = TIMEOUT)
	//@Worth(points = 15)
	public void shortString(){
		str = "a";
		setup(str);
		encoded = Huffman.encodeString(str,  encoder);
		
		assertEquals(encoded.length(), 1);
		assertEquals(str, Huffman.decodeString(Huffman.encodeString(str, encoder), huffmanTree));
	}

	@Test(timeout = TIMEOUT)
	//@Worth(points = 15)
	public void buildFrequencyTable(){
		str = "aaaaa bbbb ccc dd e";

		frequencyTable = new HashMap<Character, Integer>();

	 	for(char c : str.toCharArray()) 
			if(frequencyTable.containsKey(c))
				frequencyTable.put(c, frequencyTable.get(c)+1);
			else
				frequencyTable.put(c, 1);

		assertEquals(frequencyTable, Huffman.buildFrequencyTable(str));
	}

	@Test(timeout = TIMEOUT)
	//@Worth(points = 15)
	public void buildEncoder1(){
		str = "aaaaaabbbbbccccdddeef";
		setup(str);

		assertEquals(encoder.get('a').length(), 2);
		assertEquals(encoder.get('b').length(), 2);
		assertEquals(encoder.get('c').length(), 2);
	}

	@Test(timeout = TIMEOUT)
	//@Worth(points = 15)
	public void buildEncoder2(){
		str = "aaaaaabbbbbccccdddeef";
		setup(str);

		assertEquals(encoder.get('d').length(), 3);
		assertEquals(encoder.get('e').length(), 4);
		assertEquals(encoder.get('f').length(), 4);
	}
	
	public void setup(String str) {
		frequencyTable = Huffman.buildFrequencyTable(str);
		huffmanTree = Huffman.buildHuffmanTree(frequencyTable);
		encoder = Huffman.buildEncoder(frequencyTable);
	}
}