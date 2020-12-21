package pl.bartekficek.ocrsystem;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import net.sourceforge.tess4j.*;
import javax.imageio.ImageIO;

public class TesseractExample {

    public static void main(String[] args) throws IOException {
        URL imageFile = new URL("https://www.deco-strefa.com.pl/galerie/c/cytat-gdziekolwiek-sie-z_8617.jpg");
        BufferedImage bufferedImage = ImageIO.read(imageFile);

        /**
         * JNA Interface Mapping
         **/
        ITesseract instance = new Tesseract();

        /**
         * You either set your own tessdata folder with your custom language pack or
         * use LoadLibs to load the default tessdata folder for you.
         **/
        instance.setDatapath("/home/bartek/Desktop/LearningJava/Bykowski/OCR example (Spring Boot & Tess4J,Swagger2,Flyway,Lombok)");
        instance.setLanguage("pol");

        try {
            String result = instance.doOCR(bufferedImage);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}