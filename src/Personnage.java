
import java.awt.Image;
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
public class Personnage {
    
    // Attributs 
    private String famille; 
    private String nom;
    private int valeur; 
    private Image photo;

    public Image getPhoto() {
        return this.photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }
    
    
   // Accesseur
    public String getFamille()
    {
        return this.famille;
    }
    
    public void setFamille(String f)
    {
        this.famille=f;
    }
    
    public int getValeur()
    {
        return this.valeur;
    }
    
    public String getNom()
    {
        return this.nom;
    }
    
    // Constructeur 
    public Personnage(String f,String n,int v)
    
    {
        
        this.famille=f;
        this.nom=n;
        this.valeur=v;
        this.photo = new ImageIcon(getClass().getResource("/img/"+this.nom+".jpg")).getImage();
    }
    
    public Personnage()
    {
        this("anonyme","anonyme",0);
        this.photo = new ImageIcon(getClass().getResource("/img/anonyme.jpg")).getImage();
    }
    
    
    // Methodes
    
    public String toString()
    {
        String s=" ";
        s+="Famille : "+this.famille+"\n";
        s+="Nom : "+this.nom+"\n";
        s+="Valeur : "+this.valeur+"\n";
        return s;
        
    }
    
    public void setImgBouton(JButton jb)
    {
        Image img = this.photo.getScaledInstance(jb.getWidth(),jb.getHeight(),Image.SCALE_SMOOTH);
        jb.setIcon(new ImageIcon(img));
        
    }
}
