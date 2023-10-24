
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.*;
import javax.swing.*;

public class viewcategories extends javax.swing.JFrame {

    ArrayList<category> al = new ArrayList<>();
    mytablemodel tm;

    public viewcategories() {
        initComponents();
        setSize(800,600);
        setLocationRelativeTo(null);
        setResizable(false);
        tm = new mytablemodel();
        table.setModel(tm);
        table.setOpaque(false);
        ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        table.setShowGrid(false);
        getallcategories();
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

        table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(110, 40, 570, 402);

        bt.setText("Delete Category");
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });
        getContentPane().add(bt);
        bt.setBounds(310, 480, 160, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgroundicons/Webp.net-resizeimage(22).jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
        if(table.getSelectedRow()== -1)
        {
            JOptionPane.showMessageDialog(this,"Please select a row to delete");
        }
        else
        {
            try
            {
            
            int ans=JOptionPane.showConfirmDialog(this,"Are you sure want to delete","Delete Confirmation",JOptionPane.YES_NO_OPTION);
            if(ans== JOptionPane.YES_OPTION)
            {
               String c=al.get(table.getSelectedRow()).catname;
            HttpResponse<String> response=Unirest.get(GlobalData.hostname+"/deletecategory")
                                                 .queryString("Name",c) 
                                                 .asString();
               if(response.getBody().equals("Category Deleted"))
              {
                JOptionPane.showMessageDialog(this,"Category Deleted");
                getallcategories();
              } 
            
            }
            
            
            }
            catch(Exception ex)
            {
                  ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btActionPerformed

    
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new viewcategories().setVisible(true);
                }
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(viewcategories.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(viewcategories.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(viewcategories.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(viewcategories.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    public void getallcategories() {
        al.clear();
        try {
            HttpResponse<String> response = Unirest.get(GlobalData.hostname + "/fetchallcategories").asString();
            String ans = response.getBody();
            System.out.println(ans);
            StringTokenizer st = new StringTokenizer(ans, ";;");
            while (st.hasMoreTokens()) {
                String row = st.nextToken();
                StringTokenizer col = new StringTokenizer(row, "~~");
                String catname = col.nextToken();
                String desc = col.nextToken();
                al.add(new category(catname, desc));
            }
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
            return 2;
        }

        @Override
        public String getColumnName(int j) {
            String col[] = {"Name", "Description"};
            return col[j];
        }

        @Override
        public Object getValueAt(int i, int j) {
            switch (j) {
                case 0:
                    return al.get(i).catname;

                case 1:
                    return al.get(i).desc;

            }

            return null;

        }

    }
}
