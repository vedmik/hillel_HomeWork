package org.example;

import org.junit.Assert;
import org.junit.Test;

public class IdenticalPairsTest {
    @Test
    public void numIdenticalPairsTest() {
        IdenticalPairs identicalPairs = new IdenticalPairs();

        Assert.assertEquals(10, identicalPairs.numIdenticalPairs(new int[]{1,1,1,1,1}));
    }
}
