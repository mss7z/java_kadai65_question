import java.util.Scanner;

public class questionInputType implements questionInterface{
	private String questionStr;
	private String[] answerStr;
	private static Scanner stdin=new Scanner(System.in);
	
	//³‰ð‚ª‚P‚Â‚ÌŽž
	public questionInputType(String question,String answer){
		questionStr=question;
		String[] answerArray={new String(answer)};
		answerStr=answerArray;
	}
	//³‰ð‚ª•¡”‚ ‚é‚Æ‚«
	public questionInputType(String question,String[] answers){
		questionStr=question;
		answerStr=answers;
	}
	
	@Override
	public boolean question(){
		System.out.println("–â‘è:"+questionStr);
		
		System.out.print("‰ñ“š‚Ì•¶Žš—ñ‚ð“ü—Í> ");
		String input=stdin.next();
		System.out.println();
		for(String s:answerStr){
			if(input.equals(s)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String getQuestionStr(){
		return questionStr;
	}
	
	public String toString(){
		return String.format("–â‘è:%s",getQuestionStr());
	}
}