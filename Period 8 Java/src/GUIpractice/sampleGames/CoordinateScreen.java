package GUIpractice.sampleGames;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import GUIpractice.Screen;
import GUIpractice.components.Button;
import GUIpractice.components.Graphics;
import GUIpractice.components.MovingComponent;
import GUIpractice.components.TextLabel;
import GUIpractice.components.TextArea;
import GUIpractice.components.visible;

public class CoordinateScreen extends Screen implements MouseMotionListener, MouseListener{
	
	public CoordinateScreen(int width, int height) {
		super(width, height);
	}

	public void initObjects(ArrayList<visible> viewObjects) {
		//viewObjects.add(new TextArea(100, 100, 200, 100, "Hello C D DIOASDUA DIOASDUA DIOASDUA"));
	//	viewObjects.add(new Button(100, 150, 200, 100, "COOL", Color.black, null));
		
		Graphics picture = new Graphics(100,100,100,80,"resources/sampleImages/pic.jpg");
		viewObjects.add(picture);
		MovingComponent mc = new MovingComponent(30, 60, 80, 80);
		viewObjects.add(mc);
		mc.setY(3);;
		mc.play();
	}

	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void mouseMoved(MouseEvent m) {
		// TODO Auto-generated
	}

	public MouseMotionListener getMouseMotionListener(){
		return this;
	}
	
	public MouseListener getMouseListener(){
		return this;
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
	
}