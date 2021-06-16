package tests;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.codeborne.xlstest.XLS.containsText;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.getFile;
import static utils.Files.readXlsxFromPath;

public class XlsFileTest {
    @Test
    void xlsSimpleTest() throws IOException {
        String xlsFilePath = "./src/test/resources/files/file.xls";
        String expectedData = "Humpty-Dumpty";

        XLS xls = new XLS(getFile(xlsFilePath));
        assertThat(xls, containsText(expectedData));
    }

    @Test
    void xlsCellTest() throws IOException {
        String xlsFilePath = "./src/test/resources/files/file.xls";
        String expectedData = "Had a great fall";

        XLS xls = new XLS(getFile(xlsFilePath));
        String actualData = xls.excel.getSheetAt(0).getRow(3).getCell(0).toString();
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    void xlsxTest() {
        String xlsFilePath = "./src/test/resources/files/file.xlsx";
        String expectedData = "Three little kittens";

        String actualData = readXlsxFromPath(xlsFilePath);
        assertThat(actualData, containsString(expectedData));
    }
}
