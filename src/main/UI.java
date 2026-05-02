package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.OBJ_Coal;
import object.OBJ_Dropstone;
import object.OBJ_Fossil;
import object.OBJ_Microfossil;
import object.OBJ_Scientist;

public class UI {
	
	//handle on screen text messages and item icons

	KeyHandler keyH;

	GamePanel gp;
	Font arial_40;
	BufferedImage coalImage;
	BufferedImage scientistImage;
	BufferedImage dropstoneImage;
	BufferedImage fossilImage;
	BufferedImage microfossilImage;
	public boolean messageOn = false;
	public String currentDialogue = "";
	public static int messageCounter = 0;
	int newObject = 0;
	String coalFact1[] = {"You found coal! Coal is formed when organic /nplant material decays into peat and is /ncompressed over long periods of time. Finding /ncoal on Svalbard helps scientists understand /nwhen periods of high vegetation occurred."};
	String coalFact2[] = {"You found another piece of coal! Coal seams in Svalbard have been dated all /nthe way back in the Devonian (419 – 359 million years ago). This means that /nback then, Svalbard was a humid tropical landscape, resulting in such /nprominent coal deposits. Some coal deposits from the Paleocene (around /n61.8 million years ago) have much greater detail because peat was formed in /ncolder conditions than the Devonian."};
	String coalFact3[] = {"You found the final piece of coal! High resolution coal deposits /ncan reveal information on wildfires, carbon cycling, and peat /naccumulation rates. When combined with other evidence of past /nclimate and environments, coal is a critical component to /nunderstanding past climate."};

	String microfossilFact1[] = {"You found a coccolithophore! A coccolithophore is a single-celled /nphytoplankton, whose shell is sometimes preserved as a /nmicrofossil. Microfossils are valuable evidence for past climates, /nas different organisms indicate different climatic and /ngeological histories, such as sea ice and temperature."};
	String microfossilFact2[] = {"You found another coccolithophore! Coccolithophore microfossils are /nfound mostly in open marine environment deposits and can tell us /nabout past sea surface conditions, such as the presence of ice. /nHigh presence of coccolithophores can indicate periods of high /nocean productivity, while a lack of coccolithophores may be due to low /nlight availability because of extensive sea ice."};
	String microfossilFact3[] = {"You found the last coccolithophore! Coccolithophore microfossils dated /nto the Holocene (11 thousand years ago to present) and both their /nabundance and species composition indicate that the warm flow /nof Atlantic waters and increased sea temperatures has been /noccurring since the Holocene. Their presence across the geological /nrecord help scientists reconstruct past sea surface conditions."};
	
	String dropstoneFact1[] = {"You found a dropstone! Dropstones are large sedimentary /nstructures, such as rocks or boulders (i.e. clasts), that are /nsurrounded by fine-grained sediment types that appear /nunrelated to these clasts. Why are the dropstones there?"};
	String dropstoneFact2[] = {"You found another dropstone! Dropstones are believed to /nhave been transported by ice, which has broken off from a /nglacial front and been transported out to the ocean before /nmelting out of the ice and dropping out and settling onto the sea /nsediment."};
	String dropstoneFact3[] = {"You found the last dropstone! Finding dropstones has helped /nresearchers determine that frequent ice rafting occurred /naround Svalbard and Greenland. This helps us understand /nthe extent of ice cover and the temperatures of that time period /nof 55 – 23 million years ago."};

	String fossilFact1[] = {"You found a ginkgo fossil! Plant fossils were found among coal /ndeposits in Svalbard as early as 1850. The presence of /nplant fossils can provide significant information about the climate, /nsoil quality, nutrients, seed dispersal, and age of the /nsediment the plant fossils are found in."};
	String fossilFact2[] = {"You found another ginkgo fossil! Around Barentsburg, /napproximately 50 species of ginkgos, ferns, conifers, and /nangiosperms were found in the sediment. Scientists can use /nnumerous leaf characteristics, such as size and lobation, /nto reconstruct past climate. "};
	String fossilFact3[] = {"You found the last gingko fossil! The sediment where plant fossils were found /nwas dated to the early Paleocene (around 61.8 million years ago). Using plant /nfossils, scientists determined that the average annual temperature in Svalbard/n at the time was 10.1 celcius. Summer averages reached 19.2 celcius and winter /naverages reached 1.7 celcius. The growing season lasted 6 months and /nprecipitation was 572mm with high humidity."};


	
	String[] scientistFacts = {"You found the scientist! Scientists play an important /nrole in revealing what different climatic proxies can tell us /nabout the past and how it can be applied to the future.", "Some proxies, such as biogeochemical proxies, are complex to /nunderstand and require significant work by scientists. Biomarkers, /nfor example, are chemical fossils, molecules that have been /nbiologically produced, but are the only evidence remaining. /nThese can include proteins, lipids, and carbohydrates.", "One example is IP25, which is a biomarker produced by a /nspecific phytoplankton that grows where the ice margin is. /nIf scientists find IP25 in the sediment, it could mean that sea ice /noccurred there but would melt in the spring.", "However, scientists need to be careful and need to combine /nseveral proxies together to be sure of their interpretations of /npast climate. They have a difficult job!"};
	int factCount = 0;
	int coal = 0;
	int microfossil = 4;
	String object = "";
	int microfossilFactCount = 0;
//	String coalFact1 = "info 1";
//	String coalFact2 = "info 2";
//	String coalFact3 = "info 3";

//    String dialogues[] = new String[20];

	
    
//public void setDialogue() {
//		
//		dialogues[0] = "info 1";
//		dialogues[1] = "info 2";
//
//		
//		
//	}

	public static int on = 0;
	int off = 0;
	int check = 0;
	
	
	public UI(GamePanel gp) {
		this.gp = gp;
		arial_40 = new Font("Arial", Font.PLAIN, 30);
		OBJ_Coal coal = new OBJ_Coal();
		coalImage = coal.image;
		OBJ_Scientist scientist = new OBJ_Scientist();
		scientistImage = scientist.image;
		OBJ_Dropstone dropstone = new OBJ_Dropstone();
		dropstoneImage = dropstone.image;
		OBJ_Fossil fossil = new OBJ_Fossil();
		fossilImage = fossil.image;
		OBJ_Microfossil microfossil = new OBJ_Microfossil();
		microfossilImage = microfossil.image;
	}
	
	public void showMessage (String text) {
		
		currentDialogue = text;
		messageOn = true;
		newObject ++;
		
		
		

		
	}
	
	
	
	public void draw (Graphics2D g2) {
		
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		g2.drawImage(coalImage, gp.tileSize/2,  gp.tileSize/2, gp.tileSize,  gp.tileSize, null);
		g2.drawString ("x " + gp.player.hasCoal + "/3", 74, 65);
		g2.drawImage(scientistImage, gp.tileSize/2,  (gp.tileSize/2)+200, gp.tileSize,  gp.tileSize, null);
		g2.drawString ("x " + gp.player.scientistCount + "/1", 74, 265);
		g2.drawImage(dropstoneImage, gp.tileSize/2,  (gp.tileSize/2)+50, gp.tileSize,  gp.tileSize, null);
		g2.drawString ("x " + gp.player.dropstoneCount + "/3", 74, 115);
		g2.drawImage(fossilImage, gp.tileSize/2,  (gp.tileSize/2)+100, gp.tileSize,  gp.tileSize, null);
		g2.drawString ("x " + gp.player.fossilCount + "/3", 74, 165);
		g2.drawImage(microfossilImage, gp.tileSize/2,  (gp.tileSize/2)+150, gp.tileSize,  gp.tileSize, null);
		g2.drawString ("x " + gp.player.microfossilCount + "/3", 74, 215);
		
		
//		if(gp.keyH.next==true) {
//			int x = gp.tileSize*3;
//			int y = gp.tileSize - 30;
//			int width = gp.screenWidth - (gp.tileSize*4);
//			int height = gp.tileSize*5;
//			
//			Color c = new Color(0,0,0,200);
//			g2.setColor(c);
//			g2.fillRoundRect(x, y, width, height, 35, 35);
//			
//			g2.setColor(Color.white);
//			g2.setStroke(new BasicStroke(5));
//			g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
//			
//			x += gp.tileSize;
//			y += gp.tileSize;
//			g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 25));
//		}
		
		//coal message 1
		
//		while(on ==0 && messageOn == true && newObject != 0 && gp.player.coalFactIndicator == 1 && gp.player.coal == 1) {
//			coal = 0;
//			int x = gp.tileSize*3;
//			int y = gp.tileSize - 30;
//			int width = gp.screenWidth - (gp.tileSize*4);
//			int height = gp.tileSize*5;
//			
//			Color c = new Color(0,0,0,200);
//			g2.setColor(c);
//			g2.fillRoundRect(x, y, width, height, 35, 35);
//			
//			g2.setColor(Color.white);
//			g2.setStroke(new BasicStroke(5));
//			g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
//			
//			x += gp.tileSize;
//			y += gp.tileSize;
//			g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 25));
//			
//			for(String line: coalFact1[0].split("/n")) {
//				g2.drawString(line, x, y);
//				y+=40;
//
//		}
//			if(on ==1) {
//				break;
//			}
//		}
		
		
		if(messageOn == true && newObject != 0 && gp.player.coalFactIndicator == 1 && gp.player.coal == 1) {
			

			
			coal = 0;
			int x = gp.tileSize*3;
			int y = gp.tileSize - 30;
			int width = gp.screenWidth - (gp.tileSize*4);
			int height = gp.tileSize*5;
			
			Color c = new Color(0,0,0,200);
			g2.setColor(c);
			g2.fillRoundRect(x, y, width, height, 35, 35);
			
			g2.setColor(Color.white);
			g2.setStroke(new BasicStroke(5));
			g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
			
			x += gp.tileSize;
			y += gp.tileSize;
			g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 25));
			
			for(String line: coalFact1[0].split("/n")) {
				g2.drawString(line, x, y);
				y+=40;

			}
			
			
			messageCounter ++;
			
			if(messageCounter  > 24000) {
				factCount++;
				messageCounter = 0;
			}
			if(factCount == coalFact1.length) {
				messageOn = false;
				factCount = 0;
				newObject = 0;
				}
			messageCounter ++;
			if(gp.keyH.next==true) {
				messageCounter = 100000000;
			}
			gp.keyH.next = false;
			
		}
		
		
		
		//coal message 2
				if(messageOn == true && newObject != 0 && gp.player.coalFactIndicator == 2 && gp.player.coal == 1) {
					coal = 0;
					int x = gp.tileSize*3;
					int y = gp.tileSize - 30;
					int width = gp.screenWidth - (gp.tileSize*4);
					int height = gp.tileSize*5;
					
					Color c = new Color(0,0,0,200);
					g2.setColor(c);
					g2.fillRoundRect(x, y, width, height+15, 35, 35);
					
					g2.setColor(Color.white);
					g2.setStroke(new BasicStroke(5));
					g2.drawRoundRect(x+5, y+5, width-10, height+10, 25, 25);
					
					x += gp.tileSize;
					y += gp.tileSize;
					g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 15));
					
					for(String line: coalFact2[0].split("/n")) {
						g2.drawString(line, x, y-10);
						y+=40;

					}					
					messageCounter ++;
					
					if(messageCounter  > 42000) {
						factCount++;
						messageCounter = 0;
					}
					if(factCount == coalFact2.length) {
						messageOn = false;
						factCount = 0;
						newObject = 0;
						}
					messageCounter ++;
					
					if(gp.keyH.next==true) {
						messageCounter = 100000000;
					}
					gp.keyH.next = false;
					
				}
				
			//coal message 3
				if(messageOn == true && newObject != 0 && gp.player.coalFactIndicator == 3 && gp.player.coal == 1) {
					coal = 0;
					int x = gp.tileSize*3;
					int y = gp.tileSize - 30;
					int width = gp.screenWidth - (gp.tileSize*4);
					int height = gp.tileSize*5;
					
					Color c = new Color(0,0,0,200);
					g2.setColor(c);
					g2.fillRoundRect(x, y, width, height, 35, 35);
					
					g2.setColor(Color.white);
					g2.setStroke(new BasicStroke(5));
					g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
					
					x += gp.tileSize;
					y += gp.tileSize;
					g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 18));
					
					for(String line: coalFact3[0].split("/n")) {
						g2.drawString(line, x, y-10);
						y+=40;
					}
					messageCounter ++;
					
					if(messageCounter  > 30000) {
						factCount++;
						messageCounter = 0;
					}
					if(factCount == coalFact3.length) {
						messageOn = false;
						factCount = 0;
						newObject = 0;
						}
					messageCounter ++;
					if(gp.keyH.next==true) {
						messageCounter = 100000000;
					}
					gp.keyH.next = false;
					
				}
		
				
		
		//microfossil fact 1
				
		
		
		
				
		if (messageOn == true && newObject != 0 && gp.player.microfossilFactIndicator == 1 && gp.player.microfossil == 1) {
			int x = gp.tileSize*3;
			int y = gp.tileSize - 30;
			int width = gp.screenWidth - (gp.tileSize*4);
			int height = gp.tileSize*5;
			
			Color c = new Color(0,0,0,200);
			g2.setColor(c);
			g2.fillRoundRect(x, y, width, height, 35, 35);
			
			g2.setColor(Color.white);
			g2.setStroke(new BasicStroke(5));
			g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
			
			x += gp.tileSize;
			y += gp.tileSize;
			g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 18));
			for(String line: microfossilFact1[0].split("/n")) {
				g2.drawString(line, x, y);
				y+=40;

			}
			
			messageCounter ++;
			
//if(keyH.next == true) {
//				
//				messageCounter = 5000;
//			}
			
			if(on == 1 || messageCounter  > 30000) {
				factCount++;
				messageCounter = 0;
			}
			if(on == 1 || factCount == microfossilFact1.length) {
				messageOn = false;
				factCount = 0;
				newObject = 0;
				}
			messageCounter ++;
//			
//			if(keyH.next == true) {
//			}
			

			}
		if(gp.keyH.next==true) {
			messageCounter = 100000000;
		}
		gp.keyH.next = false;
		//microfossil message 2
		
		
		
		
		
		
		if(messageOn == true && newObject != 0 && gp.player.microfossilFactIndicator == 2 && gp.player.microfossil == 1) {
			int x = gp.tileSize*3;
			int y = gp.tileSize - 30;
			int width = gp.screenWidth - (gp.tileSize*4);
			int height = gp.tileSize*5;
			
			Color c = new Color(0,0,0,200);
			g2.setColor(c);
			g2.fillRoundRect(x, y, width, height+10, 35, 35);
			
			g2.setColor(Color.white);
			g2.setStroke(new BasicStroke(5));
			g2.drawRoundRect(x+5, y+5, width-10, height+10, 25, 25);
			
			x += gp.tileSize;
			y += gp.tileSize;
			g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 17));
			
			for(String line: microfossilFact2[0].split("/n")) {
				g2.drawString(line, x, y-5);
				y+=40;

			}			
			messageCounter ++;
			
			if(messageCounter  > 42000) {
				factCount++;
				messageCounter = 0;
			}
			if(factCount == microfossilFact2.length) {
				messageOn = false;
				factCount = 0;
				newObject = 0;
				}
			messageCounter ++;
			
			if(gp.keyH.next==true) {
				messageCounter = 100000000;
			}
			gp.keyH.next = false;
		}
		//microfossil message 3
				if(messageOn == true && newObject != 0 && gp.player.microfossilFactIndicator == 3 && gp.player.microfossil == 1) {
					int x = gp.tileSize*3;
					int y = gp.tileSize - 30;
					int width = gp.screenWidth - (gp.tileSize*4);
					int height = gp.tileSize*5;
					
					Color c = new Color(0,0,0,200);
					g2.setColor(c);
					g2.fillRoundRect(x, y, width, height, 35, 35);
					
					g2.setColor(Color.white);
					g2.setStroke(new BasicStroke(5));
					g2.drawRoundRect(x+5, y+5, width-10, height, 25, 25);
					
					x += gp.tileSize;
					y += gp.tileSize;
					g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 17));
					
					for(String line: microfossilFact3[0].split("/n")) {
						g2.drawString(line, x-5, y-10);
						y+=40;

					}					
					messageCounter ++;
					
					if(messageCounter  > 42000) {
						factCount++;
						messageCounter = 0;
					}
					if(factCount == microfossilFact3.length) {
						messageOn = false;
						factCount = 0;
						newObject = 0;
						}
					messageCounter ++;
					
					if(gp.keyH.next==true) {
						messageCounter = 100000000;
					}
					gp.keyH.next = false;
				}
				//dropstone message 1
				if(messageOn == true && newObject != 0 && gp.player.dropstoneFactIndicator == 1 && gp.player.dropstone == 1) {
					int x = gp.tileSize*3;
					int y = gp.tileSize - 30;
					int width = gp.screenWidth - (gp.tileSize*4);
					int height = gp.tileSize*5;
					
					Color c = new Color(0,0,0,200);
					g2.setColor(c);
					g2.fillRoundRect(x, y, width, height, 35, 35);
					
					g2.setColor(Color.white);
					g2.setStroke(new BasicStroke(5));
					g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
					
					x += gp.tileSize;
					y += gp.tileSize;
					g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 18));
					
					for(String line: dropstoneFact1[0].split("/n")) {
						g2.drawString(line, x, y-5);
						y+=40;
					}					
					messageCounter ++;
					
					if(messageCounter  > 2400) {
						factCount++;
						messageCounter = 0;
					}
					if(factCount == dropstoneFact1.length) {
						messageOn = false;
						factCount = 0;
						newObject = 0;
						}
					messageCounter ++;
				}
				//dropstone message 2
				if(messageOn == true && newObject != 0 && gp.player.dropstoneFactIndicator == 2 && gp.player.dropstone == 1) {
					int x = gp.tileSize*3;
					int y = gp.tileSize - 30;
					int width = gp.screenWidth - (gp.tileSize*4);
					int height = gp.tileSize*5;
					
					Color c = new Color(0,0,0,200);
					g2.setColor(c);
					g2.fillRoundRect(x, y, width, height, 35, 35);
					
					g2.setColor(Color.white);
					g2.setStroke(new BasicStroke(5));
					g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
					
					x += gp.tileSize;
					y += gp.tileSize;
					g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 18));
					
					for(String line: dropstoneFact2[0].split("/n")) {
						g2.drawString(line, x-5, y-10);
						y+=40;
					}					
					messageCounter ++;
					
					if(messageCounter  > 3000) {
						factCount++;
						messageCounter = 0;
					}
					if(factCount == dropstoneFact2.length) {
						messageOn = false;
						factCount = 0;
						newObject = 0;
						}
					messageCounter ++;
				}
				//dropstone message 3
				if(messageOn == true && newObject != 0 && gp.player.dropstoneFactIndicator == 3 && gp.player.dropstone == 1) {
					int x = gp.tileSize*3;
					int y = gp.tileSize - 30;
					int width = gp.screenWidth - (gp.tileSize*4);
					int height = gp.tileSize*5;
					
					Color c = new Color(0,0,0,200);
					g2.setColor(c);
					g2.fillRoundRect(x, y, width, height, 35, 35);
					
					g2.setColor(Color.white);
					g2.setStroke(new BasicStroke(5));
					g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
					
					x += gp.tileSize;
					y += gp.tileSize;
					g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 18));
					
					for(String line: dropstoneFact3[0].split("/n")) {
						g2.drawString(line, x-5, y-10);
						y+=40;
					}					
					messageCounter ++;
					
					if(messageCounter  > 3000) {
						factCount++;
						messageCounter = 0;
					}
					if(factCount == dropstoneFact3.length) {
						messageOn = false;
						factCount = 0;
						newObject = 0;
						}
					messageCounter ++;
				}
				//fossil message 1
				if(messageOn == true && newObject != 0 && gp.player.fossilFactIndicator == 1 && gp.player.fossil == 1) {
					int x = gp.tileSize*3;
					int y = gp.tileSize - 30;
					int width = gp.screenWidth - (gp.tileSize*4);
					int height = gp.tileSize*5;
					
					Color c = new Color(0,0,0,200);
					g2.setColor(c);
					g2.fillRoundRect(x, y, width, height, 35, 35);
					
					g2.setColor(Color.white);
					g2.setStroke(new BasicStroke(5));
					g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
					
					x += gp.tileSize;
					y += gp.tileSize;
					g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 18));
					
					for(String line: fossilFact1[0].split("/n")) {
						g2.drawString(line, x, y);
						y+=40;

					}					
					messageCounter ++;
					
					if(messageCounter  > 3000) {
						factCount++;
						messageCounter = 0;
					}
					if(factCount == fossilFact1.length) {
						messageOn = false;
						factCount = 0;
						newObject = 0;
						}
					messageCounter ++;
				}
				//fossil message 2
				if(messageOn == true && newObject != 0 && gp.player.fossilFactIndicator == 2 && gp.player.fossil == 1) {
					int x = gp.tileSize*3;
					int y = gp.tileSize - 30;
					int width = gp.screenWidth - (gp.tileSize*4);
					int height = gp.tileSize*5;
					
					Color c = new Color(0,0,0,200);
					g2.setColor(c);
					g2.fillRoundRect(x, y, width, height, 35, 35);
					
					g2.setColor(Color.white);
					g2.setStroke(new BasicStroke(5));
					g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
					
					x += gp.tileSize;
					y += gp.tileSize;
					g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 18));
					
					for(String line: fossilFact2[0].split("/n")) {
						g2.drawString(line, x, y);
						y+=40;
					}
					messageCounter ++;
					
					if(messageCounter  > 3000) {
						factCount++;
						messageCounter = 0;
					}
					if(factCount == fossilFact2.length) {
						messageOn = false;
						factCount = 0;
						newObject = 0;
						}
					messageCounter ++;
				}
				//fossil message 3
				if(messageOn == true && newObject != 0 && gp.player.fossilFactIndicator == 3 && gp.player.fossil == 1) {
					int x = gp.tileSize*3;
					int y = gp.tileSize - 30;
					int width = gp.screenWidth - (gp.tileSize*4);
					int height = gp.tileSize*5;
					
					Color c = new Color(0,0,0,200);
					g2.setColor(c);
					g2.fillRoundRect(x, y, width, height+10, 35, 35);
					
					g2.setColor(Color.white);
					g2.setStroke(new BasicStroke(5));
					g2.drawRoundRect(x+5, y+5, width-10, height, 25, 25);
					
					x += gp.tileSize;
					y += gp.tileSize;
					g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 15));
					
					for(String line: fossilFact3[0].split("/n")) {
						g2.drawString(line, x-10, y-10);
						y+=40;

					}						
					messageCounter ++;
					
					if(messageCounter  > 4800) {
						factCount++;
						messageCounter = 0;
					}
					if(factCount == fossilFact3.length) {
						messageOn = false;
						factCount = 0;
						newObject = 0;
						}
					messageCounter ++;
				}
				//scientist message 
				if(messageOn == true && newObject != 0 && gp.player.scientistFactIndicator == 1 && gp.player.scientist == 1) {
					int x = gp.tileSize*3;
					int y = gp.tileSize - 30;
					int width = gp.screenWidth - (gp.tileSize*4);
					int height = gp.tileSize*5;
					
					Color c = new Color(0,0,0,200);
					g2.setColor(c);
					g2.fillRoundRect(x, y, width, height, 35, 35);
					
					g2.setColor(Color.white);
					g2.setStroke(new BasicStroke(5));
					g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
					
					x += gp.tileSize;
					y += gp.tileSize;
					g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 18));
					
					for(String line: scientistFacts[factCount].split("/n")) {
						g2.drawString(line, x, y);
						y+=40;
					}
					
					messageCounter ++;
					
					if(messageCounter  > 3000) {
						factCount++;
						messageCounter = 0;
					}
					if(factCount == scientistFacts.length) {
						messageOn = false;
						factCount = 0;
						newObject = 0;
						}
					messageCounter ++;
				}
				
				
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	}
	}
