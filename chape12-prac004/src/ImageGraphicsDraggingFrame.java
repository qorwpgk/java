import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImageGraphicsDraggingFrame extends JFrame {
	public ImageGraphicsDraggingFrame(){
		super("그래픽 이미지 드래깅 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new MyPanel());
		setSize(300,300);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("images/apple.jpg");		
		private Image img = icon.getImage();
		private int width, height;
		private int x=100, y=100;
		
		public MyPanel() {
			width = img.getWidth(this);
			height = img.getHeight(this);
			
			MyMouseListener ml = new MyMouseListener();
			addMouseListener(ml);
			addMouseMotionListener(ml);			
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, x, y, width, height, this); 
		}
		
		class MyMouseListener extends MouseAdapter {
			private Point startP = null;
			private boolean bDrag = false; 
			
			@Override
			public void mousePressed(MouseEvent e) {
				startP = e.getPoint();				
				if((startP.x >= x && startP.x <= x+width) &&
					(startP.y >= y && startP.y <= y+height)) { 
					bDrag = true;
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(bDrag == false)
					return;

				Point endP = e.getPoint();
				x = x + endP.x - startP.x;
				y = y + endP.y - startP.y;
				repaint();
				
				bDrag = false;
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				if(bDrag == false)
					return;

				Point endP = e.getPoint();
				x = x + endP.x - startP.x;
				y = y + endP.y - startP.y;
				
				startP = endP;
				repaint();
			}	
		}
		
	}
	
	
	static public void main(String[] args) {
		new ImageGraphicsDraggingFrame();
	}
}