import java.util.Scanner;

public class questionChoice implements questionInterface{
	private String questionStr;
	private String[] choiceStr;
	private int answerVal;
	private static Scanner stdin=new Scanner(System.in);
	
	//選択問題の時に使う
	public questionChoice(String question,int answer,String[] choice){
		questionStr=question;
		choiceStr=choice;
		answerVal=answer;
	}
	
	@Override
	public boolean question(){
		System.out.println("問題:"+questionStr);
		
		//選択肢を表示
		for(int i=0;i<choiceStr.length;i++){
			System.out.printf("%2d: %s\n",i+1,choiceStr[i]);
		}
		
		int input;
		while(true){
			System.out.print("選択肢の番号を入力> ");
			input=stdin.nextInt();
			System.out.println();
			if(1<=input && input<=choiceStr.length+1){
				break;
			}
			System.out.println("選択肢にない番号です");
		}
		
		return input==answerVal;
	}
	
	@Override
	public String getQuestionStr(){
		return questionStr;
	}
	
	public String toString(){
		return String.format("問題:%s",getQuestionStr());
	}
}