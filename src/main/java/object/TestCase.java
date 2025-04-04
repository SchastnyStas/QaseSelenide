package object;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class TestCase {
    private String titleName;
    private String status;
    private String severity;
    private String priority;
    private String type;
    private String layer;
    private String isFlaky;
    private String behavior;
    private String automationStatus;
}
