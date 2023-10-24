
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;



public class addcategory extends javax.swing.JFrame {

        
    public addcategory() {
        initComponents();
        setSize(800,540);
         setLocationRelativeTo(null);
         setResizable(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descri = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bt1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Candara", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Add Catergory");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(240, 40, 300, 50);

        name.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        name.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        getContentPane().add(name);
        name.setBounds(240, 150, 300, 40);

        descri.setColumns(20);
        descri.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        descri.setRows(5);
        jScrollPane1.setViewportView(descri);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(240, 220, 300, 180);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Description");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 280, 90, 20);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Add Catergory");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(120, 160, 90, 20);

        bt1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        bt1.setText("Create");
        bt1.setOpaque(false);
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(330, 450, 140, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgroundicons/Webp.net-resizeimage(16).jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 800, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        
        String n,d;
        n=name.getText();
        d=descri.getText();
        if(name.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Category Name Is Mandatory");
        }
        else{
        try
        {
            HttpResponse<String> response = Unirest.get(GlobalData.hostname+"/addcategory")
                    .queryString("name",n)
                    .queryString("description",d)
                    .asString();
                                                       
            if(response.getBody().equals("Category Created"))
            {
                JOptionPane.showMessageDialog(this,"Category Created");
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Category Already Exists");
            }
        
                     
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    
        }
        
        
        
    }//GEN-LAST:event_bt1ActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    
    
    
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new addcategory().setVisible(true);
                }
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addcategory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(addcategory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(addcategory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(addcategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JTextArea descri;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    // End of variables declaration//GEN-END:variables
}
