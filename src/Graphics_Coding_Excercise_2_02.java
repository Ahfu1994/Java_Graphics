import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Graphics_Coding_Excercise_2_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		BufferedImage img = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		
		//Picture Frame back ground white
		g.fillRect(0, 0, img.getWidth(), img.getHeight());
		g.setColor(Color.WHITE);
	
		//Center Picture 
		int cntrX = img.getWidth() / 2;
		int cntrY = img.getHeight() / 2;

		
		//face
		int radius = 160;
		g.setColor(new Color(255, 188, 0));
		g.fillOval(cntrX - radius, cntrY - radius, radius * 2, radius * 2);
		g.setColor(new Color(255, 233, 171));
		g.fillOval(cntrX - 114, cntrY , 228, radius );
		
		// Cat nose
		g.setColor(Color.BLACK);
		int[] x = { cntrX - 20, cntrX + 20, cntrX };
		int[] y = { cntrY, cntrY, cntrY + 40 };
		g.fillPolygon(x, y, 3);
		
		Graphics2D g2d = (Graphics2D)g;
		Stroke stroke = new BasicStroke(8f);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(stroke);
		g2d.drawLine(cntrX, cntrY+39, cntrX, cntrY+58);
		stroke = new BasicStroke(1f);
		g2d.setStroke(stroke);
		
		//mouth
		g.setColor(new Color(255, 195, 244));
		g.fillArc(cntrX-44, cntrY+20, 88, 88, 180, 180);
		
		//eye
		g.setColor(new Color(0, 0, 0));
		g.fillOval(220, 220, 52, 52);
		g.fillOval(328, 220, 52, 52);
		
		//Ears
//		g2d.drawLine(0, 0, cntrX, cntrY);
//		g2d.drawLine(img.getWidth(), 0, cntrX, cntrY);
		g.setColor(new Color(255, 188, 0));
		double angle = 315;
		g2d.translate(155, 155);
		g2d.rotate(Math.PI/180*angle);
//		g.drawRect(-58, 0, 116, 116);
		g.fillArc(-58, 0, 116, 116, 0, 180);
		g2d.rotate(-Math.PI/180*angle);
		g2d.translate(-155, -155);
		
		g2d.translate(img.getWidth()-155, 155);
		g2d.rotate(-Math.PI/180*angle);
//		g.drawRect(-58, 0, 116, 116);
		g.fillArc(-58, 0, 116, 116, 0, 180);
		g2d.rotate(Math.PI/180*angle);
		g2d.translate(-155, -155);
		//////////////////////////////
		
		img.flush();
		File outputfile = new File(s);
		try {
			ImageIO.write(img, "png", outputfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();

	}

}