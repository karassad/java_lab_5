import model.Organization;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlReader {

    //принимает на вход содержимое файла и возвращает набор объектов set
    public static Set<Organization> parseXml(String xmlContent){
        Set<Organization> organizations = new LinkedHashSet<>(); //создали пустую коллекцию

        Pattern orgPattern = Pattern.compile("<organization>(.*?)<organization>");
        Matcher orgMatcher = orgPattern.matcher(xmlContent);
        return null;
    }
}