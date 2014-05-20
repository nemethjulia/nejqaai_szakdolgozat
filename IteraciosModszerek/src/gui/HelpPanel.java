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
		tabbedPane.addTab("A m�k�d�s folyamata", scrollPane1);

		JTextArea textArea1 = new JTextArea();
		textArea1.setEditable(false);
		scrollPane1.setViewportView(textArea1);

		String str = "\n";
		str += "A program S�g�ja\n";
		str += " \n";
		str += " \n";
		str += " A m�k�d�s folyamata\n";
		str += " \n";
		str += " A m�dszerek kipr�b�l�s�hoz sz�ks�ges bet�lteni a programba egy m�trixot, egy b jobboldali- �s minimum egy kezd�vektort, melyek nagys�ga megegyezik. Erre h�rom f�le lehet�s�get ad az alkalmaz�s a F�jl -> \n Bet�lt�s men�pontja alatt:	\n";
		str += " 	- �rt�kek megad�s�val a fel�leten kereszt�l\n";
		str += " 	- F�jb�l olvas�ssal\n";
		str += " 	- Tesztadatok bet�lt�s�vel\n";
		str += " Ez ut�n a M�dszerek -> M�dszerek kipr�b�l�sa men�pontra megjelenik az a panel, mely k�pes megjelen�teni az eredm�nyeket.\n";
		str += " Itt meg kell adnunk, hogy";
		str += " 	h�ny l�p�st szeretn�nk maximum a m�dszerekt�l,\n";
		str += " 	milyen kezd�vektorb�l ind�tsuk az iter�ci�kat,\n";
		str += " 	mely m�dszereket k�v�njuk l�tni.\n";
		str += " Ez ut�n a M�dszerek ind�t�sa gombra kattintva a program sz�molni kezd, majd megjelen�ti az eredm�nyeket.\n";
		textArea1.setText(str);

		JScrollPane scrollPane2 = new JScrollPane();
		tabbedPane.addTab("Belovas�s", scrollPane2);

		JTextArea textArea2 = new JTextArea();
		textArea2.setEditable(false);
		scrollPane2.setViewportView(textArea2);

		str = "\n";
		str += "A program S�g�ja\n";
		str += " \n";
		str += " \n";
		str += " Beolvas�s\n";
		str += " \n";
		str += " �rt�kek megad�s�val\n";
		str += " A m�trixot �s a vektorokat megadhatjuk a fel�leten kereszt�l. El�sz�r a leg�rd�l� men�b�l kiv�lasztjuk, hogy milyen adatot k�v�nunk megadni. Megadhatjuk a m�trixot vagy a vektorok k�z�l a b jobboldali \n vektort, vagy az x0 kezd�vektorok egyik�t. A �Folytat�s� gombra kattintva el�rhet�v� v�lik a m�ret megad�s�ra szolg�l� mez�.\n";
		str += " A m�ret mez�be a m�trix vagy a vektor m�ret�t �rjuk. Ez ut�n a �Hozz�ad� gombra kattintva folytathatjuk tov�bb az �rt�kek megad�s�val.\n";
		str += " A sor �s az oszlop mez�be szint�n term�szetes sz�mok adhat�ak csak meg, melyek 1 �s n k�z�tt vannak. Az �rt�k mez�be b�rmilyen val�s sz�mot megadhatunk (csak a 0-t�l k�l�nb�z� �rt�k�eket menti a program), \n az eg�sz �s a tizedes sz�mokat ponttal elv�lasztva. A �Hozz�ad� gombra nyomva menthetj�k az adott sorhoz �s oszlophoz tartoz� �rt�ket.	\n";
		str += " Ha m�r megadtuk az �sszes nem 0 elemet, a �K�sz� gombra nyomva t�rolhatjuk el a m�trixot vagy a vektor. Ha nem adunk meg egy �rt�ket sem, akkor olyan m�trix vagy a vektor ker�l t�rol�sra, melynek minden \n �rt�ke 0.\n";
		str += " \n";
		str += " F�jlb�l beolvas�ssal\n";
		str += " El�sz�r a leg�rd�l� men�b�l kiv�lasztjuk, hogy milyen adatot k�v�nunk megadni. Megadhatjuk a m�trixot vagy a vektorok k�z�l a b jobboldali vektort vagy az x0 kezd�vektorok egyik�t. A �Beolvas�s� gombra \n kattintva megjelenik a f�jlkeres� ablak, mellyel kiv�laszthatjuk az �llom�nyaink k�z�tt a beolvasand� f�jlt.\n";
		str += " A program �ltal �rtelmezhet� f�jl sz�veges form�tum� (.txt kiterjeszt�s�), �s a fel�p�t�se megtal�lhat� a beolvas� panelen.\n";
		str += " \n";
		str += " Tesztadat bet�lt�se\n";
		str += " Ha nem konkr�t probl�m�t szeretn�nk megoldani, csak esetleg a program m�k�d�s�t megfigyelni, akkor az alkalmaz�sba bet�lthet� egy el�k�sz�tett adat egy�ttes. Ekkor nem jelenik meg �j k�perny�, az program \n csak egy felugr� ablakkal jelzi, hogy a folyamat lezajlott.\n";
		str += " \n";

		textArea2.setText(str);

		JScrollPane scrollPane3 = new JScrollPane();
		tabbedPane.addTab("Eredm�nyek olvas�sa, export�l�sa", scrollPane3);

		JTextArea textArea3 = new JTextArea();
		textArea3.setEditable(false);
		scrollPane3.setViewportView(textArea3);

		str = "\n";
		str += "A program S�g�ja\n";
		str += " \n";
		str += " \n";
		str += " Eredm�nyek olvas�sa, export�l�sa\n";
		str += " \n";
		str += " Az els� grafikonon l�that� a tapasztalati kontrakci�s egy�tthat�, m�g a m�sodikon a reziduum vektor norm�j�nak v�ltoz�sa. Az ezeken �br�zolt eredm�nyek nem l�that�ak mindig pontosan. Ha egy oszlop f�l� \n vissz�k az egeret, a program megjelen�ti a konkr�t �rt�ket.	\n";
		str += " A diagramon �br�zolt eredm�nyeket k�tf�le m�don is export�lhatjuk. A kirajzolt k�pet lementhetj�k JPEG f�jlba (�K�p ment�se� gomb), mely 1200X1200 pixel m�ret�, de az �rt�kek �gy sem l�tszanak pontosan. \n A m�sik lehet�s�g, hogy a megjelen�tett grafikon pontos �rt�keit egy txt f�jlba �rjuk (�Adatok ment�se� gomb)	\n";
		str += " A diagramok mellett tal�lhat� a m�r ismert vektorpanel, melyen az iter�ci� eredm�ny�t l�tjuk. Ezt export�lhatjuk egy f�jlba az �Az eredm�nyvektor export�l�sa� gombbal.\n";
		str += " Az eredm�nyvektor alatt l�that�, hogy a m�dszer h�ny l�p�st haszn�lt az el�re megadott maximumb�l. Ez akkor lehet kevesebb, ha a program el�bb le�ll�tja az iter�ci�t, mert megtal�lta az eredm�nyvektort, \n vagy biztosan diverg�l a m�dszer (a tapasztalati kontrakci�s egy�tthat� (q) > 1.5 � Ekkor biztos, hogy q>1, �rdemes le�ll�tani az iter�ci�t).	\n";
		str += " A panelen lehet�s�g van m�g az iter�ci� folytat�s�ra, azaz a sz�r�panelen megadott l�p�ssz�mban �jra futtatni az adott iter�ci�t az  eredm�nyvektorral, mint kezd�vektorral. Ekkor a grafikonokon az �j adatok \n l�that�ak, az �j x(n) is l�tszik, a haszn�lt l�p�sek pedig hozz�ad�dnak az eddigiekhez.\n";
		str += " Lehet�s�g van m�g az eredm�nyvektor elt�rol�s�ra az aktu�lis kezd�vektorok k�z�tt. Ez akkor lehet hasznos, ha egy m�dszer eredm�nyvektor�b�l szeretn�nk ind�tani egy m�sik iter�ci�t. Ahogy a program is \n figyelmeztet r�, ha haszn�lni szeretn�nk ezt a vektort, �jra kell t�lten�nk a panelt (�M�dszerek� men� -> �M�dszerek kipr�b�l�sa� gombbal).	\n";

		textArea3.setText(str);

	}

}
