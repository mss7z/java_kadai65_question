import java.util.Scanner;

public class collectionManager{
	private static final String COLLECTION_FILE_LIST="collectionList.csv";
	private collection[] array;
	private int arrayBoxLen=0;
	private int arrayLen=0;
	private csvFileReader csv;
	private static Scanner stdin=new Scanner(System.in);
	
	//CSVファイルでの列の番号を示す
	private static final int COLLECTION_NAME=0,COLLECTION_FILENAME=1;
	
	//配列を広げる
	private void expandArray(){
		arrayBoxLen+=5;//5ずつ増やす
		collection[] newArray=new collection[arrayBoxLen];
		for(int i=0;i<arrayLen;i++){
			newArray[i]=array[i];
		}
		array=newArray;
	}
	//配列にコレクション「を」追加する
	private void add(String name,String file){
		if(arrayBoxLen<=arrayLen){
			expandArray();
		}
		array[arrayLen]=new collection(name);
		array[arrayLen].addFromFile(file);
		arrayLen++;
	}
	//配列を初期化する（ファイルの中身をメモリに移す）
	private void initArray(){
		csv.open(COLLECTION_FILE_LIST);
		while(true){
			String[] strs=csv.next();
			if(strs.length==0){
				//要素なしの時、ファイルの最後なので終了
				return;
			}
			add(strs[COLLECTION_NAME],strs[COLLECTION_FILENAME]);
		}
	}
	
	public collectionManager(){
		csv=new csvFileReader();
		initArray();
	}
	//コレクションを選択し、そのコレクションの参照を返す
	public collection userChoiceCollection(){
		//読み込まれたコレクションを表示
		System.out.println("現在利用可能なコレクションの一覧");
		System.out.println(" 0: 終了する");
		for(int i=0;i<arrayLen;i++){
			System.out.printf("%2d: %20s\n",i+1,array[i]);
		}
		int input;
		while(true){
			System.out.print("コレクションの番号を入力> ");
			input=stdin.nextInt();
			System.out.println();
			if(input==0){
				return null;
			}
			if(1<=input && input<=arrayLen){
				break;
			}
			System.out.println("存在しないコレクションです");
		}
		return array[input-1];
	}
}