package ChatBox;

public class JosephSchool implements ChatBot{

	private boolean inSchoolLoop;
	public String schoolResponse;
	
	public void talk() {
		inSchoolLoop = true;
		while(inSchoolLoop){
			JosephMain.print("(Type 'quit' to go back.);");
			//static call on promptINput method from JosephsMain class
			schoolResponse = JosephMain.promptInput();
			if(schoolResponse.indexOf("quit") >= 0){
				inSchoolLoop = false;
				JosephMain.talkForever();//////////////////////
			}
			if(JosephMain.school.isTriggered(schoolResponse)){
				inSchoolLoop = false;
				JosephMain.school.talk();
			}
			JosephMain.print("That's my favorite part about school too.");
		}
	}

	@Override
	public boolean isTriggered(String userInput) {
		if(JosephMain.findKeyword(userInput,  "school",  0) >= 0){
			return true;	
		}
		if(JosephMain.findKeyword(userInput,  "class",  0) >= 0){
			return true;	
		}
		return false;
	}

}