import java.io.IOException;
import java.io.InputStream;

/**
 * @author 王旻爽
 * 2020/10/22
 * @ClassName MyRequest.java
 */
public class MyRequest {

    private String requestMethod;

    private String requestUrl;

    public MyRequest(InputStream inputStream) throws IOException {
        // 缓冲区
        byte[] bytes = new byte[1024*1024];
        // 读取数据的长度
        int len = 0;
        // 定义请求的变量
        String str = null;

        if((len = inputStream.read(bytes))>0){
            str = new String(bytes,0,len);
        }

        assert str != null;
        String data = str.split("\n")[0];
        String[] params = data.split(" ");
        requestMethod = params[0];
        requestUrl = params[1];
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
