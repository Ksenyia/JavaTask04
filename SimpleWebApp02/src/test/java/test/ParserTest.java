package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import by.tr.web.dao.impl.DAOImpl;
import by.tr.web.entity.flower.Flower;

public class ParserTest {

    @Test
    public void testCalA() throws Exception {
    	DAOImpl dao = new DAOImpl();
        List<Flower> n = dao.parseSAX();
 
        assertEquals(0, n);
    }
}
