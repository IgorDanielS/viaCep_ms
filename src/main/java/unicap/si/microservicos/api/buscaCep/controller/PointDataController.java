package unicap.si.microservicos.api.buscaCep.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import unicap.si.microservicos.api.buscaCep.model.PointData;

@RestController
@RequestMapping("/point")
public class PointDataController {


    @GetMapping("/{cep}")
    public PointData consultaCep(@PathVariable("cep") String cep)
    {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PointData> res = restTemplate.getForEntity("viacep.com.br/ws/"+cep+"/json/", PointData.class);
        return res.getBody();
    }
}
