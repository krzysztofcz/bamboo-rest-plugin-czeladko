package ut.com.czeladko.atlassian;

import org.junit.Test;
import com.czeladko.atlassian.api.MyPluginComponent;
import com.czeladko.atlassian.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}