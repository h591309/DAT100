package no.hvl.dat100.lab6.matriser;

public class Matriser {

	// a)
	public static void skrivUt(int[][] matrise) {
		
		for(int i = 0; i < matrise.length; i++) {
			for(int j = 0; j < matrise[i].length; i++) {
				System.out.println(matrise[i][j]);
			}
		}
		//throw new UnsupportedOperationException("skrivUt ikke implementert");
	}

	// b)
	public static String tilStreng(int[][] matrise) {
		String txt = "";

		//TODO
		for(int i = 0; i < matrise.length; i++) {
			
			for(int j = 0; j < matrise[i].length; j++) {
				
				txt += matrise[i][j] + " ";
				
			}
			txt += "\n";
		}
		System.out.println(txt);
		return txt;
		//throw new UnsupportedOperationException("tilStreng ikke implementert");
	}

	// c)
	public static int[][] skaler(int tall, int[][] matrise) {
		
		int[][] nyMatrise = new int[matrise.length][matrise[0].length];
		
		for(int i = 0; i < matrise.length; i++) {
			
			for(int j = 0; j < matrise[i].length; j++) {
				
				nyMatrise[i][j] = matrise[i][j] * tall;
				
			}
		}
		
		return nyMatrise;
	}

	// d)
	public static boolean erLik(int[][] a, int[][] b) {

		
		for(int i = 0; i < a.length; i++) {
			
			for(int j = 0; j < b[i].length; j++) {
				
				if(a[i][j] == b[i][j]) {
					return true;
				}
			}
		}
		
		return false;
		
		//throw new UnsupportedOperationException("erLik ikke implementert");
	}
	
	// e)
	public static int[][] speile(int[][] matrise) {
		

		int[][] nyMatrise = new int[matrise.length][matrise.length];
		
		for(int i = 0; i < matrise.length; i++) {
			for(int j = 0; j < matrise[i].length; j++) {
				
				nyMatrise[i][j] = matrise[j][i];
				
			}
		}
				
		return nyMatrise;
		
		
		//throw new UnsupportedOperationException("speile ikke implementert");
	
	}

	// f)
	
	public static int[][] multipliser(int[][] a, int[][] b) {
		
		int[][] nyMatrise = new int[a.length][b.length];
		int[][] speiletB = speile(b);
		int tempSum;
		
		
		if(a.length == b[0].length) {
				
			for(int k = 0; k < a.length; k++) {
				
				for(int i = 0; i < a.length; i++) {
					
					tempSum = 0;
					
					for(int j = 0; j < b[0].length; j++) {
							
						tempSum += a[k][j] * speiletB[i][j];
						
					}
					nyMatrise[k][i] = tempSum;
				}
			}
			
			tilStreng(nyMatrise);
			
		}	
		
		return nyMatrise;
		//throw new UnsupportedOperationException("multipliser ikke implementert");
	
	}
}
