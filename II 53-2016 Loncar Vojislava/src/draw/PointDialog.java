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
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PointDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCordinateX;
	private JTextField textFieldCordinateY;
	private JTextField textFieldColor;
	private Color colorPoint;
	private boolean buttonDrawClicked;

	public PointDialog() {
		setTitle("Point draw dialog");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(95, 158, 160));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {100, 70, 100};
		gbl_contentPanel.rowHeights = new int[] {30, 30, 30, 30, 0, 30};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCoordinateX = new JLabel("X Coordinate:");
			lblCoordinateX.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
			GridBagConstraints gbc_lblCoordinateX = new GridBagConstraints();
			gbc_lblCoordinateX.anchor = GridBagConstraints.EAST;
			gbc_lblCoordinateX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCoordinateX.gridx = 0;
			gbc_lblCoordinateX.gridy = 1;
			contentPanel.add(lblCoordinateX, gbc_lblCoordinateX);
		}
		{
			textFieldCordinateX = new JTextField();
			GridBagConstraints gbc_txtCordinateX = new GridBagConstraints();
			gbc_txtCordinateX.insets = new Insets(0, 0, 5, 0);
			gbc_txtCordinateX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCordinateX.gridx = 1;
			gbc_txtCordinateX.gridy = 1;
			contentPanel.add(textFieldCordinateX, gbc_txtCordinateX);
			textFieldCordinateX.setColumns(10);
		}
		{
			JLabel lblCoordinateY = new JLabel("Y Coordinate:");
			lblCoordinateY.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
			GridBagConstraints gbc_lblCoordinateY = new GridBagConstraints();
			gbc_lblCoordinateY.anchor = GridBagConstraints.EAST;
			gbc_lblCoordinateY.insets = new Insets(0, 0, 5, 5);
			gbc_lblCoordinateY.gridx = 0;
			gbc_lblCoordinateY.gridy = 2;
			contentPanel.add(lblCoordinateY, gbc_lblCoordinateY);
		}
		{
			textFieldCordinateY = new JTextField();
			GridBagConstraints gbc_txtCordinateY = new GridBagConstraints();
			gbc_txtCordinateY.insets = new Insets(0, 0, 5, 0);
			gbc_txtCordinateY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCordinateY.gridx = 1;
			gbc_txtCordinateY.gridy = 2;
			contentPanel.add(textFieldCordinateY, gbc_txtCordinateY);
			textFieldCordinateY.setColumns(10);
		}
		{
			JButton btnColor = new JButton("Color");
			btnColor.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
			btnColor.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					colorPoint = JColorChooser.showDialog(null, "Choose color", null);
					textFieldColor.setBackground(colorPoint);
				}
			});
			GridBagConstraints gbc_btnColor = new GridBagConstraints();
			gbc_btnColor.insets = new Insets(0, 0, 5, 0);
			gbc_btnColor.gridx = 1;
			gbc_btnColor.gridy = 3;
			contentPanel.add(btnColor, gbc_btnColor);
		}
		{
			textFieldColor = new JTextField();
			GridBagConstraints gbc_txtColor = new GridBagConstraints();
			gbc_txtColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtColor.gridx = 1;
			gbc_txtColor.gridy = 4;
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
				btnDraw.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {	
						boolean isCorrectInput = false;
						try {
							int x = Integer.parseInt(textFieldCordinateX.getText());
							int y = Integer.parseInt(textFieldCordinateY.getText());
							if(x > 0 && y > 0) {
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
				btnDraw.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
				btnDraw.setActionCommand("OK");
				buttonPane.add(btnDraw);
				getRootPane().setDefaultButton(btnDraw);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
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

	public JTextField getTextFieldCordinateX() {
		return textFieldCordinateX;
	}

	public void setTextFieldCordinateX(String textFieldCordinateX) {
		this.textFieldCordinateX.setText(textFieldCordinateX);
	}

	public JTextField getTextFieldCordinateY() {
		return textFieldCordinateY;
	}

	public void setTextFieldCordinateY(String textFieldCordinateY) {
		this.textFieldCordinateY.setText(textFieldCordinateY);
	}

	public JTextField getTextFieldColor() {
		return textFieldColor;
	}

	public void setTextFieldColor(JTextField textFieldColor) {
		this.textFieldColor = textFieldColor;
	}

	public Color getColorPoint() {
		return colorPoint;
	}

	public void setColorPoint(Color colorPoint) {
		this.colorPoint = colorPoint;
	}

	public boolean isButtonDrawClicked() {
		return buttonDrawClicked;
	}

	public void setButtonDrawClicked(boolean buttonDrawClicked) {
		this.buttonDrawClicked = buttonDrawClicked;
	}

}