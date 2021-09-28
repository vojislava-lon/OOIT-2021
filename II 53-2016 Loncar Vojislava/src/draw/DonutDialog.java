package draw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DonutDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCenterX;
	private JTextField textFieldCenterY;
	private JTextField textFieldRadius;
	private JTextField textBorderColorCircle;
	private JTextField textFillColorCircle;
	private Color colorCircleFill;
	private Color colorCircleBorder;
	private JTextField textFieldInnerRadius;
	private boolean buttonDrawClicked;
	
	public DonutDialog() {
		getContentPane().setBackground(new Color(95, 158, 160));
		setTitle("Donut draw dialog");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(95, 158, 160));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.WEST);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {34, 120, 30, 70};
		gbl_contentPanel.rowHeights = new int[] {10, 10, 10, 30, 10, 10, 10, 10};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCenter = new JLabel("Center");
			lblCenter.setFont(new Font("Tahoma", Font.BOLD, 15));
			GridBagConstraints gbc_lblCenter = new GridBagConstraints();
			gbc_lblCenter.gridx = 0;
			gbc_lblCenter.gridy = 0;
			contentPanel.add(lblCenter, gbc_lblCenter);
		}
		{
			JLabel lblCenterX = new JLabel("Coordinate X:");
			lblCenterX.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
			GridBagConstraints gbc_lblCenterX = new GridBagConstraints();
			gbc_lblCenterX.anchor = GridBagConstraints.EAST;
			gbc_lblCenterX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterX.gridx = 0;
			gbc_lblCenterX.gridy = 1;
			contentPanel.add(lblCenterX, gbc_lblCenterX);
		}
		{
			textFieldCenterX = new JTextField();
			textFieldCenterX.setColumns(10);
			GridBagConstraints gbc_textCenterX = new GridBagConstraints();
			gbc_textCenterX.insets = new Insets(0, 0, 5, 5);
			gbc_textCenterX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textCenterX.gridx = 1;
			gbc_textCenterX.gridy = 1;
			contentPanel.add(textFieldCenterX, gbc_textCenterX);
		}
		{
			JButton btnFillColorCircle = new JButton("Fill Color");
			btnFillColorCircle.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
			btnFillColorCircle.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					colorCircleFill = JColorChooser.showDialog(null, "Choose color", null);
					textFillColorCircle.setBackground(colorCircleFill);
				}
			});
			btnFillColorCircle.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
			GridBagConstraints gbc_btnFillColorCircle = new GridBagConstraints();
			gbc_btnFillColorCircle.insets = new Insets(0, 0, 5, 0);
			gbc_btnFillColorCircle.gridx = 3;
			gbc_btnFillColorCircle.gridy = 1;
			contentPanel.add(btnFillColorCircle, gbc_btnFillColorCircle);
		}
		{
			JLabel lblCenterY = new JLabel("Cordinate Y:");
			lblCenterY.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
			GridBagConstraints gbc_lblCenterY = new GridBagConstraints();
			gbc_lblCenterY.anchor = GridBagConstraints.EAST;
			gbc_lblCenterY.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterY.gridx = 0;
			gbc_lblCenterY.gridy = 2;
			contentPanel.add(lblCenterY, gbc_lblCenterY);
		}
		{
			textFieldCenterY = new JTextField();
			textFieldCenterY.setColumns(10);
			GridBagConstraints gbc_textCenterY = new GridBagConstraints();
			gbc_textCenterY.insets = new Insets(0, 0, 5, 5);
			gbc_textCenterY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textCenterY.gridx = 1;
			gbc_textCenterY.gridy = 2;
			contentPanel.add(textFieldCenterY, gbc_textCenterY);
		}
		{
			textFillColorCircle = new JTextField();
			textFillColorCircle.setColumns(10);
			GridBagConstraints gbc_textFillColorCircle = new GridBagConstraints();
			gbc_textFillColorCircle.insets = new Insets(0, 0, 5, 0);
			gbc_textFillColorCircle.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFillColorCircle.gridx = 3;
			gbc_textFillColorCircle.gridy = 2;
			contentPanel.add(textFillColorCircle, gbc_textFillColorCircle);
		}
		{
			{
				JLabel lblRadiusDonut = new JLabel("Radius:");
				lblRadiusDonut.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
				GridBagConstraints gbc_lblRadiusDonut = new GridBagConstraints();
				gbc_lblRadiusDonut.anchor = GridBagConstraints.EAST;
				gbc_lblRadiusDonut.insets = new Insets(0, 0, 0, 5);
				gbc_lblRadiusDonut.gridx = 0;
				gbc_lblRadiusDonut.gridy = 4;
				contentPanel.add(lblRadiusDonut, gbc_lblRadiusDonut);
			}
			{
				textFieldRadius = new JTextField();
				textFieldRadius.setColumns(10);
				GridBagConstraints gbc_textRadius = new GridBagConstraints();
				gbc_textRadius.insets = new Insets(0, 0, 5, 5);
				gbc_textRadius.fill = GridBagConstraints.HORIZONTAL;
				gbc_textRadius.gridx = 1;
				gbc_textRadius.gridy = 4;
				contentPanel.add(textFieldRadius, gbc_textRadius);
			}
		}
		{
			JButton btnBorderColorCircle = new JButton("Border Color");
			btnBorderColorCircle.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					colorCircleBorder = JColorChooser.showDialog(null, "Choose color", null);
					textBorderColorCircle.setBackground(colorCircleBorder);
				}
			});
			btnBorderColorCircle.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
			GridBagConstraints gbc_btnBorderColorCircle = new GridBagConstraints();
			gbc_btnBorderColorCircle.insets = new Insets(0, 0, 5, 0);
			gbc_btnBorderColorCircle.gridx = 3;
			gbc_btnBorderColorCircle.gridy = 4;
			contentPanel.add(btnBorderColorCircle, gbc_btnBorderColorCircle);
		}
		{
			JLabel lblInnerRadius = new JLabel("Inner radius:");
			lblInnerRadius.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
			GridBagConstraints gbc_lblInnerRadius = new GridBagConstraints();
			gbc_lblInnerRadius.anchor = GridBagConstraints.EAST;
			gbc_lblInnerRadius.insets = new Insets(0, 0, 0, 5);
			gbc_lblInnerRadius.gridx = 0;
			gbc_lblInnerRadius.gridy = 5;
			contentPanel.add(lblInnerRadius, gbc_lblInnerRadius);
		}
		{
			textFieldInnerRadius = new JTextField();
			GridBagConstraints gbc_textInnerRadius = new GridBagConstraints();
			gbc_textInnerRadius.insets = new Insets(0, 0, 5, 5);
			gbc_textInnerRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_textInnerRadius.gridx = 1;
			gbc_textInnerRadius.gridy = 5;
			contentPanel.add(textFieldInnerRadius, gbc_textInnerRadius);
			textFieldInnerRadius.setColumns(10);
		}
		{
			textBorderColorCircle = new JTextField();
			textBorderColorCircle.setColumns(10);
			GridBagConstraints gbc_textBorderColorCircle = new GridBagConstraints();
			gbc_textBorderColorCircle.insets = new Insets(0, 0, 5, 0);
			gbc_textBorderColorCircle.fill = GridBagConstraints.HORIZONTAL;
			gbc_textBorderColorCircle.gridx = 3;
			gbc_textBorderColorCircle.gridy = 5;
			contentPanel.add(textBorderColorCircle, gbc_textBorderColorCircle);
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
							int x = Integer.parseInt(textFieldCenterX.getText());
							int y = Integer.parseInt(textFieldCenterY.getText());
							int r = Integer.parseInt(textFieldRadius.getText());
							int innerR = Integer.parseInt(textFieldInnerRadius.getText());
							if(x > 0 && y > 0 && r > 0 && innerR > 0 && innerR < r) {
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
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getTextFieldCenterX() {
		return textFieldCenterX;
	}

	public void setTextFieldCenterX(String textFieldCenterX) {
		this.textFieldCenterX.setText(textFieldCenterX);
	}

	public JTextField getTextCenterY() {
		return textFieldCenterY;
	}

	public void setTextFieldCenterY(String textFieldCenterY) {
		this.textFieldCenterY.setText(textFieldCenterY);
	}

	public JTextField getTextFieldRadius() {
		return textFieldRadius;
	}

	public void setTextFieldRadius(String textFieldRadius) {
		this.textFieldRadius.setText(textFieldRadius);
	}

	public Color getColorCircleFill() {
		return colorCircleFill;
	}

	public void setColorCircleFill(Color colorCircleFill) {
		this.colorCircleFill = colorCircleFill;
	}

	public Color getColorCircleBorder() {
		return colorCircleBorder;
	}

	public void setColorCircleBorder(Color colorCircleBorder) {
		this.colorCircleBorder = colorCircleBorder;
	}

	public JTextField getTextFieldInnerRadius() {
		return textFieldInnerRadius;
	}

	public void setTextInnerRadius(String textFieldInnerRadius) {
		this.textFieldInnerRadius.setText(textFieldInnerRadius);
	}

	public boolean isButtonDrawClicked() {
		return buttonDrawClicked;
	}

	public void setButtonDrawClicked(boolean buttonDrawClicked) {
		this.buttonDrawClicked = buttonDrawClicked;
	}

	public JTextField getTextFillColorCircle() {
		return textFillColorCircle;
	}

	public void setTextFillColorCircle(JTextField textFillColorCircle) {
		this.textFillColorCircle = textFillColorCircle;
	}

	public JTextField getTextBorderColorCircle() {
		return textBorderColorCircle;
	}

	public void setTextBorderColorCircle(JTextField textBorderColorCircle) {
		this.textBorderColorCircle = textBorderColorCircle;
	}

}