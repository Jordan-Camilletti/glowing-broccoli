/**/

package main;

import javax.swing.JLabel;

public class Grid {
	public char[][] grid=new char[21][21];
	public JLabel l=new JLabel();
	public Grid(){
		setEmpty();
	}
	/*public void showMap(){
		for(int n1=0;n1<9;n1++){
			for(int n2=0;n2<9;n2++){
				System.out.print(this.grid[n1][n2]);
			}
			System.out.print("\n");
		}
	}*/
	public JLabel showMap(){//returns a JLabel that outputs the grid
		String s="<html>";
		for(int n1=0;n1<9;n1++){
			for(int n2=0;n2<9;n2++){
				s=s+this.grid[n1][n2];
			}
			s=s+"<br/>";
		}
		s=s+"</html>";
		this.l.setText(s+"</html>");
		return(l);
	}
	public void setEmpty(){//Sets the grid completely empty
		for(int i=0;i<81;i++){
			if(i/9==0||i/9==8){
				this.grid[i/9][i%9]='|';
			}else if(i%9==0||i%9==8){
				this.grid[i/9][i%9]='-';
			}else if(Math.random()>=0.5){
				this.grid[i/9][i%9]='X';
			}else{
				this.grid[i/9][i%9]='^';
			}
		}
		this.grid[4][4]='O';
	}
	public void update(String wrd){
		switch(wrd.toUpperCase()){
		case "UP": 
			System.out.print("U");
			break;
		case "DOWN": 
			System.out.print("D");
			break;
		case "LEFT": 
			System.out.print("L");
			break;
		case "RIGHT": 
			System.out.print("R");
			break;
		}
		this.l=showMap();
	}
}
