package catcafe;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatCafeTest {
    CatCafe cafe;
    FelineOverLord bob;
    FelineOverLord franzis;
    FelineOverLord mizie;
    FelineOverLord kadse;
    FelineOverLord hollie;
    FelineOverLord maomao;
    FelineOverLord walthazarbobalthazarfeefifofalthazarTheThird;

    @BeforeEach
    void setUp(){
        // Erstelle das Cafe
        cafe = new CatCafe();
        // Erstelle die Katzen
        bob = new FelineOverLord("Bob", 7);
        franzis = new FelineOverLord("Franzis", 9);
        mizie = new FelineOverLord("Mizie", 3);
        kadse = new FelineOverLord("Kadse", 8);
        hollie = new FelineOverLord("Hollie", 2);
        maomao = new FelineOverLord("Maomao", 6);
        // https://www.tiktok.com/@walter.the.catt/video/7113298348253269253?q=cat%20waltaza&t=1748542190499
        walthazarbobalthazarfeefifofalthazarTheThird = new FelineOverLord("Walthazarbobalthazarfeefifofalthazar The Third", 5);

        cafe.addCat(bob);
        cafe.addCat(franzis);
        cafe.addCat(mizie);
        cafe.addCat(kadse);
        cafe.addCat(maomao);
        cafe.addCat(walthazarbobalthazarfeefifofalthazarTheThird);
    }

    @Test
    void testAddCat() {
        cafe.addCat(hollie);
        assertEquals(hollie, cafe.getCatByName("Hollie"));
    }

    @Test
    void testGetCatCount() {
        assertEquals(6, cafe.getCatCount());
    }

    @Test
    void testGetCatByNameReturnNull() {
        assertNull(cafe.getCatByName("Masha"));
    }

    @Test
    void testGetCatByName() {
        FelineOverLord cat = cafe.getCatByName("Maomao");
        assertEquals(maomao, cat);
    }

    @Test
    void testGetCatByWeight() {
        assertEquals(walthazarbobalthazarfeefifofalthazarTheThird, cafe.getCatByWeight(5, 6));
    }

    @Test
    void testGetCatByWeightIsNull() {
        assertNull(cafe.getCatByWeight(15, 17));
    }

    @Test
    void testGetCatCountIsZero() {
        assertEquals(0, new CatCafe().getCatCount());
    }

    @Test
    void testAddOtherCat() {
        cafe.addCat(hollie);
        assertEquals(hollie, cafe.getCatByName("Hollie"));
    }

    @Test
    void testGetCatByWeightMaxSmallerThanMin() {
        assertNull(cafe.getCatByWeight(4, 2));
    }

    @Test
    void testGetCatByWeightOutsideSelectionArea() {
        assertNull(cafe.getCatByWeight(-5, -2));
    }
}
