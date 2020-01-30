package gs;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class nonRepeatDigitProduct {
	
	static int productCount(int x, int y, int z){
		if(x == 1 || y > z){
			return 0;
		}
		
		Set<Character> set1 = new HashSet<Character>();
		Set<Character> set2 = new HashSet<Character>();
		int count = 0;
		for(int i = y; i <= z; i++){
			long product = i*x;
			for(char ch: (i + "").toCharArray())
				set1.add(ch);
			for(char ch:(product + "").toCharArray())
				set2.add(ch);
			
			int set2size = set2.size();
			set2.addAll(set1);
			if(set1.size() + set2.size() > set2.size()){
				count++;
			}
			set1.clear();
			set2.clear();
			
		}
		return count;
		
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a number");
		int x = in.nextInt();
		System.out.println("Enter a range starting number");
		int y = in.nextInt();
		System.out.println("Enter a range ending number");
		int z = in.nextInt();
		int prodCount = productCount(x, y, z);
		System.out.println("count:" + prodCount);
	}

}
