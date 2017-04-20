package questions.structures.stack_queue.testing;

import java.util.Iterator;
import java.util.Stack;

import questions.structures.stack_queue.TowersOfHanoi;

public class HanoiInitialTest {

	public static void main(String[] args) {
		
		Stack<Integer> f = new Stack<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		Stack<Integer> l = new Stack<Integer>();
		int n = 5;
		for(int i = n; i > 0; i--){
			f.push(i);
		}
		
		TowersOfHanoi hanoi = TowersOfHanoi.getInstance();
		
		hanoi.SolveHanoi(n, f, s, l);
		
		Iterator<Integer> it = l.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println(": " + l.peek());

	}

}
