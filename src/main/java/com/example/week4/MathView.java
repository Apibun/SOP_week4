package com.example.week4;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.*;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import java.awt.*;

@Route(value = "index1")
public class MathView extends VerticalLayout {
    //    private TextField num1, num2, ans;
//    private Button btnPlus, btnMinus, btnMul, btnDiv, btnMod, btnMax;
    public MathView(){
        TextField num1 = new TextField("Number 1");
        TextField num2 = new TextField("Number 2");
        TextField ans = new TextField("Answer");
        Button btnPlus = new Button("+");
        Button btnMinus = new Button("-");
        Button btnMul = new Button("*");
        Button btnDiv = new Button("/");
        Button btnMod = new Button("Mod");
        Button btnMax = new Button("Max");
        HorizontalLayout h1 = new HorizontalLayout();
        h1.add(btnPlus, btnMinus, btnMul, btnDiv, btnMod, btnMax);
        this.add(num1, num2, h1, ans);

        btnPlus.addClickListener(event ->{
            double value1 = Double.parseDouble(num1.getValue());
            double value2 = Double.parseDouble(num2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/plus/"+value1+"/"+value2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);
        });

        btnMinus.addClickListener(event ->{
            double value1 = Double.parseDouble(num1.getValue());
            double value2 = Double.parseDouble(num2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/minus/"+value1+"/"+value2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);
        });

        btnDiv.addClickListener(event ->{
            double value1 = Double.parseDouble(num1.getValue());
            double value2 = Double.parseDouble(num2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/divide/"+value1+"/"+value2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);
        });

        btnMul.addClickListener(event ->{
            double value1 = Double.parseDouble(num1.getValue());
            double value2 = Double.parseDouble(num2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/multi/"+value1+"/"+value2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);
        });

        btnMod.addClickListener(event ->{
            double value1 = Double.parseDouble(num1.getValue());
            double value2 = Double.parseDouble(num2.getValue());
            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/mod/"+value1+"/"+value2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);
        });

        btnMax.addClickListener(event ->{
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("num1", num1.getValue());
            formData.add("num2", num2.getValue());
            String out = WebClient.create()
                    .post()
                    .uri("http://localhost:8080/max")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            ans.setValue(out);
        });
    }
}
