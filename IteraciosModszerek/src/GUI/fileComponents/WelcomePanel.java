package gui.fileComponents;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class WelcomePanel extends JPanel {

	/**
	 * Auto generated serialVersion UID
	 */
	private static final long serialVersionUID = -7565759906998830602L;

	public WelcomePanel() {
		initComponents();
	}

	private void initComponents() {
		JTextField txtWelcomeText;

		txtWelcomeText = new JTextField();
		txtWelcomeText.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtWelcomeText.setEditable(false);
		txtWelcomeText.setHorizontalAlignment(SwingConstants.CENTER);
		txtWelcomeText.setText("Iter\u00E1ci\u00F3s m\u00F3dszerek implement\u00E1l\u00E1sa nagym\u00E9ret\u0171 ritka m\u00E1trixokra");
		txtWelcomeText.setColumns(10);

		BufferedImage myPicture = null;
		JLabel picLabel = null;
		try {
			myPicture = ImageIO.read(new File("welcome.png"));
			picLabel = new JLabel(new ImageIcon(myPicture));
		} catch (IOException e) {
			picLabel = new JLabel("Nem el�rhet� a panelhez rendelt k�p!");
		}
		picLabel.setHorizontalAlignment(0);

		GroupLayout layout = new GroupLayout(this);
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(txtWelcomeText, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE).addComponent(picLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(txtWelcomeText, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE).addGap(10).addComponent(picLabel, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE).addContainerGap()));

		setLayout(layout);

	}
}
