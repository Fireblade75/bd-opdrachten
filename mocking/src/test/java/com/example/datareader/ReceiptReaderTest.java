package com.example.datareader;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Iterator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReceiptReaderTest {

    FileReader fileReader = Mockito.mock(FileReader.class);

    @Test
    void testReadReceipt() throws LineError {
        String basicFile = "[apple:0:$4]\n[apple:0:$2]\n[pear:0:$3]";

        Mockito.when(fileReader.iterator()).thenReturn(new FileIterator(basicFile));

        ReceiptReader receiptReader = new ReceiptReader(4.00, fileReader);
        String result = receiptReader.readReceipt();

        Mockito.verify(fileReader).readFile("receipt.txt");
        assertThat(result).contains("apple: $30");
    }

    private class FileIterator implements Iterator<String> {
        private final String[] mockFile;
        private int index = 0;

        public FileIterator(String mockFileText) {
            this.mockFile = mockFileText.split("\n");
        }

        @Override
        public boolean hasNext() {
            return index < mockFile.length;
        }

        @Override
        public String next() {
            return mockFile[index++];
        }
    }
}