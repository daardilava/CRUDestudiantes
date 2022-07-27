/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Estudiante;
import modelo.EstudianteDAO;
import vista.Interfaz;

/**
 *
 * @author diego
 */
public class ControladorEstudiante implements ActionListener {

    
    //Instancias de cada objeto
    Estudiante estudiante = new Estudiante();
    EstudianteDAO estudiantedao = new EstudianteDAO();
    Interfaz vista = new Interfaz();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    
    //Variables globales
    private int code = 0;
    private String tipoID;
    private int numeroID;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contraseña;
    private String movil;
    private String email;
    
    

    public ControladorEstudiante(Interfaz vista) {
        
        this.vista = vista;
        vista.setVisible(true);
        agregarEventos();
        listarTabla();
    }
    
    private void agregarEventos() {
        vista.getBtnAgregar().addActionListener(this);
        vista.getBtnActualizar().addActionListener(this);
        vista.getBtnBorrar().addActionListener(this);
        vista.getBtnLimpiar().addActionListener(this);
        vista.getTblTabla().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                llenarCampos(e);
            }
        });
    }
    
    private void listarTabla(){
        String[] titulos = new String[]{"Code", "TipoID", "numeroID", "Nombre", "Apellido", "Usuario", "Contraseña", 
            "Movil", "Email"};
        modeloTabla = new DefaultTableModel(titulos, 0);
        List<Estudiante> listaEstudiantes = estudiantedao.Listar();
        for (Estudiante estudiante : listaEstudiantes){
            modeloTabla.addRow(new Object[]{estudiante.getCode(), estudiante.getTipoID(), estudiante.getNumeroID(),
            estudiante.getNombre(), estudiante.getApellido(), estudiante.getUsuario(), estudiante.getContraseña(),
            estudiante.getMovil(), estudiante.getEmail()});
        }
        vista.getTblTabla().setModel(modeloTabla);
        vista.getTblTabla().setPreferredSize(new Dimension(350, modeloTabla.getRowCount() * 16));
    }
    
    private void llenarCampos(MouseEvent e) {
        JTable target = (JTable) e.getSource();
        code = (int) vista.getTblTabla().getModel().getValueAt(target.getSelectedRow(), 0);
        vista.getTxtTipoID().setText(vista.getTblTabla().getModel().getValueAt(target.getSelectedRow(), 1).toString());
        vista.getTxtNumeroID().setText(vista.getTblTabla().getModel().getValueAt(target.getSelectedRow(), 2).toString());
        vista.getTxtNombre().setText(vista.getTblTabla().getModel().getValueAt(target.getSelectedRow(), 3).toString());
        vista.getTxtApellido().setText(vista.getTblTabla().getModel().getValueAt(target.getSelectedRow(), 4).toString());
        vista.getTxtUsuario().setText(vista.getTblTabla().getModel().getValueAt(target.getSelectedRow(), 5).toString());
        vista.getTxtContraseña().setText(vista.getTblTabla().getModel().getValueAt(target.getSelectedRow(), 6).toString());
        vista.getTxtMovil().setText(vista.getTblTabla().getModel().getValueAt(target.getSelectedRow(), 7).toString());
        vista.getTxtEmail().setText(vista.getTblTabla().getModel().getValueAt(target.getSelectedRow(), 8).toString());
    }
    
    //Validar formulario
    private boolean validarDatos(){
        if ("".equals(vista.getTxtNumeroID().getText()) || "".equals(vista.getTxtNombre().getText()) || "".equals(vista.getTxtApellido().getText())) {
            JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacios", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
       //Cargando datos en variables globales
    private boolean cargarDatos(){
        try {
            tipoID = vista.getTxtTipoID().getText();
            numeroID = Integer.parseInt(vista.getTxtNumeroID().getText());
            nombre = vista.getTxtNombre().getText();
            apellido = vista.getTxtApellido().getText();
            usuario = vista.getTxtUsuario().getText();
            contraseña = vista.getTxtContraseña().getText();
            movil = vista.getTxtMovil().getText();
            email = vista.getTxtEmail().getText();
            return true;
                 
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacios", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error al cargar datos" + e);
            return false;
        }
    }
    
    //Metodo para limpiar los campos del form
    private void limpiarCampos(){
        vista.getTxtTipoID().setText("");
        vista.getTxtNumeroID().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxtApellido().setText("");
        vista.getTxtUsuario().setText("");
        vista.getTxtContraseña().setText("");
        vista.getTxtMovil().setText("");
        vista.getTxtEmail().setText("");
        code = 0;
        tipoID = "";
        numeroID = 0;
        nombre = "";
        apellido = "";
        usuario = "";
        contraseña = "";
        movil = "";
        email = "";
    }
    
    
    //Metodo agregar
    private void agregarEstudiante(){
        try {
            if (validarDatos()) {
                if(cargarDatos()){
                    Estudiante estudiante = new Estudiante(tipoID, numeroID, nombre, apellido, usuario, contraseña, movil, email);
                    estudiantedao.agregar(estudiante);
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                    limpiarCampos();
                }
            }
        } catch (Exception e) {
            System.out.println("Error al agregarC: " + e);
        } finally {
           listarTabla(); 
        }
    }
    
    private void actualizaEstudiante(){
        try {
            if (validarDatos()) {
                if (cargarDatos()) {
                    Estudiante estudiante = new Estudiante(code, tipoID, numeroID, nombre, apellido, usuario, contraseña, movil, email);
                    estudiantedao.actualizar(estudiante);
                    JOptionPane.showMessageDialog(null, "Registro actualizado");
                    limpiarCampos();
                }
            }
        } catch (HeadlessException e) {
            System.out.println("Error en actualizarC : " + e);
        } finally {
            listarTabla();
        }
    }
    
    private void borrarEstudiante(){
        try {
            if (code != 0) {
                estudiantedao.borrar(code);
                JOptionPane.showMessageDialog(null, "Registro borrado");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un estudiante de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException e) {
            System.out.println("Error borrarC: " + e);
        } finally {
            listarTabla();
        }
    }
    
    //Dar acciones a los botones
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vista.getBtnAgregar()) {
            agregarEstudiante();
        }
        if (ae.getSource() == vista.getBtnActualizar()) {
            actualizaEstudiante();
        }
        if (ae.getSource() == vista.getBtnBorrar()){
            borrarEstudiante();
        }
        if (ae.getSource() == vista.getBtnLimpiar()){
            limpiarCampos();
        }
    
    }
}