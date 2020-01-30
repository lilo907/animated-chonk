package amazon;

public class Task1 {
	public int Sol(int A, int B){
		String numA = String.valueOf(A);
		String numB = String.valueOf(B);
		int pos = numB.indexOf(numA);		
		return pos;
	}
	
	public static void main(String[] args){
		Task1 tsk = new Task1();
		int ind = tsk.Sol(53,195378);
		System.out.println(ind);
	}
}
