package com.wanyisong.d2_xpath;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class XPathDemo {
    /**
     * 1.绝对路径： ./子元素/子元素  （.代表了当前元素）
     */
    @Test
    public void parse1() throws Exception{
        //a.创建解析器对象
        SAXReader saxReader=new SAXReader();
        //b.把xml加载成Document文档对象
        Document document=saxReader.read(XPathDemo.class.getResourceAsStream("/Books.xml"));
        //c.检索全部的名称
        List<Node> nameNodes = document.selectNodes("/书架/书/书名");
        for (Node nameNode : nameNodes) {
            Element nameEle=(Element) nameNode;
            System.out.println(nameEle.getTextTrim());
        }
    }

    /**
     * 2.相对路径：  ./子元素/子元素  （代表了当前元素）
     */
    @Test
    public void parse2() throws Exception{
        //a.创建解析器对象
        SAXReader saxReader=new SAXReader();
        //b.把xml加载成Document文档对象
        Document document=saxReader.read(XPathDemo.class.getResourceAsStream("/Books.xml"));
        Element root= document.getRootElement();
        //c.检索全部的名称
        List<Node> nameNodes = root.selectNodes("./书/书名");
        for (Node nameNode : nameNodes) {
            Element nameEle=(Element) nameNode;
            System.out.println(nameEle.getTextTrim());
        }
    }

    /**
     * 3.全文检索
     *  //元素 在全文找这个元素
     *  //元素1/元素2 在全文找元素1下面的一级元素2
     *  //元素1//元素2 在全文找元素1下面的全部元素2
     * @throws Exception
     */
    @Test
    public void parse3() throws Exception{
        //a.创建解析器对象
        SAXReader saxReader=new SAXReader();
        //b.把xml加载成Document文档对象
        Document document=saxReader.read(XPathDemo.class.getResourceAsStream("/Books.xml"));
        //c.检索数据
//        List<Node> nodes = document.selectNodes("//书名");
//        List<Node> nodes = document.selectNodes("//书/书名");
        List<Node> nodes = document.selectNodes("//书//书名");
        for (Node nameNode : nodes) {
            Element nameEle=(Element) nameNode;
            System.out.println(nameEle.getTextTrim());
        }

    }

    /**
     * 4.属性查找
     * //@属性名称 在全文中检索属性对象
     * //元素[@属性名称] 在全文检索包含该属性的元素对象
     * //元素[@属性名称=值] 在全文检索包含该属性的元素且属性值为该值的元素对象
     * @throws Exception
     */
    @Test
    public void parse4() throws Exception{
        //a.创建解析器对象
        SAXReader saxReader=new SAXReader();
        //b.把xml加载成Document文档对象
        Document document=saxReader.read(XPathDemo.class.getResourceAsStream("/Books.xml"));
        //c.检索属性
        List<Node> nodes=document.selectNodes("//@id");
        for (Node node : nodes) {
            Attribute attr=(Attribute) node;
            System.out.println(attr.getName()+"===>"+attr.getValue());
        }

        //查询书名元素(包含id属性的）
//        Node nodes1=document.selectSingleNode("//书名[@id]");
        Node nodes1=document.selectSingleNode("//书名[@id=88]");
        Element element=(Element) nodes1;
        System.out.println(element.getTextTrim());
    }


}
