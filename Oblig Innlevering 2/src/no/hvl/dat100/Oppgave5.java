package no.hvl.dat100;

import javax.swing.JOptionPane;

public class Oppgave5 {
	public static void main(String[] args) {
		
		String poengTxt;
		int poeng;
		
		for(int i = 1; i <= 10; i++) {
			
			poengTxt = JOptionPane.showInputDialog("Skriv inn poengsum for elev" + i + " (0-100): ");
			poeng = Integer.parseInt(poengTxt);
			
			while(poeng < 0 || poeng > 100 || poengTxt == "") {
				JOptionPane.showMessageDialog(null, "Tallet " + poeng + " er ugyldig!");
				poengTxt = JOptionPane.showInputDialog("Skriv inn poengsum for elev" + i + " (0-100): ");
				poeng = Integer.parseInt(poengTxt);
			}

			
			if(poeng <= 39) {
				System.out.println("Student" + i + " får karakter F med " + poeng + " poeng!");
				
			} else if(poeng <= 49) {
				System.out.println("Student" + i + " får karakter E med " + poeng + " poeng!");
				
			} else if(poeng <= 59) {
				System.out.println("Student" + i + " får karakter D med " + poeng + " poeng!");
				
			} else if(poeng <= 79) {
				System.out.println("Student" + i + " får karakter C med " + poeng + " poeng!");
				
			} else if(poeng <= 89) {
				System.out.println("Student" + i + " får karakter B med " + poeng + " poeng!");
				
			} else if(poeng <= 100) {
				System.out.println("Student" + i + " får karakter A med " + poeng + " poeng!");
				
			}
		
		}
		
	}
}
