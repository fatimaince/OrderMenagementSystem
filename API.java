package tryingProject;
import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.event.*;
import java.util.ArrayList;

public class API  {
    
  private final JFrame frame;
  private final int width;
  private final int height;
  private final JTabbedPane tabbedPane;
  private final JPanel rightPanel;
  private final JPanel drinks;
  private final JPanel deserts;
  public JButton orderButton;
  private JTextField welcome;
  private final JSpinner[] drinkSpinners = new JSpinner[9];
  private final JLabel[] drinkLabels = new JLabel[9];
  private final JTextField[] drinkFields = new JTextField[9]; 
  private final JSpinner[] desertSpinners = new JSpinner[9]; 
  private final JLabel[] desertLabels = new JLabel[9]; 
  private final JTextField[] desertFields = new JTextField[9];
 private final ImageIcon[] drinkIcons=new ImageIcon[9];
 private final ImageIcon[] desertIcons=new ImageIcon[9];
 private JTextField wField;
  public API(int w,int h){  
      frame=new JFrame("CAFE-CENTER");
      tabbedPane=new JTabbedPane();
      rightPanel=new JPanel();
      drinks=new JPanel(new GridLayout(3,3,10,10));
      deserts=new JPanel(new GridLayout(3,3,10,10));
      for (int i = 0; i < 9; i++) { 
      drinkSpinners[i] = new JSpinner(); 
      drinkLabels[i] = new JLabel();
      drinkFields[i] = new JTextField();
      drinks.add(drinkSpinners[i]);
      drinks.add(drinkLabels[i]); 
      drinks.add(drinkFields[i]); 
    wField=new JTextField();
    orderButton=new JButton("ORDER");
      }
    
      for (int i = 0; i < 9; i++) { 
      desertSpinners[i] = new JSpinner(); desertLabels[i] = new JLabel(); 
      desertFields[i] = new JTextField(); 
      deserts.add(desertSpinners[i]); 
      deserts.add(desertLabels[i]); 
      deserts.add(desertFields[i]); }
      
      this.width=w;
      this.height=h;
  }
  public void setUpGui(){
      frame.setTitle("CAFE-CENTER");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setBackground(Color.pink);
      frame.setVisible(true);
      frame.add(tabbedPane);
      rightPanel.setLayout(new BorderLayout());
      frame.add(rightPanel);
      tabbedPane.setBackground(new Color(255, 102, 0));
    
     rightPanel.add(wField);
     frame.setLayout(new BorderLayout());
frame.add(tabbedPane, BorderLayout.CENTER);
      tabbedPane.addTab("Drinks", drinks);
      tabbedPane.addTab("Deserts", deserts);
    
      orderButton.setBackground(new Color(255, 153, 51));
      orderButton.setLayout(new BorderLayout());
      orderButton.setText("𝒪ℛ𝒟ℰℛ");
      orderButton.setForeground(Color.red);
      
   rightPanel.add(orderButton,BorderLayout.CENTER);
    
   
   orderButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<String> selectedProducts = getSelectedProducts();
            System.out.println("Ordered Products: " + selectedProducts);
           
        }
    });
    
      for (int i = 0; i < 9; i++) {
          drinks.add(drinkLabels[i]);
          deserts.add(desertLabels[i]);
          drinkLabels[i].setOpaque(true);
          desertLabels[i].setOpaque(true);
          drinkLabels[i].setPreferredSize(new Dimension(250,220));
          desertLabels[i].setPreferredSize(new Dimension(250,250));
          drinkLabels[i].add(drinkSpinners[i]);
          desertLabels[i].add(desertSpinners[i]);
          drinkLabels[i].setBackground(new Color(255, 255, 153));
          desertLabels[i].setBackground(new Color(255, 255, 153));
          drinkFields[i].setForeground(new Color(204, 204, 0));
          desertFields[i].setForeground(new Color(204, 204, 0));
          drinkFields[i].setBounds(60, 130, 70, 30);
          desertFields[i].setBounds(60, 130, 70, 30);
           drinkSpinners[i].setBounds(150, 130, 50, 30);
           desertSpinners[i].setBounds(150, 130, 50, 30);
           drinkLabels[i].add(drinkFields[i]);
           desertLabels[i].add(desertFields[i]);
           drinkLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
           desertLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
           drinkLabels[i].setVerticalAlignment(SwingConstants.TOP);
           desertLabels[i].setVerticalAlignment(SwingConstants.TOP);
      }
      desertFields[0].setText("Tiramisu");
      desertFields[1].setText("Cheesecake");
      desertFields[2].setText("Baklava");
      desertFields[3].setText("Cake");
      desertFields[4].setText("Cookie");
      desertFields[5].setText("Magnolya");
      desertFields[6].setText("Croissant");
      desertFields[7].setText("Cupcake");
      desertFields[8].setText("Macaron");
      
      drinkFields[0].setText("Cappuchino");
       drinkFields[1].setText("Latte");
       drinkFields[2].setText("Milkshake");
       drinkFields[3].setText("Filter Coffee");
       drinkFields[4].setText("Tea");
       drinkFields[5].setText("Green Tea");
       drinkFields[6].setText("Ice Cofee");
       drinkFields[7].setText("Mocha");
       drinkFields[8].setText("Ice Tea");
      
      
    ImageIcon[] drinkIcons = { 
        new ImageIcon("src/images/images/americano.jpg"), 
        new ImageIcon("src/images/images/latte.jpg"), 
        new ImageIcon("src/images/images/milshake.jpg"), 
        new ImageIcon("src/images/images/filtre.jpg"), 
        new ImageIcon("src/images/images/çay.jpg"), 
        new ImageIcon("src/images/images/yeşilÇay.jpg"), 
        new ImageIcon("src/images/images/buzluKahve.jpg"), 
        new ImageIcon("src/images/images/mocha.jpg"), 
        new ImageIcon("src/images/images/soğukÇay.jpg"), };
    
     ImageIcon[] desertIcons = { 
        new ImageIcon("src/images/images/tiramisu.jpg"), 
        new ImageIcon("src/images/images/cheesecake.jpg"), 
        new ImageIcon("src/images/images/bakalva.jpg"), 
        new ImageIcon("src/images/images/yaşPasta.jpg"),
        new ImageIcon("src/images/images/kurabiye.jpeg"), 
        new ImageIcon("src/images/images/magnolya.jpeg"),
        new ImageIcon("src/images/images/kruvasan.jpeg"),
        new ImageIcon("src/images/images/cupcake.jpeg"),
        new ImageIcon("src/images/images/macaron.jpeg")};
      
    for (int i = 0; i < 9; i++) { 
        Image scaledImage = drinkIcons[i].getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH); 
        ImageIcon scaledIcon = new ImageIcon(scaledImage); drinkLabels[i].setIcon(scaledIcon); 
        Image desertScaledImage = desertIcons[i].getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH); 
        ImageIcon desertScaledIcon = new ImageIcon(desertScaledImage); desertLabels[i].setIcon(desertScaledIcon);
    }
      CustomLayoutManager layoutManager = new CustomLayoutManager();
        layoutManager.configureMainLayout(tabbedPane,  rightPanel, frame);
      
      drinks.setBackground(new Color(255, 153, 0));
      deserts.setBackground(new Color(255, 153, 0));
  }
  public ArrayList<String> getSelectedProducts() {
    ArrayList<String> selectedProducts = new ArrayList<>();
    for (int i = 0; i < drinkSpinners.length; i++) {
        int quantity = (int) drinkSpinners[i].getValue(); 
        String productName = drinkFields[i].getText();
        if (quantity > 0) { 
            selectedProducts.add(productName);
        }
    }
    for (int i = 0; i < desertSpinners.length; i++) {
        int quantity = (int) desertSpinners[i].getValue(); 
        String productName = desertFields[i].getText();   

        if (quantity > 0) { 
            selectedProducts.add(productName);}
    }
    return selectedProducts;}
    public static void main(String[] args) {
        
        API api=new API(800, 600);
        api.setUpGui();
    }
}