import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private List<String> phones;

    public Employee(String name, List<String> phones) {
        this.name = name;
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

}

public class PhoneNums {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Hritik", Arrays.asList("1234567890", "1122334455")));
        employees.add(new Employee("Ranvijay", Arrays.asList("2456801357", "2233445566")));
        employees.add(new Employee("John", Arrays.asList("4389079300", "5840244859")));
        employees.add(new Employee("Mathew", Arrays.asList("9977554433")));

        System.out.println("A 2-D List of Employee phone numbers:");
        System.out.println(
                // open a stream
                // List<Employee> -> Stream<Employee>
                employees.stream()
            
                // map each Employee instance to list of their stored phone numbers
                // Employee -> List<String>
                .map(emp -> emp.getPhones())
                // each List<String> collected in a Stream to give Stream<List<String>>
            
                // collects each list in the stream to another List
                // which results in List<List<String>>
                .collect(Collectors.toList())
                );

        System.out.println("The flattened List of Employee phone numbers:");

        // the lambda expressions can also be replaced to equivalent method references
        System.out.println(
                // open a stream
                // List<Employee> -> Stream<Employee>
                employees.stream()
            
                // method reference is equivalent to emp -> emp.getPhones() lambda expression
                // Employee -> List<String>
                // List<String> -> Stream<List<String>>
                .map(Employee::getPhones)
            
                // maps each list of phone numbers to open another stream and map each phone in that stream according to some logic
                // input Stream to flatMap = Stream<List<String>>
                .flatMap(
                        // List<String> -> Stream<String>
                        phones -> phones.stream()

                        // phone String -> another phone String -> Stream<String>
                        .map(phone -> "+91-" + phone)
                        )
                // flattens out Stream<Stream<String> to Stream<String>

                // collects each phone String in flattened stream into a List
                .collect(Collectors.toList())
                );
    }
}
