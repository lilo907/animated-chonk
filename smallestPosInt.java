package amazon;

import java.util.Arrays;

public class smallestPosInt {
	int result;
	public int sol(int[] A){
		
		int size = A.length;
	 Arrays.sort(A);
		for(int i = 0; i < size; i++){
		if(A[i+1] - A[i] != 1 && A[i+1] != A[i]){
			result = A[i] + 1;
			break;
		}
		else{
			result = A[size - 1] + 1;
		}
		
	}
		return result;
		
	}	
	public static void main(String[] args){
		smallestPosInt smol = new smallestPosInt();
		int[] arr = {1,3,6,4,1,2};
		System.out.println(smol.sol(arr));
	}
}
