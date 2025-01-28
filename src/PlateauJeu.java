/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author roland
 */
public class PlateauJeu {
    
private int tab [ ][ ];
private int nbp; // nombre de personnages sur le plateau qui diminue au cours du jeu
private int nblig;
private int nbcol;

// Constructeur avec parametre
public PlateauJeu(int n)
{   
    this. nbp=n;
    this.nblig=(int)(Math.sqrt(nbp*2)) ;
    this.nbcol=nbp*2/nblig;
    this.tab=new int [this.nblig][this.nbcol];
    initPlateauJeu();
}

// Constructeur par defaut
public PlateauJeu() { this(4); }
//Methode pour recuperer le nombre de ligne
public int getNblig() { return this.nblig; }
//Methode pour recuperer le nombre de colonne
public int getNbcol() { return this.nbcol; }
//methode pour recuperer le nombre de personnage
public int getNbp() { return this.nbp; }
// methode pour reccuperer la case de ligne l et de colonne c
public int getCase(int l, int c) { return tab[l][c]; }
//
public int getNbc() { return this.nblig*this.nbcol/2; }
//Methode pour le remplissage du plateau 
public void initPlateauJeu()
{   int k=0;
    for(int i=0; i<this.nblig; i++)
      for(int j=0; j<this.nbcol; j++)
         tab[i][j]=(k++)%this.nbp;
    melange();
}

// methode pour rendre invalide deux case du plateau simultanement 
public void invalide(int l1, int c1, int l2, int c2)
{
    tab[l1][c1]=-1;
    tab[l2][c2]=-1;
    nbp--;
}

// Methode pour faire le melange des valeurs dans le tableau 
public void melange()
{ 
    for(int i=1; i<=100; i++)
    {
        int l1=(int)(Math.random()*nblig);
        int c1=(int)(Math.random()*nbcol);
        int l2=(int)(Math.random()*nblig);
        int c2=(int)(Math.random()*nbcol);
        
        int temp = this.tab[l1][c1];
        this.tab[l1][c1]=tab[l2][c2];
        tab[l2][c2]=temp;
    }
}

// Permet de verifier si le jeu es vide c'est a dire le nombre de personnage est nulle dans le jeu 
public boolean jeuVide()
{
    return nbp==0;
}

// Methode pour verifier 
public boolean estValide(int l, int c)
{
    return tab[l][c]!=-1;
}
// Methode pour terminer le jeu c est a dire mettre toutes les valeurs du tableau
// a -1
public void termineJeu()
{
    for(int i=0; i<nblig; i++)
        for(int j=0; j<nbcol; j++)
            tab[i][j]=-1;
    nbp=0;
}
   

    
    
}
