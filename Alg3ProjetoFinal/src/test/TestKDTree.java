/*
 * Data Structures and Algorithms.
 * Copyright (C) 2016 Rafael Guterres Jeffman
 *
 * See the LICENSE file accompanying this source code, for
 * licensing restrictions that might apply.
 *
 */

package test;

import util.KDData;
import util.KDTree;


public class TestKDTree {

	public static void main(String[] args) {
        
		double[] x = { -30.029761, -30.01008, -30.026801,-30.015932,-30.029413,-30.036732,-30.0555189};
                double[] y = { -51.220184, -51.159222, -51.209125,-51.158867,-51.214928,-51.209457,-51.1704967};
               	String[] data = { "Santa Casa", "Cristo Redentor", "Moinhos de Vento","Nossa Senhora Conceicao"
                        + "","Presidente Vargas","Pronto Socorro","Sao Lucas"};
                KDData[] p = new KDData[x.length];
                
		for (int i = 0; i < x.length; i++) {
			p[i] = new KDData(x[i], y[i], data[i]);

		}


		KDTree kd = new KDTree(p);
		System.out.println(kd.toString());
                

		KDData point;
                // system.out.println modificado mostrando agora os hospitais + proximos
		System.out.println("\nBuscando pelos 2 hospitais mais proximos de Senacrs...");
		point = new KDData(-30.0369357, -51.2277891); // coordenadas Senacrs - conforme google
		KDData [] V = new KDData[2];         
		V = kd.findKNearestPoints(point, V, p);
		for (KDData n : V) {
			System.out.print(n + " ");
		}
                System.out.println(" ");
                System.out.println("\nBuscando pelos 5 hospitais mais proximos de Senacrs...");
		point = new KDData(-30.0369357, -51.2277891); // coordenadas Senacrs - conforme google
		KDData [] Z = new KDData[5];         
		Z = kd.findKNearestPoints(point, Z, p);
		for (KDData n : Z) {
			System.out.print(n + " ");
		}
	
	}

}
