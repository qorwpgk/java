import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

import javax.swing.*;

public class DicClientFrame extends JFrame{
	private Socket socket = null;
	private JTextField eng = new JTextField(10);
	private JTextField kor = new JTextField(10);
	private JButton searchBtn = new JButton("찾기");
	
	BufferedReader in = null;
	BufferedWriter out = null;
	
	public DicClientFrame(){
		super("클라이언트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("영어"));
		c.add(eng);
		c.add(new JLabel("한글"));
		c.add(kor);
		c.add(searchBtn);
		try{
			setupConnection();
		}catch (IOException e){
			handleError(e.getMessage());
		}
		searchBtn.addActionListener(new MyActionListener());
		
		setSize(400, 120);
		setVisible(true);
	}
	
	private void handleError(String message) {
		// TODO Auto-generated method stub
		
	}

	private void setupConnection() throws IOException{
		socket = new Socket("localhost",9998);
		System.out.println("연결됨");
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	}
	
	class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try{
				out.write(eng.getText()+"\n");
				out.flush();
				String text = in.readLine();
				kor.setText(text);
			} catch (IOException e2) {
				// TODO: handle exception
				handleError(e2.getMessage());
			}
		}
	}
	
	public static void main(String[]args){
		new DicClientFrame();
	}

}
