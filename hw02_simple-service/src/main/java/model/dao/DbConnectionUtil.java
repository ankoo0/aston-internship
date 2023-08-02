package model.dao;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DbConnectionUtil {

    private static DataSource dataSource;
    private static Properties properties;

    static {
        try {
            dataSource = new PGSimpleDataSource();
            properties = new Properties();
            properties.load(new FileInputStream(""));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
