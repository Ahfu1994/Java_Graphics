import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.border.Border;

public class Graphics_Coding_Excercise_1_09
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		BufferedImage img = new BufferedImage(240, 240, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		Graphics2D g2d = (Graphics2D) g;

//		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		g2d.setRenderingHints(rh);

		g.setColor(new Color(255,255,0));
		g.fillRect(0, 0, img.getWidth(), img.getHeight());

		
		g.setColor(Color.WHITE);
		int[]x = new int[] {0, 240, 240, 0};
		int[]y = new int[] {0, 240-80, 240-40, 40};
		g.fillPolygon(x,y,4);
		
		g.setColor(Color.BLACK);
		int[]x1 = new int[] {0, 240, 240, 0};
		int[]y1 = new int[] {40, 240-40, 240, 80};
		g.fillPolygon(x1,y1,4);
		

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
