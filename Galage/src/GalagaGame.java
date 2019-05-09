import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GalagaGame extends JPanel implements KeyListener {

	private boolean running = true;

	private ArrayList sprites = new ArrayList();
	private Sprite starship;

	 private int shot = 10;
          private int rerode = 9;
	private BufferedImage alienImage;//몬스터
	private BufferedImage shotImage;//탄환
	private BufferedImage shipImage;//플레이어
       private BufferedImage MBossImage;//중간 보스
	
	public GalagaGame() {
		JFrame frame = new JFrame("Galaga Game");

		frame.setSize(700, 600);//화면 크기
		frame.add(this);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
			shotImage = ImageIO.read(new File("fire.png"));
			shipImage = ImageIO.read(new File("starship.png"));
			alienImage = ImageIO.read(new File("duddn.png"));
	                MBossImage = ImageIO.read(new File("gustn.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.requestFocus();
		this.initSprites();
		addKeyListener(this);

	}

	private void initSprites() {
		starship = new StarShipSprite(this, shipImage, 370, 550);
		sprites.add(starship);
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 15; x++) {
				Sprite alien = new AlienSprite(this, alienImage, 100 + (x * 50), (50) + y * 30);
				sprites.add(alien);
				Sprite MBoss = new AlienSprite(this, MBossImage, 100 + (x * 1), (1) + y * 1);
				sprites.add(MBoss);
	
			}
		}
	}

	private void startGame() {
		sprites.clear();
		initSprites();
	}

	public void endGame() {
		System.exit(0);
	}

	public void removeSprite(Sprite sprite) {
		sprites.remove(sprite);
	}

	public void fire() {
		ShotSprite shot0 = new ShotSprite(this, shotImage, starship.getX() + 10, starship.getY() - 30);//탄환 위치
		ShotSprite shot1 = new ShotSprite(this, shotImage, starship.getX() + 15, starship.getY() - 30);
		sprites.add(shot0);
		sprites.add(shot1);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.YELLOW);//화면색 바꾸기
		g.fillRect(0, 0, 800, 600);
		for (int i = 0; i < sprites.size(); i++) {
			Sprite sprite = (Sprite) sprites.get(i);
			sprite.draw(g);
		}
	}

	public void gameLoop() {

		while (running) {
			for (int i = 0; i < sprites.size(); i++) {
				Sprite sprite = (Sprite) sprites.get(i);
				sprite.move();
			}

			for (int p = 0; p < sprites.size(); p++) {
				for (int s = p + 1; s < sprites.size(); s++) {
					Sprite me = (Sprite) sprites.get(p);
					Sprite other = (Sprite) sprites.get(s);

					if (me.checkCollision(other)) {
						me.handleCollision(other);
						other.handleCollision(me);
					}
				}
			}

			repaint();
			try {
				Thread.sleep(10);
			} catch (Exception e) {
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)//로켓 상하좌우 움직임
			starship.setDx(-5);
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			starship.setDx(+5);
		if (e.getKeyCode() == KeyEvent.VK_UP)
			starship.setDy(-5);
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			starship.setDy(+5);
		if (shot != 0) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {//로켓 날리기
				shot--;
				fire();
		
	}
}

		if (rerode != 0) {
			if (e.getKeyCode() == KeyEvent.VK_R) {
				shot = 20;
				rerode--;
				}
			}
		}
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			starship.setDx(0);
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			starship.setDx(0);
		if (e.getKeyCode() == KeyEvent.VK_UP)
			starship.setDx(0);
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			starship.setDx(0);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	public static void main(String argv[]) {
		GalagaGame g = new GalagaGame();
		g.gameLoop();
	}
}
