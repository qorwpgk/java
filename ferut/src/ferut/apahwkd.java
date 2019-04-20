package ferut;

import javax.swing.*;
import java.awt.*;

public class apahwkd extends JFrame{
	public apahwkd() {
		setTitle("메모장");
		createMenu();
		Text();
		createToolBar();
		createSplitPane();
		setSize(500,400);
		setVisible(true);
		
	}

	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		mb.add(new JMenu("파일(F)"));
		mb.add(new JMenu("편집(E)"));
		mb.add(new JMenu("서식(O)"));
		mb.add(new JMenu("보기(H)"));
		mb.add(new JMenu("도움말(H)"));
		
		this.setJMenuBar(mb);
	}
	
	private void createToolBar() {
		JToolBar bar = new JToolBar("Kitae Menu");
		
		//bar.setBackground(Color.LIGHT_GRAY);
		//bar.add(new JButton("New"));
		//bar.add(new JButton(new ImageIcon("images/open.jpg")));
		//bar.addSeparator();
		//bar.add(new JButton(new ImageIcon("images/open.jpg")));
		//bar.add(new JLabel("search"));
		//bar.add(new JTextField("text field"));
		
		//JComboBox<String> combo = new JComboBox<String>();
		//combo.addItem("Java");
		//combo.addItem("C#");
		//combo.addItem("C");
		//combo.addItem("C++");
		//bar.add(combo);
		//add(bar,BorderLayout.NORTH);
		
	}
	
	private void createSplitPane() {
	//String[] fruits = {"apple","banana","kiwi","mango",
			//"peach","berry","stawberry","blackberry"};
	
	//JList<String>scrollList = new JList<String>(fruits);
	//JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
			//new JScrollPane(scrollList),new JScrollPane(new JLabel(new ImageIcon("images/mg1.jpg"))));
	
	//add(pane, BorderLayout.CENTER);
	}
	
        private void Text() {
		Container text = getContentPane();
		text.add(new JTextArea());
	}
	public static void main(String[]args) {
		new apahwkd();
		
	}
}