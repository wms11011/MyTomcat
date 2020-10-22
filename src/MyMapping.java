import java.util.HashMap;

/**
 * @author 王旻爽
 * 2020/10/22
 * @ClassName MyMapping.java
 */
public class MyMapping {

    public static HashMap<String,String> mapping = new HashMap<>();

    static {
        mapping.put("/mytomcat","MyServlet");
    }

    public HashMap<String,String> getMapping(){
        return mapping;
    }

}
