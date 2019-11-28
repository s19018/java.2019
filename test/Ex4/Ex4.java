import java.util.ArrayList;
import java.util.Arrays;

class Ex4{

	public int [] ex4_1(int [] a){
    //    Arrays.sort(a);
    //    ArrayList<Integer> ret  = new ArrayList<Integer>();
    //    for (int i = 0; i < a.length; i++) {
    //		ret = ret.add(a[a.length - i]);
    //    }
    //    return ret;
	//}
        return a;
    }

	public int [] ex4_2(int [] a){
		return a;

	}

	public String [] ex4_3(int [] a){
		String [] ret = {""};
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                ret[i] = "零";
            }else if (a[i] > 0) {
                ret[i] = "正";
            }else {
                ret[i] = "負";
            }
	    }
        return ret;

	}

	public int ex4_4(int a){
        String str = Integer.toString(a);
        String [] ret = str.split("");
        return ret.length;
	}

	public int ex4_5(int a){
        return a;


	}

	public int [] ex4_6(int a){
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i <= a; i--) {
            if (a % i == 0) {
                ret.add(i);
            }
        }
    return ret;

	}

	public boolean ex4_7(int a){
		
		return false;

	}

	public int ex4_8(int [] a){
		
		int ret = 0;
		
		return ret;

	}

	public int ex4_9(int [] a){
		
		int ret = 0;
		
		return ret;

	}
}

