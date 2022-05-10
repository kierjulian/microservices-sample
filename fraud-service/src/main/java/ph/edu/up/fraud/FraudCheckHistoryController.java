package ph.edu.up.fraud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/fraud-check")
public class FraudCheckHistoryController {

    private final FraudCheckHistoryService fraudCheckHistoryService;

    @Autowired
    public FraudCheckHistoryController(FraudCheckHistoryService fraudCheckHistoryService) {
        this.fraudCheckHistoryService = fraudCheckHistoryService;
    }

    @GetMapping(path = "{customerId}")
    public Boolean isFraudster(
            @PathVariable("customerId") Long customerId) {
        return this.fraudCheckHistoryService.isFraudulent(customerId);
    }

}
