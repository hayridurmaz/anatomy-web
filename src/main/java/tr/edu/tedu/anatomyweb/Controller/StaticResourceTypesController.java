package tr.edu.tedu.anatomyweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.edu.tedu.anatomyweb.Model.QUIZTYPE;
import tr.edu.tedu.anatomyweb.Model.STATICRESOURCETYPES;
import tr.edu.tedu.anatomyweb.Model.SYSTEM;
import tr.edu.tedu.anatomyweb.Service.IStaticResourceTypesService;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin
@RestController
public class StaticResourceTypesController {

    @Autowired
    IStaticResourceTypesService service;

    @GetMapping(("/StaticResourceTypes"))
    List<STATICRESOURCETYPES> getStaticResourceTypes() {
        List<STATICRESOURCETYPES> resourcetypes = service.findAll();
        return resourcetypes;
    }

    @GetMapping("/StaticResourceTypes/{StaticResourceTypesID}")
    STATICRESOURCETYPES getStaticResourceTypesByID(@PathVariable Long StaticResourceTypesID) {
        STATICRESOURCETYPES s = service.findById(StaticResourceTypesID);
        return s;
    }

    @PostMapping("/StaticResourceTypes")
    public STATICRESOURCETYPES createStaticResourceType(@Valid @RequestBody STATICRESOURCETYPES type) {
        return service.save(type);
    }

    @PutMapping("/StaticResourceTypes/{StaticResourceTypesID}")
    public STATICRESOURCETYPES updateStaticResourceType(@PathVariable Long StaticResourceTypesID, @Valid @RequestBody STATICRESOURCETYPES type) {
        STATICRESOURCETYPES s = service.findById(StaticResourceTypesID);
        s.setType(type.getType());
        return service.save(s);
    }

    @DeleteMapping("/StaticResourceTypes/{StaticResourceTypesID}")
    public String deleteStaticResourceType(@PathVariable Long StaticResourceTypesID) {
        return service.delete(StaticResourceTypesID);

    }

}
