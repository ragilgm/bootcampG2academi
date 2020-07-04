



public class Nilai {
    private double bahasaInggris;
    private double fisika;
    private double algoritma;

    public Nilai(double bahasaInggris, double fisika, double algoritma){
        this.bahasaInggris = bahasaInggris;
        this.fisika = fisika;
        this.algoritma = algoritma;
    }

    public double getBahasaInggris() {
        return bahasaInggris;
    }

    public void setBahasaInggris(double bahasaInggris) {
        this.bahasaInggris = bahasaInggris;
    }

    public double getFisika() {
        return fisika;
    }

    public void setFisika(double fisika) {
        this.fisika = fisika;
    }

    public double getAlgoritma() {
        return algoritma;
    }

    public void setAlgoritma(double algoritma) {
        this.algoritma = algoritma;
    }

    public Nilai createNilai(double bahasaInggris, double fisika, double algoritma){
        return new Nilai(bahasaInggris, fisika, algoritma);
    }


    
}