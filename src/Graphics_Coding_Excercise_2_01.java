import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Stroke;
import java.awt.BasicStroke;

import java.util.Scanner;

import javax.imageio.ImageIO;

public class Graphics_Coding_Excercise_2_01
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		BufferedImage img = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, img.getWidth(), img.getHeight());

		// Cat face
		int cntrX = img.getWidth() / 2;
		int cntrY = img.getHeight() / 2;
		// Calculate the radius
		int radius = 160;
		// Draw the Circle
		g.setColor(new Color(255, 125, 0));
		g.fillOval(cntrX - radius, cntrY - radius, radius * 2, radius * 2);
		

		// Cat nose
		g.setColor(Color.BLACK);
		int[] x = { cntrX - 20, cntrX + 20, cntrX };
		int[] y = { cntrY, cntrY, cntrY + 40 };
		g.fillPolygon(x, y, 3);

		// Eye
		g.fillOval(220, 220, 52, 52);
		g.fillOval(328, 220, 52, 52);

		// Cat mouth
		g.setColor(new Color(255, 0, 0));
		g.fillOval(cntrX - 30, cntrY + 40, 30 * 2, 30 * 2);

		
		Graphics2D g2d = (Graphics2D) g;

		// beard
		Stroke stroke = new BasicStroke(8f);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(stroke);
		g2d.drawLine(94, 256, 180, 328);
		g2d.drawLine(80, 328, 180, 328);
		g2d.drawLine(94, 400, 180, 328);
		g2d.drawLine(506, 256, 420, 328);
		g2d.drawLine(520, 328, 420, 328);
		g2d.drawLine(506, 400, 420, 328);
		Stroke stroke1 = new BasicStroke(1f);
		g2d.setStroke(stroke1);

//		g2d.drawLine(0, 0, cntrX, cntrY);
//		g2d.drawLine(img.getWidth(), 0, cntrX, cntrY);
		
		// Ears
		g.setColor(new Color(255, 125, 0));
		double angle = 315;
		int[] xP = {0, 50, -50};
		int[] yP = {0, 100, 100};
		g2d.translate(125, 125);
		g2d.rotate(Math.PI/180*angle);
		g.fillPolygon(xP, yP, 3);
		g2d.rotate(-Math.PI/180*angle);
		g2d.translate(-125, -125);
		
		g2d.translate(img.getWidth()-125, 125);
		g2d.rotate(-Math.PI/180*angle);
		g.fillPolygon(xP, yP, 3);
		g2d.rotate(Math.PI/180*angle);
		g2d.translate(-125, -125);
		g2d.dispose();
		
//		
		
		
		
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
