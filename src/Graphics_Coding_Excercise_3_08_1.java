import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.reflect.GenericSignatureFormatError;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.text.AttributeSet.ColorAttribute;

public class Graphics_Coding_Excercise_3_08_1
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int height = sc.nextInt();
		int[] data = new int[4];
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


		// bar
		Stroke stroke = new BasicStroke(6f);
		g2d.setStroke(stroke);

		g.setColor(Color.BLACK);
		g.drawLine(50, 500, 550, 500);
		g.drawLine(50, 100, 50, 500);

		stroke = new BasicStroke(1f);
		g2d.setStroke(stroke);

		// histrogram
		stroke = new BasicStroke(3f);
		g2d.setStroke(stroke);
		Color[] c = new Color[4];
		c[0] = new Color(255, 0, 0);
		c[1] = new Color(0, 255, 0);
		c[2] = new Color(0, 255, 255);
		c[3] = new Color(0, 0, 255);
		
		for (int i = 0; i < data.length; i++)
		{
			g.setColor(c[i]);
			int[] x = new int[]
			{ 90 + 120 * i, 150 + 120 * i, 170+ 120 * i, 170+ 120 * i, 110+ 120 * i, 90 + 120 * i};
			int[] y = new int[]
			{ 520, 520, 500, 500 - data[i]*400/height, 500 - data[i]*400/height, 500 - data[i]*400/height + 20 };
			g.fillPolygon(x, y, 6);
			g.setColor(Color.BLACK);
			g.drawPolygon(x, y, 6);
			g.drawLine(90+ 120 * i, 500 - data[i]*400/height + 20, 150+ 120 * i, 500 - data[i]*400/height + 20);
			g.drawLine(150+ 120 * i, 500 - data[i]*400/height + 20, 170+ 120 * i, 500 - data[i]*400/height);
			g.drawLine(150+ 120 * i, 500 - data[i]*400/height + 20, 150+ 120 * i, 520);
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
