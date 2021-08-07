import java.util.*;
import java.awt.*;
import java.awt.image.*; 
import javax.swing.*;

public class Hero extends GameObject{
	Scanner sc = new Scanner(System.in);
	Random r = new Random();
	int choice;
	String action;
	int hp, magic, potions;
	boolean skip;
	BufferedImage pAlive, pDead, pWin, pRest;
	ImageIcon bAttack, bSpell, bFinish, bHeal, bReload;

	public Hero(){
		choice = 0;
		hp = 500;
		magic = 5;
		potions = 10;
		skip = false;
		action = " ";
		pAlive = MarioWindow.getImage("Sora-idle.png");
		pDead = MarioWindow.getImage("Sora-dead.png");
		pRest = MarioWindow.getImage("srest.png");
		pWin = MarioWindow.getImage("svictor.png");
		bAttack = MarioWindow.getGif("Sora-basic.gif");
		bSpell = MarioWindow.getGif("Sora-spell.gif");
		bFinish = MarioWindow.getGif("Sora-reckless.gif");
		bHeal = MarioWindow.getGif("Sora-heal.gif");
		bReload = MarioWindow.getGif("Sora-reload.gif");
	}

	public void paint(Graphics2D g){
		g.setColor(Color.RED);
		g.setFont(new Font("Impact", Font.PLAIN, 15));
		if(hp<0){
			g.drawString("HP: 0", 50, 230);
		}
		else{
			g.drawString("HP: "+hp, 50, 230);
		}
		//g.drawString("HP: "+hp, 50, 230);
		g.drawString("Magic: "+magic, 50, 260);
		g.drawString("Potions: "+potions, 50, 290);
		if(action.equals("attack")){
			bAttack.paintIcon(this, g, 50, 400);
		}
		else if(action.equals("spell")){
			bSpell.paintIcon(this, g, 50, 390);
		}
		else if(action.equals("finish")){
			bFinish.paintIcon(this, g, 50, 350);
		}
		else if(action.equals("heal")){
			bHeal.paintIcon(this, g, 50, 370);
		}
		else if(action.equals("reload")){
			bReload.paintIcon(this, g, 50, 350);
		}
		else if(action.equals("resting")){
			g.drawImage(pRest, 50, 400, null);
		}
		else if(action.equals("victory")){
			g.drawImage(pWin, 50, 370, null);
		}
		else if(action.equals("dead")){
			g.drawImage(pDead, 80, 420, null);
		}
		else{
			if(hp>0){
				g.drawImage(pAlive, 50, 380, null);
			}
			else if(hp<=0){
				g.drawImage(pDead, 80, 400, null);
			}
		}

	}

	public void basicAttack(){
		action = "attack";
		choice = 1;
	}

	public boolean specialAttack(){
		choice = 2;
		if(magic>0){
			magic -= 1;
			action = "spell";
			return true;
		}
		else{
			action = "fail";
			return false;
		}
	}

	public void recklessAttack(){
		choice = 3;
		action = "finish";
		skip = true;
	}

	public boolean heal(){
		choice = 4;
		if(magic>=2){
			magic -= 2;
			hp += 50;
			action = "heal";
			return true;
		}
		else{
			action = "fail";
			return false;
		}
	}

	public boolean reload(){
		choice = 5;
		if(potions>0){
			potions -= 1;
			magic = 5;
			action = "reload";
			return true;
		}
		else{
			action = "fail";
			return false;
		}
	}

	//
	public void basicAttacked(){
		hp -= 10;
	}

	public boolean specialAttacked(){
		int chance = r.nextInt(100) + 1;
		if(chance<=80){
			hp -= 20;
			return true;
		}
		else{
			return false;
		}
	}

	public boolean recklessAttacked(){
		int chance = r.nextInt(100) + 1;
		if(chance<=50){
			hp -= 40;
			return true;
		}
		else{
			return false;
		}
	}
	
}