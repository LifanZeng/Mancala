import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * The data part of the MJC pattern.
 * @author Lifan Zeng.
 * @author2 Victor Mendoza (setDatas() method).
 */
public class DataModel {
    private ArrayList<Integer> datas;
    private ArrayList<ChangeListener> listeners;

    /**
     * To construct a dataModel.
     * @param datas - The arrayList to store the stone numbers.
     *              datas.get(0) is the stone amount of A1; datas.get(1)--> A2; ...datas.get(6)--> Mancala A.
     *              datas.get(7)--> B1; datas.get(8)--> B2; ... datas.get(13)--> Mancala B.
     */
    public DataModel(ArrayList<Integer> datas){
        this.datas = datas;
        listeners = new ArrayList<ChangeListener>();
    }

    /**
     * Accessor of the data model.
     * @return - get datas.
     */
    public ArrayList<Integer> getDatas(){
        return (ArrayList<Integer>) datas.clone();
    }

    /**
     * To reset the datas. Just used for Undo button.
     * @param newData
     */
    public void setDatas(ArrayList<Integer> newData){
        datas = newData;
        for(ChangeListener l: listeners){
            l.stateChanged(new ChangeEvent(this));
        }
    }

    /**
     * Mutator of the data model
     * @param index - the index of the changed element.
     * @param value - the value of the changed element.
     */
    public void update(int index, int value){
        datas.set(index, value);
        for(ChangeListener l: listeners){
            l.stateChanged(new ChangeEvent(this));
        }
    }

    /**
     * To add ChangeListeners to data model.
     * @param c - a ChangeListener type parameter
     */
    public void addChangeListener(ChangeListener c){
        listeners.add(c);
    }
}