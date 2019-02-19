package tr.edu.tedu.anatomyweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Model.*;
import tr.edu.tedu.anatomyweb.Service.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class ImageController {

    @Autowired
    ISystemService systemService;
    @Autowired
    ITopicService topicService;
    @Autowired
    IImageService imageService;

    @GetMapping(("/Images"))
    List<IMAGE> getImages() {
        List<IMAGE> img = new ArrayList<>();
        imageService.findAll().forEach(image -> {
            // System.out.println(image.getSystem().toString());
            img.add(image);
        });
        return img;
    }

    @GetMapping(("/Images/{ImageId}"))
    IMAGE getImageById(@PathVariable Long ImageId) {
        IMAGE img = imageService.findById(ImageId);
        return img;
    }

    @PostMapping("/Images")
    public IMAGE createImage(@Valid @RequestBody String reqBody) {

        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        SYSTEM s = systemService.findById(Long.parseLong(parser.get("system_id").toString()));
        TOPIC t = topicService.findById(Long.parseLong(parser.get("topic_id").toString()));

        IMAGE i = new IMAGE();
        i.setTopic(t);
        i.setSystem(s);
        i.setData_url(parser.get("data_url").toString());
        return imageService.save(i);
    }

    @PutMapping("/Images/{imageId}")
    public IMAGE updateImage(@PathVariable Long imageId, @Valid @RequestBody String reqBody) {
        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        IMAGE i = imageService.findById(imageId);
        SYSTEM s;
        TOPIC t;
        String data_url;
        if (parser.get("system_id") != null) {
            s = systemService.findById(Long.parseLong(parser.get("system_id").toString()));
        } else {
            s = i.getSystem();
        }

        if (parser.get("topic_id") != null) {
            t = topicService.findById(Long.parseLong(parser.get("topic_id").toString()));
        } else {
            t = i.getTopic();
        }

        if (parser.get("data_url") != null) {
            data_url = parser.get("data_url").toString();
        } else {
            data_url = i.getData_url();
        }

        i.setTopic(t);
        i.setSystem(s);
        i.setData_url(data_url);
        return imageService.save(i);
    }

    @DeleteMapping("/Images/{imageId}")
    public @ResponseBody ResponseEntity<?> deleteImage(@PathVariable Long imageId) {
        imageService.delete(imageId);
        return ResponseEntity.ok().build();
    }

}
