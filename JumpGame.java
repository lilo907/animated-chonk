package amazon;

import java.util.Arrays;

public class JumpGame {
	
	public int jump(int[] nums){
		int steps = 0;
		int last = 0;
		int jumpLength = 0;
		
		for(int i = 0; i < jumpLength && i < nums.length; i++){
			if(i > last){
				steps++;
				last = jumpLength;
			}
			jumpLength = Math.max(jumpLength, nums[i] + i);
		}
		if(jumpLength < nums.length - 1){
			return 0;
		}
		return steps;


}
}