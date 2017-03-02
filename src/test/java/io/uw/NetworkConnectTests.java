package io.uw;

import org.junit.BeforeClass;
import org.junit.Test;

public class NetworkConnectTests{

    private static Network network;

    @BeforeClass
    public static void setUp(){
        network = new Network(8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void outOfRangeSource(){
        network.connect(9, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void outOfRangeDest(){
        network.connect(1, 12);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroSource(){
        network.connect(0, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroDest(){
        network.connect(1, 0);
    }

}
