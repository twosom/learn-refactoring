package com.icloud.refactoring._13_loop._01_replace_loop_with_pipeline;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthorTest {

    @Test
    void twitterHandler() {
        Author hope = new Author("ms", null);
        Author twosom = new Author("naver", "twosom");
        assertEquals(List.of("twosom"), Author.twitterHandles(List.of(hope, twosom), "naver"));
    }

}