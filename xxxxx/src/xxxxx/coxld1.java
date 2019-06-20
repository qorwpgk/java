package xxxxx;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class coxld1 extends JFrame {
	private JTextArea log = new JTextArea();

	public coxld1() {
		super("채팅 서버");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.add(new JLabel("채팅 서버 입니다"));
		JTextArea area = new JTextArea();
		area.setCaretPosition(area.getDocument().getLength());//스크롤 
		JScrollPane scrollPane = new JScrollPane(area);
		c.add(new JScrollPane(log), BorderLayout.CENTER);
		setVisible(true);

		new ServerThread().start();
	}

	class ServerThread extends Thread {
		@Override
		public void run() {
			ServerSocket listener = null;
			Socket socket = null;
			try {
				listener = new ServerSocket(9998);
				while (true) {
					socket = listener.accept();
					log.append("클라이언트 연결됨\n");
					new ServiceThread(socket).start();

				}
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			try {
				if (listener != null)
					listener.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	class ServiceThread extends Thread {
		private Socket socket = null;
		private BufferedReader in = null;
		private BufferedWriter out = null;

		public ServiceThread(Socket socket) {
			this.socket = socket;
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			} catch (IOException e) {
				// TODO:	 handle exception
				e.printStackTrace();
			}
		}
		public void run(){
			while(true){
				try {
					String first = in.readLine();
					
					String resText = "";
					int res = 0;
				
				out.write(resText + "\n");
				out.flush();
				log.append(first + "\n");
				
				} catch (IOException e) {
					log.append("연결종료\n");
					System.out.println("연결 종료");
					return;
					//e.printStackTrace();
					
				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new coxld1();
	}

}
