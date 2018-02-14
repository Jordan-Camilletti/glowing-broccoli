/*Created by Jordan Camilletti*/

package glowingBroccoli;

import java.util.Random;

public class Enemy extends BasicUnit{
	public Enemy(char[][] map) {
		super(map);
	}
	public void move(char[][] grid){
		int movement=rnd.nextInt(4);
		grid[loc[0]][loc[1]]=spot;
		if(movement==0 && grid[loc[0]-1][loc[1]]!='#'){//move up
			loc[0]-=1;
		}else if(movement==1 && grid[loc[0]][loc[1]+1]!='#'){//move right
			loc[1]+=1;
		}else if(movement==2 && grid[loc[0]+1][loc[1]]!='#'){//move down
			loc[0]+=1;
		}else if(movement==3 && grid[loc[0]][loc[1]-1]!='#'){//move left
			loc[1]-=1;
		}
		spot=grid[loc[0]][loc[1]];
	}
}
