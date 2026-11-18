/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.salesreport;

/**
 *
 * @author Student
 */
public class Product implements IProduct {
    
      String[] products = {
        "Cozy Nights Monarch",
        "Restonic Barbados",
        "Sealy Phuket"
    };

    int[][] sales = {
        {25, 18, 20},
        {15, 10, 12},
        {18, 15, 20}
    };

    int[] productTotals = new int[3];

    // Calculate total products sold
    @Override
    public int GetTotalProductsSold() {

        int total = 0;

        for (int i = 0; i < sales.length; i++) {

            productTotals[i] = 0;

            for (int j = 0; j < sales[i].length; j++) {

                productTotals[i] += sales[i][j];

            }

            total += productTotals[i];
        }

        return total;
    }

    // Calculate average products sold
    @Override
    public double GetAverageProductSold() {

        int total = GetTotalProductsSold();

        return total / 9.0;
    }

    // Find the most popular product
    @Override
    public String GetMostPopularProduct() {

        GetTotalProductsSold();

        int highest = productTotals[0];
        int position = 0;

        for (int i = 1; i < productTotals.length; i++) {

            if (productTotals[i] > highest) {

                highest = productTotals[i];
                position = i;

            }
        }

        return products[position] + " (" + highest + ")";
    }

    @Override
    public int PrintTotalProductSales() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double PrintAverageProductSales() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String PrintMostPopularProduct() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
