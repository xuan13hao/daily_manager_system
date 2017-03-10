package com.ccit.uimytool;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	
		public MyPanel(){}

		@Override
		protected void paintComponent(Graphics g) {
			BufferedImage bfimg=null;
			try {
				bfimg=ImageIO.read(this.getClass().getResource("/com/ccit/img/login_mark.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(bfimg, 0, 0, null);
		}
		

}
