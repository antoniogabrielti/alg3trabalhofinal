/*
 * Data Structures and Algorithms.
 * Copyright (C) 2016 Rafael Guterres Jeffman
 *
 * See the LICENSE file accompanying this source code, for
 * licensing restrictions that might apply.
 *
 */

package util;

import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.toRadians;
import java.text.DecimalFormat;

public class KDData implements Comparable<KDData> {
	private double[] _data;
        private String hospital;

        
	
	public KDData(double latitude, double longitude,String nome) {
            _data=new double[2];
            this._data[0]= latitude;
            this._data[1]= longitude;
            this.hospital=nome;
	}
        public KDData(double latitude, double longitude) {
            _data=new double[2];
            this._data[0]= latitude;
            this._data[1]= longitude;
        }
        public KDData(double distancia,String nome){
            _data=new double[1];
            this._data[0]=distancia;
            this.hospital=nome;
        }

	public double get(int dimension) {
		return _data[dimension];
	}

	public int length() {
		return _data.length;
	}

    public String getHospital() {
        return hospital;
    }
        

        // Metodo de distancia foi alterado, conforme metodo do GTFS para calculo de coordenada
	public double distance(KDData point) {
				// double R = 6378137; // Earth Equatorial radius in meters.
		double R = 6371000.8; // Earth volumetric radius in meters (IUGG).

		double dlat = toRadians(get(0) - point.get(0));
		double dlon = toRadians(get(1) - point.get(1));
		double coslat = cos(toRadians(get(0)));
		double cosother = cos(toRadians(get(1)));

		// compute haversine
		double a = pow(sin(dlat) / 2.0, 2) + coslat * cosother
				* pow(sin(dlon / 2.0), 2);
		double c = 2 * atan2(sqrt(a), sqrt(1 - a));
		double d = R * c;
                double result= d/1000;
		return result;
	}

	@Override // metodo toString alterado
	public String toString() {
                if(_data.length==1){
                    DecimalFormat decimal = new DecimalFormat( "0.00" );
                    return " \n"+hospital+" / "+decimal.format(_data[0])+" quilometros";
                }else{
                    String res = "[" + _data[0];
                    for (int i = 1; i < _data.length; i++)
			res += ", " + _data[i];
                    return res + "]"+":"+hospital;
                }
	}

      @Override // metodo compareTo acrescentado
    public int compareTo(KDData dado) {
        if(this._data[0]>dado._data[0]){
            return 1;
        }
        if(this._data[0]<dado._data[0]){
            return -1;
        }else{
            return 0;
        }
    }
 
}
