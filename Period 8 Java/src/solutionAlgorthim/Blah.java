package solutionAlgorthim;

public class Blah {

	public static void print(boolean[][] arr) {
		for (boolean[] row : arr) {
			for (boolean col : row) {
				System.out.print(col ? "O" : "X");
			}
			System.out.println();
		}
	}
}