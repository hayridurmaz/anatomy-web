package tr.edu.tedu.anatomyweb.Controller;


import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.*;
import tr.edu.tedu.anatomyweb.Repository.ImageRepository;
import tr.edu.tedu.anatomyweb.Repository.SystemRepository;
import tr.edu.tedu.anatomyweb.Repository.TopicRepository;
import tr.edu.tedu.anatomyweb.Service.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class ImageController {

    @Autowired
    SystemService systemService;
    @Autowired
    TopicService topicService;
    @Autowired
    IImageService imageService;

    @GetMapping(("/images"))
    List<IMAGE> getImages() {
        List<IMAGE> img= new ArrayList<>();
        imageService.findAll().forEach(image -> {
            System.out.println(image.getSystem().toString());
            img.add(image);
        });
        return img;
    }

    @PostMapping("/images")
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

    @PutMapping("/images/{imageId}")
    public IMAGE updateImage(@PathVariable Long imageId, @Valid @RequestBody String reqBody) {
        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        IMAGE i = imageService.findById(imageId);
        SYSTEM s;
        if(parser.get("system_id")!=null){
            s = systemService.findById(Long.parseLong(parser.get("system_id").toString()));
        }
        else{
            s=i.getSystem();
        }

        TOPIC t;
        if(parser.get("topic_id")!=null){
            t = topicService.findById(Long.parseLong(parser.get("topic_id").toString()));
        }
        else{
            t=i.getTopic();
        }

        i.setTopic(t);
        i.setSystem(s);
        i.setData_url(parser.get("data_url").toString());
        return imageService.save(i);
    }

   @DeleteMapping("/images/{imageId}")
    public @ResponseBody
    ResponseEntity<?> deleteImage(@PathVariable Long imageId) {
        imageService.delete(imageId);
        return ResponseEntity.ok().build();
    }


}
