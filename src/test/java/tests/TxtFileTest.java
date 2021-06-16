package tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readTextFromPath;


public class TxtFileTest {
    @Test
    void txtTest() throws IOException {
        String txtFilePath = "./src/test/resources/files/file.txt";
        String expectedData = "Wenn der Bär nach Hause kommt";

        String actualData = readTextFromPath(txtFilePath);
        assertThat(actualData, containsString(expectedData));
    }
}
