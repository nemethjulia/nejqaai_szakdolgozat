package gui;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class HelpPanel extends JPanel {

	/**
	 * Auto generated serialVersion UID
	 */
	private static final long serialVersionUID = -6010631095524168028L;

	public HelpPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);

		JScrollPane scrollPane1 = new JScrollPane();
		tabbedPane.addTab("A mûködés folyamata", scrollPane1);

		JTextArea textArea1 = new JTextArea();
		textArea1.setEditable(false);
		scrollPane1.setViewportView(textArea1);

		String str = "\n";
		str += "A program Súgója\n";
		str += " \n";
		str += " \n";
		str += " A mûködés folyamata\n";
		str += " \n";
		str += " A módszerek kipróbálásához szükséges betölteni a programba egy mátrixot, egy b jobboldali- és minimum egy kezdõvektort, melyek nagysága megegyezik. Erre három féle lehetõséget ad az alkalmazás a Fájl -> \n Betöltés menüpontja alatt:	\n";
		str += " 	- Értékek megadásával a felületen keresztül\n";
		str += " 	- Fájból olvasással\n";
		str += " 	- Tesztadatok betöltésével\n";
		str += " Ez után a Módszerek -> Módszerek kipróbálása menüpontra megjelenik az a panel, mely képes megjeleníteni az eredményeket.\n";
		str += " Itt meg kell adnunk, hogy";
		str += " 	hány lépést szeretnénk maximum a módszerektõl,\n";
		str += " 	milyen kezdõvektorból indítsuk az iterációkat,\n";
		str += " 	mely módszereket kívánjuk látni.\n";
		str += " Ez után a Módszerek indítása gombra kattintva a program számolni kezd, majd megjeleníti az eredményeket.\n";
		textArea1.setText(str);

		JScrollPane scrollPane2 = new JScrollPane();
		tabbedPane.addTab("Belovasás", scrollPane2);

		JTextArea textArea2 = new JTextArea();
		textArea2.setEditable(false);
		scrollPane2.setViewportView(textArea2);

		str = "\n";
		str += "A program Súgója\n";
		str += " \n";
		str += " \n";
		str += " Beolvasás\n";
		str += " \n";
		str += " Értékek megadásával\n";
		str += " A mátrixot és a vektorokat megadhatjuk a felületen keresztül. Elõször a legördülõ menübõl kiválasztjuk, hogy milyen adatot kívánunk megadni. Megadhatjuk a mátrixot vagy a vektorok közül a b jobboldali \n vektort, vagy az x0 kezdõvektorok egyikét. A „Folytatás” gombra kattintva elérhetõvé válik a méret megadására szolgáló mezõ.\n";
		str += " A méret mezõbe a mátrix vagy a vektor méretét írjuk. Ez után a „Hozzáad” gombra kattintva folytathatjuk tovább az értékek megadásával.\n";
		str += " A sor és az oszlop mezõbe szintén természetes számok adhatóak csak meg, melyek 1 és n között vannak. Az érték mezõbe bármilyen valós számot megadhatunk (csak a 0-tól különbözõ értékûeket menti a program), \n az egész és a tizedes számokat ponttal elválasztva. A „Hozzáad” gombra nyomva menthetjük az adott sorhoz és oszlophoz tartozó értéket.	\n";
		str += " Ha már megadtuk az összes nem 0 elemet, a „Kész” gombra nyomva tárolhatjuk el a mátrixot vagy a vektor. Ha nem adunk meg egy értéket sem, akkor olyan mátrix vagy a vektor kerül tárolásra, melynek minden \n értéke 0.\n";
		str += " \n";
		str += " Fájlból beolvasással\n";
		str += " Elõször a legördülõ menübõl kiválasztjuk, hogy milyen adatot kívánunk megadni. Megadhatjuk a mátrixot vagy a vektorok közül a b jobboldali vektort vagy az x0 kezdõvektorok egyikét. A „Beolvasás” gombra \n kattintva megjelenik a fájlkeresõ ablak, mellyel kiválaszthatjuk az állományaink között a beolvasandó fájlt.\n";
		str += " A program által értelmezhetõ fájl szöveges formátumú (.txt kiterjesztésû), és a felépítése megtalálható a beolvasó panelen.\n";
		str += " \n";
		str += " Tesztadat betöltése\n";
		str += " Ha nem konkrét problémát szeretnénk megoldani, csak esetleg a program mûködését megfigyelni, akkor az alkalmazásba betölthetõ egy elõkészített adat együttes. Ekkor nem jelenik meg új képernyõ, az program \n csak egy felugró ablakkal jelzi, hogy a folyamat lezajlott.\n";
		str += " \n";

		textArea2.setText(str);

		JScrollPane scrollPane3 = new JScrollPane();
		tabbedPane.addTab("Eredmények olvasása, exportálása", scrollPane3);

		JTextArea textArea3 = new JTextArea();
		textArea3.setEditable(false);
		scrollPane3.setViewportView(textArea3);

		str = "\n";
		str += "A program Súgója\n";
		str += " \n";
		str += " \n";
		str += " Eredmények olvasása, exportálása\n";
		str += " \n";
		str += " Az elsõ grafikonon látható a tapasztalati kontrakciós együttható, míg a másodikon a reziduum vektor normájának változása. Az ezeken ábrázolt eredmények nem láthatóak mindig pontosan. Ha egy oszlop fölé \n visszük az egeret, a program megjeleníti a konkrét értéket.	\n";
		str += " A diagramon ábrázolt eredményeket kétféle módon is exportálhatjuk. A kirajzolt képet lementhetjük JPEG fájlba (“Kép mentése” gomb), mely 1200X1200 pixel méretû, de az értékek így sem látszanak pontosan. \n A másik lehetõség, hogy a megjelenített grafikon pontos értékeit egy txt fájlba írjuk (“Adatok mentése” gomb)	\n";
		str += " A diagramok mellett található a már ismert vektorpanel, melyen az iteráció eredményét látjuk. Ezt exportálhatjuk egy fájlba az “Az eredményvektor exportálása” gombbal.\n";
		str += " Az eredményvektor alatt látható, hogy a módszer hány lépést használt az elõre megadott maximumból. Ez akkor lehet kevesebb, ha a program elõbb leállítja az iterációt, mert megtalálta az eredményvektort, \n vagy biztosan divergál a módszer (a tapasztalati kontrakciós együttható (q) > 1.5 – Ekkor biztos, hogy q>1, érdemes leállítani az iterációt).	\n";
		str += " A panelen lehetõség van még az iteráció folytatására, azaz a szûrõpanelen megadott lépésszámban újra futtatni az adott iterációt az  eredményvektorral, mint kezdõvektorral. Ekkor a grafikonokon az új adatok \n láthatóak, az új x(n) is látszik, a használt lépések pedig hozzáadódnak az eddigiekhez.\n";
		str += " Lehetõség van még az eredményvektor eltárolására az aktuális kezdõvektorok között. Ez akkor lehet hasznos, ha egy módszer eredményvektorából szeretnénk indítani egy másik iterációt. Ahogy a program is \n figyelmeztet rá, ha használni szeretnénk ezt a vektort, újra kell töltenünk a panelt (“Módszerek” menü -> “Módszerek kipróbálása” gombbal).	\n";

		textArea3.setText(str);

	}

}
