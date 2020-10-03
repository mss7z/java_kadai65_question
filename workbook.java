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
	//�o�菇������������
	public void initDataOrder(){
		for(int i=0;i<data.length();i++){
			dataOrder[i]=i;
		}
	}
	//�o�菇���V���b�t������
	public void shuffleDataOrder(){
		final int SHUFFLE_TIMES=20;
		int orderA,orderB;
		for(int i=0;i<SHUFFLE_TIMES;i++){
			//����ւ���Y�����������_���ɑI��
			orderA=random.nextInt(dataOrder.length);
			orderB=random.nextInt(dataOrder.length);
			//����ւ���
			final int temp=dataOrder[orderA];
			dataOrder[orderA]=dataOrder[orderB];
			dataOrder[orderB]=temp;
		}
	}
	//questions��question�𕡐��A�o�肷��
	public void questions(){
		int correctCont=0;
		for(int i=0;i<data.length();i++){
			System.out.printf("�ԍ� %2d/%2d  (���݂̐��� %2d)\n",i+1,data.length(),correctCont);
			if(data.ref(dataOrder[i]).question()){
				System.out.println("����");
				correctCont++;
			}else{
				System.out.println("�s����");
			}
			System.out.println();
		}
		
		System.out.println("�I���ł�");
		double correctRate;
		if(data.length()==0){
			correctRate=0.0;
		}else{
			correctRate=(((double)correctCont)/data.length())*100.0;
		}
		System.out.printf("���� %2d/%2d ������ %.2f%%\n",correctCont,data.length(),correctRate);
	}
	//���̈ꗗ��\������
	public void printDataOrder(){
		System.out.println(data);
		for(int i=0;i<data.length();i++){
			System.out.printf("%2d. %s\n",i+1,data.ref(dataOrder[i]).getQuestionStr());
		}
		System.out.println();
	}
	//���[�N�u�b�N�̑����
	public void workbookUI(){
		while(true){
			System.out.println("���݂̃R���N�V����:"+data.getName());
			System.out.println(" 0: ���̃��[�N�u�b�N�����");
			System.out.println(" 1: �o�菇������������");
			System.out.println(" 2: �o�菇���V���b�t������");
			System.out.println(" 3: ��������");
			System.out.println(" 4: ���̈ꗗ������");
			
			int input;
			while(true){
				System.out.print("���s����ԍ������> ");
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
					System.out.println("�I�����ɂȂ��ԍ��ł�");
					continue;
				}
				break;
			}
			
		}
	}
}