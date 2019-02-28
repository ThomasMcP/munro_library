import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MunroListTest {

    Munro munro1;
    Munro munro2;
    Munro munro3;
    Munro munro4;
    Munro munro5;
    MunroList munroList;

    @Before
    public void setUp(){
        munro1 = new Munro("Ben Chonzie", 931, "MUN", "NN773308");
        munro2 = new Munro("Ben Vorlich", 985, "MUN", "NN773308");
        munro3 = new Munro("Stuc a' Chroin", 975, "MUN", "NN773308");
        munro4 = new Munro("Ben Lomond", 974, "MUN", "NN773308");
        munro5 = new Munro("Ben More", 1174, "MUN", "NN773308");
        munroList = new MunroList();
    }

    @Test
    public void munroListIsIntiallyEmpty(){
        assertEquals(0, munroList.getMunroList().size());
    }

}