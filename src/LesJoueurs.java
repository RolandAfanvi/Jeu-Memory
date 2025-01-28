
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ka907986
 */
public class LesJoueurs {
    
    // attriuts 
    private ArrayList<Joueur> lstJ;
    
    // constructeur 
           
    public LesJoueurs()
    {
        this.lstJ= new ArrayList<>();
    }
    
    //Methodes 
    
    public Joueur getJoueur(int i)
    {
        if(i>=0 && i< this.lstJ.size())
            return this.lstJ.get(i);
        else 
            return null;
    }
    //
    public int getIndiceJoueur(Joueur j) 
    {
        return lstJ.indexOf(j);
    }
    //
    public int getNbJoueurs()
    {
        return lstJ.size();
    }
    //
    public void ajouteJoueur(Joueur j) 
    {
        lstJ.add(j);
    }
    //
    public  Joueur  rechJoueur(String  p)
    {
        Joueur j =  new Joueur();
        for(int i=0 ; i<lstJ.size(); i++)
        {
            if(this.getJoueur(i).getPseudo().equals(p))
            {
                j=getJoueur(i);
            }
        }
        return j; 
        
    }
    //
    public  void  supprimeJoueur(Joueur  j)
    {
        int i =0;
        boolean trouve = false; 
        while(i<lstJ.size() && !trouve)
        {
            if(getJoueur(i).getPseudo().equals(j.getPseudo()))
            {
                this.lstJ.remove(i);
                trouve = true;
            }
            else 
                i++;
        }
    }
    //
    public String toString()
    {
        String res= "\n";
        
        for(int i=0; i < this.lstJ.size(); i++)
        {   
            res+="JOUEUR "+(i+1)+"\n";
            res+=this.lstJ.get(i).toString()+"\n";
        }
        return res;
    }
    
    //
    
    public LesJoueurs getGagnants()
    {
        int max=getJoueur(0).getScore();
        for(int i=1; i<getNbJoueurs();i++)
            if (getJoueur(i).getScore()>max)
                max=this.getJoueur(i).getScore();
        LesJoueurs lst=new LesJoueurs();
        for(int i=0; i<getNbJoueurs();i++)
            if (getJoueur(i).getScore()==max)
                lst.ajouteJoueur(getJoueur(i));
        return lst;
        
    }
    
}
