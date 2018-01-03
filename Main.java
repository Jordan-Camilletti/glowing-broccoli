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
		while(true){//TODO: add win/lose and change this
			String test1=k.nextLine();
			map.update(test1);
		}
	}
}
