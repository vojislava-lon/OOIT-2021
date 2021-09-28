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
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RectangleDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldWidth;
	private JTextField textFieldUpperLeftPointX;
	private JTextField textFieldUpperLeftPointY;
	private JTextField textFieldHeight;
	private JTextField textFillColorRectangle;
	private JTextField textBorderColorRectangle;
	private Color colorRectangleFill;
	private Color colorRectangleBorder;
	private boolean buttonDrawClicked;

	public RectangleDialog() {
		setTitle("Rectangle draw dialog");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(95, 158, 160));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblUpperLeftPoint = new JLabel("UpperLeft Point:");
			lblUpperLeftPoint.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
			GridBagConstraints gbc_lblUpperLeftPoint = new GridBagConstraints();
			gbc_lblUpperLeftPoint.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpperLeftPoint.gridx = 0;
			gbc_lblUpperLeftPoint.gridy = 0;
			contentPanel.add(lblUpperLeftPoint, gbc_lblUpperLeftPoint);
		}
		{
			JLabel lblUpperLeftPointX = new JLabel("Coordinate X:");
			lblUpperLeftPointX.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
			GridBagConstraints gbc_lblUpperLeftPointX = new GridBagConstraints();
			gbc_lblUpperLeftPointX.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpperLeftPointX.gridx = 0;
			gbc_lblUpperLeftPointX.gridy = 1;
			contentPanel.add(lblUpperLeftPointX, gbc_lblUpperLeftPointX);
		}
		{
			JLabel label = new JLabel("Dimensions:");
			label.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 0;
			gbc_label.gridy = 3;
			contentPanel.add(label, gbc_label);
		}
		{
			JLabel lblWidth = new JLabel("Width:");
			lblWidth.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.gridx = 0;
			gbc_lblWidth.gridy = 4;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			textFieldUpperLeftPointX = new JTextField();
			GridBagConstraints gbc_textUpperLeftPointX = new GridBagConstraints();
			gbc_textUpperLeftPointX.insets = new Insets(0, 0, 5, 5);
			gbc_textUpperLeftPointX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textUpperLeftPointX.gridx = 0;
			gbc_textUpperLeftPointX.gridy = 2;
			contentPanel.add(textFieldUpperLeftPointX, gbc_textUpperLeftPointX);
			textFieldUpperLeftPointX.setColumns(10);
		}
		{
			textFieldWidth = new JTextField();
			GridBagConstraints gbc_textWidth = new GridBagConstraints();
			gbc_textWidth.insets = new Insets(0, 0, 5, 5);
			gbc_textWidth.fill = GridBagConstraints.HORIZONTAL;
			gbc_textWidth.gridx = 0;
			gbc_textWidth.gridy = 5;
			contentPanel.add(textFieldWidth, gbc_textWidth);
			textFieldWidth.setColumns(10);
		}
		{
			JLabel lblUpperLeftPointY = new JLabel("Coordinate Y:");
			lblUpperLeftPointY.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
			GridBagConstraints gbc_lblUpperLeftPointY = new GridBagConstraints();
			gbc_lblUpperLeftPointY.insets = new Insets(0, 0, 5, 0);
			gbc_lblUpperLeftPointY.gridx = 2;
			gbc_lblUpperLeftPointY.gridy = 1;
			contentPanel.add(lblUpperLeftPointY, gbc_lblUpperLeftPointY);
		}
		{
			JLabel lblHeight = new JLabel("Height:");
			lblHeight.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.insets = new Insets(0, 0, 5, 0);
			gbc_lblHeight.gridx = 2;
			gbc_lblHeight.gridy = 4;
			contentPanel.add(lblHeight, gbc_lblHeight);
		}
		{
			textFieldUpperLeftPointY = new JTextField();
			GridBagConstraints gbc_textUpperLeftPointY = new GridBagConstraints();
			gbc_textUpperLeftPointY.insets = new Insets(0, 0, 5, 0);
			gbc_textUpperLeftPointY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textUpperLeftPointY.gridx = 2;
			gbc_textUpperLeftPointY.gridy = 2;
			contentPanel.add(textFieldUpperLeftPointY, gbc_textUpperLeftPointY);
			textFieldUpperLeftPointY.setColumns(10);
		}
		{
			textFieldHeight = new JTextField();
			GridBagConstraints gbc_textHeight = new GridBagConstraints();
			gbc_textHeight.insets = new Insets(0, 0, 5, 0);
			gbc_textHeight.fill = GridBagConstraints.HORIZONTAL;
			gbc_textHeight.gridx = 2;
			gbc_textHeight.gridy = 5;
			contentPanel.add(textFieldHeight, gbc_textHeight);
			textFieldHeight.setColumns(10);
		}
		{
			JButton btnFillColorRectangle = new JButton("Fill Color");
			btnFillColorRectangle.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
			btnFillColorRectangle.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					colorRectangleFill = JColorChooser.showDialog(null, "Choose color", null);
					textFillColorRectangle.setBackground(colorRectangleFill);
				}
			});
			GridBagConstraints gbc_btnFillColorRectangle = new GridBagConstraints();
			gbc_btnFillColorRectangle.insets = new Insets(0, 0, 5, 5);
			gbc_btnFillColorRectangle.gridx = 0;
			gbc_btnFillColorRectangle.gridy = 6;
			contentPanel.add(btnFillColorRectangle, gbc_btnFillColorRectangle);
		}
		{
			JButton btnBorderColorRectangle = new JButton("Border Color");
			btnBorderColorRectangle.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
			btnBorderColorRectangle.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					colorRectangleBorder = JColorChooser.showDialog(null, "Choose color", null);
					textBorderColorRectangle.setBackground(colorRectangleBorder);
				}
			});
			GridBagConstraints gbc_btnBorderColorRectangle = new GridBagConstraints();
			gbc_btnBorderColorRectangle.insets = new Insets(0, 0, 5, 0);
			gbc_btnBorderColorRectangle.gridx = 2;
			gbc_btnBorderColorRectangle.gridy = 6;
			contentPanel.add(btnBorderColorRectangle, gbc_btnBorderColorRectangle);
		}
		{
			textFillColorRectangle = new JTextField();
			GridBagConstraints gbc_textFillColorRectangle = new GridBagConstraints();
			gbc_textFillColorRectangle.insets = new Insets(0, 0, 0, 5);
			gbc_textFillColorRectangle.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFillColorRectangle.gridx = 0;
			gbc_textFillColorRectangle.gridy = 7;
			contentPanel.add(textFillColorRectangle, gbc_textFillColorRectangle);
			textFillColorRectangle.setColumns(10);
		}
		{
			textBorderColorRectangle = new JTextField();
			GridBagConstraints gbc_textBorderColorRectangle = new GridBagConstraints();
			gbc_textBorderColorRectangle.fill = GridBagConstraints.HORIZONTAL;
			gbc_textBorderColorRectangle.gridx = 2;
			gbc_textBorderColorRectangle.gridy = 7;
			contentPanel.add(textBorderColorRectangle, gbc_textBorderColorRectangle);
			textBorderColorRectangle.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(95, 158, 160));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Draw");
				okButton.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						boolean isCorrectInput = false;
						try {
							int w = Integer.parseInt(textFieldWidth.getText());
							int h = Integer.parseInt(textFieldHeight.getText());
							int ux =Integer.parseInt(textFieldUpperLeftPointX.getText());
							int uy =Integer.parseInt(textFieldUpperLeftPointY.getText());
							if(w > 0 && h > 0 && ux > 0 && uy > 0) {
								isCorrectInput = true;
							}
						}catch(Exception e1) {
							isCorrectInput = false;
						}
						if(isCorrectInput) {
							setButtonClicked(true);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "Please enter correct numbers!");
						}
						
					}
				});
				okButton.setActionCommand("Draw");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
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

	public JTextField getTextFieldWidth() {
		return textFieldWidth;
	}

	public void setTextWidth(String  textFieldWidth) {
		this.textFieldWidth.setText(textFieldWidth);
	}

	public JTextField getTextUpperLeftPointX() {
		return textFieldUpperLeftPointX;
	}

	public void setTextFieldUpperLeftPointX(String textFieldUpperLeftPointX) {
		this.textFieldUpperLeftPointX.setText(textFieldUpperLeftPointX);
	}

	public JTextField getTextFieldUpperLeftPointY() {
		return textFieldUpperLeftPointY;
	}

	public void setTextFieldUpperLeftPointY(String textFieldFieldUpperLeftPointY) {
		this.textFieldUpperLeftPointY.setText(textFieldFieldUpperLeftPointY);
	}

	public JTextField getTextFieldHeight() {
		return textFieldHeight;
	}

	public void setTextFieldHeight(String textFieldHeight) {
		this.textFieldHeight.setText(textFieldHeight);
	}

	public Color getColorRectangleFill() {
		return colorRectangleFill;
	}

	public void setColorRectangleFill(Color colorRectangleFill) {
		this.colorRectangleFill = colorRectangleFill;
	}

	public Color getColorRectangleBorder() {
		return colorRectangleBorder;
	}

	public void setColorRectangleBorder(Color colorRectangleBorder) {
		this.colorRectangleBorder = colorRectangleBorder;
	}

	public boolean isButtonClicked() {
		return buttonDrawClicked;
	}

	public void setButtonClicked(boolean buttonDrawClicked) {
		this.buttonDrawClicked = buttonDrawClicked;
	}

	public JTextField getTextFillColorRectangle() {
		return textFillColorRectangle;
	}

	public void setTextFillColorRectangle(JTextField textFillColorRectangle) {
		this.textFillColorRectangle = textFillColorRectangle;
	}

	public JTextField getTextBorderColorRectangle() {
		return textBorderColorRectangle;
	}

	public void setTextBorderColorRectangle(JTextField textBorderColorRectangle) {
		this.textBorderColorRectangle = textBorderColorRectangle;
	}

}