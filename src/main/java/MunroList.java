import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MunroList {

    private ArrayList<Munro> munroList;

    public MunroList() {
        this.munroList = new ArrayList<>();
    }

    public ArrayList<Munro> getMunroList() {
        return munroList;
    }

    public void setMunroList(ArrayList<Munro> munroList) {
        this.munroList = munroList;
    }

    public void addMunro(Munro munro) {
        munroList.add(munro);
    }

    public int getListSize(){
        return munroList.size();
    }

    public int getIndexOf(Munro munro) {
        return munroList.indexOf(munro);
    }

    public void sortHeightAscending() {
        munroList.sort(Comparator.comparing(Munro::getHeight));
    }

    public void sortHeightDescending() {
        munroList.sort(Comparator.comparing(Munro::getHeight).reversed());
    }
}


