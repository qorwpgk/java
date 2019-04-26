import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PlusMinusImageFrame extends JFrame{
	public PlusMinusImageFrame(){
		super("그래픽 이미지 확대 축소 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new MyPanel());
		setSize(300, 300);
		setVisible(true);
		
		getContentPane().setFocusable(true);
		getContentPane().requestFocus();
	}
	
	class MyPanel extends JFrame{
		private ImageIcon icon = new ImageIcon("images/apple.jpg");
		private Image img = icon.getImage();
		private int width, height;
		
		public MyPanel(){
			width = img.getWidth(this);
			height = img.getHeight(this);
			
			addKeyListener(new KeyAdapter() {
				
				public void keyPressed(KeyEvent e){
					if(e.getKeyChar() == '+'){
						width = (int)(width*1.1);
						height = (int)(height*1.1);
						repaint();
					}
					else if(e.getKeyChar() == '-'){
						width = (int)(width*0.9);
						height = (int)(height*0.9);
						repaint();
					}
				}
			});
		}
		
		public void paintComponent(Graphics g){
			super.paintComponents(g);
			g.drawImage(img, 10, 10, width, height, this);
			
		}
	}
	
	static public void main(String[]args){
		new PlusMinusImageFrame();
	}

}
