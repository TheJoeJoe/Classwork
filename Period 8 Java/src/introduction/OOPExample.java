package introduction;

public class OOPExample {
	
	public static void main(String[] args){
		Student jillian = new Senior("Jillian", "programmer"); 
		Student jason = new Junior("Jason", "Harvard");
		Student joseph = new Student("Joseph");
		((Student) jillian).talk();
		jason.talk();
		joseph.talk();
	}
}
