package Islands;

import java.util.ArrayList;
import java.util.Scanner;

public class IslandDiscovery {
	
	
	public int countTotal(int[][] islands){
		int count = 0;
		for(int i = 0; i < islands.length; i++){
			for(int j = 0; j < islands[i].length; j++){
				if(islands[i][j] == 1){
					count += 1;
					bfs(islands, i, j);
				}
			}
		}
		return count;
	}
	
	public void bfs(int[][] grid, int i, int j){
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0){
			return;
			
		}
		grid[i][j] = 0;
		bfs(grid, i + 1, j);
		bfs(grid, i, j + 1);
		bfs(grid, i - 1, j);
		bfs(grid, i, j - 1);

	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("How many columns?");
		int cols = in.nextInt();
		System.out.println("How many rows?");
		int row = in.nextInt();
		int[][] isles = new int[row][cols];
		
		System.out.println("Enter your rows and exit to terminate: ");
		IslandDiscovery id = new IslandDiscovery();
		System.out.println("Enter your data: ");
		
		for(int i = 0; i < row; i++){
			
			
			for(int j = 0; j < cols; j++){
					isles[i][j] = in.nextInt();
			}
			
		}
		for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                System.out.print(isles[i][j]+"\t");
            }
             System.out.println();
            
        }

		System.out.println();
		System.out.println("number of islands is : " + id.countTotal(isles));
		
	}

}
