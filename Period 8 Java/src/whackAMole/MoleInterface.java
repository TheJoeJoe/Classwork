package whackAMole;

import GUIpractice.components.Action;
import GUIpractice.components.Clickable;

public interface MoleInterface extends Clickable {

	double getAppearanceTime();

	void setAppearanceTime(double d);

	void setAction(Action action);

}
