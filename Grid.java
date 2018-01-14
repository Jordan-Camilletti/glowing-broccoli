/**/

package glowingBroccoli;

import javax.swing.JLabel;

public class Grid {
	private char[][] grid=new char[12][12];//complete grid, not all is seen at once. 2 outside rows are all #
	private JLabel l=new JLabel();
	private int[] player=new int[2];
	private char playerSpot='O';//this is the spot the player is standing on
	private boolean endGame=false;
	private Enemy[] enemies=new Enemy[1];
	public Grid(){
		for(int i=0;i<100;i++){//sets the grid as empty
			if(i/10<2||i/10>=8||i%10<2||i%10>=8){
				grid[i/10][i%10]='#';
			}else if(Math.random()>=0.9){
				grid[i/10][i%10]='^';
			}else{
				grid[i/10][i%10]='O';
			}
		}
		player[0]=2;//y
		player[1]=2;//x
		grid[player[0]][player[1]]='B';
		
		enemies[0]=new Enemy(grid);
		grid[enemies[0].getLoc()[0]][enemies[0].getLoc()[1]]='S';
		
	}
	public char getSpot(int y,int x){
		return(grid[y][x]);
	}
	public boolean gameOver(){
		return(endGame);
	}
	public JLabel showMap(int ATP, int turn){//returns a JLabel that outputs the grid visible to the player
		String s="<html>";
		for(int n1=player[0]-2;n1<=player[0]+2;n1++){
			for(int n2=player[1]-2;n2<=player[1]+2;n2++){
				s=s+grid[n1][n2];
				if(n1==player[0]-2 && n2==player[1]+2){
					s=s+" Turn: "+turn;
				}else if(n1==player[0]-1 && n2==player[1]+2){
					s=s+" ATP: "+(ATP+1);
				}
			}
			s=s+"<br/>";
		}
		s=s+"</html>";
		l.setText(s+"</html>");
		return(l);
	}
	public int update(String wrd,int ATP,int turn){//updates and changes the map
		grid[player[0]][player[1]]=playerSpot;
		switch(wrd.toUpperCase()){
		case "U": 
			if(player[0]>2){
				player[0]-=1;
				ATP--;
			}
			break;
		case "D": 
			if(player[0]<=6){
				player[0]+=1;
				ATP--;
			}
			break;
		case "L": 
			if(player[1]>2){
				player[1]-=1;
				ATP--;
			}
			break;
		case "R": 
			if(player[1]<=6){
				player[1]+=1;
				ATP--;
			}
			break;
		case "QUIT":
			endGame=true;
			break;
		}
		playerSpot=grid[player[0]][player[1]];
		grid[player[0]][player[1]]='B';
		grid[enemies[0].getLoc()[0]][enemies[0].getLoc()[1]]=enemies[0].getSpot();
		enemies[0].move(grid);
		grid[enemies[0].getLoc()[0]][enemies[0].getLoc()[1]]='S';//gave out of bounds exception
		if(playerSpot=='^') ATP--;
		if(player[0]==enemies[0].getLoc()[0] && player[1]==enemies[0].getLoc()[1]){//attack
			
		}
		l=showMap(ATP,turn);
		return(ATP);
	}
}
