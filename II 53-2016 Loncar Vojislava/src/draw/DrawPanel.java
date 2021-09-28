package draw;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DrawPanel extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;

	public static OperationType operationType;
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private Shape selectedObject;
	private Point lineStartPoint;

	public DrawPanel() {
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (operationType.equals(OperationType.DRAW_POINT)) {
			Point p = new Point(e.getX(), e.getY());
			PointDialog dlgPoint = new PointDialog();
			dlgPoint.setTextFieldCordinateX(String.valueOf(e.getX()));
			dlgPoint.setTextFieldCordinateY(String.valueOf(e.getY()));
			dlgPoint.setResizable(false);
			dlgPoint.setVisible(true);
			
			p.setColor(dlgPoint.getColorPoint());

			if (dlgPoint.isButtonDrawClicked()) {
				shapes.add(p);
			}
		}
		
		if (operationType.equals(OperationType.DRAW_LINE)) {
			if (lineStartPoint == null) {
				lineStartPoint = new Point(e.getX(), e.getY());
			} else {
				Line l = new Line(lineStartPoint, new Point(e.getX(), e.getY()));
				LineDialog dlgLine = new LineDialog();
				dlgLine.setTextFieldStartPointX(String.valueOf(lineStartPoint.getX()));
				dlgLine.setTextFieldStartPointY(String.valueOf(lineStartPoint.getY()));
				dlgLine.setTextFieldEndPointX(String.valueOf(e.getX()));
				dlgLine.setTextFieldEndPointY(String.valueOf(e.getY()));
				dlgLine.setResizable(false);
				dlgLine.setVisible(true);

				if (dlgLine.isButtonDrawClicked()) {
					l.setColor(dlgLine.getColorLine());
					shapes.add(l);
				}
				lineStartPoint = null;
			}
		}
		
		if (operationType.equals(OperationType.DRAW_CIRCLE)) {
			Point center = new Point(e.getX(), e.getY());
			CircleDialog dlgCircle = new CircleDialog();
			dlgCircle.setTextFieldCenterX(String.valueOf(center.getX()));
			dlgCircle.setTextFieldCenterY(String.valueOf(center.getY()));
			
			dlgCircle.setResizable(false);
			dlgCircle.setVisible(true);

			if (dlgCircle.isButtonDrawClicked()) {
				Circle circle = new Circle(center, Integer.parseInt(dlgCircle.getTextFieldRadius().getText()));
				circle.setBorderColor(dlgCircle.getColorCircleBorder());
				circle.setFillColor(dlgCircle.getColorCircleFill());
				shapes.add(circle);
			}
		}
		
		if (operationType.equals(OperationType.DRAW_DONUT)) {
			Point center = new Point(e.getX(), e.getY());
			DonutDialog dlgDonut = new DonutDialog();
			dlgDonut.setTextFieldCenterX(String.valueOf(e.getX()));
			dlgDonut.setTextFieldCenterY((String.valueOf(e.getY())));
			
			dlgDonut.setResizable(false);
			dlgDonut.setVisible(true);

			if (dlgDonut.isButtonDrawClicked()) {
				Donut d = new Donut(center, Integer.parseInt(dlgDonut.getTextFieldRadius().getText()),
						Integer.parseInt(dlgDonut.getTextFieldInnerRadius().getText()));
				d.setBorderColor(dlgDonut.getColorCircleBorder());
				d.setFillColor(dlgDonut.getColorCircleFill());
				shapes.add(d);
			}
		}
		
		if (operationType.equals(OperationType.DRAW_RECTANGLE)) {
			Point upperLeft = new Point(e.getX(), e.getY());
			RectangleDialog dlgRectangle = new RectangleDialog();
			dlgRectangle.setTextFieldUpperLeftPointX(String.valueOf(e.getX()));
			dlgRectangle.setTextFieldUpperLeftPointY(String.valueOf(e.getY()));
			dlgRectangle.setResizable(false);
			dlgRectangle.setVisible(true);

			if (dlgRectangle.isButtonClicked()) {
				Rectangle r = new Rectangle(upperLeft, Integer.parseInt(dlgRectangle.getTextFieldWidth().getText()),
						Integer.parseInt(dlgRectangle.getTextFieldHeight().getText()));
				r.setBorderColor(dlgRectangle.getColorRectangleBorder());
				r.setFillColor(dlgRectangle.getColorRectangleFill());
				shapes.add(r);
			}
		}
		
		if (operationType.equals(OperationType.SELECT)) {
			for (int i = 0; i < shapes.size(); i++) {
				selectedObject = null;
				shapes.get(i).setSelected(false);
				if (shapes.get(i).contains(e.getX(), e.getY())) {
					selectedObject = shapes.get(i);
					shapes.get(i).setSelected(true);
				}
			}
		}
		
		if(operationType.equals(OperationType.MODIFY)) {
			selectedObject = null;
			for (int i = 0; i < shapes.size(); i++) {
				shapes.get(i).setSelected(false);
			}

			for (int i = 0; i < shapes.size(); i++) {
				if (shapes.get(i).contains(e.getX(), e.getY())) {
					selectedObject = shapes.get(i);
					shapes.get(i).setSelected(true);
					break;
				}
			}

			if (selectedObject != null) {
				if (selectedObject instanceof Point) {
					Point point1 = (Point) selectedObject;
					PointDialog dlgPoint = new PointDialog();
					dlgPoint.setTextFieldCordinateX(String.valueOf(point1.getX()));
					dlgPoint.setTextFieldCordinateY(String.valueOf(point1.getY()));
					dlgPoint.setColorPoint(point1.getColor());
					dlgPoint.getTextFieldColor().setBackground(point1.getColor());
					
					dlgPoint.setResizable(false);
					dlgPoint.setVisible(true);

					if (dlgPoint.isButtonDrawClicked()) {
						Point point2 = new Point(Integer.parseInt(dlgPoint.getTextFieldCordinateX().getText()),
								(Integer.parseInt(dlgPoint.getTextFieldCordinateY().getText())));
						point2.setColor(dlgPoint.getColorPoint());
						for (int i = 0; i < shapes.size(); i++) {
							if (shapes.get(i).isSelected()) {
								shapes.remove(i);
								shapes.add(i, point2);
								break;
							}
						}
					}
				} else if (selectedObject instanceof Line) {
					Line line1 = (Line) selectedObject;
					LineDialog dlgLine = new LineDialog();
					dlgLine.setTextFieldStartPointX(String.valueOf(line1.getStartPoint().getX()));
					dlgLine.setTextFieldStartPointY(String.valueOf(line1.getStartPoint().getY()));
					dlgLine.setTextFieldEndPointX(String.valueOf(line1.getEndPoint().getX()));
					dlgLine.setTextFieldEndPointY(String.valueOf(line1.getEndPoint().getY()));
					dlgLine.setColorLine(line1.getColor());
					dlgLine.getTextFieldColor().setBackground(line1.getColor());
					dlgLine.setResizable(false);
					dlgLine.setVisible(true);

					if (dlgLine.isButtonDrawClicked()) {
						Point startPoint = new Point(Integer.parseInt(dlgLine.getTextFieldStartPointX().getText()),
								Integer.parseInt(dlgLine.getTextFieldStartPointY().getText()));
						Point endPoint = new Point(Integer.parseInt(dlgLine.getTextFieldEndPointX().getText()),
								Integer.parseInt(dlgLine.getTextFieldEndPointY().getText()));
						Line line2 = new Line(startPoint, endPoint);
						line2.setColor(dlgLine.getColorLine());
						for (int i = 0; i < shapes.size(); i++) {
							if (shapes.get(i).isSelected()) {
								shapes.remove(i);
								shapes.add(i, line2);
								break;
							}
						}
					}
				} else if (selectedObject instanceof Donut) {
					Donut donut1 = (Donut) selectedObject;
					DonutDialog dlgDonut = new DonutDialog();
					dlgDonut.setTextFieldCenterX(String.valueOf(donut1.getCenter().getX()));
					dlgDonut.setTextFieldCenterY(String.valueOf(donut1.getCenter().getY()));
					dlgDonut.setTextFieldRadius(String.valueOf(donut1.getR()));
					dlgDonut.setTextInnerRadius(String.valueOf(donut1.getInnerR()));
					dlgDonut.setColorCircleBorder(donut1.getBorderColor());
					dlgDonut.getTextBorderColorCircle().setBackground(donut1.getBorderColor());
					dlgDonut.setColorCircleFill(donut1.getFillColor());
					dlgDonut.getTextFillColorCircle().setBackground(donut1.getFillColor());
					dlgDonut.setResizable(false);
					dlgDonut.setVisible(true);

					if (dlgDonut.isButtonDrawClicked()) {
						Point p = new Point(Integer.parseInt(dlgDonut.getTextFieldCenterX().getText()),
								Integer.parseInt((dlgDonut.getTextCenterY().getText())));
						Donut donut2 = new Donut(p, Integer.parseInt(dlgDonut.getTextFieldRadius().getText()),
								Integer.parseInt(dlgDonut.getTextFieldInnerRadius().getText()));
						donut2.setBorderColor(dlgDonut.getColorCircleBorder());
						donut2.setFillColor(dlgDonut.getColorCircleFill());
						for (int i = 0; i < shapes.size(); i++) {
							if (shapes.get(i).isSelected()) {
								shapes.remove(i);
								shapes.add(i, donut2);
								break;
							}
						}
					}
				} else if (selectedObject instanceof Rectangle) {
					Rectangle rectangle1 = (Rectangle) selectedObject;
					RectangleDialog dlgRectangle = new RectangleDialog();
					dlgRectangle.setTextFieldUpperLeftPointX(String.valueOf(rectangle1.getUpperLeft().getX()));
					dlgRectangle.setTextFieldUpperLeftPointY(String.valueOf(rectangle1.getUpperLeft().getY()));
					dlgRectangle.setTextWidth(String.valueOf(rectangle1.getWidth()));
					dlgRectangle.setTextFieldHeight(String.valueOf(rectangle1.getHeight()));
					dlgRectangle.setColorRectangleBorder(rectangle1.getBorderColor());
					dlgRectangle.getTextBorderColorRectangle().setBackground(rectangle1.getBorderColor());
					dlgRectangle.setColorRectangleFill(rectangle1.getFillColor());
					dlgRectangle.getTextFillColorRectangle().setBackground(rectangle1.getFillColor());
					dlgRectangle.setResizable(false);
					dlgRectangle.setVisible(true);

					if (dlgRectangle.isButtonClicked()) {
						Point p = new Point(Integer.parseInt(dlgRectangle.getTextUpperLeftPointX().getText()),
								Integer.parseInt((dlgRectangle.getTextFieldUpperLeftPointY().getText())));
						Rectangle rectangle2 = new Rectangle(p, Integer.parseInt(dlgRectangle.getTextFieldWidth().getText()),
								Integer.parseInt(dlgRectangle.getTextFieldHeight().getText()));
						rectangle2.setBorderColor(dlgRectangle.getColorRectangleBorder());
						rectangle2.setFillColor(dlgRectangle.getColorRectangleFill());

						for (int i = 0; i < shapes.size(); i++) {
							if (shapes.get(i).isSelected()) {
								shapes.remove(i);
								shapes.add(i, rectangle2);
								break;
							}
						}
					}
				} else {
					Circle circle1 = (Circle) selectedObject;
					CircleDialog dlgCircle = new CircleDialog();
					dlgCircle.setTextFieldCenterX(String.valueOf(circle1.getCenter().getX()));
					dlgCircle.setTextFieldCenterY(String.valueOf(circle1.getCenter().getY()));
					dlgCircle.setTextFieldRadius(String.valueOf(circle1.getR()));
					dlgCircle.setColorCircleBorder(circle1.getBorderColor());
					dlgCircle.getTextBorderColorCircle().setBackground(circle1.getBorderColor());
					dlgCircle.setColorCircleFill(circle1.getFillColor());
					dlgCircle.getTextFillColorCircle().setBackground(circle1.getFillColor());
					
					dlgCircle.setResizable(false);
					dlgCircle.setVisible(true);

					if (dlgCircle.isButtonDrawClicked()) {
						Point p = new Point(Integer.parseInt(dlgCircle.getTextFieldCenterX().getText()),
								Integer.parseInt(dlgCircle.getTextFieldCenterY().getText()));
						Circle circle2 = new Circle(p, Integer.parseInt(dlgCircle.getTextFieldRadius().getText()));
						circle2.setBorderColor(dlgCircle.getColorCircleBorder());
						circle2.setFillColor(dlgCircle.getColorCircleFill());

						for (int i = 0; i < shapes.size(); i++) {
							if (shapes.get(i).isSelected()) {
								shapes.remove(i);
								shapes.add(i, circle2);
								break;
							}
						}
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Please select a shape first!");
			}
		}

		if (operationType.equals(OperationType.DELETE)) {
			for (int i = 0; i < shapes.size(); i++) {
				selectedObject = null;
				shapes.get(i).setSelected(false);
				if (shapes.get(i).contains(e.getX(), e.getY())) {
					selectedObject = shapes.get(i);
					shapes.get(i).setSelected(true);
				}
			}
			
			repaint();
			
			int remove = JOptionPane.showConfirmDialog(null,
					"Are you sure that you want to delete selected shape?");
			if (remove == JOptionPane.YES_OPTION) {
				for (int i = 0; i < shapes.size(); i++) {
					if (shapes.get(i).isSelected()) {
						shapes.remove(i);
						break;
					}
				}
			}
		}

		if (shapes != null) {
			repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < shapes.size(); i++) {
			shapes.get(i).draw(g);
		}
	}

	public static OperationType getOperationType() {
		return operationType;
	}

	public static void setOperationType(OperationType operationType) {
		DrawPanel.operationType = operationType;
	}
}