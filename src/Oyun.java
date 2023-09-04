import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


class Mermi{
	
private int mermiX;
private int mermiY;

public Mermi(int mermiX, int mermiY) {
	super();
	this.mermiX = mermiX;
	this.mermiY = mermiY;
}




public int getMermiX() {
	return mermiX;
}




public void setMermiX(int mermiX) {
	this.mermiX = mermiX;
}




public int getMermiY() {
	return mermiY;
}

public void setMermiY(int mermiY) {
	this.mermiY = mermiY;
}


	
	
}
//------------------------------------------------//
class Dusman {

	private int dusmanX;
	private int dusmanY;
	
	public Dusman(int dusmanX, int dusmanY) {
		super();
		this.dusmanX = dusmanX;
		this.dusmanY = dusmanY;
	}

	public int getDusmanX() {
		return dusmanX;
	}

	public void setDusmanX(int dusmanX) {
		this.dusmanX = dusmanX;
	}

	public int getDusmanY() {
		return dusmanY;
	}

	public void setDusmanY(int dusmanY) {
		this.dusmanY = dusmanY;
	}
	
	
	
	
	
}

//------------------------------------------------------//

public class Oyun extends JPanel implements ActionListener, KeyListener  {


Timer timer = new Timer(10, this);	
Random rand = new Random();	
	
private BufferedImage image;
private BufferedImage imageDusman;
private ArrayList<Mermi> mermiler = new ArrayList<Mermi>();
private ArrayList<Dusman> dusmanlar = new ArrayList<Dusman>();
	
private int mermiHareket = 2;
private int dusmanHareket = 1;


private int tankX = 0;
private int tankHareket = 25;

private int dusmanUretme = 0;
private int rastgele = 0;
private int dusmanOldurme = 0;

	public Oyun() {
	
	try {
		image = ImageIO.read(new FileImageInputStream(new File("tank.png")));
		imageDusman = ImageIO.read(new FileImageInputStream(new File("dusmanTank.png")));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	setBackground(Color.BLACK);
	timer.start();
}

//-------------------------------------------------//	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	
		g.drawImage(image, tankX, 480, image.getWidth()/2, image.getHeight()/3, this);
	
		
		for (Mermi mermi: mermiler)
		{
			for (Dusman dusman: dusmanlar)
			{
			//if (new Rectangle(mermi.getMermiX(), mermi.getMermiY(), 7, 14).intersects(new Rectangle(dusman.getDusmanX(), dusman.getDusmanY(), 10, 20)));
				if ( (mermi.getMermiX()- dusman.getDusmanX())<50  && (mermi.getMermiX()- dusman.getDusmanX()) >0 )
				{
					if ((mermi.getMermiY() - dusman.getDusmanY())<60 && (mermi.getMermiY() - dusman.getDusmanY()) >0)
					{
						dusmanlar.remove(dusman);
						dusmanOldurme++;
						mermiler.remove(mermi);
						break;
					}
				}
				//else if ()
				//{
				//dusmanlar.remove(dusman);	
				//}
			}
			
		}
		
		
		
		
		
		for (Dusman dusman: dusmanlar)
		{
			g.drawImage(imageDusman, dusman.getDusmanX(), dusman.getDusmanY(), imageDusman.getWidth()/2, imageDusman.getHeight()/3, this);
			if (dusman.getDusmanY() > 570)
			{
				timer.stop();
				JOptionPane.showMessageDialog(this, "Öldünüz ama "+dusmanOldurme+ " tane düþman hakladýnýz");
				System.exit(0);
			}
		
			
		}
		
		
		
		
		
		
		
		g.setColor(Color.BLUE);
		
		for (Mermi mermi: mermiler)
		{
			g.fillRect(mermi.getMermiX(),mermi.getMermiY(), 7, 14);
			if (mermi.getMermiY() < 0)
			{
				mermiler.remove(mermi);
			}
		
			
		}
		
		
		
		
		
		}
	
	
	
	
	
	
	
	
	
		
	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		super.repaint();
	}

	
//--------------------------------------------------//	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		for(Mermi mermi: mermiler)
		{
			mermi.setMermiY(mermi.getMermiY()- mermiHareket);
		}
		
		for(Dusman dusman: dusmanlar)
		{
			dusman.setDusmanY(dusman.getDusmanY()+ dusmanHareket);
		}
		
		
		if ( 10 <dusmanOldurme && dusmanOldurme<21)
		{
			dusmanHareket = 2;
		}
		else if ( 20 <dusmanOldurme && dusmanOldurme <31)
		{
			dusmanHareket = 3;
		}
		else if ( 30 <dusmanOldurme && dusmanOldurme <41)
		{
			dusmanHareket = 4;
		}
		else if ( 40 <dusmanOldurme)
		{
			dusmanHareket = 5;
		}
		
		
		dusmanUretme++;
		
		if (dusmanUretme == 200)
		{
		rastgele = rand.nextInt(640) + 1;
		dusmanlar.add(new Dusman(rastgele, 0));
		dusmanUretme = 0;
		}
		
		
		
		
		
		repaint();
	}



	
	//-------------------------------------------------//

	@Override
	public void keyPressed(KeyEvent e) {
		
		
		int tus = e.getKeyCode();
		
		if (tus ==  KeyEvent.VK_LEFT)
		{
			
			
			if (tankX <= 0)
			{
				tankX=0;
			}
			else
			{
				tankX -= tankHareket;
			}
			
		}
		else if (tus == KeyEvent.VK_RIGHT)
		{
			
			
			if (tankX >= 640)
			{
				tankX=640;
			}
			else
			{
				tankX += tankHareket;	
			}
		}
		else if ( tus == KeyEvent.VK_CONTROL)
		{
			mermiler.add(new Mermi(tankX+21, 470));
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	
	
	
	
}
