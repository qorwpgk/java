import java.awt.*;
import javax.swing.*;

public class GraphicsPracticeFrame extends JFrame {
	public GraphicsPracticeFrame(){
		super("±×·¡ÇÈ  ´Ù°¢Çü ¿¬½À");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new MyPanel());
		setSize(300,300);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int [] x = new int [4];
			int [] y = new int [4];
			x[0] = getWidth()/2;
			y[0] = 0;
			x[1] = getWidth();
			y[1] = getHeight()/2;
			x[2] = x[0];
			y[2] = getHeight();
			x[3] = 0;
			y[3] = y[1];
			
			for(int i=0; i<10; i++) {
				g.drawPolygon(x, y, 4);
				y[0] = y[0] + 10;
				x[1] = x[1]-10;
				y[2] = y[2] -10;
				x[3] = x[3] + 10;
			}
		}
	}
	
	
	static public void main(String[] args) {
		new GraphicsPracticeFrame();
	}
}