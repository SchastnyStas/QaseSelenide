package object;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class Suite {
    private String suiteName;
    private String description;
    private String preconditions;
}
