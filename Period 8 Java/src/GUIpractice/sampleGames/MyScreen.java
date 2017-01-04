package GUIpractice.sampleGames;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import GUIpractice.Screen;
import GUIpractice.components.Action;
import GUIpractice.components.Button;
import GUIpractice.components.Clickable;
import GUIpractice.components.ClickableGraphic;
import GUIpractice.components.Graphics;
import GUIpractice.components.MouseCoordinateGame;
import GUIpractice.components.visible;

public class MyScreen extends Screen implements MouseListener {

	private Button back;
	private ClickableGraphic click;

	public MyScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initObjects(ArrayList<visible> viewObjects) {
		back = new Button(50, 50, 100, 60, "Back", Color.GRAY, new Action() {

			public void act() {
				MouseCoordinateGame.game.setScreen(MouseCoordinateGame.coordScreen);
			}
		});
		
		viewObjects.add(back);
		
		click = new ClickableGraphic(200, 200, 100, 100, "resources/sampleImages/pic.jpg");
		
		
		click.setAction(new Action() {
			public void act() {
				click.setX(click.getX() + 10);
			}
		});
		
		
		
		
		viewObjects.add(click);
	}

	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mouseMoved(MouseEvent arg0) {

	}

	public void mouseClicked(MouseEvent e) {
		if (back.isHovered(e.getX(), e.getY())) {
			back.act();
		}

		if (click.isHovered(e.getX(), e.getY())) {
			click.act();
		}
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public MouseListener getMouseListener() {
		return this;
	}

}