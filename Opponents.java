import java.util.*;
import java.awt.*;
import java.awt.image.*; 
import javax.swing.*;

public class Opponents extends GameObject{
	LinkedQueue q = new LinkedQueue();
	Random r=new Random();
	int choice = 0;

	public Opponents(){
		Opponent o1 = new Opponent();
		Opponent o2 = new Opponent();
		Opponent o3 = new Opponent();
		q.enqueue(o1);
		q.enqueue(o2);
		q.enqueue(o3);
	}


	public void paint(Graphics2D g){
		int ctr = q.visualizeQueue(g);
		g.setFont(new Font("Impact", Font.BOLD, 20));
		g.drawString("Enemies left: "+ctr, 500, 500);
	}

	public void run() {
	    while(true) {
	        MarioWindow.delay(10000);
	        int random = r.nextInt(100)+1;
	        if (random <= 50) {
	            Opponent arriving = new Opponent(); 
	            q.enqueue(arriving);
	            System.out.println("Another enemy has spawned!");
	        }
	    }
	}

	    // sample only. You would have a more complicated version
	public void attackFront() {
	 	Opponent front = q.peek();
	   	System.out.println(q.isEmpty());
	    if (q.isEmpty()) {
	        System.out.println("You win!");
	        System.exit(0);
	    } 
	    else {
	    	if(choice == 1){
	    		System.out.println(front.hp);
	    		front.basicAttacked();
	    	}
	    	else if(choice == 2){
	    		System.out.println(front.hp);
	    		front.specialAttacked();
	    	}
	    	else if(choice == 3){
	    		System.out.println(front.hp);
	    		front.recklessAttacked();
	    	}
	    }
	    if (front.hp == 0) {
	        System.out.println("You have vanquished an enemy!");
	        q.dequeue();
	        
	    }
	}

	public Opponent choseFront(){
		return q.peek();
	}

}