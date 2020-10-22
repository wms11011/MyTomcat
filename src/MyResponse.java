import java.io.IOException;
import java.io.OutputStream;

/**
 * @author 王旻爽
 * 2020/10/22
 * @ClassName MyResponse.java
 */
public class MyResponse {
    private OutputStream outputStream;

    public MyResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String str) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK\n")
                .append("Content-Type:text/html\n")
                .append("\r\n")
                .append("<html>")
                .append("<body>").append("<h1>").append(str).append("</h1>")
                .append("</body>")
          .append("</html>");
        outputStream.write(sb.toString().getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
