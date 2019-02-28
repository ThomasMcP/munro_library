import java.lang.reflect.Array;
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

    public ArrayList<Munro> limitToTenResults() {
        ArrayList<Munro> limitedResults = new ArrayList<>();
        for (Munro munro: munroList) {
            if (limitedResults.size() < 10) {
                limitedResults.add(munro);
            }
        }
        return limitedResults;
    }

    public ArrayList<Munro> getMunrosAboveLimit(int heightLimit) {
        ArrayList<Munro> munrosOverLimit = new ArrayList<>();
        for (Munro munro: munroList){
            if (munro.getHeight() >= heightLimit){
                munrosOverLimit.add(munro);
            }
        }
        return munrosOverLimit;
    }
}


