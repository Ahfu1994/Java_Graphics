import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Graphics_Coding_Excercise_2_05
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		BufferedImage img = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		Graphics2D g2d = (Graphics2D) g;

		// Picture Frame back ground white
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, img.getWidth(), img.getHeight());

		// Center point picture
		int cntrX = img.getWidth() / 2;
		int cntrY = img.getHeight() / 2;

		//
		g.setColor(new Color(140, 70, 0));
		int n = 32;
		int[] x = new int[n * 2];
		int[] y = new int[n * 2];

		for (int i = 0; i < n * 2; i++)
		{

			x[i] = (int) (cntrX + cntrX * Math.cos(i * Math.PI / n));
			y[i] = (int) (cntrY + cntrY * Math.sin(i * Math.PI / n));

			i++;

			x[i] = (int) (cntrX + (cntrX - 79) * Math.cos(i * Math.PI / n));
			y[i] = (int) (cntrY + (cntrY - 79) * Math.sin(i * Math.PI / n));

		}
		g.fillPolygon(x, y, n * 2);

		// face
		g.setColor(new Color(255, 236, 170));
		g.fillOval(120, 120, 360, 460);

		// nose
		g.setColor(Color.BLACK);
		g.fillOval(270, 310, 60, 40);

		// mouth
		Stroke stroke = new BasicStroke(8f);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(stroke);
		g.drawArc(205, 300, 190, 84, 180, 180);

		// hand
		g.drawArc(108, 358, 100, 100, 270, 180);
		g.drawArc(392, 358, 100, 100, 90, 180);

		stroke = new BasicStroke(1f);
		g2d.setStroke(stroke);

		// Foot
		g.setColor(new Color(222, 140, 0));
		g.fillOval(158, 533, 142, 134);
		g.fillOval(300, 533, 142, 134);

		// eyes
		g.setColor(Color.WHITE);
		g.fillOval(187, 217, 100, 100);
		g.fillOval(313, 217, 100, 100);

		g.setColor(Color.BLACK);
		g.fillOval(216, 246, 42, 42);
		g.fillOval(342, 246, 42, 42);

		// Center Line
//		g.setColor(Color.BLACK);
//		g.drawLine(cntrX, 0, cntrX, img.getHeight());
//		g.drawLine(0, cntrY, img.getWidth(), cntrY);

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
