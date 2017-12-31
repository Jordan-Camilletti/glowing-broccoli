/**/

package main;

import javax.swing.JLabel;

public class Grid {
	public char[][] grid=new char[9][9];
	public Grid(){
		for(int i=0;i<81;i++){
			grid[i/9][i%9]='X';
		}
		grid[4][4]='O';
	}
	/*public void showMap(char[][] grid){
		for(int n1=0;n1<9;n1++){
			for(int n2=0;n2<9;n2++){
				System.out.print(grid[n1][n2]);
			}
			System.out.print("\n");
		}
	}*/
	public JLabel showMap(char[][] gird){
		String s="<html>";
		for(int n1=0;n1<9;n1++){
			for(int n2=0;n2<9;n2++){
				s=s+grid[n1][n2];
			}
			s=s+"<br/>";
		}
		s=s+"</html>";
		JLabel l=new JLabel(s+"</html>");
		return(l);
	}
	public void setEmpty(char[][] grid){
		for(int i=0;i<81;i++){
			grid[i/9][i%9]='X';
		}
		grid[4][4]='O';
	}
}
