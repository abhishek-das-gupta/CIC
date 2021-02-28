package effective.java.generics.genrify.method;

import org.junit.Test;

public class SwapUtilTest {

    @Test
    public void testGenerify() {
        Integer[] given = {new Integer(1), new Integer(2), new Integer(3), new Integer(4)};
        Integer[] expected = {new Integer(3), new Integer(2), new Integer(1), new Integer(4)};
        Integer[] actual = SwapUtil.swapElements(given,0,2);
        for(int i=0; i<actual.length; ++i) {
            assert actual[i].equals(expected[i]);
        }
    }

}
