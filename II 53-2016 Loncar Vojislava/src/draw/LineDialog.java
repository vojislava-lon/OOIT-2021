package draw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LineDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldStartPointX;
	private JTextField textFieldStartPointY;
	private JTextField textFieldEndPointX;
	private JTextField textFieldEndPointY;
	private JTextField textFieldColor;
	private Color colorLine;
	private boolean buttonDrawClicked;

	public LineDialog() {
		setTitle("Line draw dialog");
		setBounds(100, 100, 450, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(95, 158, 160));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {100, 70, 50, 0, 20};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblStartPoint = new JLabel("Start point:");
			lblStartPoint.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
			GridBagConstraints gbc_lblStartPoint = new GridBagConstraints();
			gbc_lblStartPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartPoint.gridx = 0;
			gbc_lblStartPoint.gridy = 0;
			contentPanel.add(lblStartPoint, gbc_lblStartPoint);
		}
		{
			JLabel lblStartPointX = new JLabel("Coordinate X:");
			lblStartPointX.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
			GridBagConstraints gbc_lblStartPointX = new GridBagConstraints();
			gbc_lblStartPointX.anchor = GridBagConstraints.EAST;
			gbc_lblStartPointX.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartPointX.gridx = 0;
			gbc_lblStartPointX.gridy = 1;
			contentPanel.add(lblStartPointX, gbc_lblStartPointX);
		}
		{
			textFieldStartPointX = new JTextField();
			GridBagConstraints gbc_txtStartPointX = new GridBagConstraints();
			gbc_txtStartPointX.insets = new Insets(0, 0, 5, 5);
			gbc_txtStartPointX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtStartPointX.gridx = 1;
			gbc_txtStartPointX.gridy = 1;
			contentPanel.add(textFieldStartPointX, gbc_txtStartPointX);
			textFieldStartPointX.setColumns(10);
		}
		{
			JLabel lblStartPointY = new JLabel("Coordinate Y:");
			lblStartPointY.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
			GridBagConstraints gbc_lblStartPointY = new GridBagConstraints();
			gbc_lblStartPointY.anchor = GridBagConstraints.EAST;
			gbc_lblStartPointY.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartPointY.gridx = 0;
			gbc_lblStartPointY.gridy = 2;
			contentPanel.add(lblStartPointY, gbc_lblStartPointY);
		}
		{
			textFieldStartPointY = new JTextField();
			GridBagConstraints gbc_txtStartPointY = new GridBagConstraints();
			gbc_txtStartPointY.insets = new Insets(0, 0, 5, 5);
			gbc_txtStartPointY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtStartPointY.gridx = 1;
			gbc_txtStartPointY.gridy = 2;
			contentPanel.add(textFieldStartPointY, gbc_txtStartPointY);
			textFieldStartPointY.setColumns(10);
		}
		{
			JLabel lblEndPoint = new JLabel("End Point:");
			lblEndPoint.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
			GridBagConstraints gbc_lblEndPoint = new GridBagConstraints();
			gbc_lblEndPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndPoint.gridx = 0;
			gbc_lblEndPoint.gridy = 4;
			contentPanel.add(lblEndPoint, gbc_lblEndPoint);
		}
		{
			JLabel lblEndPointX = new JLabel("Coordinate X:");
			lblEndPointX.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
			lblEndPointX.setFont(new Font("Tahoma", Font.BOLD, 13));
			GridBagConstraints gbc_lblEndPointX = new GridBagConstraints();
			gbc_lblEndPointX.anchor = GridBagConstraints.EAST;
			gbc_lblEndPointX.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndPointX.gridx = 0;
			gbc_lblEndPointX.gridy = 5;
			contentPanel.add(lblEndPointX, gbc_lblEndPointX);
		}
		{
			textFieldEndPointX = new JTextField();
			GridBagConstraints gbc_txtEndPointX = new GridBagConstraints();
			gbc_txtEndPointX.insets = new Insets(0, 0, 5, 5);
			gbc_txtEndPointX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtEndPointX.gridx = 1;
			gbc_txtEndPointX.gridy = 5;
			contentPanel.add(textFieldEndPointX, gbc_txtEndPointX);
			textFieldEndPointX.setColumns(10);
		}
		{
			JButton btnColor = new JButton("Choose color");
			btnColor.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
			btnColor.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					colorLine = JColorChooser.showDialog(null, "Choose color", null);
					textFieldColor.setBackground(colorLine);
				}
			});
			btnColor.setActionCommand("\r\n");
			GridBagConstraints gbc_btnColor = new GridBagConstraints();
			gbc_btnColor.insets = new Insets(0, 0, 5, 0);
			gbc_btnColor.gridx = 3;
			gbc_btnColor.gridy = 5;
			contentPanel.add(btnColor, gbc_btnColor);
		}
		{
			JLabel lblEndPointY = new JLabel("Coordinate Y:");
			lblEndPointY.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
			GridBagConstraints gbc_lblEndPointY = new GridBagConstraints();
			gbc_lblEndPointY.anchor = GridBagConstraints.EAST;
			gbc_lblEndPointY.insets = new Insets(0, 0, 0, 5);
			gbc_lblEndPointY.gridx = 0;
			gbc_lblEndPointY.gridy = 6;
			contentPanel.add(lblEndPointY, gbc_lblEndPointY);
		}
		{
			textFieldEndPointY = new JTextField();
			GridBagConstraints gbc_txtEndPointY = new GridBagConstraints();
			gbc_txtEndPointY.insets = new Insets(0, 0, 0, 5);
			gbc_txtEndPointY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtEndPointY.gridx = 1;
			gbc_txtEndPointY.gridy = 6;
			contentPanel.add(textFieldEndPointY, gbc_txtEndPointY);
			textFieldEndPointY.setColumns(10);
		}
		{
			textFieldColor = new JTextField();
			GridBagConstraints gbc_txtColor = new GridBagConstraints();
			gbc_txtColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtColor.gridx = 3;
			gbc_txtColor.gridy = 6;
			contentPanel.add(textFieldColor, gbc_txtColor);
			textFieldColor.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(95, 158, 160));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnDraw = new JButton("Draw");
				btnDraw.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
				btnDraw.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						boolean isCorrectInput = false;
						try {
							int sx = Integer.parseInt(textFieldStartPointX.getText());
							int sy = Integer.parseInt(textFieldStartPointY.getText());
							int ex =Integer.parseInt(textFieldEndPointX.getText());
							int ey =Integer.parseInt(textFieldEndPointY.getText());
							if(sx > 0 && sy > 0 && ex > 0 && ey > 0) {
								isCorrectInput = true;
							}
						}catch(Exception e1) {
							isCorrectInput = false;
						}
						if(isCorrectInput) {
							setButtonDrawClicked(true);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "Please enter correct numbers!");
						}						
					}
				});
				btnDraw.setActionCommand("OK");
				buttonPane.add(btnDraw);
				getRootPane().setDefaultButton(btnDraw);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getTextFieldStartPointX() {
		return textFieldStartPointX;
	}

	public void setTextFieldStartPointX(String textFieldStartPointX) {
		this.textFieldStartPointX.setText(textFieldStartPointX);
	}

	public JTextField getTextFieldStartPointY() {
		return textFieldStartPointY;
	}

	public void setTextFieldStartPointY(String textFieldStartPointY) {
		this.textFieldStartPointY.setText(textFieldStartPointY);
	}

	public JTextField getTextFieldEndPointX() {
		return textFieldEndPointX;
	}

	public void setTextFieldEndPointX(String textFieldEndPointX) {
		this.textFieldEndPointX.setText(textFieldEndPointX);
	}

	public JTextField getTextFieldEndPointY() {
		return textFieldEndPointY;
	}

	public void setTextFieldEndPointY(String textFieldEndPointY) {
		this.textFieldEndPointY.setText(textFieldEndPointY);
	}

	public Color getColorLine() {
		return colorLine;
	}

	public void setColorLine(Color colorLine) {
		this.colorLine = colorLine;
	}

	public boolean isButtonDrawClicked() {
		return buttonDrawClicked;
	}

	public void setButtonDrawClicked(boolean buttonDrawClicked) {
		this.buttonDrawClicked = buttonDrawClicked;
	}

	public JTextField getTextFieldColor() {
		return textFieldColor;
	}

	public void setTextFieldColor(JTextField textFieldColor) {
		this.textFieldColor = textFieldColor;
	}

}