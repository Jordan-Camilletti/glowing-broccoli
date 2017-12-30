/**/

package main;

public class Main {
	public static void showMap(char[][] grid){
		for(int n1=0;n1<10;n1++){
			for(int n2=0;n2<10;n2++){
				System.out.print(grid[n1][n2]);
			}
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args){
		char[][] grid=new char[10][10];
		for(int i=0;i<100;i++){
			grid[i/10][i%10]='X';
		}
		grid[4][4]='O';
		showMap(grid);
	}
}
