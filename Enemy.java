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
		while((movement==0&&loc[0]<3)||(movement==1&&loc[1]>=8)||(movement==2&&loc[1]>=8)||(movement==3&&loc[0]<3)){
			movement=rnd.nextInt(4);
			System.out.println("X");
		}
		if(movement==0){//move up
			loc[0]-=1;
		}else if(movement==1){//move right
			loc[1]+=1;//TODO: add in enemySpot
		}else if(movement==2){//move down
			loc[0]+=1;
		}else if(movement==3){//move left
			loc[1]-=1;
		}else{//stay in place
			
		}
		//return(loc);
	}
}
