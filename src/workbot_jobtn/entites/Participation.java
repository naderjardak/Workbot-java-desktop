/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.entites;

/**
 *
 * @author hp
 */

public class Participation {
    private int id;
    private int id_event;
    private int id_userP;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public int getId_userP() {
        return id_userP;
    }

    public void setId_userP(int id_userP) {
        this.id_userP = id_userP;
    }

    public Participation() {
    }

    public Participation(int id_event, int id_userP) {
        this.id_event = id_event;
        this.id_userP = id_userP;
    }

    public Participation(int id, int id_event, int id_userP) {
        this.id = id;
        this.id_event = id_event;
        this.id_userP = id_userP;
    }
    
}
