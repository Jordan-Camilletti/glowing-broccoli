/*Created by Jordan Camilletti*/

package glowingBroccoli;

import java.util.Random;

public class Health{//will possibly change this to an extension of a base object class
	private int[] loc=new int[2];
	private char healthSpot='O';
	private boolean alive=true;
	private Random rnd=new Random();
	public Health(char[][] map){
		create(map);
	}
	public void create(char[][] map){
		alive=true;
		loc[0]=2;
		loc[1]=2;
		do{
			loc[0]=rnd.nextInt(6)+2;
			loc[1]=rnd.nextInt(6)+2;
		}while(map[loc[0]][loc[1]]=='B'||map[loc[0]][loc[1]]=='S'||map[loc[0]][loc[1]]=='#');
		healthSpot=map[loc[0]][loc[1]];
	}
	public void use(){
		alive=false;
	}
	public int[] getLoc(){
		return(loc);
	}
	public boolean getAlive(){
		return(alive);
	}
	public char getSpot(){
		return(healthSpot);
	}
}
