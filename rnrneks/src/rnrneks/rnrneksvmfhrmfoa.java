package rnrneks;

import java.awt.*;
import javax.swing.*;


public class rnrneksvmfhrmfoa extends JFrame{
	public rnrneksvmfhrmfoa(){
		setTitle("구구단");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JButton("2단"));
		c.add(new JButton("3단"));
		c.add(new JButton("4단"));
		c.add(new JButton("5단"));
		c.add(new JButton("6단"));
		c.add(new JButton("7단"));
		c.add(new JButton("8단"));
		c.add(new JButton("9단"));
		
		for(int i=2;i<=9;i++){
			for(int j=1;j<=9;j++){
			System.out.println(i + "*" + j +"=" + i*j);	
			}
			System.out.println();
		}
		
		setSize(200,200);
		setVisible(true);
     }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new rnrneksvmfhrmfoa();
	}

}
