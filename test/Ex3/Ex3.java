class Ex3{

	public String ex3_0(int n){
    String ret = "";
    if (n > 0) {
      ret = "その値は正です";
    } else {
      ret = "その値は０か負です";
    }
		return ret;
	}

	public int ex3_1(int n){
    int ret = 0;
    if (n >= 0) {
        ret =  n;
    } else {
        ret =  n*-1 ;
    }
    return ret;
    }

	public String ex3_2(int a, int b){
    String ret = "";
    if (a % b == 0) {
        ret = String.format("%dは%dの約数です", b, a);
    }else{
        ret = String.format("%dは%dの約数ではありません", b, a);
    }
    return ret;
	}

	public String ex3_3(int a, int b){
    String ret = "";
    if (a == b) {
        ret = "同じ値です";
    }else if (b > a){
        ret = String.format("%dの方が大きいです", b);
    }else{
        ret = String.format("%dの方が大きいです", a);
    }
    return ret;

	}

	public String ex3_4(int a){
    String ret = "";
    if (a < 0) {
        ret = "正でない整数値です";
    }else if (a % 5 != 0){
        ret = "その値は5で割り切れません";
    }else{
        ret = "その値は5で割り切れます";
    }
    return ret;

	}

	public String ex3_5(int a){
    String ret = "";
    if (a < 0) {
        ret = "正でない整数値です";
    }else if (a % 10 != 0) {
        ret = "その値は10の倍数ではありません";
    }else{
        ret = "その値は10の倍数です";
    }
    return ret;
	}
	
	public String ex3_6(int a){
    String ret = "";
    if (a < 0) {
        ret = "正でない整数値です";
    }else if (a % 3 != 0){
        ret = String.format("その値を3で割った余りは%dです", a % 3);
    }else {
        ret = "その値は3で割り切れます";
    }
    return ret;
	}

	public String ex3_7(int a){
    String ret = "";
    if (a <= 100 && a >= 80) {
        ret = "優";
    }else if (a <= 80 && a >= 70) {
        ret = "良";
    }else if (a <= 70 && a >= 60){
        ret = "可";
    }else if (0 <= a && a < 60){
        ret = "不可";
    }else{
        ret = "範囲(0～100)外の値です";
    }
    return ret;
	}

	public double ex3_8(double a, double b){
    double ret = 0.0;
    if (a > b) {
        ret = a;
    }else{
        ret = b;
    }
    return ret;
	}

	public int ex3_9(int a, int b){
    int ret = a - b;
    return ret;
    }

    public String ex3_10(int a, int b){
    String ret = "";
    if (a - b <= 10) {
        ret = ("それらの差は10以下です");
    }else{
        ret = ("それらの差は11以上です");
    }
    return ret;
	}

	public int ex3_11(int a, int b, int c){
    int ret = 0;
    if (b > a && c >= a) {
        ret = a;
    }else if (c > b && a >= b) {
        ret = b;
    }else{
        ret = c;
    }
    return ret;


    }
	public int ex3_12(int a, int b, int c){
    if (a >= b) {
        if (b >= c) {
            return b; // A, B, F, G
        } else if (a <= c) {
            return a; // D, E, H
        } else {
            return c; // C
        }
    }else if (a > c) {
        return a; // I
    }else if (b > c) {
        return c; // J, K
    }else {
        return b; // L, M
      }
    }


	public String ex3_13(int a){
    String ret = "";
    if (a <= 0 || a > 12) {
        ret = "範囲(1～12)外の値です";
    }else if (a > 2 && a < 6) {
        ret = "春";
    }else if (a > 5 && a < 9) {
        ret = "夏";
    }else if (a > 8 && a < 12) {
        ret = "秋";
    }else{
        ret = "冬";
    }
    return ret;
	}
}

