/**/

package main;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	public static void main(String[] args){
		JFrame f=new JFrame("frame");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel l=new JLabel("<html>abcd<br/>efgh<br/>ijkl</html>");
		Grid map=new Grid();//TODO: add 'map' to label 'l' to put the grid onto the window
		map.setEmpty(map.grid);
		map.showMap(map.grid);
		f.add(l);
		f.pack();
		f.setVisible(true);
	}
}
