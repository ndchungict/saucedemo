package chungnd.demo.steps;

import com.github.invictum.reportportal.LogsPreset;
import com.github.invictum.reportportal.ReportIntegrationConfig;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Hooks {
    @Before
    public void setStage() {
        ReportIntegrationConfig configuration = ReportIntegrationConfig.get();
        configuration.usePreset(LogsPreset.FULL);
        OnStage.setTheStage(new OnlineCast());
    }
}
