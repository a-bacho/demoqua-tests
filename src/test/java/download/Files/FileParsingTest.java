package download.Files;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class FileParsingTest {

    //private ClassLoader cl = FileParsingTest.class.getClassLoader();

    void addToZip() throws IOException {
        List<String> srcFiles = Arrays.asList("src/test/resources/files/testCsv.csv", "src/test/resources/files/testExcel.xlsx", "src/test/resources/files/testPdf.pdf");
        FileOutputStream fos = new FileOutputStream("testZip.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        for (String srcFile : srcFiles) {
            File fileToZip = new File(srcFile);
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
        zipOut.close();
        fos.close();
    }

    @Test
    void parseFilesTest() throws Exception {

        addToZip();
        ZipFile zipFile = new ZipFile("testZip.zip");

        ZipEntry csvTest = zipFile.getEntry("testCsv.csv");
        ZipEntry excelTest = zipFile.getEntry("testExcel.xlsx");
        ZipEntry pdfTest = zipFile.getEntry("testPdf.pdf");

        try (InputStream inputStream = zipFile.getInputStream(csvTest)) {
            CSVReader reader = new CSVReader(new InputStreamReader(inputStream));
            List<String[]> list = reader.readAll();
            assertThat(list)
                    .hasSize(2)
                    .contains(

                            new String[]{"1", "2", "3", "4"},
                            new String[]{"w", "d", "s", "f"}
                    );
        }

        try (InputStream inputStream = zipFile.getInputStream(excelTest)) {
            //check excel

            XLS parsed = new XLS(inputStream);
            assertThat(parsed.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue())
                    .isEqualTo("EXCEL");
            assertThat(parsed.excel.getSheetAt(0).getRow(0).getCell(1).getStringCellValue())
                    .isEqualTo("TEST");
        }


        try (InputStream inputStream = zipFile.getInputStream(pdfTest)) {
            //check pdf
            PDF parsed = new PDF(inputStream);
            assertThat(parsed.text).contains("TEST PDF");

        }

    }


}

