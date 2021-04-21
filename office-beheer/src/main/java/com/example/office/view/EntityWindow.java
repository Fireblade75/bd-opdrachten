package com.example.office.view;

import com.example.office.view.util.BaseWindow;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EntityWindow extends BaseWindow {

    public EntityWindow(String title) throws IOException {
        super();
        displayLine(title);
    }

    public <T> T selectElementFromList(List<T> elements, String elementName) {
        return elements.get(selectIndexFromList(elements, elementName));
    }

    public <T> T selectElementFromList(List<T> elements, String elementName, Function<T, String> stringFunction) {
        return elements.get(selectIndexFromList(elements, elementName, stringFunction));
    }

    public <T> int selectIndexFromList(List<T> elements, String elementName) {
        return selectIndexFromList(elements, elementName, Object::toString);
    }

    public <T> int selectIndexFromList(List<T> elements, String elementName, Function<T, String> stringFunction) {
        displayLine("The following " + elementName + "s are available");
        for (int i = 0; i < elements.size(); i++) {
            displayFormatted("%02d. %s%n", i+1, stringFunction.apply(elements.get(i)));
        }
        while (true) {
            int authorId = readInt();
            if(authorId > 0 && authorId <= elements.size()) {
                return authorId - 1;
            }
        }
    }

    public <T> T selectElementFromSet(Set<T> elements, String elementName, Function<T, String> stringFunction) {
        return selectElementFromList(new ArrayList<>(elements), elementName, stringFunction);
    }

    public <T> T selectElementFromSet(Set<T> elements, String elementName) {
        return selectElementFromList(new ArrayList<>(elements), elementName);
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

    public String askForString(String label) {
        displayLine(label);
        return readString();
    }

    public LocalDate askForDate(String label) {
        displayLine(label);
        return readLocalDate();
    }

    public <T extends Enum<T>> T askForEnumValue(T[] options, String label) {
        List<String> textOptions = Arrays.stream(options)
                .map(Enum::name)
                .collect(Collectors.toList());
        int i = selectIndexFromList(textOptions, label);
        return options[i];
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
