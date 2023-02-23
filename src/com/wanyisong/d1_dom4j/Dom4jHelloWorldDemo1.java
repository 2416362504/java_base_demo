package com.wanyisong.d1_dom4j;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * 目标：学会使用dom4j解析xml文件中的数据
 *    1.导入dom4j框架
 *    2.准备一个xml文件
 */
public class Dom4jHelloWorldDemo1 {
    @Test
    public void parseXMLData() throws Exception {
        //1.创建一个dom4j的解析器对象 代表了整个dom4j框架
        SAXReader saxReader=new SAXReader();
        //2.把xml文件加载到内存中成为一个document文档对象
//        Document document=saxReader.read(new File("F:\\IDEAworkspace\\xml-app\\src\\Books.xml"));  //需要通过模块名去定位
        //注意：getResourceAsStream中的/是直接去src下寻找的文件
        InputStream is=Dom4jHelloWorldDemo1.class.getResourceAsStream("/Books.xml");
        Document document= saxReader.read(is);

        //3.获取根元素对象
        Element root=document.getRootElement();
        System.out.println(root.getName());


        //4.拿根元素下的全部子元素对象(一级）
//        List<Element> sonEles=root.elements();
        List<Element> sonEles=root.elements("书");
        for (Element sonEle : sonEles) {
            System.out.println(sonEle.getName());
        }

        //拿某个子元素  默认提取第一个子元素对象
        Element userEle=root.element("书");
        System.out.println(userEle.getName());
        //获取子元素文本
        System.out.println(userEle.elementText("书名"));
        //去掉前后空格
        System.out.println(userEle.elementTextTrim("书名"));
        //根据元素获取属性值
        Attribute id = userEle.attribute("id");
        System.out.println(id.getName()+"===>"+id.getValue());

        //直接提取属性值
        System.out.println(userEle.attributeValue("id"));
        System.out.println(userEle.attributeValue("name"));

        //获取当前元素下的子元素对象
        Element bookName = userEle.element("书名");
        System.out.println(bookName.getText());

    }

}
