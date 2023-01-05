import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Graphics_Coding_Excercise_3_07
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		int n = sc.nextInt();
		sc.nextLine();
		String[] point = new String[n];
		for (int i = 0; i < point.length; i++)
		{
			point[i] = sc.nextLine();
		}

		int[] LongX = new int[n];
		int[] LatY = new int[n];
		for (int i = 0; i < n; i++)
		{
			String[] pointSplit = point[i].split(",");
			LatY[i] = Integer.parseInt(pointSplit[0]);
			LongX[i] = Integer.parseInt(pointSplit[1]);
		}

		// Load background image
		BufferedImage img = null;
		try
		{
			img = ImageIO.read(new File("world_map.png"));
		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Graphics g = img.getGraphics();
		Graphics2D g2d = (Graphics2D) g;
		System.out.println(img.getWidth() + " " + img.getHeight());

		// Center point picture
		int cntrX = img.getWidth() / 2;
		int cntrY = img.getHeight() / 2;
		int ctimgX = cntrX + 8;
		int ctimgY = cntrY - 22;
		double pixelX = 127 / 50;
		double pixelY = 71 / 25;

		// point
		g.setColor(Color.RED);
		for (int i = 0; i < n; i++)
		{
			g.fillOval(ctimgX - 10 + (int)pixelX*LongX[i], ctimgY - 10 - (int)pixelY * LatY[i] , 20, 20);
		}

		// center line
		g.setColor(Color.BLACK);
		g.drawLine(0, cntrY - 22, img.getWidth(), cntrY - 22);
		g.drawLine(cntrX + 8, 0, cntrX + 8, img.getHeight());

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
