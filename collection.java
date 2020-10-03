import java.lang.Integer;

class collection{
	private String name;
	private questionInterface[] array;
	private int arrayBoxLen=0;
	private int arrayLen=0;
	private csvFileReader csv;
	
	//CSVファイルでの列の番号を示す
	private static final int QUESTION_TYPE=0;
	private static final int INPUTTYPE_QUESTIONSTR=1,INPUTTYPE_ANSWERSTR=2;
	private static final int CHOICE_QUESTIONSTR=1,CHOICE_ANSWERVAL=2,CHOICE_CHOICESTR=3;
	
	//配列を広げる
	private void expandArray(){
		arrayBoxLen+=10;//10ずつ増やす
		questionInterface[] newArray=new questionInterface[arrayBoxLen];
		for(int i=0;i<arrayLen;i++){
			newArray[i]=array[i];
		}
		array=newArray;
	}
	//文字列の配列の一部から、別の文字列の配列を作る
	private String[] genNewStringArray(String[] strs,int start,int end){
		String[] ret=new String[end-start];
		for(int i=0;i<ret.length;i++){
			ret[i]=new String(strs[i+start]);
		}
		return ret;
	}
	public collection(String name){
		this.name=name;
		csv=new csvFileReader();
	}
	//問題をコレクションに追加する
	public void add(questionInterface question){
		if(arrayBoxLen<=arrayLen){
			expandArray();
		}
		array[arrayLen]=question;
		arrayLen++;
	}
	//ファイルから問題をコレクションに追加する
	public void addFromFile(String filename){
		csv.open(filename);
		while(true){
			String[] strs=csv.next();
			if(strs.length==0){
				//要素なしの時、ファイルの最後なので終了
				return;
			}
			questionInterface question;
			switch(strs[QUESTION_TYPE]){
				case "InputType":
				question=new questionInputType(strs[INPUTTYPE_QUESTIONSTR],genNewStringArray(strs,INPUTTYPE_ANSWERSTR,strs.length));
				break;
				
				case "Choice":
				question=new questionChoice(strs[CHOICE_QUESTIONSTR],Integer.parseInt(strs[CHOICE_ANSWERVAL]),genNewStringArray(strs,CHOICE_CHOICESTR,strs.length));
				break;
				
				default:
				System.out.println(filename+"で不明な問題タイプ"+strs[QUESTION_TYPE]+"の読み込みをパスしました");
				continue;
			}
			add(question);
		}
	}
	
	//参照を返す(コピーでないことに注意)
	public questionInterface ref(int num){
		return array[num];
	}
	//長さを返す
	public int length(){
		return arrayLen;
	}
	public String toString(){
		return String.format("%s 問題数:%2d",name,arrayLen);
	}
	public String getName(){
		return name;
	}
}