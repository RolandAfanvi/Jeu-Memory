/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author roland
 */
public class Transfert extends Action {
    
    private Joueur cible;
    private String fp; //famille de la carte sélectionnée
    private LesPersonnages cartesTransferees; // cartes transférées
    
    public LesPersonnages getCartesTransferees() {
        return cartesTransferees;
    }
    public Joueur getJoueurCible(){ return this.cible; }
    

    public Transfert(Joueur jc, Joueur c, String f) {
        super(jc, "Transfert de cartes");
        this.cible = c;
        this.fp=f;
        this.cartesTransferees= new LesPersonnages();
    }
    
    // Methode execute
    @Override
    public int execute() 
    {
        // Veificqtion si la famille n est pas nulle
        int res=0;
        if(!fp.equals(""))
        {
            // on retiree les cartes du paquet du joueur cible
            this.cartesTransferees= this.cible.getPaquet().retirePersosFamille(fp);
            // On a joute les cartes dans le paquet du joueur courant
            for (int i=0; i<this.cartesTransferees.getTaille(); i++)
            {
                super.getJoueurCourant().ajoutePersoPaquet(this.cartesTransferees.getPerso(i));
            }
            this.deroulement = super.getJoueurCourant().getPseudo()+" a pris les cartes de la famille"+this.fp+" à "+this.cible;
            
            res = this.cartesTransferees.getTaille();
            
        }
        return res;
        
    }
    
}
