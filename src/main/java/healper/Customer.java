package healper;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {

    @Builder.Default
    private String firstName = String.valueOf(System.currentTimeMillis());
    @Builder.Default
    private String lastName = String.valueOf(System.currentTimeMillis());
    @Builder.Default
    private String postCode = String.valueOf(System.currentTimeMillis());

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
