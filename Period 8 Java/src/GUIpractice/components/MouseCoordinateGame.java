package GUIpractice.components;

import GUIpractice.GUIApplication;
import GUIpractice.sampleGames.CoordinateScreen;
import GUIpractice.sampleGames.MyScreen;

public class MouseCoordinateGame extends GUIApplication {

	public static MouseCoordinateGame game;
	public static MyScreen myScreen;
	public static CoordinateScreen coordScreen;


	public static void main(String[] args){
		game = new MouseCoordinateGame();
		Thread app = new Thread(game);
		app.start();
	}

	@Override
	protected void initScreen() {
		myScreen = new MyScreen(getWidth(), getHeight());
		coordScreen = new CoordinateScreen(getWidth(), getHeight());
		setScreen(myScreen);
	}
}