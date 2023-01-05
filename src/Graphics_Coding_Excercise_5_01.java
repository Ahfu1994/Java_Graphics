import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Graphics_Coding_Excercise_5_01
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		int data = sc.nextInt();sc.nextLine();
		
		BufferedImage img = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, img.getWidth(), img.getHeight());
		
		g.setColor(Color.BLACK);
		Stroke stroke = new BasicStroke(6f);
		g2d.setStroke(stroke);
		g.drawRect(50, 250,500,100);
		stroke = new BasicStroke(1f);
		g2d.setStroke(stroke);
		
		g.setColor(new Color(0,255,0));
		g.fillRect(50, 250, data*500/100, 100);
		
		
		
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
