package ChatBox;

public class JosephHello implements ChatBot{
	private String helloResponse;
	private boolean inHelloLoop;
	
	private String[] calmResponses =
		{"we already said hello.  " + "Lets move the conversation along."};
	private String[] angryResponses=
		{"Okay seriously. Stop Saying Hi"};
	private int helloCount;
	
	public void talk() {
		inHelloLoop = true;
		while(inHelloLoop){
			helloCount ++;
			printResponse();//helper method
			helloResponse = JosephMain.promptInput();//negate use 
			if(!isTriggered(helloResponse)){
				inHelloLoop = false;
				JosephMain.talkForever();
			}
		}
	}
	
	private void printResponse() {
		if(helloCount > 4){
			int responseSelection = (int)(Math.random()*angryResponses.length);
			JosephMain.print(angryResponses[responseSelection]);
		}
		else{
			int responseSelection = (int)(Math.random()*calmResponses.length);
			JosephMain.print(calmResponses[responseSelection]);
		}
	}

	public boolean isTriggered(String userInput) {
		if(JosephMain.findKeyword(userInput,  "hello,", 0) >= 0){
			return true;
		}
		if(JosephMain.findKeyword(userInput,  "hi,", 0) >= 0){
			return true;
		}
		if(JosephMain.findKeyword(userInput,  "hey,", 0) >= 0){
			return true;
		}	
		return false;
	}
}
