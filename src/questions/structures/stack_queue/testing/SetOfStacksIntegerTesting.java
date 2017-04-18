package questions.structures.stack_queue.testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import questions.structures.stack_queue.SetOfStacks;

/**
 * Testing suite for SetOfStack class.
 * @author James
 *
 */
public class SetOfStacksIntegerTesting {
	private SetOfStacks<Integer> testObject;
	
	@Before
	public void setUp() throws Exception {
		testObject = SetOfStacks.getInstance(5);
		
		for(int i = 20; i > 0; i --){
			Push(i);
		}
	}

	@After
	public void tearDown() throws Exception {
		print();
		testObject = null;
	}

	@Test
	public void testPush() {
		
		testObject.push(25);
		assert(testObject.getTotalSize() > 4);
	}
	
	public void Push(Integer i) {
		testObject.push(i);
		Pop(i);
		testObject.push(i);
	}

	@Test
	public void testPop() {
		
		assert(testObject.pop() != null);
	}
	
	public void Pop(Integer i) {
		
		assert(testObject.pop() == i);
	}

	@Test
	public void testPopAtIndex() {
		
		System.out.println(testObject.popAtIndex(0));
		assert(testObject.popAtIndex(0) == 17);
		assert(testObject.popAtIndex(0) == 18);
		assert(testObject.popAtIndex(0) == 19);
		assert(testObject.popAtIndex(0) == 20);
		
		
		System.out.println(testObject.popAtIndex(0));
	}
	
	private void print(){
		Integer i;
		System.out.println(": " + testObject.getCurrIndex() + " " +  testObject.getTotalSize());
		System.out.println("now printing nums: ");
		while((i = testObject.pop()) != null){
			
			System.out.print(i + " " );
		}
		System.out.println();
	}

}
