/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Companies.Company;
import Rules.AppleRules;
import Store.Drive;
import java.awt.Color;
import javax.accessibility.AccessibleContext;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRootPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import proyecto.pkg1.so.Global;

/**
 *
 * @author vickysaldivia
 */
public class Apple extends javax.swing.JFrame {

    private SimulacionApple simulacionApple;
    
    public Apple() {
        initComponents();

       iniciarSimulacionApple();

    }

    public void actualizarValores(int motherboards, int cpus, int ram, int powerSupplies, int gpus,
            int standardComputers, int computersWithGPU, int diasRestantes,
            double costosActuales, String estadoPM, String estadoDirector,
            double sueldoPM, double sueldoDirector) {
        // Actualizar los valores de producción
        PlacasProducidas.setText(String.valueOf(motherboards));
        CPUProducidas.setText(String.valueOf(cpus));
        RAMProducidas.setText(String.valueOf(ram));
        PowerSupplyProduc.setText(String.valueOf(powerSupplies));
        GraphicCardProduc.setText(String.valueOf(gpus));
        EstandarProduc.setText(String.valueOf(standardComputers));
        GraficaProduc.setText(String.valueOf(computersWithGPU));
        
        PlacaBar.setValue(motherboards);
        this.PowerSupplyBar.setValue(powerSupplies);
        this.CPUBar.setValue(cpus);
        this.RAMBar.setValue(ram);
        this.GraphicsCardBar.setValue(gpus);

        // Actualizar los costos
        Costos1.setText(String.valueOf(costosActuales));

        // Actualizar el estado del PM y Director
        EstadoPM1.setText(estadoPM);
        EstadoD.setText(estadoDirector);

        // Actualizar los sueldos
        SueldoPM.setText(String.valueOf(sueldoPM));
        SueldoD.setText(String.valueOf(sueldoDirector));

        // Actualizar días restantes
        dias.setText(String.valueOf(diasRestantes));  // Actualizar la etiqueta de días restantes
    }
    
    public void actualizarCostosComponentes(double costoMotherboards, double costoCPUs, double costoRAM, double costoPowerSupply, double costoGPU) {
        // Actualizar los costos en los JTextFields correspondientes de la interfaz
        this.CostoPlacas.setText(String.format("%.2f", costoMotherboards));
        this.CostoCPU.setText(String.format("%.2f", costoCPUs));
        this.CostoRAM.setText(String.format("%.2f", costoRAM));
        this.PowerSupplyCosto.setText(String.format("%.2f", costoPowerSupply));
        this.GraphicCardCosto.setText(String.format("%.2f", costoGPU));
        
        
    }
    
    // Método para iniciar la simulación de Apple
    private void iniciarSimulacionApple() {
        // Crear y configurar la simulación aquí
        AppleRules appleRules = new AppleRules();
        Drive appleDrive = new Drive(0, 0, 0, 0, 0);
        Global.daysBetweenReleases = 30;

        // Número de empleados de Apple (usar valores globales para Apple)
        int numMotherboardProducers = Global.MotherboardProducersApple;
        int numCPUProducers = Global.CPUProducerApple;
        int numRAMProducers = Global.RAMProducersApple;
        int numPowerSupplyProducers = Global.PowerSupplyProducersApple;
        int numGPUProducers = Global.GPUProducersApple;
        int numAssemblers = Global.AssemblersApple;

        // Crear la compañía Apple
        Company appleCompany = new Company(
                numMotherboardProducers, numCPUProducers, numRAMProducers,
                numPowerSupplyProducers, numGPUProducers, numAssemblers,
                appleDrive, appleRules
        );

        // Crear e iniciar la simulación
        simulacionApple = new SimulacionApple(this, appleCompany);
        simulacionApple.start();
        
        // Actualizar los campos de la interfaz gráfica de Apple
        this.TBase.setText(String.valueOf(numMotherboardProducers));
        this.TBase1.setText(String.valueOf(numPowerSupplyProducers));
        this.TCPU.setText(String.valueOf(numCPUProducers));
        this.TRAM.setText(String.valueOf(numRAMProducers));
        this.TCPU1.setText(String.valueOf(numGPUProducers));
        this.TRAM1.setText(String.valueOf(numAssemblers));
    }

    // Método para detener la simulación y todos los hilos
    private void detenerHilosSimulacion() {
        if (simulacionApple != null && simulacionApple.isAlive()) {
            simulacionApple.detenerHilos();  // Llama al método detenerHilos() de SimulacionApple
            simulacionApple.interrupt();  // Interrumpe el hilo de simulación
        }
    }

    // Método que se ejecuta cuando el usuario quiere salir de la interfaz (por ejemplo, al cerrar o al presionar un botón)
    private void salir() {
        Global.daysBetweenReleases = 30;
        detenerHilosSimulacion();  // Detener todos los hilos antes de salir
        //this.dispose();  // Cerrar la ventana
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        config = new javax.swing.JLabel();
        JLabel3 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        Utilidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        FaltasPM1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        DescontadoPM = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        SueldoPM = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        EstadoD = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        SueldoD = new javax.swing.JTextField();
        EstadoPM1 = new javax.swing.JTextField();
        GananciaBruta = new javax.swing.JTextField();
        Costos1 = new javax.swing.JTextField();
        JLabel7 = new javax.swing.JLabel();
        JLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Verde = new javax.swing.JLabel();
        Rojo = new javax.swing.JLabel();
        Amarillo = new javax.swing.JLabel();
        Verde1 = new javax.swing.JLabel();
        Rojo1 = new javax.swing.JLabel();
        Amarillo1 = new javax.swing.JLabel();
        JLabel9 = new javax.swing.JLabel();
        JLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        TBase1 = new javax.swing.JTextField();
        TCPU1 = new javax.swing.JTextField();
        TRAM1 = new javax.swing.JTextField();
        TRAM = new javax.swing.JTextField();
        TCPU = new javax.swing.JTextField();
        TBase = new javax.swing.JTextField();
        PlacasProducidas = new javax.swing.JTextField();
        PlacaBar = new javax.swing.JProgressBar();
        CostoPlacas = new javax.swing.JTextField();
        dias = new javax.swing.JLabel();
        JLabel6 = new javax.swing.JLabel();
        JLabel11 = new javax.swing.JLabel();
        CPUProducidas = new javax.swing.JTextField();
        CPUBar = new javax.swing.JProgressBar();
        CostoCPU = new javax.swing.JTextField();
        JLabel12 = new javax.swing.JLabel();
        CostoRAM = new javax.swing.JTextField();
        JLabel13 = new javax.swing.JLabel();
        RAMBar = new javax.swing.JProgressBar();
        JLabel14 = new javax.swing.JLabel();
        RAMProducidas = new javax.swing.JTextField();
        JLabel15 = new javax.swing.JLabel();
        PowerSupplyProduc = new javax.swing.JTextField();
        PowerSupplyBar = new javax.swing.JProgressBar();
        PowerSupplyCosto = new javax.swing.JTextField();
        JLabel16 = new javax.swing.JLabel();
        JLabel17 = new javax.swing.JLabel();
        GraphicCardCosto = new javax.swing.JTextField();
        GraphicsCardBar = new javax.swing.JProgressBar();
        JLabel18 = new javax.swing.JLabel();
        JLabel19 = new javax.swing.JLabel();
        JLabel20 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Rojo2 = new javax.swing.JLabel();
        Verde2 = new javax.swing.JLabel();
        Amarillo2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        GraphicCardProduc = new javax.swing.JTextField();
        EstandarProduc = new javax.swing.JTextField();
        GraficaProduc = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setForeground(new java.awt.Color(153, 153, 153));
        jPanel2.setFocusable(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Apple_gray_logo.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, -1, -1));

        config.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        config.setForeground(new java.awt.Color(51, 51, 51));
        config.setText("  Configuración");
        config.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.black, java.awt.Color.black));
        config.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        config.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                configMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                configMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                configMouseExited(evt);
            }
        });
        jPanel2.add(config, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 200, 60));

        JLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        JLabel3.setForeground(new java.awt.Color(51, 51, 51));
        JLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabel3.setText("Simulación Apple");
        JLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.black, java.awt.Color.black));
        JLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JLabel3MouseExited(evt);
            }
        });
        jPanel2.add(JLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 480, 60));

        back.setBackground(new java.awt.Color(204, 204, 204));
        back.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        back.setText("🔙");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel2.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 60));

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 260, 10));

        Utilidad.setEditable(false);
        Utilidad.setBackground(new java.awt.Color(226, 226, 226));
        Utilidad.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        Utilidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Utilidad.setText("0");
        Utilidad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        Utilidad.setFocusable(false);
        Utilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UtilidadActionPerformed(evt);
            }
        });
        jPanel1.add(Utilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 140, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Faltas:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 60, 30));

        FaltasPM1.setEditable(false);
        FaltasPM1.setBackground(new java.awt.Color(226, 226, 226));
        FaltasPM1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        FaltasPM1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FaltasPM1.setText("0");
        FaltasPM1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        FaltasPM1.setFocusable(false);
        FaltasPM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FaltasPM1ActionPerformed(evt);
            }
        });
        jPanel1.add(FaltasPM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 40, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Descontado:  $");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 110, 30));

        DescontadoPM.setEditable(false);
        DescontadoPM.setBackground(new java.awt.Color(226, 226, 226));
        DescontadoPM.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        DescontadoPM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DescontadoPM.setText("0");
        DescontadoPM.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        DescontadoPM.setFocusable(false);
        DescontadoPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescontadoPMActionPerformed(evt);
            }
        });
        jPanel1.add(DescontadoPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, 50, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Sueldo acumulado:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 150, 30));

        SueldoPM.setEditable(false);
        SueldoPM.setBackground(new java.awt.Color(226, 226, 226));
        SueldoPM.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        SueldoPM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SueldoPM.setText("0");
        SueldoPM.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        SueldoPM.setFocusable(false);
        SueldoPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueldoPMActionPerformed(evt);
            }
        });
        jPanel1.add(SueldoPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 120, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel8.setText("Días restantes para la entrega:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 570, 250, 30));

        EstadoD.setEditable(false);
        EstadoD.setBackground(new java.awt.Color(226, 226, 226));
        EstadoD.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        EstadoD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EstadoD.setText("-");
        EstadoD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        EstadoD.setFocusable(false);
        EstadoD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstadoDActionPerformed(evt);
            }
        });
        jPanel1.add(EstadoD, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 140, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Sueldo acumulado:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 150, 30));

        SueldoD.setEditable(false);
        SueldoD.setBackground(new java.awt.Color(226, 226, 226));
        SueldoD.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        SueldoD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SueldoD.setText("0");
        SueldoD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        SueldoD.setFocusable(false);
        SueldoD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueldoDActionPerformed(evt);
            }
        });
        jPanel1.add(SueldoD, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 500, 120, 30));

        EstadoPM1.setEditable(false);
        EstadoPM1.setBackground(new java.awt.Color(226, 226, 226));
        EstadoPM1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        EstadoPM1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EstadoPM1.setText("-");
        EstadoPM1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        EstadoPM1.setFocusable(false);
        EstadoPM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstadoPM1ActionPerformed(evt);
            }
        });
        jPanel1.add(EstadoPM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 140, 30));

        GananciaBruta.setEditable(false);
        GananciaBruta.setBackground(new java.awt.Color(226, 226, 226));
        GananciaBruta.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        GananciaBruta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        GananciaBruta.setText("0");
        GananciaBruta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        GananciaBruta.setFocusable(false);
        GananciaBruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GananciaBrutaActionPerformed(evt);
            }
        });
        jPanel1.add(GananciaBruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 140, 30));

        Costos1.setEditable(false);
        Costos1.setBackground(new java.awt.Color(226, 226, 226));
        Costos1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        Costos1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Costos1.setText("0");
        Costos1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        Costos1.setFocusable(false);
        Costos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Costos1ActionPerformed(evt);
            }
        });
        jPanel1.add(Costos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 140, 30));

        JLabel7.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        JLabel7.setText("Utilidad:");
        jPanel1.add(JLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 100, 30));

        JLabel8.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        JLabel8.setText("Costos: ");
        jPanel1.add(JLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 120, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("20");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, 120, 30));

        Verde.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Verde.setForeground(new java.awt.Color(0, 204, 102));
        Verde.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Verde.setText("●");
        Verde.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Verde.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                VerdeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                VerdeMouseExited(evt);
            }
        });
        jPanel1.add(Verde, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 50, 60));

        Rojo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Rojo.setForeground(new java.awt.Color(255, 102, 102));
        Rojo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Rojo.setText("●");
        Rojo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Rojo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RojoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RojoMouseExited(evt);
            }
        });
        jPanel1.add(Rojo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 50, 60));

        Amarillo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Amarillo.setForeground(new java.awt.Color(255, 204, 102));
        Amarillo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Amarillo.setText("●");
        Amarillo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Amarillo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AmarilloMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AmarilloMouseExited(evt);
            }
        });
        jPanel1.add(Amarillo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 50, 60));

        Verde1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Verde1.setForeground(new java.awt.Color(0, 204, 102));
        Verde1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Verde1.setText("●");
        Verde1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Verde1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Verde1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Verde1MouseExited(evt);
            }
        });
        jPanel1.add(Verde1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 30, 60));

        Rojo1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Rojo1.setForeground(new java.awt.Color(255, 102, 102));
        Rojo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Rojo1.setText("●");
        Rojo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Rojo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Rojo1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Rojo1MouseExited(evt);
            }
        });
        jPanel1.add(Rojo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 30, 60));

        Amarillo1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Amarillo1.setForeground(new java.awt.Color(255, 204, 102));
        Amarillo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Amarillo1.setText("●");
        Amarillo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Amarillo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Amarillo1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Amarillo1MouseExited(evt);
            }
        });
        jPanel1.add(Amarillo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 50, 60));

        JLabel9.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        JLabel9.setText("Ganancias:");
        jPanel1.add(JLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 140, 30));

        JLabel10.setFont(new java.awt.Font("Arial", 3, 16)); // NOI18N
        JLabel10.setText("Base:");
        jPanel1.add(JLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 110, 20));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel15.setText("Assembler:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 500, 120, 20));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel16.setText("Graphics Card:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 470, 130, 20));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel17.setText("Power Supply:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 440, 130, 20));

        TBase1.setEditable(false);
        TBase1.setBackground(new java.awt.Color(226, 226, 226));
        TBase1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        TBase1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TBase1.setText("0");
        TBase1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        TBase1.setFocusable(false);
        TBase1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBase1ActionPerformed(evt);
            }
        });
        jPanel1.add(TBase1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 440, 40, 20));

        TCPU1.setEditable(false);
        TCPU1.setBackground(new java.awt.Color(226, 226, 226));
        TCPU1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        TCPU1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TCPU1.setText("0");
        TCPU1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        TCPU1.setFocusable(false);
        TCPU1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TCPU1ActionPerformed(evt);
            }
        });
        jPanel1.add(TCPU1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 470, 40, 20));

        TRAM1.setEditable(false);
        TRAM1.setBackground(new java.awt.Color(226, 226, 226));
        TRAM1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        TRAM1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TRAM1.setText("0");
        TRAM1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        TRAM1.setFocusable(false);
        TRAM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TRAM1ActionPerformed(evt);
            }
        });
        jPanel1.add(TRAM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 500, 40, 20));

        TRAM.setEditable(false);
        TRAM.setBackground(new java.awt.Color(226, 226, 226));
        TRAM.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        TRAM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TRAM.setText("0");
        TRAM.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        TRAM.setFocusable(false);
        TRAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TRAMActionPerformed(evt);
            }
        });
        jPanel1.add(TRAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 500, 40, 20));

        TCPU.setEditable(false);
        TCPU.setBackground(new java.awt.Color(226, 226, 226));
        TCPU.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        TCPU.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TCPU.setText("0");
        TCPU.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        TCPU.setFocusable(false);
        TCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TCPUActionPerformed(evt);
            }
        });
        jPanel1.add(TCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 470, 40, 20));

        TBase.setEditable(false);
        TBase.setBackground(new java.awt.Color(226, 226, 226));
        TBase.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        TBase.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TBase.setText("0");
        TBase.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        TBase.setFocusable(false);
        TBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TBaseActionPerformed(evt);
            }
        });
        jPanel1.add(TBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 440, 40, 20));

        PlacasProducidas.setEditable(false);
        PlacasProducidas.setBackground(new java.awt.Color(226, 226, 226));
        PlacasProducidas.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        PlacasProducidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PlacasProducidas.setText("0");
        PlacasProducidas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        PlacasProducidas.setFocusable(false);
        PlacasProducidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlacasProducidasActionPerformed(evt);
            }
        });
        jPanel1.add(PlacasProducidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 40, 20));

        PlacaBar.setBackground(new java.awt.Color(204, 204, 204));
        PlacaBar.setMaximum(25);
        PlacaBar.setToolTipText("");
        jPanel1.add(PlacaBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 160, 30));

        CostoPlacas.setEditable(false);
        CostoPlacas.setBackground(new java.awt.Color(226, 226, 226));
        CostoPlacas.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        CostoPlacas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CostoPlacas.setText("0");
        CostoPlacas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        CostoPlacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CostoPlacasActionPerformed(evt);
            }
        });
        jPanel1.add(CostoPlacas, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 80, 20));

        dias.setFont(new java.awt.Font("Arial", 3, 16)); // NOI18N
        dias.setText("4");
        jPanel1.add(dias, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 570, 340, 30));

        JLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JLabel6.setText("Costos:");
        jPanel1.add(JLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 90, 20));

        JLabel11.setFont(new java.awt.Font("Arial", 3, 16)); // NOI18N
        JLabel11.setText("CPU:");
        jPanel1.add(JLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 110, 20));

        CPUProducidas.setEditable(false);
        CPUProducidas.setBackground(new java.awt.Color(226, 226, 226));
        CPUProducidas.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        CPUProducidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CPUProducidas.setText("0");
        CPUProducidas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        CPUProducidas.setFocusable(false);
        CPUProducidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPUProducidasActionPerformed(evt);
            }
        });
        jPanel1.add(CPUProducidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 40, 20));

        CPUBar.setBackground(new java.awt.Color(204, 204, 204));
        CPUBar.setMaximum(25);
        CPUBar.setToolTipText("");
        jPanel1.add(CPUBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 160, 30));

        CostoCPU.setEditable(false);
        CostoCPU.setBackground(new java.awt.Color(226, 226, 226));
        CostoCPU.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        CostoCPU.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CostoCPU.setText("0");
        CostoCPU.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        CostoCPU.setFocusable(false);
        CostoCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CostoCPUActionPerformed(evt);
            }
        });
        jPanel1.add(CostoCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 80, 20));

        JLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JLabel12.setText("Tarjeta Gráfica:");
        jPanel1.add(JLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, 90, 20));

        CostoRAM.setEditable(false);
        CostoRAM.setBackground(new java.awt.Color(226, 226, 226));
        CostoRAM.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        CostoRAM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CostoRAM.setText("0");
        CostoRAM.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        CostoRAM.setFocusable(false);
        CostoRAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CostoRAMActionPerformed(evt);
            }
        });
        jPanel1.add(CostoRAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 80, 20));

        JLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JLabel13.setText("Costos:");
        jPanel1.add(JLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 90, 20));

        RAMBar.setBackground(new java.awt.Color(204, 204, 204));
        RAMBar.setMaximum(25);
        RAMBar.setToolTipText("");
        jPanel1.add(RAMBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 160, 30));

        JLabel14.setFont(new java.awt.Font("Arial", 3, 16)); // NOI18N
        JLabel14.setText("RAM:");
        jPanel1.add(JLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, 110, 20));

        RAMProducidas.setEditable(false);
        RAMProducidas.setBackground(new java.awt.Color(226, 226, 226));
        RAMProducidas.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        RAMProducidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        RAMProducidas.setText("0");
        RAMProducidas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        RAMProducidas.setFocusable(false);
        RAMProducidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAMProducidasActionPerformed(evt);
            }
        });
        jPanel1.add(RAMProducidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 40, 20));

        JLabel15.setFont(new java.awt.Font("Arial", 3, 16)); // NOI18N
        JLabel15.setText("Power Supply:");
        jPanel1.add(JLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 130, 20));

        PowerSupplyProduc.setEditable(false);
        PowerSupplyProduc.setBackground(new java.awt.Color(226, 226, 226));
        PowerSupplyProduc.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        PowerSupplyProduc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PowerSupplyProduc.setText("0");
        PowerSupplyProduc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        PowerSupplyProduc.setFocusable(false);
        PowerSupplyProduc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PowerSupplyProducActionPerformed(evt);
            }
        });
        jPanel1.add(PowerSupplyProduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, 40, 20));

        PowerSupplyBar.setBackground(new java.awt.Color(204, 204, 204));
        PowerSupplyBar.setMaximum(25);
        PowerSupplyBar.setToolTipText("");
        jPanel1.add(PowerSupplyBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 160, 30));

        PowerSupplyCosto.setEditable(false);
        PowerSupplyCosto.setBackground(new java.awt.Color(226, 226, 226));
        PowerSupplyCosto.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        PowerSupplyCosto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PowerSupplyCosto.setText("0");
        PowerSupplyCosto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        PowerSupplyCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PowerSupplyCostoActionPerformed(evt);
            }
        });
        jPanel1.add(PowerSupplyCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, 80, 20));

        JLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JLabel16.setText("Costos:");
        jPanel1.add(JLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 90, 20));

        JLabel17.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JLabel17.setText("Estándar:");
        jPanel1.add(JLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 290, 90, 20));

        GraphicCardCosto.setEditable(false);
        GraphicCardCosto.setBackground(new java.awt.Color(226, 226, 226));
        GraphicCardCosto.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        GraphicCardCosto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        GraphicCardCosto.setText("0");
        GraphicCardCosto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        GraphicCardCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraphicCardCostoActionPerformed(evt);
            }
        });
        jPanel1.add(GraphicCardCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 240, 80, 20));

        GraphicsCardBar.setBackground(new java.awt.Color(204, 204, 204));
        GraphicsCardBar.setMaximum(25);
        GraphicsCardBar.setToolTipText("");
        jPanel1.add(GraphicsCardBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 160, 30));

        JLabel18.setFont(new java.awt.Font("Arial", 3, 16)); // NOI18N
        JLabel18.setText("Graphics Card:");
        jPanel1.add(JLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 130, 20));

        JLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JLabel19.setText("Costos:");
        jPanel1.add(JLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 90, 20));

        JLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        JLabel20.setText("Costos:");
        jPanel1.add(JLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, 90, 20));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Estado PM:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 150, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setText("CPU:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 90, 20));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel14.setText("RAM:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, 90, 20));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setText("Base:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 90, 20));

        Rojo2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Rojo2.setForeground(new java.awt.Color(255, 102, 102));
        Rojo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Rojo2.setText("●");
        Rojo2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Rojo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Rojo2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Rojo2MouseExited(evt);
            }
        });
        jPanel1.add(Rojo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 30, 50));

        Verde2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Verde2.setForeground(new java.awt.Color(0, 204, 102));
        Verde2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Verde2.setText("●");
        Verde2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Verde2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Verde2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Verde2MouseExited(evt);
            }
        });
        jPanel1.add(Verde2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 30, 50));

        Amarillo2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Amarillo2.setForeground(new java.awt.Color(255, 204, 102));
        Amarillo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Amarillo2.setText("●");
        Amarillo2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Amarillo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Amarillo2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Amarillo2MouseExited(evt);
            }
        });
        jPanel1.add(Amarillo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 50, 50));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Estado Director:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 150, 30));

        GraphicCardProduc.setEditable(false);
        GraphicCardProduc.setBackground(new java.awt.Color(226, 226, 226));
        GraphicCardProduc.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        GraphicCardProduc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        GraphicCardProduc.setText("0");
        GraphicCardProduc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        GraphicCardProduc.setFocusable(false);
        GraphicCardProduc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraphicCardProducActionPerformed(evt);
            }
        });
        jPanel1.add(GraphicCardProduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 190, 40, 20));

        EstandarProduc.setEditable(false);
        EstandarProduc.setBackground(new java.awt.Color(226, 226, 226));
        EstandarProduc.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        EstandarProduc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EstandarProduc.setText("0");
        EstandarProduc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        EstandarProduc.setFocusable(false);
        EstandarProduc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstandarProducActionPerformed(evt);
            }
        });
        jPanel1.add(EstandarProduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 40, 20));

        GraficaProduc.setEditable(false);
        GraficaProduc.setBackground(new java.awt.Color(226, 226, 226));
        GraficaProduc.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        GraficaProduc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        GraficaProduc.setText("0");
        GraficaProduc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        GraficaProduc.setFocusable(false);
        GraficaProduc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraficaProducActionPerformed(evt);
            }
        });
        jPanel1.add(GraficaProduc, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 40, 20));

        jTextField15.setEditable(false);
        jTextField15.setBackground(new java.awt.Color(255, 255, 255));
        jTextField15.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, null, new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray)));
        jTextField15.setFocusable(false);
        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 570, 700, 30));

        jTextField13.setEditable(false);
        jTextField13.setBackground(new java.awt.Color(204, 204, 204));
        jTextField13.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jTextField13.setText(" Trabajadores:");
        jTextField13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField13.setFocusable(false);
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 280, 30));

        jTextField12.setEditable(false);
        jTextField12.setBackground(new java.awt.Color(255, 255, 255));
        jTextField12.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, null, new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray)));
        jTextField12.setFocusable(false);
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 400, 150));

        jTextField11.setEditable(false);
        jTextField11.setBackground(new java.awt.Color(204, 204, 204));
        jTextField11.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jTextField11.setText("Computadoras");
        jTextField11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField11.setFocusable(false);
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 100, -1));

        jTextField10.setEditable(false);
        jTextField10.setBackground(new java.awt.Color(255, 255, 255));
        jTextField10.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jTextField10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField10.setFocusable(false);
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 160, 70));

        jTextField9.setEditable(false);
        jTextField9.setBackground(new java.awt.Color(204, 204, 204));
        jTextField9.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jTextField9.setText(" Información de Producción");
        jTextField9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField9.setFocusable(false);
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 280, 30));

        jTextField8.setEditable(false);
        jTextField8.setBackground(new java.awt.Color(255, 255, 255));
        jTextField8.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, null, new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray)));
        jTextField8.setFocusable(false);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 400, 260));

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(204, 204, 204));
        jTextField6.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jTextField6.setText(" Estadísticas");
        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField6.setFocusable(false);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 280, 30));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jTextField1.setText(" Project Manager / Director");
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField1.setFocusable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 280, 30));

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(255, 255, 255));
        jTextField4.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, null, new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray)));
        jTextField4.setFocusable(false);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 300, 180));

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(255, 255, 255));
        jTextField5.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, null, new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray)));
        jTextField5.setFocusable(false);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 300, 220));

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(204, 204, 204));
        jTextField3.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102))));
        jTextField3.setFocusable(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 780, 50));

        jTextField7.setEditable(false);
        jTextField7.setBackground(new java.awt.Color(204, 204, 204));
        jTextField7.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102))));
        jTextField7.setFocusable(false);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 320, 470));

        jTextField14.setEditable(false);
        jTextField14.setBackground(new java.awt.Color(204, 204, 204));
        jTextField14.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102))));
        jTextField14.setFocusable(false);
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 420, 470));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VerdeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VerdeMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_VerdeMouseEntered

    private void VerdeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VerdeMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_VerdeMouseExited

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void configMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_configMouseEntered

    private void configMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_configMouseExited

    private void JLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabel3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JLabel3MouseEntered

    private void JLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLabel3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JLabel3MouseExited

    private void RojoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RojoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_RojoMouseEntered

    private void RojoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RojoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_RojoMouseExited

    private void AmarilloMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AmarilloMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_AmarilloMouseEntered

    private void AmarilloMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AmarilloMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_AmarilloMouseExited

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void configMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configMouseClicked
        // TODO add your handling code here:
        VEjecApple valoresEjecucion = new VEjecApple();
        valoresEjecucion.setLocationRelativeTo(null);
        valoresEjecucion.setResizable(false);
        valoresEjecucion.setVisible(true);
    }//GEN-LAST:event_configMouseClicked

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void UtilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UtilidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UtilidadActionPerformed

    private void PlacasProducidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlacasProducidasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PlacasProducidasActionPerformed

    private void DescontadoPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescontadoPMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescontadoPMActionPerformed

    private void SueldoPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SueldoPMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SueldoPMActionPerformed

    private void EstadoDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstadoDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EstadoDActionPerformed

    private void SueldoDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SueldoDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SueldoDActionPerformed

    private void EstadoPM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstadoPM1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EstadoPM1ActionPerformed

    private void GananciaBrutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GananciaBrutaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GananciaBrutaActionPerformed

    private void Costos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Costos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Costos1ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        salir();
        Menu ventana = new Menu();
        this.setVisible(false);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void Verde1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Verde1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Verde1MouseEntered

    private void Verde1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Verde1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Verde1MouseExited

    private void Rojo1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rojo1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Rojo1MouseEntered

    private void Rojo1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rojo1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Rojo1MouseExited

    private void Amarillo1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Amarillo1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Amarillo1MouseEntered

    private void Amarillo1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Amarillo1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Amarillo1MouseExited

    private void FaltasPM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FaltasPM1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FaltasPM1ActionPerformed

    private void CostoPlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CostoPlacasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CostoPlacasActionPerformed

    private void CPUProducidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPUProducidasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPUProducidasActionPerformed

    private void CostoCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CostoCPUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CostoCPUActionPerformed

    private void CostoRAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CostoRAMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CostoRAMActionPerformed

    private void RAMProducidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAMProducidasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RAMProducidasActionPerformed

    private void PowerSupplyProducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PowerSupplyProducActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PowerSupplyProducActionPerformed

    private void PowerSupplyCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PowerSupplyCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PowerSupplyCostoActionPerformed

    private void GraphicCardCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraphicCardCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GraphicCardCostoActionPerformed

    private void EstandarProducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstandarProducActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EstandarProducActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void GraphicCardProducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraphicCardProducActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GraphicCardProducActionPerformed

    private void GraficaProducActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraficaProducActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GraficaProducActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void TCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TCPUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TCPUActionPerformed

    private void TBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TBaseActionPerformed

    private void TRAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TRAMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TRAMActionPerformed

    private void TBase1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TBase1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TBase1ActionPerformed

    private void TCPU1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TCPU1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TCPU1ActionPerformed

    private void TRAM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TRAM1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TRAM1ActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void Rojo2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rojo2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Rojo2MouseEntered

    private void Rojo2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rojo2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Rojo2MouseExited

    private void Verde2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Verde2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Verde2MouseEntered

    private void Verde2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Verde2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Verde2MouseExited

    private void Amarillo2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Amarillo2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Amarillo2MouseEntered

    private void Amarillo2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Amarillo2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Amarillo2MouseExited

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
            java.util.logging.Logger.getLogger(Apple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Apple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Apple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Apple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Apple().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Amarillo;
    private javax.swing.JLabel Amarillo1;
    private javax.swing.JLabel Amarillo2;
    private javax.swing.JProgressBar CPUBar;
    private javax.swing.JTextField CPUProducidas;
    private javax.swing.JTextField CostoCPU;
    private javax.swing.JTextField CostoPlacas;
    private javax.swing.JTextField CostoRAM;
    private javax.swing.JTextField Costos1;
    private javax.swing.JTextField DescontadoPM;
    private javax.swing.JTextField EstadoD;
    private javax.swing.JTextField EstadoPM1;
    private javax.swing.JTextField EstandarProduc;
    private javax.swing.JTextField FaltasPM1;
    private javax.swing.JTextField GananciaBruta;
    private javax.swing.JTextField GraficaProduc;
    private javax.swing.JTextField GraphicCardCosto;
    private javax.swing.JTextField GraphicCardProduc;
    private javax.swing.JProgressBar GraphicsCardBar;
    private javax.swing.JLabel JLabel10;
    private javax.swing.JLabel JLabel11;
    private javax.swing.JLabel JLabel12;
    private javax.swing.JLabel JLabel13;
    private javax.swing.JLabel JLabel14;
    private javax.swing.JLabel JLabel15;
    private javax.swing.JLabel JLabel16;
    private javax.swing.JLabel JLabel17;
    private javax.swing.JLabel JLabel18;
    private javax.swing.JLabel JLabel19;
    private javax.swing.JLabel JLabel20;
    private javax.swing.JLabel JLabel3;
    private javax.swing.JLabel JLabel6;
    private javax.swing.JLabel JLabel7;
    private javax.swing.JLabel JLabel8;
    private javax.swing.JLabel JLabel9;
    private javax.swing.JProgressBar PlacaBar;
    private javax.swing.JTextField PlacasProducidas;
    private javax.swing.JProgressBar PowerSupplyBar;
    private javax.swing.JTextField PowerSupplyCosto;
    private javax.swing.JTextField PowerSupplyProduc;
    private javax.swing.JProgressBar RAMBar;
    private javax.swing.JTextField RAMProducidas;
    private javax.swing.JLabel Rojo;
    private javax.swing.JLabel Rojo1;
    private javax.swing.JLabel Rojo2;
    private javax.swing.JTextField SueldoD;
    private javax.swing.JTextField SueldoPM;
    private javax.swing.JTextField TBase;
    private javax.swing.JTextField TBase1;
    private javax.swing.JTextField TCPU;
    private javax.swing.JTextField TCPU1;
    private javax.swing.JTextField TRAM;
    private javax.swing.JTextField TRAM1;
    private javax.swing.JTextField Utilidad;
    private javax.swing.JLabel Verde;
    private javax.swing.JLabel Verde1;
    private javax.swing.JLabel Verde2;
    private javax.swing.JButton back;
    private javax.swing.JLabel config;
    private javax.swing.JLabel dias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
