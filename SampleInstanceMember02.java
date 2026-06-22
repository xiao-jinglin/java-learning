class Item{
    String name;
    int price;

    void showInfo(){
        System.out.println("è§ïiñºÅF" + name);
        System.out.println("âøäiÅF" + price);
    }
}

class SampleInstanceMember02{
    public static void main(String[] args){
        Item item1 = new Item();
        Item item2 = new Item();

        item1.name = "PC";
        item1.price = 12000;
        item2.name = "HD";
        item2.price = 8000;

        item1.showInfo();
        item2.showInfo();
    }
}