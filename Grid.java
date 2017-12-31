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
	/*public void showMap(){
		for(int n1=0;n1<9;n1++){
			for(int n2=0;n2<9;n2++){
				System.out.print(this.grid[n1][n2]);
			}
			System.out.print("\n");
		}
	}*/
	public JLabel showMap(){
		String s="<html>";
		for(int n1=0;n1<9;n1++){
			for(int n2=0;n2<9;n2++){
				s=s+this.grid[n1][n2];
			}
			s=s+"<br/>";
		}
		s=s+"</html>";
		JLabel l=new JLabel(s+"</html>");
		return(l);
	}
	public void setEmpty(){
		for(int i=0;i<81;i++){
			this.grid[i/9][i%9]='X';
		}
		this.grid[4][4]='O';
	}
}
