package solutionAlgorthim;

public class Pokemon {

	// :)

	private int level;
	private int hp;
	private String name;
	private boolean poisoned;

	public Pokemon(String name, int level) {
		this.hp = 100;
		this.name = name;
		this.level = level;
		this.poisoned = false;
	}

	public void setHP(int newHP) {
		this.hp = newHP;
	}

	public void setPoisoned(boolean b) {
		this.poisoned = b;
	}

	public String getName() {
		return name;
	}

	public int getHP() {
		return hp;
	}

	public void iChooseYou() {
		System.out.println(name);
	}

	public void lapse() {
		if (poisoned)
			hp -= 15;
	}

	public void attack(Pokemon target, Attack attack) {
		if (Math.random() < .9) {
			attack.attack(target);
			System.out.println("The attack hit");
		} else {
			System.out.println("The attack missed");
		}
	}
}
