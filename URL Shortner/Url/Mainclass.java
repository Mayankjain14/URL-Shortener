package Url;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AWTEventListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.w3c.dom.Text;

public class Mainclass {

    private JFrame Frame;
    private JPanel panel;
    private JLabel label;
    private JTextField longURField;
    private JButton generateButton;
    private String longURL;
    private String tinyURL;   
       
       
    public void MainClass(){
        Frame = new JFrame("TinyURL Shortner");
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setSize(new Dimension(400, 0150));

        panel =new JPanel();
        label= new JLabel("Enter a long URL :");
        generateButton =new JButton("Generate Tiny URl");
        generateButton.addActionListener(new GenerateButtonActionListener());

        panel.add(label);
        panel.add(longURField);
        panel.add(generateButton);

        Frame.add(label);
        panel.setVisible(true);
    }
    public static void main(String[] args) {new Mainclass();}

    private class GenerateButtonActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            longURL =longURField.getText();
            try{
                URL url =new URL("http://tinyurl.con/apiscreate.php?url="+ longURL);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
               connection. setRequestMethod ("GET");

               BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
               tinyURL = in. readLine();
               in.close();
               JOptionPane. showMessageDialog(Frame, "TinyURL" + tinyURL);
         }       
         catch (Exception ex){
            ex.printStackTrace();
               
            }
        }
    }
} 

