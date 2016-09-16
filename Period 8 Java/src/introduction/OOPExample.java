package introduction;

public class OOPExample {
	
	public static void main(String[] args){
		Student jillian = new Senior("Jillian"); 
		Student jason = new Juniors("Jason", "Harvard");
		Student joseph = new Student("Joseph");
		jillian.talk();
		jason.talk();
		joseph.talk();
	}
}
