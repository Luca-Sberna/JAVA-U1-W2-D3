package ex3;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Main {
	public static void main(String[] args) {
		RegistroPresenze registro = new RegistroPresenze();

		registro.aggiungiPresenza("Zlatan Ibrahimovich", 10);
		registro.aggiungiPresenza("Mike Maignan", 13);
		registro.aggiungiPresenza("Rafael Leao", 5);

		registro.salvaSuFile("presenze.txt");

		RegistroPresenze nuovoRegistro = new RegistroPresenze();
		nuovoRegistro.caricaDaFile("presenze.txt");

		nuovoRegistro.stampaPresenze();

		try {
			String content = readFileFromDisk("presenze.txt");
			System.out.println("");
			System.out.println("Contenuto del file:\n" + content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String readFileFromDisk(String nomeFile) throws IOException {
		File file = new File(nomeFile);
		if (file.exists()) {
			String content = FileUtils.readFileToString(file, "UTF-8");
			return content;
		} else {
			System.out.println("FILE NON TROVATO!");
			return "";
		}
	}
}
