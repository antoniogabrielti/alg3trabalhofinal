
package model;

public class Hospital {
    private String Nome;
    private double latitude;
    private double longitude;

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getNome() {
        return Nome;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Nome do hospital: "+Nome+"\nLatitude: "+this.latitude+"\nLongitude: "+this.longitude;
    }
    
    
}
