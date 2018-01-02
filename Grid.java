/**/

package main;

import javax.swing.JLabel;

public class Grid {
	public char[][] grid=new char[10][10];
	public JLabel l=new JLabel();
	public int[] player=new int[2];
	public Grid(){
		for(int i=0;i<100;i++){
			if(i/10==0||i/10==9||i%10==0||i%10==9){
				this.grid[i/10][i%10]='#';
			}else if(Math.random()>=0.9){
				this.grid[i/10][i%10]='^';
			}else{
				this.grid[i/10][i%10]='X';
			}
		}
		this.grid[1][1]='O';
		this.player[0]=1;
		this.player[1]=1;
	}
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
	/*public void setEmpty(){//Creates the grid and it's components
		
	}*/
	public void update(String wrd){
		switch(wrd.toUpperCase()){
		case "U": 
			System.out.print("U");
			break;
		case "D": 
			System.out.print("D");
			break;
		case "L": 
			System.out.print("L");
			break;
		case "R": 
			System.out.print("R");
			break;
		}
		this.l=showMap();
	}
}
