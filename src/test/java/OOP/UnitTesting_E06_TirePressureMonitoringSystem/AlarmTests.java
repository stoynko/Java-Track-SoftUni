package OOP.UnitTesting_E06_TirePressureMonitoringSystem;

import D_OOP.I_UnitTesting.E06_TirePressureMonitoringSystem.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.time.temporal.*;

import static org.mockito.Mockito.when;

public class AlarmTests {

    private static final double LOW_PRESSURE_VALUE = 16.0;
    private static final double NORMAL_PRESSURE_VALUE = 20.0;
    private static final double HIGH_PRESSURE_VALUE = 26.0;
    private Sensor sensor;
    private Alarm alarm;

    @BeforeEach
    public void init() {
        sensor = Mockito.mock(Sensor.class);
        alarm = new Alarm(sensor);
    }

    @Test
    public void AlarmShouldBeOnDueToLowPressure() {
        when(sensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE_VALUE);
        alarm.check();
        Assertions.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void AlarmShouldBeOnDueToHighPressure() {
        when(sensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE_VALUE);
        alarm.check();
        Assertions.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void AlarmShouldBeOff() {
        when(sensor.popNextPressurePsiValue()).thenReturn(NORMAL_PRESSURE_VALUE);
        alarm.check();
        Assertions.assertFalse(alarm.getAlarmOn());
    }
}
