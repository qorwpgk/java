import javax.swing.*;
import java.awt.*;

public class ButtonHAlignmentEX extends JFrame {
	public ButtonHAlignmentEX() {
		setTitle("버튼 정렬");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif");
		
		JButton btn = new JButton("call~~", normalIcon);
		btn.setHorizontalAlignment(SwingConstants.LEFT);
		c.add(btn);
		
		setSize(250,150);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new ButtonHAlignmentEX();
	}
} 