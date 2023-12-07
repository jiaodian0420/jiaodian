package git;
/*设计一个简单的密码管理系统，根据特定的规则对用户输入的密码(每个字符为数字或者大小写字母，长度不超过16)进行加密和解密操作，或者判断强度、生成密码，具体功能如下：
1.加密功能：用户输入一个字符串，系统根据规则对字符串进行加密：
  	（1）将每个字符的ASCII码加上它在字符串中的位置(1开始)和偏移值3
  	（2）将字符串的第一位和最后一位调换顺序
  	（3）将字符串反转
2.解密功能：用户输入一个字符串，按照上述规则字符串进行解密。*/
public class PasswordManager {
    // 加密方法
    public static String encrypt(String password) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            int ascii = (int) c;
            int offset = i + 1;//从1开始
            sb.append((char) (ascii + offset + 3));//偏移3
        }
        String encrypted = sb.toString();
        encrypted = swapFirstAndLastChar(encrypted);
        encrypted = reverseString(encrypted);
        return encrypted;
    }

    // 解密方法
    public static String decrypt(String encrypted) {
        String decrypted = reverseString(encrypted);
        decrypted = swapFirstAndLastChar(decrypted);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < decrypted.length(); i++) {
            char c = decrypted.charAt(i);
            int ascii = (int) c;
            int offset = i + 1;
            sb.append((char) (ascii - offset - 3));
        }
        return sb.toString();
    }

    // 将字符串的第一位和最后一位调换顺序
    private static String swapFirstAndLastChar(String str) {
        if (str.length() <= 1) {
            return str;
        }
        char first = str.charAt(0);
        char last = str.charAt(str.length() - 1);
        String middle = str.substring(1, str.length() - 1);
        return last + middle + first;
    }

    // 将字符串反转
    private static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}
