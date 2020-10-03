import java.util.Scanner;

public class questionChoice implements questionInterface{
	private String questionStr;
	private String[] choiceStr;
	private int answerVal;
	private static Scanner stdin=new Scanner(System.in);
	
	//�I����̎��Ɏg��
	public questionChoice(String question,int answer,String[] choice){
		questionStr=question;
		choiceStr=choice;
		answerVal=answer;
	}
	
	@Override
	public boolean question(){
		System.out.println("���:"+questionStr);
		
		//�I������\��
		for(int i=0;i<choiceStr.length;i++){
			System.out.printf("%2d: %s\n",i+1,choiceStr[i]);
		}
		
		int input;
		while(true){
			System.out.print("�I�����̔ԍ������> ");
			input=stdin.nextInt();
			System.out.println();
			if(1<=input && input<=choiceStr.length+1){
				break;
			}
			System.out.println("�I�����ɂȂ��ԍ��ł�");
		}
		
		return input==answerVal;
	}
	
	@Override
	public String getQuestionStr(){
		return questionStr;
	}
	
	public String toString(){
		return String.format("���:%s",getQuestionStr());
	}
}