package gs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class twoSumArray {

	public int[] twoSum(int[] nums, int target){
		int[] result = new int[2];
		Map<Integer, Integer> numIndex = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++){
			Integer val = numIndex.get(target - nums[i]);
			if (val == null){
				numIndex.put(nums[i], i);
			}else{
				result[0] = val;
				result[1] = i;
				break;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("enter target:");
		int target = sc.nextInt();
		System.out.println("enter numbers: ");
		int[] myArr = new int[10];
		for(int i = 0; i < myArr.length; i++){
			myArr[i] = sc.nextInt();
		}
		
		twoSumArray finArr = new twoSumArray();
		
		System.out.println(Arrays.toString(finArr.twoSum(myArr, target)));
		
	}
}
