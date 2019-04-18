import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
public class sfmTest {
    @Test
    public void testReflexive(){
        sfm s1 = sfm.of(1000,12222);
        assertTrue(s1.equals(s1));
    }
    @Test
    public void testNonNull(){
        sfm s1 = sfm.of(32323,2323);
        assertFalse(s1.equals(null));
    }
}