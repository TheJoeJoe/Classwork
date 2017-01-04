package aligame;

import GUIpractice.GUIApplication;

public class AliGame extends GUIApplication{
	
	public static void main(String args[]){
		GUIApplication game = new AliGame();
		Thread app = new Thread(game);
		app.start();
	}
	
	@Override
	protected void initScreen() {
	}
 	
}
