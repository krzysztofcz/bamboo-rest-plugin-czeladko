package it.com.czeladko.atlassian.rest;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import com.czeladko.atlassian.rest.GetEntityId;
import com.czeladko.atlassian.rest.GetEntityIdModel;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;

public class GetEntityIdFuncTest {

    @Before
    public void setup() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void messageIsValid() {

        String baseUrl = System.getProperty("baseurl");
        String resourceUrl = baseUrl + "/rest/getentityid/1.0/entityid";

        RestClient client = new RestClient();
        Resource resource = client.resource(resourceUrl);

        GetEntityIdModel message = resource.get(GetEntityIdModel.class);

        assertEquals("wrong message","Hello World",message.getMessage());
    }
}
