package pl.bartekficek.ocrsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OCRServiceApi {

    private OCRService ocrService;
    private GraphicRepo graphicRepo;

    @Autowired
    public OCRServiceApi(OCRService ocrService, GraphicRepo graphicRepo) {
        this.ocrService = ocrService;
        this.graphicRepo = graphicRepo;
    }

    @PostMapping("/api/ocr")
    public Graphic doOCR(@RequestBody Graphic graphic) {
        String ocrResult = ocrService.doOCR(graphic.getUrl());
        graphic.setContent(ocrResult);
        return graphicRepo.save(graphic);
    }

    @GetMapping("/api/ocr")
    public Iterable<Graphic> getGraphics() {
        return graphicRepo.findAll();
    }
}
