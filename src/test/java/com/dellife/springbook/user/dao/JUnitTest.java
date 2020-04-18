package com.dellife.springbook.user.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class JUnitTest {

    @Autowired
    ApplicationContext context;

    static Set<JUnitTest> testObjects = new HashSet<JUnitTest>();
    static ApplicationContext contextObject = null;

    @Test
    void test1() {
        assertThat(testObjects).doesNotContain(this);
        testObjects.add(this);

        assertThat(contextObject).isNull();
        contextObject = this.context;
    }

    @Test
    void test2() {
        assertThat(testObjects).doesNotContain(this);
        testObjects.add(this);

        assertThat(contextObject).isEqualTo(this.context);
        contextObject = this.context;
    }

    @Test
    void test3() {
        assertThat(testObjects).doesNotContain(this);
        testObjects.add(this);

        assertThat(contextObject).isEqualTo(this.context);
        contextObject = this.context;
    }
}
