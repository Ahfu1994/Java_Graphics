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
import javax.swing.text.AttributeSet.ColorAttribute;

public class Graphics_Coding_Excercise_4_04
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		BufferedImage img = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		Graphics2D g2d = (Graphics2D) g;

//		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		g2d.setRenderingHints(rh);

		// Picture Frame back ground white
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, img.getWidth(), img.getHeight());

		// Center point picture
		int cntrX = img.getWidth() / 2;
		int cntrY = img.getHeight() / 2;

		Tile(g);
		drawWhitePawn(g);
		drawBlackPawn(g);
		drawWhiteRook1(g);
		drawWhiteRook2(g);
		drawBlackRook1(g);
		drawBlackRook2(g);
		drawWhiteBishop1(g);
		drawWhiteBishop2(g);
		drawBlackBishop1(g);
		drawBlackBishop2(g);
		drawKnightWhite1(g);
		drawKnightWhite2(g);
		drawKnightBlack1(g);
		drawKnightBlack2(g);
		drawWhiteQueen(g);
		drawBlackQueen(g);
		drawWhiteKing(g);
		drawBlackKing(g);
		
		
		

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

	public static void Tile(Graphics g)
	{
		for (int j = 0; j < 8; j++)
		{
			g.setColor(new Color(255, 236, 157));
			if (j % 2 == 0)
			{
				for (int i = 0; i < 4; i++)
				{
					g.fillRect(0 + 200 * i, 0 + 100 * j, 100, 100);
				}
			} else
			{
				for (int i = 0; i < 4; i++)
				{
					g.fillRect(100 + 200 * i, 0 + 100 * j, 100, 100);
				}
			}
		}
		for (int j = 0; j < 8; j++)
		{
			g.setColor(new Color(150, 50, 0));
			if (j % 2 == 0)
			{
				for (int i = 0; i < 4; i++)
				{
					g.fillRect(100 + 200 * i, 0 + 100 * j, 100, 100);
				}
			} else
			{
				for (int i = 0; i < 4; i++)
				{
					g.fillRect(0 + 200 * i, 0 + 100 * j, 100, 100);
				}
			}
		}
	}

	public static void drawBlackPawn(Graphics g)
	{
		g.setColor(Color.BLACK);
		for (int i = 0; i < 8; i++)
		{
			g.fillOval(40 + 100 * i, 100 + 10, 20, 20);
			g.fillOval(30 + 100 * i, 100 + 25, 40, 30);
			g.fillArc(15 + 100 * i, 100 + 50, 70, 76, 0, 180);
		}

	}

	public static void drawWhitePawn(Graphics g)
	{
		g.setColor(Color.WHITE);
		for (int i = 0; i < 8; i++)
		{
			g.fillOval(40 + 100 * i, 600 + 10, 20, 20);
			g.fillOval(30 + 100 * i, 600 + 25, 40, 30);
			g.fillArc(15 + 100 * i, 600 + 50, 70, 76, 0, 180);
		}

	}

	public static void drawBlackRook1(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(16, 10, 18, 11);
		g.fillRect(41, 10, 18, 11);
		g.fillRect(66, 10, 18, 11);
		int[] x1 = new int[]
		{ 16, 84, 69, 31 };
		int[] y1 = new int[]
		{ 21, 21, 33, 33 };
		g.fillPolygon(x1, y1, 4);
		g.fillRect(31, 33, 38, 30);
		int[] x2 = new int[]
		{ 31, 69, 84, 16 };
		int[] y2 = new int[]
		{ 63, 63, 80, 80 };
		g.fillPolygon(x2, y2, 4);
		g.fillRect(16, 80, 68, 12);
	}

	public static void drawBlackRook2(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(16 + 700, 10, 18, 11);
		g.fillRect(41 + 700, 10, 18, 11);
		g.fillRect(66 + 700, 10, 18, 11);
		int[] x1 = new int[]
		{ 16 + 700, 84 + 700, 69 + 700, 31 + 700 };
		int[] y1 = new int[]
		{ 21, 21, 33, 33 };
		g.fillPolygon(x1, y1, 4);
		g.fillRect(31 + 700, 33, 38, 30);
		int[] x2 = new int[]
		{ 31 + 700, 69 + 700, 84 + 700, 16 + 700 };
		int[] y2 = new int[]
		{ 63, 63, 80, 80 };
		g.fillPolygon(x2, y2, 4);
		g.fillRect(16 + 700, 80, 68, 12);
	}

	public static void drawWhiteRook1(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(16, 10 + 700, 18, 11);
		g.fillRect(41, 10 + 700, 18, 11);
		g.fillRect(66, 10 + 700, 18, 11);
		int[] x1 = new int[]
		{ 16, 84, 69, 31 };
		int[] y1 = new int[]
		{ 21 + 700, 21 + 700, 33 + 700, 33 + 700 };
		g.fillPolygon(x1, y1, 4);
		g.fillRect(31, 33 + 700, 38, 30);
		int[] x2 = new int[]
		{ 31, 69, 84, 16 };
		int[] y2 = new int[]
		{ 63 + 700, 63 + 700, 80 + 700, 80 + 700 };
		g.fillPolygon(x2, y2, 4);
		g.fillRect(16, 80 + 700, 68, 12);
	}

	public static void drawWhiteRook2(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(16 + 700, 10 + 700, 18, 11);
		g.fillRect(41 + 700, 10 + 700, 18, 11);
		g.fillRect(66 + 700, 10 + 700, 18, 11);
		int[] x1 = new int[]
		{ 16 + 700, 84 + 700, 69 + 700, 31 + 700 };
		int[] y1 = new int[]
		{ 21 + 700, 21 + 700, 33 + 700, 33 + 700 };
		g.fillPolygon(x1, y1, 4);
		g.fillRect(31 + 700, 33 + 700, 38, 30);
		int[] x2 = new int[]
		{ 31 + 700, 69 + 700, 84 + 700, 16 + 700 };
		int[] y2 = new int[]
		{ 63 + 700, 63 + 700, 80 + 700, 80 + 700 };
		g.fillPolygon(x2, y2, 4);
		g.fillRect(16 + 700, 80 + 700, 68, 12);
	}

	public static void drawBlackBishop1(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillOval(200 + 42, 10, 16, 16);
		g.fillOval(200 + 34, 25, 32, 32);
		g.fillOval(200 + 38, 52, 24, 24);
		int[] x = new int[]
		{ 200 + 40, 200 + 60, 200 + 74, 200 + 26 };
		int[] y = new int[]
		{ 70, 70, 90, 90 };
		g.fillPolygon(x, y, 4);

		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.WHITE);
		Stroke stroke = new BasicStroke(8f);
		g2d.setStroke(stroke);
		g.setColor(Color.WHITE);
		g.drawLine(200 + 50, 41 - 9, 200 + 50, 41 - 9 + 18);
		g.drawLine(200 + 50 - 9, 41, 200 + 50 + 9, 41);
		stroke = new BasicStroke(1f);
		g2d.setStroke(stroke);

	}

	public static void drawBlackBishop2(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillOval(500 + 42, 10, 16, 16);
		g.fillOval(500 + 34, 25, 32, 32);
		g.fillOval(500 + 38, 52, 24, 24);
		int[] x = new int[]
		{ 500 + 40, 500 + 60, 500 + 74, 500 + 26 };
		int[] y = new int[]
		{ 70, 70, 90, 90 };
		g.fillPolygon(x, y, 4);

		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.WHITE);
		Stroke stroke = new BasicStroke(8f);
		g2d.setStroke(stroke);
		g.setColor(Color.WHITE);
		g.drawLine(500 + 50, 41 - 9, 500 + 50, 41 - 9 + 18);
		g.drawLine(500 + 50 - 9, 41, 500 + 50 + 9, 41);
		stroke = new BasicStroke(1f);
		g2d.setStroke(stroke);

	}

	public static void drawWhiteBishop1(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillOval(200 + 42, 700 + 10, 16, 16);
		g.fillOval(200 + 34, 700 + 25, 32, 32);
		g.fillOval(200 + 38, 700 + 52, 24, 24);
		int[] x = new int[]
		{ 200 + 40, 200 + 60, 200 + 74, 200 + 26 };
		int[] y = new int[]
		{ 700 + 70, 700 + 70, 700 + 90, 700 + 90 };
		g.fillPolygon(x, y, 4);

		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.BLACK);
		Stroke stroke = new BasicStroke(8f);
		g2d.setStroke(stroke);
		g.drawLine(200 + 50, 700 + 41 - 9, 200 + 50, 700 + 41 - 9 + 18);
		g.drawLine(200 + 50 - 9, 700 + 41, 200 + 50 + 9, 700 + 41);
		stroke = new BasicStroke(1f);
		g2d.setStroke(stroke);

	}

	public static void drawWhiteBishop2(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillOval(500 + 42, 700 + 10, 16, 16);
		g.fillOval(500 + 34, 700 + 25, 32, 32);
		g.fillOval(500 + 38, 700 + 52, 24, 24);
		int[] x = new int[]
		{ 500 + 40, 500 + 60, 500 + 74, 500 + 26 };
		int[] y = new int[]
		{ 700 + 70, 700 + 70, 700 + 90, 700 + 90 };
		g.fillPolygon(x, y, 4);

		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.BLACK);
		Stroke stroke = new BasicStroke(8f);
		g2d.setStroke(stroke);
		g.drawLine(500 + 50, 700 + 41 - 9, 500 + 50, 700 + 41 - 9 + 18);
		g.drawLine(500 + 50 - 9, 700 + 41, 500 + 50 + 9, 700 + 41);
		stroke = new BasicStroke(1f);
		g2d.setStroke(stroke);

	}

	public static void drawKnightBlack1(Graphics g)
	{
		g.setColor(Color.BLACK);
		int[] x1 = new int[]
		{ 100 + 36, 100 + 28, 100 + 28, 100 + 40, 100 + 58, 100 + 66, 100 + 66, 100 + 82, 100 + 74, 100 + 67, 100 + 55,
				100 + 70, 100 + 64 };
		int[] y1 = new int[]
		{ 76, 48, 32, 16, 16, 10, 20, 37, 49, 43, 45, 61, 76 };
		g.fillPolygon(x1, y1, 13);
		int[] x2 = new int[]
		{ 100 + 36, 100 + 64, 100 + 74, 100 + 26 };
		int[] y2 = new int[]
		{ 76, 76, 88, 88 };
		g.fillPolygon(x2, y2, 4);
		g.setColor(Color.WHITE);
		g.fillOval(100 + 62, 26, 6, 6);
	}

	public static void drawKnightBlack2(Graphics g)
	{
		g.setColor(Color.BLACK);
		int[] x1 = new int[]
		{ 600 + 36, 600 + 28, 600 + 28, 600 + 40, 600 + 58, 600 + 66, 600 + 66, 600 + 82, 600 + 74, 600 + 67, 600 + 55,
				600 + 70, 600 + 64 };
		int[] y1 = new int[]
		{ 76, 48, 32, 16, 16, 10, 20, 37, 49, 43, 45, 61, 76 };
		g.fillPolygon(x1, y1, 13);
		int[] x2 = new int[]
		{ 600 + 36, 600 + 64, 600 + 74, 600 + 26 };
		int[] y2 = new int[]
		{ 76, 76, 88, 88 };
		g.fillPolygon(x2, y2, 4);
		g.setColor(Color.WHITE);
		g.fillOval(600 + 62, 26, 6, 6);
	}

	public static void drawKnightWhite1(Graphics g)
	{
		g.setColor(Color.WHITE);
		int[] x1 = new int[]
		{ 100 + 36, 100 + 28, 100 + 28, 100 + 40, 100 + 58, 100 + 66, 100 + 66, 100 + 82, 100 + 74, 100 + 67, 100 + 55,
				100 + 70, 100 + 64 };
		int[] y1 = new int[]
		{ 700 + 76, 700 + 48, 700 + 32, 700 + 16, 700 + 16, 700 + 10, 700 + 20, 700 + 37, 700 + 49, 700 + 43, 700 + 45,
				700 + 61, 700 + 76 };
		g.fillPolygon(x1, y1, 13);
		int[] x2 = new int[]
		{ 100 + 36, 100 + 64, 100 + 74, 100 + 26 };
		int[] y2 = new int[]
		{ 700 + 76, 700 + 76, 700 + 88, 700 + 88 };
		g.fillPolygon(x2, y2, 4);
		g.setColor(Color.BLACK);
		g.fillOval(100 + 62, 700 + 26, 6, 6);
	}

	public static void drawKnightWhite2(Graphics g)
	{
		g.setColor(Color.WHITE);
		int[] x1 = new int[]
		{ 600 + 36, 600 + 28, 600 + 28, 600 + 40, 600 + 58, 600 + 66, 600 + 66, 600 + 82, 600 + 74, 600 + 67, 600 + 55,
				600 + 70, 600 + 64 };
		int[] y1 = new int[]
		{ 700 + 76, 700 + 48, 700 + 32, 700 + 16, 700 + 16, 700 + 10, 700 + 20, 700 + 37, 700 + 49, 700 + 43, 700 + 45,
				700 + 61, 700 + 76 };
		g.fillPolygon(x1, y1, 13);
		int[] x2 = new int[]
		{ 600 + 36, 600 + 64, 600 + 74, 600 + 26 };
		int[] y2 = new int[]
		{ 700 + 76, 700 + 76, 700 + 88, 700 + 88 };
		g.fillPolygon(x2, y2, 4);
		g.setColor(Color.BLACK);
		g.fillOval(600 + 62, 700 + 26, 6, 6);
	}

	public static void drawBlackQueen(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(400 + 27, 71, 46, 8);
		int[] x = new int[]
		{ 400 + 27, 400 + 73, 400 + 80, 400 + 20 };
		int[] y = new int[]
		{ 79, 79, 87, 87 };
		g.fillPolygon(x, y, 4);

		int[] x2 = new int[]
		{ 400 + 27, 400 + 37, 400 + 27 };
		int[] y2 = new int[]
		{ 33, 71, 71 };
		g.fillPolygon(x2, y2, 3);
		g.fillOval(400 + 27 - 5, 33 - 5, 10, 10);

		int[] x3 = new int[]
		{ 400 + 50 + 23, 400 + 50 + 23, 400 + 50 + 23 - 10 };
		int[] y3 = new int[]
		{ 33, 71, 71 };
		g.fillPolygon(x3, y3, 3);
		g.fillOval(400 + 50 + 23 - 5, 33 - 5, 10, 10);

		int[] x4 = new int[]
		{ 400 + 50 - 12, 400 + 50 - 12 + 7, 400 + 50 - 12 - 7 };
		int[] y4 = new int[]
		{ 28, 71, 71 };
		g.fillPolygon(x4, y4, 3);
		g.fillOval(400 + 50 - 12 - 5, 28 - 5, 10, 10);

		int[] x5 = new int[]
		{ 400 + 50 + 12, 400 + 50 + 12 + 7, 400 + 50 + 12 - 7 };
		int[] y5 = new int[]
		{ 28, 71, 71 };
		g.fillPolygon(x5, y5, 3);
		g.fillOval(400 + 50 + 12 - 5, 28 - 5, 10, 10);

		int[] x6 = new int[]
		{ 400 + 50, 400 + 50 + 8, 400 + 50 - 8 };
		int[] y6 = new int[]
		{ 23, 71, 71 };
		g.fillPolygon(x6, y6, 3);
		g.fillOval(400 + 50 - 5, 23 - 5, 10, 10);
	}

	public static void drawWhiteQueen(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(300 + 27, 700 + 71, 46, 8);
		int[] x = new int[]
		{ 300 + 27, 300 + 73, 300 + 80, 300 + 20 };
		int[] y = new int[]
		{ 700 + 79, 700 + 79, 700 + 87, 700 + 87 };
		g.fillPolygon(x, y, 4);

		int[] x2 = new int[]
		{ 300 + 27, 300 + 37, 300 + 27 };
		int[] y2 = new int[]
		{ 700 + 33, 700 + 71, 700 + 71 };
		g.fillPolygon(x2, y2, 3);
		g.fillOval(300 + 27 - 5, 700 + 33 - 5, 10, 10);

		int[] x3 = new int[]
		{ 300 + 50 + 23, 300 + 50 + 23, 300 + 50 + 23 - 10 };
		int[] y3 = new int[]
		{ 700 + 33, 700 + 71, 700 + 71 };
		g.fillPolygon(x3, y3, 3);
		g.fillOval(300 + 50 + 23 - 5, 700 + 33 - 5, 10, 10);

		int[] x4 = new int[]
		{ 300 + 50 - 12, 300 + 50 - 12 + 7, 300 + 50 - 12 - 7 };
		int[] y4 = new int[]
		{ 700 + 28, 700 + 71, 700 + 71 };
		g.fillPolygon(x4, y4, 3);
		g.fillOval(300 + 50 - 12 - 5, 700 + 28 - 5, 10, 10);

		int[] x5 = new int[]
		{ 300 + 50 + 12, 300 + 50 + 12 + 7, 300 + 50 + 12 - 7 };
		int[] y5 = new int[]
		{ 700 + 28, 700 + 71, 700 + 71 };
		g.fillPolygon(x5, y5, 3);
		g.fillOval(300 + 50 + 12 - 5, 700 + 28 - 5, 10, 10);

		int[] x6 = new int[]
		{ 300 + 50, 300 + 50 + 8, 300 + 50 - 8 };
		int[] y6 = new int[]
		{ 700 + 23, 700 + 71, 700 + 71 };
		g.fillPolygon(x6, y6, 3);
		g.fillOval(300 + 50 - 5, 700 + 23 - 5, 10, 10);
	}

	public static void drawBlackKing(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillOval(300 + 50 - 8, 22, 16, 20);

		g.setColor(Color.WHITE);
		Graphics2D g2d = (Graphics2D) g;
		Stroke stroke = new BasicStroke(6f);
		g2d.setStroke(stroke);
		g.drawLine(300 + 50, 13, 300 + 50, 13 + 14);
		g.drawLine(300 + 50 - 7, 13 + 7, 300 + 50 + 7, 13 + 7);
		stroke = new BasicStroke(1f);
		g2d.setStroke(stroke);

		g.setColor(Color.BLACK);
		g.translate(300 + 16 + 19, 29 + 23);
		g2d.rotate(Math.toRadians(-30));
		g.fillOval(-19, -23, 38, 46);
		g2d.rotate(Math.toRadians(30));
		g.translate(-(300 + 16 + 19), -(29 + 23));

		g.translate(300 + 46 + 19, 29 + 23);
		g2d.rotate(Math.toRadians(30));
		g.fillOval(-19, -23, 38, 46);
		g2d.rotate(Math.toRadians(-30));
		g.translate(-(300 + 46 + 19), -(29 + 23));

		g.fillRect(300 + 27, 60, 46, 25);

	}

	public static void drawWhiteKing(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillOval(400 + 50 - 8, 700 + 22, 16, 20);

		g.setColor(Color.BLACK);
		Graphics2D g2d = (Graphics2D) g;
		Stroke stroke = new BasicStroke(6f);
		g2d.setStroke(stroke);
		g.drawLine(400 + 50, 700 + 13, 400 + 50, 700 + 13 + 14);
		g.drawLine(400 + 50 - 7, 700 + 13 + 7, 400 + 50 + 7, 700 + 13 + 7);
		stroke = new BasicStroke(1f);
		g2d.setStroke(stroke);

		g.setColor(Color.WHITE);
		g.translate(400 + 16 + 19, 700 + 29 + 23);
		g2d.rotate(Math.toRadians(-30));
		g.fillOval(-19, -23, 38, 46);
		g2d.rotate(Math.toRadians(30));
		g.translate(-(400 + 16 + 19), -(700 + 29 + 23));

		g.translate(400 + 46 + 19, 700 + 29 + 23);
		g2d.rotate(Math.toRadians(30));
		g.fillOval(-19, -23, 38, 46);
		g2d.rotate(Math.toRadians(-30));
		g.translate(-(400 + 46 + 19), -(700 + 29 + 23));

		g.fillRect(400 + 27, 700 + 60, 46, 25);

	}
	
	
	
//	public static void drawWhitePawn(Graphics g)
//	{
//		g.setColor(Color.WHITE);
//		for (int i = 0; i < 8; i++)
//		{
//			g.fillOval(40 + 100 * i, 100 + 10, 20, 20);
//			g.fillOval(30 + 100 * i, 100 + 25, 40, 30);
//			g.fillArc(15 + 100 * i, 100 + 50, 70, 76, 0, 180);
//		}
//
//	}
//
//	public static void drawBlackPawn(Graphics g)
//	{
//		g.setColor(Color.BLACK);
//		for (int i = 0; i < 8; i++)
//		{
//			g.fillOval(40 + 100 * i, 600 + 10, 20, 20);
//			g.fillOval(30 + 100 * i, 600 + 25, 40, 30);
//			g.fillArc(15 + 100 * i, 600 + 50, 70, 76, 0, 180);
//		}
//
//	}
//
//	public static void drawWhiteRook1(Graphics g)
//	{
//		g.setColor(Color.WHITE);
//		g.fillRect(16, 10, 18, 11);
//		g.fillRect(41, 10, 18, 11);
//		g.fillRect(66, 10, 18, 11);
//		int[] x1 = new int[]
//		{ 16, 84, 69, 31 };
//		int[] y1 = new int[]
//		{ 21, 21, 33, 33 };
//		g.fillPolygon(x1, y1, 4);
//		g.fillRect(31, 33, 38, 30);
//		int[] x2 = new int[]
//		{ 31, 69, 84, 16 };
//		int[] y2 = new int[]
//		{ 63, 63, 80, 80 };
//		g.fillPolygon(x2, y2, 4);
//		g.fillRect(16, 80, 68, 12);
//	}
//
//	public static void drawWhiteRook2(Graphics g)
//	{
//		g.setColor(Color.WHITE);
//		g.fillRect(16 + 700, 10, 18, 11);
//		g.fillRect(41 + 700, 10, 18, 11);
//		g.fillRect(66 + 700, 10, 18, 11);
//		int[] x1 = new int[]
//		{ 16 + 700, 84 + 700, 69 + 700, 31 + 700 };
//		int[] y1 = new int[]
//		{ 21, 21, 33, 33 };
//		g.fillPolygon(x1, y1, 4);
//		g.fillRect(31 + 700, 33, 38, 30);
//		int[] x2 = new int[]
//		{ 31 + 700, 69 + 700, 84 + 700, 16 + 700 };
//		int[] y2 = new int[]
//		{ 63, 63, 80, 80 };
//		g.fillPolygon(x2, y2, 4);
//		g.fillRect(16 + 700, 80, 68, 12);
//	}
//
//	public static void drawBlackRook1(Graphics g)
//	{
//		g.setColor(Color.BLACK);
//		g.fillRect(16, 10 + 700, 18, 11);
//		g.fillRect(41, 10 + 700, 18, 11);
//		g.fillRect(66, 10 + 700, 18, 11);
//		int[] x1 = new int[]
//		{ 16, 84, 69, 31 };
//		int[] y1 = new int[]
//		{ 21 + 700, 21 + 700, 33 + 700, 33 + 700 };
//		g.fillPolygon(x1, y1, 4);
//		g.fillRect(31, 33 + 700, 38, 30);
//		int[] x2 = new int[]
//		{ 31, 69, 84, 16 };
//		int[] y2 = new int[]
//		{ 63 + 700, 63 + 700, 80 + 700, 80 + 700 };
//		g.fillPolygon(x2, y2, 4);
//		g.fillRect(16, 80 + 700, 68, 12);
//	}
//
//	public static void drawBlackeRook2(Graphics g)
//	{
//		g.setColor(Color.BLACK);
//		g.fillRect(16 + 700, 10 + 700, 18, 11);
//		g.fillRect(41 + 700, 10 + 700, 18, 11);
//		g.fillRect(66 + 700, 10 + 700, 18, 11);
//		int[] x1 = new int[]
//		{ 16 + 700, 84 + 700, 69 + 700, 31 + 700 };
//		int[] y1 = new int[]
//		{ 21 + 700, 21 + 700, 33 + 700, 33 + 700 };
//		g.fillPolygon(x1, y1, 4);
//		g.fillRect(31 + 700, 33 + 700, 38, 30);
//		int[] x2 = new int[]
//		{ 31 + 700, 69 + 700, 84 + 700, 16 + 700 };
//		int[] y2 = new int[]
//		{ 63 + 700, 63 + 700, 80 + 700, 80 + 700 };
//		g.fillPolygon(x2, y2, 4);
//		g.fillRect(16 + 700, 80 + 700, 68, 12);
//	}
//
//	public static void drawWhiteBishop1(Graphics g)
//	{
//		g.setColor(Color.WHITE);
//		g.fillOval(200 + 42, 10, 16, 16);
//		g.fillOval(200 + 34, 25, 32, 32);
//		g.fillOval(200 + 38, 52, 24, 24);
//		int[] x = new int[]
//		{ 200 + 40, 200 + 60, 200 + 74, 200 + 26 };
//		int[] y = new int[]
//		{ 70, 70, 90, 90 };
//		g.fillPolygon(x, y, 4);
//
//		Graphics2D g2d = (Graphics2D) g;
//		g.setColor(Color.BLACK);
//		Stroke stroke = new BasicStroke(8f);
//		g2d.setStroke(stroke);
//		g.setColor(Color.BLACK);
//		g.drawLine(200 + 50, 41 - 9, 200 + 50, 41 - 9 + 18);
//		g.drawLine(200 + 50 - 9, 41, 200 + 50 + 9, 41);
//		stroke = new BasicStroke(1f);
//		g2d.setStroke(stroke);
//
//	}
//
//	public static void drawWhiteBishop2(Graphics g)
//	{
//		g.setColor(Color.WHITE);
//		g.fillOval(500 + 42, 10, 16, 16);
//		g.fillOval(500 + 34, 25, 32, 32);
//		g.fillOval(500 + 38, 52, 24, 24);
//		int[] x = new int[]
//		{ 500 + 40, 500 + 60, 500 + 74, 500 + 26 };
//		int[] y = new int[]
//		{ 70, 70, 90, 90 };
//		g.fillPolygon(x, y, 4);
//
//		Graphics2D g2d = (Graphics2D) g;
//		g.setColor(Color.BLACK);
//		Stroke stroke = new BasicStroke(8f);
//		g2d.setStroke(stroke);
//		g.setColor(Color.BLACK);
//		g.drawLine(500 + 50, 41 - 9, 500 + 50, 41 - 9 + 18);
//		g.drawLine(500 + 50 - 9, 41, 500 + 50 + 9, 41);
//		stroke = new BasicStroke(1f);
//		g2d.setStroke(stroke);
//
//	}
//
//	public static void drawBlackBishop1(Graphics g)
//	{
//		g.setColor(Color.BLACK);
//		g.fillOval(200 + 42, 700 + 10, 16, 16);
//		g.fillOval(200 + 34, 700 + 25, 32, 32);
//		g.fillOval(200 + 38, 700 + 52, 24, 24);
//		int[] x = new int[]
//		{ 200 + 40, 200 + 60, 200 + 74, 200 + 26 };
//		int[] y = new int[]
//		{ 700 + 70, 700 + 70, 700 + 90, 700 + 90 };
//		g.fillPolygon(x, y, 4);
//
//		Graphics2D g2d = (Graphics2D) g;
//		g.setColor(Color.WHITE);
//		Stroke stroke = new BasicStroke(8f);
//		g2d.setStroke(stroke);
//		g.drawLine(200 + 50, 700 + 41 - 9, 200 + 50, 700 + 41 - 9 + 18);
//		g.drawLine(200 + 50 - 9, 700 + 41, 200 + 50 + 9, 700 + 41);
//		stroke = new BasicStroke(1f);
//		g2d.setStroke(stroke);
//
//	}
//
//	public static void drawBlackBishop2(Graphics g)
//	{
//		g.setColor(Color.BLACK);
//		g.fillOval(500 + 42, 700 + 10, 16, 16);
//		g.fillOval(500 + 34, 700 + 25, 32, 32);
//		g.fillOval(500 + 38, 700 + 52, 24, 24);
//		int[] x = new int[]
//		{ 500 + 40, 500 + 60, 500 + 74, 500 + 26 };
//		int[] y = new int[]
//		{ 700 + 70, 700 + 70, 700 + 90, 700 + 90 };
//		g.fillPolygon(x, y, 4);
//
//		Graphics2D g2d = (Graphics2D) g;
//		g.setColor(Color.WHITE);
//		Stroke stroke = new BasicStroke(8f);
//		g2d.setStroke(stroke);
//		g.drawLine(500 + 50, 700 + 41 - 9, 500 + 50, 700 + 41 - 9 + 18);
//		g.drawLine(500 + 50 - 9, 700 + 41, 500 + 50 + 9, 700 + 41);
//		stroke = new BasicStroke(1f);
//		g2d.setStroke(stroke);
//
//	}
//
//	public static void drawKnightWhite1(Graphics g)
//	{
//		g.setColor(Color.WHITE);
//		int[] x1 = new int[]
//		{ 100 + 36, 100 + 28, 100 + 28, 100 + 40, 100 + 58, 100 + 66, 100 + 66, 100 + 82, 100 + 74, 100 + 67, 100 + 55,
//				100 + 70, 100 + 64 };
//		int[] y1 = new int[]
//		{ 76, 48, 32, 16, 16, 10, 20, 37, 49, 43, 45, 61, 76 };
//		g.fillPolygon(x1, y1, 13);
//		int[] x2 = new int[]
//		{ 100 + 36, 100 + 64, 100 + 74, 100 + 26 };
//		int[] y2 = new int[]
//		{ 76, 76, 88, 88 };
//		g.fillPolygon(x2, y2, 4);
//		g.setColor(Color.BLACK);
//		g.fillOval(100 + 62, 26, 6, 6);
//	}
//
//	public static void drawKnightWhite2(Graphics g)
//	{
//		g.setColor(Color.WHITE);
//		int[] x1 = new int[]
//		{ 600 + 36, 600 + 28, 600 + 28, 600 + 40, 600 + 58, 600 + 66, 600 + 66, 600 + 82, 600 + 74, 600 + 67, 600 + 55,
//				600 + 70, 600 + 64 };
//		int[] y1 = new int[]
//		{ 76, 48, 32, 16, 16, 10, 20, 37, 49, 43, 45, 61, 76 };
//		g.fillPolygon(x1, y1, 13);
//		int[] x2 = new int[]
//		{ 600 + 36, 600 + 64, 600 + 74, 600 + 26 };
//		int[] y2 = new int[]
//		{ 76, 76, 88, 88 };
//		g.fillPolygon(x2, y2, 4);
//		g.setColor(Color.BLACK);
//		g.fillOval(600 + 62, 26, 6, 6);
//	}
//
//	public static void drawKnightBlack1(Graphics g)
//	{
//		g.setColor(Color.BLACK);
//		int[] x1 = new int[]
//		{ 100 + 36, 100 + 28, 100 + 28, 100 + 40, 100 + 58, 100 + 66, 100 + 66, 100 + 82, 100 + 74, 100 + 67, 100 + 55,
//				100 + 70, 100 + 64 };
//		int[] y1 = new int[]
//		{ 700 + 76, 700 + 48, 700 + 32, 700 + 16, 700 + 16, 700 + 10, 700 + 20, 700 + 37, 700 + 49, 700 + 43, 700 + 45,
//				700 + 61, 700 + 76 };
//		g.fillPolygon(x1, y1, 13);
//		int[] x2 = new int[]
//		{ 100 + 36, 100 + 64, 100 + 74, 100 + 26 };
//		int[] y2 = new int[]
//		{ 700 + 76, 700 + 76, 700 + 88, 700 + 88 };
//		g.fillPolygon(x2, y2, 4);
//		g.setColor(Color.WHITE);
//		g.fillOval(100 + 62, 700 + 26, 6, 6);
//	}
//
//	public static void drawKnightBlack2(Graphics g)
//	{
//		g.setColor(Color.BLACK);
//		int[] x1 = new int[]
//		{ 600 + 36, 600 + 28, 600 + 28, 600 + 40, 600 + 58, 600 + 66, 600 + 66, 600 + 82, 600 + 74, 600 + 67, 600 + 55,
//				600 + 70, 600 + 64 };
//		int[] y1 = new int[]
//		{ 700 + 76, 700 + 48, 700 + 32, 700 + 16, 700 + 16, 700 + 10, 700 + 20, 700 + 37, 700 + 49, 700 + 43, 700 + 45,
//				700 + 61, 700 + 76 };
//		g.fillPolygon(x1, y1, 13);
//		int[] x2 = new int[]
//		{ 600 + 36, 600 + 64, 600 + 74, 600 + 26 };
//		int[] y2 = new int[]
//		{ 700 + 76, 700 + 76, 700 + 88, 700 + 88 };
//		g.fillPolygon(x2, y2, 4);
//		g.setColor(Color.WHITE);
//		g.fillOval(600 + 62, 700 + 26, 6, 6);
//	}
//
//	public static void drawWhiteQueen(Graphics g)
//	{
//		g.setColor(Color.WHITE);
//		g.fillRect(400 + 27, 71, 46, 8);
//		int[] x = new int[]
//		{ 400 + 27, 400 + 73, 400 + 80, 400 + 20 };
//		int[] y = new int[]
//		{ 79, 79, 87, 87 };
//		g.fillPolygon(x, y, 4);
//
//		int[] x2 = new int[]
//		{ 400 + 27, 400 + 37, 400 + 27 };
//		int[] y2 = new int[]
//		{ 33, 71, 71 };
//		g.fillPolygon(x2, y2, 3);
//		g.fillOval(400 + 27 - 5, 33 - 5, 10, 10);
//
//		int[] x3 = new int[]
//		{ 400 + 50 + 23, 400 + 50 + 23, 400 + 50 + 23 - 10 };
//		int[] y3 = new int[]
//		{ 33, 71, 71 };
//		g.fillPolygon(x3, y3, 3);
//		g.fillOval(400 + 50 + 23 - 5, 33 - 5, 10, 10);
//
//		int[] x4 = new int[]
//		{ 400 + 50 - 12, 400 + 50 - 12 + 7, 400 + 50 - 12 - 7 };
//		int[] y4 = new int[]
//		{ 28, 71, 71 };
//		g.fillPolygon(x4, y4, 3);
//		g.fillOval(400 + 50 - 12 - 5, 28 - 5, 10, 10);
//
//		int[] x5 = new int[]
//		{ 400 + 50 + 12, 400 + 50 + 12 + 7, 400 + 50 + 12 - 7 };
//		int[] y5 = new int[]
//		{ 28, 71, 71 };
//		g.fillPolygon(x5, y5, 3);
//		g.fillOval(400 + 50 + 12 - 5, 28 - 5, 10, 10);
//
//		int[] x6 = new int[]
//		{ 400 + 50, 400 + 50 + 8, 400 + 50 - 8 };
//		int[] y6 = new int[]
//		{ 23, 71, 71 };
//		g.fillPolygon(x6, y6, 3);
//		g.fillOval(400 + 50 - 5, 23 - 5, 10, 10);
//	}
//
//	public static void drawBlackQueen(Graphics g)
//	{
//		g.setColor(Color.BLACK);
//		g.fillRect(300 + 27, 700 + 71, 46, 8);
//		int[] x = new int[]
//		{ 300 + 27, 300 + 73, 300 + 80, 300 + 20 };
//		int[] y = new int[]
//		{ 700 + 79, 700 + 79, 700 + 87, 700 + 87 };
//		g.fillPolygon(x, y, 4);
//
//		int[] x2 = new int[]
//		{ 300 + 27, 300 + 37, 300 + 27 };
//		int[] y2 = new int[]
//		{ 700 + 33, 700 + 71, 700 + 71 };
//		g.fillPolygon(x2, y2, 3);
//		g.fillOval(300 + 27 - 5, 700 + 33 - 5, 10, 10);
//
//		int[] x3 = new int[]
//		{ 300 + 50 + 23, 300 + 50 + 23, 300 + 50 + 23 - 10 };
//		int[] y3 = new int[]
//		{ 700 + 33, 700 + 71, 700 + 71 };
//		g.fillPolygon(x3, y3, 3);
//		g.fillOval(300 + 50 + 23 - 5, 700 + 33 - 5, 10, 10);
//
//		int[] x4 = new int[]
//		{ 300 + 50 - 12, 300 + 50 - 12 + 7, 300 + 50 - 12 - 7 };
//		int[] y4 = new int[]
//		{ 700 + 28, 700 + 71, 700 + 71 };
//		g.fillPolygon(x4, y4, 3);
//		g.fillOval(300 + 50 - 12 - 5, 700 + 28 - 5, 10, 10);
//
//		int[] x5 = new int[]
//		{ 300 + 50 + 12, 300 + 50 + 12 + 7, 300 + 50 + 12 - 7 };
//		int[] y5 = new int[]
//		{ 700 + 28, 700 + 71, 700 + 71 };
//		g.fillPolygon(x5, y5, 3);
//		g.fillOval(300 + 50 + 12 - 5, 700 + 28 - 5, 10, 10);
//
//		int[] x6 = new int[]
//		{ 300 + 50, 300 + 50 + 8, 300 + 50 - 8 };
//		int[] y6 = new int[]
//		{ 700 + 23, 700 + 71, 700 + 71 };
//		g.fillPolygon(x6, y6, 3);
//		g.fillOval(300 + 50 - 5, 700 + 23 - 5, 10, 10);
//	}
//
//	public static void drawWhiteKing(Graphics g)
//	{
//		g.setColor(Color.WHITE);
//		g.fillOval(300 + 50 - 8, 22, 16, 20);
//
//		g.setColor(Color.BLACK);
//		Graphics2D g2d = (Graphics2D) g;
//		Stroke stroke = new BasicStroke(6f);
//		g2d.setStroke(stroke);
//		g.drawLine(300 + 50, 13, 300 + 50, 13 + 14);
//		g.drawLine(300 + 50 - 7, 13 + 7, 300 + 50 + 7, 13 + 7);
//		stroke = new BasicStroke(1f);
//		g2d.setStroke(stroke);
//
//		g.setColor(Color.WHITE);
//		g.translate(300 + 16 + 19, 29 + 23);
//		g2d.rotate(Math.toRadians(-30));
//		g.fillOval(-19, -23, 38, 46);
//		g2d.rotate(Math.toRadians(30));
//		g.translate(-(300 + 16 + 19), -(29 + 23));
//
//		g.translate(300 + 46 + 19, 29 + 23);
//		g2d.rotate(Math.toRadians(30));
//		g.fillOval(-19, -23, 38, 46);
//		g2d.rotate(Math.toRadians(-30));
//		g.translate(-(300 + 46 + 19), -(29 + 23));
//
//		g.fillRect(300 + 27, 60, 46, 25);
//
//	}
//
//	public static void drawBlackKing(Graphics g)
//	{
//		g.setColor(Color.BLACK);
//		g.fillOval(400 + 50 - 8, 700 + 22, 16, 20);
//
//		g.setColor(Color.WHITE);
//		Graphics2D g2d = (Graphics2D) g;
//		Stroke stroke = new BasicStroke(6f);
//		g2d.setStroke(stroke);
//		g.drawLine(400 + 50, 700 + 13, 400 + 50, 700 + 13 + 14);
//		g.drawLine(400 + 50 - 7, 700 + 13 + 7, 400 + 50 + 7, 700 + 13 + 7);
//		stroke = new BasicStroke(1f);
//		g2d.setStroke(stroke);
//
//		g.setColor(Color.BLACK);
//		g.translate(400 + 16 + 19, 700 + 29 + 23);
//		g2d.rotate(Math.toRadians(-30));
//		g.fillOval(-19, -23, 38, 46);
//		g2d.rotate(Math.toRadians(30));
//		g.translate(-(400 + 16 + 19), -(700 + 29 + 23));
//
//		g.translate(400 + 46 + 19, 700 + 29 + 23);
//		g2d.rotate(Math.toRadians(30));
//		g.fillOval(-19, -23, 38, 46);
//		g2d.rotate(Math.toRadians(-30));
//		g.translate(-(400 + 46 + 19), -(700 + 29 + 23));
//
//		g.fillRect(400 + 27, 700 + 60, 46, 25);
//
//	}
}
