
import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;


import javax.imageio.ImageIO;

public class Graphics_Coding_Excercise_2_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		BufferedImage img = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		Graphics2D g2d = (Graphics2D) g;

		// Picture Frame back ground white
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, img.getWidth(), img.getHeight());

		// Center point picture
		int cntrX = img.getWidth() / 2;
		int cntrY = img.getHeight() / 2;

		//
		g.setColor(new Color(200, 100, 0));
		int n = 16;
		int[] x = new int[n * 2];
		int[] y = new int[n * 2];

		for (int i = 0; i < n * 2; i++) {

			x[i] = (int) (cntrX + cntrX * Math.cos(i * Math.PI / n));
			y[i] = (int) (cntrX + cntrX * Math.sin(i * Math.PI / n));

			i++;

			x[i] = (int) (cntrX + (cntrX - 80) * Math.cos(i * Math.PI / n));
			y[i] = (int) (cntrY + (cntrY - 80) * Math.sin(i * Math.PI / n));

		}
		g.fillPolygon(x, y, n * 2);

		// face
		g.setColor(new Color(255, 255, 0));
		int[] xface = {140, 460, 380, 220};
		int[] yface = {140, 140, 460, 460};
		g.fillPolygon(xface, yface, 4);

		//nose
		g.setColor(Color.BLACK);
		int[] xnose = {268, 332, 300};
		int[] ynose = {300, 300, 340};
		g.fillPolygon(xnose, ynose, 3);
		
		Stroke stroke = new BasicStroke(8f);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(stroke);
		g2d.drawLine(cntrX, cntrY+39, cntrX, cntrY+58);
		
		// mouth
		g.drawArc(252, 278, 96, 84, 225, 90);
		stroke = new BasicStroke(1f);
		g2d.setStroke(stroke);
		
		//ears
		g.setColor(new Color(255, 255, 0));
		g.fillArc(140, 80, 120, 120, 0, 180);
		g.fillArc(340, 80, 120, 120, 0, 180);
		
		g.setColor(new Color(255, 170, 84));
		g.fillArc(170, 110, 60, 60, 0, 180);
		g.fillArc(370, 110, 60, 60, 0, 180);
		
		//eyes
		g.setColor(new Color(0, 0, 0));
		g.fillOval(220, 240, 60, 60);
		g.fillOval(320, 240, 60, 60);
		
		
		g.setColor(new Color(255, 255, 0));
		g.fillRect(220, 240, 60, 20);
		g.fillRect(320, 240, 60, 20);
       
        
		// Center Line
//		g.setColor(Color.BLACK);
//		g.drawLine(cntrX, 0, cntrX, img.getHeight());
//		g.drawLine(0, cntrY, img.getWidth(), cntrY);

		
		img.flush();
		File outputfile = new File(s);
		try {
			ImageIO.write(img, "png", outputfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
