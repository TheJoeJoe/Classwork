package introduction;

public class Juniors extends Student {
	
	String wantedCollege; 
	
	public Juniors(String name, String college) {
		super(name);
		this.wantedCollege = college;
	}

	public void talk(){
		super.talk();
		System.out.println("I am a Junior");
	}
}
