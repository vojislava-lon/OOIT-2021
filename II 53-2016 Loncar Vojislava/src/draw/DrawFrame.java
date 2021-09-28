package draw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;

public class DrawFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private DrawPanel drawPanel = new DrawPanel();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawFrame frame = new DrawFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DrawFrame() {
		setTitle("Vojislava Loncar II 53-2016");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(drawPanel, BorderLayout.CENTER);
		drawPanel.setBackground(Color.WHITE);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(new Color(95, 158, 160));
		contentPane.add(panelNorth, BorderLayout.WEST);
		
		JToggleButton tglbtnPoint = new JToggleButton("Point");
		tglbtnPoint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DrawPanel.operationType = OperationType.DRAW_POINT;
			}
		});
		panelNorth.setLayout(new GridLayout(0, 1, 0, 20));
		tglbtnPoint.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelNorth.add(tglbtnPoint);
		
		JToggleButton tglbtnLine = new JToggleButton("Line");
		tglbtnLine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DrawPanel.operationType = OperationType.DRAW_LINE;
			}
		});
		tglbtnLine.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelNorth.add(tglbtnLine);	
		
		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		tglbtnCircle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DrawPanel.operationType = OperationType.DRAW_CIRCLE;
			}
		});
		tglbtnCircle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelNorth.add(tglbtnCircle);
		
		JToggleButton tglbtnDonut = new JToggleButton("Donut");
		tglbtnDonut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DrawPanel.operationType = OperationType.DRAW_DONUT;
			}
		});
		tglbtnDonut.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelNorth.add(tglbtnDonut);
		
		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				DrawPanel.operationType = OperationType.DRAW_RECTANGLE;
			}
		});
		tglbtnRectangle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelNorth.add(tglbtnRectangle);
		
		JPanel panelSouth = new JPanel();
		panelSouth.setBackground(new Color(95, 158, 160));
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		JToggleButton tglbtnSelect = new JToggleButton("Select");
		tglbtnSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DrawPanel.operationType = OperationType.SELECT;
			}
		});
		tglbtnSelect.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelSouth.add(tglbtnSelect);
		
		JToggleButton tglbtnModify = new JToggleButton("Modify");
		tglbtnModify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DrawPanel.operationType = OperationType.MODIFY;
			}
		});
		tglbtnModify.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelSouth.add(tglbtnModify);
		
		JToggleButton tglbtnDelete = new JToggleButton("Delete");
		tglbtnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DrawPanel.operationType = OperationType.DELETE;
			}
		});
		tglbtnDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelSouth.add(tglbtnDelete);
		ButtonGroup group = new ButtonGroup();
		group.add(tglbtnPoint);
		group.add(tglbtnLine);
		group.add(tglbtnCircle);
		group.add(tglbtnDonut);
		group.add(tglbtnRectangle);
		group.add(tglbtnSelect);
		group.add(tglbtnModify);
		group.add(tglbtnDelete);		
	}

}
