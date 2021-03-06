import java.util.Scanner;

public class questionInputType implements questionInterface{
	private String questionStr;
	private String[] answerStr;
	private static Scanner stdin=new Scanner(System.in);
	
	//正解が１つの時
	public questionInputType(String question,String answer){
		questionStr=question;
		String[] answerArray={new String(answer)};
		answerStr=answerArray;
	}
	//正解が複数あるとき
	public questionInputType(String question,String[] answers){
		questionStr=question;
		answerStr=answers;
	}
	
	@Override
	public boolean question(){
		System.out.println("問題:"+questionStr);
		
		System.out.print("回答の文字列を入力> ");
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
		return String.format("問題:%s",getQuestionStr());
	}
}