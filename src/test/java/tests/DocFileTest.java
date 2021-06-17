package tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readDocFile;
import static utils.Files.readDocxFile;


public class DocFileTest {
    @Test
    void docTest() throws IOException {
        String docFilePath = "./src/test/resources/files/file.doc";
        String expectedData = "Wenn der Bär nach Hause kommt";

        String actualData = readDocFile(docFilePath);
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    void docxTest() throws IOException {
        String docFilePath = "./src/test/resources/files/file.docx";
        String expectedData = "Mutter oh gib mir Kraft";

        String actualData = readDocxFile(docFilePath);
        assertThat(actualData, containsString(expectedData));
    }
}
