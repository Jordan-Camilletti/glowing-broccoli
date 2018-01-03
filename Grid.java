/**/

package main;

import javax.swing.JLabel;

public class Grid {
	public char[][] grid=new char[10][10];//complete grid, not all is seen at once
	public JLabel l=new JLabel();
	public int[] player=new int[2];
	public char playerSpot='X';//this is the spot the player is standing on
	public Grid(){
		for(int i=0;i<100;i++){//sets the grid as empty
			if(i/10==0||i/10==9||i%10==0||i%10==9){
				this.grid[i/10][i%10]='#';
			}else if(Math.random()>=0.9){
				this.grid[i/10][i%10]='^';
			}else{
				this.grid[i/10][i%10]='X';
			}
		}
		this.player[0]=2;//y
		this.player[1]=2;//x
		this.grid[this.player[0]][this.player[1]]='O';
	}
	public JLabel showMap(){//returns a JLabel that outputs the grid visible to the player
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
	public void update(String wrd){//updates the visible map
		switch(wrd.toUpperCase()){
		this.grid[this.player[0]][this.player[1]]=this.playerSpot;
		case "U": 
			System.out.print("U");
			this.player[0]-=1;
			break;
		case "D": 
			System.out.print("D");
			this.player[0]+=1;
			break;
		case "L": 
			System.out.print("L");
			this.player[1]-=1;
			break;
		case "R": 
			System.out.print("R");
			this.player[1]+=1;
			break;
		}
		this.grid[this.player[0]][this.player[1]]='O';
		this.l=showMap();
	}
}
