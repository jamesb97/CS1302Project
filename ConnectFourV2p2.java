import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import sun.audio.*;

/*Create a java program in which simulates two players playing connect four.*/

public class ConnectFourV2p2 {

  static JFrame mainWindow;
  static JButton firstButton = new JButton("Drop");
  static JButton secondButton = new JButton("Drop");
  static JButton thirdButton = new JButton("Drop");
  static JButton fourthButton = new JButton("Drop");
  static JButton fifthButton = new JButton("Drop");
  static JButton sixthButton = new JButton("Drop");
  static JButton seventhButton = new JButton("Drop");
  static JPanel[][] gridArray = new JPanel[6][7];
  static String[][] spotOnGrid = new String[6][7];
  static JLabel emptyLabel = new JLabel();
  static JPanel emptyPanel;
  static ImageIcon emptyBox;
  static JLabel redLabel = new JLabel();
  static JPanel redPanel;
  static ImageIcon redBox;
  static JLabel yellowLabel = new JLabel();
  static JPanel yellowPanel;
  static ImageIcon yellowBox;
  static JPanel gridPanel;
  static Boolean redTurn = true;

  private static class ButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      int buttonIndex = buttonz.indexOf(e.getSource());
      //Create an arrayList 
      private static List<JButton> buttonz = Arrays.asList(firstButton, secondButton, thirdButton, fourthButton, fifthButton, sixthButton, seventhButton);
      
        if(redTurn) {
          dropRedBox(buttonIndex);
          if(winCheck("red")){
            JOptionPane.showMessageDialog(null, "Red wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE );
          }
        }
          else {
            dropYellowBox(buttonIndex);
            if (winCheck("yellow"))  
            JOptionPane.showMessageDialog(null, "Yellow wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE );}
      

      if (e.getSource() == secondButton) {
        if(redTurn) {
          dropRedBox(1);
          if(winCheck("red")){
            JOptionPane.showMessageDialog(null, "Red wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE );
          }
        }
          else {
            dropYellowBox(1);
            winCheck("yellow");
            JOptionPane.showMessageDialog(null, "Yellow wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE );}
        }


      if (e.getSource() == thirdButton) {
        if(redTurn) {
          dropRedBox(2);
          if(winCheck("red")){
            JOptionPane.showMessageDialog(null, "Red wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE );
          }
        }
          else {
            dropYellowBox(2);
            winCheck("yellow");
            JOptionPane.showMessageDialog(null, "Yellow wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE );}
        }


      if (e.getSource() == fourthButton) {
        if(redTurn) {
          dropRedBox(3);
          if(winCheck("red")){
            JOptionPane.showMessageDialog(null, "Red wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE );
          }
        }
          else {
            dropYellowBox(3);
            winCheck("yellow");
            JOptionPane.showMessageDialog(null, "Yellow wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE );}
        }


      if (e.getSource() == fifthButton) {
        if(redTurn) {
          dropRedBox(4);
          if(winCheck("red")){
            JOptionPane.showMessageDialog(null, "Red wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE );
          }
        }
          else {
            dropYellowBox(4);
            winCheck("yellow");
            JOptionPane.showMessageDialog(null, "Yellow wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE );}
        }


      if (e.getSource() == sixthButton) {
        if(redTurn) {
          dropRedBox(5);
          if(winCheck("red")){
            JOptionPane.showMessageDialog(null, "Red wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE );
          }
        }
          else {
            dropYellowBox(5);
            winCheck("yellow");
            JOptionPane.showMessageDialog(null, "Yellow wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE );}
        }


      if (e.getSource() == seventhButton) {
        if(redTurn) {
          dropRedBox(6);
          if(winCheck("red")){
            JOptionPane.showMessageDialog(null, "Red wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE );
          }
        }
          else {
            dropYellowBox(6);
            winCheck("yellow");
            JOptionPane.showMessageDialog(null, "Yellow wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE );}
        }


    }
  }

  public static void main(String[] args) {

    ButtonHandler listener = new ButtonHandler();
    JPanel mainPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    gridPanel = new JPanel();

    mainPanel.setLayout(new BorderLayout());
    gridPanel.setLayout(new GridLayout(6, 7));
    buttonPanel.setLayout(new GridLayout(1, 7));
    gridPanel.setBackground(new Color(255, 127, 38));



    mainPanel.add(gridPanel, BorderLayout.CENTER);
    mainPanel.add(buttonPanel, BorderLayout.NORTH);

    buttonPanel.add(firstButton);
    buttonPanel.add(secondButton);
    buttonPanel.add(thirdButton);
    buttonPanel.add(fourthButton);
    buttonPanel.add(fifthButton);
    buttonPanel.add(sixthButton);
    buttonPanel.add(seventhButton);

    firstButton.addActionListener(listener);
    secondButton.addActionListener(listener);
    thirdButton.addActionListener(listener);
    fourthButton.addActionListener(listener);
    fifthButton.addActionListener(listener);
    sixthButton.addActionListener(listener);
    seventhButton.addActionListener(listener);

    mainWindow = new JFrame("Connect Four");
    mainWindow.setContentPane(mainPanel);
    mainWindow.setSize(884, 730);
    mainWindow.setLocationRelativeTo(null);
    mainWindow.setVisible(true);
    mainWindow.setResizable(false);

    createGrid();
    resetGrid();

  }



  public static void createGrid() {
    for(int j = 0; j < 6; j++) {
      for (int k = 0; k < 7; k++) {
        gridArray[j][k] = new JPanel();
        gridPanel.add(gridArray[j][k]);
        gridArray[j][k].setBackground(new Color(103,110,215));
      }
    }
  }

  public static void resetGrid(){
    for(int j = 0; j < 6; j++) {
      for (int k = 0; k < 7; k++) {
        gridArray[j][k].removeAll();
        gridArray[j][k].add(new JLabel(new ImageIcon("emptyBox.png")));
        gridArray[j][k].revalidate();
        spotOnGrid[j][k] = "empty";
      }
    }
  }

  public static void dropRedBox(int col) {
    for(int j = 5; j >= 0; j--) {
      if(spotOnGrid[j][col].equals("empty")) {
        spotOnGrid[j][col] = "red";
        gridArray[j][col].removeAll();
        gridArray[j][col].add(new JLabel(new ImageIcon("redBox.png")));
        gridArray[j][col].revalidate();
        spotOnGrid[j][col] = "red";
        redTurn = false;
        break;
      }

    }
  }

  public static void dropYellowBox(int col){
    for(int j = 5; j >=0; j--) {
      if(spotOnGrid[j][col].equals("empty")) {
        spotOnGrid[j][col] = "yellow";
        gridArray[j][col].removeAll();
        gridArray[j][col].add(new JLabel(new ImageIcon("yellowBox.png")));
        gridArray[j][col].revalidate();
        spotOnGrid[j][col] = "yellow";
        redTurn = true;
        break;
      }
    }
  }


  public static boolean winCheck(String box) {
    Boolean winner = false;
    int currentRow;
    int currentCol;
    for(int j = 0; j < 6; j++) {
      for (int k = 0; k < 7; k++) {
        if(spotOnGrid[j][k].equals(box)) {
          currentRow = j;
          currentCol = k;

          if(((j -3) >= 0) && spotOnGrid[j -1][k].equals(box) && spotOnGrid[j -2][k].equals(box) && spotOnGrid[j -3][k].equals(box)) {         
            return true;
          }

          if(((j +3) <= 5) && spotOnGrid[j +1][k].equals(box) && spotOnGrid[j +2][k].equals(box) && spotOnGrid[j +3][k].equals(box)) {       
            return true;
          }

          if(((k -3) >= 0) && spotOnGrid[j][k -1].equals(box) && spotOnGrid[j][k -2].equals(box) && spotOnGrid[j][k -3].equals(box)) {
            return true;
          }
          if(((k +3) <= 6) && spotOnGrid[j][k +1].equals(box) && spotOnGrid[j][k +2].equals(box) && spotOnGrid[j][k +3].equals(box)) {           
            return true;
          }
          else
            return false;

        }

      }

    }
    return false;
  }

}
          