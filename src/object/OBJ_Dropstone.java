package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Dropstone extends SuperObject {
	
	public OBJ_Dropstone () {
		
		name = "Dropstone";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/dropstone.png"));
			
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
