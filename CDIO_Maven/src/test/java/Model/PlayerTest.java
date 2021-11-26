package Model;

import org.junit.jupiter.api.Test;

import javax.xml.namespace.QName;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getMoney() {
        Player p = new Player("m",20);
        assertEquals("m",p.getMoney());
    }
}