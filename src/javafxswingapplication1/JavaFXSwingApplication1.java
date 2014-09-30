/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxswingapplication1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;




/*
 * @author Beke András
 */



public class JavaFXSwingApplication1 extends JApplet {
  
  private static final int JFXPANEL_WIDTH_INT = 600;
  private static final int JFXPANEL_HEIGHT_INT = 450;
  private static JFXPanel fxContainer;

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      
      @Override
      public void run() {
        try {
          UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
          System.err.printf("Exception occured : %s", e.getMessage());
        }
        
        JFrame frame = new JFrame("JavaFX 2 in Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JApplet applet = new JavaFXSwingApplication1();
        applet.init();
        
        frame.setContentPane(applet.getContentPane());
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        applet.start();
      }
    });
  }
  
  @Override
  public void init() {
    fxContainer = new JFXPanel();
    fxContainer.setPreferredSize(new Dimension(JFXPANEL_WIDTH_INT, JFXPANEL_HEIGHT_INT));
    add(fxContainer, BorderLayout.CENTER);
    // create JavaFX scene
    Platform.runLater(new Runnable() {
      
      @Override
      public void run() {
        createScene();
      }
    });
  }
  
  private void createScene() {
    //A radio button with an empty string for its label
    RadioButton rb1 = new RadioButton();
    //Setting a text label
    rb1.setText("Home");
    //A radio button with the specified label
    RadioButton rb2 = new RadioButton("Calendar");
    
    Button btn = new Button();
    btn.setText("Mondd 'Helló Világ!'");
    btn.setOnAction(new EventHandler<ActionEvent>() {
      
      @Override
      public void handle(ActionEvent event) {
        System.err.println("Button handle activated.");
        ColorChooserDialog.createAndShowGUI();
      }
      
    });
    TilePane root = new TilePane();
    root.getChildren().add(btn);
    root.getChildren().add(rb1);
    root.getChildren().add(rb2);
    
    fxContainer.setScene(new Scene(root));
  }
    
}
