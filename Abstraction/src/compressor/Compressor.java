package compressor;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Compressor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader compressor = new FileReader("EnglishToArabicDictionary (1).txt");
		HashMap<Character, Integer> frq = new HashMap<Character, Integer>(); //create a frequency map of characters

		int a;
		while((a=compressor.read()) !=-1) 
										 
		{
			char letter = (char)a;
			
				if(frq.containsKey(letter))       //add each time a character is seen again
				{
					frq.put(letter, frq.get(letter)+1);
				}
				
				else		 //if new character, create a new key with initial frequency of 1
				{
					frq.put(letter, 1);
				}
			
			
		}
		
		
		PriorityQueue<Branch<Character>> pq  = new PriorityQueue<Branch<Character>>();      // create a priority queue where 
																							// nodes are put in descending order 
																							// of frequency
		
		for (Character c : frq.keySet()) 	//add keys of hashmap to priority queue
		{
			Branch b = new Branch(c);
			pq.add(b, frq.get(c));
		}
		
		
		while(pq.getSize()>1)
	      {
			 int f1= pq.getFrequency(0);				//get the frequency of the first node
	         Branch first = (Branch)pq.pop();			//get the first node
	         int f2= pq.getFrequency(0);				//get the frequency of the second node
	         Branch second = (Branch)pq.pop();			//get the second node
	       
	          Branch br = new Branch(first, second);	//create an empty third node that has the first node and second node as childs
	          pq.add(br, f1+f2);
	      }
		Branch<Character> codeTree = pq.pop();
	      HashMap<Character, String> dict= createMap(codeTree);

	      System.out.println("Code map:");								//prints out codemap
	      for (Character c: dict.keySet()) {
	          System.out.println(c.toString() + ": " + dict.get(c));
	      }
	      
	      compress("EnglishToArabicDictionary (1).txt", dict);						//compresses original text and creates coded file in "Compressedfile"
	      System.out.println("Compression complete!");

	      HashMap<String, Character> inv_dict = inverseHashMap(dict);
	      decompress("Decompressedfile", inv_dict);					//decompresses "Compressedfile" and writes original text in "Decompressedfile"
	       System.out.println("Decompression complete!");
	}

		// 1
		// getCode method creates a code for each characters using the binary branch built above
		 public static void getCode(HashMap<Character, String> dict, Branch<Character> node, String s)
		 {
		        if (node.isLeaf()) 		// if it reaches leaf, the code making for a character in the leaf is over
		        						// thus, the code should be added into the hashmap
		        {
		   
		            dict.put(node.getItem(), s);
		        }
		        else {
		            getCode(dict, node.getLeft(), s+'0'); 			//adds 0 to String value if the node is a left child
		            getCode(dict, node.getRight(), s+'1');			//adds 1 to String value if the node is a right child
		        }
		    
		 }
		 
		 public static HashMap<Character, String> createMap(Branch<Character> cTree) 
		 	{
		        HashMap<Character, String> words= new HashMap<Character, String>(); // a hashmap with characters as keys and 
		        																	// binary codes as values
		        getCode(words, cTree, ""); //fills in code map using getCode method 
		        return words; //returns the code map
		    }
		 
		 //2
		 //the compressor method transforms an original text file into a compressed non legible file
		 public static void compress(String filename, HashMap<Character, String> dict) throws IOException
		 {
		        FileReader compressor = new FileReader(filename);
		        BufferedBitWriter writer = new BufferedBitWriter("Compressedfile");
		        int a;
		        while((a=compressor.read()) != -1) //read the file character by character until the end
		        {
		            char letter = (char)a;
		            String code = dict.get(letter); //get the corresponding code for character a
		           
		            for (int i=0;i<code.length(); i++) 
		            {
		           
		                if (code.charAt(i) == '0')	//uses BufferedBitWriter to write the binary
		                							// code bit by bit
		                    writer.writeBit(false);
		                else
		                    writer.writeBit(true);
		            }
		        }
		        compressor.close();
		        writer.close();
		    }
		 
		 //4
		 // creates an inverse Hashmap where the keys are binary codes and values are characters
		 public static HashMap<String, Character> inverseHashMap(HashMap<Character, String> dict)
		 		{
		        HashMap<String, Character> inv_dict = new HashMap<String, Character>();
		        for (Map.Entry<Character, String> item : dict.entrySet())															
		        {																//use a for loop to get the key 
		            inv_dict.put(item.getValue(), item.getKey());				// and values of dict<Character, String> 
		        }																// put value of dict into key and key into value 
		        return inv_dict;												// of new inversehashmap
		    }
		 
		 // a decompressor file to decode the compressed file
		 public static void decompress(String filename, HashMap<String, Character> dict) throws IOException{
		        FileWriter writer = new FileWriter(filename);
		        BufferedBitReader decompressor = new BufferedBitReader("Compressedfile"); //uses BufferedBitReader to decode the compressed 
		        																				//file created by BufferedBitWriter
		        String code = ""; //stores code that is being read
		        while (decompressor.hasNext()) {
		            if (!dict.containsKey(code))  //if the inversehashmap does not recognize the String code
		            {
		                if (decompressor.readBit())  //read another bit and add it into String code
		                    code += "1";
		                else
		                    code += "0";
		            }
		            else 
		            {										//if inversehashmap recognizes the code, write the corresponding character
		                writer.write(dict.get(code));		// and reset String code
		                code = "";
		            }
		        }
		        decompressor.close();
		        writer.close();
		    }
		 
	
}
