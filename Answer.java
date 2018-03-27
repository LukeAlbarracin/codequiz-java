
public enum Answer {
	CSHARP(0), JAVA(1), BOTH(2), NEITHER(3);
	private int _answer;
	
	private Answer (int x) {
		_answer = x;
	}
	public int toInt() {
		return _answer;
	}
	
}
