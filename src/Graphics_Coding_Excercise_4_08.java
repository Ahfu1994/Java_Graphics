import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Graphics_Coding_Excercise_4_08
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		BufferedImage img = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		Graphics2D g2d = (Graphics2D) g;

		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHints(rh);

		// Picture Frame back ground white
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, img.getWidth(), img.getHeight());

		// Center point picture
		int cntrX = img.getWidth() / 2;
		int cntrY = img.getHeight() / 2;

		Stroke stroke = new BasicStroke(4f);
		g2d.setStroke(stroke);
		g.setColor(new Color(255, 0, 0));
		drawFractalTree(300, 550, -90, g, 200, 10);
		stroke = new BasicStroke(1f);
		g2d.setStroke(stroke);

		// center line
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

	public static void drawFractalTree(int x1, int y1, int angle, Graphics g, int height, int round)
	{
		if (round == 0)
		{
			return;
		}

		int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * height);
		int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * height);

//		System.out.println(x1 + " " + x2 + " " + (x1 + x2) / 2);
//		System.out.println(y1 + " " + y2 + " " + (y1 + y2) / 2);
		g.drawLine(x1, y1, x2, y2);

		drawFractalTree((int) ((x1 + x2) / 3), (int) ((y1 + y2) / 3), angle - 30, g, (int) (height * 0.8), round - 1);
//		drawFractalTree((int) ((x1 + x2) / 2), (int) ((y1 + y2) / 2), angle + 30, g, (int) (height * 0.8), round - 1);
	}
}
