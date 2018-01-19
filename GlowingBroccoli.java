/*Created by Jordan Camilletti*/

package glowingBroccoli;

import java.util.Scanner;
import javax.swing.JFrame;

public class GlowingBroccoli{
	public static void main(String[] args){
		int ATP=2,turn=1;
		JFrame f=new JFrame("frame");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Grid map=new Grid();
		f.add(map.showMap(ATP,turn));
		f.pack();
		f.setVisible(true);
		Scanner k=new Scanner(System.in);
		String movement;
		while(!map.gameOver()){
			System.out.println("Turn " + turn);
			while(ATP>0){
				movement=k.nextLine();
				ATP=map.playerMove(movement,ATP,turn);
			}
			turn++;
			ATP=3;
			map.enemyMove();
		}
	}
}
