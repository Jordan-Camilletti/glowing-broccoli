/*Created by Jordan Camilletti*/

package glowingBroccoli;

import javax.swing.JLabel;
import java.util.*;
import java.awt.Color;

public class Grid{
	private char[][] grid=new char[12][12];//complete grid, not all is seen at once. 2 outside rows are all #
	private JLabel l=new JLabel();
	private int[] player=new int[2];
	private int playerHP=5;
	private int ATP=3;
	private char playerSpot='O';//this is the spot the player is standing on
	private boolean playerTurn=true;
	private boolean endGame=false;
	private ArrayList<Enemy> enemies=new ArrayList<Enemy>();
	private ArrayList<Health> heals=new ArrayList<Health>();
	private ArrayList<Clone> clones=new ArrayList<Clone>();
        
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
		for(int n=0;n<6;n++){//starting off with 6 heals and 6 enemies
			enemies.add(new Enemy(grid));
			heals.add(new Health(grid));
			grid[enemies.get(n).getLoc()[0]][enemies.get(n).getLoc()[1]]='S';
			grid[heals.get(n).getLoc()[0]][heals.get(n).getLoc()[1]]='P';
		}
	}
	public char getSpot(int y,int x){
		return(grid[y][x]);
	}
	public boolean gameOver(){
		return(playerHP<=0 || endGame);
	}
	public boolean enemyDeath(){//might need to be renamed to 'calculateDeath()'
		return(true);//TODO: set this up for clones
	}
	public boolean playerTurn(){
		return(playerTurn);
	}
	public void newTurn(){
		ATP=4;
		playerTurn=true;
	}
	public JLabel showMap(int turn){//returns a JLabel that outputs the grid visible to the player
		String s="<html>";
		for(int n1=player[0]-2;n1<=player[0]+2;n1++){
			for(int n2=player[1]-2;n2<=player[1]+2;n2++){
				//s=s+grid[n1][n2];
                                if(grid[n1][n2]=='B'){
                                    s=s+"<font color=green>"+grid[n1][n2]+"</font>";
                                }else if(grid[n1][n2]=='S'){
                                    s=s+"<font color=red>"+grid[n1][n2]+"</font>";
                                }else if(grid[n1][n2]=='P'){
                                    s=s+"<font color=blue>"+grid[n1][n2]+"</font>";
                                }else if(grid[n1][n2]=='^'){
                                    s=s+"<font color=#999999>"+grid[n1][n2]+"</font>";
                                }else if(grid[n1][n1]=='#'){
                                    s=s+"<font color=>"+grid[n1][n2]+"</font>";
                                }else{
                                    s=s+grid[n1][n2];
                                }
				if(n1==player[0]-2 && n2==player[1]+2){
					s=s+" Turn: "+(turn);
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
                //l.setForeground(Color.red);
		return(l);
	}
	public int playerMove(String wrd,int turn){//updates and changes the map
		grid[player[0]][player[1]]=playerSpot;
		switch(wrd.toUpperCase()){
		case "SPINACH"://TESTING ONLY
			ATP=999;
			break;
		case "U": 
			if(player[0]>2 && ATP>0 && playerTurn){
				player[0]-=1;
			}
			break;
		case "D": 
			if(player[0]<=6 && ATP>0 && playerTurn){
				player[0]+=1;
			}
			break;
		case "L": 
			if(player[1]>2 && ATP>0 && playerTurn){
				player[1]-=1;
			}
			break;
		case "R": 
			if(player[1]<=6 && ATP>0 && playerTurn){
				player[1]+=1;
			}
			break;
		case "C"://create a clone
			if(ATP>0 && playerHP>0){
				clones.add(new Clone(grid));
			}
			break;
		case "E"://end turn
			playerTurn=false;
			turn++;
			for(int n=0;n<enemies.size();n++)//enemies move
				enemies.get(n).move(grid);
			for(int n=0;n<clones.size();n++)//clones move
				clones.get(n).move(grid);
			for(int n=0;n<6;n++){
				if(enemies.get(n).getAlive() && turn%2==0){
					enemies.add(new Enemy(grid));
				}//adds an enemy for each of the 6 first enemies
				if(heals.get(n).getAlive() && turn%2!=0){
					heals.add(new Health(grid));
				}//adds a health pack for each of the 6 first heals
			}
			newTurn();
			break;
		case "QUIT":
			endGame=true;
			break;
		}
		ATP--;
		playerSpot=grid[player[0]][player[1]];
		if(playerSpot=='^') ATP--;
		for(int n=0;n<heals.size();n++){//updates health position and status
			//grid[heals[n].getLoc()[0]][heals[n].getLoc()[1]]=heals[n].getSpot();
			if(heals.get(n).getAlive()){
				grid[heals.get(n).getLoc()[0]][heals.get(n).getLoc()[1]]='P';
			}else{
				grid[heals.get(n).getLoc()[0]][heals.get(n).getLoc()[1]]=heals.get(n).getSpot();
			}
			if(player[0]==heals.get(n).getLoc()[0] && player[1]==heals.get(n).getLoc()[1] && heals.get(n).getAlive()){
				playerHP++;
				heals.get(n).use();
				playerSpot=heals.get(n).getSpot();
			}
		}
		for(int n=0;n<enemies.size();n++){//updates enemy positions and status
			grid[enemies.get(n).getLoc()[0]][enemies.get(n).getLoc()[1]]=enemies.get(n).getSpot();
			if(enemies.get(n).getAlive()){
				grid[enemies.get(n).getLoc()[0]][enemies.get(n).getLoc()[1]]='S';
			}else{
				grid[enemies.get(n).getLoc()[0]][enemies.get(n).getLoc()[1]]=enemies.get(n).getSpot();
			}
			if(player[0]==enemies.get(n).getLoc()[0] && player[1]==enemies.get(n).getLoc()[1] && enemies.get(n).getAlive()){
				playerHP--;
				enemies.get(n).use();
				playerSpot=enemies.get(n).getSpot();
			}
			for(int n2=0;n2<clones.size();n2++){
				if(clones.get(n2).getAlive() && enemies.get(n).getAlive() && clones.get(n2).getLoc()[0]==enemies.get(n).getLoc()[0] && clones.get(n2).getLoc()[1]==enemies.get(n).getLoc()[1]){
					clones.get(n2).use();
					enemies.get(n).use();
				}
			}
		}
		for(int n=0;n<clones.size();n++){//updates clone position and status
			grid[clones.get(n).getLoc()[0]][clones.get(n).getLoc()[1]]=clones.get(n).getSpot();
			if(clones.get(n).getAlive()){
				grid[clones.get(n).getLoc()[0]][clones.get(n).getLoc()[1]]='B';
			}else{
				grid[clones.get(n).getLoc()[0]][clones.get(n).getLoc()[1]]=clones.get(n).getSpot();
			}
			for(int n2=0;n2<enemies.size();n2++){
				if(clones.get(n).getAlive() && enemies.get(n2).getAlive() && clones.get(n).getLoc()[0]==enemies.get(n2).getLoc()[0] && clones.get(n).getLoc()[1]==enemies.get(n2).getLoc()[1]){
					clones.get(n).use();
					enemies.get(n2).use();
				}
			}
		}
		grid[player[0]][player[1]]='B';
		l=showMap(turn);
		return(turn);
	}
}
