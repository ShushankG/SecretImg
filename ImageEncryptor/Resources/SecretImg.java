import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.awt.Font;

public class SecretImg {
public static void operate(int key){
JFileChooser fileChooser=new JFileChooser();
fileChooser.showOpenDialog(null);
File file=fileChooser.getSelectedFile();
try{

    FileInputStream fis =new FileInputStream(file);
    byte[]data =new byte[fis.available()];
    fis.read(data);
    int i=0;
    for(byte b:data){
        System.out.println(b);
        data[i]=(byte) (b^key);
        i++;

    }
    FileOutputStream fos =new FileOutputStream(file);
    fos.write(data);
    fos.close();
    fis.close();
    JOptionPane.showMessageDialog(null,"done");

}
catch(Exception e){
e.printStackTrace();
}

}

    public static void main(String[] args) {
        JFrame f= new JFrame();
        f.setTitle("Image Operation");
        f.setSize(300, 300);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font=new Font("Roboto",Font.BOLD,18);
        
       //Creating button--
        JButton btn=new JButton();
        btn.setText("Select Image");
        btn.setFont(font);
        //creating text field-----
        JTextField textfield=new JTextField(10);
        textfield.setFont(font);
        f.setLayout(new FlowLayout());

        //adding btn and textfield
        f.add(btn);
        f.add(textfield);
        f.setVisible(true);

        //Actions
        btn.addActionListener(e->{
            
           String code= textfield.getText();
           int temp=Integer.parseInt(code);
           operate(temp);


        });


    }
}
