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

public class Graphics_Coding_Excercise_4_03
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		BufferedImage img = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);
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

		Tile(g);

//		// center line
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

	public static void Tile(Graphics g)
	{
		for (int j = 0; j < 8; j++)
		{
			g.setColor(new Color(255, 236, 157));
			if (j % 2 == 0)
			{
				for (int i = 0; i < 4; i++)
				{
					g.fillRect(0 + 200 * i, 0 + 100 * j, 100, 100);
				}
			} else
			{
				for (int i = 0; i < 4; i++)
				{
					g.fillRect(100 + 200 * i, 0 + 100 * j, 100, 100);
				}
			}
		}
		for (int j = 0; j < 8; j++)
		{
			g.setColor(new Color(150, 50, 0));
			if (j % 2 == 0)
			{
				for (int i = 0; i < 4; i++)
				{
					g.fillRect(100 + 200 * i, 0 + 100 * j, 100, 100);
				}
			} else
			{
				for (int i = 0; i < 4; i++)
				{
					g.fillRect(0 + 200 * i, 0 + 100 * j, 100, 100);
				}
			}
		}
	}

}
