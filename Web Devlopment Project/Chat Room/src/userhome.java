
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class userhome extends javax.swing.JFrame {

    int w, h;
    ArrayList<category> al = new ArrayList<>();

    public userhome() {
        initComponents();
        Dimension d=getToolkit().getScreenSize();
        w=d.width;
        h=d.height;
        setSize(w,h);
        setLocationRelativeTo(null);
        setResizable(false);
        getnameandphoto();
        getmypanels();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        welcome = new javax.swing.JLabel();
        cp = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();
        mr = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 10, 160, 160);

        welcome.setFont(new java.awt.Font("Candara", 1, 36)); // NOI18N
        getContentPane().add(welcome);
        welcome.setBounds(190, 10, 810, 70);

        cp.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        cp.setText("Change Password");
        cp.setOpaque(false);
        cp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpActionPerformed(evt);
            }
        });
        getContentPane().add(cp);
        cp.setBounds(1080, 20, 190, 40);

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setHorizontalScrollBar(null);

        mainpanel.setBackground(new java.awt.Color(0, 51, 102));
        mainpanel.setLayout(null);
        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 190, 1270, 460);

        mr.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        mr.setText("My Rooms");
        mr.setOpaque(false);
        mr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mrActionPerformed(evt);
            }
        });
        getContentPane().add(mr);
        mr.setBounds(1080, 80, 190, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgroundicons/tetrahedron-particle-field-background-animation-white-1-img.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-10, 0, 1410, 716);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpActionPerformed
        new userchangepass().setVisible(true);

    }//GEN-LAST:event_cpActionPerformed

    private void mrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mrActionPerformed
        new usermyroom().setVisible(true);
    }//GEN-LAST:event_mrActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new userhome().setVisible(true);
                }
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userhome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(userhome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(userhome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(userhome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JPanel mainpanel;
    private javax.swing.JButton mr;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables

    private void getnameandphoto() {
        try {
            ImageIcon icon = new ImageIcon("");
            BufferedImage bufferedImage, newimage;

            HttpResponse<String> response = Unirest.get(GlobalData.hostname + "/getnameandphoto")
                    .queryString("username", GlobalData.nameofuser)
                    .asString();
            String ans = response.getBody();
            System.out.println(ans);
            StringTokenizer st = new StringTokenizer(ans, "~~");
            while (st.hasMoreTokens()) {
                String display = st.nextToken();
                String photo = st.nextToken();
                welcome.setText("WELCOME " + display.toUpperCase());
                try {
                    URL url = new URL(GlobalData.hostname + "/GetResource/" + photo);
                    System.out.println("url : " + url);
                    bufferedImage = ImageIO.read(url);
                    newimage = resizephoto(bufferedImage, jLabel1.getWidth(), jLabel1.getHeight());
                    icon = new ImageIcon(newimage);
                    jLabel1.setIcon(icon);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    BufferedImage resizephoto(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }
    String catname, desc;

    private void getmypanels() {
        int x = 10, y = 10;
        al.clear();
        try {
            HttpResponse<String> response = Unirest.get(GlobalData.hostname + "/fetchallcategories").asString();
            String ans = response.getBody();
            System.out.println(ans);
            StringTokenizer st = new StringTokenizer(ans, ";;");
            while (st.hasMoreTokens()) {
                String row = st.nextToken();
                System.out.println(row);
                StringTokenizer col = new StringTokenizer(row, "~~");
                String catname = col.nextToken();
                String desc = col.nextToken();
                al.add(new category(catname, desc));
            }
           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < al.size(); i++) {
            categorypanel cp[] = new categorypanel[al.size()];
            cp[i] = new categorypanel();
            cp[i].jScrollPane1.setSize((w - 200), 300);//400
            cp[i].setBounds(x, y, w - 50, 430); //edit420
//            cp[i].mainpanel.setPreferredSize(new Dimension(w - 50, 300));
            cp[i].catname.setText(al.get(i).catname.toUpperCase());
            cp[i].desc.setText(al.get(i).desc);
            y = y + 450;//420

            try {
                System.out.println(al.get(i).catname);
                HttpResponse<String> httpResponse = Unirest.get(GlobalData.hostname + "/GetRooms")
                        .queryString("category",al.get(i).catname)
                        .asString();
                String ans = httpResponse.getBody().trim();
                System.out.println(ans);
                int j = 0, m = 10, n = 10;
                StringTokenizer st = new StringTokenizer(ans, ";;");
                int count = st.countTokens();
                roompanel rp[] = new roompanel[count];

                while (st.hasMoreTokens()) {
                    String row = st.nextToken();
                    System.out.println(row);
                    StringTokenizer stcol = new StringTokenizer(row, "~~");
                    int roomid = Integer.parseInt(stcol.nextToken());
                    String roomname = stcol.nextToken();
                    String category = stcol.nextToken();
                    String photo = stcol.nextToken();
                    rp[j] = new roompanel();
                    rp[j].roomname.setText(roomname);
                    BufferedImage bufferedImage, newimage = null;
                    ImageIcon icon = new ImageIcon("");
                    try {
                        URL url = new URL(GlobalData.hostname + "/GetResource/" + photo);
                        System.out.println("url : " + url);
                        bufferedImage = ImageIO.read(url);
                        newimage = resizephoto(bufferedImage, rp[j].photo.getWidth(), rp[j].photo.getHeight());
                        rp[j].setBounds(m, n, 270, 270);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    icon = new ImageIcon(newimage);
                    rp[j].photo.setIcon(icon);
                    rp[j].addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent me)
                        {
                            if (me.getClickCount() == 2) {
                               joinroom jr = new joinroom(roomid);
                                jr.setVisible(true);
                            }
                        }

                    });
//                    cp[i].jScrollPane1.setSize((j*250), 300);
                    cp[i].mainpanel.setPreferredSize(new Dimension((j * 300), 200));
                    cp[i].mainpanel.add(rp[j]);
                    mainpanel.add(cp[i]);
                    repaint();
                    mainpanel.repaint();
                    cp[i].repaint();
                    cp[i].mainpanel.repaint();
                    System.out.println(x);
                    System.out.println(y);

//                    y = y + 200;
                    x = 10;
                    m = m + 290;
                    j++;
                    mainpanel.setPreferredSize(new Dimension(w, y));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
