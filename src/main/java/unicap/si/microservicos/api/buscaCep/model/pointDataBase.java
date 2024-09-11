package unicap.si.microservicos.api.buscaCep.model;

import lombok.Data;

@Data
public class pointDataBase {

    private String cep;
    private String regiao;
    private int quantidade;
}
