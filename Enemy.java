/**/

package glowingBroccoli;

import java.util.Random;

public class Enemy {
	private int[] loc=new int[2];//enemy location
	private char enemySpot='O';
	public Enemy(char[][] map){
		Random rnd=new Random();
		loc[0]=2;
		loc[1]=2;
		while(map[loc[0]][loc[1]]=='B'||map[loc[0]][loc[1]]=='S'){
			loc[0]=rnd.nextInt(9)+2;
			loc[1]=rnd.nextInt(9)+2;
		}
		enemySpot=map[loc[0]][loc[1]];
	}
	public int[] getLoc(){
		return(loc);
	}
}
