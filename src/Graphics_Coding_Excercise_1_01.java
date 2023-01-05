import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Graphics_Coding_Excercise_1_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		BufferedImage img = new BufferedImage(250, 250, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect( 0, 0, img.getWidth(), img.getHeight());
		g.setColor(Color.RED);
		g.fillOval(75, 75, 100, 100);
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

