import java.util.Random;
import java.util.Scanner;

public class workbook{
	private collection data;
	private int[] dataOrder;
	private static Scanner stdin=new Scanner(System.in);
	private static Random random=new Random();
	
	public workbook(collection c){
		data=c;
		dataOrder=new int[c.length()];
		initDataOrder();
	}
	//出題順を初期化する
	public void initDataOrder(){
		for(int i=0;i<data.length();i++){
			dataOrder[i]=i;
		}
	}
	//出題順をシャッフルする
	public void shuffleDataOrder(){
		final int SHUFFLE_TIMES=20;
		int orderA,orderB;
		for(int i=0;i<SHUFFLE_TIMES;i++){
			//入れ替える添え字をランダムに選ぶ
			orderA=random.nextInt(dataOrder.length);
			orderB=random.nextInt(dataOrder.length);
			//入れ替える
			final int temp=dataOrder[orderA];
			dataOrder[orderA]=dataOrder[orderB];
			dataOrder[orderB]=temp;
		}
	}
	//questionsはquestionを複数、出題する
	public void questions(){
		int correctCont=0;
		for(int i=0;i<data.length();i++){
			System.out.printf("番号 %2d/%2d  (現在の正解数 %2d)\n",i+1,data.length(),correctCont);
			if(data.ref(dataOrder[i]).question()){
				System.out.println("正解");
				correctCont++;
			}else{
				System.out.println("不正解");
			}
			System.out.println();
		}
		
		System.out.println("終了です");
		double correctRate;
		if(data.length()==0){
			correctRate=0.0;
		}else{
			correctRate=(((double)correctCont)/data.length())*100.0;
		}
		System.out.printf("正解数 %2d/%2d 正答率 %.2f%%\n",correctCont,data.length(),correctRate);
	}
	//問題の一覧を表示する
	public void printDataOrder(){
		System.out.println(data);
		for(int i=0;i<data.length();i++){
			System.out.printf("%2d. %s\n",i+1,data.ref(dataOrder[i]).getQuestionStr());
		}
		System.out.println();
	}
	//ワークブックの操作盤
	public void workbookUI(){
		while(true){
			System.out.println("現在のコレクション:"+data.getName());
			System.out.println(" 0: このワークブックを閉じる");
			System.out.println(" 1: 出題順を初期化する");
			System.out.println(" 2: 出題順をシャッフルする");
			System.out.println(" 3: 問題を解く");
			System.out.println(" 4: 問題の一覧を見る");
			
			int input;
			while(true){
				System.out.print("実行する番号を入力> ");
				input=stdin.nextInt();
				System.out.println();
				switch(input){
					case 0:
					return;
					
					case 1:
					initDataOrder();
					break;
					
					case 2:
					shuffleDataOrder();
					break;
					
					case 3:
					questions();
					break;
					
					case 4:
					printDataOrder();
					break;
					
					default:
					System.out.println("選択肢にない番号です");
					continue;
				}
				break;
			}
			
		}
	}
}