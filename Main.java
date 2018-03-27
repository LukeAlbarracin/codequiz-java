import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JToggleButton;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;
import javax.swing.SwingConstants;


import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.Font;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.color.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board board = new Board (3);
	}
}

class Board extends JFrame implements ActionListener {
	private transient long serialVersionUID = 1L;
	private JToggleButton[] _buttons = new JToggleButton[4];
	private JTextField _textField;
	private JLabel _label;
	private Question _question;
	private Keyword _s = Keyword.AS;
	private int _pts = 0;
	private int rounds = 0;
	private String _string = "";
	
	public Board (int length) {
		makeLabel();
		createQuestion();
		initializeJFrame(length);
	}
	public void makeLabel() {
		_label = new JLabel();
		_label.setLayout(null);
		_label.setVisible(true);
		_label.setFont(new Font("Arial", Font.PLAIN, 50));
		_label.setBounds(0, 0, 100, 100);
 		add (_label); 
	}
	public void initializeJFrame(int length) {
		setTitle("Java vs. C# - Similarities and Differences");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(5, 3));
		_buttons[0] = new JToggleButton(String.format("C#"));
		_buttons[1] = new JToggleButton(String.format("JAVA"));
		_buttons[2] = new JToggleButton(String.format("BOTH"));
		_buttons[3] = new JToggleButton(String.format("NEITHER"));
		for (int x = 0; x < 4; x++) {
			_buttons[x].setHorizontalTextPosition(SwingConstants.CENTER);
			_buttons[x].setFont(new Font("Arial", Font.PLAIN, 20));
			_buttons[x].setSize(50, 50);
			_buttons[x].addActionListener(this);
			add (_buttons[x]);
		}
		setResizable(true);
		setSize (1000, 300);
		setVisible(true);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	
	//dynamic polymorphism
	@Override
	public void actionPerformed(ActionEvent e) {
		JToggleButton button = null;
		if (e.getSource() == _buttons[0] && rounds < 11) {
			_question.inputAnswer(0);
			button = _buttons[0];
		} else if (e.getSource() == _buttons[1] && rounds < 11) {
			_question.inputAnswer(1);
			button = _buttons[1];
		} else if (e.getSource() == _buttons[2] && rounds < 11) {
			_question.inputAnswer(2);
			button = _buttons[2];
		} else if (e.getSource() == _buttons[3] && rounds < 11) {
			_question.inputAnswer(3);
			button = _buttons[3];
		}
		if (_question.getAnswer(_s) && rounds < 11) {
			_string = "Correct! ";
			checkCase();
			_label.setText("Correct");
			_label.setForeground(Color.GREEN);
			_pts++;
		} else if (rounds < 11){
			_string = "Incorrect... ";
			checkCase();
			_label.setText("Incorrect");
			_label.setForeground(Color.RED);
		}
		rounds++;
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		if (rounds < 11) { //10 questions asked
			createQuestion();
		} else {
			JOptionPane.showMessageDialog(null, "You got " + _pts + " out of 10 points");
			judgePoints();
		}
	}

	
	public void createQuestion () {
		//Question q = new Question();
		Random rand = new Random();
		_question = new Question();
		_s = _question.getKeyWord().randomKeyword();
		String s = _s.toString();
		_label.setHorizontalAlignment(SwingConstants.CENTER);
		_label.setText(s);
		_label.setForeground(Color.BLACK);
	}
	public void judgePoints() {
		if (_pts < 2) {
			_label.setText("Please take this seriously!");
		} else if (_pts < 4) {
			_label.setText("NOVICE ");
		} else if (_pts < 6) {
			_label.setText("YOUNG DEVELOPER");
		} else if (_pts < 8) {
			_label.setText("EXPERIENCED PROGRAMMER");
		} else if (_pts < 9) {
			_label.setText("OBJECT ORIENTED MASTER");
		} else {
			_label.setText("EXPERT");
		}
	}
	public void checkCase() {
		switch(_s) {
		case BOOLEAN : 
			JOptionPane.showMessageDialog(null, _string + "'boolean' means true or false. Boolean is only used in JAVA and is called bool in c#");
			break;
		case THROWS :
			JOptionPane.showMessageDialog(null, _string +"JAVA checks both checked and unchecked exceptions. C# only checks unchecked exceptions. 'throws' denotes a checked exception in JAVA, while 'throw' denotes an unchecked in both. Thus, 'throws' is strictly used in JAVA.");
			break;
		case EXTENDS :
			JOptionPane.showMessageDialog(null, _string + "'extends' denotes a subclass (child class) of a super class (parent class). It is only used in JAVA as C# uses a colon instead.");
			break;
		case IMPLEMENTS :
			JOptionPane.showMessageDialog(null, _string + "'implements' entails a use of inherited abstract methods from a given interface. It is only used in JAVA as C# uses a colon instead.");
			break;
		case NATIVE :
			JOptionPane.showMessageDialog(null, _string + "Whew that was a tough one! This keyword 'native' denotes a use of code using the JAVA Native Inferface and is only used in JAVA");
			break;
		case FINAL :
			JOptionPane.showMessageDialog(null, _string + "This keyword 'final' can be associated with the term constant as is only used in JAVA. In C#, it is called 'const'");
			break;
		case STRICTFP :
			JOptionPane.showMessageDialog(null, _string + "Kudos to you if you got this one right!!! This is strictly JAVA.");
			break;
		case ASSERT :
			JOptionPane.showMessageDialog(null, _string + "'Assert is used for expected boolean statements. It is strictly used in JAVA. In C#, it is a method.");
			break;
		case TRANSIENT :
			JOptionPane.showMessageDialog(null, _string +"'transient' denotes that a field should not be serialized. This is a complicated concept used strictly in JAVA.");
			break;
		case INSTANCEOF :
			JOptionPane.showMessageDialog(null, _string +"'instanceof' returns true or false if a particular object is of a particular type. This is strictly used in JAVA");
			break;
		case BOOL :
			JOptionPane.showMessageDialog(null, _string + "'bool' means true or false in C#. In JAVA, it is called 'boolean' instead.");
			break;
		case BASE :
			JOptionPane.showMessageDialog(null, _string + "'base' is often used when overriding a superclass (parent) method and when extending a class, writing a constructor. This is strictly used in C# and is called 'super' in JAVA.");
			break;
		case NAMESPACE :
			JOptionPane.showMessageDialog(null, _string + "'namespace' is similar to a package in JAVA. Strictly used in C#, named differently since C# creators wanted to be different from JAVA");
			break;
		case AS :
			JOptionPane.showMessageDialog(null, _string + "'as' is a keyword often used for casting in C#. Unique to C#.");
			break;
		case VIRTUAL :
			JOptionPane.showMessageDialog(null, _string + "'virtual' allows for something to be overrode via override in C#. Unique to C#");
			break;
		case STRING :
			JOptionPane.showMessageDialog(null, _string + "'string' is an arrangement of characters and is very similar to 'String' in JAVA");
			break;
		case OVERRIDE :
			JOptionPane.showMessageDialog(null, _string + "'override' allows for a subclass (child) to use a method with the same name under its own class in C#, and is well-known as @Override in JAVA");
			break;
		case VOLATILE :
			JOptionPane.showMessageDialog(null, _string + "'volatile' is used for the most updated value especially in concurrency (multiple threads) cases and is used strictly in C#.");
		case GOTO :
			JOptionPane.showMessageDialog(null, _string + "'goto' is used in switch statements and nested loops and transfers it to a labelled statement and is strictly used in C#");
			break;
		case DYNAMIC :
			JOptionPane.showMessageDialog(null, _string + "'dynamic' is similar to an 'Object' but does not have to be casted, exclusively used in C#");
			break;
		case IMPLICIT :
			JOptionPane.showMessageDialog(null, _string + "'implicit' allows conversions between a defined type (user) and another type and is unique in C#");
			break;
		case CATCH :
			JOptionPane.showMessageDialog(null, _string + "'catch' is used in both object-oriented programming languages to detect exceptions" );
			break;
		case SWITCH :
			JOptionPane.showMessageDialog(null, _string + "'switch' is used as an alternative to an if statement when using enums and certain variables that always has a default case and is used in both C# and JAVA");
			break;
		case DOUBLE :
			JOptionPane.showMessageDialog(null, _string + "'double' is a variable that can carry small amounts of decimal places and is used in both C# and JAVA");
			break;
		case NEW :
			JOptionPane.showMessageDialog(null, _string + "'new' is a crucial keyword necessary for creating instances of classes and accessing its encapsulated and non-static methods used in both C# and JAVA");
			break;
		case PROTECTED :
			JOptionPane.showMessageDialog(null, _string + "'protected' is a keyword necessary for low-level encapsulation used in both C# and JAVA");
			break;
		case ENUM :
			JOptionPane.showMessageDialog(null, _string + "'enum' is a collection of constants. This is used in both languages of C# and JAVA");
			break;
		case INTERFACE :
			JOptionPane.showMessageDialog(null, _string + "'interface' is a collection of necessary methods and variables that must be implemented by a class that implements it and is used in C# and JAVA.");
			break;
		case UNCHECKED :
			JOptionPane.showMessageDialog(null, _string + "'unchecked' is used in both C# and JAVA and is associated with the unchecked exception");
			break;
		case IS :
			JOptionPane.showMessageDialog(null, _string + "'is' checks if an object is of a particular type (e.g. long) and is used in both C# and JAVA");
			break;
		case THIS :
			JOptionPane.showMessageDialog(null, _string + "'this' refers to the variable declared explicitly in the/a particular class not referring to the one within a given method used in both C# and JAVA");
			break;
		case FUNCTION :
			JOptionPane.showMessageDialog(null, _string + "function refers to a keyword in Javascript similar to a method, but not C# or JAVA");
			break;
		case FOO :
			JOptionPane.showMessageDialog(null, _string + "a common variable name that is not used in any programming language");
			break;
		case TRACERT :
			JOptionPane.showMessageDialog(null, _string + "Also known as a tracer route, this is written in batch, but not C# or JAVA");
			break;
		case VAR :
			JOptionPane.showMessageDialog(null, _string + "This is a variable in JavaScript, but not C# or JAVA");
			break;
		default :
			break;
		}
	}

}

