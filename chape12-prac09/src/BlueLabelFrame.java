import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BlueLabelFrame extends JFrame {
	public BlueLabelFrame(){
		super("Blue Label ¸¸µé±â");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		BlueLabel blueLabell = new BlueLabel("hello");
		blueLabell.setBackground(Color.RED);
		blueLabell.setForeground(Color.YELLOW);
		c.add(blueLabell);
		
		BlueLabe12 blueLabe12 = new BlueLabe12("Big Hello");
		blueLabe12.setOpaque(true);
		blueLabe12.setFont(new Font("TimesRoman", Font.ITALIC, 50));
		blueLabe12.setForeground(Color.MAGENTA);
		c.add(blueLabe12);
		
		setSize(300, 200);
		setVisible(true);

	}
	static public void main(String[]args){
		new BlueLabelFrame();
	}

}

class BlueLabel extends JLabel{
	public BlueLabel(ImageIcon icon){
		super(icon);
	}
	public BlueLabel(String text){
		super(text);
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		super.paintComponent(g);
	}
}

class BlueLabe12 extends JLabel{
	public BlueLabe12(ImageIcon icon){
		super(icon);
	}
	public BlueLabe12(String text){
		super(text);
	}
	
	public void setBackground(Color c){
		super.setBackground(Color.BLUE);
	}
}
