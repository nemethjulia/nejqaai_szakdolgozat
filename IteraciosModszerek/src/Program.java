
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {

	public void Run() throws IOException {
		int choice = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Kedves Felhaszn�l�! \nA LER megold�sa a c�l, vagy a m�dszerek kipr�b�l�sa, �sszehasonl�t�sa?");
		while (choice != 1 && choice != 2) {
			System.out.println("V�lasszon!");
			System.out.println("1, LER megold�sa");
			System.out.println("2, M�dszerek kipr�b�l�sa");
			choice = Integer.parseInt(reader.readLine());

		}
		switch (choice) {
			case 1 :
				megoldas();
				break;

			case 2 :
				proba();
				break;
		}

	}

	private void megoldas() {
		System.out.println("A programnak be kell olvasni a m�trixot.");
		// MySparseMatrix

	}

	private void proba() {
		// TODO Auto-generated method stub

	}

}
