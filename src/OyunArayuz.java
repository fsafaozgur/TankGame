import java.awt.HeadlessException;

import javax.swing.JFrame;

public class OyunArayuz extends JFrame {


	public OyunArayuz(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}	
	
	
	
	
	
public static void main (String[] Args)
{
	
OyunArayuz frame = new OyunArayuz("Tank Oyunu");

frame.setResizable(false);
frame.setFocusable(false);

frame.setSize(700, 600);
frame.setLocation(300, 100);

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

Oyun oyun = new Oyun();

oyun.requestFocus();

oyun.addKeyListener(oyun);
oyun.setFocusable(true);
oyun.setFocusTraversalKeysEnabled(false);

frame.add(oyun);


frame.setVisible(true);

}



	
	
	
	
	
	
}
