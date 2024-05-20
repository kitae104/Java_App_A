package gui.builder.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MyEditor {

	private JFrame frmMyeditorVer;
	private JTextArea ta;
	
	private final int EXIT_SUCCESS = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyEditor window = new MyEditor();
					window.frmMyeditorVer.setLocation(2800, 200);
					window.frmMyeditorVer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyEditor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMyeditorVer = new JFrame();
		frmMyeditorVer.setTitle("MyEditor ver0.1");
		frmMyeditorVer.setBounds(100, 100, 665, 447);
		frmMyeditorVer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMyeditorVer.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frmMyeditorVer.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		ta = new JTextArea();
		ta.setFont(new Font("Monospaced", Font.PLAIN, 16));
		ta.setLineWrap(true);
		scrollPane.setViewportView(ta);
		
		JToolBar toolBar = new JToolBar();
		scrollPane.setColumnHeaderView(toolBar);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
			}
		});
		btnNewButton.setIcon(new ImageIcon(MyEditor.class.getResource("/gui/builder/images/new.png")));
		toolBar.add(btnNewButton);
		
		toolBar.addSeparator();
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openAction();
			}			
		});
		btnNewButton_1.setIcon(new ImageIcon(MyEditor.class.getResource("/gui/builder/images/open.png")));
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(MyEditor.class.getResource("/gui/builder/images/save.png")));
		toolBar.add(btnNewButton_2);
		
		toolBar.addSeparator();
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				exitAction();
			}

			
		});
		btnNewButton_3.setIcon(new ImageIcon(MyEditor.class.getResource("/gui/builder/images/exit.png")));
		toolBar.add(btnNewButton_3);
		
		JMenuBar menuBar = new JMenuBar();
		frmMyeditorVer.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Open");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Save");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Exit");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitAction();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("계산기");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calc calc = new Calc();
				calc.getFrame().setLocation(2800, 200);
				calc.getFrame().setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_2 = new JMenu("info");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Program Info");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frmMyeditorVer, "내가 만든 텍스트 에디터 ver 0.1",
						"프로그램 정보", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
	}
	
	private void exitAction() {
		if(JOptionPane.showConfirmDialog(frmMyeditorVer, 
				"정말 끝낼까요?", "종료 확인", 
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			System.exit(EXIT_SUCCESS);
		}
	}
	
	private void openAction() {		
		JFileChooser fc = new JFileChooser();
		
		File currentDirectory = new File("./src/basic/classes");
		fc.setCurrentDirectory(currentDirectory);
		
		fc.addChoosableFileFilter(new FileNameExtensionFilter("Java", "java"));
		fc.addChoosableFileFilter(new FileNameExtensionFilter("Text", "txt"));
		fc.setAcceptAllFileFilterUsed(true);
		
		fc.showOpenDialog(frmMyeditorVer);
		
		File in = fc.getSelectedFile();
		BufferedReader br = null;
		try {
			 br = new BufferedReader(new FileReader(in));
			 String line = null;
			 while((line = br.readLine()) != null) {
				 ta.append(line + "\n");
			 }	 
			 
		} catch (FileNotFoundException e) {
			System.out.println("파일 접근시 오류 발생");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("입출력시 오류 발생");
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {					
					e.printStackTrace();
				}
			}
		}
	}
}
