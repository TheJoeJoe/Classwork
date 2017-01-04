package whackamolekev;

import GUIpractice.components.Action;
import GUIpractice.components.Clickable;

public interface MoleInterface extends Clickable {

	public int getAppearanceTime();

	public void setAppearanceTime(int screenTime);
	
	public void setAction(Action action);

}
