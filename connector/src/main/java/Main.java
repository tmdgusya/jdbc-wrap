import reader.ReadConfiguration;
import reader.ReadXmlConfigure;

public class Main {

    public static void main(String[] args) {
        ReadConfiguration readConfiguration = new ReadXmlConfigure();

        readConfiguration.read("/Users/roach/Desktop/study/jdbc-wrap/connector/src/main/resources/connector.xml");
    }

}
