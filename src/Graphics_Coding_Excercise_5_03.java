import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Graphics_Coding_Excercise_5_03
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int data = sc.nextInt();
		sc.nextLine();

		BufferedImage img = new BufferedImage(360, 600, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		Graphics2D g2d = (Graphics2D) g;

		// Picture Frame back ground white
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, img.getWidth(), img.getHeight());

		g.setColor(Color.BLACK);
		Stroke stroke = new BasicStroke(6f);
		g2d.setStroke(stroke);

		g.drawArc(105, 422, 150, 150, 125, 290);

		g.drawLine(136, 65, 136, 380 + 54);
		g.drawLine(136 + 88, 65, 136 + 88, 380 + 54);

		g.drawArc(136, 32, 88, 88, 0, 180);

		for (int i = 0; i < 11; i++)
		{
			g.drawLine(244, 54 + i * 38, 268, 54 + i * 38);
		}

		stroke = new BasicStroke(1f);
		g2d.setStroke(stroke);

		g.setColor(new Color(210, 210, 210));
		g.fillArc(158, 54, 44, 44, 0, 180);
		g.fillRect(158, 76, 44, 380 + 54);

		g.setColor(new Color(255, 0, 0));
		g.fillOval(130, 447, 100, 100);

		g.fillRect(158, 435, 44, 50);
		
		g.fillRect(158, 453-data*38/10, 44, data*38/10);
		
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
