package genericstack;

import java.util.ArrayList;

public class GenericStack<T> {
    private int top;
    private ArrayList<T> items = new ArrayList<T>();

    public GenericStack() {     	  
          top = 0;
    }//end constructor

    public void push(T item) {                  
          items.add(item);
          top++;
    }//end method push    

    public T pop() {
          if (isEmpty())
                throw new GenericStackException("Underflow Error");	           
          return items.remove(--top);
    }//end method pop

    public boolean isEmpty() {
          return (top == 0);
    }//end method isEmpty

    public static class GenericStackException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		public GenericStackException(String message) {
                super(message);
          }//end constructor
    }//end class GenericStackException


    public static void main(String[] args) {
    	GenericStack<Integer> stack = new GenericStack<Integer>();
    	stack.push(1);
    	stack.push(2);
    	stack.push(3);		
    	stack.push(4);

    	System.out.println(stack.pop());
    	System.out.println(stack.pop());
    	System.out.println(stack.pop());
    	System.out.println(stack.pop());
    	System.out.println(stack.pop());//underflow error
    }//end method main
}//end class GenericStack