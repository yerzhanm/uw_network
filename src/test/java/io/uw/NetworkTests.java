package io.uw;

import org.junit.Test;

public class NetworkTests {

    @Test(expected = IllegalArgumentException.class)
    public void negativeSize(){
        Network network = new Network(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroSize(){
        Network network = new Network(0);
    }
}
