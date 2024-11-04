package org.example;

import javax.swing.*;
import java.awt.event.*;
import java.net.URL;

public class Main {

    private JPanel Root;
    private JTextField tfNumber;
    private JPanel panMain;
    private JPanel panData;
    private JPanel panResults;
    private JTextField tfName;
    private JTextField tfSurname;
    private JPanel panEyes;
    private JLabel lNumber;
    private JLabel lName;
    private JLabel lSurname;
    private JRadioButton rbEyesBlue;
    private JRadioButton rbEyesBrown;
    private JRadioButton rbEyesGreen;
    private JButton btnOk;
    private JLabel imgPerson;
    private JLabel imgPrint;
    public Main() {

        tfNumber.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                String num = tfNumber.getText();
                URL personIconURL = getClass().getResource("/" + num + "-zdjecie.jpg");
                URL printIconURL = getClass().getResource("/" + num + "-odcisk.jpg");
                if(personIconURL == null || printIconURL == null){
                    imgPerson.setVisible(false);
                    imgPrint.setVisible(false);
                    return;
                }
                imgPerson.setVisible(true);
                imgPrint.setVisible(true);
                ImageIcon personIcon = new ImageIcon(personIconURL);
                ImageIcon printIcon = new ImageIcon(printIconURL);
                imgPerson.setIcon(personIcon);
                imgPrint.setIcon(printIcon);
            }
        });
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = tfName.getText();
                String surname = tfSurname.getText();
                String eyes = "";
                if(rbEyesGreen.isSelected())
                    eyes = "zielone";
                else if (rbEyesBrown.isSelected())
                    eyes = "piwne";
                else if (rbEyesBlue.isSelected())
                    eyes = "niebieskie";

                if(name.isEmpty() || surname.isEmpty()){
                    JOptionPane.showMessageDialog(Root, "Wprowadź dane");
                    return;
                }
                JOptionPane.showMessageDialog(Root, name + " " + surname + " kolor oczu " + eyes);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Wprowadzenie danych do paszportu. Wykonał: XYZ");
        Main main = new Main();
        frame.setContentPane(main.Root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}