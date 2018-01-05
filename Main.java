/**/

package main;

import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	public static void main(String[] args){
		JFrame f=new JFrame("frame");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Grid map=new Grid();
		f.add(map.showMap());
		f.pack();
		f.setVisible(true);
		Scanner k=new Scanner(System.in);
		String movement;
		while(!map.endGame()){//TODO: add win/lose and change this
			movement=k.nextLine();
			map.update(movement);
		}
	}
}
