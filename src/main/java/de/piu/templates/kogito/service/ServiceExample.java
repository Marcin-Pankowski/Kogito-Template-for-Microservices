package de.piu.templates.kogito.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Singleton;
import de.piu.templates.kogito.dto.BankCustomer;
import de.piu.templates.kogito.dto.ComplexServiceExampleInput;
import de.piu.templates.kogito.dto.ComplexServiceExampleOutput;

@Singleton
public class ServiceExample {

    public ComplexServiceExampleOutput doSomething(ComplexServiceExampleInput input) {

        ComplexServiceExampleOutput output = new ComplexServiceExampleOutput();

        List<BankCustomer> bankCustomers = new ArrayList<>();

        input.getPersons().forEach(person -> {
            Random rand = new Random(); // instance of random class
            int upperbound = 25;
            bankCustomers.add(BankCustomer.builder()
                    .name(person.getName())
                    .age(person.getAge())
                    .counselor("Marcin Pankowski")
                    .credit(rand.nextInt(upperbound))
                    .build());
            output.setBankCustomers(bankCustomers);
        });

        return output;

    }

}
