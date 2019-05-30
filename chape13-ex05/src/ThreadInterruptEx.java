import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TimerRunnable implements Runnable{
	private JLabel timerLabel;
	
	public TimerRunnable(JLabel timerLabel){
		this.timerLabel = timerLabel;
	}
	
	@Override
	public void run(){
		int n = 0;
	while(true){
	timerLabel.setText(Integer.toString(n));
	n++;
	try{
		Thread.sleep(1000);
	}
	catch (InterruptedException e) {
		// TODO: handle exception
		return;
	    }
	 }
	}
	
}
public class ThreadInterruptEx extends JFrame{
	private Thread th;
	public ThreadInterruptEx(){
		setTitle("hreadlnterruptEx ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic",Font.ITALIC,80));
		
		TimerRunnable runnable = new TimerRunnable(timerLabel);
		th = new Thread(runnable);
		c.add(timerLabel);
		
		JButton btn = new JButton("kill Timer");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				th.interrupt();
				JButton btn = (JButton)e.getSource();
				btn.setEnabled(false);
			}
		});
		c.add(btn);
		setSize(300,170);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         new ThreadInterruptEx();
	}

}
