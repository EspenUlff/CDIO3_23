package Model;

import org.junit.jupiter.api.Test;

import javax.xml.namespace.QName;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getMoney() {
        Player p = new Player("millions",20);
        assertEquals("millions",p.getMoney());
    }
}