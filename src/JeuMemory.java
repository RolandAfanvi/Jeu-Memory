
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ka907986
 */

public class JeuMemory extends javax.swing.JFrame {

    /**
     * Creates new form JeuMemory
     */
    // Attributs
    private LesPersonnages persos ; // Attributs les personnages pour les personnages
                                    // du jeu
    private LesJoueurs joueurs ;  // Pour gerer les joueurs du jeu
    private Jeu monJeu; // pour la gestion d’un tour de jeu
    private int l1, c1, l2, c2; // pour les cartes sélectionnées à chaque tour de jeu
    private  int pos1 ,pos2;
    
    // Methode execute apres le clic sur une carte du jeu 
    private void boutonActionPerformed(ActionEvent evt) 
    {
        JButton bt = (JButton)evt.getSource();
        int pos=0;
        int num = parseInt(bt.getName());
        int l = 0; //pour recuperer la ligne 
        int c= 0;   //pour recuperer la colonne 
        
        int ligne = this.monJeu.getPlateau().getNblig(); // nombre de ligne du plateau
        int colonne = this.monJeu.getPlateau().getNbcol();  // nombre de colnne du plateau 
        int n = -1;  // valeur qui va etre incrementer 
        for(int i=0 ; i<ligne ; i++)
        {
            for(int j=0; j<colonne ; j++)
            {
                n++;
                if(n==num)
                {
                    pos=n;
                    l=i;
                    c=j;
                }
            }       
        }
        int valeur = this.monJeu.getPlateau().getCase(l, c);
        
        Image img = this.persos.getPerso(valeur).getPhoto().getScaledInstance(bt.getWidth(),bt.getHeight(),Image.SCALE_SMOOTH);
        bt.setIcon(new ImageIcon(img));
        
        // Si c'est la premiere carte qui est tourne 
        if(this.l1==-1 && this.c1==-1)
        {
            //on fait l1=l et c1=c
            this.l1=l;
            this.c1=c;
            this.pos1=pos;
        }    
        //sinon si c est la deuxieme carte qui est tourne 
        else if(l2==-1 && c2==-1)
        {
           // on fait l2=l et c2=c
            this.l2=l;
            this.c2=c;
            
            if(l2!=l1 || c2!=c1)
            {
                this.pos2=pos;
            
                // on appelle la methode startTimer() 
                startTimer();
            }
            else 
            {this.l2=-1; this.c2=-1;}
        }
    }
    
    //Methode qui permet d'avoir un temps d'attente apres le clic sur la deuxieme carte   
    public void startTimer(){
        // définit un timer qui lance la vérification des deux personnages au bout d'une demi-seconde
        Timer t = new Timer(500, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                verifPersos();
            }
        });
        t.setRepeats(false);
        t.start();
    }
    
    //Methode qui verifie les deux cartes retounes 
    public void verifPersos() 
    {
        int val1 = this.monJeu.getPlateau().getCase(l1, c1);
        int val2 = this.monJeu.getPlateau().getCase(l2, c2);
        if(val1==val2)
        {
            Panneau.getComponent(pos1).setEnabled(false);
            Panneau.getComponent(pos2).setEnabled(false);
            String fam = this.persos.getPerso(val1).getFamille();
            int bonus = this.monJeu.traiterTour(this.monJeu.getJoueurCourant(), val1);
            if(bonus>=0)
            {
                Edition.setText(this.monJeu.getJoueurCourant().getPseudo()+" a récupérer tous les personnages de la famille "+fam);
                if(bonus==0)
                {
                    this.monJeu.finJeu();
                    Edition.append(this.monJeu.getJoueurCourant().getPseudo()+" a gagné !");
                    // Tous les boutons sont bloques
                    for(int i=0 ; i<this.persos.getTaille()*2 ; i++)
                    { Panneau.getComponent(i).setEnabled(false);}
                }
                else if(bonus==1)
                {
                    TransfertDlg transfert = new TransfertDlg(this,true,this.joueurs,this.monJeu.getIndC());
                    transfert.setVisible(true);
                    if(transfert.isOk()==true)
                        Edition.append("\n"+transfert.getTransfert().getDeroulement());
                }
                else if(bonus==2)
                {
                    BatailleDlg bataille = new BatailleDlg(this,true,this.joueurs,this.monJeu.getIndC());
                    bataille.setVisible(true);
                    if(bataille.isOk()==true)
                        Edition.append("\n"+bataille.getBataille().getDeroulement());
                    
                }
                bonus=-1;
                int indC  =this.monJeu.getIndC();
                this.monJeu.setJoueurCourant(this.monJeu.getIndSuivant(indC));
                
            }
            // Les cartes sont retires du plateau
            this.monJeu.getPlateau().invalide(l1, c1, l2, c2);
            //S'il n y a plus de carte a retouner
            if(this.monJeu.getPlateau().jeuVide())
            {
                Edition.append("\n   FIN DE JEU");
                LesJoueurs lesj = this.monJeu.getJoueurs().getGagnants();
                if(lesj.getNbJoueurs()>1)
                {Edition.append("\nLes joueurs gagnants sont:\n"+lesj.toString());
                 
                }
                else if(lesj.getNbJoueurs()==1)
                {Edition.append("\nLe joueur gagnant est: "+lesj.getJoueur(0).toString());
                 Message3.setText("C'est "+lesj.getJoueur(0).getPseudo()+" le gagnant");
                }
            }
            //else
                //Edition.append("\nC'est à "+this.monJeu.getJoueurCourant().getPseudo()+"de jouer");
            Message1.setText("Nombre de personnages trouvés: "+(this.persos.getTaille()-this.monJeu.getPlateau().getNbp()));
            Message2.setText("Nombre de personnages restant: "+this.monJeu.getPlateau().getNbp());
           
        }
        else 
        {
         
              
            JButton bt1 = (JButton)Panneau.getComponent(pos1);
            bt1.setIcon(null);
           
            JButton bt2 = (JButton)Panneau.getComponent(pos2);
            bt2.setIcon(null);
            
            int indc = this.monJeu.getIndC();
            this.monJeu.setJoueurCourant(this.monJeu.getIndSuivant(indc));
            Message3.setText("C'est a "+this.monJeu.getJoueurCourant().getPseudo()+" de jouer");
          
        }
        this.l1=-1;this.c1=-1;this.l2=-1;this.c2=-1; 
    }
    
    
    
    
    // CONSTRUCTEUR
    public JeuMemory() {
        initComponents();
        this.joueurs= new LesJoueurs(); // Allocation memoire pour stocker de joueur
        this.persos = new LesPersonnages(10); // Allocation memoire pour stocker les personnages
        this.l1= -1;this.c1= -1;
        this.l2= -1;this.c2= -1;
        this.pos1=-1;
        this.pos2=-1;
        this.monJeu=null;
        
        
       /* Joueur j=new Joueur("Lara", "epiques"); //Creation de joueur Lara
        j.setPhoto(new ImageIcon(getClass().getResource("/img/lara.jpg")));
        this.joueurs.ajouteJoueur(j);  // Ajout de ce joueur a l nsemble des joueurs
        j=new Joueur("Jack", "rares"); //Creation de joueur Jack
        j.setPhoto(new ImageIcon(getClass().getResource("/img/jack.png")));
        this.joueurs.ajouteJoueur(j);  // Ajout de ce joueur a l'ensemble des joueurs
        
         */
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PInfos = new javax.swing.JPanel();
        PHaut = new javax.swing.JPanel();
        Message1 = new javax.swing.JLabel();
        Message2 = new javax.swing.JLabel();
        Message3 = new javax.swing.JLabel();
        PBas = new javax.swing.JPanel();
        BDemarrer = new javax.swing.JButton();
        BRecommencer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Edition = new javax.swing.JTextArea();
        Panneau = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MParametres = new javax.swing.JMenu();
        Options = new javax.swing.JMenuItem();
        AjoutJoueur = new javax.swing.JMenuItem();
        MVisualiser = new javax.swing.JMenu();
        MJoueur = new javax.swing.JMenuItem();
        MCarte = new javax.swing.JMenuItem();
        Test = new javax.swing.JMenu();
        Transfert_Test = new javax.swing.JMenuItem();
        Bataille_Test = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.BorderLayout());

        PInfos.setLayout(new java.awt.BorderLayout());

        PHaut.setLayout(new java.awt.GridLayout(3, 1));
        PHaut.add(Message1);
        PHaut.add(Message2);

        Message3.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        PHaut.add(Message3);

        PInfos.add(PHaut, java.awt.BorderLayout.NORTH);

        PBas.setLayout(new java.awt.GridLayout(1, 2));

        BDemarrer.setText("Démarrer");
        BDemarrer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BDemarrerMouseClicked(evt);
            }
        });
        BDemarrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BDemarrerActionPerformed(evt);
            }
        });
        PBas.add(BDemarrer);

        BRecommencer.setText("Recommencer");
        BRecommencer.setEnabled(false);
        BRecommencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRecommencerActionPerformed(evt);
            }
        });
        PBas.add(BRecommencer);

        PInfos.add(PBas, java.awt.BorderLayout.SOUTH);

        Edition.setEditable(false);
        Edition.setColumns(20);
        Edition.setLineWrap(true);
        Edition.setRows(5);
        jScrollPane1.setViewportView(Edition);

        PInfos.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(PInfos, java.awt.BorderLayout.WEST);

        Panneau.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(Panneau, java.awt.BorderLayout.CENTER);

        MParametres.setText("Paramètres");

        Options.setText("Options");
        Options.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionsActionPerformed(evt);
            }
        });
        MParametres.add(Options);

        AjoutJoueur.setText("AjoutJoueur");
        AjoutJoueur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjoutJoueurActionPerformed(evt);
            }
        });
        MParametres.add(AjoutJoueur);

        jMenuBar1.add(MParametres);

        MVisualiser.setText("Visualisation");

        MJoueur.setText("Joueurs");
        MJoueur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MJoueurActionPerformed(evt);
            }
        });
        MVisualiser.add(MJoueur);

        MCarte.setText("Carte");
        MCarte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MCarteActionPerformed(evt);
            }
        });
        MVisualiser.add(MCarte);

        jMenuBar1.add(MVisualiser);

        Test.setText("Test");

        Transfert_Test.setText("Transfert_Test");
        Transfert_Test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Transfert_TestActionPerformed(evt);
            }
        });
        Test.add(Transfert_Test);

        Bataille_Test.setText("Bataille_Test");
        Bataille_Test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bataille_TestActionPerformed(evt);
            }
        });
        Test.add(Bataille_Test);

        jMenuBar1.add(Test);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionsActionPerformed
        // TODO add your handling code here:
    // Creation d'une instance de InitDlg
        InitDlg diag = new InitDlg(this,true);
        diag.setVisible(true); // permet l'ouverture de cette derniere
        if(diag.getOk()==true) 
        {
            //boite fermée par valider
            //on recupere les jouers choisi 
            LesJoueurs lj=diag.getJoueurs(); 
            // Recuperer les joueurs selectionnes
            for(int i=0; i<lj.getNbJoueurs();i++)
            {
              this.joueurs.ajouteJoueur(lj.getJoueur(i));
            }
            // on recupere le niveau 
            int niveau = diag.getNiveau(); // Recuperer le niveau choisi
            
            this.persos= new LesPersonnages(niveau);
            this.monJeu = new Jeu(this.persos , this.joueurs , this.persos.getTaille());
            

            
        }
    }//GEN-LAST:event_OptionsActionPerformed

    private void MJoueurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MJoueurActionPerformed
        // TODO add your handling code here:
         // Creation d'une instance de VisuJoueursDlg avec en parametre l'attributs de type
        // LesJouurs qui regroupe l'ensemble des joueurs du jeu
        VisuJoueursDlg diag = new VisuJoueursDlg(this,true,this.joueurs);
        diag.setVisible(true); // permet l'ouverture de cette derniere
    }//GEN-LAST:event_MJoueurActionPerformed

    private void AjoutJoueurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjoutJoueurActionPerformed
        // TODO add your handling code here:
        // Creation d'unee instance de SaisieJoueurDlg avec en parametre 
        SaisieJoueurDlg diag = new SaisieJoueurDlg(this,true,this.persos);
        diag.setVisible(true);
        if(diag.isVrai()==true)
        {
           this.joueurs.ajouteJoueur(diag.getJoueur()); 
           Edition.append("Le joueur "+diag.getJoueur().getPseudo()+" a ete ajoute au jeu");
        }
        
         
    }//GEN-LAST:event_AjoutJoueurActionPerformed

    private void MCarteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MCarteActionPerformed
        // TODO add your handling code here:

        VisuPersonnagesDlg diag = new VisuPersonnagesDlg(this,true,this.monJeu.getJoueurCourant());
        diag.setVisible(true);
    }//GEN-LAST:event_MCarteActionPerformed

    private void Transfert_TestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Transfert_TestActionPerformed
        // TODO add your handling code here:
        Joueur j1=new Joueur("FanMemory0", "commun");
        j1.initPaquetTest();
        Joueur j2=new Joueur("FanMemory1", "commun");
        j2.getPaquet().ajoutePerso(new Personnage("epiques", "burnout", 20));
        j2.getPaquet().ajoutePerso(new Personnage("epiques", "funk-ops", 30));
        j2.getPaquet().ajoutePerso(new Personnage("alpins-femmes", "mogul-master", 10));
        this.joueurs.ajouteJoueur(j1);
        this.joueurs.ajouteJoueur(j2);
        TransfertDlg diag = new TransfertDlg(this,true,joueurs,0 );
        diag.setVisible(true);
        
    }//GEN-LAST:event_Transfert_TestActionPerformed

    private void BDemarrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BDemarrerActionPerformed
        // TODO add your handling code here:
        if(joueurs.getNbJoueurs()<2)
            Edition.append("\nErreur! Vous devez choisir au moins 2 joueurs");
        else
        {
            Panneau.setVisible(true);
            Edition.append("\n"+this.joueurs.toString());
            BDemarrer.setEnabled(false);
            BRecommencer.setEnabled(true);
            Options.setEnabled(false);
            AjoutJoueur.setEnabled(false);
            MJoueur.setEnabled(true);
            MCarte.setEnabled(true);
            Message1.setText("Nombre de personnages trouvés :"+0);
            Message2.setText("Nombre de personnages restant :"+this.persos.getTaille());
            Message3.setText("C'est à "+this.monJeu.getJoueurCourant().getPseudo()+" de jouer");
            // Creation des grille du plateau de jeu pour les cartes 
            int ligne = this.monJeu.getPlateau().getNblig();  // nombre deligne
            int colonne = this.monJeu.getPlateau().getNbcol();   // nombre de colonne
            Panneau.setLayout(new GridLayout(ligne,colonne));
            // Boucle pour la creation des boutons de la grille
            for (int i=0 ; i<this.persos.getTaille()*2 ; i++)
            {
                BoutonImage bt = new BoutonImage();
                bt.setName(""+i);
             
                bt.addActionListener(new ActionListener(){
                  public void actionPerformed(ActionEvent evt){
                    boutonActionPerformed(evt);
                }
                });
                Panneau.add(bt);
            }
            this.pack();
            
            
            
            
        } 
    }//GEN-LAST:event_BDemarrerActionPerformed

    private void BDemarrerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BDemarrerMouseClicked
        // TODO add your handling code here:
         
           
    }//GEN-LAST:event_BDemarrerMouseClicked

    private void BRecommencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRecommencerActionPerformed
        // TODO add your handling code here:
        
        this.Panneau.removeAll();
        Panneau.repaint();
        Panneau.setVisible(false);
        this.persos=new LesPersonnages();
        this.joueurs = new LesJoueurs();
        this.monJeu = null;
        this.AjoutJoueur.setEnabled(true);
        this.BDemarrer.setEnabled(true);
        this.Options.setEnabled(true);
        Message1.setText("");
        Message2.setText("");
        Message3.setText("");
        Edition.setText("");
        
    }//GEN-LAST:event_BRecommencerActionPerformed

    private void Bataille_TestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bataille_TestActionPerformed
        // TODO add your handling code here:
        // ajout de cartes aux 2 premiers joueurs
        this.joueurs.getJoueur(0).initPaquetTest();
        this.joueurs.getJoueur(1).getPaquet().ajoutePerso(new Personnage("epiques", "burnout", 20));
        this.joueurs.getJoueur(1).getPaquet().ajoutePerso(new Personnage("epiques", "funk-ops", 30));
        // ouverture de la boîte de dialogue, avec le 1er joueur en joueur courant.
        BatailleDlg diag = new BatailleDlg(this, true, this.joueurs, 0);
        diag.setSize(1000,600);
        diag.setVisible(true);
    }//GEN-LAST:event_Bataille_TestActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JeuMemory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JeuMemory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JeuMemory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JeuMemory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               JeuMemory Boite = new JeuMemory();
               Boite.setVisible(true);
               Boite.setSize(700, 400);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AjoutJoueur;
    private javax.swing.JButton BDemarrer;
    private javax.swing.JButton BRecommencer;
    private javax.swing.JMenuItem Bataille_Test;
    private javax.swing.JTextArea Edition;
    private javax.swing.JMenuItem MCarte;
    private javax.swing.JMenuItem MJoueur;
    private javax.swing.JMenu MParametres;
    private javax.swing.JMenu MVisualiser;
    private javax.swing.JLabel Message1;
    private javax.swing.JLabel Message2;
    private javax.swing.JLabel Message3;
    private javax.swing.JMenuItem Options;
    private javax.swing.JPanel PBas;
    private javax.swing.JPanel PHaut;
    private javax.swing.JPanel PInfos;
    private javax.swing.JPanel Panneau;
    private javax.swing.JMenu Test;
    private javax.swing.JMenuItem Transfert_Test;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
