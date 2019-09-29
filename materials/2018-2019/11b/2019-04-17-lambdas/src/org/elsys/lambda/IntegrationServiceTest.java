package org.elsys.lambda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegrationServiceTest {

    @Test
    public void testIntegrateLn() {
        Assertions.assertEquals(Math.log(2),
                IntegrationService.integrateLn(2, 3, 1));
        Assertions.assertEquals(-Math.log(0.5) * 0.5,
                IntegrationService.integrateLn(0.5, 1, 1));
    }
}
