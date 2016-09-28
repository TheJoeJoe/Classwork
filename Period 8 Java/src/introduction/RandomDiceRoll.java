package introduction;

public class RandomDiceRoll {
	
	public static void main(String[]args) {
		System.out.println(rollUnfairDie());
	}
	
	// sexy clean unfairdie method dank memes 420 blaze that stuff
	public static int rollUnfairDie() {
		final int[] blah = {1, 2, 3, 4, 4, 4, 4, 5, 6};
		double num = Math.random();
		return blah[(int) (num * blah.length)];
	}
}
