
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Usersignup extends javax.swing.JFrame {

   File f;
   int w,h;
    public Usersignup() {
        initComponents();
        setSize(1000,700);
         setLocationRelativeTo(null);
         setResizable(false);
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        confirm = new javax.swing.JPasswordField();
        display = new javax.swing.JTextField();
        gender = new javax.swing.JComboBox<>();
        email = new javax.swing.JTextField();
        mob = new javax.swing.JTextField();
        photo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 48)); // NOI18N
        jLabel1.setText("SignUp");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(590, 20, 150, 50);

        user.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        user.setOpaque(false);
        getContentPane().add(user);
        user.setBounds(580, 100, 150, 30);

        pass.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        pass.setOpaque(false);
        getContentPane().add(pass);
        pass.setBounds(580, 150, 150, 30);

        confirm.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        confirm.setOpaque(false);
        getContentPane().add(confirm);
        confirm.setBounds(580, 200, 150, 30);

        display.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        display.setOpaque(false);
        getContentPane().add(display);
        display.setBounds(580, 250, 150, 30);

        gender.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Others" }));
        gender.setOpaque(false);
        gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderActionPerformed(evt);
            }
        });
        getContentPane().add(gender);
        gender.setBounds(580, 300, 150, 30);

        email.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        email.setOpaque(false);
        getContentPane().add(email);
        email.setBounds(580, 350, 150, 30);

        mob.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        mob.setOpaque(false);
        getContentPane().add(mob);
        mob.setBounds(580, 400, 150, 30);
        getContentPane().add(photo);
        photo.setBounds(580, 460, 150, 120);

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(780, 500, 90, 30);

        jLabel3.setText("Username");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(490, 110, 70, 10);

        jLabel4.setText("Gender");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(500, 310, 70, 10);

        jLabel5.setText("Confirm Password");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(470, 210, 120, 20);

        jLabel6.setText("Photo");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(510, 510, 70, 10);

        jLabel7.setText("Password");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(490, 160, 70, 14);

        jLabel8.setText("Display Name");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(490, 260, 90, 14);

        jLabel9.setText("Email");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(510, 360, 70, 10);

        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(600, 610, 140, 30);

        jLabel10.setText("Mobile No.");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(500, 410, 70, 10);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgroundicons/Webp.net-resizeimage(5).jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 360, 700);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgroundicons/Webp.net-resizeimage(13).jpg"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(360, 0, 640, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser jfc=new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpeg", "jpg", "bmp", "png", "gif");
        jfc.setFileFilter(filter);
        jfc.setAcceptAllFileFilterUsed(false);
        int ans=jfc.showOpenDialog(this);
        if(ans==JFileChooser.APPROVE_OPTION)
        {
            try {
                f=jfc.getSelectedFile();
                BufferedImage img = ImageIO.read(f);
                //Image newimg = img.getScaledInstance(lbpreview.getWidth(), lbpreview.getHeight(), Image.SCALE_SMOOTH);
                BufferedImage newimg = resizephoto(img, photo.getWidth(), photo.getHeight());
                
                photo.setIcon(new ImageIcon(newimg));
            } catch (IOException ex) {
                Logger.getLogger(addroom.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else
        {
            System.out.println("User Cancelled"); 
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       String a,b,c,d,e,g,o;
       
       a=user.getText();
       b=pass.getText();
       o=confirm.getText();
       c=display.getText();
       d=gender.getSelectedItem().toString();
       e=email.getText();
       g=mob.getText();
       
       if(a.equals("")||b.equals("")||c.equals("")||d.equals("")||e.equals("")||g.equals(""))
       {
           JOptionPane.showMessageDialog(this,"All fields are mandatory");
           
       }
       else{
               if(e.indexOf("@")==-1||e.indexOf(".")==-1||e.indexOf("com")==-1)
       {
            JOptionPane.showMessageDialog(this,"Invalid email");
       }
       if(g.length()!=10)
       {
           JOptionPane.showMessageDialog(this,"Invalid Mobile No.");
       }
       if(b.equals(o))
       {
           try
       {
       HttpResponse<String> response= Unirest.post(GlobalData.hostname+"/usersignup")
                                             .queryString("username",a)
                                             .queryString("password",b)
                                             .queryString("displayname",c)
                                             .queryString("gender",d)
                                             .queryString("email",e)
                                             .queryString("mobile",g)
                                             .field("photo", f)
                                             .asString();
         if(response.getBody().equals("User SignUp Successful"))
         {
             JOptionPane.showMessageDialog(this,"Account Created");
             new userlogin().setVisible(true);
         }
         else
         {
             JOptionPane.showMessageDialog(this,"Username already taken");
         }
         
               
    }                                        
    catch(Exception ex)
    {
       ex.printStackTrace();
    }
       }
       else
       {
           JOptionPane.showMessageDialog(this,"Confirm password and password should be same");
       }
     
       }
      
               
    }//GEN-LAST:event_jButton2ActionPerformed

    private void genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderActionPerformed
   
    
    public static void main(String args[]) {
       try {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
           java.awt.EventQueue.invokeLater(new Runnable() {
               public void run() {
                   new Usersignup().setVisible(true);
               }
           });
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(Usersignup.class.getName()).log(Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           Logger.getLogger(Usersignup.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           Logger.getLogger(Usersignup.class.getName()).log(Level.SEVERE, null, ex);
       } catch (UnsupportedLookAndFeelException ex) {
           Logger.getLogger(Usersignup.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirm;
    private javax.swing.JTextField display;
    private javax.swing.JTextField email;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField mob;
    private javax.swing.JPasswordField pass;
    private javax.swing.JLabel photo;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
BufferedImage resizephoto(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }


}

