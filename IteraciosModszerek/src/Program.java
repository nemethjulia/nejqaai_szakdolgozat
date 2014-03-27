
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {

	public void Run() throws IOException {
		int choice = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Kedves Felhasználó! \nA LER megoldása a cél, vagy a módszerek kipróbálása, összehasonlítása?");
		while (choice != 1 && choice != 2) {
			System.out.println("Válasszon!");
			System.out.println("1, LER megoldása");
			System.out.println("2, Módszerek kipróbálása");
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
		System.out.println("A programnak be kell olvasni a mátrixot.");
		// MySparseMatrix

	}

	private void proba() {
		// TODO Auto-generated method stub

	}

}
