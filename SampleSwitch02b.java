class SampleSwitch01b {
    public static void main(String[] args){
        int x = 5;

        switch(x) {
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
            case 3:
                System.out.println("Three");
            default:
                System.out.println("Others");
        }
    }
}