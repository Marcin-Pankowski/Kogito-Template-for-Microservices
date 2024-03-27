package de.piu.templates.kogito.test.process;

import de.piu.templates.kogito.dto.ComplexServiceExampleInput;
import de.piu.templates.kogito.dto.ComplexServiceExampleOutput;
import de.piu.templates.kogito.dto.Person;
import de.piu.templates.kogito.test.listener.TestNodeTriggeredListener;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.kie.kogito.process.Processes;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ComplexServiceExampleProcessTest {

    @Inject
    Processes processes;

    @Inject
    Instance<TestNodeTriggeredListener> testNodeTriggeredListenerInstance;

    @BeforeEach
    void resetListener() {
        testNodeTriggeredListenerInstance.get().setProcessNameToObserve("ComplexServiceExample");
        testNodeTriggeredListenerInstance.get().resetObserver();
    }

    @Test
    public void checkIfProcessEndIsReachedAndOutputIsValid() {

        ComplexServiceExampleInput input = new ComplexServiceExampleInput();
        input.setPersons(List.of(Person.builder().name("John").age(25).build(),
                Person.builder().name("Jane").age(30).build()));

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("input", input);

        var process = processes.processById("ComplexServiceExample");
        var model = process.createModel();
        model.fromMap(parameters);
        var processInstance = process.createInstance(model);
        processInstance.start();


        assertThat(processInstance.status()).isEqualTo(org.kie.api.runtime.process.ProcessInstance.STATE_COMPLETED);

        var triggeredNodesNames = testNodeTriggeredListenerInstance.get().getTriggeredNodesNames();
        // Is the end node reached?
        assertThat(triggeredNodesNames.stream().reduce((first, second) -> second).get()).isEqualTo("End");

        var output = (ComplexServiceExampleOutput) processInstance.variables().toMap().get("output");
        assertThat(output.getBankCustomers().size()).isEqualTo(2);
    }



}
