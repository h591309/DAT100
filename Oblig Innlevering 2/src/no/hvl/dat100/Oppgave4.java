/*
 * 
 * 
 * Oppgave 6 - Utregning av trinnskatt
 * 
 * 
 * 
 * */




package no.hvl.dat100;

import javax.swing.JOptionPane;

public class Oppgave4 {

	public static void main(String[] args) {
		
		String inntektTxt = JOptionPane.showInputDialog("Skriv inn inntekten: ");
		double inntekt = Double.parseDouble(inntektTxt);
		double trinn1 = 0.93;
		double trinn2 = 2.41;
		double trinn3 = 11.52;
		double trinn4 = 14.52;
		
		double trinnSkatt = 0;
		
		
		if(inntekt <= 164100) {									//trinn 0
			trinnSkatt = 0;
			
		} else if(inntekt >= 164101 && inntekt <= 230950) {		//trinn 1
			trinnSkatt = inntekt * trinn1 / 100;
			
			
		} else if(inntekt >= 230951 && inntekt <= 580650) { 	//trinn 2
			trinnSkatt = inntekt * trinn2 / 100;
		
			
		} else if(inntekt >= 580651 && inntekt <= 934050) {		//trinn 3
			trinnSkatt = inntekt * trinn3 / 100;
			
			
		} else if(inntekt >= 934051) {							//trinn 4
			trinnSkatt = inntekt * trinn4 / 100;
			
			
		}
		
		JOptionPane.showMessageDialog(null, "Trinnskatten vil være: " + trinnSkatt + "kr.");
		
		
	}

}
