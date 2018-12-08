import com.jwojcik.Helper;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * @author jrwoj
 * createdOn 08.12.2018
 */

public class HelperTest {

    @Test
    public void readTest(){

    }

    @Test
    public void saveTest(){
        HashMap<String, Integer> params = new HashMap<>();

        params.put("key1", 1);
        params.put("key2", 2);
        params.put("key3", 3);

        Helper.saveToFile(params, "./src/main/java/resources/save_test.txt");
        assertTrue(true);
    }
}
