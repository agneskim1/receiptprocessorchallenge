package com.fetch.receiptchallenge;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/receipts")
public class Controller {
    private Map<String, Receipt> newReceiptEntry = new HashMap<>();

    @PostMapping("/process")
    public Map<String,String> getReceiptID(@RequestBody Receipt receipt){
        UUID uuid = UUID.randomUUID();
    
        String id = uuid.toString();
        newReceiptEntry.put(id, receipt);

        Map<String,String> receiptIdResponse = new HashMap<>();
        receiptIdResponse.put("id", id);
        return receiptIdResponse;
    }
}
