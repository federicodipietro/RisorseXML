package risorsexml.namespace;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;

public class Main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        XmlResourceParser parser = getResources().getXml(R.xml.compilation);
        try 
        {
        int eventType = parser.getEventType();
        while (eventType != XmlResourceParser.END_DOCUMENT) 
        	{
        	if (eventType == XmlResourceParser.START_TAG) 
        		{
        		String tagName = parser.getName();
        			if ("brano".equals(tagName)) 
        			{
        				String id = parser.getAttributeValue(0);
        				Log.d("XML PARSER",id);

        			}
        		} 
        	else if (eventType == XmlResourceParser.TEXT) 
        		{
        			String elementValue = parser.getText();
        			Log.d("XML PARSER",elementValue);

        		}
        		eventType = parser.next();
        	}
        } 
        catch (XmlPullParserException e) {
        	e.printStackTrace();
        	} 
        catch (IOException e) {
        	e.printStackTrace();
        	}

    }
}