package nablarch.common.idgenerator.formatter;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * {@link LpadFormatter}のテスト
 *
 * @author Hisaaki Sioiri
 */
public class LpadFormatterTest {
    @Test
    public void testFormat() throws Exception {
        LpadFormatter formatter = new LpadFormatter(10, '0');
        assertThat(formatter.format("01", "100"), is("0000000100"));
        assertThat(formatter.format("01", "1234567890"), is("1234567890"));
        assertThat(formatter.format("01", "12345678901"), is("12345678901"));
    }

    @Test
    public void testSetter() throws Exception {
        LpadFormatter formatter = new LpadFormatter();
        formatter.setLength(10);
        formatter.setPaddingChar("0");
        assertThat(formatter.format("01", "100"), is("0000000100"));
        assertThat(formatter.format("01", "1234567890"), is("1234567890"));
        assertThat(formatter.format("01", "12345678901"), is("12345678901"));
    }
    
    @Test
    public void testSetterError() throws Exception {
        LpadFormatter formatter = new LpadFormatter();
        try {
            formatter.setPaddingChar("01");
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage(), is("invalid paddingChar length. must be length eq 1."));
        }

        try {
            formatter.setPaddingChar("");
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage(), is("invalid paddingChar length. must be length eq 1."));
        }
    }
}
