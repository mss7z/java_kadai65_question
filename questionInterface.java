//各問題のclassのinterfaceとなる
public interface questionInterface{
	//問題を問う
	//trueで正解、falseで不正解
	boolean question();
	//問題の文字列を得る
	String getQuestionStr();
}