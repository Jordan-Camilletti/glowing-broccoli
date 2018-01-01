/**/

package main;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	public static void main(String[] args){
		JFrame f=new JFrame("frame");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JLabel l=new JLabel("<html>abcd<br/>efgh<br/>ijkl</html>");
		Grid map=new Grid();
		map.setEmpty();
		//map.showMap(map.grid);
		f.add(map.showMap());
		f.pack();
		f.setVisible(true);
	}
}
