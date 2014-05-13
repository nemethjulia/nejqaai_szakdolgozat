package gui.fileComponents;

import gui.Manager;
import gui.fileComponents.showDataStructures.MatrixComponent;
import gui.fileComponents.showDataStructures.MatrixJustDataComponent;
import gui.fileComponents.showDataStructures.MultipleVectorComponent;
import gui.fileComponents.showDataStructures.MultipleVectorJustDataComponent;
import gui.fileComponents.showDataStructures.VectorComponent;
import gui.fileComponents.showDataStructures.VectorJustDataComponent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class ShowValues extends JPanel {

	/**
	 * Auto generated serialVersion UID
	 */
	private static final long serialVersionUID = 5680723855545340540L;

	private JTabbedPane matrixArea;
	private JTabbedPane xVectorsArea;
	private JTabbedPane bVectorArea;

	public ShowValues() {
		super();

		Manager manager = Manager.getInstance();

		matrixArea = new JTabbedPane();
		MatrixComponent mcomp = new MatrixComponent(manager.getMatrix());
		JScrollPane matrixScroller = new JScrollPane(mcomp);
		MatrixJustDataComponent mjdcomp = new MatrixJustDataComponent(manager.getMatrix());
		JScrollPane matrixJDScroller = new JScrollPane(mjdcomp);
		matrixArea.addTab("Mátrix teljes ábrázolása", matrixScroller);
		matrixArea.addTab("Csak a mátrix nem 0 elemei", matrixJDScroller);

		JLabel lblBetltttMtrix = new JLabel("Bet\u00F6lt\u00F6tt m\u00E1trix:");

		xVectorsArea = new JTabbedPane();
		MultipleVectorComponent xVectorscomp = new MultipleVectorComponent(manager.getxVectors());
		JScrollPane xVectorsScroller = new JScrollPane(xVectorscomp);
		MultipleVectorJustDataComponent xVectorsJDcomp = new MultipleVectorJustDataComponent(manager.getxVectors());
		JScrollPane xVectorsJDScroller = new JScrollPane(xVectorsJDcomp);
		xVectorsArea.addTab("Vektorok teljes ábrázolása", xVectorsScroller);
		xVectorsArea.addTab("Csak a vektorok nem 0 elemei", xVectorsJDScroller);

		JLabel lblXVektorok = new JLabel("X0 vektorok: ");

		bVectorArea = new JTabbedPane();
		VectorComponent bVectorcomp = new VectorComponent(manager.getBVector());
		JScrollPane bVectorScroller = new JScrollPane(bVectorcomp);
		VectorJustDataComponent bVectorJDcomp = new VectorJustDataComponent(manager.getBVector());
		JScrollPane bVectorJDScroller = new JScrollPane(bVectorJDcomp);
		bVectorArea.addTab("Vektorok teljes ábrázolása", bVectorScroller);
		bVectorArea.addTab("Csak a vektorok nem 0 elemei", bVectorJDScroller);

		JLabel lblBVektor = new JLabel("b vektor");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout.createSequentialGroup().addComponent(lblBetltttMtrix, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE).addGap(10).addComponent(matrixArea, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup().addComponent(lblXVektorok, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE).addGap(10).addComponent(xVectorsArea, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE).addGap(0, 0, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup().addComponent(lblBVektor, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE).addGap(10).addComponent(bVectorArea, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE).addGap(0, 0, Short.MAX_VALUE))).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(35).addComponent(lblBetltttMtrix, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)).addGroup(groupLayout.createSequentialGroup().addGap(30).addComponent(matrixArea, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(18).addComponent(xVectorsArea, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)).addGroup(groupLayout.createSequentialGroup().addGap(25).addComponent(lblXVektorok, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))).addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(bVectorArea, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE).addComponent(lblBVektor, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)).addContainerGap(12, Short.MAX_VALUE)));
		setLayout(groupLayout);

	}
}
