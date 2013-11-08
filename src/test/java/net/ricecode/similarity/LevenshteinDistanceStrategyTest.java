package net.ricecode.similarity;

import org.junit.Test;
import static org.junit.Assert.*;

public class LevenshteinDistanceStrategyTest {

    @Test (expected = NullPointerException.class)
    public void testNullThrows() {
        LevenshteinDistanceStrategy lds = new LevenshteinDistanceStrategy();
        lds.score(null, "kEvIn");
    }

    @Test
    public void emptyStringTest() {
        LevenshteinDistanceStrategy lds = new LevenshteinDistanceStrategy();
        double response = lds.score("", "");
        assertEquals(1.0, response, 0.0);
    }

    @Test
    public void testExactMatchDifferentCase() {
        LevenshteinDistanceStrategy lds = new LevenshteinDistanceStrategy();
        double response = lds.score("KeViN", "kevin");
        assertEquals(1.0, response, 0.0);
    }

    @Test
    public void testExactMatchSameCase() {
        LevenshteinDistanceStrategy lds = new LevenshteinDistanceStrategy();
        double response = lds.score("java", "java");
        assertEquals(1.0, response, 0.0);
    }

    @Test
    public void testNoSimilarity() {
        LevenshteinDistanceStrategy lds = new LevenshteinDistanceStrategy();
        double response = lds.score("abc", "def");
        assertEquals(0.0, response, 0.0);
    }

    @Test
    public void score1() {
        LevenshteinDistanceStrategy lds = new LevenshteinDistanceStrategy();
        double response = lds.score("he", "head");
        assertEquals(0.5d, response, 0.0001d);
    }

    @Test
    public void score2() {
        LevenshteinDistanceStrategy lds = new LevenshteinDistanceStrategy();
        double response = lds.score("hd", "head");
        assertEquals(0.5d, response, 0.0001d);
    }

    @Test
    public void score3() {
        LevenshteinDistanceStrategy lds = new LevenshteinDistanceStrategy();
        double response = lds.score("d", "head");
        assertEquals(0.25d, response, 0.0001d);
    }

    @Test
    public void score4() {
        LevenshteinDistanceStrategy lds = new LevenshteinDistanceStrategy();
        double response = lds.score("head", "he");
        assertEquals(0.5d, response, 0.0001d);
    }

    @Test
    public void score5() {
        LevenshteinDistanceStrategy lds = new LevenshteinDistanceStrategy();
        double response = lds.score("kitten", "sitting");
        assertEquals(0.5714d, response, 0.0001d);
    }

    @Test
    public void score6() {
        LevenshteinDistanceStrategy lds = new LevenshteinDistanceStrategy();
        double response = lds.score("Saturday", "Sunday");
        assertEquals(0.625d, response, 0.0001d);
    }




}
