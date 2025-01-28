/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author roland
 */
public class Jeu {
    // Attributs 
    private LesPersonnages lesPers; // Personnages du Jeu 
    private LesJoueurs lesJ; // joueurs du jeu
    private PlateauJeu monP; // Le plateau du jeu (etat courant)
    private Action act; // Actionn a realiser 
    private int indC; // Indice du joueur courant 
    
    //Accesseur 

    public LesPersonnages getPersonnages() {
        return lesPers;
    }

    public LesJoueurs getJoueurs() {
        return lesJ;
    }

    public PlateauJeu getPlateau() {
        return monP;
    }

    public Action getAct() {
        return act;
    }

    public int getIndC() {
        return indC;
    }
    
    // Constructeur 
    public Jeu (LesPersonnages lp, LesJoueurs lj, int nbc)
    {
        this.lesPers= lp;
        this.lesJ= lj;
        this.indC= 0;
        this.monP = new PlateauJeu(nbc);
        this.act= null;
    }
    
    // Methodes
    
    public Joueur getJoueurCourant()
    {
        return this.lesJ.getJoueur(indC);
    }
    
    public int getIndSuivant(int ic)
    {
        return (ic+1)%this.lesJ.getNbJoueurs();
    }// Quand on est au dernier joueur on revient au premier
    
    public void setJoueurCourant(int s)
    {
        this.indC=s;
    }
    
    public boolean finJeu()
    {
        return this.monP.jeuVide();
    }
    
    // Methode pour traiter le nombre de tour du jeu 
    public int traiterTour( Joueur jo, int s)
    {
        int bonus=-1;
        Personnage pers = lesPers.getPerso(s);
        jo.ajoutePersoPaquet(pers);
        String fp = pers.getFamille();
        int npj = jo.getPaquet().getPersosFamille(fp).getTaille();
        int npf = lesPers.getPersosFamille(fp).getTaille();
        
        if(npj == npf)
        {
          if(fp.equals(jo.getFamillePrefere()))  
          {
              bonus=0;  
          }
          else 
              //
          {
              boolean valide = true;
              for(int i =0 ; i<this.lesJ.getNbJoueurs() ;i++)
              {
                  if(lesJ.getJoueur(i).getPaquet().getTaille()==0)
                      valide=false;
              }
               
              if(valide==true)
              {
                  if(fp.equals("rares") || fp.equals("communs"))
                      bonus=1;
                  else if(fp.equals("epiques") || fp.equals("legendaires"))
                          bonus=2;
                       else
                           bonus=3;
              }
          }
          
        }
            
          
        
        return bonus;
    }
    
}
