import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Card extends Sprite implements Runnable {

	private boolean Selected;
	private Boolean visible;
	private Boolean moving;
	private Thread t2;
	private JLabel[] lblGobArray;
	private JLabel[] lblCardArray;
	private JLabel lblScore;
	private EnemyGob[] EnemyGobArray;
	private int CardNum;
	private String ImgYell;
	private int StartX;
	private int StartY;
	private int StartH;
	private int StartW;
	private int intScore;
	private Player player1 = new Player(); 


	

	public int getStartX() {
		return StartX;
	}

	public int getStartH() {
		return StartH;
	}

	public void setStartH(int startH) {
		StartH = startH;
	}

	public int getStartW() {
		return StartW;
	}

	public void setStartW(int startW) {
		StartW = startW;
	}

	public void setStartX(int startX) {
		StartX = startX;
	}

	public int getStartY() {
		return StartY;
	}

	public void setStartY(int startY) {
		StartY = startY;
	}

	public Card (int num1, JLabel[] TemplblGobArray, JLabel[] TemplblCardArray,EnemyGob[] TempEnemyGobArray, 
			int TempCardNum,Player tempPlayer1, JLabel templblScore) {
		super("CardArrow65.png", 72,82);
		lblGobArray = TemplblGobArray;
		lblCardArray = TemplblCardArray;
		CardNum = TempCardNum;
		EnemyGobArray = TempEnemyGobArray;
		ImgYell = "CardArrow65Yell.png";
		player1= tempPlayer1;	
		lblScore = templblScore;
		
		}
	
	public Card (int num1, int num2, JLabel[] TemplblGobArray, JLabel[] TemplblCardArray, EnemyGob[] TempEnemyGobArray,
			int TempCardNum,  Player tempPlayer1, JLabel templblScore) {
		super("CardKnight65.png", 66,51);
		lblGobArray = TemplblGobArray;
		lblCardArray = TemplblCardArray;
		CardNum = TempCardNum;
		EnemyGobArray = TempEnemyGobArray;
		ImgYell = "CardKnight65Yell.png";
		player1= tempPlayer1;
		lblScore = templblScore;
		
		}
	
	public Card (int num1, int num2, int num3, JLabel[] TemplblGobArray, JLabel[] TemplblCardArray,EnemyGob[] TempEnemyGobArray,
			int TempCardNum, Player tempPlayer1, JLabel templblScore) {
		super("CardSword65.png", 66,66);
		lblGobArray = TemplblGobArray;
		lblCardArray = TemplblCardArray;
		CardNum = TempCardNum;
		EnemyGobArray = TempEnemyGobArray;
		ImgYell = "CardSword65Yell.png";
		player1= tempPlayer1;	
		lblScore = templblScore;
		
		}
	
	
	public String getImgYell() {
		return ImgYell;
	}

	public void setImgYell(String imgYell) {
		this.ImgYell = imgYell;
	}

	public boolean isSelected() {
			return Selected;
		}
	
	public void setSelected(boolean selected) {
			Selected = selected;
			
		}
	
	public Boolean getVisible() {
			return visible;
		}
	
	public void setVisible(Boolean visible) {
			this.visible = visible;
		}
	
	public Boolean getMoving() {
			return moving;
		}
	
	public void setMoving(Boolean moving) {
			this.moving = moving;
		}

	public void MoveCard() {

		t2 = new Thread(this, "Card Move");
		t2.start();
	}
	

	
	public void run () {
		moving = true;

		while (moving) {
			
			for (int i = 0; i < EnemyGobArray.length; i ++) {
				if (EnemyGobArray[i].getPosition() > 6) {
			
					if (EnemyGobArray[i].getPosition() > 6 && 
						EnemyGobArray[i].getPosition() <= 12 &&
						this.getSpriteName().equals("CardArrow65.png")){
					
				
						if (EnemyGobArray[i].r.intersects(this.getR())){
							lblGobArray[i].setVisible(false);
							lblGobArray[i].setLocation(-1000,-1000);
							lblGobArray[i].setSize(0,0);
							EnemyGobArray[i].updateRpos(-1000,1000);
							lblCardArray[CardNum].setVisible(false);
							lblCardArray[CardNum].setLocation(-6000,-6000);
							lblCardArray[CardNum].setSize(0,0);
							this.setMoving(false);
							this.updateRpos(-6000,6000);
							
							player1.getScore();
							player1.setScore(player1.getScore()+ 1);
							lblScore.setText("Goblins Killed : " + player1.getScore());
							break;
					
							}
						
				} else if (EnemyGobArray[i].getPosition() > 12 && 
						EnemyGobArray[i].getPosition()  <= 18 &&
						this.getSpriteName().equals("CardKnight65.png")){
				
						if (EnemyGobArray[i].r.intersects(this.getR())){
								lblGobArray[i].setVisible(false);
								lblGobArray[i].setLocation(-1000,-1000);
								lblGobArray[i].setSize(0,0);
								EnemyGobArray[i].updateRpos(-1000,1000);
								lblCardArray[CardNum].setVisible(false);
								lblCardArray[CardNum].setLocation(-6000,-6000);
								lblCardArray[CardNum].setSize(0,0);
								this.updateRpos(-6000,6000);
								this.setMoving(false);
								
								player1.getScore();
								player1.setScore(player1.getScore()+ 1);
								lblScore.setText("Goblins Killed : " + player1.getScore());
								break;

			
					}
				
					
				} else if (EnemyGobArray[i].getPosition() > 18 && 
						EnemyGobArray[i].getPosition()  <= 24 &&
						this.getSpriteName().equals("CardSword65.png") ){
						
						if (EnemyGobArray[i].r.intersects(this.getR())){
								lblGobArray[i].setVisible(false);
								lblGobArray[i].setLocation(-1000,-1000);
								lblGobArray[i].setSize(0,0);
								EnemyGobArray[i].updateRpos(-1000,1000);
								lblCardArray[CardNum].setVisible(false);
								lblCardArray[CardNum].setLocation(-6000,-6000);
								lblCardArray[CardNum].setSize(0,0);
								this.setMoving(false);
								this.updateRpos(-6000,6000);
								
								player1.getScore();
								player1.setScore(player1.getScore()+ 1);
								lblScore.setText("Goblins Killed : " + player1.getScore());
								break;

				
						}
					
					} else {
						
						}
						
					try {
						Thread.sleep(200);
						
					} catch (Exception e) {
					}	
				}
			}
		}
	}
}



	

