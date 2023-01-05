import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.awt.RenderingHints;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Graphics_Coding_Excercise_4_01
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		BufferedImage img = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		Graphics2D g2d = (Graphics2D) g;

//		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		g2d.setRenderingHints(rh);

		// Picture Frame back ground white
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, img.getWidth(), img.getHeight());

		// Center point picture
		int cntrX = img.getWidth() / 2;
		int cntrY = img.getHeight() / 2;

		// innner circle
		g.setColor(Color.BLACK);
		g.fillArc(0, 0, 600, 600, 270, 180);
		g.setColor(Color.WHITE);
		g.fillArc(0, 0, 600, 600, 90, 180);
		g.fillOval(150, 0, 300, 300);
		g.setColor(Color.BLACK);
		g.fillOval(262, 112, 75, 75);
		g.fillOval(150, 300, 300, 300);
		g.setColor(Color.WHITE);
		g.fillOval(262, 412, 75, 75);
		
		// outter circle
		g.setColor(Color.BLACK);
		Stroke stroke = new BasicStroke(8f);
		g2d.setStroke(stroke);

		g.drawOval(0, 0, 600, 600);

		stroke = new BasicStroke(1f);
		g2d.setStroke(stroke);

//		g.drawLine(0, cntrY, img.getWidth(), cntrY);
//		g.drawLine(cntrX, 0, cntrX, img.getHeight());

		img.flush();
		File outputfile = new File(s);
		try
		{
			ImageIO.write(img, "png", outputfile);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		sc.close();
	}
}
