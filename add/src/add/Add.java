package add;

import java.awt.*;
import javax.swing.*;

public class Add extends JFrame{
	public Add(){
		setTitle("°è»ê±â");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JButton("1"));
		c.add(new JButton("2"));
		c.add(new JButton("3"));
		c.add(new JButton("4"));
		c.add(new JButton("5"));
		c.add(new JButton("6"));
		c.add(new JButton("7"));
		c.add(new JButton("8"));
		c.add(new JButton("9"));
		c.add(new JButton("0"));
		c.add(new JButton("+"));
		c.add(new JButton("-"));
		c.add(new JButton("*"));
		c.add(new JButton("/"));
		c.add(new JButton("="));
		c.add(new JButton(" "));
		
		setSize(200,200);
		setVisible(true);
		
		class add{
			private int a,b;
			
			public void setValue(int a, int b){
				this.a=a;
				this.b=b;
			}
			public int calculate(){
				return a+b;
			
	    }
     }
		}
public static void main(String[]args){
	new Add();
}

}

