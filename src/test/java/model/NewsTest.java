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


}
