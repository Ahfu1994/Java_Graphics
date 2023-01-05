import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Graphics_Coding_Excercise_4_05
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int cm = sc.nextInt();
		sc.nextLine();
		BufferedImage img = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		Graphics2D g2d = (Graphics2D) g;

		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHints(rh);

		// Picture Frame back ground white
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, img.getWidth(), img.getHeight());

		drawTile(cm, g);

		// Center point picture
//		int cntrX = img.getWidth() / 2;
//		int cntrY = img.getHeight() / 2;

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

	public static void drawTile(int l, Graphics g)
	{
		for (int i = 0; i < 12; i++)
		{
			if (i % 2 == 0)
			{
				for (int j = 0; j < 7; j++)
				{
					g.setColor(new Color(200, 90, 0));
					g.fillRect(0 + j * 100, 0 + i * 50, 90, 40);
					g.setColor(new Color(180, 180, 180));
					g.fillRect(90 + j * 100, 0 + i * 50, 10, 40);
				}
			} else
			{
				for (int j = 0; j < 7; j++)
				{
					g.setColor(new Color(200, 90, 0));
					g.fillRect(-l + j * 100, 0 + i * 50, 90, 40);
					g.setColor(new Color(180, 180, 180));
					g.fillRect(-l + 90 + j * 100, 0 + i * 50, 10, 40);
				}
			}
			g.fillRect(0, 40 + 50 * i, 600, 10);
		}
	}
}
