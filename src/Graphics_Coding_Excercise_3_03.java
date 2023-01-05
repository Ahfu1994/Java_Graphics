import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Graphics_Coding_Excercise_3_03
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int[] data = new int[8];
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

		// circle
		Stroke stroke = new BasicStroke(6f);
		g2d.setStroke(stroke);

		g.setColor(Color.BLACK);
		g.drawOval(50, 50, 500, 500);

		stroke = new BasicStroke(1f);
		g2d.setStroke(stroke);

		// pie
		double total = 0;
		for (int i = 0; i < data.length; i++)
		{
			total = data[i] + total;
		}
		Color[] c = new Color[6];
		c[0] = new Color(255, 0, 0);
		c[1] = new Color(0, 255, 0);
		c[2] = new Color(255, 255, 0);
		c[3] = new Color(0, 0, 255);
		c[4] = new Color(0, 255, 0);
		c[5] = new Color(0, 255, 255);
//
		double curValue = 0.0;
		int startAngle = 0;
		for (int i = 0; i < data.length; i++)
		{
			startAngle = (int) (curValue * 360 / total);
			int arcAngle = (int) (data[i] * 360 / total);
			g.setColor(c[i]);
			g.fillArc(50, 50, 500, 500, -startAngle, -arcAngle);
			curValue += data[i];
		}

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
