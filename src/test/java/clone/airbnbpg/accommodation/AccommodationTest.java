package clone.airbnbpg.accommodation;

import clone.airbnbpg.common.BaseTest;
import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.generator.BuilderArbitraryGenerator;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class AccommodationTest extends BaseTest {

    @RepeatedTest(100)
    void 정상적으로_인스턴스를_생성한다() {
        Accommodation accommodation = createInstance(Accommodation.class);

        assertThat(accommodation).isNotNull();
        assertThat(accommodation.getName()).isNotBlank();
        assertThat(accommodation.getDescription()).isNotNull();
        assertThat(accommodation.getAddress()).isNotNull();
        assertThat(accommodation.getLatitude()).isNotBlank();
        assertThat(accommodation.getLongitude()).isNotBlank();
        assertThat(accommodation.getBasicPrice()).isGreaterThanOrEqualTo(1_000);
        assertThat(accommodation.getPersonCount()).isGreaterThanOrEqualTo(1);
    }
}