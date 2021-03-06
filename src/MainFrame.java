import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
    private Container cp;
    private JPanel jp=new JPanel(new GridLayout(3,3));
    private JButton jbtns[]=new JButton[9];
    private JTextField jtf=new JTextField();
    private LoginFrame loginFrame;
    public MainFrame(LoginFrame frm){
        loginFrame=frm;
        initComp();
    }
    private void initComp(){
        cp=this.getContentPane();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loginFrame.setVisible(true);
            }
        });
        this.setBounds(100,100,400,500);
        this.setLayout(new BorderLayout(5,5));
        this.add(jtf,BorderLayout.NORTH);
        this.add(jp,BorderLayout.CENTER);
        for(int i=0;i<9;i++){
            jbtns[i]=new JButton(Integer.toString(i));
            jp.add(jbtns[i]);
            jbtns[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tmpButton=(JButton)e.getSource();
                    jtf.setText(jtf.getText()+tmpButton.getText());
                    jtf.setEditable(false);
                }
            });
        }
    }
}
