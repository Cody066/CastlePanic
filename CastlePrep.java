import java.awt.Color;
import java.awt.Component;
import java.util.Random;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class CastlePrep extends JFrame implements KeyListener, ActionListener, MouseMotionListener, MouseListener {

	

	private CastleTower tower1 = new CastleTower();

	private ImageIcon imgTower1;
	private ImageIcon imgBackground;
		
	private JLabel lblBackground;
	private JLabel lblScore = new JLabel();
	private JLabel lblGameOver = new JLabel();


	private JButton btnDiscard;
	private JButton btnNext = new JButton ("Next");
	
	private Container content;
	
	private int mouseX = 0; 
	private int mouseY = 0;
		
	public int GobCounter = 0;
	public int GobCounterPlus = 1;
	public int CardCounter = 0;
	public int clickCounter = 0;
	public int NextCard = 0;
	
	private Player player1 = new Player();

	
	private boolean TurnOver;

	private JLabel lblTower1 = new JLabel();

	int N = 20;
	int W =6;
	int CountVis = 0;
	
	
	JLabel[]lblWallArray = new JLabel[W]; {
		
	for (int i=0; i<W; i++ ) {
		lblWallArray[i] = new JLabel();
		;}
	}
	
	ImageIcon[]imgWallArray = new ImageIcon[W]; {
		
	for (int i=0; i<W; i++ ) {
		imgWallArray[i] = new ImageIcon();
		;}
	}
	
	
	CastleWall[] CastleWallArray = new CastleWall[W]; {
	
	for (int i=0; i<W; i++ ) {
		 CastleWallArray[i] = new CastleWall();
		;}
	}
	
	JLabel[]lblGobArray = new JLabel[N]; {
		
	for (int i=0; i<N; i++ ) {
		lblGobArray[i] = new JLabel();
		;}
	}
	
	ImageIcon[]imgGobArray = new ImageIcon[N]; {
		
	for (int i=0; i<N; i++ ) {
		imgGobArray[i] = new ImageIcon();
		;}
	}
	
	
	
	EnemyGob[]EnemyGobArray = new EnemyGob[N]; {
		
	for (int i=0; i<N; i++ ) {
		EnemyGobArray[i] = new EnemyGob(lblGobArray[i], btnNext, lblWallArray,
				CastleWallArray, lblTower1, tower1, lblGameOver, player1);
		;}
	}
	
	
	JLabel[]lblCardArray = new JLabel[N]; {
		
	for (int i=0; i<N; i++ ) {
		lblCardArray[i] = new JLabel();
		;}
	}
	
	ImageIcon[]imgCardArray = new ImageIcon[N]; {
		
	for (int i=0; i<N; i++ ) {
		imgCardArray[i] = new ImageIcon();
		;}
	}
	
	ImageIcon[]imgCardYellArray = new ImageIcon[N]; {
		
	for (int i=0; i<N; i++ ) {
		imgCardYellArray[i] = new ImageIcon();
		;}
	}
	
	Card[]CardArray = new Card[N]; {
	
		for (int i=0; i<N; i++ ) {
			Random randCard = new Random();
			
			int  n1 = randCard.nextInt(3) + 1;
			
			if (n1 == 1) {
				CardArray[i] = new Card(n1, lblGobArray, lblCardArray,EnemyGobArray, i, player1, lblScore);
				
			}else if (n1 == 2) {
				CardArray[i] = new Card(n1,n1 ,lblGobArray, lblCardArray,EnemyGobArray, i , player1, lblScore);
				
			}else if (n1 == 3) {
				CardArray[i] = new Card(n1,n1,n1,lblGobArray, lblCardArray,EnemyGobArray, i, player1, lblScore);
			
			}
		}
	}
	

	

	public CastlePrep() {
	


		btnDiscard = new JButton("Discard");
		



		lblBackground = new JLabel();
		//lblScore = new JLabel();
		
		imgGobArray[0] = new ImageIcon(
				getClass().getResource(EnemyGobArray[0].getSpriteName()));
		
		imgTower1 = new ImageIcon(
				getClass().getResource(tower1.getSpriteName()));
	
		imgBackground = new ImageIcon(
				getClass().getResource("castlepan1green700.png"));
				
		
		
		content = getContentPane();
		
		
		setSize(GameProps.SCREEN_WIDTH, GameProps.SCREEN_HEIGHT);
		
		content.setBackground(Color.gray);
		setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
//////////////////////////////////////////////////////////////////////
		//Add the walls
		
		imgWallArray[0] = new ImageIcon(
				getClass().getResource("wall440.png"));
		imgWallArray[1] = new ImageIcon(
				getClass().getResource("wall80R.png"));
		imgWallArray[2] = new ImageIcon(
				getClass().getResource("wall340.png"));
		imgWallArray[3] = new ImageIcon(
				getClass().getResource("wall440.png"));
		imgWallArray[4] = new ImageIcon(
				getClass().getResource("wall80L.png"));
		imgWallArray[5] = new ImageIcon(
				getClass().getResource("wall340.png"));

		for (int i=0; i<lblWallArray.length; i++) {
			CastleWallArray[i].setSpriteX(1000); CastleWallArray[i].setSpriteY(1000);
			lblWallArray[i].setIcon(imgWallArray[i]);
			CastleWallArray[i].updateRpos(CastleWallArray[i].getSpriteX(),CastleWallArray[i].getSpriteY());
			lblWallArray[i].setSize(CastleWallArray[i].getSpriteH(),CastleWallArray[i].getSpriteW());
			//lblWallArray[i].setLocation(CastleWallArray[i].getSpriteX(),CastleWallArray[i].getSpriteY());
			add(lblWallArray[i]);
			lblWallArray[i].setVisible(true);
		}

		CastleWallArray[0].setSpriteX(340);CastleWallArray[0].setSpriteY(180);
		CastleWallArray[1].setSpriteX(390);CastleWallArray[1].setSpriteY(240);
		CastleWallArray[2].setSpriteX(351);CastleWallArray[2].setSpriteY(265);
		CastleWallArray[3].setSpriteX(268);CastleWallArray[3].setSpriteY(265);
		CastleWallArray[4].setSpriteX(232);CastleWallArray[4].setSpriteY(240);
		CastleWallArray[5].setSpriteX(268);CastleWallArray[5].setSpriteY(180);
		
		lblWallArray[0].setLocation(CastleWallArray[0].getSpriteX(),CastleWallArray[0].getSpriteY());
		lblWallArray[1].setLocation(CastleWallArray[1].getSpriteX(),CastleWallArray[1].getSpriteY());
		lblWallArray[2].setLocation(CastleWallArray[2].getSpriteX(),CastleWallArray[2].getSpriteY());
		lblWallArray[3].setLocation(CastleWallArray[3].getSpriteX(),CastleWallArray[3].getSpriteY());
		lblWallArray[4].setLocation(CastleWallArray[4].getSpriteX(),CastleWallArray[4].getSpriteY());
		lblWallArray[5].setLocation(CastleWallArray[5].getSpriteX(),CastleWallArray[5].getSpriteY());
		
		CastleWallArray[0].r.setSize(45, 45);
		CastleWallArray[1].r.setSize(45, 45);
		CastleWallArray[2].r.setSize(45, 45);
		CastleWallArray[3].r.setSize(45, 45);
		CastleWallArray[4].r.setSize(45, 45);
		CastleWallArray[5].r.setSize(45, 45);
		
		CastleWallArray[0].updateRpos(CastleWallArray[0].getSpriteX(),CastleWallArray[0].getSpriteY());
		CastleWallArray[1].updateRpos(CastleWallArray[1].getSpriteX(),CastleWallArray[1].getSpriteY());
		CastleWallArray[2].updateRpos(CastleWallArray[2].getSpriteX(),CastleWallArray[2].getSpriteY());
		CastleWallArray[3].updateRpos(CastleWallArray[3].getSpriteX(),CastleWallArray[3].getSpriteY());
		CastleWallArray[4].updateRpos(CastleWallArray[4].getSpriteX() + 25,CastleWallArray[4].getSpriteY()+ 10);
		CastleWallArray[5].updateRpos(CastleWallArray[5].getSpriteX(),CastleWallArray[5].getSpriteY() + 10);
		
		

		
		
	/////////////////////////////////////////////////////////////////////	
		//Add the  first gobbos
		
		
		Random RandGob1 = new Random();
		int  g1 = RandGob1.nextInt(5) + 1;
		
		EnemyGobArray[0].setPosition(g1);

		lblGobArray[0].setIcon(imgGobArray[0]);
		lblGobArray[0].setSize(EnemyGobArray[0].getSpriteH(),EnemyGobArray[0].getSpriteW());
		lblGobArray[0].setLocation(EnemyGobArray[0].getSpriteX(),EnemyGobArray[0].getSpriteY());
		EnemyGobArray[0].r.setSize(40, 40);
		EnemyGobArray[0].updateRpos(EnemyGobArray[0].getSpriteX(),EnemyGobArray[0].getSpriteY());
		
		add(lblGobArray[0]);
		
		btnDiscard.setLocation(550,605);
		btnDiscard.setSize(90, 40);
		btnNext.setLocation(450,605);
		btnNext.setSize(90,40);
		
		btnDiscard.addActionListener(this);
		btnNext.addActionListener(this);
		content.addMouseMotionListener(this);
		content.addMouseListener(this);

		
		for (int i=1; i<lblGobArray.length; i++) {
			EnemyGobArray[i].setSpriteX(-250); EnemyGobArray[i].setSpriteY(-250);
			lblGobArray[i].setIcon(imgGobArray[0]);
			EnemyGobArray[i].updateRpos(EnemyGobArray[i].getSpriteX(),EnemyGobArray[i].getSpriteY());
			lblGobArray[i].setSize(EnemyGobArray[i].getSpriteH(),EnemyGobArray[i].getSpriteW());
			lblGobArray[i].setLocation(EnemyGobArray[i].getSpriteX(),EnemyGobArray[i].getSpriteY());
			add(lblGobArray[i]);
			lblGobArray[i].setVisible(false);
		}
		
		for (int i=0; i<lblCardArray.length; i++) {
			CardArray[i].setSpriteX(-250); CardArray[i].setSpriteY(-250);
			imgCardArray[i] = new ImageIcon(
					getClass().getResource(CardArray[i].getSpriteName()));
			imgCardYellArray[i] = new ImageIcon(
					getClass().getResource(CardArray[i].getImgYell()));
			lblCardArray[i].setIcon(imgCardArray[i]);
			lblCardArray[i].setSize(CardArray[i].getSpriteH(),CardArray[i].getSpriteW());
			lblCardArray[i].setLocation(CardArray[i].getSpriteX(),CardArray[i].getSpriteY());
			lblCardArray[i].setVisible(false);
			add(lblCardArray[i]);
		}
		
		
		for (int i = 0; i < 5; i ++) {
			CardArray[i].setSpriteX(50 + i*100);CardArray[i].setSpriteY(550);
			CardArray[i].setStartX(CardArray[i].getSpriteX());
			CardArray[i].setStartY(CardArray[i].getSpriteY());
			CardArray[i].setStartH(CardArray[i].getSpriteH());
			CardArray[i].setStartW(CardArray[i].getSpriteW());
			lblCardArray[i].setLocation(CardArray[i].getSpriteX(),CardArray[i].getSpriteY());
			lblCardArray[i].setVisible(true);
			CardArray[i].updateRpos(CardArray[i].getSpriteX(),CardArray[i].getSpriteY());
			
		}
		
		
		add(btnDiscard);
		add(btnNext);
		
		
		lblTower1.setIcon(imgTower1);
		lblTower1.setSize(tower1.getSpriteH(),tower1.getSpriteW());
		lblTower1.setLocation(318,230);
		tower1.setSpriteX(318);tower1.setSpriteY(230);
		tower1.r.setSize(45, 45);
		tower1.updateRpos(tower1.getSpriteX(),tower1.getSpriteY());
		
		
		add (lblTower1);
		
		
		
		lblScore.setSize(150, 50);
		lblScore.setLocation(25, 25);
		lblScore.setForeground(Color.YELLOW);
		lblScore.setText("Goblins Killed : ");
		lblScore.setVisible(true);
		
		add(lblScore);
		

		lblGameOver.setVisible(false);
		
		add(lblGameOver);
		

		
		lblBackground.setIcon(imgBackground);
		lblBackground.setSize(700, 700);
		lblBackground.setLocation(0, 0);
		
		add(lblBackground);
		
		
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CastlePrep myGame = new CastlePrep();
		myGame.setVisible(true);
		myGame.setResizable(false);
		
		
			
	}

	public void Shuffle() {
		JLabel[]lblCardArray = new JLabel[N]; {
			
			for (int i=0; i<N; i++ ) {
				lblCardArray[i] = new JLabel();
				;}
			}
			
			ImageIcon[]imgCardArray = new ImageIcon[N]; {
				
			for (int i=0; i<N; i++ ) {
				imgCardArray[i] = new ImageIcon();
				;}
			}
			
			ImageIcon[]imgCardYellArray = new ImageIcon[N]; {
				
			for (int i=0; i<N; i++ ) {
				imgCardYellArray[i] = new ImageIcon();
				;}
			}
			
			Card[]CardArray = new Card[N]; {
			
				for (int i=0; i<N; i++ ) {
					Random randCard = new Random();
					
					int  n1 = randCard.nextInt(3) + 1;
					
					if (n1 == 1) {
						CardArray[i] = new Card(n1, lblGobArray, lblCardArray,EnemyGobArray, i, player1, lblScore);
						
					}else if (n1 == 2) {
						CardArray[i] = new Card(n1,n1 ,lblGobArray, lblCardArray,EnemyGobArray, i, player1, lblScore);
						
					}else if (n1 == 3) {
						CardArray[i] = new Card(n1,n1,n1,lblGobArray, lblCardArray,EnemyGobArray, i, player1, lblScore);
					
					}
				}
			}
			
			for (int i=0; i<lblCardArray.length; i++) {
				CardArray[i].setSpriteX(-250); CardArray[i].setSpriteY(-250);
				imgCardArray[i] = new ImageIcon(
						getClass().getResource(CardArray[i].getSpriteName()));
				imgCardYellArray[i] = new ImageIcon(
						getClass().getResource(CardArray[i].getImgYell()));
				lblCardArray[i].setIcon(imgCardArray[i]);
				lblCardArray[i].setSize(CardArray[i].getSpriteH(),CardArray[i].getSpriteW());
				lblCardArray[i].setLocation(CardArray[i].getSpriteX(),CardArray[i].getSpriteY());
				lblCardArray[i].setVisible(false);
				add(lblCardArray[i]);
			}
		}
	
		
	public void actionPerformed(ActionEvent click) {
		

		if(click.getSource() == btnDiscard) {
			
			if(TurnOver = true) {
			for (int i = 0; i < lblCardArray.length; i ++ ) {
				
				if (i + 5 > lblCardArray.length) {
					i = 0;
					Shuffle();
				}
			
			   if (CardArray[i].isSelected()) {
				   
				   lblCardArray[i].setVisible(false);
				   
				   lblCardArray[i + 5].setVisible(true);
				   lblCardArray[i + 5].setLocation(CardArray[i].getSpriteX(),(CardArray[i].getSpriteY()));
				   lblCardArray[i + 5].setSize(CardArray[i].getSpriteH(),CardArray[i].getSpriteW());
				   CardArray[i+ 5].updateRpos(CardArray[i+5].getSpriteX(),CardArray[i+5].getSpriteY());
				   
				   lblCardArray[i].setSize(0, 0);
				   lblCardArray[i].setLocation(-1000, -1000);
				   

			   } 
			   
			TurnOver = false;   
		   }
		}	
	}	
//check which cards are selected and get rid of them and create get new cards
			//max 2 cards


		
		if(click.getSource()== btnNext) {

			TurnOver = true;
			clickCounter = 0;
			CardCounter = 0;
			int NotVis = 6;
			//if less than 5 lblCards visible add another card
		
			
			for (CountVis = 0; CountVis < lblCardArray.length; CountVis++) {
				if (lblCardArray[CountVis].isVisible()) {
					CardCounter++;
					System.out.println(CardCounter);
				} else {
					NotVis = CountVis;
					//break;
				}
				if (CardCounter == 5) {
					break;
				}
				
			}
			
			if (NotVis + 5 > lblCardArray.length) {
				NotVis = 0;
				Shuffle();
			}
			
			while(CardCounter < 5) {
				
				lblCardArray[NotVis + 5].setVisible(true);
				CardArray[NotVis+ 5].setSelected(false);
				CardArray[NotVis + 5].setSpriteX(CardArray[NotVis].getStartX());
				CardArray[NotVis + 5].setSpriteY(CardArray[NotVis].getStartY());
				CardArray[NotVis + 5].setStartX(CardArray[NotVis].getStartX());
				CardArray[NotVis + 5].setStartY(CardArray[NotVis].getStartY());
				lblCardArray[NotVis + 5].setLocation(CardArray[NotVis + 5].getSpriteX(), CardArray[NotVis + 5].getSpriteY());
				lblCardArray[NotVis + 5].setSize(CardArray[NotVis].getSpriteH(),CardArray[NotVis].getSpriteW());
				CardArray[NotVis+ 5].updateRpos(CardArray[NotVis+5].getStartX(),CardArray[NotVis+5].getStartY());
				System.out.println("CardArray : " + NotVis);   
				CardCounter ++;
				System.out.println(CardCounter);
				}	
				


			
		for (int i = 0; i < lblGobArray.length; i ++ ) {
			if (lblGobArray[i].isVisible()) {
				if(EnemyGobArray[i].getMoving()) {
					EnemyGobArray[i].setMoving(false);
				}else {
					EnemyGobArray[i].setMoving(true);
					EnemyGobArray[i].moveGob();

				}
			}
			
		}
			
			GobCounter ++;
			
			if (GobCounter <= 2) {
			//System.out.println(GobCounter);
				
			
			Random RandGob2 = new Random();
			int  g2 = RandGob2.nextInt(5) + 1;
		
			
			
			EnemyGobArray[GobCounter].setPosition(g2);
			
			lblGobArray[GobCounter].setIcon(imgGobArray[0]);
			lblGobArray[GobCounter].setSize(EnemyGobArray[GobCounter].getSpriteH(),EnemyGobArray[GobCounter].getSpriteW());
			lblGobArray[GobCounter].setLocation(EnemyGobArray[GobCounter].getSpriteX(),EnemyGobArray[GobCounter].getSpriteY());
			EnemyGobArray[GobCounter].updateRpos(EnemyGobArray[GobCounter].getSpriteX(),EnemyGobArray[GobCounter].getSpriteY());
			lblGobArray[GobCounter].setVisible(true);

			} else if (GobCounter > 2 && GobCounter <= 4){
				Random RandGob2 = new Random();
				Random RandGob3 = new Random();
				int  g2 = RandGob2.nextInt(5) + 1;
				int  g3 = RandGob3.nextInt(5) + 1;
			
			
				EnemyGobArray[GobCounter].setPosition(g2);
				
				lblGobArray[GobCounter].setIcon(imgGobArray[0]);
				lblGobArray[GobCounter].setSize(EnemyGobArray[GobCounter].getSpriteH(),EnemyGobArray[GobCounter].getSpriteW());
				lblGobArray[GobCounter].setLocation(EnemyGobArray[GobCounter].getSpriteX(),EnemyGobArray[GobCounter].getSpriteY());
				EnemyGobArray[GobCounter].updateRpos(EnemyGobArray[GobCounter].getSpriteX(),EnemyGobArray[GobCounter].getSpriteY());
				lblGobArray[GobCounter].setVisible(true);
				
				GobCounter ++;
				
				EnemyGobArray[GobCounter].setPosition(g3);
				
				lblGobArray[GobCounter].setIcon(imgGobArray[0]);
				lblGobArray[GobCounter].setSize(EnemyGobArray[GobCounter].getSpriteH(),EnemyGobArray[GobCounter].getSpriteW());
				lblGobArray[GobCounter].setLocation(EnemyGobArray[GobCounter].getSpriteX(),EnemyGobArray[GobCounter].getSpriteY());
				EnemyGobArray[GobCounter].updateRpos(EnemyGobArray[GobCounter].getSpriteX(),EnemyGobArray[GobCounter].getSpriteY());
				lblGobArray[GobCounter].setVisible(true);
			
			} else {
				Random RandGob2 = new Random();
				Random RandGob3 = new Random();
				Random RandGob4 = new Random();
				int  g2 = RandGob2.nextInt(5) + 1;
				int  g3 = RandGob3.nextInt(5) + 1;
				int  g4 = RandGob4.nextInt(5) + 1;
			
			
				EnemyGobArray[GobCounter].setPosition(g2);
				
				lblGobArray[GobCounter].setIcon(imgGobArray[0]);
				lblGobArray[GobCounter].setSize(EnemyGobArray[GobCounter].getSpriteH(),EnemyGobArray[GobCounter].getSpriteW());
				lblGobArray[GobCounter].setLocation(EnemyGobArray[GobCounter].getSpriteX(),EnemyGobArray[GobCounter].getSpriteY());
				EnemyGobArray[GobCounter].updateRpos(EnemyGobArray[GobCounter].getSpriteX(),EnemyGobArray[GobCounter].getSpriteY());
				lblGobArray[GobCounter].setVisible(true);
				
				GobCounter ++;
				
				EnemyGobArray[GobCounter].setPosition(g3);
				
				lblGobArray[GobCounter].setIcon(imgGobArray[0]);
				lblGobArray[GobCounter].setSize(EnemyGobArray[GobCounter].getSpriteH(),EnemyGobArray[GobCounter].getSpriteW());
				lblGobArray[GobCounter].setLocation(EnemyGobArray[GobCounter].getSpriteX(),EnemyGobArray[GobCounter].getSpriteY());
				EnemyGobArray[GobCounter].updateRpos(EnemyGobArray[GobCounter].getSpriteX(),EnemyGobArray[GobCounter].getSpriteY());
				lblGobArray[GobCounter].setVisible(true);
				
				GobCounter ++;
				
				EnemyGobArray[GobCounter].setPosition(g4);
				
				lblGobArray[GobCounter].setIcon(imgGobArray[0]);
				lblGobArray[GobCounter].setSize(EnemyGobArray[GobCounter].getSpriteH(),EnemyGobArray[GobCounter].getSpriteW());
				lblGobArray[GobCounter].setLocation(EnemyGobArray[GobCounter].getSpriteX(),EnemyGobArray[GobCounter].getSpriteY());
				EnemyGobArray[GobCounter].updateRpos(EnemyGobArray[GobCounter].getSpriteX(),EnemyGobArray[GobCounter].getSpriteY());
				lblGobArray[GobCounter].setVisible(true);
				
			}
				
		}
		
	}
	
	
	public void mouseDragged(MouseEvent e) {
		
	    mouseX = e.getX();
	    mouseY = e.getY();
	    
	    Component pressedComp = content.getComponentAt(e.getX(), e.getY());
	    //if no collision reset position
	    
	    for (int i = 0 ; i < CardArray.length; i++) {
	    
		    if (pressedComp == lblCardArray[i]) {
		    	pressedComp.setLocation(mouseX - (pressedComp.getWidth()/2), mouseY - (pressedComp.getHeight()/2) );
		    	CardArray[i].updateRpos(mouseX - (pressedComp.getWidth()/2), mouseY - (pressedComp.getHeight()/2) );
		    	CardArray[i].setSelected(true);
		    	lblCardArray[i].setIcon(
						new ImageIcon(getClass().getResource(CardArray[i].getImgYell())));
		    	CardArray[i].setMoving(true);
		    	CardArray[i].MoveCard();
		    
		    	
		    }
	    }
	}
	

	
	public void mouseClicked(MouseEvent e) {
		
	    mouseX = e.getX();
	    mouseY = e.getY();
	    
	    Component pressedComp = content.getComponentAt(e.getX(), e.getY());
	    
		for (int i = 0; i < lblCardArray.length; i++) {
		
			if(pressedComp == lblCardArray[i]) {
				System.out.println("Clicked " + i);
				if (clickCounter <= 1  && !CardArray[i].isSelected()) {
					CardArray[i].setSelected(true);
					lblCardArray[i].setIcon(
							new ImageIcon(getClass().getResource(CardArray[i].getImgYell())));
					clickCounter++;
					System.out.println("Click counter : " + clickCounter);
					
				} else if (CardArray[i].isSelected()) {
					CardArray[i].setSelected(false);
					lblCardArray[i].setIcon(
							new ImageIcon(getClass().getResource(CardArray[i].getSpriteName())));
					clickCounter--;
					System.out.println("Click counter : " + clickCounter);
					
				}
				
			}

		}

	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	    mouseX = e.getX();
	    mouseY = e.getY();
	    
	    Component pressedComp = content.getComponentAt(e.getX(), e.getY());
	    //if no collision reset position
	    
	    for (int i = 0 ; i < CardArray.length; i++) {
	    
		    if (pressedComp == lblCardArray[i]) {
		    	pressedComp.setLocation(CardArray[i].getStartX(),CardArray[i].getStartY() );
		    	CardArray[i].updateRpos(CardArray[i].getSpriteX(),CardArray[i].getSpriteY());
		    	CardArray[i].setSelected(false);
		    	lblCardArray[i].setIcon(
						new ImageIcon(getClass().getResource(CardArray[i].getSpriteName())));
		    	CardArray[i].setMoving(false);
		    
		    
		    	
		    }
	    }
		
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}





	
	
	
}
