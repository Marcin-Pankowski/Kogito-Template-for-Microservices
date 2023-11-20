package de.piu.templates.kogito.starter.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.jupiter.api.Test;
import org.kie.kogito.process.ProcessInstance;
import org.kie.kogito.process.WorkItem;
import org.kie.kogito.Model;
import org.kie.kogito.auth.IdentityProviders;
import org.kie.kogito.auth.SecurityPolicy;
import org.kie.kogito.process.Process;


import io.quarkus.test.junit.QuarkusTest;


@QuarkusTest
public class ProcessExampleTest {

    @Named("processExample")
    @Inject
    Process<? extends Model> processExample;

    @Test
    public void testProcessExample() {

        assertNotNull(processExample);

        Model m = processExample.createModel();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("variableA", "variableA" );
        parameters.put("variableB", "variableB" );
        m.fromMap(parameters);

        ProcessInstance<?> processInstance = processExample.createInstance(m);
        processInstance.start();
        assertEquals(org.kie.api.runtime.process.ProcessInstance.STATE_ACTIVE, processInstance.status());
        assertEquals(processInstance.businessKey(),"variableA");
        
        SecurityPolicy policy = SecurityPolicy.of(IdentityProviders.of("admin", Collections.singletonList("managers")));

        processInstance.workItems(policy);

        List<WorkItem> workItems = processInstance.workItems(policy);
        assertEquals(1, workItems.size());

        assertEquals(workItems.get(0).getName(),"Task2");
        assertEquals(workItems.get(0).getPhase(),"Task2");


    }

   
}

