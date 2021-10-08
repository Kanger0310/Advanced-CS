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
	   
	   public String toString()
	   {
	      return list.toString();
	   }
	   
	   public void add(E c, int priority)
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
	         list.add(list.size()-1, new Node(c, priority) );
	      }
	   }
	   
	   public E pop()
	   {
	      Node n = list.remove(list.size()-1);
	      return n.getinfo();
	   }

	
	private class Node
	{
	   private E info;
	   private int frequency;
	   
	   public Node (E c, int f)
	   {
	      info = c;
	      frequency = f;
	   }
	   
	   public E getinfo()
	   {
	      return info;
	   }
	   
	   public int getFrequency()
	   {
	      return frequency;
	   }
	   public String toString()
	   { 
		  
		   return info.toString() +", "+ frequency;
		 
		 		
	   }
	}
	
		
	}


