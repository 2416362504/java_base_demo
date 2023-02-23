package com.wanyisong.d1_dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Dmo4jTest2 {
    public static void main(String[] args) {
        //需求：解析xml中的数据成为一个list集合对象

    }

    @Test
    public void parseToList() throws Exception {
        //需求：解析xml中的数据成为一个List集合对象
        //1.导入框架
        //2.创建SaxReader对象
        SAXReader saxReader=new SAXReader();
        //3.加载xml文件成为文档对象Document对象
        Document document=saxReader.read(Dmo4jTest2.class.getResourceAsStream("/Books.xml"));
        //4.先拿根元素
        Element root= document.getRootElement();
        //5.提取Books子元素
        List<Element> bookEles=root.elements("书");
        //6.准备一个arrayList集合封装联系人信息
        List<Books> books=new ArrayList<>();
        //7.遍历bookEles子元素
        for (Element bookEle : bookEles) {
            //8.每个子元素都是一个联系人对象
            Books book=new Books();
            book.setId(Integer.valueOf(bookEle.attributeValue("id")));
            book.setVip(Boolean.valueOf(bookEle.attributeValue("vip")));
            book.setName(bookEle.elementTextTrim("书名"));
            book.setAuthor(bookEle.elementTextTrim("作者"));
            book.setPrice(Double.valueOf(bookEle.elementTextTrim("售价")));
            //9.把书对象数据加入到List集合中
            books.add(book);
        }

        //10.遍历list集合对象
        for (Books b : books) {
            System.out.println(b);
        }
    }
}
