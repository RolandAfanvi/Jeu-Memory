/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ka907986
 */
public abstract class Action {
    
    //Attributs 
    protected Joueur j;
    protected String descriptif;
    protected String deroulement ;
    
    //Accesseur 

    public Joueur getJoueurCourant() {
        return j;
    }

    public void setJoueurCourant(Joueur j) {
        this.j = j;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public String getDeroulement() {
        return deroulement;
    }
    
    public void setDeroulement(String deroulement) {
        this.deroulement = deroulement;
    }
    
    // Constructeur 
    public Action(Joueur jo, String d)
    {
        this.j= jo;
        this.descriptif= d;
        this.deroulement="";
    }
     
    // Methodes 
    public abstract int execute();
             
}
