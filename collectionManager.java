import java.util.Scanner;

public class collectionManager{
	private static final String COLLECTION_FILE_LIST="collectionList.csv";
	private collection[] array;
	private int arrayBoxLen=0;
	private int arrayLen=0;
	private csvFileReader csv;
	private static Scanner stdin=new Scanner(System.in);
	
	//CSV�t�@�C���ł̗�̔ԍ�������
	private static final int COLLECTION_NAME=0,COLLECTION_FILENAME=1;
	
	//�z����L����
	private void expandArray(){
		arrayBoxLen+=5;//5�����₷
		collection[] newArray=new collection[arrayBoxLen];
		for(int i=0;i<arrayLen;i++){
			newArray[i]=array[i];
		}
		array=newArray;
	}
	//�z��ɃR���N�V�����u���v�ǉ�����
	private void add(String name,String file){
		if(arrayBoxLen<=arrayLen){
			expandArray();
		}
		array[arrayLen]=new collection(name);
		array[arrayLen].addFromFile(file);
		arrayLen++;
	}
	//�z�������������i�t�@�C���̒��g���������Ɉڂ��j
	private void initArray(){
		csv.open(COLLECTION_FILE_LIST);
		while(true){
			String[] strs=csv.next();
			if(strs.length==0){
				//�v�f�Ȃ��̎��A�t�@�C���̍Ō�Ȃ̂ŏI��
				return;
			}
			add(strs[COLLECTION_NAME],strs[COLLECTION_FILENAME]);
		}
	}
	
	public collectionManager(){
		csv=new csvFileReader();
		initArray();
	}
	//�R���N�V������I�����A���̃R���N�V�����̎Q�Ƃ�Ԃ�
	public collection userChoiceCollection(){
		//�ǂݍ��܂ꂽ�R���N�V������\��
		System.out.println("���ݗ��p�\�ȃR���N�V�����̈ꗗ");
		System.out.println(" 0: �I������");
		for(int i=0;i<arrayLen;i++){
			System.out.printf("%2d: %20s\n",i+1,array[i]);
		}
		int input;
		while(true){
			System.out.print("�R���N�V�����̔ԍ������> ");
			input=stdin.nextInt();
			System.out.println();
			if(input==0){
				return null;
			}
			if(1<=input && input<=arrayLen){
				break;
			}
			System.out.println("���݂��Ȃ��R���N�V�����ł�");
		}
		return array[input-1];
	}
}