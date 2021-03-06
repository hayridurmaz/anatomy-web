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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @GetMapping(("/Media/SystemId/{SystemId}"))
    List<MEDIA> getMediaBySystemId(@PathVariable Long SystemId) {
        List<MEDIA> medias = mediaService.findBySystemId(SystemId);
        return medias;
    }

    @GetMapping(("/Media/TopicId/{TopicId}"))
    List<MEDIA> getMediaByTopicId(@PathVariable Long TopicId) {
        List<MEDIA> medias = mediaService.findAllByTopics(topicService.findById(TopicId));
        return medias;
    }

    @GetMapping(("/Media/GetBySystemAndMediaType"))
    public List<MEDIA> findBySystemAndAndMediaType(@RequestParam(name="system_id") String system_id, @RequestParam(name="mediatype_id") String mediaType){
        SYSTEM system = systemService.findById(Long.valueOf(system_id));
        MediaType media_type = MediaType.values()[Integer.parseInt(mediaType)];
        return mediaService.findBySystemIdAndMediaType(Long.valueOf(system_id), media_type);
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
        i.setMedia_type(media_type);
        i.setData_url(parser.get("data_url").toString());
        i.setThumbnail_url(parser.get("thumbnail_url").toString());
        i.setDescription(parser.get("description").toString());
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

        if (parser.get("description") != null) {
            i.setDescription(parser.get("description").toString());
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
            i.setMedia_type(MediaType.valueOf(media_type));
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
