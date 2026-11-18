/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.salesreport;

/**
 *
 * @author Student
 */
public class SalesReport {

    public static void main(String[] args) {
        Product product = new Product();

        PrintProduct report = new PrintProduct();

        System.out.println("PRODUCT SALES REPORT - 2026");

        System.out.println("******************************************");

        int total = product.GetTotalProductsSold();

        double average = product.GetAverageProductSold();

        String popular = product.GetMostPopularProduct();

        report.PrintTotalProductSales(total);

        report.PrintAverageProductSales(average);

        report.PrintMostPopularProduct(popular);

        System.out.println("******************************************");

    }

}
 
