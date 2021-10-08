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
   public Branch(Branch<E> l, Branch<E> r)
   {
      left = l;
      right = r;
      isLeaf = false;
   }
   
   public Branch(E info)
   {
      information = info;
      isLeaf = true;
   }
}