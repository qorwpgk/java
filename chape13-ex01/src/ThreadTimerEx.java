import java.awt.*;
import javax.swing.*;

class TimerTherad extends Thread{
	private JLabel timerLabel;
	
	public TimerTherad(JLabel timerLabel){
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
			return ;
		  }
		}
	 }
}
public class ThreadTimerEx extends JFrame{
	public ThreadTimerEx(){
		setTitle("Thread�� ��ӹ��� Ÿ�̸� ������ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c =getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC,80));
		c.add(timerLabel);
		
		TimerTherad th = new TimerTherad(timerLabel);
		
		setSize(300,170);
		setVisible(true);
		
		th.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          new ThreadTimerEx();
	}

}
