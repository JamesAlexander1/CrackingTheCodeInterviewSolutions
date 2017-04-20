package questions.structures.stack_queue;

import java.util.Stack;

public class TowersOfHanoi{

	private boolean isSolved;
	
	private TowersOfHanoi(){
		isSolved = false;
		
	}
	public void SolveHanoi(Integer n, Stack<Integer> F, Stack<Integer> S, Stack<Integer> L){
		
		if(n % 2 == 0){
			EvenSolve(n, F, S, L);
		}else{
			OddSolve(n, F, S, L);
		}
	}
	private void EvenSolve(Integer n, Stack<Integer> F, Stack<Integer> S, Stack<Integer> L){
		while(! Solved(n, L)){
			move(F, S);
			if(Solved(n,L)){ break; }
			move(F, L);
			if(Solved(n,L)){ break; }
			move(S, L);
		}
	}
	private void OddSolve(Integer n, Stack<Integer> F, Stack<Integer> S, Stack<Integer> L){
		while(! Solved(n, L)){
			move(F, L);
			if(Solved(n,L)){ break; }
			move(F, S);
			if(Solved(n,L)){ break; }
			move(S, L);
		}
	}
	private void move(Stack<Integer> A, Stack<Integer> B){
		//condiiton 1 - if one stack is empty
		if(A.isEmpty()){
			
			A.push(B.pop());
			
		}else if(B.isEmpty()){
			
			B.push(A.pop());
		//condition 2 
		}else{
			
			if(A.peek() > B.peek()){
				
				A.push(B.pop());
				
			}else{
				
				B.push(A.pop());
			}
		}
		
	}
	private boolean Solved(Integer n, Stack<Integer> L){
		
		if(L.size() == n){
			return true;
		}
		return false;
	}
	
	public static TowersOfHanoi getInstance(){
		return new TowersOfHanoi();
	}
}
