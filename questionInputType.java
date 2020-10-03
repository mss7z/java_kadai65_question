import java.util.Scanner;

public class questionInputType implements questionInterface{
	private String questionStr;
	private String[] answerStr;
	private static Scanner stdin=new Scanner(System.in);
	
	//�������P�̎�
	public questionInputType(String question,String answer){
		questionStr=question;
		String[] answerArray={new String(answer)};
		answerStr=answerArray;
	}
	//��������������Ƃ�
	public questionInputType(String question,String[] answers){
		questionStr=question;
		answerStr=answers;
	}
	
	@Override
	public boolean question(){
		System.out.println("���:"+questionStr);
		
		System.out.print("�񓚂̕���������> ");
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
		return String.format("���:%s",getQuestionStr());
	}
}