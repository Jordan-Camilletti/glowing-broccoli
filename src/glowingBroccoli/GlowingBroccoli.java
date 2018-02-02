/*Created by Jordan Camilletti*/

package glowingBroccoli;

import java.util.Scanner;
import javax.swing.JFrame;

public class GlowingBroccoli{
	public static void main(String[] args){
		int /*ATP=2,*/turn=1;
                boolean pTurn=true;
		JFrame f=new JFrame("frame");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Grid map=new Grid();
		f.add(map.showMap(turn));
		f.pack();
		f.setVisible(true);
		Scanner k=new Scanner(System.in);
		String movement;
		while(!map.gameOver()){
			System.out.println("Turn " + turn);
			//while(pTurn){
				movement=k.nextLine();
				map.playerMove(movement,turn);
			//}
                        /*while(enemie's turn){
                            
                        }*/
		}
	}
}
