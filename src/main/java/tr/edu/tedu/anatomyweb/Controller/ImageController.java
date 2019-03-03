package tr.edu.tedu.anatomyweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Model.IMAGE;
import tr.edu.tedu.anatomyweb.Model.SYSTEM;
import tr.edu.tedu.anatomyweb.Model.TOPIC;
import tr.edu.tedu.anatomyweb.Service.IImageService;
import tr.edu.tedu.anatomyweb.Service.ISystemService;
import tr.edu.tedu.anatomyweb.Service.ITopicService;

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
        if (parser.get("system_id") != null) {
            SYSTEM s = systemService.findById(Long.parseLong(parser.get("system_id").toString()));
            i.setSystem(s);
        }

        if (parser.get("topic_id") != null) {
            TOPIC t = topicService.findById(Long.parseLong(parser.get("topic_id").toString()));
            i.setTopic(t);

        }

        if (parser.get("data_url") != null) {
            String data_url = parser.get("data_url").toString();
            i.setData_url(data_url);
        }

        return imageService.save(i);
    }

    @DeleteMapping("/Images/{imageId}")
    public @ResponseBody
    String deleteImage(@PathVariable Long imageId) {
        return imageService.delete(imageId);
    }

}
