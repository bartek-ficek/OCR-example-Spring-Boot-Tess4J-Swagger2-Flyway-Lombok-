package pl.bartekficek.ocrsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OCRServiceApi {

    private OCRService ocrService;

    @Autowired
    public OCRServiceApi(OCRService ocrService) {
        this.ocrService = ocrService;
    }

    @PostMapping("/api/ocr")
    public String doOCR(@RequestBody Graphic graphic) {
        return ocrService.doOCR(graphic.getUrl());
    }
}
