/*Created by Jordan Camilletti*/

package glowingBroccoli;

import java.util.Random;

public class Enemy{//will possibly change this to an extension of a base object class
	private int[] loc=new int[2];//enemy location
	private char enemySpot='O';
	private boolean alive=true;
	private Random rnd=new Random();
	public Enemy(char[][] map){
		create(map);
	}
	public void create(char[][] map){
		alive=true;
		do{
			loc[0]=rnd.nextInt(6)+2;
			loc[1]=rnd.nextInt(6)+2;
		}while(map[loc[0]][loc[1]]=='B'||map[loc[0]][loc[1]]=='S'||map[loc[0]][loc[1]]=='#');
		enemySpot=map[loc[0]][loc[1]];
	}
	public void use(){
		alive=false;
	}
	public int[] getLoc(){
		return(loc);
	}
	public char getSpot(){
		return(enemySpot);
	}
	public boolean getAlive(){
		return(alive);
	}
	public void move(char[][] grid){
		int movement=rnd.nextInt(4);
		grid[loc[0]][loc[1]]=enemySpot;
		if(movement==0 && grid[loc[0]-1][loc[1]]!='#'){//move up
			loc[0]-=1;
		}else if(movement==1 && grid[loc[0]][loc[1]+1]!='#'){//move right
			loc[1]+=1;
		}else if(movement==2 && grid[loc[0]+1][loc[1]]!='#'){//move down
			loc[0]+=1;
		}else if(movement==3 && grid[loc[0]][loc[1]-1]!='#'){//move left
			loc[1]-=1;
		}
		enemySpot=grid[loc[0]][loc[1]];
	}
}
