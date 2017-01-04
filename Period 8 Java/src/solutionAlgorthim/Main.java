package solutionAlgorthim;

public class Main {

	public static void main(String[] args) {
		Pokemon raticate = new Pokemon("Raticate", 26);
		Pokemon bulbasaur = new Pokemon("Bulbasaur", 26);
		
		raticate.iChooseYou();
		bulbasaur.iChooseYou();
		
		System.out.println("Raticate is preparing to attack with super fang");
		raticate.attack(bulbasaur, new Attack() {
			
			//cuts health(hp) in half
			public void attack(Pokemon target) {
				int newHP = target.getHP()/2;
				target.setHP(newHP);
			}
		});
		
		bulbasaur.attack(raticate, new Attack() {
			
			//poisons the target
			public void attack(Pokemon target) {
				target.setPoisoned(true);
			}

		});

		raticate.lapse();
		bulbasaur.lapse();
		printScore(raticate, bulbasaur);
	}

	private static void printScore(Pokemon p1, Pokemon p2) {
		System.out.println(p1.getName()+". HP = "+p1.getHP());
		System.out.println(p2.getName()+". HP = "+p2.getHP());
	}
	
}
