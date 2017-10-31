import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class JacksonTest {

    private ArrayList<Plate> plates = Main.generatePlates();

    @Test
    public void serialize() throws Exception{
        assertNotNull(Jackson.serialize(plates));
    }

    @Test
    public void deserialize()throws Exception{
        assertNotEquals(Jackson.serialize(plates),
                Jackson.deserialize(Jackson.serialize(plates)));
    }

}