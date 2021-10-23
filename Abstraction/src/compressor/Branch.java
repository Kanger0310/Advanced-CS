package compressor;

// Part 3
public class Branch<E>
{
   //4 ATTRIBUTES
   private Branch<E> left;
   private Branch<E> right;
   private E information;
   private boolean isLeaf;
   
   //TWO CONSTRUCTORS
   public Branch(Branch<E> l, Branch<E> r) //takes two children as parameter but has no information
   {
      left = l;
      right = r;
      isLeaf = false;
   }
   
   public Branch(E info) // leaf constructor
   {
      information = info;
      isLeaf = true;
   }
   
   public Branch<E> getLeft() {return this.left;}		//returns left child
   public Branch<E> getRight() {return this.right;}		//returns right child
   public E getItem() {return this.information;}		//returns E of the node
   public boolean isLeaf() {return this.isLeaf;}		//returns true if E is leaf false when E is not a leaf
	
   public String toString()		//toString method to print
   {
	   if(information == null) 
	 {
	 return "null";
	 }
	   else 
	   {
		   return information.toString();
	   }
		   	
   }

}