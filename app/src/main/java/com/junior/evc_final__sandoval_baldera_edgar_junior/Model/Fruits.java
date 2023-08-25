package com.junior.evc_final__sandoval_baldera_edgar_junior.Model;

public class Fruits {

    private String nombre;
    private int calorias;
    private double azucar;
    private double carbohidratos;
    private double proteinas;
    private String imageUrl;

    public Fruits(String nombre, int calorias, double azucar, double carbohidratos, double proteinas, String imageUrl) {
        this.nombre = nombre;
        this.calorias = calorias;
        this.azucar = azucar;
        this.carbohidratos = carbohidratos;
        this.proteinas = proteinas;
        this.imageUrl = imageUrl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public double getAzucar() {
        return azucar;
    }

    public void setAzucar(float azucar) {
        this.azucar = azucar;
    }

    public double getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(float carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(float proteinas) {
        this.proteinas = proteinas;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
