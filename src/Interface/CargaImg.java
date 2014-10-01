/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Clases.Alm_ImgInsumos;
import Clases.BD;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.jvnet.substance.*;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.SubstanceAbstractSkin;
import org.jvnet.substance.watermark.*;

/**
 *
 * @author Jhonbarranco
 */
public class CargaImg extends javax.swing.JFrame {

    private ImageIcon etiquetaImagen;
    private ArrayList<Alm_ImgInsumos> imagenes;
    private int contador = 0;

    /**
     * Creates new form CargaImg
     */
    public CargaImg() {
        initComponents();
        setLocationRelativeTo(null);

        JFrame.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.SaharaSkin");
        SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceAquaTheme");
        SubstanceLookAndFeel.setCurrentWatermark(new SubstanceLatchWatermark());
        SubstanceLookAndFeel.setImageWatermarkOpacity(new Float(0.6));

        Calendar cal = Calendar.getInstance();
        String fecha = cal.get(Calendar.DATE) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(cal.YEAR);
        String hora = cal.get(cal.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(cal.SECOND);
        this.Fechas.setText(fecha);
        this.Horas.setText(hora);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cargar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MyTable = new javax.swing.JTable();
        Borrar = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ExportarImg = new javax.swing.JButton();
        help = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Horas = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Fechas = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestor Central De Imagenes");
        setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        setIconImage(getIconImage());
        setResizable(false);

        cargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/subir-icono-4963-48.png"))); // NOI18N
        cargar.setToolTipText("Cargar Imagenes");
        cargar.setMaximumSize(new java.awt.Dimension(97, 73));
        cargar.setMinimumSize(new java.awt.Dimension(97, 73));
        cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarActionPerformed(evt);
            }
        });

        MyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE_COM", "Ruta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        MyTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MyTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(MyTable);
        if (MyTable.getColumnModel().getColumnCount() > 0) {
            MyTable.getColumnModel().getColumn(0).setResizable(false);
            MyTable.getColumnModel().getColumn(1).setResizable(false);
            MyTable.getColumnModel().getColumn(2).setResizable(false);
        }

        Borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/recyclebin-vacio-icono-9473-64.png"))); // NOI18N
        Borrar.setToolTipText("Remover");
        Borrar.setEnabled(false);
        Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarActionPerformed(evt);
            }
        });

        Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/guardar.png"))); // NOI18N
        Guardar.setToolTipText("Guardar");
        Guardar.setEnabled(false);
        Guardar.setMaximumSize(new java.awt.Dimension(97, 73));
        Guardar.setMinimumSize(new java.awt.Dimension(97, 73));
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(153, 204, 255));
        jLabel2.setText("CARGAR IMAGENES  ");

        ExportarImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/de-flecha-para-conducir-bajo-descarga-icono-5065-64.png"))); // NOI18N
        ExportarImg.setToolTipText("Exportar Imagenes");
        ExportarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportarImgActionPerformed(evt);
            }
        });

        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/globos-de-ayuda-icono-5985-32.png"))); // NOI18N
        help.setToolTipText("Ayuda");
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("BIENVENIDO AL SISTEMA GESTOR DE IMAGENES :  ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel4.setText("HORA : ");

        Horas.setText("00:00:00");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel9.setText("FECHA :");

        Fechas.setText("00/00/00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(Fechas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Horas)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Horas)
                    .addComponent(jLabel9)
                    .addComponent(Fechas))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(ExportarImg, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(9, 9, 9)
                            .addComponent(Borrar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(help))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(help, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Borrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ExportarImg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarActionPerformed

        //Declaro el Objeto JfileChooser
        JFileChooser jf = new JFileChooser();
        jf.setMultiSelectionEnabled(true);//para poder seleccionar muchos archivos
        jf.setDialogTitle("Selección de imagen"); //titulo 

        jf.setAcceptAllFileFilterUsed(true); // solo se aceptan los archivos con las extenciones definidas 

        jf.setFileFilter(new FileNameExtensionFilter("jpg, png, gif", "jpg", "png", "gif", "bmp"));//Extencion Definida

        int sel = jf.showOpenDialog(null);//si se selecciono un archivo

        if (sel == JFileChooser.APPROVE_OPTION) {
            ImageIcon image = new ImageIcon(jf.getSelectedFile().getPath());
            ImageIcon imageScalada = new ImageIcon(image.getImage().getScaledInstance(90, 100, 100));
            //   String rutaOrigen = jf.getSelectedFile().getAbsolutePath();
            String rutaOrigen = "";

            File file[] = jf.getSelectedFiles();

            DefaultTableModel miTableModel = (DefaultTableModel) MyTable.getModel();
            for (File file1 : file) {
                
                int pos = file1.getName().indexOf(".");
                String nombre = file1.getName().substring(0, pos);
                Object[] nuevafila = {nombre, file1.getName(), file1.getAbsolutePath()};
                miTableModel.addRow(nuevafila);
                Borrar.setEnabled(true);
                Guardar.setEnabled(true);

            }

        }
    }//GEN-LAST:event_cargarActionPerformed

    /**
     * Metodo para mostrar icono de la aplicacion
     * @return 
     */
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Interface/oie_transparent.png"));

        return retValue;
    }

    /**
     * Metodo que limpia los datos de una tabla
     *
     * @param Tabla
     */
    public void reiniciarJTable(javax.swing.JTable Tabla) {
        DefaultTableModel modelo = (DefaultTableModel) Tabla.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        Guardar.setEnabled(false);
        Borrar.setEnabled(false);

    }

    
     /**
      * Boton Guardar
      * @param evt 
      */
    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        DefaultTableModel miTableModel = (DefaultTableModel) MyTable.getModel();

        try {
            for (int i = 0; i < MyTable.getRowCount(); i++) {

                GuardarImg(MyTable.getValueAt(i, 0).toString(), MyTable.getValueAt(i, 2).toString());

            }
            CARGANDO.main(null);
            JOptionPane.showMessageDialog(null, "Los Datos Se guardaron con Exito", "Informacion", JOptionPane.INFORMATION_MESSAGE);

            reiniciarJTable(MyTable);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CargaImg.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error Al Guardar Datos", "Alerta", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_GuardarActionPerformed

    /**
     * Metodo que trabaja con la bd
     *
     * @param Codins
     * @param Ruta
     * @throws FileNotFoundException
     */
    public void GuardarImg(String Codins, String Ruta) throws FileNotFoundException {
        Connection conn = (Connection) BD.GetConnection();
        FileInputStream fis = null;
        try {
            String sql = "UPDATE Alm_ImgInsumos SET Graficos=? WHERE Codins=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            File file = new File(Ruta);//Ruta
            fis = new FileInputStream(file);
            // statement.set
            statement.setBinaryStream(1, fis, (int) file.length());
            statement.setString(2, Codins);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Correcto");

            }

        } catch (FileNotFoundException | SQLException e) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, e);

            JOptionPane.showMessageDialog(null, "Error! :\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    ArrayList<Alm_ImgInsumos> getImagenes() throws SQLException {
        ArrayList<Alm_ImgInsumos> lista = new ArrayList();
        Connection conn = (Connection) BD.GetConnection();
        Statement stmt = null;

        try {

            String query = "SELECT Graficos,Codins FROM Alm_ImgInsumos";

            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Alm_ImgInsumos imagen = new Alm_ImgInsumos();
                    Blob blob = rs.getBlob("Graficos");
                    String nombre = rs.getObject("Codins").toString();
                    byte[] data = blob.getBytes(1, (int) blob.length());
                    BufferedImage img = null;
                    try {
                        img = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (IOException ex) {
                        Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    imagen.setGraficos(img);
                    imagen.setCodins(nombre);
                    lista.add(imagen);
                }
                rs.close();
            } catch (SQLException e) {

            }

        } catch (Exception e) {
            if (stmt != null) {
                stmt.close();
            }
        }

        return lista;
    }


    private void MyTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MyTableMouseClicked
        // agregar codigo


    }//GEN-LAST:event_MyTableMouseClicked

    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarActionPerformed

        DefaultTableModel miTableModel = (DefaultTableModel) MyTable.getModel();

        int fila = MyTable.getSelectedRow();
        if (fila > -1) {
            miTableModel.removeRow(fila);

            if (MyTable.getRowCount() == 0) {

                Borrar.setEnabled(false);
                Guardar.setEnabled(false);
            }

            /* para elminar multiples reguistros
             for (int i = 0; i <= indFil.length; i++) {
             jTextField1.setText("" + indFil.length);
             miTableModel.removeRow(i);
             }*/
        } else {

            JOptionPane.showMessageDialog(null, "Debe Seleccionar Fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_BorrarActionPerformed

    public void ObtenerImagenes() {
        try {
            imagenes = getImagenes();
        } catch (SQLException ex) {
            Logger.getLogger(CargaImg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ExportarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportarImgActionPerformed
        int variable = 0;
        ObtenerImagenes();

        try {
            final JFileChooser elegirCarpeta = new JFileChooser();
            elegirCarpeta.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int o = elegirCarpeta.showOpenDialog(this);
            if (o == JFileChooser.APPROVE_OPTION) {
                String path = elegirCarpeta.getSelectedFile().getAbsolutePath();
             //   System.out.println(path.length() + " : " + path);//saber la ruta
                for (int i = 0; i < imagenes.size(); i++) {
                    ImageIO.write((RenderedImage) imagenes.get(i).getGraficos(), "JPG", new File(path+"\\"+imagenes.get(i).getCodins()+".JPG"));
                    variable++; 
                  
                
                }
                ExportarImg.setEnabled(false);
             }
            JOptionPane.showMessageDialog(null, "El backup ha sido Exitoso Fueron Procesados\n"+variable+"  Archivos", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            ExportarImg.setEnabled(true);

        
        } catch (HeadlessException e) {
        } catch (IOException ex) {
            Logger.getLogger(CargaImg.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_ExportarImgActionPerformed

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Ayuda En Construccion", "Informacion", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_helpActionPerformed

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
            java.util.logging.Logger.getLogger(CargaImg.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargaImg.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargaImg.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargaImg.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargaImg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Borrar;
    private javax.swing.JButton ExportarImg;
    private javax.swing.JLabel Fechas;
    private javax.swing.JButton Guardar;
    private javax.swing.JLabel Horas;
    private javax.swing.JTable MyTable;
    private javax.swing.JButton cargar;
    private javax.swing.JButton help;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblhora;
    // End of variables declaration//GEN-END:variables
}
