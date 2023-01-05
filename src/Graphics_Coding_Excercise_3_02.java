import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Graphics_Coding_Excercise_3_02
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int height = sc.nextInt();
		int[] data1 = new int[4];
		int[] data2 = new int[4];
		for (int i = 0; i < data1.length; i++)
		{
			data1[i] = sc.nextInt();
			data2[i] = sc.nextInt();
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

		// bar
		Stroke stroke = new BasicStroke(6f);
		g2d.setStroke(stroke);

		g.setColor(Color.BLACK);
		g.drawLine(50, 500, 500, 500);
		g.drawLine(50, 500, 50, 500 - height);

		stroke = new BasicStroke(1f);
		g2d.setStroke(stroke);

		// histrogram
		for (int i = 0; i < data1.length; i++)
		{
			g.setColor(new Color(255, 0, 0));
			g.fillRect(90 + (80 + 40) * i, 500 - data1[i] - 1, 40, data1[i] - 1);

			g.setColor(new Color(0, 0, 255));
			g.fillRect(130 + (80 + 40) * i, 500 - data2[i] - 1, 40, data2[i] - 1);

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
