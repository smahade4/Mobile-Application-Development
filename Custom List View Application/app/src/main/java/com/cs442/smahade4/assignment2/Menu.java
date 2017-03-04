package com.cs442.smahade4.assignment2;
/**
 * Created by sushmama on 9/22/2016.
 */public  class Menu {

    private int menuid;
    private String menuimage;
    private String menudescription;
    private String menuname;
    private int menuprice;

    public Menu(int menuid,String menuimage,String menudescripton, String menuname, int menuprice) {
        this.menuid = menuid;
        this.menuimage = menuimage;
        this.menudescription = menudescripton;
        this.menuname = menuname;
        this.menuprice=menuprice;
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

