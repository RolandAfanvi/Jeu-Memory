/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author ka907986
 */
public class InitDlg extends javax.swing.JDialog {

    // Attributs
    private LesJoueurs lj; // les joueurs slectionnes 
    private boolean ok;   // indicateur de la fermeture 
    private int nc; //niveau du jeu(4,10,18,32)

    // Accesseur 
    public LesJoueurs getJoueurs() {
        return this.lj;
    }


    public boolean getOk() {
        return this.ok;
    }


    public int getNiveau() {
        return this.nc;
    }

   

    
    
    /**
     * Creates new form OptionsDlg
     */
    public InitDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.lj= new LesJoueurs();
        groupBouton();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // methode pour grouper les boutons radio
    private void groupBouton()
    {
        ButtonGroup group = new ButtonGroup();
        group.add(BEnfant);
        group.add(BDebutant);
        group.add(BAvance);
        group.add(BExpert);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PBas = new javax.swing.JPanel();
        BAnnuler = new javax.swing.JButton();
        BValider = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        PJeu = new javax.swing.JPanel();
        PTitreJeu = new javax.swing.JPanel();
        LTitreJeu = new javax.swing.JLabel();
        POptionJeu = new javax.swing.JPanel();
        BEnfant = new javax.swing.JRadioButton();
        BDebutant = new javax.swing.JRadioButton();
        BAvance = new javax.swing.JRadioButton();
        BExpert = new javax.swing.JRadioButton();
        PJoueurs = new javax.swing.JPanel();
        PTitreJoueur = new javax.swing.JPanel();
        lTitreJeu = new javax.swing.JLabel();
        POptionJoueur = new javax.swing.JPanel();
        CaseLara = new javax.swing.JCheckBox();
        CaseJack = new javax.swing.JCheckBox();
        CaseSeb = new javax.swing.JCheckBox();
        CaseAmadeus = new javax.swing.JCheckBox();
        PJoueur = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Edition = new javax.swing.JTextArea();
        BPhoto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        PBas.setLayout(new java.awt.GridLayout(1, 2));

        BAnnuler.setText("Annuler");
        BAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAnnulerActionPerformed(evt);
            }
        });
        PBas.add(BAnnuler);

        BValider.setText("Valider");
        BValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BValiderActionPerformed(evt);
            }
        });
        PBas.add(BValider);

        getContentPane().add(PBas, java.awt.BorderLayout.SOUTH);

        jPanel2.setLayout(new java.awt.GridLayout(1, 3));

        PJeu.setLayout(new java.awt.BorderLayout());

        LTitreJeu.setText("Choisissez la taille");

        javax.swing.GroupLayout PTitreJeuLayout = new javax.swing.GroupLayout(PTitreJeu);
        PTitreJeu.setLayout(PTitreJeuLayout);
        PTitreJeuLayout.setHorizontalGroup(
            PTitreJeuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(PTitreJeuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PTitreJeuLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(LTitreJeu)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        PTitreJeuLayout.setVerticalGroup(
            PTitreJeuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(PTitreJeuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PTitreJeuLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(LTitreJeu)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        PJeu.add(PTitreJeu, java.awt.BorderLayout.NORTH);

        POptionJeu.setLayout(new java.awt.GridLayout(4, 1));

        BEnfant.setText("enfant (4 personnages, 2  familles)");
        POptionJeu.add(BEnfant);

        BDebutant.setText("débutant (10 personnages , 2 familles)");
        POptionJeu.add(BDebutant);

        BAvance.setText("avancé (18 personnages , 4 familles)");
        POptionJeu.add(BAvance);

        BExpert.setText("expert (32 personnages ,  6 familles)");
        POptionJeu.add(BExpert);

        PJeu.add(POptionJeu, java.awt.BorderLayout.CENTER);

        jPanel2.add(PJeu);

        PJoueurs.setLayout(new java.awt.BorderLayout());

        lTitreJeu.setText("Choisissez les joueurs");

        javax.swing.GroupLayout PTitreJoueurLayout = new javax.swing.GroupLayout(PTitreJoueur);
        PTitreJoueur.setLayout(PTitreJoueurLayout);
        PTitreJoueurLayout.setHorizontalGroup(
            PTitreJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(PTitreJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PTitreJoueurLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lTitreJeu)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        PTitreJoueurLayout.setVerticalGroup(
            PTitreJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(PTitreJoueurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PTitreJoueurLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lTitreJeu)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        PJoueurs.add(PTitreJoueur, java.awt.BorderLayout.NORTH);

        POptionJoueur.setLayout(new java.awt.GridLayout(4, 1));

        CaseLara.setText("Lara");
        CaseLara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaseLaraActionPerformed(evt);
            }
        });
        POptionJoueur.add(CaseLara);

        CaseJack.setText("Jack");
        CaseJack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaseJackActionPerformed(evt);
            }
        });
        POptionJoueur.add(CaseJack);

        CaseSeb.setText("Jean-Sébastien");
        CaseSeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaseSebActionPerformed(evt);
            }
        });
        POptionJoueur.add(CaseSeb);

        CaseAmadeus.setText("Amadeus");
        CaseAmadeus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaseAmadeusActionPerformed(evt);
            }
        });
        POptionJoueur.add(CaseAmadeus);

        PJoueurs.add(POptionJoueur, java.awt.BorderLayout.CENTER);

        jPanel2.add(PJoueurs);

        PJoueur.setLayout(new java.awt.GridLayout(2, 1));

        Edition.setEditable(false);
        Edition.setColumns(20);
        Edition.setRows(5);
        jScrollPane1.setViewportView(Edition);

        PJoueur.add(jScrollPane1);

        BPhoto.setText("jButton1");
        PJoueur.add(BPhoto);

        jPanel2.add(PJoueur);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CaseLaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaseLaraActionPerformed
        // TODO add your handling code here:
        if(CaseLara.isSelected())
        {   Joueur j= new Joueur("Lara","epiques");
            j.setPhoto(new ImageIcon(getClass().getResource("/img/lara.jpg")));
            Edition.setText(j.toString());
            Image img = j.getPhoto().getImage().getScaledInstance(BPhoto.getWidth(),BPhoto.getHeight(),Image.SCALE_SMOOTH);
            BPhoto.setIcon(new ImageIcon(img));
        }
        
        
    }//GEN-LAST:event_CaseLaraActionPerformed

    private void CaseAmadeusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaseAmadeusActionPerformed
        // TODO add your handling code here:
        if(CaseAmadeus.isSelected())
        {   Joueur j= new Joueur("Amadeus","communs");
            j.setPhoto(new ImageIcon(getClass().getResource("/img/mozart.jpg")));
            Edition.setText(j.toString());
            Image img = j.getPhoto().getImage().getScaledInstance(BPhoto.getWidth(),BPhoto.getHeight(),Image.SCALE_SMOOTH);
            BPhoto.setIcon(new ImageIcon(img));
        }
    }//GEN-LAST:event_CaseAmadeusActionPerformed

    private void CaseJackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaseJackActionPerformed
        // TODO add your handling code here:
        if(CaseJack.isSelected())
        {   Joueur j= new Joueur("Jack","rares");
            j.setPhoto(new ImageIcon(getClass().getResource("/img/jack.png")));
            Edition.setText(j.toString());
            Image img = j.getPhoto().getImage().getScaledInstance(BPhoto.getWidth(),BPhoto.getHeight(),Image.SCALE_SMOOTH);
            BPhoto.setIcon(new ImageIcon(img));
        }
    }//GEN-LAST:event_CaseJackActionPerformed

    private void CaseSebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaseSebActionPerformed
        // TODO add your handling code here:
        if(CaseSeb.isSelected())
        {   Joueur j= new Joueur("Jean-Sébastien","alpins-femmes");
            j.setPhoto(new ImageIcon(getClass().getResource("/img/bach.jpg")));
            Edition.setText(j.toString());
            Image img = j.getPhoto().getImage().getScaledInstance(BPhoto.getWidth(),BPhoto.getHeight(),Image.SCALE_SMOOTH);
            BPhoto.setIcon(new ImageIcon(img));
        }   
    }//GEN-LAST:event_CaseSebActionPerformed

    private void BValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BValiderActionPerformed
        // TODO add your handling code here:
        this.ok=true;
        
        if(CaseLara.isSelected())
        {
            Joueur j= new Joueur("Lara","epiques");
            j.setPhoto(new ImageIcon(getClass().getResource("/img/lara.jpg")));
            this.lj.ajouteJoueur(j);
        }
        
        if(CaseAmadeus.isSelected())
        {
           Joueur j= new Joueur("Amadeus","communs");
           j.setPhoto(new ImageIcon(getClass().getResource("/img/mozart.jpg"))); 
           this.lj.ajouteJoueur(j);
        }
        
        if(CaseJack.isSelected())
        {
           Joueur j= new Joueur("Jack","rares");
           j.setPhoto(new ImageIcon(getClass().getResource("/img/jack.png")));
           this.lj.ajouteJoueur(j);
        }
        
        if(CaseSeb.isSelected())
        {
           Joueur j= new Joueur("Jean-Sébastien","alpins-femmes");
           j.setPhoto(new ImageIcon(getClass().getResource("/img/bach.jpg"))); 
           this.lj.ajouteJoueur(j);
        }
        
        if(BEnfant.isSelected()){this.nc=4;}
        else
            if(BDebutant.isSelected()){this.nc=10;}
            else
                if(BAvance.isSelected()){this.nc=18;}
                else
                    if(BExpert.isSelected()){this.nc=32;}
        
        
        this.dispose();
        
        
    }//GEN-LAST:event_BValiderActionPerformed

    private void BAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAnnulerActionPerformed
        // TODO add your handling code here:
        this.ok=false;
        this.setVisible(ok);
    }//GEN-LAST:event_BAnnulerActionPerformed

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
            java.util.logging.Logger.getLogger(InitDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InitDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InitDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InitDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InitDlg dialog = new InitDlg(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAnnuler;
    private javax.swing.JRadioButton BAvance;
    private javax.swing.JRadioButton BDebutant;
    private javax.swing.JRadioButton BEnfant;
    private javax.swing.JRadioButton BExpert;
    private javax.swing.JButton BPhoto;
    private javax.swing.JButton BValider;
    private javax.swing.JCheckBox CaseAmadeus;
    private javax.swing.JCheckBox CaseJack;
    private javax.swing.JCheckBox CaseLara;
    private javax.swing.JCheckBox CaseSeb;
    private javax.swing.JTextArea Edition;
    private javax.swing.JLabel LTitreJeu;
    private javax.swing.JPanel PBas;
    private javax.swing.JPanel PJeu;
    private javax.swing.JPanel PJoueur;
    private javax.swing.JPanel PJoueurs;
    private javax.swing.JPanel POptionJeu;
    private javax.swing.JPanel POptionJoueur;
    private javax.swing.JPanel PTitreJeu;
    private javax.swing.JPanel PTitreJoueur;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lTitreJeu;
    // End of variables declaration//GEN-END:variables
}
