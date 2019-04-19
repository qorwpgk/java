package JFrameEX;
import javax.swing.*;
import java.*;
import java.awt.color.*;
import java.awt.Color;
import java.awt.FlowLayout;

public class JFrameEX extends JFrame{
	public JFrameEX(){
		setTitle("프레임 구성");
		
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("file");
		JMenu editMenu = new JMenu("Edit");
		JMenu sourceMenu = new JMenu("Source");
		JMenu searchMenu = new JMenu("search");
		JMenu windowMenu = new JMenu("window");
		
		mb.add(fileMenu);
		mb.add(editMenu);
		mb.add(sourceMenu);
		mb.add(searchMenu);
		mb.add(windowMenu);
		setJMenuBar(mb);
		
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().setBackground(new Color(186,143,45));
		this.add(new JButton("add"));
		this.add(new JButton("sub"));
		this.add(new JButton("mul"));
		this.add(new JButton("div"));
		
		setSize(300,200);
		setVisible(true);
	}
	
	public static void main(String[]args){
		new JFrameEX();
		
	}
	
}