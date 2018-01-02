/**/

package main;

import javax.swing.JLabel;

public class Grid {
	public char[][] grid=new char[10][10];
	public JLabel l=new JLabel();
	public int[] player=new int[2];
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
		for(int n1=0;n1<5;n1++){
			for(int n2=0;n2<5;n2++){
				s=s+this.grid[n1][n2];
			}
			s=s+"<br/>";
		}
		s=s+"</html>";
		this.l.setText(s+"</html>");
		return(l);
	}
	public void setEmpty(){//Creates the grid and it's components
		for(int i=0;i<100;i++){
			if(i/5==0||i/5==8||i%5==0||i%5==8){
				this.grid[i/5][i%5]='#';
			}else if(Math.random()>=0.8){
				this.grid[i/5][i%5]='X';
			}else{
				this.grid[i/5][i%5]='^';
			}
		}
		this.grid[1][1]='O';
		this.player[0]=1;
		this.player[1]=1;
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
