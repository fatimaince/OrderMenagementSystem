package tryingProject;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JButton;

public class CustomLayoutManager {

    public void configureMainLayout(JTabbedPane tabbedPane, JPanel rightPanel, JFrame frame) {
        // JSplitPane ile iki paneli ayırma
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, tabbedPane, rightPanel);
        splitPane.setDividerLocation(0.5); // Pencerenin %50'si tabbedPane, %50'si rightPanel olacak şekilde ayarla
        splitPane.setEnabled(false); // JSplitPane'i sabit yapar, bölme çubuğunu hareket ettiremezsiniz

        frame.add(splitPane, BorderLayout.CENTER);
      
    }
    
}

    

