import java.awt.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ka907986
 */
public class Joueur {
    // attributs
    private String pseudo;
    private String famillePrefere;
    private LesPersonnages paquet;
    private ImageIcon photo;
    
    // methodes complementaires
    
    public void ajoutePersoPaquet(Personnage p) 
    {
        this.paquet.ajoutePerso(p);
    }
    public void initPaquetTest()
    {
        ajoutePersoPaquet(new Personnage("communs", "assault-trooper", 10));
        ajoutePersoPaquet(new Personnage("communs", "commando", 20));
        ajoutePersoPaquet(new Personnage("rares", "absolute-zero", 10));
    }
    
    // Accesseur
    public String getPseudo() {
        return this.pseudo;
    }

    public void setPseudo(String p) {
        this.pseudo = p;
    }
   

    public String getFamillePrefere() {
        return this.famillePrefere;
    }

    public void setFamillePrefere(String famillePrefere) {
        this.famillePrefere = famillePrefere;
    }

    public LesPersonnages getPaquet() {
        return this.paquet;
    }

    public void setPaquet(LesPersonnages pqt) {
        this.paquet = pqt;
    }

    public ImageIcon getPhoto() {
        return this.photo;
    }

    public void setPhoto(ImageIcon photo) {
        this.photo = photo;
    }
    
    
    
    
    
    
    // Construteur
    
    public Joueur(String ps,String fp)
    {
       this.pseudo=ps;
       this.famillePrefere=fp;
       this.paquet=new LesPersonnages();
       //this.photo=new ImageIcon(getClass().getResource("/img/"+this.pseudo+".jpg"));
       this.photo=new ImageIcon(getClass().getResource("/img/joueurDefaut.png"));
       
    }
    
    public Joueur ()
    {
        this.pseudo="anonyme";
        this.famillePrefere="anonyme";
        this.paquet= new LesPersonnages();
        this.photo= new ImageIcon(getClass().getResource("/img/anonyme.png"));
    }
    
    public int getScore()
    {   int s=0;
        for (int i=0; i< this.paquet.getTaille(); i++)
        {
            s+=this.paquet.getPerso(i).getValeur();
        }
        return s;
        
    }
    
    // methodes 
    
    public String toString()
    {
        String s ="";
        s+="Joueur "+this.pseudo+"\n";
        s+="famille préférée :"+this.famillePrefere+"\n";
        s+= "en possession des personnages : \n"+this.paquet.toString();
        s+="Score : "+this.paquet.getScore();
        return s;
    }
    
  
    
}
