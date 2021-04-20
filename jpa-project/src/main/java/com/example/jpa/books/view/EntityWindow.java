package com.example.jpa.books.view;

import org.slf4j.Logger;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;

public class EntityWindow extends BaseWindow implements AutoCloseable {

//    @InjectLogger
    private Logger logger;

    public EntityWindow(String title) throws IOException {
        super();
        displayLine(title);
    }

    public <T> T selectElementFromList(List<T> elements, String elementName) {
        return elements.get(selectIdFromList(elements, elementName));
    }

    public <T> int selectIdFromList(List<T> elements, String elementName) {
        displayLine("The following " + elementName + "s are available");
        for (int i = 0; i < elements.size(); i++) {
            displayFormatted("%02d. %s%n", i+1, elements.get(i).toString());
        }
        while (true) {
            int authorId = readInt();
            if(authorId > 0 && authorId <= elements.size()) {
                return authorId - 1;
            }
        }
    }

    public boolean askYesNoQuestion(String question) {
        displayLine(question);
        return readBool();
    }

    public BigDecimal askForBigDecimal(String label) {
        return askForBigDecimal(label, null, null);
    }

    public BigDecimal askForBigDecimal(String label, Predicate<BigDecimal> requirement, String errorMessage) {
        displayLine(label);
        while (true) {
            BigDecimal value = readBigDecimal();
            if(requirement == null || requirement.test(value)) {
                return value;
            } else {
                displayLine(errorMessage);
            }
        }
    }

    public <T> void displayEntity(T entity, String label) {
        displayLine(label + "\n" + entity.toString());
    }

    public <T>  void displayEntities(List<T> entities, String label) {
        StringBuilder sb = new StringBuilder(label).append("\n");
        entities.forEach(sale ->
                sb.append(sale.toString()).append("\n")
        );
        displayLine(sb.toString());
    }
}
