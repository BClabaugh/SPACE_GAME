package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.GamePanel;

public class ALAN extends Entity{
	
	GamePanel gp;
	int stepCounter = 0;
	
	
	public  ALAN(GamePanel gp) {
		this.gp = gp;
		
		setDefaultValues();
		getAlanImage();
	}
	public void setDefaultValues() {
		
		x = 450;
		y = 250;
		speed = 1;
		direction = "down";
		
	}
	public void getAlanImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/alan/UpAl1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/alan/UpAl2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/alan/DownAl1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/alan/DownAl2.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		
		switch(direction) {
		case "up":
			y -= speed;
			break;
		case "down":
			y += speed;
			break;
		}
		if(stepCounter > 70) {
			if(direction == "down") {
				direction = "up";
			} else if(direction == "up") {
				direction = "down";
			}
			stepCounter = 0;
		}
		stepCounter++;
		spriteCounter++;
		if(spriteCounter > 15) {
			if(spriteNum == 1) {
				spriteNum = 2;
			} 
			else if(spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
	}
	
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
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
			break;
		}
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	}


}
