package com.shaonvyuan.test;

import com.shaonvyuan.test.search.MainPage;
import com.shaonvyuan.test.search.SearchPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class ShaonvyuanPOTest {

    private MainPage main;

    @BeforeAll
    static void beforeAll(){

    }

    @Test
    void testWeb() throws InterruptedException {
        MainPage main = new MainPage();
        String title = main.start().searchTitle();
        assertThat(title, containsString("少女愿"));
    }

}
