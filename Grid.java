/**/

package glowingBroccoli;

import javax.swing.JLabel;

public class Grid {
	private char[][] grid=new char[12][12];//complete grid, not all is seen at once. 2 outside rows are all #
	private JLabel l=new JLabel();
	private int[] player=new int[2];
	private char playerSpot='O';//this is the spot the player is standing on
	private boolean endGame=true;
	public Grid(){
		for(int i=0;i<100;i++){//sets the grid as empty
			if(i/10<2||i/10>=8||i%10<2||i%10>=8){
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
	public JLabel showMap(int ATP, int turn){//returns a JLabel that outputs the grid visible to the player
		String s="<html>";
		for(int n1=this.player[0]-2;n1<=this.player[0]+2;n1++){
			for(int n2=this.player[1]-2;n2<=this.player[1]+2;n2++){
				s=s+this.grid[n1][n2];//TODO: change this so that the visible map follows the player
				if(n1==this.player[0]-2 && n2==this.player[1]+2){
					s=s+" Turn: "+turn;
				}else if(n1==this.player[0]-1 && n2==this.player[1]+2){
					s=s+" ATP: "+(ATP+1);
				}
			}
			s=s+"<br/>";
		}
		s=s+"</html>";
		this.l.setText(s+"</html>");
		return(l);
	}
	public boolean gameOver(){
		return(endGame);
	}
	public int update(String wrd,int ATP,int turn){//updates and changes the map
		this.grid[this.player[0]][this.player[1]]=this.playerSpot;
		switch(wrd.toUpperCase()){
		case "U": 
			if(this.player[0]>2){
				this.player[0]-=1;
				ATP--;
			}
			break;
		case "D": 
			if(this.player[0]<=6){
				this.player[0]+=1;
				ATP--;
			}
			break;
		case "L": 
			if(this.player[1]>2){
				this.player[1]-=1;
				ATP--;
			}
			break;
		case "R": 
			if(this.player[1]<=6){
				this.player[1]+=1;
				ATP--;
			}
			break;
		case "QUIT":
			endGame=true;
			break;
		}
		this.playerSpot=this.grid[this.player[0]][this.player[1]];
		this.grid[this.player[0]][this.player[1]]='B';
		if(this.playerSpot=='^') ATP--;
		this.l=showMap(ATP,turn);
		return(ATP);
	}
}
