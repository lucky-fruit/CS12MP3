import java.util.*;
import java.awt.*;
import java.awt.image.*; 
import javax.swing.*;

public class Opponent extends GameObject{
	Scanner sc = new Scanner(System.in);
	Random r = new Random();
	int hp, magic, potions;
	String action;
	boolean skip;
	BufferedImage zAlive, zDead, zWin, zRest;
	ImageIcon cAttack, cSpell, cFinish, cHeal, cReload;
	public Opponent(){
		hp = 100;
		magic = 5;
		potions = 3;
		skip = false;
		action = " ";
		zAlive = MarioWindow.getImage("w1.png");
		zDead = MarioWindow.getImage("w33.png");
		zRest = MarioWindow.getImage("w35.png");
		zWin = MarioWindow.getImage("w21.png");
		cAttack = MarioWindow.getGif("Wizard-basic.gif");
		cSpell = MarioWindow.getGif("Wizard-spell.gif");
		cFinish = MarioWindow.getGif("Wizard-reckless.gif");
		cHeal = MarioWindow.getGif("Wizard-heal.gif");
		cReload = MarioWindow.getGif("Wizard-reload.gif");
	}

	public void paint(Graphics2D g, int ctr){
		g.setColor(Color.BLUE);
		if(hp<0){
			g.drawString("HP: 0", 600+ctr*80, 230);
		}
		else{
			g.drawString("HP: "+hp, 600+ctr*80, 230);
		}
		g.drawString("Magic: "+magic, 600+ctr*80, 260);
		g.drawString("Potions: "+potions, 600+ctr*80, 290);
		if(action.equals("attack")){
			cAttack.paintIcon(this, g, 550+ctr*80, 380);
		}
		else if(action.equals("spell")){
			cSpell.paintIcon(this, g, 550+ctr*80, 380);
		}
		else if(action.equals("finish")){
			cFinish.paintIcon(this, g, 600+ctr*80, 380);
		}
		else if(action.equals("heal")){
			cHeal.paintIcon(this, g, 570+ctr*80, 380);
		}
		else if(action.equals("reload")){
			cReload.paintIcon(this, g, 600+ctr*80, 380);
		}
		else if(action.equals("resting")){
			g.drawImage(zRest, 600+ctr*80, 380, null);
		}
		else if(action.equals("victory")){
			g.drawImage(zWin, 600+ctr*80, 380, null);
		}
		else if(action.equals("dead")){
			g.drawImage(zDead, 600+ctr*80, 380, null);
		}
		else{
			if(hp>0){
				g.drawImage(zAlive, 600+ctr*80, 380, null);
			}
			else if(hp<=0){
				g.drawImage(zDead, 600+ctr*80, 380, null);
			}
		}
	}

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

	//
	public void basicAttack(){
		action = "attack";
	}

	public boolean specialAttack(){
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
		action = "finish";
		skip = true;
	}

	public boolean heal(){
		if(magic>=2){
			magic -= 2;
			hp += 30;
			action = "heal";
			return true;
		}
		else{
			action = "fail";
			return false;
		}
	}

	public boolean reload(){
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

}