package GUIpractice;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.beans.Visibility;
import java.util.ArrayList;

import GUIpractice.components.visible;

public abstract class Screen {

	private int width;
	private int height;
	private ArrayList<visible> viewObjects;

	protected BufferedImage image;

	public Screen(int width, int height) {
		viewObjects = new ArrayList<visible>();
		this.width = width;
		this.height = height;
		initObjects(viewObjects);
		initImage();
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public abstract void initObjects(ArrayList<visible> viewObjects);

	private void initImage() {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		update();
	}

	public void update() {
		// this is where you draw stuff
		Graphics2D g = image.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.fillRect(0, 0, image.getWidth(), image.getHeight());
		g.setColor(Color.black);
		// draw all visible components
		for (int i = 0; i < viewObjects.size(); i++) {
			visible v = viewObjects.get(i);
			g.drawImage(v.getImage(), v.getX(), v.getY(), null);
		}
		// g.setFont(new Font("Helvetica", Font.PLAIN, 20));
		// g.drawString("Hello", 40, 80);
		// g.drawOval(0, 40, 120, 80);
		// g.drawRect(20, 120, 80, 110);
		// g.drawLine(100, 120, 110, 200);
		//
		// g.setColor(Color.green);
		// for(int i = 0; i < image.getWidth(); i+=2){
		// g.drawLine(i, 230, i, 238);
		// }
		//
		// g.drawOval(150, 100, 100, 100);
	}

	public void remove(visible v){
		//remove a visible from the screen
		//ArrayList notes
		//While this method is very simple, do not underestimate the trickiness of moving items in an array list.  It causes indices to change
		//example suppose you have an ArrayList<integer> and you want to remove all values greater than 5.  THIS IS BAD
		//for(int i = 0; i < list.size(); i++){
		//	if(list.get(i) > 5) list.remove(i);
		//}
		//suppose you have (4,5,6,7)
		//the first integer to be removed is 6, at index 2
		//since it gets removed, 7 moves from index 3 to 2.
		//your list is now (4,5,7)
		//after you increment i, i becomes 3.
		// This is out of bounds so 7 never gets removed
		//Instead when an object is removed, decrease i to compensate change in size
		//CORRECT
		//for(int i = 0; i < list.size(); i++){
		//	if(list.get(i) > 5){ 
		//	list.remove(i);
		//	i--;
		//	}
		//}
		//Also CORRECT
		//for(int i = 0; i < list.size(); i++){
		//	while(i < list.size() && list.get(i) > 5) list.remove(i);
		//}
		//for this reason, the following doesn't even work!
		//Because remove changes the size
		//for(Integer i: list){
		//	if(i > 5)list.remove(i);
		//}
		//FINALLY if you remove using an index, it returns the removed object,
		//so you can do this:
		//System.out.println(list.remove(0).toString() + " was removed.");
		viewObjects.remove(v);
		//this removes the object that has the same identity as v, not an object that is equal to v
	}

	public void moveToFront(visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);
			viewObjects.add(v);
			
		}
	}
	
	public void moveToBack(visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);
			viewObjects.add(0, v);
			//movers all objects with index >= n forward by 1, increase size by 1 adds object to index n
		}
	}
	
	public BufferedImage getImage() {
		return image;
	}

	public MouseListener getMouseListener() {
		return null;
	}

	public MouseMotionListener getMouseMotionListener() {
		return null;
	}

	public void addObject(visible v) {
		viewObjects.add(v);
	}

}
