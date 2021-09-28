package draw;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	private Point upperLeft;
	private int width;
	private int height;
	private Color fillColor;
	private Color borderColor;

	public Rectangle() {

	}

	public Rectangle(Point upperLeft, int width, int height) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
	}

	public Rectangle(Point upperLeft, int width, int height, boolean selected) {
		this(upperLeft, width, height);
		this.selected = selected;
	}

	public int area() {
		return width * height;
	}

	@Override
	public String toString() {
		return "Upper left point: " + upperLeft + ", width: " + width + ", height: " + height;
	}

	public Point getUpperLeft() {
		return upperLeft;
	}

	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
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
			g.fillRect(this.getUpperLeft().getX(), this.getUpperLeft().getY(), this.width, this.getHeight());
		}

		if (borderColor != null) {
			g.setColor(borderColor);
			g.drawRect(this.getUpperLeft().getX(), this.getUpperLeft().getY(), this.width, this.getHeight());
		} else {
			g.setColor(Color.BLACK);
			g.drawRect(this.getUpperLeft().getX(), this.getUpperLeft().getY(), this.width, this.getHeight());
		}

		if (isSelected()) {
			g.setColor(Color.BLACK);
			g.drawRect(getUpperLeft().getX() - 3, getUpperLeft().getY() - 3, 6, 6);
			g.drawRect(getUpperLeft().getX() + getWidth() - 3, getUpperLeft().getY() - 3, 6, 6);
			g.drawRect(getUpperLeft().getX() - 3, getUpperLeft().getY() + getHeight() - 3, 6, 6);
			g.drawRect(getUpperLeft().getX() + getWidth() - 3, getUpperLeft().getY() + getHeight() - 3, 6, 6);
		}
	}

	@Override
	public boolean contains(int x, int y) {
		return (upperLeft.getX() <= x && upperLeft.getX() + width >= x && upperLeft.getY() <= y
				&& upperLeft.getY() + height >= y);
	}
}