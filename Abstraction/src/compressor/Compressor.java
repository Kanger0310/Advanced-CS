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
		
		System.out.println(frq);
	}
	

}
