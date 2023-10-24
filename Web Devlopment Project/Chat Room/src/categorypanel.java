
public class categorypanel extends javax.swing.JPanel {

    
    public categorypanel() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        catname = new javax.swing.JLabel();
        desc = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(153, 255, 204));
        setLayout(null);

        catname.setFont(new java.awt.Font("Candara", 1, 48)); // NOI18N
        add(catname);
        catname.setBounds(10, 10, 630, 60);

        desc.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        add(desc);
        desc.setBounds(20, 80, 620, 40);

        mainpanel.setBackground(new java.awt.Color(204, 255, 204));
        mainpanel.setLayout(null);
        jScrollPane1.setViewportView(mainpanel);

        add(jScrollPane1);
        jScrollPane1.setBounds(20, 120, 620, 70);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel catname;
    public javax.swing.JLabel desc;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JPanel mainpanel;
    // End of variables declaration//GEN-END:variables
}
