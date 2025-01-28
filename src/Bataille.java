/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ka907986
 */
public class Bataille extends Action  {
   
    //Attributs 
    private Joueur adversaire ;
     
    // Constructeur
    public Bataille (Joueur sc, Joueur a)
    {
        super(sc,"Bataille");
        this.adversaire=a;
    }
   
    // Methodes
      
    public Joueur getAdversaire() {return adversaire; }
    
    public int execute() 
    { 
        Personnage c1 , c2 ;
        int res=-1;
        
        if(this.getJoueurCourant().getPaquet().getTaille()>0 && this.adversaire.getPaquet().getTaille()>0)
        {
            c1=  this.getJoueurCourant().getPaquet().getPerso(0);
            c2= this.adversaire.getPaquet().getPerso(0);
            this.getJoueurCourant().getPaquet().retirePerso(c1);
            this.adversaire.getPaquet().retirePerso(c2);
            
            if(c1.getValeur()== c2.getValeur())
            {
               res=0;
               this.getJoueurCourant().getPaquet().ajoutePerso(c1);
               this.adversaire.getPaquet().ajoutePerso(c2);
               
            }
            else
                if(c1.getValeur()> c2.getValeur())
                {
                   res=1;
                   this.getJoueurCourant().getPaquet().ajoutePerso(c1);
                   this.getJoueurCourant().getPaquet().ajoutePerso(c2);
                }
                else
                {
                   res=2; 
                   this.adversaire.getPaquet().ajoutePerso(c1);
                   this.adversaire.getPaquet().ajoutePerso(c2);
                }
            
            if(this.getJoueurCourant().getPaquet().getTaille()==0 && this.adversaire.getPaquet().getTaille()==0)
            {
               String s= "";
               s+="Bataille : "+this.getJoueurCourant().getPseudo();
               s+="Contre : "+this.adversaire.getPseudo()+"\n";
                
               if(this.getJoueurCourant().getPaquet().getTaille()>0)
                   s+="gagné !\n";
               else
                   s+="perdu !\n";
                super.setDeroulement(s);
            }
  
        }
        return res;
    }
    
    
}

