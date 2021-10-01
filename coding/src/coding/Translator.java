package coding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Translator {
	
	
	Scanner sc= new Scanner(System.in);
	String English = sc.next();
	
	String a =""; 
	HashMap<String, String> words= new HashMap<String, String>();
	BufferedReader in1;
	File file = new File("EnglishToArabicDictionary.txt");
	
	public Translator() {//reads txt file and hashmap(key= english, value= arabic)
	
		try {
			BufferedReader in1 = new BufferedReader(new FileReader("EnglishToArabicDictionary.txt"));
			in1.readLine();
			String Eng="";
			String Arb="";
			int cnt=0;
			for (String line= in1.readLine(); line !=null; line =in1.readLine()) {
					Eng=line;
					Arb = in1.readLine();
				
					words.put(Eng,Arb);
					
			}
			in1.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		finally {
			
		}
		if(English.equals("quit"))
		{
			System.out.print("END DICTIONARY");
			
		}
		else{
			System.out.println(words.get(English));
			}
		
		
	}
	
	
	public static void main(String[] args) {
		while(true)
		{
			new Translator();
		}
	}
}


