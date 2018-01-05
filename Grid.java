/**/

package main;

import javax.swing.JLabel;

public class Grid {
	public char[][] grid=new char[10][10];//complete grid, not all is seen at once
	public JLabel l=new JLabel();
	public int[] player=new int[2];
	public char playerSpot='O';//this is the spot the player is standing on
	public Grid(){
		for(int i=0;i<100;i++){//sets the grid as empty
			if(i/10==0||i/10==9||i%10==0||i%10==9){
				this.grid[i/10][i%10]='#';
			}else if(Math.random()>=0.9){
				this.grid[i/10][i%10]='^';
			}else{
				this.grid[i/10][i%10]='O';
			}
		}
		this.player[0]=2;//y
		this.player[1]=2;//x
		this.grid[this.player[0]][this.player[1]]='B';
	}
	public JLabel showMap(){//returns a JLabel that outputs the grid visible to the player
		String s="<html>";
		for(int n1=0;n1<5;n1++){
			for(int n2=0;n2<5;n2++){
				s=s+this.grid[n1][n2];//TODO: change this so that the visible map follows the player
			}
			s=s+"<br/>";
		}
		s=s+"</html>";
		this.l.setText(s+"</html>");
		return(l);
	}
	/*public void setEmpty(){//Creates the grid and it's components
		
	}*/
	public void update(String wrd){//updates and changes the map
		this.grid[this.player[0]][this.player[1]]=this.playerSpot;
		switch(wrd.toUpperCase()){
		case "U": 
			if(this.player[0]>1){
				this.player[0]-=1;
			}
			break;
		case "D": 
			if(this.player[0]<8){
				this.player[0]+=1;
			}
			break;
		case "L": 
			if(this.player[1]>1){
				this.player[1]-=1;
			}
			break;
		case "R": 
			if(this.player[1]<8){
				this.player[1]+=1;
			}
			break;
		case "QUIT":
			endGame();
			break;
		}
		this.playerSpot=this.grid[this.player[0]][this.player[1]];
		this.grid[this.player[0]][this.player[1]]='B';
		this.l=showMap();
	}
}
