package simon;

import java.util.ArrayList;
import java.util.List;

import GUIpractice.components.TextLabel;
import GUIpractice.components.visible;
import GUIpractice.sampleGames.ClickableScreen;
import whackAMole.MoleInterface;

public class SimonScreenJoseph extends ClickableScreen implements Runnable {

	private TextLabel text;
	private ButtonInterfaceJoseph button;
	private ProgressInterfaceJoseph progress;
	private ArrayList<MoveInterface> move;
	int roundNumber;
	boolean acceptingInput;
	int sequenceIndex;
	int lastSelectedButton;
	
	public SimonScreenJoseph(int width, int height) {
		super(width, height);
		Thread play = new Thread(this);
		play.start();	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
 
	}
 
	@Override
	public void initAllObjects(List<visible> viewObjects) {
		// TODO Auto-generated method stub

	}

}
