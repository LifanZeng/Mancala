import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * To define the main frame.
 * @authors: Lifan Zeng, Victor Mendoza, Kynan Hui.
 */
public class MainFrame extends JFrame implements ChangeListener {
    private DataModel dataModel;
    private GridShape[] gridShapes = new GridShape[14];
    private Blank_GridShape blank_shape;
    private ShapeIcon[] shapeIcons = new ShapeIcon[14];
    private ShapeIcon blank_icon;       //0, blank_icon1, blank_icon2, blank_icon3, blank_icon4,
    private JLabel[] labels = new JLabel[14];
    private boolean PlayerA = true; //holds the current player
    private boolean lastPlayer = PlayerA;
    private JLabel player;
    private ArrayList<Integer> lastData = new ArrayList<>();
    private Strategy strategy = new PlayerOne();

    /**
     * To construct a main frame.
     * @param dm - a DataModel type parameter.
     */
    public MainFrame(DataModel dm){
        this.dataModel = dm;
        for(int i = 0; i < gridShapes.length; i++)
        {
            final int j = i;
            if(i<7)
                gridShapes[i] = new GridShape(0, 0, 200, Color.red);
            else
                gridShapes[i] = new GridShape(0, 0, 200, Color.blue);
            shapeIcons[i] = new ShapeIcon(gridShapes[i], 200, 200);
            labels[i] = new JLabel(shapeIcons[i]);
            if(i != 6 && i != 13)
            {
                    labels[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        super.mousePressed(e);
                        lastData = dataModel.getDatas();
                        lastPlayer = PlayerA;
                        JLabel currentLabel = (JLabel)e.getSource();
                        changePlayer();
                        depositBeads(currentLabel);

                    }
                });
            }
        }

        gridShapes[6].setNumber(0);
        gridShapes[13].setNumber(0);


        player = new JLabel("Player A");
        player.setForeground(Color.red);
        JButton undo = new JButton("Undo");
        undo.addActionListener(e -> {
            dataModel.setDatas(lastData);
            PlayerA = lastPlayer;
            setPlayer();
        });
//        JPanel Bpanel = new JPanel();
        JPanel Bpanel = new JPanel();
        Bpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        Bpanel.add(undo);
        Bpanel.add(player);
        //add(Bpanel, BorderLayout.PAGE_END);//     add(panel);

        JPanel PitPanel = new JPanel();
        PitPanel.setLocation(0, 100);
        PitPanel.setLayout(new GridLayout(3, 8));

         //To set blank label 0~9;
        blank_shape = new Blank_GridShape(0, 0, 200);
        blank_icon = new ShapeIcon(blank_shape, 200, 200);

        JLabel lblBlank0 = new JLabel(blank_icon);
        JLabel lblBlank1 = new JLabel(blank_icon);
        JLabel lblBlank2 = new JLabel(blank_icon);
        JLabel lblBlank3 = new JLabel(blank_icon);
        JLabel lblBlank4 = new JLabel(blank_icon);
        JLabel lblBlank5 = new JLabel(blank_icon);
        JLabel lblBlank6 = new JLabel(blank_icon);
        JLabel lblBlank7 = new JLabel(blank_icon);
        JLabel lblBlank8 = new JLabel(blank_icon);
        JLabel lblBlank9 = new JLabel(blank_icon);

//        JPanel PitPanel = new JPanel();
//        PitPanel.setLocation(0, 100);
//        PitPanel.setLayout(new GridLayout(3, 8));

        PitPanel.add(lblBlank0);
        PitPanel.add(labels[12]);
        PitPanel.add(labels[11]);
        PitPanel.add(labels[10]);
        PitPanel.add(labels[9]);
        PitPanel.add(labels[8]);
        PitPanel.add(labels[7]);

        PitPanel.add(lblBlank1);

        //Second line
        PitPanel.add(labels[13]);
        PitPanel.add(lblBlank2);
        PitPanel.add(lblBlank3);
        PitPanel.add(lblBlank4);
        PitPanel.add(lblBlank5);
        PitPanel.add(lblBlank6);
        PitPanel.add(lblBlank7);
        PitPanel.add(labels[6]);

        //Third line
        PitPanel.add(lblBlank8);
        PitPanel.add(labels[0]);
        PitPanel.add(labels[1]);
        PitPanel.add(labels[2]);
        PitPanel.add(labels[3]);
        PitPanel.add(labels[4]);
        PitPanel.add(labels[5]);

        PitPanel.add(lblBlank9);

        //add(PitPanel);
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        add(Bpanel);
        add(PitPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    /**
     * Receive the notify of data Model, then repaint the main frame.
     * Here it let the main frame acts as the View of MVC pattern.
     * @param e - a ChangeEvent parameter.
     */
    @Override
    public void stateChanged(ChangeEvent e) {        // View
        for(int i = 0; i < gridShapes.length; i++)
        {
            gridShapes[i].setNumber(dataModel.getDatas().get(i));
        }
        repaint();                              //   for GUI
    }

    /**
     *To deposit beads in the pit.
     * @param label - a JLabel parameter.
     */
    public void depositBeads(JLabel label)
    {
        ArrayList<Integer> data = dataModel.getDatas();
        //find which label was clicked
        int index = 0;
        while(!label.equals(labels[index]))
        {
            index++;
        }
        //iterator to deposit the beads
        int iter = index;
        //get how many beads were in the pit that was clicked
        int beads = data.get(index);
        while(beads > 0)
        {
            iter++;
            if(iter > 13)
            {
                iter = 0;
            }
            int x = data.get(iter);

            if(strategy.lastBeadGoal(beads, iter))
            {
                changePlayer();
            }
            if(strategy.lastBeadEmpty(beads, iter, x))
            {
                int mancalaBeads = 0;
                int pitAcross = 12 - iter;
                //gets the number of beads in the players pit
                if(PlayerA)
                    mancalaBeads = data.get(13);
                else
                    mancalaBeads = data.get(6);

                //gets the index of the pit across from it
                int totalBeads = beads + data.get(pitAcross) + mancalaBeads;
                dataModel.update(iter, 0);
                dataModel.update(pitAcross, 0);
                if(PlayerA)
                    dataModel.update(13, totalBeads);
                else
                    dataModel.update(6, totalBeads);

            }
            x++;
            dataModel.update(iter, x);
            beads--;
        }
        dataModel.update(index, 0);

    }

    /**
     * To change player states.
     */
    public void changePlayer() {
        PlayerA = !PlayerA;
        if(PlayerA) {
            strategy = new PlayerOne();
            player.setForeground(Color.red);
            player.setText("Player A");
        }
        else{
            strategy = new PlayerTwo();
            player.setForeground(Color.blue);
            player.setText("Player B");
        }
    }

    /**
     * To set the player.
     */
    public void setPlayer()
    {
        if(PlayerA) {
            player.setForeground(Color.red);
            strategy = new PlayerOne();
            player.setText("Player A");
        }
        else{
            player.setForeground(Color.blue);
            strategy = new PlayerTwo();
            player.setText("Player B");
        }

    }

}