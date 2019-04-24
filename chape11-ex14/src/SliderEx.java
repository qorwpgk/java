import javax.swing.*;
import java.awt.*;

public class SliderEx extends JFrame{
             public SliderEx() {
            	 setTitle("½½¶óÀÌ´õ ¸¸µé±â ¿¹Á¦");
            	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	 Container c = getContentPane();
            	 c.setLayout(new FlowLayout());
            	 
            	 JSlider slider = new JSlider(JSlider.HORIZONTAL);
            	 slider.setPaintLabels(true);
            	 slider.setPaintTicks(true);
            	 slider.setPaintTrack(true);
            	 slider.setMajorTickSpacing(50);
            	 slider.setMinorTickSpacing(10);
            	 c.add(slider);
            	 
            	 setSize(300,100);
            	 setVisible(true);
            	 
             }
             public static void main(String[]args) {
            	 new SliderEx();
            	 
             }
}
