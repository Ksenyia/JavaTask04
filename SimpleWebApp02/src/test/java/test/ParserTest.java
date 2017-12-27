package test;

import static org.junit.Assert.assertEquals;


import java.util.List;

import org.junit.Test;

import by.tr.web.dao.DOMBuilder;
import by.tr.web.dao.Director;
import by.tr.web.dao.SAXBuilder;
import by.tr.web.dao.StAXBuilder;
import by.tr.web.entity.Growing;
import by.tr.web.entity.Visual;
import by.tr.web.entity.flower.Flower;
import by.tr.web.entity.flower.PerennialsFlower;
import by.tr.web.service.Service;
import by.tr.web.service.impl.ServiceImpl;

public class ParserTest {

    @Test
    public void testParseSAX() throws Exception {
        List<Flower> test = Director.createOrangery(new SAXBuilder());
        Flower result = new PerennialsFlower("Rose","f2","Greece","sod-podzolic",new Visual("Green", "White", 75),"cuttings",new Growing(20, 80));
        assertEquals(result, test.get(1));
    }
    @Test
    public void testParseSTAX() throws Exception {
        List<Flower> test = Director.createOrangery(new StAXBuilder());
        Flower result = new PerennialsFlower("Kermek","f6","Central Asia","subsoil",new Visual("Green", "Blue", 40),"seeds",new Growing(18, 10));

        assertEquals(result, test.get(5));
    }
    @Test
    public void testParse() throws Exception {
    	Service service = new ServiceImpl();
        List<Flower> test = service.parse("SAX");
        Flower result = new PerennialsFlower("Kermek","f6","Central Asia","subsoil",new Visual("Green", "Blue", 40),"seeds",new Growing(18, 10));
        assertEquals(result, test.get(5));
    }
    @Test
    public void testParseDOM() throws Exception {
        List<Flower> test = Director.createOrangery(new DOMBuilder());
        Flower result = new PerennialsFlower("Kermek","f6","Central Asia","subsoil",new Visual("Green", "Blue", 40),"seeds",new Growing(18, 10));
        assertEquals(result, test.get(5));
    }
}
