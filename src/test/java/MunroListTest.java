import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MunroListTest {

    Munro munro1;
    Munro munro2;
    Munro munro3;
    Munro munro4;
    Munro munro5;
    Munro munro6;
    MunroList munroList;

    @Before
    public void setUp(){
        munro1 = new Munro("Ben Chonzie", 931, "MUN", "NN773308");
        munro2 = new Munro("Ben Vorlich", 985, "MUN", "NN773308");
        munro3 = new Munro("Stuc a' Chroin", 975, "MUN", "NN773308");
        munro4 = new Munro("Ben Lomond", 974, "MUN", "NN773308");
        munro5 = new Munro("Ben More", 1174, "MUN", "NN773308");
        munro6 = new Munro("Stob Binnein - Stob Coire an Lochain", 1068, "TOP", "NN438220");

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



}
