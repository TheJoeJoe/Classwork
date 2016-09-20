package introduction;

public class Junior extends Student {
	
	String wantedCollege; 
	
	public Junior(String name, String college) {
		super(name);
		this.wantedCollege = college;
	}

	public void talk(){
		super.talk();
		System.out.println("I am a Junior");
	}
}
