package whackamolekev;

import java.util.ArrayList;
import java.util.List;

import GUIpractice.components.Action;
import GUIpractice.components.TextLabel;
import GUIpractice.components.visible;
import GUIpractice.sampleGames.ClickableScreen;

public class WhackAMoleScreen extends ClickableScreen implements Runnable {
	private ArrayList<MoleInterface> moles;
	private PlayerInterface player;
	private TextLabel label;
	private TextLabel timeLabel;
	private double timeLeft;

	public WhackAMoleScreen(int width, int height) {
		super(width, height);

		timeLeft = 30.0;
	}

	@Override
	public void initAllObjects(List<visible> viewObjects) {
		moles = new ArrayList<MoleInterface>();
		player = getPlayer();
		label = new TextLabel(350, 220, 100, 40, "Sample Text");
		timeLabel = new TextLabel(360, 40, 80, 40, "30.0");

		viewObjects.add(label);
		viewObjects.add(timeLabel);
	}

	public PlayerInterface getPlayer() {
		return null;
	}

	public MoleInterface getMole() {
		return null;
	}

	@Override
	public void run() {
		changeText("Ready...");
		changeText("Set...");
		changeText("Go...");
		label.setText("");

		while (timeLeft > 0) {
			updateTimer();
			updateAllMoles();
		}
	}

	private void updateTimer() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		timeLeft -= .1;
		timeLabel.setText(String.valueOf((timeLeft * 10 / 10.0)));
	}

	public void appearNewMole() {
		double chance = .1 * (60 - timeLeft) / 60;
		if (Math.random() < chance) {
			final MoleInterface mole = getMole();
			mole.setAppearanceTime((int) (500 + Math.random() * 2000));

			mole.setAction(new Action() {

				public void act() {
					player.increaseScore(1);
					remove(mole);
					moles.remove(mole);
				}

			});
			
			addObject(mole);
			moles.add(mole);
		}
	}

	private void updateAllMoles() {
		for (int i = 0; i < moles.size(); i++) {
			MoleInterface m = moles.get(i);
			int screenTime = m.getAppearanceTime() - 100;
			m.setAppearanceTime(screenTime);

			if (m.getAppearanceTime() <= 0) {
				remove(m);
				moles.remove(m);

				i--;
			}
		}
	}

	public void changeText(String str) {
		label.setText(str);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
