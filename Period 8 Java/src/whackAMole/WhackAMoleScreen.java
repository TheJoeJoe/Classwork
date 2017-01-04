package whackAMole;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import GUIpractice.components.Action;
import GUIpractice.components.Button;
import GUIpractice.components.TextLabel;
import GUIpractice.components.visible;
import GUIpractice.sampleGames.ClickableScreen;

public class WhackAMoleScreen extends ClickableScreen implements Runnable{
	
	private Button button;
	private ArrayList<MoleInterface> moles;
	private PlayerInterface player;
	private TextLabel label;
	private TextLabel timeLabel;
	private double timeLeft;
	

	public WhackAMoleScreen(int width, int height) {
		super(width, height);
	}
	
	private void changeText(String s) {
		try{
			label.setText(s);
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	@Override
	public void initAllObjects(List<visible> viewObjects) {
		button = new Button(0, 0, 50, 50, "DON'T CLICK ME", Color.RED, new Action() {

			@Override
			public void act() {
				button.setX((int) (Math.random() * (getWidth() - button.getWidth())));
				button.setY((int) (Math.random() * (getHeight() - button.getHeight())));
			}
			
		});
		
		//addObject(button);
		moles = new ArrayList<MoleInterface>();
		player = getAPlayer();
		label = new TextLabel(getWidth()/2-60, getHeight()/2-30, 120, 60, "Ready...");
		timeLabel = new TextLabel(getWidth()/2-60,50, 120, 60, "");
		viewObjects.add(label);
		viewObjects.add(player);
		viewObjects.add(timeLabel);
	}

	public void update(){
		super.update();
	}
	
	
	public void run() {
		changeText("Set . . .");
		changeText("GO!");
		changeText("");
		timeLabel.setText("" + timeLeft);
		while(timeLeft > 0){
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			timeLeft -= .1;
			timeLabel.setText("" + (int)(timeLeft*10)/10.0);
			disappearMoles();
			addNewMoles();
		}
	}
	
	private void addNewMoles() {
		//probability of mole appearing depends on time left
		double probability = .2 + .1 * (30.0 - timeLeft)/30;
		if(Math.random()< probability){
			final MoleInterface mole = getAMole();
			//between .5 and 2.5 seconds
			mole.setAppearanceTime((int) (500+ Math.random() * 2000));
			mole.setAction(new Action(){
				public void act(){
					player.increaseScore(1);
					//removeMole from viewObjects
					remove(mole);
					//remove mole from database
					moles.remove(mole);
				}
			});
			//add mole to visible
			addObject(mole);
			//add mole to mole list
			moles.add(mole);
		}
	}

	private void disappearMoles() {
		//each mole has  clock, when the clock counts down to 0 it disappears
		for(int i = 0; i < moles.size(); i++){
			MoleInterface m = moles.get(i);
			m.setAppearanceTime(m.getAppearanceTime()-100);
			if(m.getAppearanceTime() <= 0){
				//remove from viewObjects
				remove(m);
				//remove it from our mole database
				moles.remove(i);
				i--;//compensate for i++
			}
		}		
	}

	/**
	 * this is a placeholder because early in the game design process,
	 * the players aren't designed yet, so we use this method later,
	 * once we learn how to create a player
	 * @return
	 */
	private PlayerInterface getAPlayer() {
		return new Player(20,20);
	}
	
	private MoleInterface getAMole() {
		return new Mole((int)(getWidth()*Math.random())-100, (int)(getHeight()*Math.random()));
	}
}
