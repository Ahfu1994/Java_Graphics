import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Graphics_Coding_Excercise_1_10
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		BufferedImage img = new BufferedImage(240, 240, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		Graphics2D g2d = (Graphics2D) g;

		// Picture Frame back ground white
		g.setColor(new Color(255, 0, 0));
		g.fillRect(0, 0, img.getWidth(), img.getHeight());

		// Center point picture
		int cntrX = img.getWidth() / 2;
		int cntrY = img.getHeight() / 2;

		//
		g.setColor(new Color(255, 255, 0));
		int n = 5;
		int[] x = new int[n * 2];
		int[] y = new int[n * 2];

		g.translate(cntrX, cntrY);
		g2d.rotate(Math.toRadians(-18));
		for (int i = 0; i < n * 2; i++)
		{

//			x[i] = (int) (cntrX + cntrX * Math.cos(i * Math.PI / n));
//			y[i] = (int) (cntrY + cntrY * Math.sin(i * Math.PI / n));
			x[i] = (int) (80 * Math.cos(i * Math.PI / n));
			y[i] = (int) (80 * Math.sin(i * Math.PI / n));

			i++;

//			x[i] = (int) (cntrX + (cntrX - 79) * Math.cos(i * Math.PI / n));
//			y[i] = (int) (cntrY + (cntrY - 79) * Math.sin(i * Math.PI / n));
			x[i] = (int) ((80 - 50) * Math.cos(i * Math.PI / n));
			y[i] = (int) ((80 - 50) * Math.sin(i * Math.PI / n));

		}
		g.fillPolygon(x, y, n * 2);

//		g.translate(-cntrX, -cntrY);
//		g2d.rotate(Math.toRadians(-36));

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
