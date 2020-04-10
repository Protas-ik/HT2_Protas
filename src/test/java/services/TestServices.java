package services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import text.Text;

public class TestServices {
    private static Text text;
    private static Services services;

    @Before
    public void setUp() throws Exception {
        text = new Text("Hey, guys! How are you? Blood type on a sleeve.\n");
        services = new Services();
    }

    @Test
    public void isTextParseCorrectly(){
        Assert.assertEquals("Hey, guys! How are you? Blood type on a sleeve.\n",text.toString());
    }

    @Test
    public void isFirstAndLastWordInSentenceChangeCorrectly(){
        services.changeFirstAndLastWordInSentence(text);
        Assert.assertEquals("guys, Hey! you are How? sleeve type on a Blood.\n",text.toString());
    }
}
