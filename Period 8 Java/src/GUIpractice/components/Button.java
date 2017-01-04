package GUIpractice.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Button extends TextLabel implements Clickable, MouseListener{

	private Color color;
	private Action action;

	public Button(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text);
		this.color = color;
		this.action = action;
		update();
	}
	
	public Color getColor(){
		return color;
	}
	
	public void setColor(Color c){
		color = c;
		update();
	}
	
	@Override
	public void update(Graphics2D g) {
		g = clear();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(color);
		g.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 35);
		g.setColor(Color.black);
		g.drawRoundRect(0, 0,getWidth()-1, getHeight()-1, 25, 35);
		if (getText() != null) {
			g.setColor(Color.black);
			g.setFont(new Font(getFont(), Font.PLAIN, getSize()));
			g.drawString(getText(), getWidth() / 2, getHeight() / 2);
		}
	}
	
	@Override
	public boolean isHovered(int x, int y){
		return x > getX() && x<getX() + getWidth() && y > getY() && y <getY() + getHeight();	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void act() {
		action.act();
	}
	
}