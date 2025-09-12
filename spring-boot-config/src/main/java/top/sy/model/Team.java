package top.sy.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Component
public class Team {
    @Value("${team.name}")
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 3,max = 20)
    private String name;

    @Value("${team.leader}")
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 3,max = 8)
    private String leader;

    @Value("${team.phone}")
    private String phone;

    @Value("${team.age}")
    @Min(1)
    @Max(4)
    private Integer age;


    private LocalDate createTime;
}
