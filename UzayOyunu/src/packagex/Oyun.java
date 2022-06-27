package packagex;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JPanel;

class Ates {
	private int x;
	private int y;
	public Ates(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
}
public class Oyun extends JPanel implements KeyListener,ActionListener{
	
Random random=new Random();
Timer timer = new Timer(3,this);
private int gecen_sure = 0;
private int harcanan_ates = 0;
private BufferedImage image;
private ArrayList<Ates> atesler = new ArrayList<Ates>();
private int atesdirY = 1;
private int hedefX= 0;
private int hedefY=0;
private int hedefdirX=2;
private int hedefdirY=3;
private int uzayGemisiX= 4;
private int dirUzayX=30;
public boolean kontrolEt() {
	for(Ates ates : atesler) {
	if(new Rectangle(ates.getX(),ates.getY(),2,7).intersects(new Rectangle(hedefX,0,15,15))) {
	
		return true;

	}
	
	if(new Rectangle(ates.getX(),ates.getY(),2,7).intersects(new Rectangle(hedefY,15,15,15))) {
	
	return true;
	}
	
	}
	
    return false;

    
}

	public Oyun() {
		try {
		image = ImageIO.read(new FileImageInputStream(new File("img/uzaygemisi.png")));
		
		
	}
	catch (IOException ex) {
		Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE,null,ex	);
	}
		
		
	setBackground(Color.black);
    
	timer.start();
	}

public void paint(Graphics g) {

super.paint(g);
gecen_sure+=3;

g.setColor(Color.magenta);

g.drawOval(hedefX, 0, 15, 15);
g.drawOval(hedefY, 15, 15, 15);

g.drawImage(image, uzayGemisiX, 507, image.getHeight()/7,image.getTileHeight()/7,this);

for(Ates ates : atesler) {
   	
	if (ates.getY()<0) {
		
		atesler.remove(ates);
	}
	
}
g.setColor(Color.red);
for(Ates ates : atesler) {
g.fillRect(ates.getX(), ates.getY(), 2, 7);	

}

if (kontrolEt())	 {
  timer.stop();

	  if(harcanan_ates<10) {
	   
	  
	  String message ="Kazandýnýz\n"+"Harcanan Ates :"+harcanan_ates+"Gecen Sure :"+gecen_sure/1000;
	 JOptionPane.showMessageDialog(this, message);
	
	 System.exit(0);
      
}
	  else{
			  
String message="Kaybettiniz\n"+"Harcanan Ates :"+harcanan_ates+"Gecen Sure :"+gecen_sure/1000;
JOptionPane.showMessageDialog(this, message);
System.exit(0);
		  
	  }

}


		 
	    



}

public void repaint() {
	super.repaint();
}
	

	public void actionPerformed(ActionEvent e) {
	
	for(Ates ates : atesler) {
		ates.setY(ates.getY() - atesdirY);
		
	}
		
	
		
	hedefX+=hedefdirX;
	hedefY+=hedefdirY;
	if(hedefX>=380) {
		
	hedefdirX=-hedefdirX;	
	}
	if(hedefY>=380) {
	hedefdirY=-hedefdirY;
	}
	if(hedefX<=0) {
		
	hedefdirX= -hedefdirX;	
	
	}
	if(hedefY<=0) {
		hedefdirY=-hedefdirY;
	}
	repaint();
	
	
	}


	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();	
		if(c==KeyEvent.VK_LEFT) {
		if(uzayGemisiX<=0) {
			
			uzayGemisiX=0;
		
		}
		else {
			uzayGemisiX -=dirUzayX;
	
	
		}
		
		}
		else if(c== KeyEvent.VK_RIGHT) {
			
			if(uzayGemisiX>=330) {
				
				uzayGemisiX=330;
			
			}
			else {
				
				uzayGemisiX +=dirUzayX;
			
			}
		
		}
		else if(c== KeyEvent.VK_CONTROL) {
			atesler.add(new Ates(uzayGemisiX+29,499));
	            
			harcanan_ates++;
		
			
		}
		
	
		}
		
	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	
	public void keyTyped(KeyEvent e) {
		
   
}
	
}
