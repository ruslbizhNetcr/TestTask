package MegaputerIntelligence;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 *
 */
public class NumSearchTest
{
    private NumSearch numSearch = new NumSearch();

    @Before
    public void init() {
        numSearch.setMassive(NumSearch.generateMassive(20));
    }

    @Test
    public void checkMassive() {
        assertEquals(NumSearch.N, numSearch.getMassive().size());
        assertTrue(numSearch.getMassive().get(0) < numSearch.getMassive().get(1));
    }


    @Test
    public void mainTestOne() {
        //Massive starts from value > 0 (20) and than values were incremented.
        //So modification of value of the first element won't break increasing order
        numSearch.getMassive().set(0, 0.55);//setting search item with index 0
        assertEquals(0, numSearch.findNumber(numSearch.getMassive()));
    }

    @Test
    public void mainTestTwo() {
        numSearch.setMassive(NumSearch.generateMassive(-10));
        //Massive starts from negative value and than values were incremented.
        // So modification of value of the last element won't break increasing order
        numSearch.getMassive().set(999_999, 999_999.55);//setting search item with index 999_999
        assertEquals(999_999, numSearch.findNumber(numSearch.getMassive()));
    }
}







