package com.example.gracegh.studentproject.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable//enables you to embed the guardian class into the student class...
@Data//for creating getters and setters...
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name="guardianName",
                column =   @Column(name="guardian_name")
        ),
        @AttributeOverride(
                name="guardianEmail",
                column =   @Column(name="guardian_email_address")
        ),
        @AttributeOverride(
                name="guardianMobile",
                column =   @Column(name="guardian_mobile_number")
        )
})
public class Guardian {

    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;
}
