package kr.co.woobi.imyeon.baseadapterex;

public class CoffeeModel {
    private int imageRes;
    private String menu;
    private String price;

    public CoffeeModel(int imageRes, String menu, String price) {
        this.imageRes = imageRes;
        this.menu = menu;
        this.price = price;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CoffeeModel{" +
                "imageRes=" + imageRes +
                ", menu='" + menu + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
