package chanjy.util;



public class Salt {
    public static String getSalt(){
        String linkNo = "";
        // 用字符数组的方式随机
        String model = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] m = model.toCharArray();
        for (int j = 0; j < 6; j++) {
            char c = m[(int) (Math.random() * 36)];
            // 保证六位随机数之间没有重复的
            if (linkNo.contains(String.valueOf(c))) {
                j--;
                continue;
            }
            linkNo = linkNo + c;
        }
        return linkNo;
    }

    public static String getOrderId(){
        String link = "";
        // 用字符数组的方式随机
        String model = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] m = model.toCharArray();
        for (int j = 0; j < 10; j++) {
            char c = m[(int) (Math.random() * 36)];
            // 保证六位随机数之间没有重复的
            if (link.contains(String.valueOf(c))) {
                j--;
                continue;
            }
            link = link + c;
        }
        return link;
    }


}
