package programmerzamannow.records.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataTest {
    @Test
    void generic() {
        Data<String> data = new Data<>("Alvenio");
        assertEquals("Alvenio", data.data());

        Data<Integer> data2 = new Data<>(100);
        assertEquals(100, data2.data());
    }
}