import javax.net.ssl.KeyManager;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class keyListenerEx extends JFrame{
             private JLabel [] keyMessage;
             
             public keyListenerEx(){
            	 setTitle("KeyListener ����");
            	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	 
            	 Container c = getContentPane();
            	 c.setLayout(new FlowLayout());
            	 c.addKeyListener(new MyKeyListener());
            	 
            	 keyMessage = new JLabel[3];
            	 keyMessage[0] = new JLabel("getkeyCode()");
            	 keyMessage[1] = new JLabel("getkeyChar()");
            	 keyMessage[2] = new JLabel("getkeyText()");
            	 
            	 for(int i=0;i<keyMessage.length;i++){
            		 c.add(keyMessage[i]);
            		 keyMessage[i].setOpaque(true);
            		 keyMessage[i].setBackground(Color.YELLOW);
            	 }
            	 
            	 setSize(300,150);
            	 setVisible(true);
            	 
            	 c.setFocusable(true);
            	 c.requestFocus();
            	 }
             class MyKeyListener extends KeyAdapter{
            	 public void keyPressed(KeyEvent e){
            		 int keyCode = e.getKeyCode();
            		 char keyChar = e.getKeyChar();
            		 keyMessage[0].setText(Integer.toString(keyCode));
            		 keyMessage[1].setText(Character.toString(keyChar));
            		 keyMessage[2].setText(KeyEvent.getKeyText(keyCode));
            		 System.out.println("keyPressed");
            	 }
            	 public void keyReleased(KeyEvent e){
            		 System.out.println("keyReleased"); 
            	 }
            	 public void keyTyped(KeyEvent e){
            		 System.out.println("ketTyped");
           }
            	 
             }
             public static void main(String[]args){
            	 new keyListenerEx();
            	 
             }
}
