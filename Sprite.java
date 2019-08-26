import java.awt.Rectangle;

public class Sprite {
	
	protected int spriteX;
	protected int spriteY;
	
	protected int spriteH;
	protected int spriteW;
	
	protected String spriteName;
	
	protected Rectangle r;

	public int getSpriteX() {
		return spriteX;
	}

	public void setSpriteX(int spriteX) {
		this.spriteX = spriteX;
	}

	public int getSpriteY() {
		return spriteY;
	}

	public void setSpriteY(int spriteY) {
		this.spriteY = spriteY;
	}

	public int getSpriteH() {
		return spriteH;
	}

	public void setSpriteH(int spriteH) {
		this.spriteH = spriteH;
	}

	public int getSpriteW() {
		return spriteW;
	}

	public void setSpriteW(int spriteW) {
		this.spriteW = spriteW;
	}

	public String getSpriteName() {
		return spriteName;
	}

	public void setSpriteName(String spriteName) {
		this.spriteName = spriteName;
	}

	public Rectangle getR() {
		return r;
	}

	public void setR(Rectangle r) {
		this.r = r;
	}
	

	public void updateRpos(int x , int y) {
		r.x = x;
		r.y = y;
	}

	public Sprite(int spriteX, int spriteY, int spriteH, int spriteW, String spriteName) {
		super();
		this.spriteX = spriteX;
		this.spriteY = spriteY;
		this.spriteH = spriteH;
		this.spriteW = spriteW;
		this.spriteName = spriteName;
		this.r = new Rectangle(this.spriteX,this.spriteY,this.spriteH,this.spriteW);
		
	}

	public Sprite() {
		super();
		this.spriteX = 0;
		this.spriteY = 0;
		this.spriteH = 0;
		this.spriteW = 0;
		this.spriteName = "";
		this.r = new Rectangle(this.spriteX,this.spriteY,this.spriteH,this.spriteW);
	}
	
	public Sprite(String spriteName , int spriteH ,int spriteW) {
		super();
		this.spriteH = spriteH;
		this.spriteW = spriteW;
		this.spriteName = spriteName;
		this.r = new Rectangle(this.spriteX,this.spriteY,this.spriteH,this.spriteW);
	}
	
	
	public void Display() {
		System.out.println("X , Y : " + this.spriteX + " " + this.spriteY);
		
	}

}
