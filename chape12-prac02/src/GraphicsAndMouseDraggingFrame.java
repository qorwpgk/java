import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GraphicsAndMouseDraggingFrame extends JFrame{
	public GraphicsAndMouseDraggingFrame(){
		super("이미지 위에 원 드래깅 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new MyPanel());
		setSize(300, 300);
		setVisible(true);
		
	}
	class MyPanel extends JPanel{
		private ImageIcon icon = new ImageIcon("images/back.jpg");
		private Image img = icon.getImage();
		private int ovalX=100, ovalY=100;
		private final int RADIUS = 20;
		
		public MyPanel(){
			addMouseMotionListener(new MouseMotionAdapter() {
				
				public void mouseDragged(MouseEvent e){
					ovalX = e.getX();
					ovalY = e.getY();
					repaint();
					
				}
			});
		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			g.setColor(Color.GREEN);
			g.fillOval(ovalX, ovalY, RADIUS, RADIUS);
			
		}
		
	}
	static public void main(String[]args){
		new GraphicsAndMouseDraggingFrame();
	}

}
