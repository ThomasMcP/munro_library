import java.util.ArrayList;

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
        munroList.size();
    }
}


