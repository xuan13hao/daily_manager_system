package com.ccit.uimytool;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyLink extends JLabel implements MouseListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isEnter = false;
	public MyLink(String title)
	{
		super(title);
		this.addMouseListener(this);
	}
	
	
	
	@Override
	protected void paintBorder(Graphics g)
	{
		int w = this.getSize().width; 
        int h = this.getSize().height; 
		if(isEnter)
			g.drawLine(0, h - 1, w - 1, h - 1); 
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		String str = (String) e.getSource();
		new JFrame("dddd");
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		isEnter = true;
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));//鼠标变成手型
		this.setForeground(Color.CYAN);
		this.repaint();
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		isEnter = false;
		this.setForeground(Color.GRAY);
		this.repaint();
	}
}
