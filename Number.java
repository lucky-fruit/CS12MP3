import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class Number extends GameObject{
	int num;
	BufferedImage Wcard;
	public Number(){
		num = 7;
		Wcard = MarioWindow.getImage("Wizard_(card).png");
	}

	public void paint(Graphics2D g){
		g.setColor(Color.WHITE);
		g.setFont(new Font("Impact", Font.PLAIN, 15));
		if(num == 7){
			g.drawString("Opponents Left: 7", 400, 600);
			g.drawImage(Wcard, 700, 500, null);
			g.drawImage(Wcard, 675, 500, null);
			g.drawImage(Wcard, 650, 500, null);
			g.drawImage(Wcard, 625, 500, null);
			g.drawImage(Wcard, 600, 500, null);
			g.drawImage(Wcard, 575, 500, null);
			g.drawImage(Wcard, 550, 500, null);
		}
		else if(num == 6){
			g.drawString("Opponents Left: 6", 400, 600);
			g.drawImage(Wcard, 700, 500, null);
			g.drawImage(Wcard, 675, 500, null);
			g.drawImage(Wcard, 650, 500, null);
			g.drawImage(Wcard, 625, 500, null);
			g.drawImage(Wcard, 600, 500, null);
			g.drawImage(Wcard, 575, 500, null);
		}
		else if(num == 5){
			g.drawString("Opponents Left: 5", 400, 600);
			g.drawImage(Wcard, 700, 500, null);
			g.drawImage(Wcard, 675, 500, null);
			g.drawImage(Wcard, 650, 500, null);
			g.drawImage(Wcard, 625, 500, null);
			g.drawImage(Wcard, 600, 500, null);
		}
		else if(num == 4){
			g.drawString("Opponents Left: 4", 400, 600);
			g.drawImage(Wcard, 700, 500, null);
			g.drawImage(Wcard, 675, 500, null);
			g.drawImage(Wcard, 650, 500, null);
			g.drawImage(Wcard, 625, 500, null);
		}
		else if(num == 3){
			g.drawString("Opponents Left: 3", 400, 600);
			g.drawImage(Wcard, 700, 500, null);
			g.drawImage(Wcard, 675, 500, null);
			g.drawImage(Wcard, 650, 500, null);
		}
		else if(num == 2){
			g.drawString("Opponents Left: 2", 400, 600);
			g.drawImage(Wcard, 700, 500, null);
			g.drawImage(Wcard, 675, 500, null);
		}
		else if(num == 1){
			g.drawString("Opponents Left: 1", 400, 600);
			g.drawImage(Wcard, 700, 500, null);
		}
		else if(num == 0){
			g.drawString("Opponents Left: 0", 400, 600);
		}
	}
}