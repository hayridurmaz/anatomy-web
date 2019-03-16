package tr.edu.tedu.anatomyweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Model.MEDIA;
import tr.edu.tedu.anatomyweb.Model.SYSTEM;
import tr.edu.tedu.anatomyweb.Model.TOPIC;
import tr.edu.tedu.anatomyweb.Service.IMediaService;
import tr.edu.tedu.anatomyweb.Service.ISystemService;
import tr.edu.tedu.anatomyweb.Service.ITopicService;
import tr.edu.tedu.anatomyweb.Utils.MediaType;

import javax.validation.Valid;
import java.util.*;

@CrossOrigin
@RestController
public class MediaController {

    @Autowired
    ISystemService systemService;
    @Autowired
    ITopicService topicService;
    @Autowired
    IMediaService mediaService;

    @GetMapping(("/Media"))
    List<MEDIA> getMedia() {
        List<MEDIA> medias = new ArrayList<>();
        mediaService.findAll().forEach(media -> {
            // System.out.println(Media.getSystem().toString());
            medias.add(media);
        });
        return medias;
    }

    @GetMapping(("/Media/{MediaId}"))
    MEDIA getMediaById(@PathVariable Long MediaId) {
        MEDIA img = mediaService.findById(MediaId);
        return img;
    }

    @PostMapping("/Media")
    public MEDIA createMedia(@Valid @RequestBody String reqBody) {

        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        SYSTEM s = systemService.findById(Long.parseLong(parser.get("system_id").toString()));
        //TOPIC t = topicService.findById(Long.parseLong(parser.get("topic_id").toString()));
        MediaType media_type = MediaType.values()[Integer.parseInt(parser.get("media_type").toString())];

        MEDIA i = new MEDIA();
        //i.setTopic(t);

        List<TOPIC> topics = new ArrayList<>();
        List<Object> topic_ids = factory.parseList(parser.get("topic_ids").toString());
        for (Object o :
                topic_ids) {
            System.out.println(o);
            TOPIC t = topicService.findById(Long.parseLong(o.toString()));
            topics.add(t);
        }

        i.setTopics(topics);
        i.setSystem(s);
        i.setMediaType(media_type);
        i.setData_url(parser.get("data_url").toString());
        i.setThumbnail_url(parser.get("thumbnail_url").toString());
        i.setDate(parser.get("date").toString());
        return mediaService.save(i);
    }

    @PutMapping("/Media/{MediaId}")
    public MEDIA updateMedia(@PathVariable Long MediaId, @Valid @RequestBody String reqBody) {
        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);


        MEDIA i = mediaService.findById(MediaId);
        if (parser.get("system_id") != null) {
            SYSTEM s = systemService.findById(Long.parseLong(parser.get("system_id").toString()));
            i.setSystem(s);
        }

        if (parser.get("topic_ids") != null) {
            List<TOPIC> topics = new ArrayList<>();
            List<Object> topic_ids = factory.parseList(parser.get("topic_ids").toString());
            for (Object o :
                    topic_ids) {
                System.out.println(o);
                TOPIC t = topicService.findById(Long.parseLong(o.toString()));
                topics.add(t);
            }

            i.setTopics(topics);

        }

        if (parser.get("data_url") != null) {
            String data_url = parser.get("data_url").toString();
            i.setData_url(data_url);
        }

        if (parser.get("thumbnail_url") != null) {
            String data_url = parser.get("thumbnail_url").toString();
            i.setThumbnail_url(data_url);
        }


        if (parser.get("media_type") != null) {
            String media_type = parser.get("media_type").toString();
            i.setMediaType(MediaType.valueOf(media_type));
        }


        //return i;
        return mediaService.save(i);
    }

    @DeleteMapping("/Media/{MediaId}")
    public @ResponseBody
    String deleteMedia(@PathVariable Long MediaId) {
        return mediaService.delete(MediaId);
    }

}
