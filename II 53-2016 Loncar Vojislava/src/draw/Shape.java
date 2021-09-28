package draw;

import java.awt.Graphics;

public abstract class Shape {

	protected boolean selected;

	public Shape() {

	}

	public Shape(boolean selected) {
		this.selected = selected;
	}

	public abstract void draw(Graphics g);

	public abstract boolean contains(int x, int y);

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}