package whackamolekev;

import GUIpractice.GUIApplication;

public class WhackAMoleGame extends GUIApplication {

	public WhackAMoleGame() {
	}

	public static void main(String[] args) {
		WhackAMoleGame game = new WhackAMoleGame();
		Thread thr = new Thread(game);
		thr.start();
	}

	@Override
	protected void initScreen() {
		WhackAMoleScreen game = new WhackAMoleScreen(getWidth(), getHeight());
		setScreen(game);
	
		Thread play = new Thread(game);
		play.start();
	}

}
