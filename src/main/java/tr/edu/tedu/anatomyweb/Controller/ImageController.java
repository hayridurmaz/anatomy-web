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
import tr.edu.tedu.anatomyweb.Service.IQuiztypeService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class ImageController {

    @Autowired
    SystemRepository systemRepository;
    @Autowired
    SystemRepository topicRepository;
    @Autowired
    ImageRepository imageRepository;

    @GetMapping(("/images"))
    List<IMAGE> getImages() {
        List<IMAGE> img= new ArrayList<>();
        imageRepository.findAll().forEach(image -> {
            System.out.println(image.getSystem().toString());
            img.add(image);
        });
        return img;
    }

    @PostMapping("/images")
    public void createImage(@Valid @RequestBody Object reqBody) {



        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody.toString());

        /*SYSTEM s = systemRepository.findById(parser.system_id);
        TOPIC t =topicRepository.findById(parser.topic_id);*/

        System.out.println(parser.toString());
        //return imageRepository.save(image);
    }

    @PutMapping("/images/{imageId}")
    public IMAGE updateImage(@PathVariable Long imageId, @Valid @RequestBody IMAGE imageRequest) {
        IMAGE i = imageRepository.findById(imageId).orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id " + imageId));
        i.setData_url(imageRequest.getData_url());
        i.setSystem(imageRequest.getSystem());
        i.setTopic(imageRequest.getTopic());
        return imageRepository.save(i);
    }

   /* @DeleteMapping("/images/{quiztypeId}")
    public @ResponseBody
    ResponseEntity<?> deleteQuiztype(@PathVariable Long quiztypeId) {
        quiztypeService.delete(quiztypeId);
        return ResponseEntity.ok().build();
    }
*/

}
