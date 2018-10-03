import com.microsoft.sqlserver.jdbc.SQLServerException;
import org.junit.*;
import org.apache.log4j.*;
import java.util.List;
import com.microsoft.sqlserver.jdbc.*;
import java.net.UnknownHostException;

import static org.mockito.Mockito.*;

/**
 * Created by zureklu on 26/09/2018.
 */
public class uczymysieTest {

    final static Logger logger = Logger.getLogger(uczymysieTest.class);

    //@Test
    public void test01(){
        logger.info("XXXXXXX Test1 XXXXXXX");
        Assert.assertEquals("HELLO","Alex","Alex");
    }

    @Test
    public void test02(){
        try{
            logger.info("Starting test.");
            czytamyDB a = new czytamyDB();
            logger.info("Connecting to DB.");
            a.getTestIdsFromDb();
            Assert.assertEquals("HELLO","Alex2","Alex");
        }
        catch(ComparisonFailure e){
            logger.fatal("Comparison error: " + e);
        }
        catch(SQLServerException e){
            logger.fatal("XXXX DB problem");
        }
        catch(UnknownHostException e){
            logger.fatal("XXXX Host DB nieznany");
        }
        catch(Exception e){
            logger.fatal("XXXX Host DB nieznany");
        }
    }

    //@Test
    public void test03(){
        logger.warn("XXXXXXX This is warn XXXXXXXX");
        logger.warn("Dodane");
        logger.error("XXXXXXX This is error XXXXXXX");
        logger.fatal("XXXXXXX This is fatal XXXXXXX");
        Assert.assertEquals("HELLO","Alex3","Alex");
    }

    @Test
    public void test04(){
        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.clear();
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }
}
