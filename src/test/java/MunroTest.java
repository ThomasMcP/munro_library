import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MunroTest {

    Munro munro;

    @Before
    public void setUp(){
        munro = new Munro("Ben Chonzie", 931, "MUN", "NN773308");
    }

    @Test
    public void munroHasName(){
        assertEquals("Ben Chonzie", munro.getName());
    }




}
