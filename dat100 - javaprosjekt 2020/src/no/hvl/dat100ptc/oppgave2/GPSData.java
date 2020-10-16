package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int n) {
		
		/*
		 * 
		 * KONSTRUKTØR
		 * 
		 * */
		
		//Opretter en tom tabell for gpspunkt, med størrelse n
		
		antall = 0;
		gpspoints = new GPSPoint[n];
		
	}

	
	public GPSPoint[] getGPSPoints() {
		
		return this.gpspoints;
		
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		
		
		boolean inserted = false;

		if(antall < gpspoints.length) {
			
			//Setter inn gpspoint i gpspoints-tabellen
			gpspoints[antall] = gpspoint;
			
			if(gpspoints[antall] != null) {
				//Øker antall dersom gpspunktet er satt inn.
				antall++;
				
				//Setter antall lik true dersom gpspunktet er satt inn
				inserted = true;
			}
			
		}
		
		
		return inserted;

		

		// TODO - SLUTT
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		GPSPoint gpspoint;
		gpspoint = new GPSPoint(GPSDataConverter.toSeconds(time), Double.parseDouble(latitude), Double.parseDouble(longitude), Double.parseDouble(elevation));
		
		return insertGPS(gpspoint);
	}

	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");

		for(int i = 0; i < gpspoints.length; i++) {
			System.out.println(gpspoints[i].toString());
		}

		
		System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
