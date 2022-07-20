package base64ToImage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class ConvertBase64StringToImage {

    public static void main(String[] args) throws IOException {

        File imageFile = new File("resources/decodedImage.png");
        String encodedString = encodeFileToBase64Binary(imageFile);
        decodeBase64StringToImage(encodedString);
        System.out.println("Check the file in resource folder");
    }

    private static String encodeFileToBase64Binary(File file) throws IOException{
        FileInputStream fileInputStreamReader = new FileInputStream(file);
        byte[] bytes = new byte[(int)file.length()];
        fileInputStreamReader.read(bytes);
        return new String(Base64.getEncoder().encode(bytes), "UTF-8");
    }

    private static void decodeBase64StringToImage(String encodedString) throws IOException {
        byte[] decodeByte = Base64.getDecoder().decode(encodedString);
        Files.write(Paths.get("resources/decodeDone.png"),decodeByte);
    }
}
