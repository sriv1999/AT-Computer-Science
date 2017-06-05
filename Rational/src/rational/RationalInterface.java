package rational;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RationalInterface {

	public static void main(String[] args) {
              JFrame frame = new JFrame("FRACTIONS"); // The main window
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // This tells the
                                                                                     
                         // program to
                                                                                     
                         // exit when the
                                                                                     
                         // frame is
                                                                                   
                         // closed

              frame.setBounds(0, 0, 400, 400); // First two numbers set position, // second two set size

              Rational one = new Rational(1, 2);
              Rational two = new Rational(3, 4);
              JPanel north = new JPanel(); // JPanels allow me to place the buttons

              JLabel numLabel1 = new JLabel("Numerator 1: ");
              JLabel denLabel1 = new JLabel("Denominator 1: ");
              JLabel numLabel2 = new JLabel("Numerator 2: ");
              JLabel denLabel2 = new JLabel("Denominator 2: ");
              JLabel add = new JLabel("Add: ");
              JLabel subtract = new JLabel("Subtract: ");
              JLabel multiply = new JLabel("Multiply: ");
              JLabel divide = new JLabel("Divide: ");
              
              
              final int FIELD_WIDTH = 5;

              final JTextField numField1 = new JTextField(FIELD_WIDTH);
              numField1.setText("0");
              final JTextField denField1 = new JTextField(FIELD_WIDTH);
              denField1.setText("1");
              final JTextField numField2 = new JTextField(FIELD_WIDTH);
              numField1.setText("0");
              final JTextField denField2 = new JTextField(FIELD_WIDTH);
              denField1.setText("1");
              final JTextField addField = new JTextField(FIELD_WIDTH);
              add.setText("0");
              final JTextField subtractField = new JTextField(FIELD_WIDTH);
              subtract.setText("0");
              final JTextField multiplyField = new JTextField(FIELD_WIDTH);
              multiply.setText("0");
              final JTextField divideField = new JTextField(FIELD_WIDTH);
              divide.setText("1");

              // The button to trigger the calculation
              int num1 = Integer.parseInt(numField1.getText());
              int den1 = Integer.parseInt(denField1.getText());
              JLabel ratio1 = new JLabel("" + new Rational(num1, den1));
              JButton reduceButton1 = new JButton("Reduce");
              reduceButton1.setBackground(Color.ORANGE);
              
              // The button to trigger the calculation
              int num2 = Integer.parseInt(numField1.getText());
              int den2 = Integer.parseInt(denField1.getText());
              JLabel ratio2 = new JLabel("" + new Rational(num2, den2));
              JButton reduceButton2 = new JButton("Reduce");
              reduceButton2.setBackground(Color.ORANGE);
              
              JButton addButton = new JButton("Add");
              addButton.setBackground(Color.RED);
              
              JButton subtractButton = new JButton("Subtract");
              subtractButton.setBackground(Color.BLUE);
              
              JButton multiplyButton = new JButton("Multiply");
              multiplyButton.setBackground(Color.MAGENTA);
              
              JButton divideButton = new JButton("Divide");
              divideButton.setBackground(Color.CYAN);

              // The panel that holds the input components
              north.setLayout(new GridLayout(15, 1));
              north.add(numLabel1);
              north.add(numField1);
              north.add(denLabel1);
              north.add(denField1);
              north.add(reduceButton1);
              north.add(ratio1);
              
              north.add(numLabel2);
              north.add(numField2);
              north.add(denLabel2);
              north.add(denField2);
              north.add(reduceButton2);
              north.add(ratio2);
              
              north.add(addButton);
              north.add(add);
              
              north.add(subtractButton);
              north.add(subtract);
              
              north.add(multiplyButton);
              north.add(multiply);
              
              north.add(divideButton);
              north.add(divide);
              
              
              frame.getContentPane().add(north, BorderLayout.NORTH);
              frame.getContentPane().add(BorderLayout.NORTH, north); // BorderLayout                                                                                     
                         // allows me to
                                                                                     
                         // attach the
                                                                                     
                         // JPanel to the
                                                                                     
                         // border of the
                                                                                  
                         // frame
              frame.setVisible(true); // Makes the frame visible

              // This makes the button work. all of the code is the parameter of the
              // method

              reduceButton1.addActionListener(new ActionListener() {
                     public void actionPerformed(ActionEvent evt) {
                           int num1 = Integer.parseInt(numField1.getText());
                           int den1 = Integer.parseInt(denField1.getText());
                           one.setNumer(num1);
                           one.setDenom(den1);
                           one.reduce();
                           ratio1.setText("" + one);
                     }
              });
              
              reduceButton2.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent evt) {
                        int num2 = Integer.parseInt(numField2.getText());
                        int den2 = Integer.parseInt(denField2.getText());
                        one.setNumer(num2);
                        one.setDenom(den2);
                        one.reduce();
                        ratio2.setText("" + one);
                  }
              });
              
              addButton.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent evt) {
                        int num1 = Integer.parseInt(numField1.getText());
                        int den1 = Integer.parseInt(denField1.getText());
                        one.setNumer(num1);
                        one.setDenom(den1);
                        one.reduce();
                        
                        int num2 = Integer.parseInt(numField2.getText());
                        int den2 = Integer.parseInt(denField2.getText());
                        one.setNumer(num2);
                        one.setDenom(den2);
                        one.reduce();
                        
                        add.setText("" + one.add(two));
                  }
              });
              
              subtractButton.addActionListener(new ActionListener() {
            	  public void actionPerformed(ActionEvent evt) {
                      int num1 = Integer.parseInt(numField1.getText());
                      int den1 = Integer.parseInt(denField1.getText());
                      one.setNumer(num1);
                      one.setDenom(den1);
                      one.reduce();
                      
                      int num2 = Integer.parseInt(numField2.getText());
                      int den2 = Integer.parseInt(denField2.getText());
                      one.setNumer(num2);
                      one.setDenom(den2);
                      one.reduce();
                      
                      subtract.setText("" + one.subtract(two));
                }
              });
              
              multiplyButton.addActionListener(new ActionListener() {
            	  public void actionPerformed(ActionEvent evt) {
                      int num1 = Integer.parseInt(numField1.getText());
                      int den1 = Integer.parseInt(denField1.getText());
                      one.setNumer(num1);
                      one.setDenom(den1);
                      one.reduce();
                      
                      int num2 = Integer.parseInt(numField2.getText());
                      int den2 = Integer.parseInt(denField2.getText());
                      one.setNumer(num2);
                      one.setDenom(den2);
                      one.reduce();
                      
                      multiply.setText("" + one.multiply(two));
                }
              });
              
              divideButton.addActionListener(new ActionListener() {
            	  public void actionPerformed(ActionEvent evt) {
                      int num1 = Integer.parseInt(numField1.getText());
                      int den1 = Integer.parseInt(denField1.getText());
                      one.setNumer(num1);
                      one.setDenom(den1);
                      one.reduce();
                      
                      int num2 = Integer.parseInt(numField2.getText());
                      int den2 = Integer.parseInt(denField2.getText());
                      one.setNumer(num2);
                      one.setDenom(den2);
                      one.reduce();
                      
                      divide.setText("" + one.divide(two));
                }
              });
       }

}