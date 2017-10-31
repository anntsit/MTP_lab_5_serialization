import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class OrgJSONTest {
    private ArrayList<Plate> plates = Main.generatePlates();

    @Test
    public void serialize() throws Exception{
        assertNotNull(OrgJSON.serialize(plates));
    }

    @Test
    public void deserialize()throws Exception{
        assertNotEquals(OrgJSON.serialize(plates),
                OrgJSON.deserialize(OrgJSON.serialize(plates)));
    }

}