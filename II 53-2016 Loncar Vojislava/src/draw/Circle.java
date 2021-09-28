package draw;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {

	protected Point center;
	protected int r;
	protected Color fillColor;
	protected Color borderColor;

	public Circle() {

	}

	public Circle(Point center, int r) {
		this.center = center;
		this.r = r;
	}

	public Circle(Point center, int r, boolean selected) {
		this(center, r);
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "Center:" + center + "," + "radius = " + r;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	@Override
	public void draw(Graphics g) {
		if (fillColor != null) {

			g.setColor(fillColor);
			g.fillOval(this.getCenter().getX() - this.getR(), this.getCenter().getY() - this.getR(), this.getR() * 2,
					this.getR() * 2);
		}
		if (borderColor != null) {
			g.setColor(borderColor);
			g.drawOval(this.getCenter().getX() - getR(), getCenter().getY() - this.r, this.getR() * 2, this.getR() * 2);
		} else {
			g.setColor(Color.black);
			g.drawOval(this.getCenter().getX() - getR(), getCenter().getY() - this.r, this.getR() * 2, this.getR() * 2);
		}

		if (isSelected()) {
			g.setColor(Color.BLACK);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3 + getR(), getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3 - getR(), getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() - getR() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() + getR() - 3, 6, 6);

		}

	}

	@Override
	public boolean contains(int x, int y) {
		return center.distance(x, y) <= r;
	}
}