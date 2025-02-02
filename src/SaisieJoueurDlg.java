
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.io.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author roland
 */
public class SaisieJoueurDlg extends javax.swing.JDialog {

    /**
     * Creates new form SaisieJoueurDlg
     */
    // Attributs
    private Joueur joueur;
    private boolean vrai;
    private ImageIcon photo;
    private LesPersonnages lp;

    private SaisieJoueurDlg(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Joueur getJoueur() {
        return this.joueur;
    }

    public boolean isVrai() {
        return this.vrai;
    }
    
    
    
    public SaisieJoueurDlg(java.awt.Frame parent, boolean modal,LesPersonnages p) {
        super(parent, modal);
        initComponents();
        this.lp = p;
        initListeFamilles();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // methode pour le rmplissage de la JList
    public void initListeFamilles()
    {
        //Recuperation de toutes les familles des personnages du jeu 
        ArrayList<String> famille = this.lp.getFamilles();
        DefaultListModel mod = new DefaultListModel();
        ListeFamilles.setModel(mod);
        for(int i=0; i<famille.size();i++)
        {  // Ajout de famille dans la JList
           mod.addElement(famille.get(i));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PTitre = new javax.swing.JPanel();
        LTitre = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        PGauche = new javax.swing.JPanel();
        PGaucheHaut = new javax.swing.JPanel();
        LTitre2 = new javax.swing.JLabel();
        FPseudo = new javax.swing.JTextField();
        PGaucheCentre = new javax.swing.JPanel();
        LTitre3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListeFamilles = new javax.swing.JList<>();
        PGaucheBas = new javax.swing.JPanel();
        LTitre4 = new javax.swing.JLabel();
        Parcourir = new javax.swing.JButton();
        PDroite = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Photo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Annuler = new javax.swing.JButton();
        Valider = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        LTitre.setText("Creez votre joueur !");

        javax.swing.GroupLayout PTitreLayout = new javax.swing.GroupLayout(PTitre);
        PTitre.setLayout(PTitreLayout);
        PTitreLayout.setHorizontalGroup(
            PTitreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
            .addGroup(PTitreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PTitreLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(LTitre)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        PTitreLayout.setVerticalGroup(
            PTitreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
            .addGroup(PTitreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PTitreLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(LTitre)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(PTitre, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        PGauche.setLayout(new java.awt.GridLayout(3, 1));

        PGaucheHaut.setLayout(new java.awt.BorderLayout());

        LTitre2.setText("Donnez votre pseudo :");
        PGaucheHaut.add(LTitre2, java.awt.BorderLayout.NORTH);
        PGaucheHaut.add(FPseudo, java.awt.BorderLayout.CENTER);

        PGauche.add(PGaucheHaut);

        PGaucheCentre.setLayout(new java.awt.BorderLayout());

        LTitre3.setText("Quelle est votre famille preferee de personnage ?");
        PGaucheCentre.add(LTitre3, java.awt.BorderLayout.NORTH);

        ListeFamilles.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(ListeFamilles);

        PGaucheCentre.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        PGauche.add(PGaucheCentre);

        PGaucheBas.setLayout(new java.awt.BorderLayout());

        LTitre4.setText("Choisissez une photo :");
        PGaucheBas.add(LTitre4, java.awt.BorderLayout.NORTH);

        Parcourir.setText("Parcourir");
        Parcourir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParcourirActionPerformed(evt);
            }
        });
        PGaucheBas.add(Parcourir, java.awt.BorderLayout.CENTER);

        PGauche.add(PGaucheBas);

        jPanel1.add(PGauche);

        PDroite.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(1, 1));
        jPanel2.add(Photo);

        PDroite.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(1, 2));

        Annuler.setText("Annuler");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });
        jPanel3.add(Annuler);

        Valider.setText("Valider");
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });
        jPanel3.add(Valider);

        PDroite.add(jPanel3, java.awt.BorderLayout.SOUTH);

        jPanel1.add(PDroite);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ParcourirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParcourirActionPerformed
        // TODO add your handling code here:
        
        JFileChooser jf= new JFileChooser();
        if (jf.showOpenDialog(this)== JFileChooser.APPROVE_OPTION)
        { 
            String path = jf.getSelectedFile().getPath();
            Image img=Toolkit.getDefaultToolkit().getImage(path);
            img=img.getScaledInstance(Photo.getWidth()-10, Photo.getHeight()-10, Image.SCALE_DEFAULT);
            photo = new ImageIcon(img);
            Photo.setIcon(photo);
        }
    }//GEN-LAST:event_ParcourirActionPerformed

    private void ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValiderActionPerformed
        // TODO add your handling code here:
        //Recuperation et verification si le pseudo saisi est different de ""
        String p = FPseudo.getText();       
        if(!p.equals(""))
        {
            // verification si la famille choisi dans la liste n'est pas ""
            if(!(ListeFamilles.getSelectedValue().equals("")))
            {   //on recupere la famille et on cree le joueur 
                String fp= ListeFamilles.getSelectedValue();
                this.joueur= new Joueur(p,fp);
                
                this.vrai = true;
                // on verifie si la photo n est pas nulle et on l'affecte a la photo du joueur       
                if(null!=Photo.getIcon())
                {
                    this.joueur.setPhoto(this.photo);
                }
                this.dispose(); // on libere de l'espace en fermant la boite de dialogue 
                 
            }
        }
        else
        {
            FPseudo.setText("Veuillez donner un pseudo");
        }
        
        
    }//GEN-LAST:event_ValiderActionPerformed
    // Gestionnaire du clic sur le bouton Annuler 
    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
        // TODO add your handling code here:
        this.vrai = false;
        this.setVisible(vrai); // Fermeture de la boite de dialogue 
        
    }//GEN-LAST:event_AnnulerActionPerformed

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
            java.util.logging.Logger.getLogger(SaisieJoueurDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaisieJoueurDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaisieJoueurDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaisieJoueurDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SaisieJoueurDlg dialog = new SaisieJoueurDlg(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton Annuler;
    private javax.swing.JTextField FPseudo;
    private javax.swing.JLabel LTitre;
    private javax.swing.JLabel LTitre2;
    private javax.swing.JLabel LTitre3;
    private javax.swing.JLabel LTitre4;
    private javax.swing.JList<String> ListeFamilles;
    private javax.swing.JPanel PDroite;
    private javax.swing.JPanel PGauche;
    private javax.swing.JPanel PGaucheBas;
    private javax.swing.JPanel PGaucheCentre;
    private javax.swing.JPanel PGaucheHaut;
    private javax.swing.JPanel PTitre;
    private javax.swing.JButton Parcourir;
    private javax.swing.JButton Photo;
    private javax.swing.JButton Valider;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
