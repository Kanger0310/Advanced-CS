package compressor;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
//part 1
	public class PriorityQueue<E>
	{
	   private ArrayList<Node> list = new ArrayList<Node>();
	   public int getSize()			//method to return the length of the arraylist
	   {
		   return list.size();
	   }
	   public String toString()			//method to printout arraylist
	   {
	      return list.toString();
	   }
	   
	   public void add(E c, int priority)	//adds node to arraylist according to its frequency
	   {
	      if (list.size() == 0)
	      {
	         list.add(new Node(c, priority));
	      }
	      else
	      {
	         for (int i = 0; i < list.size(); i++)
	         {
	            if (list.get(i).getFrequency() >= priority)
	            {
	               list.add(i, new Node(c, priority));
	               return;
	            }   
	         }
	         list.add(new Node(c, priority) );
	      }
	   }
	   
	   public E pop()					//retrieves node from priority queue
	   {
	      Node n = list.remove(0);
	      return n.getinfo();
	   }
	   public E peek()					//retrieves character
	   {
		   return list.get(0).getinfo();
	   }
	   
	   public int getFrequency(int a )	//returns the frequency of a character in the arraylist
	   									//int a is the index of the character
	   {
		  return list.get(a).getFrequency();
	   }
	   public void print()
	   {
		   for (Node n : list)
		   {
			   System.out.println(n.getinfo()+ ":" + Integer.toString(n.getFrequency()));
		   }
	   }
	 

	
	private class Node		//node class that represents a single child in a branch
	{
	   private E info;
	   private int frequency;
	   
	   public Node (E c, int f)
	   {
	      info = c;
	      frequency = f;
	   }
	   
	   public E getinfo()		//returns info(character in this case) of node
	   {
	      return info;
	   }
	   
	   public int getFrequency()	//returns frequency of character
	   {
	      return frequency;
	   }
	   public String toString()
	   { 
		  
		   return info.toString() +", "+ frequency;
		 
		 		
	   }
	}
	
		
	}


