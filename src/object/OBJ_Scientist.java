package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Scientist extends SuperObject {
	
	public OBJ_Scientist () {
		
		name = "Scientist";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/scientist.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setDialogue() {
		
		dialogues[0] = "info 1";
		dialogues[1] = "info 2";

		
		
	}
	
	public void speak() {
		
		
		
	}

}
