package example.functionality;

public class ParsingJSON {
    public static void main(String[] args) {
        String s = "{'lastName':'blabla','salary':123,'friends':[\"fr1\",\"fr2\"]}";
        s = s.substring(1, s.length() - 1);
        String[] pair = s.split(",");
        // 'lastName:'blabla'
        String key = pair[1].split(":")[0].replace("'", "");
        String value = pair[1].split(":")[1].replace("'", "");
        System.out.println(key);
        System.out.println(value);
    }
}
