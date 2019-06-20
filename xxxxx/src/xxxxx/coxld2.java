package xxxxx;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class coxld2 extends JFrame{
	
	private JTextField startTf = new JTextField(7);
	private JButton calcBtn = new JButton("전송");
	private Socket socket = null;
	private BufferedReader in = null;
	private BufferedWriter out = null;
		
	
	public coxld2(){
		super("채팅 1");
		setSize(360,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(startTf);
		c.add(calcBtn);
		
		setVisible(true);
		
		setupConnection();
		
		calcBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent argO) {
				// TODO Auto-generated method stub
				try{
					String startText = startTf.getText().trim();
					if(startText.length() == 0 )
		                    return;
					out.write(startText+"\n");
					out.flush();
					String result = in.readLine();
				}catch (IOException e){
					System.out.println("클라이언트 : 서버로부터 연결 종료");
					return;
					//e.printStackTrace();
				}
			}
		});
	}
	public void setupConnection(){
		try{
			socket = new Socket("localhost", 9998);
			in =  new BufferedReader(new 
					InputStreamReader(socket.getInputStream()));
			out =  new BufferedWriter(new
					OutputStreamWriter(socket.getOutputStream()));
		}catch (UnknownHostException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
     public static void main(String[]args){
    	 new coxld2();
     }
}
