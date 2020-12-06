package a.b.c;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class operatorListener implements ActionListener {
    JTextArea area_1;
    JTextArea area_2;
    public void setJTextAreaOne(JTextArea a1)
    {
        area_1=a1;
    }
    public void setJTextAreaTwo(JTextArea a2)
    {
        area_2=a2;
    }

    public void actionPerformed(ActionEvent e)
    {
        try{
            X_GetFomula calculator=new X_GetFomula();
            String s=area_1.getText();
            area_2.append("结果为"+calculator.calc(s).toString()+" ");
        }
        catch (Exception E)
        {
            area_2.append("输入错误了");
        }
    }
}
