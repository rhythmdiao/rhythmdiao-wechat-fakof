package com.github.rhythmdiao.service;

import com.github.rhythmdiao.domain.wechat.msg.BaseMsg;
import com.google.common.base.Charsets;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.util.Pair;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rhyth
 */
public enum MsgConverter {
    ;

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
        try {
            if (msg != null) {
                xstream.alias("xml", msg.getClass());
                return xstream.toXML(msg);
            }
        } catch (Exception ignored) {
        }
        return "";
    }

    @SuppressWarnings("unchecked")
    public static <T> T xmlToObject(HttpServletRequest request, Class<T> cls) {
        XStream xstream = new XStream(new DomDriver());
        xstream.processAnnotations(cls);
        StringBuilder source = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    request.getInputStream(), Charsets.UTF_8.name()));
            String line;
            while ((line = reader.readLine()) != null) {
                source.append(line);
            }
            reader.close();
        } catch (IOException ignored) {
        }
        return (T) xstream.fromXML(source.toString());
    }
}
