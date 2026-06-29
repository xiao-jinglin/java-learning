//問題1
class Room{
    int number;
    String type;
    int price;

    Room(int number, String type, int price){
        this.number = number;
        this.type = type;
        this.price = price;
    }

    void showInfo() {
        System.out.println("部屋番号: " + number);
        System.out.println("部屋の種別: " + type);
        System.out.println("一泊の料金: " + price + "円");
    }

}

//問題2
class Guest{
    String id;
    String name;
    String contact;

    Guest(String id, String name, String contact){
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    Guest(String name, String contact){
        this("00000000", name, contact);
    }

    void showInfo() {
        System.out.println("会員番号: " + id);
        System.out.println("名前: " + name);
        System.out.println("連絡先: " + contact);
    }

}

//問題3
class ReservataionCounter{
    static int total;
    static int lastld;

    int getId(){
        total++;
        lastld++;
        return lastld;
    }

    void displayTotal(){
        System.out.println("全体の予約数" + total);
    }

}

//問題4
class Booking{
    Guest guest;
    Room room;
    int bookingId;

    Booking(Guest guest, Room room, int bookingId){
        this.guest = guest;
        this.room = room;
        this.bookingId = bookingId;
    }

    void confirmBooking(){
        System.out.println(guest.name + "様が" + room.price + "円の部屋を予約しました(予約番号:" + bookingId + ")");
    }
}


class ClassEx0119 {
    public static void main(String[] args){
        //問題5
        Room room1 = new Room(101, "シングル", 8000);
        Room room2 = new Room(202, "ダブル", 15000);
        Room room3 = new Room(303, "トリプル", 50000);

        ReservataionCounter counter = new ReservataionCounter();

        int id1 = counter.getId();
        Guest guest1 = new Guest(String.valueOf(id1), "佐藤太郎", "satou1@gmail.com");
        Booking booking1 = new Booking(guest1, room1, id1);
        booking1.confirmBooking();

        int id2 = counter.getId();
        Guest guest2 = new Guest(String.valueOf(id2), "佐藤二郎", "satou2@gmail.com");
        Booking booking2 = new Booking(guest2, room2, id2);
        booking2.confirmBooking();

        int id3 = counter.getId();
        Guest guest3 = new Guest(String.valueOf(id3), "佐藤三郎", "satou3@gmail.com");
        Booking booking3 = new Booking(guest3, room3, id3);
        booking3.confirmBooking();

        counter.displayTotal();

        int id4 = counter.getId();
        Guest guest4 = new Guest(String.valueOf(id4), "佐藤四郎", "satou3@gmail.com");
        SuiteRoom vipRoom= new SuiteRoom(404, "スイート", 80000);
        SuiteBooking suiteroom = new SuiteBooking(guest4, vipRoom, id4);
        System.out.println("--- スイートルーム予約確認 ---");
        suiteroom.confirmBooking();


    }
}

//問題6
class SuiteRoom{
    int number;
    String type;
    int price;
    int servicePrice = 10000;

    SuiteRoom(int number, String type, int price){
        this.number = number;
        this.type = type;
        this.price = price;
    }

    void showInfo(){
        System.out.println("部屋番号: " + number);
        System.out.println("部屋の種別: " + type);
        System.out.println("総料金（一泊＋サービス料）: " + (price + servicePrice) + "円");
    }

    public void showFacilities() {
        System.out.println("部屋の装備: 専用ジャグジー、ミニバーあり");
    }
}

//問題7
class SuiteBooking{

    Guest guest;
    SuiteRoom suiteRoom;
    int bookingId;


    public SuiteBooking(Guest guest, SuiteRoom suiteRoom, int bookingId) {
        this.guest = guest;
        this.suiteRoom = suiteRoom;
        this.bookingId = bookingId;
    }


    public void confirmBooking() {
        System.out.println(guest.name + "様が" + (suiteRoom.price + suiteRoom.servicePrice) + "円のスイートルームを予約しました" + "(予約番号:" + bookingId + ")");
    }
}