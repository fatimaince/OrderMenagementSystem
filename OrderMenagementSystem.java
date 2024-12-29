
package tryingProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import java.awt.event.ActionListener;

import java.awt.event.ActionListener;

import java.awt.event.ActionListener;

import java.util.ArrayList;

public class OrderMenagementSystem {

  public static void main(String[] args) {
      API api = new API(800, 600);
      api.setUpGui();

      ProductTree orderTree = new ProductTree();
      TreeNode root = new TreeNode("root", 0);

      // Sipariş ekleme örnekleri
      ArrayList<String> order1 = new ArrayList<>(Arrays.asList("milkshake", "tea"));
      orderTree.takeNewOrder(order1);
      System.out.println("First Order: " + order1);
      orderTree.printTree();

      ArrayList<String> order2 = new ArrayList<>(Arrays.asList("cake", "Ice Coffee"));
      orderTree.takeNewOrder(order2);
      System.out.println("Second Order: " + order2);
      orderTree.printTree();

      // API'den alınan seçilen ürünler
      ArrayList<String> selectedList = api.getSelectedProducts();
      orderTree.takeNewOrder(selectedList);

      // Ürün seti sorgulama
      ArrayList<String> query1 = new ArrayList<>(Arrays.asList("milkshake", "tea"));
      int result = orderTree.queryProductSet(query1);
      System.out.println("Path count: " + result);

      // Ağaç yapısını yazdırma
      orderTree.printTree();

      // Sipariş iptali
      ArrayList<String> canceledOrder1 = new ArrayList<>(Arrays.asList("cake", "Ice Coffee"));
      orderTree.removeProducts(canceledOrder1);
      System.out.println("After canceling order: " + canceledOrder1);
      orderTree.printTree();

      // Sipariş Düğmesi Tıklandığında Seçilen Ürünleri Al ve İşle
      api.orderButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              ArrayList<String> selectedProducts = api.getSelectedProducts();
              if (!selectedProducts.isEmpty()) {
                  orderTree.takeNewOrder(selectedProducts);
                  System.out.println("Order has been saved on tree!");
              } else {
                  System.out.println("No product was selected.");
              }

              orderTree.printTree();
          }
});
}
}
