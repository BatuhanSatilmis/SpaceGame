package packagex;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JPanel;



public class OyunEkrani extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;




	public OyunEkrani(String arg0) throws HeadlessException {
		super(arg0);
	
       

	}
   
	
	
	
  public static void main(String[] args) {
  

	 OyunEkrani ekran = new OyunEkrani("Uzay Oyunu");

 	
  ekran.setResizable(false);
  ekran.setFocusable(false);
  ekran.setSize(400,600);
  ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  Oyun oyun = new Oyun();
 
  oyun.requestFocus();
  oyun.addKeyListener(oyun);
  oyun.setFocusable(true);
  oyun.setFocusTraversalKeysEnabled(false);
  ekran.add(oyun);
  ekran.setVisible(true);
  
  
  }

	

}
