package parsingXml;

import java.io.BufferedReader; //для буферезирования считывания, оптимизация, считывает инфу блоками
import java.io.FileReader; //считывает посимвольно
import java.io.IOException;

//загрузка содержимого из xml файла в строку (или null при ошибке)
public class XmlFileLoader {

    public static String loadXmlFile(String filePath) throws Exception{

        //в отличие от Стринга StringBuilder позволяет изменять строку "На месте", не создавая новые объекты
        StringBuilder xmlContent = new StringBuilder();

        //обязательно указываем на ошибку в методе, без нее код не батрачит из-за fileReader
        //BufferedReader(new FileReader(filePath)) оборачивает FileReader в BufferedReader для повышения эффективности чтения
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line; //хранит прочитанные строки
            while ((line = br.readLine()) != null) { //пока readline возвращает непустые строки
                xmlContent.append(line.trim()); //.trim убирает нач и кон пробелы из строки
            }
            return xmlContent.toString();
        } catch (IOException e){
            System.err.println("Error reading XML file: " + e.getMessage());
            return null;
        }
    }
}
