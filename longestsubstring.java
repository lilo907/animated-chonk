package amazon;

import java.util.HashSet;

public class longestsubstring {

	HashSet<Character> h = new HashSet<Character>();
	int length = 0;
	public int addChar(String st){
		
		for(char ch : st.toCharArray()){
			if(!h.contains(ch)){
				h.add(ch);
				length = h.size();
			}
			if(h.contains(ch)){
				h.clear();
				h.add(ch);
				if(h.size() > length){
					length = h.size();
				}
			}
		}
		return length;
	}
	
	public static void main(String[] args){
		String str = "abccdfacrkd";
		longestsubstring lst = new longestsubstring();
		System.out.println(lst.addChar(str));
	}

}