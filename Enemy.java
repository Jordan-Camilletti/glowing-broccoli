/**/

package glowingBroccoli;

import java.util.Random;

public class Enemy {
	private int[] loc=new int[2];//enemy location
	private char enemySpot='O';
	private Random rnd=new Random();
	public Enemy(char[][] map){
		loc[0]=2;
		loc[1]=2;
		while(map[loc[0]][loc[1]]=='B'||map[loc[0]][loc[1]]=='S'||map[loc[0]][loc[1]]=='#'){
			loc[0]=rnd.nextInt(9)+2;
			loc[1]=rnd.nextInt(9)+2;
		}
		enemySpot=map[loc[0]][loc[1]];
	}
	public int[] getLoc(){
		return(loc);
	}
	public void move(){
		int movement=rnd.nextInt(4);
		if(movement==0){//move up
			if(){
				
			}else{
				
			}
		}else if(movement==1){//move right
			if(){
				
			}else{
				
			}
		}else if(movement==2){//move down
			if(){
				
			}else{
				
			}
		}else if(movement==3){//move left
			if(){
				
			}else{
				
			}
		}else{//stay in place
			
		}
	}
}
