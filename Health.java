/*Created by Jordan Camilletti*/

package glowingBroccoli;

import java.util.Random;

public class Health{
	private int[] loc=new int[2];
	private char healthSpot='O';
	private boolean used=false;
	private Random rnd=new Random();
	public Health(char[][] map){
		create(map);
	}
	public void create(char[][] map){
		used=true;
		loc[0]=2;
		loc[1]=2;
		while(map[loc[0]][loc[1]]=='B'||map[loc[0]][loc[1]]=='S'||map[loc[0]][loc[1]]=='#'){
			loc[0]=rnd.nextInt(6)+2;
			loc[1]=rnd.nextInt(6)+2;
		}
		healthSpot=map[loc[0]][loc[1]];
	}
	public void use(){
		used=true;
	}
	public int[] getLoc(){
	return(loc);
	}
	public boolean getUsed(){
		return(used);
	}
}
