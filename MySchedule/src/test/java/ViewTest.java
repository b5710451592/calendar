import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import java.sql.SQLOutput;

import static org.junit.Assert.*;

public class ViewTest {

    @Test
    public void testString(){
        MySchedule n=new MySchedule("20/5/60","20.00 am","eate some thing");
        String result =n.getTextDate()+" | "+n.getTextTime()+" | "+n.getTextNote();
        assertEquals("20/5/60 | 20.00 am | eate some thing",result);

    }













}