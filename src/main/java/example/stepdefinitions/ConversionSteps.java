package example.stepdefinitions;

import cucumber.api.DataTable;
import cucumber.api.java8.En;
import example.MyClass;
import model.OrderAttribute;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConversionSteps implements En {

    Logger logger = LoggerFactory.getLogger(ConversionSteps.class);

    public ConversionSteps() {
        Given("^I add a sku$", (DataTable dt) -> {

            List<MyClass> ProductAttributes = dt.asList(MyClass.class);

            Map<String, List<MyClass>> mapOfBranches = ProductAttributes.stream()
                    .collect(Collectors.groupingBy(branch -> branch.getBranch()));

            mapOfBranches.forEach((branch, branchAttributes) -> {

                importThis(branch);
            });
        });

        Given("^I send the following$", (DataTable dataTable) -> {

            List<OrderAttribute> orderAttributes = dataTable.asList(OrderAttribute.class);

            Map<String,List<String>> tryMap= new HashMap<>();
            orderAttributes.forEach(oa->{
                if(oa.getCategory().equalsIgnoreCase("toilet")){
                    List<String> ls= new ArrayList<>();
                    ls.add(oa.getBarcode());
                    ls.add(oa.getProduct());
                    tryMap.put(oa.getCategory(),ls);
                }
            });

            Map<String, List<OrderAttribute>> map=orderAttributes.stream().collect(Collectors.groupingBy(OrderAttribute::getCategory));

            List<Map<String,String>> listMap= new ArrayList<>();

            orderAttributes.forEach(row -> {
                Map<String, String> filterMap = new HashMap<>();
                filterMap.put(row.getCategory(), row.getProduct());
                listMap.add(filterMap);
            });

            System.out.println(listMap);
        });
    }


    public void importThis(String branch) {

        logger.info("This is branch {}", branch);
        System.out.println("this is the branch " + branch);
        //Disable all branches for this
    }


}