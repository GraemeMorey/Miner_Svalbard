package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	
	
	public final int screenX; 
	public final int screenY;
	//coal
	public int hasCoal = 0;
	public int coal = 0;
	public int coalFactIndicator = 0;
	public int coalFact1 = 0;
	public int coalFact2 = 0;
	public int coalFact3 = 0;

	//fossil
	public int fossil = 0;
	public int fossilFactIndicator = 0;
	public int fossilFact1 = 0;
	public int fossilFact2 = 0;
	public int fossilFact3 = 0;
	public int fossilCount = 0;

	//microfossil
	public int microfossil = 0;
	public int microfossilFactIndicator = 0;
	public int microfossilCount = 0;
	

	//dropstone
	public int dropstone = 0;
	public int dropstoneFactIndicator = 0;
	public int dropstoneFact1 = 0;
	public int dropstoneFact2 = 0;
	public int dropstoneFact3 = 0;
	public int dropstoneCount = 0;
	//scientist
	public int scientist = 0;
	public int scientistFactIndicator = 0;
	public int scientistFact1 = 0;
	public int scientistFact2 = 0;
	public int scientistFact3 = 0;
	public int scientistCount = 0;

	


	public int dialogueCounter = 0;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 15; //adjust collision area for character
		solidArea.y = 20;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 20;
		solidArea.height = 23;
		
		setDefaultValues();
		getPlayerImage();
			}
	public void setDefaultValues() {
		
		worldX = gp.tileSize * 15; // default player position on world map
		worldY = gp.tileSize * 46; // default player position on world map
		speed = 4;
		direction = "rest";
	}
	public void getPlayerImage() {
		
		try {
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/miner_up_0.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/miner_up_1.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/miner_down0.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/miner_down1.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/miner_right_0.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/miner_right_1.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/miner_left0.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/miner_left1.png"));
			rest1 = ImageIO.read(getClass().getResourceAsStream("/player/miner_rest_0.png"));
			rest2 = ImageIO.read(getClass().getResourceAsStream("/player/miner_rest_1.png"));
			rest3 = ImageIO.read(getClass().getResourceAsStream("/player/miner_rest_2.png"));
			rest4 = ImageIO.read(getClass().getResourceAsStream("/player/miner_rest_3.png"));

			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		
		if(keyH.upPressed == true) {
			direction = "up";
		}
		else if(keyH.downPressed == true) {
			direction = "down";
		}
		else if(keyH.leftPressed == true) {
			direction = "left";
		}
		else if(keyH.rightPressed == true) {
			direction = "right";
		}
		else if(keyH.rest == true) {
			direction = "rest";	
		}
		else if(keyH.next == true) {
			main.UI.on = 1;
		}
//		else if(keyH.endDialogue == true) {
//			dialogueCounter = 0;
//		}
		
		
		//CHECK TILE COLLISION
		collisionOn = false;
		gp.cChecker.checkTile(this);
		
		
		//CHECK OBJECT COLLISION
		int objIndex = gp.cChecker.checkObject(this, true);
		pickUpObject(objIndex);
		
		
		
		//IF COLLISION IS FALSE, PLAYER CAN MOVE
		if(collisionOn == false) {
			
			switch(direction) {
			case "up": worldY -= speed; break;
			case "down":worldY += speed; break;
			case "left":worldX -= speed; break;
			case "right":worldX += speed; break;
			}
		}
		
		spriteCounter++;
		if(spriteCounter > 20) {
			if(spriteNum == 1) {
				spriteNum = 2;
			}
			else if(spriteNum == 2) {
				spriteNum = 3;
			}
			else if(spriteNum == 3) {
				spriteNum = 4;
			}
			else if(spriteNum == 4) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
	}
	
		public void pickUpObject (int i) {
			
			if (i != 999) {
				
				String objectName = gp.obj[i].name;
				
				
				switch(objectName) {
				case "Coal":
					coal = 1;
					coalFactIndicator++;
					dropstone = 0;
					fossil = 0;
					microfossil = 0;
					scientist = 0;
					coalFact1 = 0;
					hasCoal ++;
					gp.obj[i] = null; //deletes object we just touched
					gp.ui.showMessage("Coal info, so so cool!");

					break;
				case "Dropstone":
					dropstone = 1;
					dropstoneFactIndicator ++;
					dropstoneCount ++;
					coal = 0;
					fossil = 0;
					microfossil = 0;
					scientist = 0;
					gp.obj[i] = null; //deletes object we just touched
					gp.ui.showMessage("Coal info, so so cool!");

					break;
				case "Fossil":
					fossil = 1;
					fossilFactIndicator ++;
					fossilCount ++;
					coal = 0;
					dropstone = 0;
					microfossil = 0;
					scientist = 0;
					gp.obj[i] = null; //deletes object we just touched
					gp.ui.showMessage("Coal info, so so cool!");

					break;
				case "Microfossil":
					microfossil = 1;
					microfossilCount ++;
					coal = 0;
					dropstone = 0;
					fossil = 0;
					scientist = 0;
					microfossilFactIndicator ++;
					gp.obj[i] = null; //deletes object we just touched
					gp.ui.showMessage("Coal info, so so cool!");

					break;
				case "Scientist":
					scientist = 1;
					scientistFactIndicator ++;
					scientistCount ++;
					coal = 0;
					dropstone = 0;
					fossil = 0;
					microfossil = 0;
					gp.obj[i] = null; //deletes object we just touched
					gp.ui.showMessage("Coal info, so so cool!");

					break;
				}
				
			}
		}
		
	
		public void draw(Graphics2D g2) {
			
//			g2.setColor(Color.white);
//			g2.fillRect(x, y, gp.tileSize, gp.tileSize);
			BufferedImage image = null;
			
			switch(direction) {
			case "up":
				if(spriteNum == 1) {
					image = up1;
				}
				if(spriteNum == 2) {
					image = up2;
				}
				if(spriteNum == 3) {
					image = up1;
				}
				if(spriteNum == 4) {
					image = up2;
				}
				break;
			case "down":
				if(spriteNum == 1) {
					image = down1;
				}
				if(spriteNum == 2) {
					image = down2;
				}
				if(spriteNum == 3) {
					image = down1;
				}
				if(spriteNum == 4) {
					image = down2;
				}
				break;
			case "left":
				if(spriteNum == 1) {
					image = left1;
				}
				if(spriteNum == 2) {
					image = left2;
				}
				if(spriteNum == 3) {
					image = left1;
				}
				if(spriteNum == 4) {
					image = left2;
				}
				break;
			case "right":
				if(spriteNum == 1) {
					image = right1;
				}
				if(spriteNum == 2) {
					image = right2;
				}
				if(spriteNum == 3) {
					image = right1;
				}
				if(spriteNum == 4) {
					image = right2;
				}
				break;
			case "rest":
				if(spriteNum == 1) {
					image = rest1;
				}
				if(spriteNum == 2) {
					image = rest2;
				}
				if(spriteNum == 3) {
					image = rest3;
				}
				if(spriteNum == 4) {
					image = rest4;
				}
				
			}
			g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			
		}
	

}










