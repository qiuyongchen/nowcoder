/**
 * Created by DELL on 2016-06-22.
 */
public class ReplaceString {
    public String replaceSpace(StringBuffer str) {
        StringBuilder builder = new StringBuilder();

        String s = str.toString();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') builder.append("%20");
            else builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}
