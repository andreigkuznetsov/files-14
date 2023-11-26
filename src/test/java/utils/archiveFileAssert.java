package utils;

import org.assertj.core.api.Assertions;

import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class archiveFileAssert {

    private final ClassLoader classLoader;

    public archiveFileAssert(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public void assertFileInZip(String archiveName, String expectedFileName,
                                long expectedCompressedSize, long expectedSize) throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                Objects.requireNonNull(classLoader.getResourceAsStream(archiveName))
        )) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals(expectedFileName)) {
                    Assertions.assertThat(entry.getCompressedSize()).isEqualTo(expectedCompressedSize);
                    Assertions.assertThat(entry.getSize()).isEqualTo(expectedSize);
                    return;
                }
            }
            Assertions.fail("Файл " + expectedFileName + " не найден в архиве.");
        }
    }
}

