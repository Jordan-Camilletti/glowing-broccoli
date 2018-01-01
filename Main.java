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
		for(int n=0;n<4;n++){
			String test1=k.nextLine();
			map.update(test1);
		}
	}
}
