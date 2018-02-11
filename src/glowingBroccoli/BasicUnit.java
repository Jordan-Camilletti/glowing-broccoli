/*Created by Jordan Camilletti*/

package glowingBroccoli;

import java.util.Random;

public class BasicUnit{
    private int[] loc=new int[2];
    private char spot='O';
    private boolean alive=true;
    private Random rnd=new Random();
    public BasicUnit(char[][] map){
            create(map);
    }
    public void create(char[][] map){
            alive=true;   
    }
}
