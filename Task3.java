package amazon;

import java.util.Scanner;


public class Task3 {
	
	public int robotPath(char[][] arr){
		int steps = 0;
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				if(arr[i][j] == 'F'){
					
					search(arr, i, j);
				}
			}
		}
		
		return steps;
	}
	
	public void search(char[][] grid, int i, int j){
		if(grid[i][j] == 'F'){
			grid[i][j] = 'T';
		}
		search(grid, i+1,j);
		search(grid, i,j+1);
		
		
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("How many columns?");
		int cols = in.nextInt();
		System.out.println("How many rows?");
		int row = in.nextInt();
		char[][] land = new char[row][cols];
		
		System.out.println("Enter your rows and exit to terminate: ");
		Task3 id = new Task3();
		System.out.println("Enter your data: ");
		
		for(int i = 0; i < row; i++){
			
			
			for(int j = 0; j < cols; j++){
					land[i][j] = in.next().charAt(0);
			}
			
		}
		for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                System.out.print(land[i][j]+"\t");
            }
             System.out.println();
            
        }

		System.out.println();
		System.out.println("number of steps is : " + id.robotPath(land));
	}
}
