import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.color.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class adminhome extends javax.swing.JFrame {

  
    public adminhome() {
        initComponents();
        setSize(914,514);
        setLocationRelativeTo(null);
        setResizable(false);
        String n="Welcome "+GlobalData.nameofadmin+" !!!";
        jLabel1.setText(n);
       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        addc = new javax.swing.JButton();
        view = new javax.swing.JButton();
        room = new javax.swing.JButton();
        viewr = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Candara", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 40, 640, 70);

        addc.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        addc.setText("Add Category");
        addc.setOpaque(false);
        addc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addcActionPerformed(evt);
            }
        });
        getContentPane().add(addc);
        addc.setBounds(70, 170, 200, 40);

        view.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        view.setText("View Categories");
        view.setOpaque(false);
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        getContentPane().add(view);
        view.setBounds(70, 310, 200, 40);

        room.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        room.setText("Add Room");
        room.setOpaque(false);
        room.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomActionPerformed(evt);
            }
        });
        getContentPane().add(room);
        room.setBounds(70, 240, 200, 40);

        viewr.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        viewr.setText("View Rooms");
        viewr.setOpaque(false);
        viewr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewrActionPerformed(evt);
            }
        });
        getContentPane().add(viewr);
        viewr.setBounds(70, 380, 200, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgroundicons/apex-legends-octane-uhdpaper.com-4K-69.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 914, 514);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addcActionPerformed
        new addcategory().setVisible(true);
    }//GEN-LAST:event_addcActionPerformed

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
            new viewcategories().setVisible(true);
          
            
    }//GEN-LAST:event_viewActionPerformed

    private void roomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomActionPerformed
        new addroom().setVisible(true);
    }//GEN-LAST:event_roomActionPerformed

    private void viewrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewrActionPerformed
            new viewrooms().setVisible(true);
    }//GEN-LAST:event_viewrActionPerformed

    
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new adminhome().setVisible(true);
                }
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(adminhome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(adminhome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(adminhome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(adminhome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton room;
    private javax.swing.JButton view;
    private javax.swing.JButton viewr;
    // End of variables declaration//GEN-END:variables
}
