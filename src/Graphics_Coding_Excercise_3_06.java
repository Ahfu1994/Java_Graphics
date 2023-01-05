import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Graphics_Coding_Excercise_3_06
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String str_H_W = sc.nextLine();
		String[] hw = str_H_W.split(",");
		int W = Integer.parseInt(hw[0]);
		int H = Integer.parseInt(hw[1]);

		int n = sc.nextInt();
		sc.nextLine();
		String[] point = new String[n];
		for (int i = 0; i < point.length; i++)
		{
			point[i] = sc.nextLine();
		}

		int[] pointX = new int[n];
		int[] pointY = new int[n];
		for (int i = 0; i < n; i++)
		{
			String[] pointSplit = point[i].split(",");
			pointX[i] = Integer.parseInt(pointSplit[0]);
			pointY[i] = Integer.parseInt(pointSplit[1]);
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
		g.drawLine(50, 500, 50 + W, 500);
		g.drawLine(50, 500, 50, 500 - H);

		stroke = new BasicStroke(1f);
		g2d.setStroke(stroke);

		// point
		g.setColor(Color.RED);
		for (int i = 0; i < n; i++)
		{
			g.fillOval(50 + pointX[i] - 10, 500 - pointY[i] - 10, 20, 20);
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
