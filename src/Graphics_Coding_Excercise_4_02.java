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

public class Graphics_Coding_Excercise_4_02
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		BufferedImage img = new BufferedImage(1000, 600, BufferedImage.TYPE_INT_RGB);
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

		g.setColor(new Color(0, 200, 255));
		g.fillRect(0, 0, img.getWidth(), cntrY);

		g.setColor(new Color(0, 210, 0));
		g.fillRect(0, cntrY, img.getWidth(), 300);

		drawMoutain(222, g);
		drawMoutain(468, g);
		drawMoutain(796, g);

		drawSum(g);

		drawCould(71, 118, g);
		drawCould(336, 154, g);
		drawCould(892, 88, g);

		drawRiver(g);

		drawHouse(g);

		drawTree(g);

		drawField(g);

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

	public static void drawMoutain(int startX, Graphics g)
	{
		g.setColor(new Color(0, 65, 0));
		int[] x = new int[]
		{ startX, startX + 220, startX - 220 };
		int[] y = new int[]
		{ 133, 300, 300 };
		g.fillPolygon(x, y, 3);
	}

	public static void drawSum(Graphics g)
	{
		g.setColor(new Color(255, 160, 0));
		int n = 16;
		int[] x = new int[n * 2];
		int[] y = new int[n * 2];

		for (int i = 0; i < n * 2; i++)
		{

			x[i] = (int) (638 + 90 * Math.cos(i * Math.PI / n));
			y[i] = (int) (103 + 90 * Math.sin(i * Math.PI / n));

			i++;

			x[i] = (int) (638 + (90 - 25) * Math.cos(i * Math.PI / n));
			y[i] = (int) (103 + (90 - 25) * Math.sin(i * Math.PI / n));

		}
		g.fillPolygon(x, y, n * 2);
		g.setColor(new Color(255, 0, 0));
		g.fillOval(594, 59, 88, 88);
	}

	public static void drawCould(int startX, int startY, Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillArc(startX - 48, startY - 42, 96, 82, 0, 180);
		g.fillArc(startX, startY - 60, 96, 118, 0, 180);
	}

	public static void drawHouse(Graphics g)
	{
		g.setColor(new Color(194, 100, 68));
		g.fillRect(668, 453, 168, 94);
		g.setColor(new Color(254, 236, 164));
//		g.fillRect(702, 483, 100, 35);
		g.fillRect(702, 463, 100, 35);
		g.setColor(new Color(194, 100, 68));
		int[] x = new int[]
		{ 752, 892, 892 - 280 };
		int[] y = new int[]
		{ 363, 453, 453 };
		g.fillPolygon(x, y, 3);
	}

	public static void drawRiver(Graphics g)
	{
		g.setColor(new Color(0, 90, 183));
		int[] x = new int[]
		{ 624, 676, 504, 452 };
		int[] y = new int[]
		{ 300, 300, 600, 600 };
		g.fillPolygon(x, y, 4);
	}

	public static void drawTree(Graphics g)
	{
		g.setColor(new Color(0, 100, 0));
		g.fillOval(865, 323, 140, 130);
		g.setColor(new Color(119, 82, 45));
		g.fillRect(918, 453, 40, 94);
	}

	public static void drawField(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(new Color(255, 255, 0));
		int[] x = new int[]
		{ 25, 590, 436, -129 };
		int[] y = new int[]
		{ 314, 314, 584, 584 };
		g.fillPolygon(x, y, 4);
		g.setColor(Color.BLACK);
		Stroke stroke = new BasicStroke(.8f);
		g2d.setStroke(stroke);
		g.drawPolygon(x, y, 4);
		for (int i = 0; i < 6; i++)
		{
			g.drawLine(25 + 113 * i, 314, -129 + 113 * i, 584);

		}
		for (int i = 0; i < 3; i++)
		{
			g.drawLine(25 - 53 * i, 314 + 95 * i, 590 - 53 * i, 314 + 95 * i);
		}
		
		stroke = new BasicStroke(.1f);
		g2d.setStroke(stroke);

	}
}

