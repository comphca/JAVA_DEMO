package demo01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class ParseDemo01 {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		//1.获取解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//2.从解析工厂获取解析器
		SAXParser parse = factory.newSAXParser();
		//3.加载文档Document  注册处理器
		//4.编写处理器
		PersonHandler handler = new PersonHandler();
		parse.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("demo01/Person.xml")
				, handler);
		List<Person> persons = handler.getPersons();
		for(Person p : persons){
			System.out.println(p.getName() + "--->" + p.getName());
		}
	}
}
