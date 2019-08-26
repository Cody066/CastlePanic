import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class EnemyGob extends Sprite implements Runnable{

	private Boolean visible;
	private Boolean moving;
	private Boolean booGameOver;
	private Boolean collide = false;
	private JLabel lblGobArray;
	private JLabel lblGameOver;
	private JLabel[] lblWallArray;

	private JLabel lblTower1;
	private CastleTower tower1;
	private CastleWall[] CastleWallArray;
	private Thread t1;
	private JButton btnNext;
	private Player player1;
	private int Position;
	


	public EnemyGob(JLabel templblGobArray, JButton tempbtnNext, JLabel[] templblWallArray, 
			CastleWall[] tempCastleWallArray, JLabel templblTower1, CastleTower temptower1,
			JLabel templblGameOver, Player tempplayer1) {
		super("gob65.png", 53, 70);
		this.moving =false;
		lblGobArray = templblGobArray;
		btnNext = tempbtnNext;
		lblWallArray = templblWallArray;
		CastleWallArray = tempCastleWallArray;
		lblTower1 = templblTower1;
		tower1 = temptower1;
		lblGameOver = templblGameOver;
		player1 = tempplayer1;
		
		
	}


	public Boolean getCollide() {
		return collide;
	}


	public void setCollide(Boolean collide) {
		this.collide = collide;
	}

	public int getPosition() {
		return Position;
	}



	public void setPosition(int position) {
		Position = position;
		switch(position) {
		case 1 :
			this.setSpriteX(480);
			this.setSpriteY(30);
			break;
		case 2 :
			this.setSpriteX(630);
			this.setSpriteY(240);
			break;
		case 3 :
			this.setSpriteX(480);
			this.setSpriteY(470);
			break;
		case 4 :
			this.setSpriteX(180);
			this.setSpriteY(470);
			break;
		case 5 :
			this.setSpriteX(20);
			this.setSpriteY(240);
			break;
		case 6 :
			this.setSpriteX(180);
			this.setSpriteY(30);
			break;
		case 7 :
			this.setSpriteX(450);
			this.setSpriteY(75);
			break;
		case 8 :
			this.setSpriteX(570);
			this.setSpriteY(240);
			break;
		case 9 :
			this.setSpriteX(460);
			this.setSpriteY(410);
			break;
		case 10 :
			this.setSpriteX(200);
			this.setSpriteY(415);
			break;
		case 11 :
			this.setSpriteX(80);
			this.setSpriteY(240);
			break;
		case 12 :
			this.setSpriteX(200);
			this.setSpriteY(75);
			break;
		case 13 :
			this.setSpriteX(425);
			this.setSpriteY(115);
			break;
		case 14 :
			this.setSpriteX(510);
			this.setSpriteY(240);
			break;
		case 15 :
			this.setSpriteX(425);
			this.setSpriteY(370);
			break;
		case 16 :
			this.setSpriteX(240);
			this.setSpriteY(370);
			break;
		case 17 :
			this.setSpriteX(140);
			this.setSpriteY(240);
			break;
		case 18 :
			this.setSpriteX(225);
			this.setSpriteY(115);
			break;
		case 19 :
			this.setSpriteX(380);
			this.setSpriteY(150);
			break;
		case 20 :
			this.setSpriteX(450);
			this.setSpriteY(240);
			break;
		case 21 :
			this.setSpriteX(395);
			this.setSpriteY(325);
			break;
		case 22 :
			this.setSpriteX(270);
			this.setSpriteY(325);
			break;
		case 23 :
			this.setSpriteX(200);
			this.setSpriteY(240);
			break;
		case 24 :
			this.setSpriteX(260);
			this.setSpriteY(150);
			break;
		case 25 :
			this.setSpriteX(360);
			this.setSpriteY(190);
			break;
		case 26 :
			this.setSpriteX(400);
			this.setSpriteY(240);
			break;
		case 27 :
			this.setSpriteX(370);
			this.setSpriteY(290);
			break;
		case 28 :
			this.setSpriteX(280);
			this.setSpriteY(290);
			break;
		case 29 :
			this.setSpriteX(270);
			this.setSpriteY(240);
			break;
		case 30 :
			this.setSpriteX(280);
			this.setSpriteY(190);
			break;
		case 31 :
			this.setSpriteX(330);
			this.setSpriteY(250);
			break;

		}
	}
	
	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	
	public void moveGob() {
		t1 = new Thread(this, "Gob Move");
		t1.start();
	}
	

		
	
	
	public void WallCollision() {
		
		for (int i = 0; i < 6; i ++) {
			
			if (CastleWallArray[i].r.intersects(this.getR())){
				lblWallArray[i].setVisible(false);
				lblWallArray[i].setLocation(-1000,-1000);
				lblWallArray[i].setSize(0,0);
				CastleWallArray[i].updateRpos(-1000, -1000);
				lblGobArray.setVisible(false);
				lblGobArray.setLocation(-1000,-1000);
				lblGobArray.setSize(0,0);
				this.setCollide(true);
				this.updateRpos(-1000, -1000);
				this.setMoving(false);
				break;

			}
		}
	}
	
	public void TowerCollision() {
		
			if (tower1.r.intersects(this.getR())){
				lblTower1.setVisible(false);
				lblTower1.setLocation(-1000,-1000);
				lblTower1.setSize(0,0);
				lblGobArray.setVisible(false);
				lblGobArray.setLocation(-1000,-1000);
				lblGobArray.setSize(0,0);
				this.setMoving(false);
				
				GameOver();
				
		}
	}

	
	public void GameOver() {
		
		booGameOver = true;
		
		while(booGameOver) {
			
		
		lblGameOver.setText("Game Over");
		lblGameOver.setForeground(Color.BLACK);
		lblGameOver.setSize(300, 300);
		lblGameOver.setLocation(270,30);
		lblGameOver.setFont(new Font("Serif", Font.BOLD, 34));
		
		
		lblGameOver.setVisible(true);
		//player1.setName(JOptionPane.showInputDialog(null, "Enter Player Name"));
		
		booGameOver = false;
		
		}
		
	}
	
	
	public Boolean getMoving() {
		return moving;
	}

	public void setMoving(Boolean moving) {
		this.moving = moving;
	}

	
	
	@Override
	public void run() {
		moving = true ;
		lblGobArray.setIcon(new ImageIcon(getClass().getResource(this.getSpriteName())
				)
			);
		
		
		while (moving) {
			
			switch (this.getPosition()) {
			
			case 1 :
				
				int x1 = this.getSpriteX();
				int y1 = this.getSpriteY();
				this.setPosition(7);
				int x2 = this.getSpriteX();
				int y2 = this.getSpriteY();
				this.setPosition(1);
				int m = (y2-y1)/(x2-x1)- 1 ;
				int b = m * x1;
				int MoveX = x1;
				while (this.spriteY < y2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					this.spriteY = MoveY;
					MoveX--;
					MoveX--;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					}
				}
				
				this.setPosition(7);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 2 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(8);
				
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(2);
	
				m = (y2-y1)/(x2-x1)- 1 ;
				b = m * x1;
				MoveX = x1;
				System.out.println("X1 = "+x1+ "X2 = "+x2);
				System.out.println("y1 = "+y1+ "y2 = "+y2);
				System.out.println("M = " + m + "B = " + b);
				while (this.spriteX > x2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					//this.spriteY = MoveY;
					
					MoveX--;
					MoveX--;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					
					}
				}
				
				this.setPosition(8);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 3 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(9);
				
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(3);
	
				m = (y2-y1)/(x2-x1)- 1 ;
				b = m * x1;
				MoveX = x1;
				System.out.println("X1 = "+x1+ "X2 = "+x2);
				System.out.println("y1 = "+y1+ "y2 = "+y2);
				System.out.println("M = " + m + "B = " + b);
				while (this.spriteX > x2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					this.spriteY = MoveY;
					
					MoveX--;
					MoveX--;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					
					}
				}
				
				this.setPosition(9);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 4 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(10);
				
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(4);
	
				m = (y2-y1)/(x2-x1) - 1 ;
				b = m * x1;
				MoveX = x1;
				System.out.println("X1 = "+x1+ "X2 = "+x2);
				System.out.println("y1 = "+y1+ "y2 = "+y2);
				System.out.println("M = " + m + "B = " + b);
				while (this.spriteX < x2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					this.spriteY = MoveY;
					
					MoveX++;
					MoveX++;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					
					}
				}
				
				this.setPosition(10);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 5 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(11);
				
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(5);
	
				m = (y2-y1)/(x2-x1)- 1 ;
				b = m * x1;
				MoveX = x1;
				System.out.println("X1 = "+x1+ "X2 = "+x2);
				System.out.println("y1 = "+y1+ "y2 = "+y2);
				System.out.println("M = " + m + "B = " + b);
				while (this.spriteX < x2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					//this.spriteY = MoveY;
					
					MoveX++;
					MoveX++;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					
					}
				}
				
				this.setPosition(11);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 6 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(12);
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(6);
				m = (y2-y1)/(x2-x1)+ 1 ;
				b = m * x1;
				MoveX = x1;
				while (this.spriteY < y2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					this.spriteY = MoveY;
					MoveX++;
				//	MoveX++;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					}
				}
				
				this.setPosition(12);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 7 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(13);
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(7);
				m = (y2-y1)/(x2-x1)- 1 ;
				b = m * x1;
				MoveX = x1;
				while (this.spriteY < y2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					this.spriteY = MoveY;
					MoveX--;
					MoveX--;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					}
				}
				
				this.setPosition(13);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 8 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(14);
				
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(8);
	
				m = (y2-y1)/(x2-x1)- 1 ;
				b = m * x1;
				MoveX = x1;
				System.out.println("X1 = "+x1+ "X2 = "+x2);
				System.out.println("y1 = "+y1+ "y2 = "+y2);
				System.out.println("M = " + m + "B = " + b);
				while (this.spriteX > x2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					//this.spriteY = MoveY;
					
					MoveX--;
					MoveX--;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					
					}
				}
				
				this.setPosition(14);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 9 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(15);
				
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(9);
	
				m = (y2-y1)/(x2-x1) ;
				b = m * x1;
				MoveX = x1;
				System.out.println("X1 = "+x1+ "X2 = "+x2);
				System.out.println("y1 = "+y1+ "y2 = "+y2);
				System.out.println("M = " + m + "B = " + b);
				while (this.spriteX > x2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					this.spriteY = MoveY;
					
					MoveX--;
					MoveX--;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					
					}
				}
				
				this.setPosition(15);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 10 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(16);
				
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(10);
	
				m = (y2-y1)/(x2-x1);
				b = m * x1;
				MoveX = x1;
				System.out.println("X1 = "+x1+ "X2 = "+x2);
				System.out.println("y1 = "+y1+ "y2 = "+y2);
				System.out.println("M = " + m + "B = " + b);
				while (this.spriteX < x2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					this.spriteY = MoveY;
					
					MoveX++;
					MoveX++;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					
					}
				}
				
				this.setPosition(16);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 11 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(17);
				
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(11);
	
				m = (y2-y1)/(x2-x1)- 1 ;
				b = m * x1;
				MoveX = x1;
				while (this.spriteX < x2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					//this.spriteY = MoveY;
					
					MoveX++;
					MoveX++;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					
					}
				}
				
				this.setPosition(17);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 12 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(18);
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(12);
				m = (y2-y1)/(x2-x1)  ;
				b = m * x1;
				MoveX = x1;
				while (this.spriteX < x2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					this.spriteY = MoveY;
					MoveX++;
				//	MoveX++;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					}
				}
				
				this.setPosition(18);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 13 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(19);
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(13);
				m = (y2-y1)/(x2-x1)-1 ;
				b = m * x1;
				MoveX = x1;
				System.out.println("X1 = "+x1+ "X2 = "+x2);
				System.out.println("y1 = "+y1+ "y2 = "+y2);
				System.out.println("M = " + m + "B = " + b);
				while (this.spriteY < y2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					this.spriteY = MoveY;
					MoveX--;
					
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					}
				}
				
				this.setPosition(19);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 14 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(20);
				
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(14);
	
				m = (y2-y1)/(x2-x1)- 1 ;
				b = m * x1;
				MoveX = x1;
				System.out.println("X1 = "+x1+ "X2 = "+x2);
				System.out.println("y1 = "+y1+ "y2 = "+y2);
				System.out.println("M = " + m + "B = " + b);
				while (this.spriteX > x2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					//this.spriteY = MoveY;
					
					MoveX--;
					MoveX--;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					
					}
				}
				
				this.setPosition(20);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 15 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(21);
				
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(15);
	
				m = (y2-y1)/(x2-x1) ;
				b = m * x1;
				MoveX = x1;
				System.out.println("X1 = "+x1+ "X2 = "+x2);
				System.out.println("y1 = "+y1+ "y2 = "+y2);
				System.out.println("M = " + m + "B = " + b);
				while (this.spriteX > x2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					this.spriteY = MoveY;
					
					MoveX--;
					MoveX--;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					
					}
				}
				
				this.setPosition(21);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 16 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(22);
				
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(16);
	
				m = (y2-y1)/(x2-x1)  ;
				b = m * x1;
				MoveX = x1;
				System.out.println("X1 = "+x1+ "X2 = "+x2);
				System.out.println("y1 = "+y1+ "y2 = "+y2);
				System.out.println("M = " + m + "B = " + b);
				while (this.spriteX < x2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					this.spriteY = MoveY;
					
					MoveX++;
					MoveX++;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					
					}
				}
				
				this.setPosition(22);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 17 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(23);
				
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(17);
	
				m = (y2-y1)/(x2-x1)  ;
				b = m * x1;
				MoveX = x1;
				while (this.spriteX < x2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					//this.spriteY = MoveY;
					
					MoveX++;
					MoveX++;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					
					}
				}
				
				this.setPosition(23);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 18 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(24);
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(18);
				m = (y2-y1)/(x2-x1)+ 1 ;
				b = m * x1;
				MoveX = x1;
				while (this.spriteY < y2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					this.spriteY = MoveY;
					MoveX++;
				//	MoveX++;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					}
				}
				
				this.setPosition(24);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 19 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(25);
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(19);
				m = (y2-y1)/(x2-x1) +1 ;
				b = m * x1;
				MoveX = x1;
			//	System.out.println("X1 = "+x1+ "X2 = "+x2);
			//	System.out.println("y1 = "+y1+ "y2 = "+y2);
			//	System.out.println("M = " + m + "B = " + b);
				while (this.spriteX > x2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					this.spriteY = MoveY;
					MoveX--;
					MoveX--;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					}
				}
				
				this.setPosition(25);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());

				moving = false;
				break;
				
			case 20 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(26);
				
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(20);
	
				m = (y2-y1)/(x2-x1)- 1 ;
				b = m * x1;
				MoveX = x1;
			//	System.out.println("X1 = "+x1+ "X2 = "+x2);
			//System.out.println("y1 = "+y1+ "y2 = "+y2);
			//	System.out.println("M = " + m + "B = " + b);
				while (this.spriteX > x2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					//this.spriteY = MoveY;
					
					MoveX--;
					MoveX--;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					
					}
				}
				
				this.setPosition(26);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 21 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(27);
				
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(21);
	
				m = (y2-y1)/(x2-x1) ;
				b = m * x1;
				MoveX = x1;
				while (this.spriteX > x2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					this.spriteY = MoveY;
					
					MoveX--;
					MoveX--;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					
					}
				}
				
				this.setPosition(27);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 22 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(28);
				
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(22);
	
				m = (y2-y1)/(x2-x1);
				b = m * x1;
				MoveX = x1;
				while (this.spriteX < x2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					this.spriteY = MoveY;
					
					MoveX++;
					MoveX++;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					
					}
				}
				
				this.setPosition(28);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 23 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(29);
				
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(23);
	
				m = (y2-y1)/(x2-x1)- 1 ;
				b = m * x1;
				MoveX = x1;
				while (this.spriteX < x2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					//this.spriteY = MoveY;
					
					MoveX++;
					MoveX++;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					
					}
				}
				
				this.setPosition(29);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 24 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(30);
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(24);
				m = (y2-y1)/(x2-x1)  ;
				b = m * x1;
				MoveX = x1;
				System.out.println("X1 = "+x1+ "X2 = "+x2);
				System.out.println("y1 = "+y1+ "y2 = "+y2);
				System.out.println("M = " + m + "B = " + b);
				while (this.spriteY < y2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					this.spriteY = MoveY;
					MoveX++;
				//	MoveX++;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					}
				}
				
				this.setPosition(30);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 25 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(31);
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(25);
				m = (y2-y1)/(x2-x1)+ 1 ;
				b = m * x1;
				MoveX = x1;
				while (this.spriteY < y2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					this.spriteY = MoveY;
					MoveX++;
				//	MoveX++;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					}
				}
				
				this.setPosition(31);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 26 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(31);
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(26);
				m = (y2-y1)/(x2-x1)- 1 ;
				b = m * x1;
				MoveX = x1;
				while (this.spriteY < y2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					this.spriteY = MoveY;
					MoveX--;
					MoveX--;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					}
				}
				
				this.setPosition(31);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 27 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(31);
				
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(27);
	
				m = (y2-y1)/(x2-x1)- 1 ;
				b = m * x1;
				MoveX = x1;
				while (this.spriteX > x2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					//this.spriteY = MoveY;
					
					MoveX--;
					MoveX--;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					
					}
				}
				
				this.setPosition(31);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 28 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(31);
				
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(28);
	
				m = (y2-y1)/(x2-x1) ;
				b = m * x1;
				MoveX = x1;
				System.out.println("X1 = "+x1+ "X2 = "+x2);
				System.out.println("y1 = "+y1+ "y2 = "+y2);
				System.out.println("M = " + m + "B = " + b);
				while (this.spriteX < x2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					this.spriteY = MoveY;
					
					MoveX--;
					MoveX--;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					
					}
				}
				
				this.setPosition(31);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 29 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(31);
				
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(29);
	
				m = (y2-y1)/(x2-x1);
				b = m * x1;
				MoveX = x1;
				while (this.spriteX < x2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					this.spriteY = MoveY;
					
					MoveX++;
					MoveX++;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					
					}
				}
				
				this.setPosition(31);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			case 30 :
				
				x1 = this.getSpriteX();
				y1 = this.getSpriteY();
				this.setPosition(31);
				
				x2 = this.getSpriteX();
				y2 = this.getSpriteY();
				this.setPosition(30);
	
				m = (y2-y1)/(x2-x1)- 1 ;
				b = m * x1;
				MoveX = x1;
				while (this.spriteX < x2 ) {
					
					int MoveY = (int) (m*MoveX - b + y1);
					this.spriteX = MoveX;
					//this.spriteY = MoveY;
					
					MoveX++;
					MoveX++;
					this.updateRpos(this.getSpriteX(),this.getSpriteY());
					lblGobArray.setLocation(this.getSpriteX(), this.getSpriteY());
					WallCollision();
					if (this.getCollide()) {
						break;
					}
					TowerCollision();	
					
					try {
						Thread.sleep(100);
						
					} catch (Exception e) {
						
					
					}
				}
				
				this.setPosition(31);
				this.setSpriteX(x2);
				this.setSpriteY(y2);
				lblGobArray.setLocation(this.getSpriteX(),this.getSpriteY());
				this.updateRpos(this.getSpriteX(),this.getSpriteY());
				moving = false;
				break;
				
			}
		}
		
	}
}
