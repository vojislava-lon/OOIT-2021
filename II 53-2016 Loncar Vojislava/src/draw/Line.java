package draw;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
	
	private Point startPoint;
	private Point endPoint;
	private Color color;

	public Line() {

	}

	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		this.selected = selected;
	}

	public Point middleOfLine() {
		int middleOfLineX = (this.getStartPoint().getX() + this.getEndPoint().getX()) / 2;
		int middleOfLineY = (this.getStartPoint().getY() + this.getEndPoint().getY()) / 2;
		Point middlePoint = new Point(middleOfLineX, middleOfLineY);
		return middlePoint;
	}

	public double length() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}

	public String toString() {
		return startPoint + " ----> " + endPoint;
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public void draw(Graphics g) {
		if (color == null) {
			g.setColor(Color.BLACK);
		} else {
			g.setColor(color);
		}
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());

		if (isSelected()) {
			g.setColor(Color.BLACK);
			g.drawRect(this.getStartPoint().getX() - 3, this.getStartPoint().getY() - 3, 6, 6);
			g.drawRect(getEndPoint().getX() - 3, getEndPoint().getY() - 3, 6, 6);
			g.drawRect(middleOfLine().getX() - 3, middleOfLine().getY() - 3, 6, 6);
		}

	}

	@Override
	public boolean contains(int x, int y) {
		return (startPoint.distance(x, y) + endPoint.distance(x, y) - length() < 0.1);
	}

}