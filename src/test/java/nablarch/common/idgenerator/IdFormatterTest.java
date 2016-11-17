package nablarch.common.idgenerator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import nablarch.common.idgenerator.formatter.LpadFormatter;

import org.junit.Test;

/**
 * {@link IdFormatter}のテスト
 */
public class IdFormatterTest {

    @Test
    public void generateTest() throws Exception {
        final IdGenerator sut = new IdGenerator() {
            int seq = 0;
            @Override
            public String generateId(final String id) {
                return id + "-" + ++seq;
            }

            @Override
            public String generateId(final String id, final IdFormatter formatter) {
                return id + "-" + formatter.format(id, String.valueOf(++seq));
            }
        };

        assertThat(sut.generateId("test"), is("test-1"));
        assertThat(sut.generateId("test"), is("test-2"));

        final LpadFormatter formatter = new LpadFormatter(10, '0');
        assertThat(sut.generateId("id", formatter), is("id-0000000003"));
    }
}