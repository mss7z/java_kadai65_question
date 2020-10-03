import java.lang.Integer;

class collection{
	private String name;
	private questionInterface[] array;
	private int arrayBoxLen=0;
	private int arrayLen=0;
	private csvFileReader csv;
	
	//CSV�t�@�C���ł̗�̔ԍ�������
	private static final int QUESTION_TYPE=0;
	private static final int INPUTTYPE_QUESTIONSTR=1,INPUTTYPE_ANSWERSTR=2;
	private static final int CHOICE_QUESTIONSTR=1,CHOICE_ANSWERVAL=2,CHOICE_CHOICESTR=3;
	
	//�z����L����
	private void expandArray(){
		arrayBoxLen+=10;//10�����₷
		questionInterface[] newArray=new questionInterface[arrayBoxLen];
		for(int i=0;i<arrayLen;i++){
			newArray[i]=array[i];
		}
		array=newArray;
	}
	//������̔z��̈ꕔ����A�ʂ̕�����̔z������
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
	//�����R���N�V�����ɒǉ�����
	public void add(questionInterface question){
		if(arrayBoxLen<=arrayLen){
			expandArray();
		}
		array[arrayLen]=question;
		arrayLen++;
	}
	//�t�@�C����������R���N�V�����ɒǉ�����
	public void addFromFile(String filename){
		csv.open(filename);
		while(true){
			String[] strs=csv.next();
			if(strs.length==0){
				//�v�f�Ȃ��̎��A�t�@�C���̍Ō�Ȃ̂ŏI��
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
				System.out.println(filename+"�ŕs���Ȗ��^�C�v"+strs[QUESTION_TYPE]+"�̓ǂݍ��݂��p�X���܂���");
				continue;
			}
			add(question);
		}
	}
	
	//�Q�Ƃ�Ԃ�(�R�s�[�łȂ����Ƃɒ���)
	public questionInterface ref(int num){
		return array[num];
	}
	//������Ԃ�
	public int length(){
		return arrayLen;
	}
	public String toString(){
		return String.format("%s ��萔:%2d",name,arrayLen);
	}
	public String getName(){
		return name;
	}
}