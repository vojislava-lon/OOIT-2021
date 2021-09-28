package stack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class StackFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JList<Rectangle> rectangleJList = new JList<Rectangle>();
	private DefaultListModel<Rectangle> rectangleStack = new DefaultListModel<Rectangle>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackFrame frame = new StackFrame();
					frame.setTitle("Vojislava Loncar II 53-2016");
					frame.setSize(620, 420);
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StackFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		rectangleJList.setFont(new Font("Arial", Font.PLAIN, 12));

		contentPane.add(rectangleJList, BorderLayout.CENTER);
		rectangleJList.setModel(rectangleStack);

		JPanel northPanel = new JPanel();
		northPanel.setBackground(new Color(95, 158, 160));
		contentPane.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnAdd = new JButton("Add Rectangle");
		btnAdd.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnAdd.setBackground(new Color(211, 211, 211));
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					StackDialog dialog = new StackDialog(true);
					dialog.setSize(550,280);
					
					dialog.setResizable(false);
					dialog.setVisible(true);
					
					
					if(dialog.isButtonAddClicked()) {
						Point point = new Point(dialog.getxCord(), dialog.getyCord());
						Rectangle rectangle = new Rectangle (point, dialog.getRectangleWidth(), dialog.getRectangleHeight());
				
						rectangleStack.add(0, rectangle);
					}
			}
		});
		northPanel.add(btnAdd);

		JButton btnRemove = new JButton("Remove Rectangle");
		btnRemove.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnRemove.setBackground(new Color(211, 211, 211));
		btnRemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					if(rectangleStack.size() != 0) {
						rectangleJList.setSelectedIndex(0);
						Rectangle rectangle = (Rectangle) rectangleJList.getSelectedValue();
						
						StackDialog dialog = new StackDialog(false);
						dialog.setSize(550,280);
						dialog.getTextFieldX().setText(String.valueOf(rectangle.getUpperLeft().getX()));
						dialog.getTextFieldY().setText(String.valueOf(rectangle.getUpperLeft().getY()));
						dialog.getTextFieldHeight().setText(String.valueOf(rectangle.getHeight()));
						dialog.getTextFieldWidth().setText(String.valueOf(rectangle.getWidth()));					
						
						
						dialog.setResizable(false);
						dialog.setVisible(true);
						
						if(dialog.isButtonRemoveClicked()) {
							rectangleStack.remove(0);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Stack is empty!");
					}
			}
		});
		northPanel.add(btnRemove);
	}

}
