package draw;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {
	
	private int innerR;
	private Color donutFillColor;
	private Color donutBorderColor;

	public Donut() {
	}

	public Donut(Point center, int r, int innerR) {
		super(center, r);
		this.innerR = innerR;
	}

	public Donut(Point center, int r, int innerR, boolean selected) {
		this(center, r, innerR);
		this.selected = selected;
	}

	@Override
	public String toString() {
		return super.toString() + ", inner radius = " + innerR;
	}

	public int getInnerR() {
		return innerR;
	}

	public void setInnerR(int innerR) {
		this.innerR = innerR;
	}
	
	public Color getDonutFillColor() {
		return donutFillColor;
	}

	public void setDonutFillColor(Color donutFillColor) {
		this.donutFillColor = donutFillColor;
	}

	public Color getDonutBorderColor() {
		return donutBorderColor;
	}

	public void setDonutBorderColor(Color donutBorderColor) {
		this.donutBorderColor = donutBorderColor;
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(Color.WHITE);
		g.fillOval(this.getCenter().getX() - this.getInnerR(), this.getCenter().getY() - this.getInnerR(),
				this.getInnerR() * 2, this.getInnerR() * 2);
		g.setColor(super.getBorderColor());
		g.drawOval(this.getCenter().getX() - this.getInnerR(), this.getCenter().getY() - this.getInnerR(),
				this.getInnerR() * 2, this.getInnerR() * 2);

		if (isSelected()) {
			g.setColor(Color.BLACK);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - getInnerR() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + getInnerR() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - getInnerR() - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() + getInnerR() - 3, this.getCenter().getY() - 3, 6, 6);
		}

	}

	@Override
	public boolean contains(int x, int y) {
		return super.contains(x, y) && this.getCenter().distance(x, y) >= this.getInnerR();
	}

}
