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

public class Graphics_Coding_Excercise_4_06
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int type = sc.nextInt();
		sc.nextLine();
		BufferedImage img = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		Graphics2D g2d = (Graphics2D) g;

//		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		g2d.setRenderingHints(rh);

		// Picture Frame back ground white
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, img.getWidth(), img.getHeight());

//		drawTileType1(g);
//		drawTileType2(g);
		if (type == 1)
		{
			drawBigTile1(g);
		} else if (type == 2)
		{
			drawBigTile2(g);
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

	public static void drawTileType1(Graphics g)
	{
		g.setColor(Color.BLACK);
		Graphics2D g2d = (Graphics2D) g;
		Stroke stroke = new BasicStroke(4f);
		g2d.setStroke(stroke);
		g.drawRect(0, 0, 200, 200);
		stroke = new BasicStroke(1f);
		g2d.setStroke(stroke);

		stroke = new BasicStroke(2f);
		g2d.setStroke(stroke);
		for (int j = 0; j < 2; j++)
		{
			g.translate(50 + 100 * j, 50 + 100 * j);
			for (int i = 0; i < 4; i++)
			{
				int angle = 0;
//				System.out.println(i);
				if (i % 2 == 0)
				{
					angle = 90 * i;
					g.setColor(Color.WHITE);

				} else
				{
					angle = 90 * i;
					g.setColor(new Color(0, 130, 200));
				}
				g2d.rotate(Math.toRadians(angle));
				int[] x1 = new int[]
				{ 0, -50, 50 };
				int[] y1 = new int[]
				{ 0, -50, -50 };
				g.fillPolygon(x1, y1, 3);
				g2d.rotate(Math.toRadians(-angle));
			}
			g.translate(-(50 + 100 * j), -(50 + 100 * j));

			g.translate(150 - 100 * j, 50 + 100 * j);
			for (int i = 0; i < 4; i++)
			{
				int angle = 0;
				if (i % 2 == 0)
				{
					angle = 90 * i;
					g.setColor(new Color(0, 130, 200));
				} else
				{
					angle = 90 * i;
					g.setColor(Color.WHITE);
				}
				g2d.rotate(Math.toRadians(angle));
				int[] x1 = new int[]
				{ 0, -50, 50 };
				int[] y1 = new int[]
				{ 0, -50, -50 };
				g.fillPolygon(x1, y1, 3);
				g2d.rotate(Math.toRadians(-angle));
			}
			g.translate(-(150 - 100 * j), -(50 + 100 * j));
		}
		stroke = new BasicStroke(1f);
		g2d.setStroke(stroke);
	}

	public static void drawTileType2(Graphics g)
	{
		g.setColor(Color.BLACK);
		Graphics2D g2d = (Graphics2D) g;

		g.setColor(new Color(0, 130, 200));
		Stroke stroke1 = new BasicStroke(2f);
		g2d.setStroke(stroke1);
		g.drawLine(0, 0, 200, 200);
		g.drawLine(100, 0, 200, 100);
		g.drawLine(0, 100, 100, 200);
		g.drawLine(0, 100, 100, 0);
		g.drawLine(200, 0, 0, 200);
		g.drawLine(200, 100, 100, 200);
		stroke1 = new BasicStroke(1f);
		g2d.setStroke(stroke1);

		for (int j = 0; j < 5; j++)
		{
			for (int k = 0; k < 3; k++)
			{
				if (j % 2 == 0)
				{
					g.translate(100 * k, 50 * j);
				} else
				{
					g.translate(100 * k - 50, 50 * j);
				}

				g2d.rotate(Math.toRadians(22.5));
				int n = 8;
				int[] x = new int[n * 2];
				int[] y = new int[n * 2];

				for (int i = 0; i < n * 2; i++)
				{

					x[i] = (int) (0 + 25 * Math.cos(i * Math.PI / n));
					y[i] = (int) (0 + 25 * Math.sin(i * Math.PI / n));

					i++;

					x[i] = (int) (0 + (25 - 12) * Math.cos(i * Math.PI / n));
					y[i] = (int) (0 + (25 - 12) * Math.sin(i * Math.PI / n));

				}
				g.fillPolygon(x, y, n * 2);
				g2d.rotate(Math.toRadians(-22.5));

				if (j % 2 == 0)
				{
					g.translate(-100 * k, -(50 * j));
				} else
				{
					g.translate(-(100 * k - 50), -(50 * j));
				}
			}
			stroke1 = new BasicStroke(1f);
			g2d.setStroke(stroke1);

		}

		g.setColor(Color.BLACK);
		Stroke stroke = new BasicStroke(2f);
		g2d.setStroke(stroke);
		g.drawRect(0, 0, 200, 200);
		stroke = new BasicStroke(1f);
		g2d.setStroke(stroke);

	}

	public static void drawBigTile2(Graphics g)
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (j % 2 == 0 && i % 2 == 0)
				{
					g.translate(200 * j, 200 * i);
					drawTileType2(g);
					g.translate(-200 * j, -200 * i);
				} else
				{

				}

			}
		}

		g.translate(200, 200);
		drawTileType2(g);
		g.translate(-200, -200);

		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (i % 2 == 0 && j % 2 != 0)
				{
					g.translate(200 * j, 200 * i);
					drawTileType1(g);
					g.translate(-200 * j, -200 * i);
				} else if (i % 2 != 0 && j % 2 == 0)
				{
					g.translate(200 * j, 200 * i);
					drawTileType1(g);
					g.translate(-200 * j, -200 * i);
				}

			}
		}

	}

	public static void drawBigTile1(Graphics g)
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (i % 2 == 0 && j % 2 != 0)
				{
					g.translate(200 * j, 200 * i);
					drawTileType2(g);
					g.translate(-200 * j, -200 * i);
				} else if (i % 2 != 0 && j % 2 == 0)
				{
					g.translate(200 * j, 200 * i);
					drawTileType2(g);
					g.translate(-200 * j, -200 * i);
				}

			}
		}

		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (j % 2 == 0 && i % 2 == 0)
				{
					g.translate(200 * j, 200 * i);
					drawTileType1(g);
					g.translate(-200 * j, -200 * i);
				} else
				{

				}

			}
		}

		g.translate(200, 200);
		drawTileType1(g);
		g.translate(-200, -200);

	}
}
