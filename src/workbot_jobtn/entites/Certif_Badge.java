/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.entites;

/**
 *
 * @author ADMIN
 */
public class Certif_Badge {
    private int id_user,id_certif,id_badge;

    public Certif_Badge() {
    }

    public Certif_Badge(int id_user) {
        this.id_user = id_user;
    }

    public Certif_Badge(int id_certif, int id_badge) {
        this.id_certif = id_certif;
        this.id_badge = id_badge;
    }

    
    public Certif_Badge(int id_user, int id_certif, int id_badge) {
        this.id_user = id_user;
        this.id_certif = id_certif;
        this.id_badge = id_badge;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_certif() {
        return id_certif;
    }

    public void setId_certif(int id_certif) {
        this.id_certif = id_certif;
    }

    public int getId_badge() {
        return id_badge;
    }

    public void setId_badge(int id_badge) {
        this.id_badge = id_badge;
    }

    @Override
    public String toString() {
        return "Certif_Badge{" + "id_user=" + id_user + ", id_certif=" + id_certif + ", id_badge=" + id_badge + '}';
    }
    
    
    
}
