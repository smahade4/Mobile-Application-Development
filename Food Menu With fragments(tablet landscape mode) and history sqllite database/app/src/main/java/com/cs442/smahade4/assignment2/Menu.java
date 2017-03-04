package com.cs442.smahade4.assignment2;
/**
 * Created by sushmama on 9/22/2016.
 */public  class Menu {

    private int menuid;
    private String menuimage;
    private String menudescription;
    private String menuname;
    private int menuprice;
    private int quantity;
    public Menu(int menuid,String menuimage,String menudescription, String menuname, int menuprice,int quantity) {
        this.menuid = menuid;
        this.menuimage = menuimage;
        this.menudescription = menudescription;
        this.menuname = menuname;
        this.menuprice=menuprice;
        this.quantity=quantity;
    }

    public int getmenuid() {
        return menuid;
    }

    public void setmenuid(int menuid) {
        this.menuid = menuid;
    }

    public String getmenudescription() {
        return menudescription;
    }

    public void setmenudescription(String menudescription) {
        this.menudescription = menudescription;
    }

    public String getmenuimage() {
        return menuimage;
    }

    public void setmenuimage(String menuimage) {
        this.menuimage = menuimage;
    }


    public int getmenuquantity() {
        return quantity;
    }

    public void setmenuquantity(int quantity) {
        this.quantity = quantity;
    }

    public String getmenuname() {
        return menuname;
    }

    public void setmenuname(String menuname) {
        this.menuname = menuname;
    }

    public int getmenuprice() {
        return menuprice;
    }

    public void setmenuprice(int menuprice) {
        this.menuprice = menuprice;
    }

    @Override
    public String toString() {
        return this.menuid + ". " + this.menuname + " [$" + this.menuprice + "]";
    }

}

