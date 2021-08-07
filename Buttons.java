import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Buttons extends GameObject{
	BufferedImage a, b, c, d, e, f;
	int pressed;

	public Buttons(){
		a = MarioWindow.getImage("A.png");
		b = MarioWindow.getImage("B.png");
		c = MarioWindow.getImage("C.png");
		d = MarioWindow.getImage("D.png");
		e = MarioWindow.getImage("E.png");
		f = MarioWindow.getImage("F.png");
		pressed = 0;
	}

	public void paint(Graphics2D g){
		g.drawImage(a, 200, 250, null);
		g.drawImage(b, 300, 250, null);
		g.drawImage(c, 400, 250, null);
		g.drawImage(d, 200, 350, null);
		g.drawImage(e, 300, 350, null);
		//g.drawImage(f, 400, 350, null);
	}

	public void mouseClicked(int xmouse, int ymouse, int button){
		if((xmouse>=200)&&(xmouse<=200+100)&&(ymouse>=250)&&(ymouse<=250+100)){
			//System.out.println("Pressed A");
			pressed = 1;
		}
		else if((xmouse>=300)&&(xmouse<=300+100)&&(ymouse>=250)&&(ymouse<=250+100)){
			//System.out.println("Pressed B");
			pressed = 2;
		}
		else if((xmouse>=400)&&(xmouse<=400+100)&&(ymouse>=250)&&(ymouse<=250+100)){
			//System.out.println("Pressed C");
			pressed = 3;
		}
		else if((xmouse>=200)&&(xmouse<=200+100)&&(ymouse>=350)&&(ymouse<=350+100)){
			//System.out.println("Pressed D");
			pressed = 4;
		}
		else if((xmouse>=300)&&(xmouse<=300+100)&&(ymouse>=350)&&(ymouse<=350+100)){
			//System.out.println("Pressed E");
			pressed = 5;
		}
		//else if((xmouse>=400)&&(xmouse<=400+100)&&(ymouse>=350)&&(ymouse<=350+100)){
		//	System.out.println("Pressed F");
		//	pressed = 6;
		//}
		else{
			System.out.println("Pressed");
			pressed = 0;
		}
	}
}