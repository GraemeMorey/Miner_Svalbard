package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	public boolean upPressed, downPressed, leftPressed, rightPressed, rest, next, stop;

	@Override
	public void keyPressed(KeyEvent e) {

			int code = e.getKeyCode();
			
			if(code == KeyEvent.VK_W) {
				upPressed = true;
			}
			if(code == KeyEvent.VK_S) {
				downPressed = true;
			}
			if(code == KeyEvent.VK_A) {
				leftPressed = true;
			}
			if(code == KeyEvent.VK_D) {
				rightPressed = true;
			}
			if(code == KeyEvent.VK_N) {
				next = true;
			}
			if(code == KeyEvent.VK_M) {
				stop = true;
			}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			upPressed = false;
			rest = true;
		}
		if(code == KeyEvent.VK_S) {
			downPressed = false;
			rest = true;
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = false;
			rest = true;
		}
		if(code == KeyEvent.VK_D) {
			rightPressed = false;
			rest = true;
		}
		if(code == KeyEvent.VK_N) {
			next = false;
		}
		if(code == KeyEvent.VK_M) {
			stop = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {		
	}
	


}