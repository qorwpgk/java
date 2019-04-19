import java.awt.Color;

import java.awt.Container;

import java.awt.FlowLayout;



import javax.swing.JButton;

import javax.swing.JFrame;



public class ContentPanEX extends JFrame {

	public ContentPanEX(){

		setTitle("Content Pane and JFrame");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		

		Container contentPan = getContentPane();

		contentPan.setBackground(Color.RED);

		contentPan.setLayout(new FlowLayout());

		

		contentPan.add(new JButton("OK"));

		contentPan.add(new JButton("CANCEL"));

		contentPan.add(new JButton("IGNORE"));

		

		setSize(300,300);

		setVisible(true);

	}

													

	public static void main(String[] args) {

		

		new ContentPanEX();

		// TODO Auto-generated method stub



	}



}