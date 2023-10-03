import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPFinder {

    public static void main(String[] args) {

        JFrame jFrame = new JFrame("IP Finder");
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(400,300);
        jFrame.setLayout(new BorderLayout(10,10));

        //Horizontal and Vertical padding(space) between components in the Border-layout
        JPanel jpanel = new JPanel(new BorderLayout(10, 10));
        //creating some padding(space) between the panel's edge and component inside it.
        jpanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));



        JLabel jLabel = new JLabel("Enter URL : ");
        jpanel.add(jLabel,BorderLayout.NORTH);

        JTextField jTextField = new JTextField();
        jpanel.add(jTextField,BorderLayout.CENTER);


        JButton jButton = new JButton("Find IP address");
        jpanel.add(jButton,BorderLayout.SOUTH);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = jTextField.getText();
                try {

                    // Get the ip address of url
                    InetAddress ia = InetAddress.getByName(url);

                    // Retrieve the IP address in a human-readable format
                    String ip = ia.getHostAddress();
                    JOptionPane.showMessageDialog(jFrame, ip);
                } catch (UnknownHostException unknownHostException) {
                    JOptionPane.showMessageDialog(jFrame, "IP not found");

                }
            }
        });

        jFrame.add(jpanel,BorderLayout.CENTER);


    }
}
