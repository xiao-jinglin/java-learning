class Item{
    String name;
    int price;
}

class SampleInstanceMember01{
    public static void main(String[] args){
        Item item = new Item();
        item.name = "PC";
        item.price = 12000;

        System.out.println("è§ïiñºÅF" + item.name);
        System.out.println("âøäiÅF" + item.price);
    }
}