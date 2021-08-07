import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
public class Environment extends GameObject{
	BufferedImage dbox;
	BufferedImage bg;
	String text;
	int ctr=0;
	public Environment(){
		text = " ";
		dbox = MarioWindow.getImage("dbox2.png");
		bg = MarioWindow.getImage("ground.png");
	}

	public void paint(Graphics2D g){
		g.setColor(Color.BLACK);
		g.setFont(new Font("Impact", Font.PLAIN, 18));
		g.drawImage(bg, 0, 0, null);
		g.drawImage(dbox, 80, 50, null);
		if(text.equals("hbasic")){
			g.drawString("Sora attacks!", 110, 90);
			g.drawString("[Enemy: -10HP]",110,110);
		}
		if(text.equals("obasic")){
			g.drawString("Enemy attacks!", 110, 90);
			g.drawString("(Sora: -10HP)",110,110);
		}
		if(text.equals("hspell")){
			g.drawString("Sora casts a spell!", 110, 90);
			g.drawString("[Enemy: -20HP]",110,110);
		}
		if(text.equals("ospell")){
			g.drawString("Enemy casts a spell!", 110, 90);
			g.drawString("(Sora: -20HP)",110,110);
		}
		if(text.equals("hreckless")){
			g.drawString("Sora moves in to strike!", 110, 90);
			g.drawString("[Enemy: -40HP]",110,110);
		}
		if(text.equals("oreckless")){
			g.drawString("Enemy moves in to strike!", 110, 90);
			g.drawString("(Sora: -40HP)",110,110);
		}
		if(text.equals("hheal")){
			g.drawString("Sora casts Cure!", 110, 90);
			g.drawString("(Sora: +30HP)",110,110);
		}
		if(text.equals("oheal")){
			g.drawString("Enemy casts Cure!", 110, 90);
			g.drawString("[Enemy: =30HP]",110,110);
		}
		if(text.equals("hreload")){
			g.drawString("Sora uses a potion!", 110, 90);
		}
		if(text.equals("oreload")){
			g.drawString("Enemy recharges magic!", 110, 90);
		}
		if(text.equals("hmagic")){
			g.drawString("Sora does not have enough magic", 110, 90);
		}
		if(text.equals("hhp")){
			g.drawString("HP is full!", 110, 90);
		}
		if(text.equals("magicful")){
			g.drawString("Magic is full!", 110, 90);
		}
		if(text.equals("omagic")){
			g.drawString("Enemy does not have enough magic", 110, 90);
		}
		if(text.equals("hpotions")){
			g.drawString("Sora is out of potions", 110, 90);
		}
		if(text.equals("opotion")){
			g.drawString("Enemy is out of potions", 110, 90);
		}
		if(text.equals("hmissed")){
			g.drawString("Sora's attack misses!", 110, 90);
		}
		if(text.equals("omissed")){
			g.drawString("Enemy's attack misses!", 110, 90);
		}
		if(text.equals("hresting")){
			g.drawString("Sora is resting", 110, 90);
		}
		if(text.equals("oresting")){
			g.drawString("Enemy is resting", 110, 90);
		}
		if(text.equals("hvictory")){
			g.drawString("Sora has defeated all!", 110, 90);
		}
		if(text.equals("ovictory")){
			g.drawString("The Heartless win...", 110, 90);
		}
		if(text.equals("option")){
			g.drawString("Enter a valid option", 110, 90);
		}
		if(text.equals("defeat")){
			g.drawString("Defeated an enemy", 110, 90);
		}
		if(text.equals(" ")){
			g.drawString("--A. Basic Attack", 110, 90);
			g.drawString("--B. Special Attack", 110, 110);
			g.drawString("--C. Reckless Attack", 110, 130);
			g.drawString("--D. Heal", 110, 150);
			g.drawString("--E. Recharge", 110, 170);
		}
	}	
}