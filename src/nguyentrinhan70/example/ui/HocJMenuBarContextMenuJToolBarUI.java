package nguyentrinhan70.example.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class HocJMenuBarContextMenuJToolBarUI extends JFrame {
	JMenuBar mnuBar; //Nơi chứa các JMenu
	JMenu mnuFile;
	JMenu mnuEdit;
	JMenu mnuHelp;
	
	JMenuItem mnuFileNew;
	JMenuItem mnuFileOpen;
	JMenuItem mnuFileExit;
	
	JMenuItem mnuEditCopy;
	JMenuItem mnuEditCut;
	JMenuItem mnuEditDelete;
	
	JMenuItem mnuHelpGui;
	JMenuItem mnuHelpAbout;
	
	JButton btn1, btn2;
	
	JMenuItem mnuPopUpMauXanh, mnuPopUpMauDo;
	
	JButton btnLastedChoose=null;
	
	JToolBar toolBar;
	JButton btnLenh1, btnLenh2, btnLenh3;
	JCheckBox chk1, chk2;
	
	
	public HocJMenuBarContextMenuJToolBarUI(String title){
		super(title);
		addControls();
		addEvents();
	}
	public void addControls(){
		mnuBar = new JMenuBar();
		setJMenuBar(mnuBar);
		
		mnuFile = new JMenu("File");
		mnuBar.add(mnuFile);
		mnuEdit = new JMenu("Edit");
		mnuBar.add(mnuEdit);
		mnuHelp = new JMenu("Help");
		mnuBar.add(mnuHelp);
		
		mnuFileNew = new JMenuItem("New");
		mnuFileNew.setAccelerator(KeyStroke.getKeyStroke('N', 
				Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		mnuFile.add(mnuFileNew);
		
		mnuFileOpen = new JMenuItem("Open");
		
		mnuFile.addSeparator();
		mnuFile.add(mnuFileOpen);
		
		mnuFileExit = new JMenuItem("Exit");
		mnuFileExit.setIcon(new ImageIcon("images/exit.png" ));
		mnuFile.add(mnuFileExit);
		
		mnuEditCopy = new JMenuItem("Copy");
		mnuEdit.addSeparator();
		mnuEdit.add(mnuEdit);
		
		mnuEditCut = new JMenuItem("Cut");
		mnuEdit.add(mnuEditCut);
		
		mnuEditDelete = new JMenuItem("Delete");
		mnuEdit.add(mnuEditDelete);
		
		mnuHelpGui = new JMenuItem("Guide");
		mnuHelp.addSeparator();
		mnuHelp.add(mnuHelpGui);
		
		mnuHelpAbout = new JMenuItem("About");
		mnuHelp.add(mnuHelpAbout);
		
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		
		toolBar = new JToolBar();
		btnLenh1 = new JButton("Lệnh 1");
		btnLenh2 = new JButton("Lệnh 2");
		btnLenh3 = new JButton("Lệnh 3");
		toolBar.add(btnLenh1);
		toolBar.add(btnLenh2);
		toolBar.add(btnLenh3);
		chk1 = new JCheckBox("Tự động lưu dữ liệu");
		toolBar.add(chk1);
		
		chk2 = new JCheckBox("Lưu dữ liệu bằng tay");
		toolBar.add(chk2);
		con.add(toolBar, BorderLayout.NORTH);
		
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new FlowLayout());
		btn1 = new JButton("Bấm chuột phải vào tôi đi");
		pnMain.add(btn1);
		con.add(pnMain);
		btn1.addMouseListener(new PopClickListener());
		
		btn2 = new JButton("Bấm chuột phải vào tôi đi");
		pnMain.add(btn2);
		con.add(pnMain,BorderLayout.CENTER);
		btn2.addMouseListener(new PopClickListener());
	}
	
	class PopUpDemo extends JPopupMenu{
		JMenuItem anItem;
		public PopUpDemo(){
			mnuPopUpMauDo = new JMenuItem("Tô màu đỏ");
			add(mnuPopUpMauDo);
			
			mnuPopUpMauXanh = new JMenuItem("Tô màu xanh");
			add(mnuPopUpMauXanh);
			
			mnuPopUpMauDo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(btnLastedChoose!=null)
					{
						btnLastedChoose.setBackground(Color.red);
					}
					
				}
			});
			mnuPopUpMauXanh.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(btnLastedChoose!=null){
						btnLastedChoose.setBackground(Color.green);
					}
				}
			});
		}
	}
	class PopClickListener extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			if(e.isPopupTrigger()){
				doPop(e);
			}
		}
		public void mouseReleased(MouseEvent e){
			if(e.isPopupTrigger()){
				doPop(e);
			}
		}
		private void doPop(MouseEvent e	) {
			PopUpDemo menu = new PopUpDemo();
			btnLastedChoose = (JButton) e.getComponent();
			menu.show(e.getComponent(), e.getX(),e.getY() );
		}
	}
	
	public void addEvents(){
		mnuFileExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				
			}
		});
		mnuFileNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Bạn vừa chọn Ctrl + N");
			}
		});
		btnLenh1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Bạn vừa chọn lệnh 1");
			}
		});
	}
	public void showWindow(){
		this.setSize(800,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
