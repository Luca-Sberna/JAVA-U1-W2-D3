package ex3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class RegistroPresenze {
	private List<Presenza> presenze;

	public RegistroPresenze() {
		presenze = new ArrayList<>();
	}

	public void aggiungiPresenza(String nome, int giorni) {
		presenze.add(new Presenza(nome, giorni));
	}

	public void salvaSuFile(String nomeFile) {
		StringBuilder sb = new StringBuilder();
		for (Presenza presenza : presenze) {
			sb.append(presenza.getNome()).append("@").append(presenza.getGiorni()).append("#");
		}
		sb.deleteCharAt(sb.length() - 1);

		try {
			FileUtils.writeStringToFile(new File(nomeFile), sb.toString(), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void caricaDaFile(String nomeFile) {
		try {
			String contenuto = FileUtils.readFileToString(new File(nomeFile), "UTF-8");
			String[] presenzeArray = contenuto.split("#");
			for (String presenzaStr : presenzeArray) {
				String[] presenzaInfo = presenzaStr.split("@");
				String nome = presenzaInfo[0];
				int giorni = Integer.parseInt(presenzaInfo[1]);
				presenze.add(new Presenza(nome, giorni));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void stampaPresenze() {
		for (Presenza presenza : presenze) {
			System.out.println(presenza.getNome() + ": " + presenza.getGiorni() + " giorni");
		}
	}

	private static class Presenza {
		private String nome;
		private int giorni;

		public Presenza(String nome, int giorni) {
			this.nome = nome;
			this.giorni = giorni;
		}

		public String getNome() {
			return nome;
		}

		public int getGiorni() {
			return giorni;
		}
	}
}
