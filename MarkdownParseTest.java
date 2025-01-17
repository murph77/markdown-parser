import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLink()throws IOException{
        Path testFile = Path.of("test1.md");
        String result = Files.readString(testFile);
        ArrayList<String> links = MarkdownParse.getLinks(result);
        List<String> output = List.of("https://something.com", "some-page.html");
        assertEquals(output,links);
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        System.out.println(links); 
    }
    
}
