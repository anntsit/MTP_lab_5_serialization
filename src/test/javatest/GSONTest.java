import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class GSONTest {
    private ArrayList<Plate> plates = Main.generatePlates();

    @Test
    public void serialize() {
        assertNotNull(GSON.serialize(plates));
    }

    @Test
    public void deserialize()  {
        assertNotEquals(GSON.serialize(plates),
                GSON.deserialize(GSON.serialize(plates)));
    }

}