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

public class Graphics_Coding_Excercise_3_01
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

		// Center point picture
		int cntrX = img.getWidth() / 2;
		int cntrY = img.getHeight() / 2;

		// bar
		Stroke stroke = new BasicStroke(6f);
		g2d.setStroke(stroke);

		g.setColor(Color.BLACK);
		g.drawLine(50, 500, 550, 500);
		g.drawLine(50, 500, 50, 500 - height);

		stroke = new BasicStroke(1f);
		g2d.setStroke(stroke);

		// histrogram
		for (int i = 0; i < data.length; i++)
		{
			g.setColor(new Color(255, 0, 0));
			g.fillRect(90 + (80+40) * i, 500 - data[i], 80, data[i]);
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
