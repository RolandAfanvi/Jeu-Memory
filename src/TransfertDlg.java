
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ka907986
 */
public class TransfertDlg extends javax.swing.JDialog {
    
    
    private LesJoueurs lj; //collection des joueurs, pour initialiser la liste déroulante avec les pseudos des joueurs
    private int indj; //indice joueur courant// 
    private Transfert tc; // cette classe sera étudiée ultérieurement –laisser l’attribut en commentaire
    private boolean ok; // indicateur pour savoir le transfert a bien été effectué.
    private int indjs; //indice du joueur sélectionné dans la liste déroulante
    private String fs; //famille du personnage sélectionné en cliquant sur un des personnages du joueur sélectionné

    private TransfertDlg(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public LesJoueurs getJoueurs() {
        return lj;
    }

    public int getIndJoueurCourant() {
        return indj;
    }

    public Transfert getTransfert() {
        return tc;
    }

    public boolean isOk() {
        return this.ok;
    }
    
    public int getIndJoueurSelect() {
        return indjs;
    }

    public String getFamilleSelect() {
        return fs;
    }
    
    
    
    /**
     * Creates new form TransfertDlg
     */
    public TransfertDlg(java.awt.Frame parent, boolean modal, LesJoueurs lj, int indj) {
        super(parent, modal);
        initComponents();
        this.lj = lj;
        this.indj = indj;
        this.tc=null;
        this.ok=false;
        this.fs=null;
        initCombo();// méthode pour remplir la liste déroulante
        indjs = 0;
        Message.setText("Le joueur "+lj.getJoueur(indj).getPseudo()+" a obtenu une famille complète");
        Infos.setText("Personnages de "+lj.getJoueur(indj).getPseudo()+" : \n"+lj.getJoueur(indj).getPaquet());
    }

    // Methodes pour la creation des boutons
    private void creePanneau(JPanel jp, LesPersonnages lc) 
    {
        int t = lc.getTaille();
        int n = 1+(t-1)/4;
        jp.setLayout(new GridLayout(4, n));
        
        jp.removeAll();
        for(int i=0 ; i<t ; i++)
        {
            JButton jb = new JButton();
            jb.setName(""+i);
            jp.add(jb);
            
        }
        this.pack(); 
    }
    // Methode pour mettre les images dans le panneau
    private void dessinePanneau(JPanel jp, LesPersonnages lc)
    {
        for (int i=0 ; i<lc.getTaille() ; i++)
        {
            JButton jb = (JButton)jp.getComponent(i);
            lc.getPerso(i).setImgBouton(jb);
            //jb.setIcon(new ImageIcon(lc.getPerso(i).getPhoto()));
        }
    }
    //Methode pour remplir la liste deroulante
    public void initCombo()
    {
        ComboJoueurs.removeAllItems();
        for(int i=0; i<lj.getNbJoueurs();i++)
        {
            ComboJoueurs.addItem(lj.getJoueur(i).getPseudo());
        }
        
    }
    
    // methode pour l'initialisation du panneau gauche par les images des personnages du joueur
    // selectionnes dans la JComboBox
    
    public void initPanneau()
    {
        PanneauG.removeAll();
        this.repaint();
        //this.indjs = ComboJoueurs.getSelectedIndex();
        LesPersonnages lcs= lj.getJoueur(this.indjs).getPaquet();
        int t = lcs.getTaille();
        int n = 1+(t-1)/4;
        PanneauG.setLayout(new java.awt.GridLayout(4, n));
        for (int i=0; i<t ; i++)
        {
            JButton bt = new JButton();
            bt.setName(lcs.getPerso(i).getFamille());
           
            bt.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                  boutonActionPerformed(evt);
                }
            });
            PanneauG.add(bt);
        }
        this.pack(); 
    }

    
    //Methode affichePanneau 
    public void affichePanneau()
    {
        //this.indjs = ComboJoueurs.getSelectedIndex();
        LesPersonnages lp = lj.getJoueur(this.indjs).getPaquet();
        for (int i=0; i<lp.getTaille();i++)
        {
            JButton bt = (JButton)PanneauG.getComponent(i);
            Image img = lp.getPerso(i).getPhoto().getScaledInstance(bt.getWidth(), bt.getHeight(), Image.SCALE_SMOOTH);
            bt.setIcon(new ImageIcon(img));
        }
    }
    
    // methodes lie au clic sur l'un des images des personnages 
    private void boutonActionPerformed(ActionEvent evt)
    {
        LesPersonnages lp = lj.getJoueur(this.indjs).getPaquet();
        int t = lp.getTaille();
        JButton bt=(JButton) evt.getSource();
        fs = bt.getName(); // la proprité Name, contient ici le nom du personnage affiché sur le bouton
        for(int i = 0; i < t; i++) {
            JButton b = (JButton)(PanneauG.getComponent(i));
            if (b.getName().equals(fs))
                b.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(255, 0, 0)));
            else
                b.setBorder(null);
            }
        LesPersonnages lps = lp.getPersosFamille(fs);
        Infos.setText("Vous pouvez récupérer "+lps.getTaille()+" personnages : \n"+lps);
    }
    
   
    
    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanneauG = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Message = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ComboJoueurs = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Infos = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        Transfert = new javax.swing.JButton();
        Fermer = new javax.swing.JButton();
        PanneauD = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 3));

        javax.swing.GroupLayout PanneauGLayout = new javax.swing.GroupLayout(PanneauG);
        PanneauG.setLayout(PanneauGLayout);
        PanneauGLayout.setHorizontalGroup(
            PanneauGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );
        PanneauGLayout.setVerticalGroup(
            PanneauGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        getContentPane().add(PanneauG);

        jPanel2.setLayout(new java.awt.GridLayout(2, 1));

        jPanel1.setLayout(new java.awt.GridLayout(4, 1));

        Message.setText("jLabel1");
        jPanel1.add(Message);

        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2);

        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3);

        ComboJoueurs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboJoueurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboJoueursActionPerformed(evt);
            }
        });
        jPanel1.add(ComboJoueurs);

        jPanel2.add(jPanel1);

        jPanel3.setLayout(new java.awt.BorderLayout());

        Infos.setColumns(20);
        Infos.setRows(5);
        jScrollPane1.setViewportView(Infos);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        Transfert.setText("Transfert");
        Transfert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransfertActionPerformed(evt);
            }
        });
        jPanel4.add(Transfert);

        Fermer.setText("Fermer");
        Fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FermerActionPerformed(evt);
            }
        });
        jPanel4.add(Fermer);

        jPanel3.add(jPanel4, java.awt.BorderLayout.SOUTH);

        jPanel2.add(jPanel3);

        getContentPane().add(jPanel2);

        javax.swing.GroupLayout PanneauDLayout = new javax.swing.GroupLayout(PanneauD);
        PanneauD.setLayout(PanneauDLayout);
        PanneauDLayout.setHorizontalGroup(
            PanneauDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );
        PanneauDLayout.setVerticalGroup(
            PanneauDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        getContentPane().add(PanneauD);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FermerActionPerformed
        // TODO add your handling code here:
        this.ok=true;
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_FermerActionPerformed

    private void ComboJoueursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboJoueursActionPerformed
        // TODO add your handling code here:
        this.indjs = ComboJoueurs.getSelectedIndex();
        if (indjs != -1)
        {
            if(this.indjs == this.indj) 
            { 
                Infos.setText("Sélectionnez un joueur différent du joueur courant !");
                PanneauG.removeAll();
                PanneauG.repaint();
            }
            else 
            {
                Infos.setText("\nJoueur sélectionné: "+lj.getJoueur(indjs).toString());
                initPanneau();
                affichePanneau();
            }
        }
    }//GEN-LAST:event_ComboJoueursActionPerformed

    private void TransfertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransfertActionPerformed
        // TODO add your handling code here:
        
        // verification si l indice du joueur selectionnes est different dd -1
        if(indjs!=-1 && (fs!=null))
        {
            Transfert tc = new Transfert(lj.getJoueur(indj), lj.getJoueur(indjs) , fs);
            int valeur =tc.execute();
            if(valeur> 0)
            {
                //  Affichage des cartes transféres dans le panneau Droit 
                LesPersonnages lesp = tc.getCartesTransferees();
                creePanneau(PanneauD,lesp);
                dessinePanneau(PanneauD,lesp);
                // Reaffichage des cartes du joueur sur qui a ete fairt le transfret 
                
                //PanneauG.removeAll();
                this.repaint();
                LesPersonnages persos = lj.getJoueur(indjs).getPaquet();
                creePanneau(PanneauG,persos);
                dessinePanneau(PanneauG,persos);
                //
                this.ok = true ;
                Transfert.setEnabled(false);
  
            }
        }    
        else 
                Infos.setText("Il est neccessaire de sélectionner un joueur qui a au moins une carte ");
            
        
    }//GEN-LAST:event_TransfertActionPerformed

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
            java.util.logging.Logger.getLogger(TransfertDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransfertDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransfertDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransfertDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TransfertDlg dialog = new TransfertDlg(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> ComboJoueurs;
    private javax.swing.JButton Fermer;
    private javax.swing.JTextArea Infos;
    private javax.swing.JLabel Message;
    private javax.swing.JPanel PanneauD;
    private javax.swing.JPanel PanneauG;
    private javax.swing.JButton Transfert;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
