/*Created by Jordan Camilletti*/

package glowingBroccoli;

import java.util.Random;

public class BasicUnit{
	protected int[] loc=new int[2];
	protected char spot='O';
	protected boolean alive=true;
	protected Random rnd=new Random();
	public BasicUnit(char[][] map, int vertSize, int horiSize){
		create(map,vertSize,horiSize);
	}
	public void create(char[][] map, int vertSize, int horiSize){
		alive=true;
		do{
			loc[0]=rnd.nextInt(vertSize-2)+2;
			loc[1]=rnd.nextInt(horiSize-2)+2;
		}while(map[loc[0]][loc[1]]=='B'||map[loc[0]][loc[1]]=='S'||map[loc[0]][loc[1]]=='#');
		spot=map[loc[0]][loc[1]];
	}
	public void use(){
		alive=false;
	}
	public int[] getLoc(){
		return(loc);
	}
	public char getSpot(){
		return(spot);
	}
	public boolean getAlive(){
		return(alive);
	}
}
