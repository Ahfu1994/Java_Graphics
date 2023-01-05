import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Graphics_Coding_Excercise_3_04_1
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int height = sc.nextInt();
		int[] data = new int[6];
		for (int i = 0; i < data.length; i++)
		{
			data[i] = sc.nextInt();

		}
		
		BufferedImage img = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		Graphics2D g2d = (Graphics2D) g;

		// Picture Frame back ground white
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, img.getWidth(), img.getHeight());

		// Center point picture
		int cntrX = img.getWidth() / 2;
		int cntrY = img.getHeight() / 2;

		// x , y
		Stroke stroke = new BasicStroke(6f);
		g2d.setStroke(stroke);

		g.setColor(Color.BLACK);
		g.drawLine(50, 500, 500, 500);
		g.drawLine(50, 100, 50, 500);

		// Line
		for (int i = 0; i < data.length; i++)
		{
			g.setColor(Color.BLACK);
			g.drawLine(120 + 70 * i, 480, 120 + 70 * i, 520);
		}
		
		for (int i = 1; i < data.length; i++)
		{
			g.setColor(new Color(255, 0, 0));
			g.drawLine(120 + 70 * (i-1), 500-data[i-1]*400/height, 120 + 70 * i, 500-data[i]*400/height);
		}
		
		stroke = new BasicStroke(1f);
		g2d.setStroke(stroke);
		
		//plus
		stroke = new BasicStroke(2f);
		g2d.setStroke(stroke);
		for (int i = 0; i < data.length; i++)
		{
			g.setColor(new Color(255, 0, 0));
			g.drawLine(120 + 70 * i -20, 500-data[i]*400/height, 120 + 70 * i + 20, 500-data[i]*400/height);
			g.drawLine(120 + 70 * i, 500-data[i]*400/height-20, 120 + 70 * i, 500-data[i]*400/height+20);
		}
		
		
		
		stroke = new BasicStroke(1f);
		g2d.setStroke(stroke);

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
