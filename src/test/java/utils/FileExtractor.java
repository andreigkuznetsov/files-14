package utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileExtractor {

    public byte[] extractFileFromZip(String archiveName, String fileName) throws IOException {
        try (InputStream inputStream = FileExtractor.class.getClassLoader().getResourceAsStream(archiveName)) {
            assert inputStream != null;
            try (ZipInputStream zipInputStream = new ZipInputStream(inputStream);
                 ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

                ZipEntry entry;
                while ((entry = zipInputStream.getNextEntry()) != null) {
                    if (entry.getName().equals(fileName)) {
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = zipInputStream.read(buffer)) > 0) {
                            outputStream.write(buffer, 0, len);
                        }
                        return outputStream.toByteArray();
                    }
                }
            }
        }
        throw new IllegalArgumentException("Файл " + fileName + " не найден в архиве " + archiveName);
    }
}
