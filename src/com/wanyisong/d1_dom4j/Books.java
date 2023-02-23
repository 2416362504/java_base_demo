package com.wanyisong.d1_dom4j;

//<书 id="1" name="书1">
//<书名>javaEE SSM</书名>
//<作者>NEWboy</作者>
//<售价>40</售价>
//</书>
public class Books {
    private String name;
    private int id;
    private boolean vip;
    private String author;
    private double price;

    public Books() {
    }

    public Books(String name, int id, boolean vip, String author, double price) {
        this.name = name;
        this.id = id;
        this.vip = vip;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Books{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", vip=" + vip +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
