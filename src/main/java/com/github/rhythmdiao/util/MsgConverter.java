package com.github.rhythmdiao.util;

import com.github.rhythmdiao.domain.msg.BaseMsg;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rhyth
 */
public enum MsgConverter {
    ;
    public static final String TEXT_MSG = "text";
    public static final String EVENT_MSG = "event";

    @SuppressWarnings("unchecked")
    public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException {
        Map<String, String> map = new HashMap<>();
        SAXReader reader = new SAXReader();

        InputStream ins = null;
        try {
            ins = request.getInputStream();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Document doc;
        try {
            doc = reader.read(ins);
            Element root = doc.getRootElement();

            List<Element> list = root.elements();

            for (Element e : list) {
                map.put(e.getName(), e.getText());
            }

            return map;
        } catch (DocumentException e1) {
            e1.printStackTrace();
        } finally {
            if (ins != null) {
                ins.close();
            }
        }
        return null;
    }

    /**
     * 文本消息对象转换成xml
     *
     * @param msg 文本消息对象
     * @return xml
     */
    public static String textMessageToXml(BaseMsg msg) {
        XStream xstream = new XStream();
        xstream.alias("xml", msg.getClass());
        return xstream.toXML(msg);
    }
}
