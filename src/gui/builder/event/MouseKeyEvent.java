package gui.builder.event;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionAdapter;

public class MouseKeyEvent {

	private JFrame frame;
	private JLabel lblName;
	public final int STEP = 30;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MouseKeyEvent window = new MouseKeyEvent();
					window.frame.setLocation(2300, 280);
					window.frame.setVisible(true);
					window.frame.getContentPane().requestFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MouseKeyEvent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				//lblName.setLocation(e.getPoint());
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				lblName.setLocation(e.getPoint());
			}
		});
		frame.getContentPane().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				int code = e.getKeyCode();
				if(code == KeyEvent.VK_RIGHT) {
					lblName.setLocation(lblName.getX() + STEP, lblName.getY());
				} else if(code == KeyEvent.VK_LEFT) {
					lblName.setLocation(lblName.getX() - STEP, lblName.getY());
				} else if(code == KeyEvent.VK_UP) {
					lblName.setLocation(lblName.getX(), lblName.getY() - STEP);
				} else if(code == KeyEvent.VK_DOWN) {
					lblName.setLocation(lblName.getX(), lblName.getY() + STEP);
				}
				
			}
		});
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				System.out.println(x + ", " + y);
				lblName.setLocation(x, y);
			}
		});
		frame.setTitle("마우스와 키보드 이벤트");
		frame.setBounds(100, 100, 585, 378);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblName = new JLabel("홍길동");
		lblName.setFont(new Font("굴림", Font.PLAIN, 20));
		lblName.setBounds(72, 66, 72, 24);		
		frame.getContentPane().add(lblName);
		
	}
}
