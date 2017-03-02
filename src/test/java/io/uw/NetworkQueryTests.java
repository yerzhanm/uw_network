package io.uw;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NetworkQueryTests{

    private static Network network;

    @BeforeClass
    public static void setUp(){
        network = new Network(8);
        network.connect(1, 2);
        network.connect(6, 2);
        network.connect(2, 4);
        network.connect(5, 8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void outOfRangeSource(){
        network.query(9, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void outOfRangeDest(){
        network.query(1, 12);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroSource(){
        network.query(0, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroDest(){
        network.query(1, 0);
    }

    @Test
    public void checkDirectConnection(){
        assertTrue("Direct connection error", network.query(1, 2));
    }

    @Test
    public void checkIndirectConnection(){
        assertTrue("Indirect connection error", network.query(1, 6));
    }

    @Test
    public void checkNotConnected(){
        assertFalse("not connected error", network.query(7, 4));
    }
}
