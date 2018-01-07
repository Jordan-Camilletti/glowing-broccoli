/**/

package main;

import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	public static void main(String[] args){
		int ATP=3,turn=0;;
		JFrame f=new JFrame("frame");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Grid map=new Grid();
		f.add(map.showMap());
		f.pack();
		f.setVisible(true);
		Scanner k=new Scanner(System.in);
		String movement;
		while(!map.gameOver){//TODO: add win/lose and change this
			movement=k.nextLine();
			turn++;
			ATP=3;
			while(ATP>0){
				map.update(movement);
				ATP--;
			}
			System.out.println(turn);
		}
	}
}
