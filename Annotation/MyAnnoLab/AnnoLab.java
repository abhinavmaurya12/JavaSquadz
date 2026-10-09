package MyAnnoLab;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention (RetentionPolicy.RUNTIME)
@Target (ElementType.TYPE)
@interface AnnoLab {
    String name1();
    String name2();
    String name3();

    int TimePM1();
    int TimePM2();
    int TimePM3();
}
