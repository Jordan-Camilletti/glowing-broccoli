/*Created by Jordan Camilletti*/

package glowingBroccoli;

import javax.swing.JLabel;

public class Grid{
	private char[][] grid=new char[12][12];//complete grid, not all is seen at once. 2 outside rows are all #
	private JLabel l=new JLabel();
	private int[] player=new int[2];
	private int playerHP=5;
	private int ATP=3;
	private char playerSpot='O';//this is the spot the player is standing on
	private boolean playerTurn=true;
	private boolean endGame=false;
	private Enemy[] enemies=new Enemy[6];
	private Health[] heals=new Health[6];
        
	public Grid(){
		for(int i=0;i<100;i++){//sets the grid as empty
			if(i/10<2||i/10>=8||i%10<2||i%10>=8){
				grid[i/10][i%10]='#';
			}else if(Math.random()>=0.85){
				grid[i/10][i%10]='^';
			}else{
				grid[i/10][i%10]='O';
			}
		}
		player[0]=2;//y
		player[1]=2;//x
		grid[player[0]][player[1]]='B';
		for(int n=0;n<heals.length;n++){
			heals[n]=new Health(grid);
			grid[heals[n].getLoc()[0]][heals[n].getLoc()[1]]='H';
		}
		for(int n=0;n<enemies.length;n++){
			enemies[n]=new Enemy(grid);
			grid[enemies[n].getLoc()[0]][enemies[n].getLoc()[1]]='S';
		}
	}
	public char getSpot(int y,int x){
		return(grid[y][x]);
	}
	public boolean gameOver(){
		return(playerHP<=0);
	}
	public JLabel showMap(int turn){//returns a JLabel that outputs the grid visible to the player
		String s="<html>";
		for(int n1=player[0]-2;n1<=player[0]+2;n1++){
			for(int n2=player[1]-2;n2<=player[1]+2;n2++){
				s=s+grid[n1][n2];
				if(n1==player[0]-2 && n2==player[1]+2){
					s=s+" Turn: "+turn;
				}else if(n1==player[0]-1 && n2==player[1]+2){
					s=s+" HP: "+(playerHP);
				}else if(n1==player[0] && n2==player[1]+2){
					s=s+" ATP: "+(ATP);
				}
			}
			s=s+"<br/>";
		}
		s=s+"</html>";
		l.setText(s+"</html>");
		return(l);
	}
	public int playerMove(String wrd,int turn){//updates and changes the map
        grid[player[0]][player[1]]=playerSpot;
		switch(wrd.toUpperCase()){
		case "U": 
			if(player[0]>2 && ATP>0 && playerTurn){
				player[0]-=1;
				ATP--;
			}
			break;
		case "D": 
			if(player[0]<=6 && ATP>0 && playerTurn){
				player[0]+=1;
				ATP--;
			}
			break;
		case "L": 
			if(player[1]>2 && ATP>0 && playerTurn){
				player[1]-=1;
				ATP--;
			}
			break;
		case "R": 
			if(player[1]<=6 && ATP>0 && playerTurn){
				player[1]+=1;
				ATP--;
			}
			break;
                case "E"://end turn
                        playerTurn=false;
                        ATP=3;
                        turn++;
                        for(Enemy n:enemies){
                        	n.move(grid);
                        }
                        playerTurn=true;
                        break;
		case "QUIT":
			endGame=true;
			break;
		
		}
		playerSpot=grid[player[0]][player[1]];
		if(playerSpot=='^') ATP--;
		for(int n=0;n<heals.length;n++){
			//grid[heals[n].getLoc()[0]][heals[n].getLoc()[1]]=heals[n].getSpot();
			if(player[0]==heals[n].getLoc()[0] && player[1]==heals[n].getLoc()[1] && !heals[n].getUsed()){
				playerHP++;
				heals[n].use();
                                playerSpot=heals[n].getSpot();
			}
		}
		for(int n=0;n<enemies.length;n++){
			grid[enemies[n].getLoc()[0]][enemies[n].getLoc()[1]]=enemies[n].getSpot();
			if(enemies[n].isAlive()){
				grid[enemies[n].getLoc()[0]][enemies[n].getLoc()[1]]='S';
                        }else{//Bug: enemies that move close to their death often leave 'S' on grid, 'S' has no effects and needs to be removed
                                grid[enemies[n].getLoc()[0]][enemies[n].getLoc()[1]]=enemies[n].getSpot();
                        }
			if(player[0]==enemies[n].getLoc()[0] && player[1]==enemies[n].getLoc()[1] && enemies[n].isAlive()){//attack
				playerHP--;
				enemies[n].kill();
			}
		}
		grid[player[0]][player[1]]='B';
		l=showMap(turn);
		return(turn);
	}
        public boolean playerTurn(){
            return(playerTurn);
        }
        public void newTurn(){
            ATP=3;
            playerTurn=true;
        }
}