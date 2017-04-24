package tdd.examples.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tdd.examples.calculator.domain.CalculatorHistory;
import tdd.examples.calculator.dto.CollectionResult;
import tdd.examples.calculator.service.CalculatorHistoryService;

import java.util.List;

/**
 * Created by urstory on 2017. 4. 24.
 */
@RestController
public class CalculatorHistoryController {
    @Autowired
    CalculatorHistoryService calculatorHistoryService;

    @GetMapping(path="/calculatorHistories")
    public CollectionResult<List<CalculatorHistory>> getCalculatorHistories(){

        return new CollectionResult<>(calculatorHistoryService.getCalculatorHistories());

    }

    @PostMapping(path="/calculatorHistories")
    public CalculatorHistory getCalculatorHistories(@RequestBody CalculatorHistory calculatorHistory){
        CalculatorHistory calculatorHistoryResult = calculatorHistoryService.create(calculatorHistory);
        return calculatorHistoryResult;

    }

    @DeleteMapping(path="/calculatorHistories/{id}")
    public int deleteCalculatorHistory(@PathVariable(name = "id")Long id) {
        int deleteCount = calculatorHistoryService.delete(id);
        return deleteCount;
    }
}