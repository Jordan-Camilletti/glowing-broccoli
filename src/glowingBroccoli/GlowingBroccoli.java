/*Created by Jordan Camilletti*/

package glowingBroccoli;

import java.util.Scanner;
import javax.swing.JFrame;

public class GlowingBroccoli{
	public static void main(String[] args){
		int turn=1;
		Grid map=new Grid();
		JFrame f=new JFrame("frame");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(map.showMap(turn));
		f.pack();
		f.setVisible(true);
		Scanner k=new Scanner(System.in);
		String movement;
		while(!map.gameOver()){
			System.out.println("Turn " + turn);
			movement=k.nextLine();
			turn=map.playerMove(movement,turn);
		}
	}
}
