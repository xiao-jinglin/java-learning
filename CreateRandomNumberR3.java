class CreateRandomNumberR3 {
    static final int EXIT_FAILURE = 1;
    static java.io.Console con;

    public static void main(String[] args) {
        java.util.Random r = new java.util.Random();
        
        if ((con = System.console()) == null) {
            System.err.println("ERROR:コンソールの取得が出来ませんでした。OSの再起動が必要です");
            System.exit(EXIT_FAILURE);
        }
        String line;
        while ((line = con.readLine("発生させる乱数の個数(0～) > ")) != null) {
            try {
                int n = Integer.parseInt(line);
                if (n >= 1) {
                    System.out.print("0 ～ " + (n - 1) + " 内の乱数 : ");
                    int result = r.nextInt(n);
                    System.out.println(result);
                } else {
                    System.err.println("ERROR:正数を入力してください");
                }
            } catch(NumberFormatException ex) {
                if (!line.equals("")) {
                    System.err.println("ERROR:数値以外を入力しないでください");
                }
            }
            System.out.println();
        }
        System.out.println("プログラムを終了します");
    }
}
