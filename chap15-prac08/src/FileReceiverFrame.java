import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class FileReceiverFrame extends JFrame{
	private JTextArea log = new JTextArea();
	private JLabel imageLabel = new JLabel();
	
	public FileReceiverFrame(){
		super("���� �޴� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.add(new JScrollPane(log), BorderLayout.NORTH);
		c.add(imageLabel, BorderLayout.CENTER);
		
		setSize(300, 300);
		setVisible(true);
		
		startService();
	}
	
	private void startService(){
		ServerThread server = new ServerThread();
		server.start();
	}
	
	private void drawImage(String file){
		ImageIcon icon = new ImageIcon(file);
		imageLabel.setIcon(icon);
		this.pack();
	}
	
	private class ServerThread extends Thread{
		public void run(){
			BufferedInputStream fin = null;
			BufferedOutputStream listener = null;
			ServerSocket listener1 = null;
			Socket socket = null;
			String saveFileName = null;
			try{
				listener1 = new ServerSocket(9999);
			}catch (IOException e1){
				e1.printStackTrace();
			}
			
			while(true){
				try{
					socket = listener1.accept();
					log.setText("�����\n");
					fin = new BufferedInputStream(socket.getInputStream());
					int cmd;
					String fileName = null;
					long length=0;
					
					cmd = fin.read();
					BufferedOutputStream fout;
					if(cmd == Command.FILE_NAME){
						int nameSize = receiveInt(fin);
						log.append("���۹��� ���� �̸� ���� :"+ nameSize + "\n");
						byte fname[] = new byte[nameSize];
						fin.read(fname);
						fileName = new String(fname);
						log.append("���۹��� ���� �̸�:" + saveFileName+ "\n");
						fout = new BufferedOutputStream(new FileOutputStream(saveFileName));				
					}else{
						log.append("��� ���� ����"+ cmd + "\n");
						socket.close();
						return;
					}
					cmd = fin.read();
					if(cmd == Command.FILE_SIZE){
						int lenghLow = receiveInt(fin);
						int lenghHigh = receiveInt(fin);
						length = lenghHigh;
						length <<= 32;
						length += lenghLow;
						log.append("��� ���� ����" + cmd + "\n");
						if(fout != null)
							fout.close();
						socket.close();
						listener1.close();
						return;
					}
					cmd = fin.read();
					if(cmd == Command.SEND_BEGIN){
						int numberToRead;
						while(length >0){
							byte b[] = new byte[2048];
							if(length <b.length)
								numberToRead = (int)length;
							else
								numberToRead = b.length;
								int numRead = fin.read(b, 0, numberToRead);
								if(numRead <= 0){
									if(length > 0){
										log.append("���� ������ �߻��߽��ϴ�. ���� ����Ʈ:" + numRead+ "���� ����Ʈ:" + length+ "\n");
										break;
										
									}
								}else{
									log.append(".");
									fout.write(b, 0, numRead);
									length -= numRead;
								}
						}
						cmd = fin.read();
						if(cmd == Command.SEND_END){
							log.append("\n���� ���� �����߽��ϴ�. ����  j���� ����Ǿ����ϴ�.\n");
						}else{
							log.append("\n��� ���� ����"+ cmd+ "\n");
						}
						if(fout != null)
							fout.close();
						socket.close();
						drawImage(saveFileName);
					}
				}catch (IOException e){
					e.printStackTrace();
					log.append("���� ���� �� ������ �߻��߽��ϴ�.\n");
				}
			}
		}
	}
	
	private int receiveInt(BufferedInputStream fin)throws IOException{
		int value;
		value = fin.read();
		value |= fin.read() << 8;
		value |= fin.read() << 16;
		value |= fin.read() << 24;
		return value;
	}
	
	public static void main(String[]args){
		new FileReceiverFrame();
	}

}
