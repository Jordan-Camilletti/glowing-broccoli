/**/

package glowingBroccoli;

import java.util.Random;

public class Enemy {
	private int[] location=new int[2];
	public Enemy(){
		Random rnd=new Random();
		location[0]=rnd.nextInt(10)+2;//2 and 10 inclusive
		location[1]=rnd.nextInt(10)+2;
	}
}
