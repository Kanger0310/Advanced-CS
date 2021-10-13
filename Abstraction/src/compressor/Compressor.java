package compressor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Compressor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader compressor = new FileReader("EnglishToArabicDictionary (1).txt");
		HashMap<Character, Integer> frq = new HashMap<Character, Integer>(); //add frequency when u see the character again
//		for (int i=compressor.read(); i != -1; i= compressor.read())
		int a;
		while((a=compressor.read()) !=-1)
		{
			char letter = (char)a;
			
				if(frq.containsKey(letter))
				{
					frq.put(letter, frq.get(letter)+1);
				}
				
				else
				{
					frq.put(letter, 1);
				}
			
			
		}
		
//		System.out.println(frq);
		
		
		PriorityQueue<Branch<Character>> pq  = new PriorityQueue<Branch<Character>>();
		
		for (Character c : frq.keySet()) {
			Branch b = new Branch(c);
			pq.add(b, frq.get(c));
		}
		//Check if the Branch class is correct
	      //How to use a loop? ( make size method and run while loop until size is 1)
	      //How to add two frequencies of the two branches (make frequency method)
		
		while(pq.getSize()>1)
	      {
			 int f1= pq.getFrequency(0);
	         Branch first = (Branch)pq.pop();
	         int f2= pq.getFrequency(0);
	         Branch second = (Branch)pq.pop();
	       
	          Branch br = new Branch(first, second);
	          pq.add(br, f1+f2);
	      }
		System.out.print(pq);
	}
	

}
