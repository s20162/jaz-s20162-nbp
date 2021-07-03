package com.LichySoft.jazs20162nbp.Controller;


import com.LichySoft.jazs20162nbp.Model.NBP;
import com.LichySoft.jazs20162nbp.Service.NBPService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/nbp")
public class NBPController {

    private final NBPService nbpService;

    public NBPController(NBPService nbpService) {
        this.nbpService = nbpService;
    }


    @GetMapping("/{cur}")
    public ResponseEntity<Double> getCur(@PathVariable String cur, @RequestParam("start") String start,
                                         @RequestParam("end") String end) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startt = LocalDate.parse(start, dtf);
        LocalDate endd = LocalDate.parse(end, dtf);
        Date requestDateTime = Calendar.getInstance().getTime();
        Double avg = nbpService.getCur(cur, start, end);
        NBP log = new NBP(cur, startt, endd, avg, requestDateTime);
        nbpService.save(log);

        return ResponseEntity.ok(avg);
    }

}
