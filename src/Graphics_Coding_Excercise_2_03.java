
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Graphics_Coding_Excercise_2_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		BufferedImage img = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		Graphics2D g2d = (Graphics2D) g;
		
		//Picture Frame back ground white
		g.fillRect(0, 0, img.getWidth(), img.getHeight());
		g.setColor(Color.WHITE);
	
		//Center point picture 
		int cntrX = img.getWidth() / 2;
		int cntrY = img.getHeight() / 2;

		// Face
		g.setColor(new Color(255, 255, 0));
		g.fillRect(140, 220, 320, 320);
		
		g.setColor(new Color(255, 242, 215));
		g.fillRect(140, 416, 320, 124);
		
		//half circle
		g.setColor(new Color(230, 122, 13));
		g.fillArc(72, 280, 136, 136, 270, 180);
		g.fillArc(392, 152, 136, 136, 180, 90);
		
		//horn
		g.setColor(new Color(255, 255, 0));
		g.fillRect(231, 66, 40, 154);
		g.fillRect(329, 66, 40, 154);
		
		g.setColor(new Color(200, 100, 0));
		g.fillOval(218, 60, 66, 66);
		g.fillOval(316, 60, 66, 66);
		
		//eyes
		g.setColor(new Color(0, 0, 0));
		g.fillOval(224, 328, 52, 52);
		g.fillOval(324, 328, 52, 52);
		
		g.setColor(new Color(255, 255, 255));
		g.fillOval(230, 344, 20, 20);
		g.fillOval(330, 344, 20, 20);
		
		//nose
		g.setColor(new Color(230, 122, 130));
		g.fillOval(258, 436, 20, 16);
		g.fillOval(322, 436, 20, 16);
		
		//Line
		g.setColor(new Color(0, 0, 0));
		g.drawLine(0, cntrY, img.getWidth(), cntrY);
		g.drawLine(cntrX, 0, cntrX, img.getHeight());
		
		//mouth
		Stroke stroke = new BasicStroke(8f);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(stroke);
		g2d.drawArc(252, 430, 96, 84, 180, 180);
		stroke = new BasicStroke(1f);
		g2d.setStroke(stroke);
		
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
