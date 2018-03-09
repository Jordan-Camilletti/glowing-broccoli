/*Created by Jordan Camilletti*/

package glowingBroccoli;

public class Upgrade extends BasicUnit{
	public Upgrade(char[][] map,int vertSize,int horiSize){
		super(map,vertSize,horiSize);
	}
	public int getPower(){
		return(rnd.nextInt(5));
	}//0==+5 health,1==+10 health,2==2 free clones,3==+3 ATP,4==+1 ATP every turn
}
