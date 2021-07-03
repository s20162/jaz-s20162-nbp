package com.LichySoft.jazs20162nbp.Service;


import com.LichySoft.jazs20162nbp.Model.NBP;
import com.LichySoft.jazs20162nbp.Model.Rate;
import com.LichySoft.jazs20162nbp.Model.Root;
import com.LichySoft.jazs20162nbp.Repository.NBPRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NBPService {

    private final NBPRepository nbpRepository;
    private final RestTemplate restTemplate;

    public NBPService(NBPRepository nbpRepository, RestTemplate restTemplate) {
        this.nbpRepository = nbpRepository;
        this.restTemplate = restTemplate;
    }


    public Double getCur(String cur, String start, String end){
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/" + cur +"/" + start + "/" + end +"/";
        Root root = restTemplate.getForObject(url, Root.class);

        return root.getRates()
                .stream()
                .mapToDouble(Rate::getMid)
                .average().orElse(0.0);
    }

    public NBP save(NBP nbp){
        return nbpRepository.save(nbp);
    }

}
