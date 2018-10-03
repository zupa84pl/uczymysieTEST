import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.microsoft.sqlserver.jdbc.*;
import java.net.UnknownHostException;
/**
 * Created by zureklu on 28/09/2018.
 */
public class czytamyDB {

    public ArrayList<String> testIDs = new ArrayList<String>();

    public ArrayList<String> getTestIdsFromDb() throws Exception {

        ArrayList<String> results = new ArrayList<String>();
            Class<?> aClass = Class.forName(SQLServerDriver.class.getName());
            String dbUrl = "jdbc:sqlserver://s-ishs-st-bt2;instanceName=first;databaseName=ResponseSimulator;user=testingUser;password=test123";
            Connection c;
            c = DriverManager.getConnection(dbUrl);
            String query = "SELECT [ControlTestId] FROM [ResponseSimulator].[erru].[CheckGoodReputeGeneralTests]";
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("ControlTestId"));
                results.add(rs.getString("ControlTestId"));
            }

            return results;
    }

    public static void main(String[] arg){
        czytamyDB a = new czytamyDB();
        try{
            a.getTestIdsFromDb();}
        catch(Exception e){
                  System.out.print(e);
        }
        }

    }

