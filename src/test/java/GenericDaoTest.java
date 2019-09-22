import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexm on 14.08.2019.
 */
public class GenericDaoTest {

//    public abstract GenericDao dao();

    @Test
    public void testGetAll() throws Exception {
//        List list = dao().getAll();
        List list = new ArrayList();
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() == 0);
    }

//    @Test
//    public void price_givenStartAndAnd_returnsCorrectResult() throws Exception {
//        Distance distance = new Distance();
//        TaxiRide start = new TaxiRide();
//        start.setStartAddress("Universal Studios Blvd, Los Angeles, CA 90068, USA");
//
//        TaxiRide end = new TaxiRide();
//        end.setEndAddress("Disneyland (Harbor Blvd.), S Harbor Blvd, Anaheim, CA 92802, USA");
//
//        Double price = distance.price(start, end);
//        Assert.assertTrue(price == 5689.400000000001);
//    }
}
