import CITS2200.*;
import CITS2200.Deque;

public class DequeCyclic implements Deque {

   private int first;
   private int last;
   private int size;
   private Object item[];
   
   public DequeCyclic (int s) {
	   item = new Object[s];
	   first = 1;
	   last = 0;
	   size = 0;
   }
   
        
   public boolean isEmpty () {
	   return size == 0;
   }
   
   public boolean isFull () {
	   return size == item.length;
   }
   
   public void pushLeft (Object c) throws Overflow {
	   if (!isFull()) {
		   item[first] = c;
		   first = (first+1) % item.length;
		   size++;
	   } else throw new Overflow ("Queue is full");
   }
   
   public void pushRight (Object c) throws Overflow {
	   if (!isFull()) {
		   item[last] = c;
		   last = (last-1) % item.length;
		   size++;
	   } else throw new Overflow ("Queue is full");
	   
   }
   
   public Object peekLeft () throws Underflow {
	   if (!isEmpty()) {
		   return item[(first-1) % item.length];
	   } else throw new Underflow ("Queue is empty");
   }
   
   public Object peekRight () throws Underflow {
	   if (!isEmpty()) {
		   return item[(last+1) % item.length];
	   } else throw new Underflow ("Queue is empty");
   }
   
   public Object popLeft () throws Underflow {
	   if (!isEmpty()) {
		   first = (first-1) % item.length;
		   size--;
		   return item[first];
	   } else throw new Underflow ("Deleting from empty queue");
   }
   
   public Object popRight () throws Underflow {
	   if (!isEmpty()) {
		   last = (last+1) % item.length;
		   size--;
		   return item[last];
	   } else throw new Underflow ("Deleting from empty queue");
   }
   
}