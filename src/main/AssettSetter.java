package main;

import object.OBJ_Coal;
import object.OBJ_Dropstone;
import object.OBJ_Fossil;
import object.OBJ_Microfossil;
import object.OBJ_Scientist;

public class AssettSetter {
	
	GamePanel gp;
	
	public AssettSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		
		gp.obj[0] = new OBJ_Coal();
		gp.obj[0].worldX = 5 * gp.tileSize;
		gp.obj[0].worldY = 34 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Dropstone();
		gp.obj[1].worldX = 8 * gp.tileSize;
		gp.obj[1].worldY = 24 * gp.tileSize;
		
		gp.obj[2] = new OBJ_Fossil();
		gp.obj[2].worldX = 17 * gp.tileSize;
		gp.obj[2].worldY = 22 * gp.tileSize;
		
		gp.obj[3] = new OBJ_Microfossil();
		gp.obj[3].worldX = 32 * gp.tileSize;
		gp.obj[3].worldY = 33 * gp.tileSize;
		
		gp.obj[4] = new OBJ_Coal();
		gp.obj[4].worldX = 32 * gp.tileSize;
		gp.obj[4].worldY = 26 * gp.tileSize;
		
		gp.obj[5] = new OBJ_Dropstone();
		gp.obj[5].worldX = 22 * gp.tileSize;
		gp.obj[5].worldY = 7 * gp.tileSize;
		
		gp.obj[6] = new OBJ_Fossil();
		gp.obj[6].worldX = 40 * gp.tileSize;
		gp.obj[6].worldY = 8 * gp.tileSize;
		
		gp.obj[7] = new OBJ_Scientist();
		gp.obj[7].worldX = 45 * gp.tileSize;
		gp.obj[7].worldY = 8 * gp.tileSize;
		
		gp.obj[8] = new OBJ_Microfossil();
		gp.obj[8].worldX = 31 * gp.tileSize;
		gp.obj[8].worldY = 1 * gp.tileSize;
		
		gp.obj[9] = new OBJ_Coal();
		gp.obj[9].worldX = 7 * gp.tileSize;
		gp.obj[9].worldY = 6 * gp.tileSize;
		
		gp.obj[10] = new OBJ_Dropstone();
		gp.obj[10].worldX = 20 * gp.tileSize;
		gp.obj[10].worldY = 1 * gp.tileSize;
		
		gp.obj[11] = new OBJ_Fossil();
		gp.obj[11].worldX = 3 * gp.tileSize;
		gp.obj[11].worldY = 16 * gp.tileSize;
		
		gp.obj[12] = new OBJ_Microfossil();
		gp.obj[12].worldX = 14 * gp.tileSize;
		gp.obj[12].worldY = 33 * gp.tileSize;
		
		
		//continue to do this for another object when I want (new object or still obj_coal
		
	}

}
