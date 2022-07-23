package com.sharansh.karate.karatetests;

import com.intuit.karate.junit5.Karate;
import com.sharansh.karate.KarateApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = {KarateApplication.class})
public class Tests {

    @Karate.Test
    Karate getEmployeeTest() {
        return Karate.run("employee").relativeTo(getClass());
    }
}
