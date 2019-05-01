package tr.edu.tedu.anatomyweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Model.*;
import tr.edu.tedu.anatomyweb.Service.IStaticResourceTypesService;
import tr.edu.tedu.anatomyweb.Service.IStaticResourcesService;
import tr.edu.tedu.anatomyweb.Service.ISystemService;
import tr.edu.tedu.anatomyweb.Utils.MediaType;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class StaticResourcesController {

    @Autowired
    IStaticResourcesService staticResourceservice;
    @Autowired
    ISystemService systemService;
    @Autowired
    IStaticResourceTypesService resourceTypesService;

    @GetMapping(("/StaticResources"))
    List<STATICRESOURCES> getStaticResources() {
        List<STATICRESOURCES> resources = staticResourceservice.findAll();
        return resources;
    }

    @GetMapping("/StaticResources/{StaticResourcesID}")
    STATICRESOURCES getStaticResourcesByID(@PathVariable Long StaticResourcesID) {
        STATICRESOURCES s = staticResourceservice.findById(StaticResourcesID);
        return s;
    }

    @PostMapping("/StaticResources")
    public STATICRESOURCES createStaticResource(@Valid @RequestBody String reqBody) {
        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        SYSTEM s = systemService.findById(Long.parseLong(parser.get("system_id").toString()));
        STATICRESOURCETYPES resource_type = resourceTypesService.findById(Long.parseLong(parser.get("resource_type").toString()));

        STATICRESOURCES rsc = new STATICRESOURCES();
        //i.setTopic(t);

        rsc.setSystem(s);
        rsc.setResource_type(resource_type);
        rsc.setButton_image_url(parser.get("button_image_url").toString());
        rsc.setResource_name(parser.get("resource_name").toString());
        rsc.setButton_image(parser.get("button_image").toString());
        rsc.setTarget_page(parser.get("target_page").toString());
        return staticResourceservice.save(rsc);
    }

    @PutMapping("/StaticResources/{StaticResourcesID}")
    public STATICRESOURCES updateStaticResource(@PathVariable Long StaticResourcesID, @Valid @RequestBody String reqBody) {
        JsonParser factory = JsonParserFactory.getJsonParser();
        Map parser = factory.parseMap(reqBody);

        STATICRESOURCES rsc = staticResourceservice.findById(StaticResourcesID);
        if (parser.get("system_id") != null) {
            SYSTEM s = systemService.findById(Long.parseLong(parser.get("system_id").toString()));
            rsc.setSystem(s);
        }

        if (parser.get("resource_type") != null) {
            STATICRESOURCETYPES t = resourceTypesService.findById(Long.parseLong(parser.get("resource_type").toString()));
            rsc.setResource_type(t);

        }

        if (parser.get("button_image_url") != null) {
            rsc.setButton_image_url(parser.get("button_image_url").toString());
        }

        if (parser.get("resource_name") != null) {
            String resource_name = parser.get("resource_name").toString();
            rsc.setResource_name(resource_name);
        }

        if (parser.get("button_image") != null) {
            String button_image = parser.get("button_image").toString();
            rsc.setButton_image(button_image);
        }


        if (parser.get("target_page") != null) {
            String target_page = parser.get("target_page").toString();
            rsc.setTarget_page(target_page);
        }


        //return i;
        return staticResourceservice.save(rsc);
    }

    @DeleteMapping("/StaticResources/{StaticResourcesID}")
    public String deleteStaticResource(@PathVariable Long StaticResourcesID) {
        return staticResourceservice.delete(StaticResourcesID);

    }


}
