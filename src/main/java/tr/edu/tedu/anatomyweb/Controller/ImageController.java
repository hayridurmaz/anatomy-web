package tr.edu.tedu.anatomyweb.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Exception.ResourceNotFoundException;
import tr.edu.tedu.anatomyweb.Model.IMAGE;
import tr.edu.tedu.anatomyweb.Model.QUIZ;
import tr.edu.tedu.anatomyweb.Model.QUIZTYPE;
import tr.edu.tedu.anatomyweb.Repository.ImageRepository;
import tr.edu.tedu.anatomyweb.Service.IQuiztypeService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class ImageController {


    @Autowired
    ImageRepository imageRepository;

    @GetMapping(("/images"))
    List<IMAGE> getImages() {
        List<IMAGE> img= new ArrayList<>();
        imageRepository.findAll().forEach(image -> {
            img.add(image);
        });
        return img;
    }

    @PostMapping("/images")
    public IMAGE createImage(@Valid @RequestBody IMAGE image) {
        return imageRepository.save(image);
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
