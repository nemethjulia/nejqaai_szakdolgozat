package gui;

import gui.fileComponents.ExportToFile;
import gui.fileComponents.ImportEnteringValues;
import gui.fileComponents.ImportFromFilePanel;
import gui.fileComponents.ShowValues;
import gui.fileComponents.WelcomePanel;
import gui.methodComponents.MethodComponent;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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
		setMinimumSize(new Dimension(1200, 700));

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("F\u00E1jl");
		menuBar.add(mnFile);

		JMenuItem mntmNewProcess = new JMenuItem("\u00DAj folyamat");
		mntmNewProcess.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Manager.getInstance().restartProcess();
				loadPanel(new WelcomePanel());
			}
		});
		mnFile.add(mntmNewProcess);

		JMenu mnImport = new JMenu("Bet\u00F6lt\u00E9s");
		mnFile.add(mnImport);

		JMenuItem mnEnteringValues = new JMenuItem("\u00C9rt\u00E9kek megad\u00E1s\u00E1val");
		mnEnteringValues.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				loadPanel(new ImportEnteringValues());

			}
		});
		mnImport.add(mnEnteringValues);

		JMenuItem mnFromFile = new JMenuItem("F\u00E1jlb\u00F3l");
		mnFromFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				loadPanel(new ImportFromFilePanel());
			}
		});
		mnImport.add(mnFromFile);

		JMenuItem mntmImportTestData = new JMenuItem("Tesztadat bet\u00F6lt\u00E9se");
		mntmImportTestData.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Manager.getInstance().generateTestData();

				Manager.getInstance().showMessage("Tesztadatok betöltve!");
			}
		});
		mnImport.add(mntmImportTestData);

		JMenuItem mntmrtkekMegjelentse = new JMenuItem("Aktu\u00E1lis adatok megjelen\u00EDt\u00E9se");
		mntmrtkekMegjelentse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				loadPanel(new ShowValues());
			}
		});
		mnFile.add(mntmrtkekMegjelentse);

		JMenuItem mntmSaveToFile = new JMenuItem("Ment\u00E9s f\u00E1jlba");
		mntmSaveToFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadPanel(new ExportToFile());
			}
		});
		mnFile.add(mntmSaveToFile);

		JMenuItem mntmExit = new JMenuItem("Kil\u00E9p\u00E9s");
		mntmExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(NORMAL);
			}
		});
		mnFile.add(mntmExit);

		JMenu mnMethods = new JMenu("M\u00F3dszerek");
		menuBar.add(mnMethods);

		JMenuItem mnTryMethods = new JMenuItem("M\u00F3dszerek kipr\u00F3b\u00E1l\u00E1sa");
		mnTryMethods.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadPanel(new MethodComponent());
			}
		});
		mnMethods.add(mnTryMethods);

		JMenu mnHelp = new JMenu("S\u00FAg\u00F3");
		menuBar.add(mnHelp);

		JMenuItem mntmOverview = new JMenuItem("\u00C1ttekint\u00E9s");
		mnHelp.add(mntmOverview);

		getContentPane().add(new WelcomePanel());

	}

	private void loadPanel(JPanel panel) {
		getContentPane().removeAll();
		getContentPane().add(panel);
		pack();
	}
}
