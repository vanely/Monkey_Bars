import music.Theory;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TheoryTest {


    @BeforeEach
    void init() {
    }

    @BeforeAll
    static void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void done() {
    }

    @Test
    void testCreateScalesSpacingList() {
    }

    @Test
    void testCreateModesList() {
    }

    @DisplayName("Test whether getRomanNumeral(int) correctly converts numbers to roman numerals.")
    @Test
    void testGetRomanNumeral() {
        assertAll("All values convert to roman numerals",
                () -> assertEquals(Theory.getRomanNumeral(2510), "MMDX"),
                () -> assertEquals(Theory.getRomanNumeral(2046), "MMXLVI"),
                () -> assertEquals(Theory.getRomanNumeral(3708), "MMMDCCVIII"),
                () -> assertEquals(Theory.getRomanNumeral(1086), "MLXXXVI"),
                () -> assertEquals(Theory.getRomanNumeral(2906), "MMCMVI"),
                () -> assertEquals(Theory.getRomanNumeral(3912), "MMMCMXII"),
                () -> assertEquals(Theory.getRomanNumeral(3857), "MMMDCCCLVII"),
                () -> assertEquals(Theory.getRomanNumeral(915), "CMXV"),
                () -> assertEquals(Theory.getRomanNumeral(3022), "MMMXXII"),
                () -> assertEquals(Theory.getRomanNumeral(3696), "MMMDCXCVI"),
                () -> assertEquals(Theory.getRomanNumeral(1), "I"),
                () -> assertEquals(Theory.getRomanNumeral(2), "II"),
                () -> assertEquals(Theory.getRomanNumeral(3), "III"),
                () -> assertEquals(Theory.getRomanNumeral(4), "IV"),
                () -> assertEquals(Theory.getRomanNumeral(5), "V"),
                () -> assertEquals(Theory.getRomanNumeral(6), "VI"),
                () -> assertEquals(Theory.getRomanNumeral(7), "VII"),
                () -> assertEquals(Theory.getRomanNumeral(8), "VIII"),
                () -> assertEquals(Theory.getRomanNumeral(9), "IX"),
                () -> assertEquals(Theory.getRomanNumeral(10), "X")
        );
    }

    @Test
    void testGetOctaveBaseList() {
    }

    @Test
    void testGetScale() {
    }

    @Test
    void testGetScale1() {
    }

    @Test
    void testGetBaseEquivalent() {
    }

    @Test
    void testGetSingleFlatEquivalent() {
    }

    @Test
    void testGetFlatishEquivalent() {
    }

    @Test
    void testGetSingleSharpEquivalent() {
    }

    @Test
    void testGetSharpishEquivalent() {
    }

    @Test
    void testGetCircleLabel() {
    }

    @Test
    void testGetMajorScale() {
    }

    @Test
    void testGetNaturalMinorScale() {
    }

    @Test
    void testGetBase() {
    }

    @Test
    void testNormalizeScale() {
    }
}