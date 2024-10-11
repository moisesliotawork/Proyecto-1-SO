/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Companies.Company;
import Rules.DellRules;
import Store.Drive;
import javax.accessibility.AccessibleContext;
import javax.swing.JButton;
import javax.swing.JLabel;
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
public class Dell extends javax.swing.JFrame {

    public static SimulacionDell simulacionDell;

    public Dell() {
        initComponents();

        iniciarSimulacionDell();
    }

    public void actualizarValores(int motherboards, int cpus, int rams, int powerSupplies, int gpus, int standardComputers, int computersWithGPU, int diasRestantes, double costos, String estadoPM, String estadoDirector, double sueldoPM, double sueldoDirector) {
        // Actualizar componentes producidos
        BaseCantidad.setText(String.valueOf(motherboards));
        CPUCantidad.setText(String.valueOf(cpus));
        RAMCantidad.setText(String.valueOf(rams));
        PowerSupplyCantidad.setText(String.valueOf(powerSupplies));
        GraphicsCardCantidad.setText(String.valueOf(gpus));

        BaseBar.setValue(motherboards);
        this.PowerSupplyBar.setValue(powerSupplies);
        this.CPUBar.setValue(cpus);
        this.RAMBar.setValue(rams);
        this.GraphicsCardBar.setValue(gpus);

        // Actualizar computadoras ensambladas
        CompEstandarCantidad.setText(String.valueOf(standardComputers));
        CompGraficaCantidad.setText(String.valueOf(computersWithGPU));

        // Actualizar días restantes
        JLabel18.setText("Días restantes para la entrega: " + diasRestantes);

        // Actualizar costos
        CostosValor.setText(String.format("%.2f", costos));

        // Actualizar estado del PM y director
        EstadosPM.setText(estadoPM);
        EstadoDirector.setText(estadoDirector);

        SueldoPM.setText(String.valueOf(sueldoPM));
        SueldoDirector.setText(String.valueOf(sueldoDirector));
    }

    public void actualizarEstadoDirector(String estado) {
        EstadoDirector.setText(estado);  // Aquí actualizas el JLabel con el estado actual
    }

    public void actualizarSueldos(float sueldoDirector, float sueldoPM) {
        SueldoDirector.setText(String.format("%.2f", sueldoDirector));
        SueldoPM.setText(String.format("%.2f", sueldoPM));
    }

    public void actualizarGananciaYUtilidad(double ganancia, double utilidad) {
        // Actualizar los campos de ganancia y utilidad en la interfaz gráfica
        this.GananciasValor.setText(String.format("%.2f", ganancia));
        this.UtilidadValor.setText(String.format("%.2f%%", utilidad));  // Mostrar como porcentaje
    }

    public void actualizarCostosComponentes(double costoMotherboards, double costoCPUs, double costoRAM, double costoPowerSupply, double costoGPU) {
        // Actualizar los costos en los JTextFields correspondientes de la interfaz
        this.BaseCostos.setText(String.format("%.2f", costoMotherboards));
        this.CPUCostos.setText(String.format("%.2f", costoCPUs));
        this.RAMCostos.setText(String.format("%.2f", costoRAM));
        this.PowerSupplyCostos.setText(String.format("%.2f", costoPowerSupply));
        this.PowerSupplyCostos1.setText(String.format("%.2f", costoGPU));
    }

    // Método para iniciar la simulación de Dell
    private void iniciarSimulacionDell() {
        // Crear y configurar la simulación aquí
        DellRules dellRules = new DellRules();
        Drive dellDrive = new Drive(0, 0, 0, 0, 0);
        Global.daysBetweenReleases = 30;

        // Número de empleados de Dell (usar valores globales para Dell)
        int numMotherboardProducers = Global.MotherboardProducersDell;
        int numCPUProducers = Global.CPUProducerDell;
        int numRAMProducers = Global.RAMProducersDell;
        int numPowerSupplyProducers = Global.PowerSupplyProducersDell;
        int numGPUProducers = Global.GPUProducersDell;
        int numAssemblers = Global.AssemblersDell;

        // Crear la compañía Dell
        Company dellCompany = new Company(
                numMotherboardProducers, numCPUProducers, numRAMProducers,
                numPowerSupplyProducers, numGPUProducers, numAssemblers,
                dellDrive, dellRules
        );

        // Crear e iniciar la simulación
        simulacionDell = new SimulacionDell(this, dellCompany);
        simulacionDell.start();

        // Actualizar los campos de la interfaz gráfica de Dell
        this.BaseTrab.setText(String.valueOf(numMotherboardProducers));
        this.PowerSupplyTrab.setText(String.valueOf(numPowerSupplyProducers));
        this.CPUTrab.setText(String.valueOf(numCPUProducers));
        this.RAMTrab.setText(String.valueOf(numRAMProducers));
        this.GraphicsCardTrab.setText(String.valueOf(numGPUProducers));
        this.GraphicsCardTrab1.setText(String.valueOf(numAssemblers));
    }

    // Método para detener la simulación y todos los hilos
    private void detenerHilosSimulacion() {
        if (simulacionDell != null && simulacionDell.isAlive()) {
            simulacionDell.detenerHilos();  // Llama al método detenerHilos() de SimulacionDell
            simulacionDell.interrupt();  // Interrumpe el hilo de simulación
        }
    }

    // Método que se ejecuta cuando el usuario quiere salir de la interfaz (por ejemplo, al cerrar o al presionar un botón)
    private void salir() {
        Global.daysBetweenReleases = 30;
        detenerHilosSimulacion();  // Detener todos los hilos antes de salir
        this.dispose();  // Cerrar la ventana
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        JLabel6 = new javax.swing.JLabel();
        JLabel7 = new javax.swing.JLabel();
        JLabel8 = new javax.swing.JLabel();
        CantidadTrabajadores = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        JLabel9 = new javax.swing.JLabel();
        JLabel10 = new javax.swing.JLabel();
        JLabel11 = new javax.swing.JLabel();
        BaseCostos = new javax.swing.JTextField();
        BaseCantidad = new javax.swing.JTextField();
        DescontadoPM = new javax.swing.JTextField();
        FaltasPM = new javax.swing.JTextField();
        EstadosPM = new javax.swing.JTextField();
        JLabel16 = new javax.swing.JLabel();
        JLabel17 = new javax.swing.JLabel();
        JLabel19 = new javax.swing.JLabel();
        JLabel21 = new javax.swing.JLabel();
        JLabel23 = new javax.swing.JLabel();
        JLabel27 = new javax.swing.JLabel();
        BaseTrab = new javax.swing.JTextField();
        PowerSupplyCostos1 = new javax.swing.JTextField();
        JLabel24 = new javax.swing.JLabel();
        CompGraficaCantidad = new javax.swing.JTextField();
        CompEstandarCantidad = new javax.swing.JTextField();
        GraphicsCardCantidad = new javax.swing.JTextField();
        GraphicsCardBar = new javax.swing.JProgressBar();
        PowerSupplyCostos = new javax.swing.JTextField();
        PowerSupplyBar = new javax.swing.JProgressBar();
        PowerSupplyCantidad = new javax.swing.JTextField();
        JLabel22 = new javax.swing.JLabel();
        RAMCostos = new javax.swing.JTextField();
        RAMBar = new javax.swing.JProgressBar();
        JLabel20 = new javax.swing.JLabel();
        RAMCantidad = new javax.swing.JTextField();
        CPUCantidad = new javax.swing.JTextField();
        CPUBar = new javax.swing.JProgressBar();
        JLabel18 = new javax.swing.JLabel();
        CPUCostos = new javax.swing.JTextField();
        UtilidadValor = new javax.swing.JTextField();
        CostosValor = new javax.swing.JTextField();
        GananciasValor = new javax.swing.JTextField();
        JLabel12 = new javax.swing.JLabel();
        SueldoPM = new javax.swing.JTextField();
        JLabel13 = new javax.swing.JLabel();
        SueldoDirector = new javax.swing.JTextField();
        JLabel15 = new javax.swing.JLabel();
        JLabel14 = new javax.swing.JLabel();
        JLabel25 = new javax.swing.JLabel();
        JLabel26 = new javax.swing.JLabel();
        BaseBar = new javax.swing.JProgressBar();
        EstadoDirector = new javax.swing.JTextField();
        JLabel28 = new javax.swing.JLabel();
        JLabel29 = new javax.swing.JLabel();
        JLabel30 = new javax.swing.JLabel();
        GraphicsCardTrab1 = new javax.swing.JTextField();
        JLabel32 = new javax.swing.JLabel();
        JLabel31 = new javax.swing.JLabel();
        JLabel33 = new javax.swing.JLabel();
        GraphicsCardTrab = new javax.swing.JTextField();
        PowerSupplyTrab = new javax.swing.JTextField();
        RAMTrab = new javax.swing.JTextField();
        CPUTrab = new javax.swing.JTextField();
        JLabel34 = new javax.swing.JLabel();
        jTextField41 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jTextField40 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jTextField39 = new javax.swing.JTextField();
        jTextField37 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField36 = new javax.swing.JTextField();
        jTextField38 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 125, 184));
        jPanel4.setPreferredSize(new java.awt.Dimension(800, 60));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 144, 212));
        jButton1.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("⬅");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 255), new java.awt.Color(0, 116, 185)));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Dell.png"))); // NOI18N
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 100, 60));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 125, 184));
        jTextField1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Simulación Dell");
        jTextField1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.blue, java.awt.Color.blue));
        jTextField1.setFocusable(false);
        jPanel4.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 400, 60));

        jTextField7.setEditable(false);
        jTextField7.setBackground(new java.awt.Color(0, 125, 184));
        jTextField7.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setText("Configuración");
        jTextField7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.blue, java.awt.Color.blue));
        jTextField7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTextField7.setFocusable(false);
        jTextField7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField7MousePressed(evt);
            }
        });
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 240, 60));

        jTextField8.setBackground(new java.awt.Color(174, 182, 196));
        jTextField8.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText(" X");
        jTextField8.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 40, 30));

        jTextField12.setBackground(new java.awt.Color(211, 216, 226));
        jTextField12.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 380, 280));

        jTextField10.setBackground(new java.awt.Color(174, 182, 196));
        jTextField10.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setText(" —");
        jTextField10.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 40, 30));

        jTextField9.setBackground(new java.awt.Color(174, 182, 196));
        jTextField9.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setText(" ▢");
        jTextField9.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 40, 30));

        jTextField11.setBackground(new java.awt.Color(174, 182, 196));
        jTextField11.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 380, 30));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        JLabel6.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        JLabel6.setForeground(new java.awt.Color(51, 51, 51));
        JLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel6.setText("Utilidad:");
        jPanel3.add(JLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 160, 30));

        JLabel7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        JLabel7.setForeground(new java.awt.Color(51, 51, 51));
        JLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel7.setText("Costos:");
        jPanel3.add(JLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 90, 20));

        JLabel8.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        JLabel8.setForeground(new java.awt.Color(51, 51, 51));
        JLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel8.setText("Costos:");
        jPanel3.add(JLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 160, 30));

        CantidadTrabajadores.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        CantidadTrabajadores.setForeground(new java.awt.Color(51, 51, 51));
        CantidadTrabajadores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CantidadTrabajadores.setText("18");
        jPanel3.add(CantidadTrabajadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 380, 80, 30));

        jSeparator1.setForeground(new java.awt.Color(174, 182, 196));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 340, 10));

        JLabel9.setFont(new java.awt.Font("SansSerif", 3, 14)); // NOI18N
        JLabel9.setForeground(new java.awt.Color(51, 51, 51));
        JLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel9.setText("Días restantes para la entrega:");
        jPanel3.add(JLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 570, 250, 30));

        JLabel10.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        JLabel10.setForeground(new java.awt.Color(51, 51, 51));
        JLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel10.setText("Faltas:");
        jPanel3.add(JLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 80, 20));

        JLabel11.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        JLabel11.setForeground(new java.awt.Color(51, 51, 51));
        JLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel11.setText("Descontado: $");
        jPanel3.add(JLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 130, 20));

        BaseCostos.setBackground(new java.awt.Color(231, 235, 242));
        BaseCostos.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        BaseCostos.setForeground(new java.awt.Color(51, 51, 51));
        BaseCostos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BaseCostos.setText("0");
        BaseCostos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        BaseCostos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BaseCostosActionPerformed(evt);
            }
        });
        jPanel3.add(BaseCostos, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 70, 20));

        BaseCantidad.setBackground(new java.awt.Color(231, 235, 242));
        BaseCantidad.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        BaseCantidad.setForeground(new java.awt.Color(51, 51, 51));
        BaseCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BaseCantidad.setText("0");
        BaseCantidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        BaseCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BaseCantidadActionPerformed(evt);
            }
        });
        jPanel3.add(BaseCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 50, 20));

        DescontadoPM.setBackground(new java.awt.Color(231, 235, 242));
        DescontadoPM.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        DescontadoPM.setForeground(new java.awt.Color(51, 51, 51));
        DescontadoPM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DescontadoPM.setText("0");
        DescontadoPM.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        jPanel3.add(DescontadoPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, 60, 20));

        FaltasPM.setBackground(new java.awt.Color(231, 235, 242));
        FaltasPM.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        FaltasPM.setForeground(new java.awt.Color(51, 51, 51));
        FaltasPM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FaltasPM.setText("0");
        FaltasPM.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        jPanel3.add(FaltasPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 60, 20));

        EstadosPM.setBackground(new java.awt.Color(231, 235, 242));
        EstadosPM.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        EstadosPM.setForeground(new java.awt.Color(51, 51, 51));
        EstadosPM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EstadosPM.setText("0");
        EstadosPM.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        jPanel3.add(EstadosPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 130, 20));

        JLabel16.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        JLabel16.setForeground(new java.awt.Color(51, 51, 51));
        JLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel16.setText("Base:");
        jPanel3.add(JLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 70, 20));

        JLabel17.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        JLabel17.setForeground(new java.awt.Color(51, 51, 51));
        JLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel17.setText("CPU:");
        jPanel3.add(JLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 70, 20));

        JLabel19.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        JLabel19.setForeground(new java.awt.Color(51, 51, 51));
        JLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel19.setText("Costos:");
        jPanel3.add(JLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, 90, 20));

        JLabel21.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        JLabel21.setForeground(new java.awt.Color(51, 51, 51));
        JLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel21.setText("Costos:");
        jPanel3.add(JLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 90, 20));

        JLabel23.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        JLabel23.setForeground(new java.awt.Color(51, 51, 51));
        JLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel23.setText("Tarjeta Gráfica:");
        jPanel3.add(JLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 330, 100, 20));

        JLabel27.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        JLabel27.setForeground(new java.awt.Color(51, 51, 51));
        JLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel27.setText("Base:");
        jPanel3.add(JLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, 70, 20));

        BaseTrab.setBackground(new java.awt.Color(231, 235, 242));
        BaseTrab.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        BaseTrab.setForeground(new java.awt.Color(51, 51, 51));
        BaseTrab.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BaseTrab.setText("0");
        BaseTrab.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        BaseTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BaseTrabActionPerformed(evt);
            }
        });
        jPanel3.add(BaseTrab, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 440, 60, 20));

        PowerSupplyCostos1.setBackground(new java.awt.Color(231, 235, 242));
        PowerSupplyCostos1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        PowerSupplyCostos1.setForeground(new java.awt.Color(51, 51, 51));
        PowerSupplyCostos1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PowerSupplyCostos1.setText("0");
        PowerSupplyCostos1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        PowerSupplyCostos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PowerSupplyCostos1ActionPerformed(evt);
            }
        });
        jPanel3.add(PowerSupplyCostos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 250, 70, 20));

        JLabel24.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        JLabel24.setForeground(new java.awt.Color(51, 51, 51));
        JLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel24.setText("Graphics Card:");
        jPanel3.add(JLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 110, 20));

        CompGraficaCantidad.setBackground(new java.awt.Color(231, 235, 242));
        CompGraficaCantidad.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        CompGraficaCantidad.setForeground(new java.awt.Color(51, 51, 51));
        CompGraficaCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CompGraficaCantidad.setText("0");
        CompGraficaCantidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        CompGraficaCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompGraficaCantidadActionPerformed(evt);
            }
        });
        jPanel3.add(CompGraficaCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 330, 50, 20));

        CompEstandarCantidad.setBackground(new java.awt.Color(231, 235, 242));
        CompEstandarCantidad.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        CompEstandarCantidad.setForeground(new java.awt.Color(51, 51, 51));
        CompEstandarCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CompEstandarCantidad.setText("0");
        CompEstandarCantidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        CompEstandarCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompEstandarCantidadActionPerformed(evt);
            }
        });
        jPanel3.add(CompEstandarCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 300, 50, 20));

        GraphicsCardCantidad.setBackground(new java.awt.Color(231, 235, 242));
        GraphicsCardCantidad.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        GraphicsCardCantidad.setForeground(new java.awt.Color(51, 51, 51));
        GraphicsCardCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        GraphicsCardCantidad.setText("0");
        GraphicsCardCantidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        GraphicsCardCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraphicsCardCantidadActionPerformed(evt);
            }
        });
        jPanel3.add(GraphicsCardCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 200, 50, 20));

        GraphicsCardBar.setBackground(new java.awt.Color(174, 182, 196));
        GraphicsCardBar.setPreferredSize(new java.awt.Dimension(160, 30));
        jPanel3.add(GraphicsCardBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, -1, 30));

        PowerSupplyCostos.setBackground(new java.awt.Color(231, 235, 242));
        PowerSupplyCostos.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        PowerSupplyCostos.setForeground(new java.awt.Color(51, 51, 51));
        PowerSupplyCostos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PowerSupplyCostos.setText("0");
        PowerSupplyCostos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        PowerSupplyCostos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PowerSupplyCostosActionPerformed(evt);
            }
        });
        jPanel3.add(PowerSupplyCostos, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 170, 70, 20));

        PowerSupplyBar.setBackground(new java.awt.Color(174, 182, 196));
        PowerSupplyBar.setPreferredSize(new java.awt.Dimension(160, 30));
        jPanel3.add(PowerSupplyBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, -1, 30));

        PowerSupplyCantidad.setBackground(new java.awt.Color(231, 235, 242));
        PowerSupplyCantidad.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        PowerSupplyCantidad.setForeground(new java.awt.Color(51, 51, 51));
        PowerSupplyCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PowerSupplyCantidad.setText("0");
        PowerSupplyCantidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        PowerSupplyCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PowerSupplyCantidadActionPerformed(evt);
            }
        });
        jPanel3.add(PowerSupplyCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, 50, 20));

        JLabel22.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        JLabel22.setForeground(new java.awt.Color(51, 51, 51));
        JLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel22.setText("Power Supply: ");
        jPanel3.add(JLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, 110, 20));

        RAMCostos.setBackground(new java.awt.Color(231, 235, 242));
        RAMCostos.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        RAMCostos.setForeground(new java.awt.Color(51, 51, 51));
        RAMCostos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        RAMCostos.setText("0");
        RAMCostos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        RAMCostos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAMCostosActionPerformed(evt);
            }
        });
        jPanel3.add(RAMCostos, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 70, 20));

        RAMBar.setBackground(new java.awt.Color(174, 182, 196));
        RAMBar.setPreferredSize(new java.awt.Dimension(160, 30));
        jPanel3.add(RAMBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, -1, 30));

        JLabel20.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        JLabel20.setForeground(new java.awt.Color(51, 51, 51));
        JLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel20.setText("RAM:");
        jPanel3.add(JLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 70, 20));

        RAMCantidad.setBackground(new java.awt.Color(231, 235, 242));
        RAMCantidad.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        RAMCantidad.setForeground(new java.awt.Color(51, 51, 51));
        RAMCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        RAMCantidad.setText("0");
        RAMCantidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        RAMCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAMCantidadActionPerformed(evt);
            }
        });
        jPanel3.add(RAMCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 50, 20));

        CPUCantidad.setBackground(new java.awt.Color(231, 235, 242));
        CPUCantidad.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        CPUCantidad.setForeground(new java.awt.Color(51, 51, 51));
        CPUCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CPUCantidad.setText("0");
        CPUCantidad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        CPUCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPUCantidadActionPerformed(evt);
            }
        });
        jPanel3.add(CPUCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, 50, 20));

        CPUBar.setBackground(new java.awt.Color(174, 182, 196));
        CPUBar.setPreferredSize(new java.awt.Dimension(160, 30));
        jPanel3.add(CPUBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, -1, 30));

        JLabel18.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        JLabel18.setForeground(new java.awt.Color(51, 51, 51));
        JLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabel18.setText("0");
        jPanel3.add(JLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 570, 390, 30));

        CPUCostos.setBackground(new java.awt.Color(231, 235, 242));
        CPUCostos.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        CPUCostos.setForeground(new java.awt.Color(51, 51, 51));
        CPUCostos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CPUCostos.setText("0");
        CPUCostos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        CPUCostos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPUCostosActionPerformed(evt);
            }
        });
        jPanel3.add(CPUCostos, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 70, 20));

        UtilidadValor.setBackground(new java.awt.Color(231, 235, 242));
        UtilidadValor.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        UtilidadValor.setForeground(new java.awt.Color(51, 51, 51));
        UtilidadValor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        UtilidadValor.setText("0");
        UtilidadValor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        jPanel3.add(UtilidadValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 160, 30));

        CostosValor.setBackground(new java.awt.Color(231, 235, 242));
        CostosValor.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        CostosValor.setForeground(new java.awt.Color(51, 51, 51));
        CostosValor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CostosValor.setText("0");
        CostosValor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        jPanel3.add(CostosValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 160, 30));

        GananciasValor.setBackground(new java.awt.Color(231, 235, 242));
        GananciasValor.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        GananciasValor.setForeground(new java.awt.Color(51, 51, 51));
        GananciasValor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        GananciasValor.setText("0");
        GananciasValor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        jPanel3.add(GananciasValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 160, 30));

        JLabel12.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        JLabel12.setForeground(new java.awt.Color(51, 51, 51));
        JLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel12.setText("Sueldo acumulado: ");
        jPanel3.add(JLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 160, 20));

        SueldoPM.setBackground(new java.awt.Color(231, 235, 242));
        SueldoPM.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        SueldoPM.setForeground(new java.awt.Color(51, 51, 51));
        SueldoPM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SueldoPM.setText("0");
        SueldoPM.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        jPanel3.add(SueldoPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 160, 20));

        JLabel13.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        JLabel13.setForeground(new java.awt.Color(51, 51, 51));
        JLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel13.setText("Sueldo acumulado: ");
        jPanel3.add(JLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 160, 20));

        SueldoDirector.setBackground(new java.awt.Color(231, 235, 242));
        SueldoDirector.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        SueldoDirector.setForeground(new java.awt.Color(51, 51, 51));
        SueldoDirector.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SueldoDirector.setText("0");
        SueldoDirector.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        jPanel3.add(SueldoDirector, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, 160, 20));

        JLabel15.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        JLabel15.setForeground(new java.awt.Color(51, 51, 51));
        JLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel15.setText("Ganancias:");
        jPanel3.add(JLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 220, 30));

        JLabel14.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        JLabel14.setForeground(new java.awt.Color(51, 51, 51));
        JLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel14.setText("Estado Director:");
        jPanel3.add(JLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 130, 20));

        JLabel25.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        JLabel25.setForeground(new java.awt.Color(51, 51, 51));
        JLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel25.setText("Costos:");
        jPanel3.add(JLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 90, 20));

        JLabel26.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        JLabel26.setForeground(new java.awt.Color(51, 51, 51));
        JLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel26.setText("Estándar:");
        jPanel3.add(JLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 305, 90, -1));

        BaseBar.setBackground(new java.awt.Color(174, 182, 196));
        BaseBar.setPreferredSize(new java.awt.Dimension(160, 30));
        jPanel3.add(BaseBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, -1, 30));

        EstadoDirector.setBackground(new java.awt.Color(231, 235, 242));
        EstadoDirector.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        EstadoDirector.setForeground(new java.awt.Color(51, 51, 51));
        EstadoDirector.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        EstadoDirector.setText("0");
        EstadoDirector.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        jPanel3.add(EstadoDirector, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, 130, 20));

        JLabel28.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        JLabel28.setForeground(new java.awt.Color(51, 51, 51));
        JLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel28.setText("Power Supply:");
        jPanel3.add(JLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 440, 130, 20));

        JLabel29.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        JLabel29.setForeground(new java.awt.Color(51, 51, 51));
        JLabel29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel29.setText("RAM:");
        jPanel3.add(JLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 500, 70, 20));

        JLabel30.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        JLabel30.setForeground(new java.awt.Color(51, 51, 51));
        JLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel30.setText("CPU:");
        jPanel3.add(JLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 470, 70, 20));

        GraphicsCardTrab1.setBackground(new java.awt.Color(231, 235, 242));
        GraphicsCardTrab1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        GraphicsCardTrab1.setForeground(new java.awt.Color(51, 51, 51));
        GraphicsCardTrab1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        GraphicsCardTrab1.setText("0");
        GraphicsCardTrab1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        GraphicsCardTrab1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraphicsCardTrab1ActionPerformed(evt);
            }
        });
        jPanel3.add(GraphicsCardTrab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 500, 60, 20));

        JLabel32.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        JLabel32.setForeground(new java.awt.Color(51, 51, 51));
        JLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel32.setText("Assembler:");
        jPanel3.add(JLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 500, 130, 20));

        JLabel31.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        JLabel31.setForeground(new java.awt.Color(51, 51, 51));
        JLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel31.setText("Graphics Card:");
        jPanel3.add(JLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 470, 130, 20));

        JLabel33.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        JLabel33.setForeground(new java.awt.Color(51, 51, 51));
        JLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel33.setText("Estado PM:");
        jPanel3.add(JLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 130, 20));

        GraphicsCardTrab.setBackground(new java.awt.Color(231, 235, 242));
        GraphicsCardTrab.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        GraphicsCardTrab.setForeground(new java.awt.Color(51, 51, 51));
        GraphicsCardTrab.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        GraphicsCardTrab.setText("0");
        GraphicsCardTrab.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        GraphicsCardTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraphicsCardTrabActionPerformed(evt);
            }
        });
        jPanel3.add(GraphicsCardTrab, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 470, 60, 20));

        PowerSupplyTrab.setBackground(new java.awt.Color(231, 235, 242));
        PowerSupplyTrab.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        PowerSupplyTrab.setForeground(new java.awt.Color(51, 51, 51));
        PowerSupplyTrab.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PowerSupplyTrab.setText("0");
        PowerSupplyTrab.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        PowerSupplyTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PowerSupplyTrabActionPerformed(evt);
            }
        });
        jPanel3.add(PowerSupplyTrab, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 440, 60, 20));

        RAMTrab.setBackground(new java.awt.Color(231, 235, 242));
        RAMTrab.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        RAMTrab.setForeground(new java.awt.Color(51, 51, 51));
        RAMTrab.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        RAMTrab.setText("0");
        RAMTrab.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        RAMTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RAMTrabActionPerformed(evt);
            }
        });
        jPanel3.add(RAMTrab, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 500, 60, 20));

        CPUTrab.setBackground(new java.awt.Color(231, 235, 242));
        CPUTrab.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        CPUTrab.setForeground(new java.awt.Color(51, 51, 51));
        CPUTrab.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CPUTrab.setText("0");
        CPUTrab.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.darkGray, java.awt.Color.darkGray));
        CPUTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPUTrabActionPerformed(evt);
            }
        });
        jPanel3.add(CPUTrab, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 470, 60, 20));

        JLabel34.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        JLabel34.setForeground(new java.awt.Color(51, 51, 51));
        JLabel34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel34.setText("Costos:");
        jPanel3.add(JLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 90, 20));

        jTextField41.setEditable(false);
        jTextField41.setBackground(new java.awt.Color(231, 235, 242));
        jTextField41.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jTextField41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField41ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField41, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 570, 640, 30));

        jTextField35.setBackground(new java.awt.Color(174, 182, 196));
        jTextField35.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        jTextField35.setForeground(new java.awt.Color(51, 51, 51));
        jTextField35.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField35.setText("  Computadoras");
        jTextField35.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField35ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField35, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, 180, 20));

        jTextField29.setBackground(new java.awt.Color(174, 182, 196));
        jTextField29.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jTextField29.setForeground(new java.awt.Color(51, 51, 51));
        jTextField29.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField29.setText("  Información de Producción");
        jTextField29.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField29ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField29, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 270, 30));

        jTextField40.setEditable(false);
        jTextField40.setBackground(new java.awt.Color(231, 235, 242));
        jTextField40.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jTextField40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField40ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField40, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, 180, 80));

        jTextField27.setBackground(new java.awt.Color(174, 182, 196));
        jTextField27.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jTextField27.setForeground(new java.awt.Color(51, 51, 51));
        jTextField27.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField27.setText("  Project Manager/Director");
        jTextField27.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField27ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 260, 30));

        jTextField39.setEditable(false);
        jTextField39.setBackground(new java.awt.Color(231, 235, 242));
        jTextField39.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jTextField39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField39ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 360, 210));

        jTextField37.setEditable(false);
        jTextField37.setBackground(new java.awt.Color(231, 235, 242));
        jTextField37.setForeground(new java.awt.Color(51, 51, 51));
        jTextField37.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jTextField37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField37ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField37, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, 370, 120));

        jTextField28.setBackground(new java.awt.Color(174, 182, 196));
        jTextField28.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jTextField28.setForeground(new java.awt.Color(51, 51, 51));
        jTextField28.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField28.setText("  Estadísticas");
        jTextField28.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField28ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 260, 30));

        jTextField21.setBackground(new java.awt.Color(174, 182, 196));
        jTextField21.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jTextField21.setForeground(new java.awt.Color(51, 51, 51));
        jTextField21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField21.setText(" —");
        jTextField21.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField21ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 560, 40, 50));

        jTextField36.setEditable(false);
        jTextField36.setBackground(new java.awt.Color(231, 235, 242));
        jTextField36.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jTextField36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField36ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 360, 140));

        jTextField38.setEditable(false);
        jTextField38.setBackground(new java.awt.Color(231, 235, 242));
        jTextField38.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jTextField38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField38ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField38, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 370, 250));

        jTextField20.setBackground(new java.awt.Color(174, 182, 196));
        jTextField20.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jTextField20.setForeground(new java.awt.Color(51, 51, 51));
        jTextField20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField20.setText(" ▢");
        jTextField20.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField20ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 40, 50));

        jTextField19.setBackground(new java.awt.Color(174, 182, 196));
        jTextField19.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jTextField19.setForeground(new java.awt.Color(51, 51, 51));
        jTextField19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField19.setText(" X");
        jTextField19.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField19ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 40, 50));

        jTextField18.setBackground(new java.awt.Color(211, 216, 226));
        jTextField18.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 780, 50));

        jTextField5.setBackground(new java.awt.Color(174, 182, 196));
        jTextField5.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(51, 51, 51));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText(" X");
        jTextField5.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 40, 30));

        jTextField6.setBackground(new java.awt.Color(174, 182, 196));
        jTextField6.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(51, 51, 51));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText(" ▢");
        jTextField6.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 40, 30));

        jTextField4.setBackground(new java.awt.Color(174, 182, 196));
        jTextField4.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(51, 51, 51));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText(" —");
        jTextField4.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 40, 30));

        jTextField2.setBackground(new java.awt.Color(174, 182, 196));
        jTextField2.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 380, 30));

        jTextField3.setBackground(new java.awt.Color(211, 216, 226));
        jTextField3.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 380, 190));

        jTextField13.setBackground(new java.awt.Color(174, 182, 196));
        jTextField13.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jTextField13.setForeground(new java.awt.Color(51, 51, 51));
        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13.setText(" X");
        jTextField13.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 40, 30));

        jTextField14.setBackground(new java.awt.Color(174, 182, 196));
        jTextField14.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jTextField14.setForeground(new java.awt.Color(51, 51, 51));
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14.setText(" ▢");
        jTextField14.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 40, 30));

        jTextField15.setBackground(new java.awt.Color(174, 182, 196));
        jTextField15.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jTextField15.setForeground(new java.awt.Color(51, 51, 51));
        jTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField15.setText(" —");
        jTextField15.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 40, 30));

        jTextField16.setBackground(new java.awt.Color(174, 182, 196));
        jTextField16.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 380, 30));

        jTextField17.setBackground(new java.awt.Color(211, 216, 226));
        jTextField17.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 380, 260));

        jTextField24.setBackground(new java.awt.Color(174, 182, 196));
        jTextField24.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jTextField24.setForeground(new java.awt.Color(51, 51, 51));
        jTextField24.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField24.setText(" —");
        jTextField24.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField24ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 40, 30));

        jTextField25.setBackground(new java.awt.Color(174, 182, 196));
        jTextField25.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jTextField25.setForeground(new java.awt.Color(51, 51, 51));
        jTextField25.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField25.setText(" ▢");
        jTextField25.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField25ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 40, 30));

        jTextField26.setBackground(new java.awt.Color(174, 182, 196));
        jTextField26.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jTextField26.setForeground(new java.awt.Color(51, 51, 51));
        jTextField26.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField26.setText(" X");
        jTextField26.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField26ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField26, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 40, 30));

        jTextField23.setBackground(new java.awt.Color(174, 182, 196));
        jTextField23.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField23ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 380, 30));

        jTextField22.setBackground(new java.awt.Color(211, 216, 226));
        jTextField22.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jTextField22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField22ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 390, 300));

        jTextField31.setBackground(new java.awt.Color(174, 182, 196));
        jTextField31.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jTextField31.setForeground(new java.awt.Color(51, 51, 51));
        jTextField31.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField31.setText("  Trabajadores");
        jTextField31.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField31ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField31, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 270, 30));

        jTextField32.setBackground(new java.awt.Color(174, 182, 196));
        jTextField32.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jTextField32.setForeground(new java.awt.Color(51, 51, 51));
        jTextField32.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField32.setText(" —");
        jTextField32.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField32ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField32, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, 40, 30));

        jTextField33.setBackground(new java.awt.Color(174, 182, 196));
        jTextField33.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jTextField33.setForeground(new java.awt.Color(51, 51, 51));
        jTextField33.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField33.setText(" ▢");
        jTextField33.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField33ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField33, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 40, 30));

        jTextField34.setBackground(new java.awt.Color(174, 182, 196));
        jTextField34.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jTextField34.setForeground(new java.awt.Color(51, 51, 51));
        jTextField34.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField34.setText(" X");
        jTextField34.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.darkGray));
        jTextField34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField34ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField34, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, 40, 30));

        jTextField30.setBackground(new java.awt.Color(211, 216, 226));
        jTextField30.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        jTextField30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField30ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField30, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, 390, 170));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void BaseCostosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BaseCostosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BaseCostosActionPerformed

    private void BaseCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BaseCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BaseCantidadActionPerformed

    private void BaseTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BaseTrabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BaseTrabActionPerformed

    private void PowerSupplyCostos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PowerSupplyCostos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PowerSupplyCostos1ActionPerformed

    private void CompGraficaCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompGraficaCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CompGraficaCantidadActionPerformed

    private void CompEstandarCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompEstandarCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CompEstandarCantidadActionPerformed

    private void GraphicsCardCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraphicsCardCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GraphicsCardCantidadActionPerformed

    private void PowerSupplyCostosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PowerSupplyCostosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PowerSupplyCostosActionPerformed

    private void PowerSupplyCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PowerSupplyCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PowerSupplyCantidadActionPerformed

    private void RAMCostosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAMCostosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RAMCostosActionPerformed

    private void RAMCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAMCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RAMCantidadActionPerformed

    private void CPUCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPUCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPUCantidadActionPerformed

    private void CPUCostosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPUCostosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPUCostosActionPerformed

    private void GraphicsCardTrab1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraphicsCardTrab1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GraphicsCardTrab1ActionPerformed

    private void GraphicsCardTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GraphicsCardTrabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GraphicsCardTrabActionPerformed

    private void PowerSupplyTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PowerSupplyTrabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PowerSupplyTrabActionPerformed

    private void RAMTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RAMTrabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RAMTrabActionPerformed

    private void CPUTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPUTrabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPUTrabActionPerformed

    private void jTextField41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField41ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField41ActionPerformed

    private void jTextField35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField35ActionPerformed

    private void jTextField29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField29ActionPerformed

    private void jTextField40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField40ActionPerformed

    private void jTextField27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField27ActionPerformed

    private void jTextField39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField39ActionPerformed

    private void jTextField37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField37ActionPerformed

    private void jTextField28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField28ActionPerformed

    private void jTextField21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField21ActionPerformed

    private void jTextField36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField36ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField36ActionPerformed

    private void jTextField38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField38ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField38ActionPerformed

    private void jTextField20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20ActionPerformed

    private void jTextField19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19ActionPerformed

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void jTextField24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField24ActionPerformed

    private void jTextField25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField25ActionPerformed

    private void jTextField26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField26ActionPerformed

    private void jTextField23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23ActionPerformed

    private void jTextField22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22ActionPerformed

    private void jTextField31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField31ActionPerformed

    private void jTextField32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField32ActionPerformed

    private void jTextField33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField33ActionPerformed

    private void jTextField34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField34ActionPerformed

    private void jTextField30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField30ActionPerformed

    private void jTextField7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField7MousePressed
        // TODO add your handling code here:
        VEjecDell valoresEjecucion = new VEjecDell();
        valoresEjecucion.setLocationRelativeTo(null);
        valoresEjecucion.setResizable(false);
        valoresEjecucion.setVisible(true);
    }//GEN-LAST:event_jTextField7MousePressed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Menu ventana = new Menu();
        this.setVisible(false);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        VEjecDell config = new VEjecDell();
    }//GEN-LAST:event_jTextField7ActionPerformed

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
            java.util.logging.Logger.getLogger(Dell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dell.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dell().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar BaseBar;
    private javax.swing.JTextField BaseCantidad;
    private javax.swing.JTextField BaseCostos;
    private javax.swing.JTextField BaseTrab;
    private javax.swing.JProgressBar CPUBar;
    private javax.swing.JTextField CPUCantidad;
    private javax.swing.JTextField CPUCostos;
    private javax.swing.JTextField CPUTrab;
    private javax.swing.JLabel CantidadTrabajadores;
    private javax.swing.JTextField CompEstandarCantidad;
    private javax.swing.JTextField CompGraficaCantidad;
    private javax.swing.JTextField CostosValor;
    private javax.swing.JTextField DescontadoPM;
    private javax.swing.JTextField EstadoDirector;
    private javax.swing.JTextField EstadosPM;
    private javax.swing.JTextField FaltasPM;
    private javax.swing.JTextField GananciasValor;
    private javax.swing.JProgressBar GraphicsCardBar;
    private javax.swing.JTextField GraphicsCardCantidad;
    private javax.swing.JTextField GraphicsCardTrab;
    private javax.swing.JTextField GraphicsCardTrab1;
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
    private javax.swing.JLabel JLabel21;
    private javax.swing.JLabel JLabel22;
    private javax.swing.JLabel JLabel23;
    private javax.swing.JLabel JLabel24;
    private javax.swing.JLabel JLabel25;
    private javax.swing.JLabel JLabel26;
    private javax.swing.JLabel JLabel27;
    private javax.swing.JLabel JLabel28;
    private javax.swing.JLabel JLabel29;
    private javax.swing.JLabel JLabel30;
    private javax.swing.JLabel JLabel31;
    private javax.swing.JLabel JLabel32;
    private javax.swing.JLabel JLabel33;
    private javax.swing.JLabel JLabel34;
    private javax.swing.JLabel JLabel6;
    private javax.swing.JLabel JLabel7;
    private javax.swing.JLabel JLabel8;
    private javax.swing.JLabel JLabel9;
    private javax.swing.JProgressBar PowerSupplyBar;
    private javax.swing.JTextField PowerSupplyCantidad;
    private javax.swing.JTextField PowerSupplyCostos;
    private javax.swing.JTextField PowerSupplyCostos1;
    private javax.swing.JTextField PowerSupplyTrab;
    private javax.swing.JProgressBar RAMBar;
    private javax.swing.JTextField RAMCantidad;
    private javax.swing.JTextField RAMCostos;
    private javax.swing.JTextField RAMTrab;
    private javax.swing.JTextField SueldoDirector;
    private javax.swing.JTextField SueldoPM;
    private javax.swing.JTextField UtilidadValor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
