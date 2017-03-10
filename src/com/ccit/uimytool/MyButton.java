package com.ccit.uimytool;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class MyButton extends JButton{
	private int states;			//通过类型来构建按钮
	private String path;		//通
	public MyButton(){}
	public MyButton(int states,String path)
	{
		super(String.valueOf(states));
		this.path=path;
	}
	private static final long serialVersionUID = 1L;
	@Override
	protected void paintComponent(Graphics g) {
		BufferedImage imag=null;
		try {
			imag=ImageIO.read(MyButton.class.getResource(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(imag, 0,0,null);
		
	}

	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(32,32);
	}
	

}
