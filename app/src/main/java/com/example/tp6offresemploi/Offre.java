package com.example.tp6offresemploi;

public class Offre {
    private Integer id;
    private String poste;
    private String description;

    public Offre(Integer id, String poste, String description) {
        this.id = id;
        this.poste = poste;
        this.description = description;
    }

    public Offre(String poste, String description) {
        this.poste = poste;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Offre{" +
                "id=" + id +
                ", poste='" + poste + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
