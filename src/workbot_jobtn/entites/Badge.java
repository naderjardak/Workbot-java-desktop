/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.entites;

/**
 *
 * @author ADMIN
 */
public class Badge {
    
    private int id;
    private String nom;

    public Badge() {
    }

    public Badge(int id) {
        this.id = id;
    }

    public Badge(String nom) {
        this.nom = nom;
    }

    public Badge(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Badge{" + "id=" + id + ", nom=" + nom + '}';
    }
    
    
}
