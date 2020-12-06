package a.b.c;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Style extends JFrame
{
    private JButton button;
    private JTextArea area_1;
    private JTextArea area_2;
    private operatorListener listener;
    private JLabel label_1;
    //private JLabel label_2;

    public Style()
    {
        init();
        setLocation(60,60);
        setSize(240,400);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    private void init()
    {
        setLayout(new FlowLayout());
        setTitle("X_Calc");
        button=new JButton("计算");
        label_1=new JLabel("请输入:");
        //label_2=new JLabel("结果:");
        area_1=new JTextArea(9,20);

        area_2=new JTextArea(9,20);
        listener=new operatorListener();
        listener.setJTextAreaOne(area_1);
        listener.setJTextAreaTwo(area_2);
        button.addActionListener(listener);
        add(label_1);
        add(area_1);
        add(button);
        //add(label_2);
        add(area_2);
    }

    //public void setMycommandListenser()
}