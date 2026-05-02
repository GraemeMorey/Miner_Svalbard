package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Fossil extends SuperObject {
	
	public OBJ_Fossil () {
		
		name = "Fossil";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/fossil.png"));
			
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
