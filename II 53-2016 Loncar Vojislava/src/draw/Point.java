package draw;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {

	private int x;
	private int y;
	private Color color;

	public Point() {
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public double distance(int x, int y) {
		int dX = this.x - x;
		int dY = this.y - y;
		double d = Math.sqrt(dX * dX + dY * dY);
		return d;
	}

	@Override
	public void draw(Graphics g) {
		if (color == null) {
			g.setColor(Color.BLACK);
		} else {
			g.setColor(color);
		}
		g.drawLine(x - 2, y, x + 2, y);
		g.drawLine(x, y + 2, x, y - 2);

		if (isSelected()) {
			g.setColor(Color.BLACK);
			g.drawRect(this.x - 3, this.y - 3, 6, 6);
		}
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public boolean contains(int x, int y) {
		return this.distance(x, y) <= 2;
	}
}