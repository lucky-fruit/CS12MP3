import java.util.*;
import java.awt.*;
import java.awt.image.*; 
import javax.swing.*;
public class CS12MP3PinedaLance{
	public static void main (String [] args) throws InterruptedException{
		Scanner sc = new Scanner(System.in);
		Hero h = new Hero();
		Opponent o;
		Environment e = new Environment();
		Buttons b = new Buttons();
		//Number n = new Number();
		Opponents q = new Opponents();

		final MarioWindow w1 = new MarioWindow();
		w1.add(e);
		//w1.add(n);
		w1.add(h);
		w1.add(q);
		w1.add(b);
		(new Thread(){
			public void run(){
				w1.startGame();
			}
		}).start();

		while(h.hp>0 && !q.q.isEmpty()){
			o = q.q.head.data;
			h.action = " ";
			e.text = " ";
			System.out.println("A. Basic Attack\nB. Special Attack\nC. Reckless Attack\nD. Heal\nE. Recharge\n");
			//System.out.print("Enter option: ");
			String option = " ";

		if(h.skip == false){
			while(true){
				w1.delay(1);
				if(b.pressed!=0){
					break;
				}
			}
			

				if(option.equalsIgnoreCase("A") || b.pressed == 1){
					e.text = "hbasic";
					h.basicAttack();
					Thread.sleep(800);
					h.bAttack.getImage().flush();
					h.action = " ";
					q.choice = 1;
					q.attackFront();
					System.out.println("Dealt damage [-10]");
					b.pressed = 0;
				}

				else if(option.equalsIgnoreCase("B") || b.pressed == 2){
					if(h.specialAttack() == true){
						//if(o.specialAttacked()){
							q.choice = 2;
							q.attackFront();
							e.text = "hspell";
							Thread.sleep(800);
							h.bSpell.getImage().flush();
							h.action = " ";
							System.out.println("Dealt damage [-20]");
						//}
						//else{
						//	e.text = "hmissed";
						//	System.out.println("Missed");
						//}
					}
					else{
						e.text = "hmagic";
						System.out.println("Not enough magic");
						w1.delay(1000);
						b.pressed = 0;
						continue;
					}
					b.pressed = 0;
				}

				else if(option.equalsIgnoreCase("C") || b.pressed == 3){
					//if(o.recklessAttacked()){
						q.choice = 3;
						q.attackFront();
						e.text = "hreckless";
						h.recklessAttack();
						Thread.sleep(800);
						h.bFinish.getImage().flush();
						h.action = " ";
						System.out.println("Dealt heavy damage [-40]");
					/*
					else{
						e.text = "hmissed";
						h.skip = true;
						System.out.println("Missed");
					}*/
					b.pressed = 0;
				}

				else if(option.equalsIgnoreCase("D") || b.pressed == 4){
					if(h.hp+50>500){
						e.text = "hhp";
						System.out.println("HP is full");
						w1.delay(1000);
						b.pressed = 0;
						continue;
					}
					if(h.heal()){
						e.text = "hheal";
						Thread.sleep(800);
						h.bHeal.getImage().flush();
						h.action = " ";
						System.out.println("Healed (+50)");
					}
					else{
						e.text = "hmagic";
						System.out.println("Not enough magic");
						w1.delay(1000);
						b.pressed = 0;
						continue;
					}
					b.pressed = 0;
				}

				else if(option.equalsIgnoreCase("E") || b.pressed == 5){
					if(h.magic == 5){
						e.text = "magicful";
						System.out.println("Magic is full!");
						w1.delay(1000);
						b.pressed = 0;
						continue;
					}
					else{
						if(h.reload()){
							e.text = "hreload";
							Thread.sleep(1000);
							h.bReload.getImage().flush();
							h.action = " ";
							System.out.println("Replenished magic");
						}
						else{
							e.text = "hpotions";
							System.out.println("Out of potions");
							w1.delay(1000);
							b.pressed = 0;
							continue;
						}
					}
					b.pressed = 0;
				}

				else{
					e.text = "option";
					System.out.println("Enter an option");
					w1.delay(1000);
					b.pressed = 0;
					continue;
				}
			}
		


			else{
				e.text = "hresting";
				h.action = "resting";
				h.skip = false;
				System.out.println("Resting");
				b.pressed = 0;
			}

			w1.delay(1000);

			/*if(o.hp <= 0){
				n.num -= 1;
				o.action = "dead";
				e.text = "defeat";
				w1.delay(1000);
				if(n.num < 1){
					o.action = " ";
					e.text = "hvictory";
					h.action = "victory";
					w1.delay(1000);
					break;
				}
				else{
					o.action = " ";
					o.hp = 100;
					o.magic = 8;
					o.potions = 3;
					o.skip = false;
					continue;
				}
			}
			*/
		
			if(o.skip == false){
				if(o.magic <= 2){
					if(o.reload()){
						e.text = "oreload";
						Thread.sleep(1000);
						o.cReload.getImage().flush();
						o.action = " ";
						System.out.println("Enemy replenished magic");
						w1.delay(1000);
						continue;
					}
					else{
						e.text = "opotions";
						System.out.println("Enemy is out of potions");
					}
				}

				if(o.hp<30){
					if(o.heal()){
						e.text = "oheal";
						Thread.sleep(800);
						o.cHeal.getImage().flush();
						o.action = " ";
						System.out.println("Enemy healed [+30]");
						w1.delay(1000);
						continue;
					}
					else{
						e.text = "omagic";
						System.out.println("Enemy does not have enough magic");	
					}
				}

				if(o.hp>=80){
					e.text = "obasic";
					o.basicAttack();
					Thread.sleep(800);
					o.cAttack.getImage().flush();
					o.action = " ";
					h.basicAttacked();
					System.out.println("Took damage (-10)");
				}

				else if(o.hp<80 && o.hp>=50){
					if(o.specialAttack()){
						if(h.specialAttacked()){
							e.text = "ospell";
							Thread.sleep(800);
							o.cSpell.getImage().flush();
							o.action = " ";
							System.out.println("Took damage (-20)");
						}
						else{
							e.text = "omissed";
							System.out.println("Dodged");
						}
					}
					else{
						e.text = "omagic";
						System.out.println("Enemy does not have enough magic");
						w1.delay(1000);
						continue;
					}
				}

				else{
					if(h.recklessAttacked()){
						e.text = "oreckless";
						o.recklessAttack();
						Thread.sleep(800);
						o.cFinish.getImage().flush();
						o.action = " ";
						System.out.println("Took heavy damage (-40)");
					}
					else{
						e.text = "omissed";
						o.skip = true;
						System.out.println("Dodged");
					}	
				}
			}

			else{
				e.text = "oresting";
				o.action = "resting";
				o.skip = false;
				System.out.println("Enemy is resting");
			}

			w1.delay(1000);

			if(h.hp <= 0){
				h.action = "dead";
				e.text = "ovictory";
				o.action = "victory";
				w1.delay(1000);
				break;
			}

		}

	}
}