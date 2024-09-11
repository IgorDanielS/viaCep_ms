package unicap.si.microservicos.api.buscaCep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicap.si.microservicos.api.buscaCep.exception.CepNotFoundException;
import unicap.si.microservicos.api.buscaCep.model.PointData;
import unicap.si.microservicos.api.buscaCep.repository.PointDataRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PointDataService {

    @Autowired
    private PointDataRepository pointDataRepository;


    public void insertPointData(PointData pointData)
    {
        pointDataRepository.save(pointData);
    }

    public void deletePointDataByCep(String cep) throws Exception
    {
        Optional<PointData> optionalPointData = pointDataRepository.findByCep(cep);

        if(optionalPointData.isPresent())
        {
            pointDataRepository.delete(optionalPointData.get());
        }else
        {
            throw new Exception();
        }
    }

    public List<PointData> getAllPointData()
    {
        return pointDataRepository.findAll();
    }

    public PointData getPointData(String cep)
    {
        Optional<PointData> optionalPointData = pointDataRepository.findByCep(cep);

        return optionalPointData.orElse(null);
    }

    public boolean updatePointDataLogradouro(String cep, String logradouro) throws CepNotFoundException
    {
        Optional<PointData> optionalPointData = pointDataRepository.findByCep(cep);

        if(optionalPointData.isPresent())
        {
            PointData pointData = optionalPointData.get();
            pointData.setLogadouro(logradouro);
            pointDataRepository.save(pointData);
            return true;
        }
        throw new CepNotFoundException("CEP not found");
    }


}
