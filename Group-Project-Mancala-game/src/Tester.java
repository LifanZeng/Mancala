/**
 * CS151 Team Project -- Mancala game.
 *  @authors: Lifan Zeng, Victor Mendoza, Kynan Hui.
 *  @version 1.0 5/7/2021
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Tester is the class with the main method.
 * @author Lifan Zeng
 */
public class Tester {
    public static void main(String[] args){
        ArrayList<Integer> datas = new ArrayList<Integer>();
        for(int i = 0; i < 14; i++)
        {
            if(i == 6 || i == 13)
                datas.add(0);
            else
                datas.add(4);

        }
        DataModel dataModel = new DataModel(datas);
        MainFrame frame =new MainFrame(dataModel);
        dataModel.addChangeListener(frame);
    }
}