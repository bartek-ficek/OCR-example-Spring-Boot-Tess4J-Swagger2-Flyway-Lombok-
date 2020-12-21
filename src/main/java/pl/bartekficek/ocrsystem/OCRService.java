package pl.bartekficek.ocrsystem;

import java.awt.image.BufferedImage;
import java.net.URL;
import net.sourceforge.tess4j.*;
import javax.imageio.ImageIO;

public class OCRService {

    public String doOCR(String url) {
        try {
            URL imageFile = new URL(url);
            BufferedImage bufferedImage = ImageIO.read(imageFile);
            ITesseract instance = new Tesseract();
            instance.setDatapath("/home/bartek/Desktop/LearningJava/Bykowski/OCR example (Spring Boot & Tess4J,Swagger2,Flyway,Lombok)");
            instance.setLanguage("pol");
            return instance.doOCR(bufferedImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

//URL of my test image: https://www.deco-strefa.com.pl/galerie/c/cytat-gdziekolwiek-sie-z_8617.jpg