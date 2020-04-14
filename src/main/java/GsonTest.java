import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;
import java.util.HashMap;
import java.util.Map;

public class GsonTest {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().create();
        OuterClass outerClass = gson.fromJson("{\"MessageID\":{'value':'3A72fd4ccb-1980-26cf-8db3-9eaadf1205c2'}}", OuterClass.class);
        AttributedURI attributedURI = gson.fromJson("{'value':'3A72fd4ccb-1980-26cf-8db3-9eaadf1205c2'}", AttributedURI.class);
        System.out.println(outerClass);
        System.out.println(attributedURI);
    }
}

class AttributedURI {
    protected String value;
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the value property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     *
     * <p>
     * the map is keyed by the name of the attribute and
     * the value is the string value of the attribute.
     *
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     *
     *
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

    @Override
    public String toString() {
        return "AttributedURI{" +
                "value='" + value + "'" +
                ", otherAttributes=" + otherAttributes +
                "}";
    }
}

class OuterClass {
    @SerializedName("MessageID")
    private AttributedURI messageID;

    public AttributedURI getMessageID(){
        return messageID;
    }

    @Override
    public String toString() {
        return "OuterClass{" +
                "messageID=" + messageID +
                "}";
    }
}