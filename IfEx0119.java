class IfEx0119 {
    public static void main(String[] args){
        //–â‘è‚P

        int x1 = 1;

        if(x1 > 0){
            System.out.println("x1‚Í³‚Ì”‚Å‚·B");
        } else if (x1 == 0){
            System.out.println("x1‚Íƒ[ƒ‚Å‚·B");
        }else{
            System.out.println("x1‚Í•‰‚Ì”‚Å‚·B");
        }

        //–â‘è‚Q

        int x2 = 19;

        if(x2 % 2 == 0){
            System.out.println("x2‚Í‹ô”‚Å‚·B");
        }else {
            System.out.println("x2‚ÍŠï”‚Å‚·B");
        }

        // –â‘è‚R

        int x3 = 86;

        if(x3 > 90){
            System.out.println("•]‰¿‚ÍS‚Å‚·B");
        }else if (x3 > 80){
            System.out.println("•]‰¿‚ÍA‚Å‚·B");
        }else if (x3 > 70){
            System.out.println("•]‰¿‚ÍB‚Å‚·B");
        }else if (x3 > 60){
            System.out.println("•]‰¿‚ÍC‚Å‚·B");
        }else {
            System.out.println("•]‰¿‚ÍD‚Å‚·B");
        }

        // –â‘è‚S
        int x4 = 1900;

        if (x4 % 400 == 0 || ( x4 % 4 == 0 && x4 % 100 != 0 )){
            System.out.println(x4 + "‚Í‚¤‚é‚¤”N‚Å‚·B");
        }else {
            System.out.println(x4 + "‚Í‚¤‚é‚¤”N‚Å‚Í‚È‚¢B");
        }

        // –â‘è‚T
        int x5 = 16;

        if(x5 < 6){
            System.out.println("–³—¿‚Å‚·B");
        }else if (x5 < 12){
            System.out.println("500‰~‚Å‚·B");
        }else if (x5 < 18){
            System.out.println("800‰~‚Å‚·B");
        }else {
            System.out.println("1200‰~‚Å‚·B");
        }

        // –â‘è‚U
        int a = 314, b = 159, c = 265;
        int max = a;

        if(b > max){
            max = b;
        }
        if(c > max){
            max = c;
        }

        System.out.println("Å‚à‘å‚«‚¢”’l‚Í: " + max);

        // –â‘è‚V
        double height = 1.7,weight = 48.8;
        double BMI;

        BMI = weight / (height * height);

        if(BMI < 18.5){
            System.out.println("’á‘Ìd");
        }else if (BMI < 25){
            System.out.println("•’Ê‘Ìd");
        }else {
            System.out.println("”ì–");
        }

        // –â‘è‚W
        int time = 18,age = 16;

        if(age > 65){
            System.out.println("1100‰~‚Å‚·B");
        }else if (time < 20){
            if(age < 18){
                System.out.println("1000‰~‚Å‚·B");
            }else {
                System.out.println("1800‰~‚Å‚·B");
            }
        }else{
            System.out.println("1300‰~‚Å‚·B");
        }

    }
}