package com.example.datareader;

import java.util.Iterator;

public class MockFileReader extends FileReader {
    private String[] mockFile;

    public MockFileReader(String mockFile) {
        this.mockFile = mockFile.split("\n");
    }

    @Override
    public void readFile(String fileName) {
        // Do nothing
    }


    @Override
    public Iterator<String> iterator() {
        return new MockFileReaderIterator();
    }

    private class MockFileReaderIterator implements Iterator<String> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < mockFile.length;
        }

        @Override
        public String next() {
            return mockFile[index];
        }
    }
}
