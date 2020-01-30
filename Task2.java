package amazon;

public class Task2 {
	
	public int Sol(int A, int B){
		int result = 0;
		int num = 1;
		if(A > B){
			return -1;
		}
		for(int i = A; i <= B; i++){
				while(num <= i/2){
					if(num * (num+1) != i){
					num++;
					}
					else{
						System.out.println(num);
						result++;
					}
			
				}
				
			
		}
		System.out.println(result);
		return result;
	}
	
	public static void main(String[] args){
		Task2 tsk = new Task2();
		int ind = tsk.Sol(6,20);
		System.out.println(ind);
	}

}
