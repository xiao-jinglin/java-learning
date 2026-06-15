class SampleField01{
    final static double TAX = 0.08;

    static int calcTaxedPrice(int price){
        int taxedPrice = (int)(price + price * TAX);
        return taxedPrice;
    }

    public static void main(String[] args){
        int price = 1200;

        int taxedPrice = calcTaxedPrice(price);

        System.out.println("ê≈çûâøäiÇÕ" + taxedPrice + "â~Ç≈Ç∑ÅB(ê≈ó¶" + TAX + ")");
    }
}