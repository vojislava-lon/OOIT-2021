package stack;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;

public class StackDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldHeight;
	private JTextField textFieldX;
	private JTextField textFieldWidth;
	private JTextField textFieldY;
	private int xCord;
	private int yCord;
	private int rectangleHeight;
	private int rectangleWidth;
	private boolean isButtonAddClicked;
	private boolean isButtonRemoveClicked;

	public StackDialog(boolean isAdd) {
		setBackground(new Color(95, 158, 160));
		getContentPane().setBackground(new Color(95, 158, 160));
		setModal(true);
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("UpperLeft point:");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(5, 5, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("X coordinate:");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textFieldX = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		getContentPane().add(textFieldX, gbc_textField);
		textFieldX.setColumns(10);
		
		JLabel lblY = new JLabel("Y coordinate:");
		lblY.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		GridBagConstraints gbc_lblY = new GridBagConstraints();
		gbc_lblY.anchor = GridBagConstraints.EAST;
		gbc_lblY.insets = new Insets(0, 0, 5, 5);
		gbc_lblY.gridx = 1;
		gbc_lblY.gridy = 2;
		getContentPane().add(lblY, gbc_lblY);
		
		textFieldY = new JTextField();
		textFieldY.setSize(20,150);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 2;
		getContentPane().add(textFieldY, gbc_textField_1);
		textFieldY.setColumns(10);
		
		JLabel lblDimension = new JLabel("Dimensions:");
		lblDimension.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		GridBagConstraints gbc_lblDimension = new GridBagConstraints();
		gbc_lblDimension.anchor = GridBagConstraints.WEST;
		gbc_lblDimension.insets = new Insets(0, 5, 5, 5);
		gbc_lblDimension.gridx = 0;
		gbc_lblDimension.gridy = 4;
		getContentPane().add(lblDimension, gbc_lblDimension);
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		GridBagConstraints gbc_lblHeight = new GridBagConstraints();
		gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeight.gridx = 1;
		gbc_lblHeight.gridy = 5;
		getContentPane().add(lblHeight, gbc_lblHeight);
		
		textFieldHeight = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.WEST;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 5;
		getContentPane().add(textFieldHeight, gbc_textField_2);
		textFieldHeight.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Width:");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 6;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textFieldWidth = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.anchor = GridBagConstraints.WEST;
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 6;
		getContentPane().add(textFieldWidth, gbc_textField_3);
		textFieldWidth.setColumns(10);
		
		JButton addButton = new JButton("Add");
		addButton.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		
		if(isAdd == true) {
			addButton.setVisible(true);
		}else {
			addButton.setVisible(false);
		}
		
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean isCorrectInput = false;
				try {
					xCord = Integer.parseInt(textFieldX.getText());
					yCord = Integer.parseInt(textFieldY.getText());
					rectangleHeight = Integer.parseInt(textFieldHeight.getText());
					rectangleWidth = Integer.parseInt(textFieldWidth.getText());
					if(xCord > 0 && yCord > 0 && rectangleWidth > 0 && rectangleHeight > 0) {
						isCorrectInput = true;
					}
				}catch(Exception e1){
					isCorrectInput = false;
				}
				
				if(isCorrectInput == true) {
					setButtonAddClicked(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Please enter correct numbers!");
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 9;
		getContentPane().add(addButton, gbc_btnNewButton_2);
		
		JButton removeButton = new JButton("Remove");
		removeButton.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		if(isAdd == true) {
			removeButton.setVisible(false);
		}else {
			removeButton.setVisible(true);
		}
		
		removeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setButtonRemoveClicked(true);
				dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 9;
		getContentPane().add(removeButton, gbc_btnNewButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 9;
		getContentPane().add(cancelButton, gbc_btnNewButton_1);
	}

	public JTextField getTextFieldHeight() {
		return textFieldHeight;
	}

	public void setTextFieldHeight(JTextField textFieldHeight) {
		this.textFieldHeight = textFieldHeight;
	}

	public JTextField getTextFieldX() {
		return textFieldX;
	}

	public void setTextFieldX(JTextField textFieldX) {
		this.textFieldX = textFieldX;
	}

	public JTextField getTextFieldWidth() {
		return textFieldWidth;
	}

	public void setTextFieldWidth(JTextField textFieldWidth) {
		this.textFieldWidth = textFieldWidth;
	}

	public JTextField getTextFieldY() {
		return textFieldY;
	}

	public void setTextFieldY(JTextField textFieldY) {
		this.textFieldY = textFieldY;
	}

	public int getxCord() {
		return xCord;
	}

	public void setxCord(int xCord) {
		this.xCord = xCord;
	}

	public int getyCord() {
		return yCord;
	}

	public void setyCord(int yCord) {
		this.yCord = yCord;
	}

	public int getRectangleHeight() {
		return rectangleHeight;
	}

	public void setRectangleHeight(int rectangleHeight) {
		this.rectangleHeight = rectangleHeight;
	}

	public int getRectangleWidth() {
		return rectangleWidth;
	}

	public void setRectangleWidth(int rectangleWidth) {
		this.rectangleWidth = rectangleWidth;
	}

	public boolean isButtonAddClicked() {
		return isButtonAddClicked;
	}

	public void setButtonAddClicked(boolean isButtonAddClicked) {
		this.isButtonAddClicked = isButtonAddClicked;
	}

	public boolean isButtonRemoveClicked() {
		return isButtonRemoveClicked;
	}

	public void setButtonRemoveClicked(boolean isButtonRemoveClicked) {
		this.isButtonRemoveClicked = isButtonRemoveClicked;
	}

}