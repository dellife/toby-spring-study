package com.dellife.springbook.user.dao;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class JUnitTest {

    static Set<JUnitTest> testObjects = new HashSet<JUnitTest>();

    @Test
    void test1() {
        assertThat(testObjects).doesNotContain(this);
        testObjects.add(this);
    }

    @Test
    void test2() {
        assertThat(testObjects).doesNotContain(this);
        testObjects.add(this);
    }

    @Test
    void test3() {
        assertThat(testObjects).doesNotContain(this);
        testObjects.add(this);
    }
}
