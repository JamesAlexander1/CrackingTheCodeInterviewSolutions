package questions.structures.stack_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



/**
 * Class implementing multiple stack data structures of specified capacity. Corresponds to question 3.3 Cracking the Code Interview.
 * @author James Alexander
 *
 */
public class SetOfStacks<E> {

	/**
	 * default size of each stack for each SetOfStacks object.
	 */
	private static int DEFAULT = 100;
	
	/**
	 * isEmpty 		- if stacks is empty or not.
	 * currIndex 	- current stack where input is pushed to.
	 * capacity 	- max capacity for each stack.
	 * stacks 		- each stack is an element in a ArrayList
	 */
	private boolean isEmpty;
	private int currIndex;
	private int capacity;
	private List<Stack<E>> stacks;
	
	private SetOfStacks(){
		this(DEFAULT);
		
	}
	/**
	 * Constructor. private.
	 * @param cap	- maximum capacity for each stack.
	 */
	private SetOfStacks(int cap){
		capacity = cap;
		currIndex = 0;
		stacks = new ArrayList<Stack<E>>();
		
		Stack<E> newStack = new Stack<E>();
		newStack.ensureCapacity(capacity);
		
		stacks.add(newStack);
		
		isEmpty = false;
	}
	
	/**
	 * private method for initialising new Stack with specified capacity to stacks variable.
	 */
	private void addNewStack(){
		
		Stack<E> newStack = new Stack<E>();
		newStack.ensureCapacity(capacity);
		
		stacks.add(newStack);
		currIndex ++;
	}
	
	/**
	 * Standard push operation except will initialize a new Stack element in Stacks list if current stack is full.
	 * @param element	- element to push onto stack.
	 */
	public void push( E element){
		
		/*
		 * initialize new stack. add element to said Stack.
		 */
		if(stacks.get(currIndex).size() == capacity){
			addNewStack();
		}
		
		stacks.get(currIndex).push(element);
		
		if(isEmpty){
			isEmpty = false;
		}
	}
	/**
	 * Standard Stack pop operation.
	 * @return E item 	- item on top of stack.
	 */
	public E pop(){
		
		E item = null;
		if(! isEmpty){
			
			item = stacks.get(currIndex).pop();
			
			/*
			 * if stack is now empty. remove from stack list and update accordingly.
			 */
			if(stacks.get(currIndex).isEmpty()){
				
				//if empty stack happens to be the only stack element in stack list.
				if(currIndex == 0 && stacks.size() == 1){
					
					isEmpty = true;
			
				//otherwise, just remove. NOTE: is somewhat of a waste if subsequent operation is push(). 	
				}else if(currIndex > 0){
					
					stacks.remove(currIndex);
					currIndex --;
				}
			}
		}
		
		return item;
	}
	
	/**
	 * Pop operation on a specific stack
	 * @param index		- index of stack in stack list to pop top element.
	 * @return E item 	- top element in specified stack.
	 */
	public E popAtIndex(int index){
		E item = null;
		
		//if index is incorrect.
		if(index < 0 || index > currIndex){
			//index exception
		}else{
			//if specified stack happens to be empty, remove said stack and update list and remove that next value.
			if(stacks.get(index).isEmpty()){	//add exceptions
				stacks.remove(index);
				currIndex --;
				
				
			
			//otherwise, return popped element as normal.
			}
			item = stacks.get(index).pop();
			
		}
		return item;
	}
	

	/**
	 * Standard getter for current stack list index - which corresponds to how many stacks are in use.
	 * @return
	 */
	public int getCurrIndex() {
		return currIndex;
	}
	
	public int getTotalSize(){
		return stacks.size();
	}
	/**
	 * Public static setOfStacks getInstance method.
	 * @param cap
	 * @return
	 */
	public static <E> SetOfStacks<E> getInstance(int cap){
		
		return new SetOfStacks<E>(cap);
	}
}
