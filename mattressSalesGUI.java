/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MattressSalesGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Student
 */
public class mattressSalesGUI extends JFrame {
   

    // Declare GUI components

    private JTextField txtCustomerName;
    private JTextField txtPrice;

    private JComboBox<String> cmbProduct;

    private JButton btnProcess;

    // Constructor
    public MattressSalesGUI() {

        setTitle("Mattress Sales Application");

        setSize(450, 350);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new GridLayout(5, 2, 10, 10));

        // Customer Name
        add(new JLabel("Customer Name:"));

        txtCustomerName = new JTextField();

        add(txtCustomerName);

        // Product Selection
        add(new JLabel("Select Product:"));

        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        cmbProduct = new JComboBox<>(products);

        add(cmbProduct);

        // Product Price
        add(new JLabel("Enter Price:"));

        txtPrice = new JTextField();

        add(txtPrice);

        // Process Button
        add(new JLabel(""));

        btnProcess = new JButton("PROCESS");

        add(btnProcess);

        // Button Action
        btnProcess.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                processSale();

            }

        });

        setVisible(true);

    }

    // Process the sale
    private void processSale() {

        String customerName = txtCustomerName.getText().trim();

        String productName = (String) cmbProduct.getSelectedItem();

        // Validate customer name
        if (customerName.isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "Please enter the customer name.");

            return;

        }

        double price;

        // Validate product price
        try {

            price = Double.parseDouble(txtPrice.getText());

            if (price <= 0) {

                JOptionPane.showMessageDialog(this,
                        "Please enter a price greater than zero.");

                return;

            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(this,
                    "Please enter a valid product price.");

            return;

        }

        // Calculate VAT
        double vat = price * 0.15;

        // Calculate Commission
        double commission = price * 0.05;

        // Calculate Total Sale
        double total = price + vat + commission;

        // Display results
        String message = "Customer Name: " + customerName
                + "\nProduct: " + productName
                + "\nVAT: R " + vat
                + "\nCOMMISSION: R " + commission
                + "\nTOTAL: R " + total;

        JOptionPane.showMessageDialog(this, message);

        // Save information to data.txt
        saveToFile(customerName, productName, vat,
                commission, total);

    }

    // Save transaction to file
    private void saveToFile(String customerName,
            String productName, double vat,
            double commission, double total) {

        try {

            FileWriter writer = new FileWriter("data.txt", true);

            writer.write("DATA LOG\n");

            writer.write("******************************************\n");

            writer.write("Customer Name: " + customerName + "\n");

            writer.write("Product: " + productName + "\n");

            writer.write("VAT: R " + vat + "\n");

            writer.write("COMMISSION: R " + commission + "\n");

            writer.write("TOTAL: R " + total + "\n");

            writer.write("******************************************\n");

            writer.write("\n");

            writer.close();

            JOptionPane.showMessageDialog(this,
                    "Transaction successfully saved to data.txt");

        } catch (IOException e) {

            JOptionPane.showMessageDialog(this,
                    "Error saving transaction: " + e.getMessage());

        }

    }