import java.util.ArrayList;
import java.util.Random;

public enum Keyword {
		BOOLEAN("boolean", 0), THROWS("throws", 1), EXTENDS("extends", 2), IMPLEMENTS("implements", 3), NATIVE("native", 4), FINAL("final", 19), STRICTFP ("strictfp", 20), ASSERT ("assert", 21), TRANSIENT("transient", 31), INSTANCEOF("instanceof", 33),
		BOOL("bool", 5), BASE ("base", 6), NAMESPACE("namespace", 7), AS("as", 8), VIRTUAL("virtual", 9), STRING ("string", 10), OVERRIDE("override", 11), VOLATILE ("volatile", 22), GOTO ("goto", 23), DYNAMIC("dynamic", 30), IMPLICIT("implicit", 24), 
		CATCH("catch", 12), SWITCH("switch", 13), DOUBLE("double", 14), NEW("new", 15), PROTECTED("protected", 16), ENUM("enum", 17), INTERFACE("interface", 18), UNCHECKED ("unchecked", 25), IS("is", 26), THIS("this", 32), 
		FUNCTION("function", 27), FOO("foo", 28), TRACERT("tracert", 29), VAR("var", 30);
		
		private String _keyword;
		public ArrayList<String> array = new ArrayList<String>();
		private int _x;
		private Keyword (String s, int x) {
			_keyword = s;
			_x = x;
		}
		
		@Override //dynamic polymorphism
		public String toString() {
			return _keyword;
		}
		
		public static Keyword randomKeyword() {
			Random rand = new Random();
			return values()[rand.nextInt(values().length)];
		}
	}