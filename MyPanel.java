/*
//Code to close out UI's
JComponent comp = (JComponent) e.getSource();
Window win = SwingUtilities.getWindowAncestor(comp);
win.dispose();
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MyPanel extends JPanel{
    private JTextArea jcomp1;
    private JTextArea jcomp2;
    private JButton jcomp3;
    private JLabel jcomp4;
    private JLabel jcomp5;
    private JButton jcomp6;

    public MyPanel() {
        //construct components
        jcomp1 = new JTextArea (5, 5);
        jcomp2 = new JTextArea (5, 5);
        jcomp3 = new JButton ("Convert");
        jcomp4 = new JLabel ("User Input:");
        jcomp5 = new JLabel ("Converted Output:");
        jcomp6 = new JButton ("Clear All");
        //bottom text area formatting rules
        jcomp2.setEditable(false);
        jcomp2.setLineWrap(true);
        jcomp2.setWrapStyleWord(true);  
        
        /*
        This actionListener take the input and passes that through the
        Alternative caps filter and return the output to the textbox.
        */
        jcomp3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){  
            jcomp2.setText(alternativeTextFilter(jcomp1.getText()));
        }  
        });  
        
        //This actionListener clears all of the input and output from the text box fields.
        jcomp6.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {  
            jcomp1.setText("");
            jcomp2.setText("");

            }  
        }); 

        //adjust size and set layout
        setPreferredSize (new Dimension (677, 518));
        setLayout (null);

        //add components
        add (jcomp1);
        add (jcomp2);
        add (jcomp3);
        add (jcomp4);
        add (jcomp5);
        add (jcomp6);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (60, 55, 560, 125);
        jcomp2.setBounds (60, 315, 560, 155);
        jcomp3.setBounds (175, 210, 130, 40);
        jcomp4.setBounds (60, 25, 100, 25);
        jcomp5.setBounds (60, 275, 135, 25);
        jcomp6.setBounds (340, 210, 130, 40);
    }

    public static String alternativeTextFilter(String userInput)
    {
        //Split the userInput to char array
        String[] charUserInput = userInput.split("");
        //Create a variable to store the output for return
        String convertedOutput = "";
        //For every char in the Strung array charUserInput
        for (int x = 0; x < charUserInput.length; x++)
        {
            if(x % 2 == 0)
            {
                convertedOutput = convertedOutput + charUserInput[x].toUpperCase();
            }
            else
            {
                convertedOutput = convertedOutput + charUserInput[x].toLowerCase();           
            }
        }   
    return convertedOutput;
    }
    
    public static void main (String[] args) {
        JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new MyPanel());
        frame.pack();
        frame.setVisible (true);
    }

}
