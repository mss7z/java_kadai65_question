public class programMain{
	public static void main(String[] args){
		collectionManager manager=new collectionManager();
		while(true){
			collection coll=manager.userChoiceCollection();
			if(coll==null){
				System.out.println("èIóπÇµÇ‹Ç∑");
				return;
			}
			workbook book=new workbook(coll);
			
			book.workbookUI();
			System.out.println();
		}
	}
}