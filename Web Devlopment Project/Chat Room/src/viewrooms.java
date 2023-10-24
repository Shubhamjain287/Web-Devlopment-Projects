
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.*;

public class viewrooms extends javax.swing.JFrame {

    ArrayList<room> al = new ArrayList<>();
    mytablemodel tm;

    public viewrooms() {
        initComponents();
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        tm = new viewrooms.mytablemodel();
        table.setModel(tm);
        table.setOpaque(false);
        ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        table.setShowGrid(false);
        getallrooms();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        bt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jScrollPane1.setOpaque(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room id", "Roomname", "Category", "Photo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setFocusable(false);
        table.setGridColor(new java.awt.Color(255, 255, 255));
        table.setOpaque(false);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 20, 680, 460);

        bt.setText("Delete Row");
        bt.setOpaque(false);
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });
        getContentPane().add(bt);
        bt.setBounds(330, 500, 160, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgroundicons/Webp.net-resizeimage(22).jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
        if (table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Please select a room to delete");
        } else {
            try {

                int ans = JOptionPane.showConfirmDialog(this, "Are you sure want to delete", "Delete Confirmation", JOptionPane.YES_NO_OPTION);
                if (ans == JOptionPane.YES_OPTION) {
                    String c = al.get(table.getSelectedRow()).roomid;

                    HttpResponse<String> response = Unirest.get(GlobalData.hostname + "/deleteroom")
                            .queryString("Roomid", c)
                            .asString();

//              {
                    JOptionPane.showMessageDialog(this, response.getBody());
                    getallrooms();
//              } 

                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


    }//GEN-LAST:event_btActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new viewrooms().setVisible(true);
                }
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(viewrooms.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(viewrooms.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(viewrooms.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(viewrooms.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    private void getallrooms() {
        al.clear();
        try {
            HttpResponse<String> response = Unirest.get(GlobalData.hostname + "/fetchallrooms").asString();
            String ans = response.getBody();
            System.out.println(ans);
            StringTokenizer st = new StringTokenizer(ans, "~~");
            while (st.hasMoreTokens()) {
                String row = st.nextToken();
                StringTokenizer col = new StringTokenizer(row, ";;");
                String roomid = col.nextToken();
                String name = col.nextToken();
                String category = col.nextToken();
                String photo = col.nextToken();
                al.add(new room(roomid, name, category, photo));
               

            }
             table.getColumnModel().getColumn(3).setCellRenderer(new ImageRenderer());
                table.setRowHeight(100);
            tm.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    class mytablemodel extends AbstractTableModel {
        @Override
        public int getRowCount() {
                 
  return al.size();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public String getColumnName(int j) {
            String col[] = {"Roomid", "Roomname", "Category", "Photo"};
            return col[j];
        }

        @Override
        public Object getValueAt(int i, int j) {
            switch (j) {
                case 0:
                    return al.get(i).roomid;

                case 1:
                    return al.get(i).name;

                case 2:
                    return al.get(i).category;

                case 3:
                    return al.get(i).photo;

            }
            return null;
        }

    }

    class ImageRenderer extends DefaultTableCellRenderer {

        JLabel lbl = new JLabel();

        ImageIcon icon = new ImageIcon("");
        BufferedImage bufferedImage, newimage;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            try {
                URL url = new URL(GlobalData.hostname + "/GetResource/" + al.get(row).photo);
                System.out.println("url : " + url);
                bufferedImage = ImageIO.read(url);
                newimage = resizephoto(bufferedImage, 165, 160);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            icon = new ImageIcon(newimage);
            lbl.setIcon(icon);
            lbl.setBounds(0, 0, 100, 100);
            return lbl;
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
}
