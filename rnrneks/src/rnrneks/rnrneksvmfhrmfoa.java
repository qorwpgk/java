package rnrneks;

import java.awt.*;
import javax.swing.*;


public class rnrneksvmfhrmfoa extends JFrame{
	public rnrneksvmfhrmfoa(){
		setTitle("������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JButton("2��"));
		c.add(new JButton("3��"));
		c.add(new JButton("4��"));
		c.add(new JButton("5��"));
		c.add(new JButton("6��"));
		c.add(new JButton("7��"));
		c.add(new JButton("8��"));
		c.add(new JButton("9��"));
		
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
