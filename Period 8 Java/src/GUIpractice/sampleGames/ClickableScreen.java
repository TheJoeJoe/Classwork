package GUIpractice.sampleGames;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.Visibility;
import java.util.ArrayList;
import java.util.List;

import GUIpractice.Screen;
import GUIpractice.components.Button;
import GUIpractice.components.Clickable;
import GUIpractice.components.visible;

public abstract class ClickableScreen extends Screen implements MouseListener {

	private ArrayList<Clickable> clickables;

	public ClickableScreen(int width, int height) {
		super(width, height);

	}

	public abstract void initAllObjects(List<visible> viewObjects);

	@Override
	public void mouseClicked(MouseEvent e) {
		for (int i = 0; i < clickables.size(); i++) {
			Clickable c = clickables.get(i);
			if (c.isHovered(e.getX(), e.getY())) {
				c.act();
				break;
			}
		}
	}

	@Override
	public void addObject(visible v) {
		super.addObject(v);

		if (v instanceof Clickable) {
			clickables.add((Clickable) v);
		}
	}

	public void remove(visible v) {
		super.remove(v);
		clickables.remove(v);
	}

	@Override
	public void mousePressed(MouseEvent e) {

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
	public void initObjects(ArrayList<visible> viewObjects) {
		initAllObjects(viewObjects);
		clickables = new ArrayList<Clickable>();
		for(visible v: viewObjects){
			if(v instanceof Clickable){
				clickables.add((Clickable)v);
			}
		}
	}

	@Override
	public MouseListener getMouseListener() {
		return this;
	}
}
