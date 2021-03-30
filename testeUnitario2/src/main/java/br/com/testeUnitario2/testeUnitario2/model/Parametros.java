package br.com.testeUnitario2.testeUnitario2.model;

public class Parametros {

    private Double p1;
    private Double p2;

    public Parametros(Double p1, Double p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Parametros() {

    }

    public Double getP1() {
        return p1;
    }

    public void setP1(Double p1) {
        this.p1 = p1;
    }

    public Double getP2() {
        return p2;
    }

    public void setP2(Double p2) {
        this.p2 = p2;
    }
}
