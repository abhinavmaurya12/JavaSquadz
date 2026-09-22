
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

public class mchat implements ActionListener
{
    JFrame f, f1;

    JLabel l, l1, l2;

    JTextField tf;

    JTextArea ta, ta1, ta2;

    JScrollPane js, js1, js2;

    JButton b, b1, b2;

    Socket s;

    DataInputStream din;
    DataOutputStream dout;

    String st = "";
    String name = "";

    int flag = 0;


    // Constructor
    public mchat()
    {
        // LOGIN FRAME
        f = new JFrame("LOGIN FORM");

        // CHAT FRAME
        f1 = new JFrame("CHAT");


        // ---------------- LOGIN COMPONENTS ----------------

        l = new JLabel("Enter User Name");
        l.setBounds(50, 50, 100, 30);

        tf = new JTextField();
        tf.setBounds(160, 50, 100, 30);

        b = new JButton("LOG IN");
        b.setBounds(100, 100, 90, 30);


        f.getContentPane().add(l);
        f.getContentPane().add(tf);
        f.getContentPane().add(b);


        // ---------------- CHAT COMPONENTS ----------------

        l1 = new JLabel("Sent Items");
        l1.setBounds(40, 50, 80, 30);

        l2 = new JLabel("Wanna Send?");
        l2.setBounds(40, 230, 80, 30);


        ta = new JTextArea();
        ta1 = new JTextArea();
        ta2 = new JTextArea();


        // Received/chat messages should not be manually edited
        ta1.setEditable(false);
        ta2.setEditable(false);


        // Scroll panes
        js = new JScrollPane(
                ta,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS
        );

        js1 = new JScrollPane(
                ta1,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS
        );

        js2 = new JScrollPane(
                ta2,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS
        );


        // Positions
        js.setBounds(160, 230, 250, 60);

        js1.setBounds(160, 50, 250, 160);

        js2.setBounds(450, 50, 100, 160);


        // Buttons
        b1 = new JButton("SEND");
        b1.setBounds(75, 300, 80, 30);

        b2 = new JButton("LOG OUT");
        b2.setBounds(170, 300, 120, 30);


        // Add components
        f1.getContentPane().add(b1);
        f1.getContentPane().add(b2);

        f1.getContentPane().add(l1);
        f1.getContentPane().add(l2);

        f1.getContentPane().add(js);
        f1.getContentPane().add(js1);
        f1.getContentPane().add(js2);


        // ---------------- FRAME SETTINGS ----------------

        f.getContentPane().setLayout(null);

        f.setSize(300, 300);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setLocationRelativeTo(null);

        f.setVisible(true);


        f1.getContentPane().setLayout(null);

        f1.setSize(600, 600);

        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f1.setLocationRelativeTo(null);

        f1.setVisible(false);


        // ---------------- ACTION LISTENERS ----------------

        b.addActionListener(this);

        b1.addActionListener(this);

        b2.addActionListener(this);


        // ---------------- SERVER CONNECTION ----------------

        try
        {
            /*
             * Remote server
             */
            s = new Socket("13.201.161.138", 8);


            /*
             * If the server is running on your own computer,
             * use this instead:
             *
             * s = new Socket("localhost", 8);
             */


            din = new DataInputStream(
                    s.getInputStream()
            );

            dout = new DataOutputStream(
                    s.getOutputStream()
            );


            // Start receiving thread
            my m = new my(din, this);

            Thread t1 = new Thread(m);

            t1.start();


            ta2.setText("");
        }
        catch (Exception e)
        {
            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    f,
                    "Unable to connect to server.\n\n"
                    + e.getMessage(),
                    "Connection Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    // ---------------- BUTTON ACTIONS ----------------

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // LOGIN BUTTON
        if (e.getSource() == b)
        {
            try
            {
                name = tf.getText().trim();


                if (name.isEmpty())
                {
                    JOptionPane.showMessageDialog(
                            f,
                            "Please enter your user name."
                    );

                    return;
                }


                f.setVisible(false);

                f1.setVisible(true);


                clientchat1();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }


        // SEND BUTTON
        if (e.getSource() == b1)
        {
            try
            {
                clientchat();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }


        // LOGOUT BUTTON
        if (e.getSource() == b2)
        {
            try
            {
                clientchat2();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }


    // ---------------- LOGIN MESSAGE ----------------

    public void clientchat1() throws IOException
    {
        String s1 = name + " logged in";

        dout.writeUTF(s1);

        dout.flush();
    }


    // ---------------- SEND MESSAGE ----------------

    public void clientchat() throws IOException
    {
        String s1 = ta.getText();


        if (s1.trim().isEmpty())
        {
            return;
        }


        /*
         * Message format:
         *
         * *username::message
         */
        dout.writeUTF(
                "*" + name + "::" + s1
        );

        dout.flush();


        // Clear message box
        ta.setText("");
    }


    // ---------------- LOGOUT ----------------

    public void clientchat2() throws IOException
    {
        if (dout != null)
        {
            dout.writeUTF(
                    "(" + name + " logged out)"
            );

            dout.flush();
        }


        if (s != null && !s.isClosed())
        {
            s.close();
        }


        System.exit(0);
    }


    // ---------------- MAIN METHOD ----------------

    public static void main(String[] args)
    {
        new mchat();
    }
}


/*
 * =========================================================
 * RECEIVING THREAD
 * =========================================================
 *
 * This class continuously receives messages from the server.
 */

class my implements Runnable
{
    private DataInputStream din;

    private mchat chat;


    // Constructor
    public my(DataInputStream din, mchat chat)
    {
        this.din = din;

        this.chat = chat;
    }


    @Override
    public void run()
    {
        String st;

        String st1 = "";


        while (true)
        {
            try
            {
                // Read message from server
                st = din.readUTF();


                /*
                 * Chat messages start with '*'
                 *
                 * Example:
                 *
                 * *Abhinav::Hello
                 */
                if (st.startsWith("*"))
                {
                    /*
                     * Remove '*' before displaying.
                     */
                    st1 = st1
                            + st.substring(1)
                            + "\n";


                    /*
                     * Copy the current value because
                     * lambda expressions require captured
                     * local variables to be final/effectively final.
                     */
                    final String messageToDisplay = st1;


                    /*
                     * Update Swing components on
                     * the Event Dispatch Thread.
                     */
                    SwingUtilities.invokeLater(
                            new Runnable()
                            {
                                @Override
                                public void run()
                                {
                                    chat.ta1.setText(
                                            messageToDisplay
                                    );
                                }
                            }
                    );
                }
                else
                {
                    /*
                     * Login/logout/server messages.
                     */
                    final String serverMessage = st;


                    SwingUtilities.invokeLater(
                            new Runnable()
                            {
                                @Override
                                public void run()
                                {
                                    chat.ta2.append(
                                            serverMessage + "\n"
                                    );
                                }
                            }
                    );
                }
            }
            catch (EOFException e)
            {
                System.out.println(
                        "Server disconnected."
                );

                break;
            }
            catch (IOException e)
            {
                System.out.println(
                        "Connection closed."
                );

                break;
            }
            catch (Exception e)
            {
                e.printStackTrace();

                break;
            }
        }
    }
}

