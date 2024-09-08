package unicap.si.microservicos.api.buscaCep.model;

import lombok.Data;

@Data
public class pointData {

    private String cep;
    private String logadouro;
    private String bairro;
    private String localidade;
    private String uf;

}
