package tests;

import net.lingala.zip4j.exception.ZipException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readTextFromPath;
import static utils.Zip.unzip;

public class ZipFileTest {
    @Test
    void zipTest() throws IOException, ZipException {
        String zipFilePath = "./src/test/resources/files/file.zip";
        String unzipFolderPath = "./src/test/resources/files/unzip";
        String password = "password";
        String unzipTxtFilePath = "./src/test/resources/files/unzip/file.txt";
        String expectedData = "Wenn der Bär nach Hause kommt";

        unzip(zipFilePath, unzipFolderPath, password);
        String actualData = readTextFromPath(unzipTxtFilePath);
        assertThat(actualData, containsString(expectedData));
    }
}
