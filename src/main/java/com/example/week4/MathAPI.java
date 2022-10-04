package com.example.week4;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.MultiValueMap;
import java.util.*;

public class MathAPI {
    @RequestMapping(value = "/plus/{n1}/{n2}", method = RequestMethod.GET)
    public double myPlus(@PathVariable("n1") double num1, @PathVariable("n2") double num2){
        return (num1 + num2);
    }

    @RequestMapping(value = "/minus/{n1}/{n2}", method = RequestMethod.GET)
    public double myMinus(@PathVariable("n1") double num1, @PathVariable("n2") double num2){
        return (num1 - num2);
    }

    @RequestMapping(value = "/divide/{n1}/{n2}", method = RequestMethod.GET)
    public double myDivide(@PathVariable("n1") double num1, @PathVariable("n1") double num2){
        return (num1 / num2);
    }

    @RequestMapping(value = "/multi/{n1}/{n2}", method = RequestMethod.GET)
    public double myMultiply(@PathVariable("n1") double num1, @PathVariable("n2") double num2){
        return (num1 * num2);
    }

    @RequestMapping(value = "/mod/{n1}/{n2}", method = RequestMethod.GET)
    public double myMod(@PathVariable("n1") double num1, @PathVariable("n2") double num2){
        return (num1 % num2);
    }

    @RequestMapping(value = "/max", method = RequestMethod.POST)
    public double myMax(@RequestBody MultiValueMap<String, String> ans){
        Map<String, String> value = ans.toSingleValueMap();
        return Math.max(Double.parseDouble(value.get("num1")) , Double.parseDouble(value.get("num2")));
    }


}
