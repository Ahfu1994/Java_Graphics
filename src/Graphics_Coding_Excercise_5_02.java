import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Graphics_Coding_Excercise_5_02
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int data = sc.nextInt();
		sc.nextLine();

		BufferedImage img = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		Graphics2D g2d = (Graphics2D) g;

		// Picture Frame back ground white
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, img.getWidth(), img.getHeight());

		g.setColor(Color.BLACK);
		Stroke stroke = new BasicStroke(6f);
		g2d.setStroke(stroke);

		g.drawOval(100, 100, 400, 400);

		stroke = new BasicStroke(1f);
		g2d.setStroke(stroke);

		g.setColor(new Color(0, 255, 0));
		double curValue = 0.0;
		int startAngle = 90;

//		startAngle = (int) (curValue * 360 / 100);
		int arcAngle = (int) (-data * 360 / 100);

		g.fillArc(100, 100, 400, 400, startAngle, arcAngle);

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
