import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MunroListTest {

    Munro munro1;
    Munro munro2;
    Munro munro3;
    Munro munro4;
    Munro munro5;
    Munro munro6;
    Munro munro7;
    MunroList munroList;

    @Before
    public void setUp(){
        munro1 = new Munro("Ben Chonzie", 931, "MUN", "NN773308");
        munro2 = new Munro("Ben Vorlich", 985, "MUN", "NN773308");
        munro3 = new Munro("Stuc a' Chroin", 975, "MUN", "NN773308");
        munro4 = new Munro("Ben Lomond", 974, "MUN", "NN773308");
        munro5 = new Munro("Ben More", 1174, "MUN", "NN773308");
        munro6 = new Munro("Stob Binnein - Stob Coire an Lochain", 1068, "TOP", "NN438220");
        munro7 = new Munro("Stob Binnein - Stob Coire an Lochain", 1068, "", "NN438220");
        munroList = new MunroList();
    }

    @Test
    public void munroListIsIntiallyEmpty(){
        assertEquals(0, munroList.getMunroList().size());
    }

    @Test
    public void canAddMunrosToList(){
        munroList.addMunro(munro1);
        assertEquals(1, munroList.getMunroList().size());
        munroList.addMunro(munro2);
        munroList.addMunro(munro3);
        munroList.addMunro(munro4);
        munroList.addMunro(munro5);
        assertEquals(5, munroList.getListSize());
    }

    @Test
    public void canSortMunrosByHeightAscending(){
        munroList.addMunro(munro1);
        munroList.addMunro(munro2);
        munroList.addMunro(munro3);
        munroList.addMunro(munro4);
        munroList.addMunro(munro5);
        munroList.addMunro(munro6);
        munroList.sortHeightAscending();
        assertEquals(5, munroList.getIndexOf(munro5) );
        assertEquals(0, munroList.getIndexOf(munro1) );
    }

    @Test
    public void canSortHeightDescending(){
        munroList.addMunro(munro1);
        munroList.addMunro(munro2);
        munroList.addMunro(munro3);
        munroList.addMunro(munro4);
        munroList.addMunro(munro5);
        munroList.addMunro(munro6);
        munroList.sortHeightDescending();
        assertEquals(5, munroList.getIndexOf(munro1));
        assertEquals(0, munroList.getIndexOf(munro5));
    }

    @Test
    public void canSortHeightAscendinglimited(){
        for (int i = 0; i < 5; i++) {
            munroList.addMunro(munro1);
            munroList.addMunro(munro2);
            munroList.addMunro(munro3);
            munroList.addMunro(munro4);
            munroList.addMunro(munro5);
            munroList.addMunro(munro6);
        }

//        as munros have been reused, munro5 will appear 5 times and munro6 will also appear 5 times.

        munroList.sortHeightAscending();
        assertEquals(30, munroList.getListSize());
        assertEquals(10, munroList.limitToTenResults().size());
    }

    @Test
    public void canLimitSortWhenListLessThanTen(){
        munroList.addMunro(munro1);
        munroList.addMunro(munro2);
        munroList.addMunro(munro3);
        munroList.addMunro(munro4);
        munroList.addMunro(munro5);
        munroList.addMunro(munro6);
        assertEquals(6, munroList.limitToTenResults().size());
    }

    @Test
    public void canSortNameAscending(){

//        set out of order deliberately.
        munroList.addMunro(munro2);
        munroList.addMunro(munro1);
        munroList.addMunro(munro3);
        munroList.addMunro(munro5);
        munroList.addMunro(munro6);
        munroList.addMunro(munro4);

        munroList.sortNameAscending();
        assertEquals(0, munroList.getIndexOf(munro1));
        assertEquals(5, munroList.getIndexOf(munro3));
    }

    @Test
    public void canSortNameDescending(){

//        set out of order deliberately.
        munroList.addMunro(munro2);
        munroList.addMunro(munro1);
        munroList.addMunro(munro3);
        munroList.addMunro(munro5);
        munroList.addMunro(munro6);
        munroList.addMunro(munro4);

        munroList.sortNameDescending();
        assertEquals(0, munroList.getIndexOf(munro3));
        assertEquals(5, munroList.getIndexOf(munro1));
    }


    @Test
    public void canLimitResultsToTop10(){
        for (int i = 0; i < 5; i++) {
            munroList.addMunro(munro1);
            munroList.addMunro(munro2);
            munroList.addMunro(munro3);
            munroList.addMunro(munro4);
            munroList.addMunro(munro5);
            munroList.addMunro(munro6);
        }
        assertEquals(30, munroList.getListSize());
        assertEquals(0, munroList.getIndexOf(munro1));
        assertEquals(10, munroList.limitToTenResults().size());
    }

    @Test
    public void canSetMinimumHeight(){
        munroList.addMunro(munro1);
        munroList.addMunro(munro2);
        munroList.addMunro(munro3);
        munroList.addMunro(munro4);
        munroList.addMunro(munro5);
        munroList.addMunro(munro6);
        assertEquals(6, munroList.getListSize());
        assertEquals(2, munroList.getMunrosAboveLimit(1000).size());
    }

    @Test
    public void canSetMaximumHeight(){
        munroList.addMunro(munro1);
        munroList.addMunro(munro2);
        munroList.addMunro(munro3);
        munroList.addMunro(munro4);
        munroList.addMunro(munro5);
        munroList.addMunro(munro6);
        assertEquals(4, munroList.getMunrosBelowLimit(1000).size());
    }

    @Test
    public void canGetMunrosInbetweenDefinedHeightValues(){
        munroList.addMunro(munro1);
        munroList.addMunro(munro2);
        munroList.addMunro(munro3);
        munroList.addMunro(munro4);
        munroList.addMunro(munro5);
        munroList.addMunro(munro6);
        ArrayList selected = munroList.getMunrosBetweenMaxAndMinHeights(931, 974);
        assertEquals(2, selected.size());
    }

    @Test
    public void canHandleWrongInputValuesForMaxAndMinHeight(){
        munroList.addMunro(munro1);
        munroList.addMunro(munro2);
        munroList.addMunro(munro3);
        munroList.addMunro(munro4);
        munroList.addMunro(munro5);

        ArrayList selected = munroList.getMunrosBetweenMaxAndMinHeights(1000, 900);
        assertEquals(5, selected.size());
    }

    @Test
    public void canGetMunrosOfSpecificType(){
        munroList.addMunro(munro1);
        munroList.addMunro(munro2);
        munroList.addMunro(munro3);
        munroList.addMunro(munro4);
        munroList.addMunro(munro5);
        munroList.addMunro(munro6);
//        added munro with empty type value for test
        munroList.addMunro(munro7);
        ArrayList resultTop = munroList.getTypeOfMunros("TOP");
        assertEquals(1, resultTop.size());
        ArrayList resultMun = munroList.getTypeOfMunros("MUN");
        assertEquals(5, resultMun.size());
    }

    @Test
    public void defaultIfMunroTypeNotGiven(){
        munroList.addMunro(munro1);
        munroList.addMunro(munro2);
        munroList.addMunro(munro3);
        munroList.addMunro(munro4);
        munroList.addMunro(munro5);
        munroList.addMunro(munro6);
        ArrayList resultNonInput = munroList.getTypeOfMunros("");
        assertEquals(5, resultNonInput.size());
    }
}
