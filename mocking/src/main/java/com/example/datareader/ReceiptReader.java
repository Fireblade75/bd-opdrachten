package com.example.datareader;

import java.util.HashMap;
import java.util.regex.Pattern;

public class ReceiptReader {
    private final Pattern pattern = Pattern.compile("\\[([a-zA-Z]+):\\$(\\d+(?:\\.\\d\\d?)?)\\]");
    private final double taxes;
    private final FileReader fileReader;

    public ReceiptReader(double taxes, FileReader fileReader) {
        this.taxes = taxes;
        this.fileReader = fileReader;
    }

    public String readReceipt() throws LineError {
        fileReader.readFile("receipt.txt");
        var itemMap = new HashMap<String, Double>();
        for (String line : fileReader) {
            var match = pattern.matcher(line);
            if (!match.matches()) {
                throw new LineError(line);
            }
            String itemName = match.group(1);
            double price = applyTaxes(Double.parseDouble(match.group(2)));

            if (itemMap.containsKey(itemName)) {
                itemMap.put(itemName, itemMap.get(itemName) + price);
            } else {
                itemMap.put(itemName, price);
            }
        }

        var sb = new StringBuilder();
        for(var entry : itemMap.entrySet()) {
            sb.append(String.format("%s: $%.2f%n", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }

    private double applyTaxes(double originalPrice) {
        return originalPrice * (1 + taxes);
    }
}
