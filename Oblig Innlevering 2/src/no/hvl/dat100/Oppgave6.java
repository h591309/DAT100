package no.hvl.dat100;

import javax.swing.JOptionPane;


public class Oppgave6 {

	public static void main(String[] args) {
		//Leser inn tall som er større enn 0;
		
		String nTall = JOptionPane.showInputDialog("Skriv inn et tall for å regne ut fakultet: ");
		
		int n = Integer.parseInt(nTall);
		long fakultet = 1;
		
		while(n <= 0) {
			JOptionPane.showMessageDialog(null, "Tallet " + n + " er for lavt, kan ikke regne ut fakultet!");
			nTall = JOptionPane.showInputDialog("Skriv inn et tall for å regne ut fakultet: ");
			n = Integer.parseInt(nTall);
			
		}
		
		while (n > 1) {
			fakultet *= n;
			n--;
		}
		
		System.out.println(nTall + "! = " + fakultet);

	}

}
