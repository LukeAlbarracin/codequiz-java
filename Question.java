import java.util.Random;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Question {
	public Answer _answer;
	public Keyword _keyword;
	

	public boolean isCorrect (Answer input) {
		if (input == _answer) {
			return true;
		} else {
			return false;
		}
	}	
	public Answer getAnswer () {
		return _answer;
	} //static polymorphism
	
	public boolean getAnswer(Keyword word) {
		switch (word) {
		case BOOLEAN : case THROWS : case EXTENDS : case IMPLEMENTS : case NATIVE : case FINAL : case STRICTFP : case ASSERT : case TRANSIENT : case INSTANCEOF :
			//JAVA
			if (_answer.toInt() == 1) {
				return true;
			} else {
				return false;
			}
		case BOOL : case BASE : case NAMESPACE : case AS : case VIRTUAL : case STRING : case OVERRIDE : case VOLATILE : case GOTO : case DYNAMIC : case IMPLICIT : case UNCHECKED : case IS :
			//C#
			if (_answer.toInt() == 0) {
				return true;
			} else {
				return false;
			}
		case CATCH : case SWITCH : case DOUBLE : case NEW : case PROTECTED : case ENUM : case INTERFACE : case THIS :
			//both
			if (_answer.toInt() == 2) {
				return true;
			} else {
				return false;
			}
		default :
			if (_answer.toInt() == 3) {
				return true;
			} else {
				return false;
			}
		}
	}	
	public void inputAnswer(int x) {
		switch (x) {
		case 0 : 
			_answer = Answer.CSHARP;
			break;
		case 1 :
			_answer = Answer.JAVA;
			break;
		case 2 :
			_answer = Answer.BOTH;
			break;
		case 3 :
			_answer = Answer.NEITHER;
		default :
			break;
		}
	}
	
	
	public Keyword getKeyWord () {
		return _keyword;
	}
	
}