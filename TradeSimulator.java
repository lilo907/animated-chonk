package tradesim;

import java.util.ArrayList;
import java.util.Scanner;

public class TradeSimulator {
	int buy, sell;
	
	public int maxProfit(ArrayList<Integer> prices){
		if(prices == null || prices.size() == 1){
			return 0;
		}
		int min = prices.get(0); //min so far
		int max = prices.get(0);
		
		for(int i = 1; i < prices.size(); i++){
			int temp = prices.get(i);
			if(temp <= min){
				min = temp;
			}
			if(temp >= max){
				max = temp;
			}
			
				
			
		}
		System.out.println("The best price to buy is " + min);
		System.out.println("The best price to sell is " + max);
		return (max - min);
			
		}
		
	
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		TradeSimulator ts = new TradeSimulator();
		ArrayList<Integer> prices = new ArrayList<Integer>();
		System.out.println("Enter prices of stock for each day and type 'exit' to terminate:");
		while(!in.equals("exit") && in.hasNextInt()){
			prices.add(in.nextInt());
		}
		
		System.out.println(ts.maxProfit(prices));
		
		
	}

}
