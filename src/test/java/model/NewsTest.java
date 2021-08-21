package model;

import models.News;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NewsTest {

    @Test
    public void NewsClassCreatesInstances(){
        News news = new News(
                    "Angry man Vandalizes Property",
                    "An angry man vandalized property in Nairobi",
                    "Larry Madowo"
                    );
        Assertions.assertEquals(true, news instanceof News);
    }

    @Test
    public void allVariablesInNewsClassAreAssignable(){
        News news = new News(
                "Angry man Vandalizes Property",
                "An angry man vandalized property in Nairobi",
                "Larry Madowo"
        );
        news.setHeader("Curfew");
        news.setContent("Curfew extended to June 2022");
        news.setWritten_by("Jeff Koinange");
        Assertions.assertEquals("Curfew", news.getHeader());
        Assertions.assertEquals("Curfew extended to June 2022", news.getContent());
        Assertions.assertEquals("Jeff Koinange", news.getWritten_by());
    }
}
