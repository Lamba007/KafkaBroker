package model;

import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderAttribute {

    String barcode;
    String category;
    String product;
    String quantity;

    public String getBarcode() {
        return barcode;
    }

    public String getCategory() {
        return category;
    }

    public String getProduct() {
        return product;
    }

    public String getQuantity() {
        return quantity;
    }

    @Test
    public void createPrintStream() {

        Stream<OrderAttribute> intStream = Stream.of(new OrderAttribute(),new OrderAttribute());

//        intStream.forEach(is-> Collectors.groupingBy(is.category));
    }
}
