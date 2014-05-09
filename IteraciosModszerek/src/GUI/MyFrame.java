package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyFrame extends JFrame {

	/**
	 * Auto generated serialVersion UID
	 */
	private static final long serialVersionUID = -2122161377842820073L;

	public MyFrame() {
		initComponents();
	}

	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Iter\u00E1ci\u00F3s M\u00F3dszerek");

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("F\u00E1jl");
		menuBar.add(mnFile);

		JMenuItem mntmNewProcess = new JMenuItem("\u00DAj folyamat");
		mnFile.add(mntmNewProcess);

		JMenuItem mntmExit = new JMenuItem("Kil\u00E9p\u00E9s");
		mntmExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(NORMAL);
			}
		});
		mnFile.add(mntmExit);

		JMenu mnImport = new JMenu("Bet\u00F6lt\u00E9s");
		menuBar.add(mnImport);

		JMenu mnEnteringValues = new JMenu("\u00C9rt\u00E9kek megad\u00E1s\u00E1val");
		mnImport.add(mnEnteringValues);

		JMenuItem mntmImportVectorByEnteringValues = new JMenuItem("Vektor bet\u00F6lt\u00E9se");
		mnEnteringValues.add(mntmImportVectorByEnteringValues);

		JMenuItem mntmImportMatrixByEnteringValues = new JMenuItem("M\u00E1trix bet\u00F6lt\u00E9se");
		mnEnteringValues.add(mntmImportMatrixByEnteringValues);

		JMenu mnFromFile = new JMenu("F\u00E1jlb\u00F3l");
		mnImport.add(mnFromFile);

		JMenuItem mntmImportVectorFromFile = new JMenuItem("Vektor bet\u00F6lt\u00E9se");
		mnFromFile.add(mntmImportVectorFromFile);

		JMenuItem mntmImportMatrixFromFile = new JMenuItem("M\u00E1trix bet\u00F6lt\u00E9se");
		mnFromFile.add(mntmImportMatrixFromFile);

		getContentPane().add(new WelcomePanel());

	}
}
